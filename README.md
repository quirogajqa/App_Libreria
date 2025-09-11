# 📱 Prototipo de App: Librería Virtual

Este proyecto es un prototipo de una aplicación móvil para Android que simula una librería virtual. Fue diseñado para demostrar una navegación fluida, la gestión de recursos de la interfaz de usuario (`UI`) y la interacción del usuario a través de un carrito de compras.

## ✨ Características de la Aplicación

La aplicación se compone de varias pantallas y elementos de navegación clave:

  - **Splash Activity**: La primera pantalla al iniciar la aplicación. Incluye una animación de carga de Lottie y el logo de la librería para mejorar la experiencia de usuario.
  - **Header Principal**: Un encabezado que se incluye en el `Activity` principal para mantener una apariencia consistente.
  - **Bottom Navigation Menu**: El menú de navegación principal que permite al usuario moverse entre tres fragmentos:
      - **Fragmento Inicio**: Muestra una selección de los tres libros más vendidos.
      - **Fragmento Lista**: Presenta una lista completa de todos los libros disponibles. Cada ítem muestra el título, autor, año, una portada y un enlace para ver la descripción detallada.
      - **Fragmento Carrito**: Permite visualizar los libros seleccionados, con detalles como el nombre, autor, precio y portada. También muestra un resumen de la compra con el subtotal, IVA y total.
  - **Funcionalidad del Carrito**: Los usuarios pueden seleccionar uno o varios libros en el **Fragmento Lista** mediante checkboxes y agregarlos al carrito con un botón flotante. Desde el carrito, los libros pueden ser eliminados individualmente.
  - **Pasarela de Pago**: Un botón de "Pagar" en el carrito lleva al usuario a un fragmento con una página de pago estática que simula el proceso de `checkout` y muestra los medios de pago disponibles.

-----

## 🛠️ Tecnologías Utilizadas

Este proyecto ha sido desarrollado con las siguientes tecnologías:

  - **Android Studio**: Entorno de Desarrollo Integrado (IDE) principal para la creación del proyecto.
  - **Java**: Lenguaje de programación utilizado para toda la lógica de la aplicación.
  - **XML**: Utilizado para la maquetación y el diseño de la interfaz de usuario.
  - **Material 3**: La aplicación utiliza componentes de diseño de Material 3 para una estética moderna y funcional.
  - **Fragments y Navigation Component**: Empleados para gestionar la navegación entre las diferentes pantallas.
  - **RecyclerView**: Usado para mostrar de manera eficiente las listas de libros.
  - **Lottie**: Biblioteca para la animación del **Splash Activity**.

-----

## ⚙️ Cómo Ejecutar el Proyecto

Para configurar y ejecutar el proyecto, sigue estos pasos:

1.  **Clonar el repositorio**:
    ```bash
    git clone https://github.com/quirogajqa/App_Libreria.git
    ```
2.  **Abrir en Android Studio**:
    Abre Android Studio y selecciona `File > Open`, luego navega hasta la carpeta del proyecto clonado y ábrela.
3.  **Sincronizar el proyecto**:
    Android Studio detectará el proyecto y sincronizará automáticamente las dependencias. Si no, haz clic en **"Sync Project with Gradle Files"**.
4.  **Ejecutar la aplicación**:
    Conecta un dispositivo Android físico o utiliza un emulador. Selecciona el dispositivo en la barra de herramientas y haz clic en el botón **"Run"** (el ícono de flecha verde).

-----

## 🤔 Decisiones de Diseño y Desarrollo

  - **Navegación**: Se optó por un **Bottom Navigation Menu** para una navegación intuitiva y accesible, ya que los tres fragmentos principales son de alta relevancia para el usuario.
  - **Rendimiento**: El uso de **RecyclerView** para la lista de libros fue una decisión clave para asegurar un rendimiento óptimo, incluso con una lista muy larga, ya que reutiliza las vistas.
  - **Experiencia de Usuario**: La inclusión de una animación Lottie y un logo en el **Splash Activity** mejora la experiencia inicial, haciendo que el tiempo de espera sea más atractivo visualmente.
  - **Estructura de la aplicación**: La arquitectura del proyecto se basa en **Activities** y **Fragments**, lo que permite una buena modularidad y reutilización de componentes de la interfaz de usuario.

-----

## 📖 Respuestas a Preguntas Teóricas y Prácticas

### **Pregunta teórica: Tecnologías y Herramientas clave en Android**

El desarrollo de aplicaciones Android se basa en un conjunto de tecnologías y herramientas que trabajan en conjunto para crear aplicaciones eficientes y funcionales. Tres de las más importantes son:

1.  **Java/Kotlin**: Los lenguajes de programación principales. Kotlin es el lenguaje preferido por Google debido a su sintaxis concisa y su seguridad.
2.  **Android SDK (Software Development Kit)**: El kit de herramientas con todo lo necesario para crear aplicaciones Android, incluyendo bibliotecas, depuradores y emuladores.
3.  **Android Studio**: El Entorno de Desarrollo Integrado (IDE) oficial de Google, que proporciona un editor de código, herramientas de depuración y un diseñador de interfaz.

### **Pregunta práctica: Configuración de un nuevo proyecto**

Para configurar un nuevo proyecto en Android Studio, se deben seguir estos pasos esenciales:

1.  **Seleccionar el tipo de proyecto**: Elegir una plantilla base, como **"Empty Activity"**, para comenzar desde cero.
2.  **Configurar el lenguaje y el nombre**: Elegir entre Kotlin o Java, asignar un nombre a la aplicación y definir un nombre de paquete único (por ejemplo, `com.ejemplo.miaplicacion`).
3.  **Establecer la versión mínima de Android (Minimum SDK)**: Esta configuración es crucial porque determina en qué versión de Android funcionará la aplicación.

### **Pregunta práctica: Manejo y optimización de assets**

El manejo de **assets** (recursos como imágenes, fuentes y archivos de sonido) es fundamental para el rendimiento. Se almacenan en el directorio `res`. La optimización de los assets es vital por las siguientes razones:

1.  **Rendimiento**: Las imágenes grandes o no optimizadas consumen mucha memoria y CPU, lo que puede ralentizar la aplicación.
2.  **Tamaño de la aplicación**: Unos assets grandes aumentan el tamaño del archivo APK.
3.  **Adaptación a diferentes dispositivos**: Android usa un sistema de calificadores de recursos (como `mdpi`, `hdpi`, `xhdpi`) para que la aplicación utilice versiones optimizadas de la misma imagen, asegurando que se vea bien en pantallas con diferentes densidades.

-----

## 📸 Galería de Capturas

Aquí puedes ver capturas de pantalla de la aplicación en funcionamiento.

  ![Captura de la pantalla de carga](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/pantalla_carga.png)
  ![Captura de la pantalla de inicio](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/pantalla_inicio.png))
  ![Captura de la pantalla de la descripción de un libro](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/pantalla_descripcion.png)
  ![Captura de la pantalla de la lista de libros](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/pantalla_lista.png)
  ![Cartura de la pantalla del carrito](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/pantalla_carrito.png)
  ![Captura de la pantalla de pago](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/pantalla_pago.png))
  
## 🎥 Aplicación en Funcionamiento

Aquí puedes un gif con la aplicación en funcionamiento..

  ![Captura de la pantalla de pago](https://github.com/quirogajqa/App_Libreria/blob/master/app/src/main/assets/app_funcionando.gif)







 
