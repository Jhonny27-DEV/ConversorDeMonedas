Conversor de Monedas

Descripción del Proyecto

Este proyecto es un conversor de monedas que permite convertir entre diferentes divisas. El programa permite seleccionar entre diversas opciones predefinidas de monedas y también ingresar valores personalizados para realizar conversiones entre cualquier par de divisas.

Este proyecto es un desafío de Alura, en el cual se aplican conocimientos de Java, manipulación de APIs, validación de entradas de usuario y formateo de resultados. El objetivo principal es crear una herramienta funcional que permita realizar consultas de conversión de divisas y muestre resultados precisos y legibles para el usuario final.

Características

- Conversión rápida y precisa entre monedas.
- Capacidad para elegir entre opciones predefinidas o personalizar las monedas base y objetivo.
- Validación de entradas para asegurar que los valores sean numéricos.
- Resultados formateados para mejorar la legibilidad, incluyendo separadores de miles y decimales.
- Integración con una API de tipo de cambio para obtener valores actualizados.

Instalación y Ejecución

1. Clonar este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu_usuario/conversor_monedas.git
   ```

2. Compilar el código:

   ```bash
   javac Principal.java Calculos.java ConsultaConversion.java
   ```

3. Ejecutar el programa:

   ```bash
   java Principal
   ```

Estructura del Código

El proyecto contiene los siguientes archivos principales:

- **Principal.java**: Controla la ejecución del programa y la interacción del usuario con el menú de opciones.
- **Calculos.java**: Gestiona las operaciones de entrada y la lógica de validación y procesamiento de los valores de divisas seleccionadas.
- **ConsultaConversion.java**: Se conecta a la API de conversión para obtener los valores actualizados de las tasas de cambio.

Metodología de Desarrollo

La metodología utilizada para desarrollar este proyecto se basa en **TDD (Test-Driven Development)**, garantizando que cada nueva funcionalidad fuera probada y validada en pequeñas unidades antes de avanzar a la siguiente fase. Los pasos seguidos fueron:

1. **Análisis de Requisitos**: Se identificaron los requerimientos funcionales de la herramienta, como el tipo de monedas soportadas y la precisión de los resultados.
2. **Diseño Modular**: Se organizó el programa en clases separadas (`Principal`, `Calculos`, `ConsultaConversion`) para facilitar la legibilidad y el mantenimiento del código.
3. **Desarrollo por Iteraciones**: A cada iteración se fueron agregando nuevas funcionalidades, como el formato de miles, validación de entradas y conexión a una API de tasa de cambio.
4. **Pruebas y Validación**: Se verificaron los resultados de la conversión y el manejo de entradas inválidas para asegurar la confiabilidad del programa.
5. **Documentación**: Se creó esta documentación para explicar la funcionalidad del programa y su estructura.

Ejemplo de Uso

```plaintext
<<<<<<<<<<<<<<<<<<<<<< Conversor de Monedas >>>>>>>>>>>>>>>>>>>>>
1) Peso Mexicano -> Dólar Estadounidense
2) Peso Mexicano -> Euro
3) Peso Mexicano -> Libra Esterlina
4) Dólar Estadounidense -> Peso Mexicano
5) Euro -> Peso Mexicano
6) Libra Esterlina -> Peso Mexicano
7) Otra opción de conversión
8) Salir
Seleccione una opción:
```

Ejemplo de Conversión Personalizada

Para usar opciones de conversión personalizadas, el usuario puede seleccionar la opción 7 e ingresar los códigos de las monedas deseadas (e.g., USD, EUR) junto con el valor a convertir.

Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal para el desarrollo del programa.
- **API de Conversión de Divisas**: Fuente externa para obtener datos de tasas de cambio actualizados.
- **JUnit (opcional)**: Utilizado para pruebas unitarias de los métodos de cálculo.

Créditos

Este proyecto fue desarrollado por JHonny Rosario, como parte de un **Challenge de Alura** en la ruta de aprendizaje de Java.

