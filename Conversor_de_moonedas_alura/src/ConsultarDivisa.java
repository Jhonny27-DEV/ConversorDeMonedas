import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

class ConsultarDivisa {
    private static final String API_KEY = "59ddd6f39a8323e01cf6b984"; // Coloca aquí tu API Key
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public String buscaConversion(String monedaBase, String monedaObjetivo, double cantidad) {
        try {
            // Construcción de la URL
            URI direccion = URI.create(BASE_URL + API_KEY + "/pair/" + monedaBase + "/" + monedaObjetivo);

            // Configuración de la solicitud HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            // Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el estado de la respuesta
            if (response.statusCode() != 200) {
                return "Error: Código de respuesta HTTP " + response.statusCode() + " - " + response.body();
            }

            // Análisis del JSON de respuesta en modo lenient
            JsonObject jsonObject;
            try {
                jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            } catch (JsonSyntaxException e) {
                return "Error: Formato JSON no válido en la respuesta de la API.";
            }

            // Comprobar si la respuesta tiene un error
            if (jsonObject.has("error")) {
                String errorMessage = jsonObject.get("error").getAsString();
                return "Error de la API: " + errorMessage;
            }

            // Comprobamos si la respuesta tiene la tasa de conversión
            if (!jsonObject.has("conversion_rate")) {
                return "Error: No se encontró la tasa de conversión.";
            }

            // Obtener la tasa de conversión y calcular el resultado
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
            double resultadoConversion = cantidad * conversionRate;

            // Formateo del resultado a estilo millar con 2 decimales
            DecimalFormat formatoMiles = new DecimalFormat("#,###.00");
            String resultadoFormateado = formatoMiles.format(resultadoConversion);

            return monedaBase + " " + cantidad + " equivale a: " + monedaObjetivo + " " + resultadoFormateado;

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error en la solicitud HTTP: " + e.getMessage());
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}



