import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculos {
    private String monedaBase;
    private String monedaObjetivo;
    private double cantidad;
    private final Scanner lectura = new Scanner(System.in);
    private final ConsultarDivisa conversion;

    /* Constructor que recibe una instancia de ConsultarDivisa, la cual se usará para realizar consultas de divisas. */
    public Calculos(ConsultarDivisa conversion) {
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public double getCantidad() {
        return cantidad;
    }

    // Método para almacenar valores predeterminados de moneda base y moneda objetivo
    public void almacenarValores(String monedaBase, String monedaObjetivo) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidad = solicitarCantidad();
    }

    // Método para ingresar monedas y valores personalizados
    public void almacenarValoresPersonalizados() {
        mostrarOpcionesMonedas();
        System.out.println("Ingrese la moneda base (código de 3 letras):");
        this.monedaBase = lectura.next().toUpperCase();
        System.out.println("Ingrese la moneda objetivo (código de 3 letras):");
        this.monedaObjetivo = lectura.next().toUpperCase();
        this.cantidad = solicitarCantidad();
    }

    // Método para obtener el mensaje de respuesta formateado
    public String obtenerMensajeRespuesta() {
        String resultadoConversion = conversion.buscaConversion(monedaBase, monedaObjetivo, cantidad);
        DecimalFormat formatoMiles = new DecimalFormat("#,###.00");
        String cantidadFormateada = formatoMiles.format(cantidad);
        String mensaje = monedaBase + " " + cantidadFormateada + " equivale a: " + monedaObjetivo + " " + resultadoConversion;
        System.out.println(mensaje);
        return mensaje;
    }

    // Método auxiliar para solicitar la cantidad a convertir
    private double solicitarCantidad() {
        double cantidadIngresada = 0;
        boolean entradaValida = false;
        do {
            System.out.println("Ingrese el valor a convertir:");
            if (lectura.hasNextDouble()) {
                cantidadIngresada = lectura.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Error. Ingrese un valor numérico válido.");
                lectura.next(); // Limpiar el buffer en caso de entrada no válida
            }
        } while (!entradaValida);
        return cantidadIngresada;
    }

    // Método auxiliar para mostrar el menú de monedas disponibles
    private void mostrarOpcionesMonedas() {
        String menuOtrasOpciones = """
                Currency Code       Currency Name       Country
                ------------------------------------------------
                USD United States Dollar          United States
                MXN Mexican Peso                  Mexico
                EUR Euro                          European Union
                GBP British Pound                 United Kingdom
                JPY Japanese Yen                  Japan
                CAD Canadian Dollar               Canada
                ... (otras monedas)
                """;
        System.out.println(menuOtrasOpciones);
    }
}

