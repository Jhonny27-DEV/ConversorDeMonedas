import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;

        // Instancias necesarias para el funcionamiento del programa
        ConsultarDivisa consulta = new ConsultarDivisa ();
        Calculos calculos = new Calculos(consulta);
        GenerarArchivo generador = new GenerarArchivo ();

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>
                *** Bienvenido al Conversor de Monedas ***                       |
                                                                                 |
                1) Peso Mexicano ==>> Dólar Estadounidense                       |
                2) Peso Mexicano ==>> Euro                                       |
                3) Peso Mexicano ==>> Libra Esterlina                            |
                4) Dólar Estadounidense ==>> Peso Mexicano                       |
                5) Euro ==>> Peso Mexicano                                       |
                6) Libra Esterlina ==>> Peso Mexicano                            |
                7) Dolar Estadounidense ==>> Peso Dominicano                     |
                8) Otra opción de conversión                                     |
                9) Salir                                                         |
                <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                """;

        while (opcionElegida != 9) {
            try {
                System.out.println(menu);
                System.out.print("Por favor, ingrese la opcion deseda, entre:(1-9): ");
                opcionElegida = Integer.parseInt(lectura.nextLine());

                // Validación del rango de opciones
                if (opcionElegida < 1 || opcionElegida > 9) {
                    System.out.println("Por favor, ingrese la opcion deseda, entre:(1-9): " );
                    continue;
                }

                // Marca de tiempo actual
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                // Procesamiento según la opción elegida
                switch (opcionElegida) {
                    case 1 -> almacenarYRegistrarConversion(calculos, respuestas, "MXN", "USD", formattedDate);
                    case 2 -> almacenarYRegistrarConversion(calculos, respuestas, "MXN", "EUR", formattedDate);
                    case 3 -> almacenarYRegistrarConversion(calculos, respuestas, "MXN", "GBP", formattedDate);
                    case 4 -> almacenarYRegistrarConversion(calculos, respuestas, "USD", "MXN", formattedDate);
                    case 5 -> almacenarYRegistrarConversion(calculos, respuestas, "EUR", "MXN", formattedDate);
                    case 6 -> almacenarYRegistrarConversion(calculos, respuestas, "GBP", "MXN", formattedDate);
                    case 7 -> almacenarYRegistrarConversion(calculos, respuestas, "USD", "DOP", formattedDate);
                    case 8 -> {
                        calculos.almacenarValoresPersonalizados();
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                    }
                    case 9 -> System.out.println("Finalizando programa...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }
        }

        // Guardar las respuestas en un archivo JSON
        generador.guardarJson(respuestas);

        // Cerrar el scanner
        lectura.close();
    }
    private static void almacenarYRegistrarConversion(Calculos calculos, List<String> respuestas,
                                                      String monedaOrigen,
                                                      String monedaDestino,
                                                      String formattedDate) {
        calculos.almacenarValores(monedaOrigen, monedaDestino);
        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
    }
}



