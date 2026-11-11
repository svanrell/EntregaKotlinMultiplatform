# Entrega Tema 2: Primeras interfaces con Kotlin & Compose

**Módulo:** Desarrollo de Interfaces (2º DAM)  
**Profesor:** Miguel Molina  
**Alumno:** Sergi Vanrell Quevedo  

---

## 📌 1. ¿Qué he hecho?

En esta práctica he replicado la interfaz propuesta en el ejercicio de clase: una ventana de escritorio con **3 tarjetas de presentación** con diferente información, incluyendo imágenes y textos con distintos estilos visuales.

La ventana tiene como título `"Tarjeta de presentación"` y dentro se muestran los tres perfiles solicitados:
1. **Elvira Ocaña Rodríguez** (Desarrolladora DAM)
2. **Ginés Ocaña Rodríguez** (Desarrollador DAM)
3. **Gustavo Ocaña Rodríguez** (Desarrollador DAM)

Cada una de las tarjetas cuenta con:
* Una **fotografía circular** a la izquierda.
* El **nombre** de la persona destacado en negrita y a un tamaño mayor.
* El **cargo** con un color diferenciado en tono teja/terracota.
* Una **línea divisoria horizontal** (`HorizontalDivider`) que separa la cabecera de los datos de contacto.
* Las filas de **correo y ciudad**, donde he resaltado la etiqueta (`Correo:` y `Ciudad:`) en negrita y el valor en texto normal, cumpliendo con el requisito de usar distintos formatos de texto.

---

## 🛠️ 2. ¿Cómo lo he hecho?

He buscado que el código sea lo más **limpio, minimalista y directo posible**, evitando crear clases auxiliares innecesarias y usando solo los modificadores (`Modifier`) imprescindibles.

### 2.1. Dependencias añadidas
En el archivo `desktopApp/build.gradle.kts` añadí las dependencias de Material 3 y Compose Resources:
```kotlin
dependencies {
    implementation(libs.compose.components.resources)
    implementation(libs.compose.material3)
    implementation(compose.desktop.currentOs)
    ...
}
```

### 2.2. Ventana de la aplicación (`main.kt`)
En `desktopApp/src/main/kotlin/com/example/entregakotlin1/main.kt` he configurado el punto de entrada usando la función `application` y el componente `Window`, asignando el título exacto `"Tarjeta de presentación"` y un tamaño inicial cómodo de `850.dp x 650.dp`.

### 2.3. Estructura de la interfaz (`App.kt`)
Todo el diseño visual vive en `shared/src/commonMain/kotlin/com/example/entregakotlin1/App.kt` y se divide en dos funciones:

1. **Función principal `App()`:**  
   Envuelve la vista en `MaterialTheme` y utiliza un `Column` que ocupa toda la pantalla (`fillMaxSize`) con un `padding(16.dp)`. Para separar las tarjetas de manera uniforme utilizo `verticalArrangement = Arrangement.spacedBy(16.dp)`, lo que me permite evitar añadir `Spacers` manuales entre tarjeta y tarjeta.

2. **Función reutilizable `Tarjeta(...)`:**  
   He creado una función `@Composable` que recibe por parámetro los datos de cada tarjeta:
   ```kotlin
   @Composable
   fun Tarjeta(
       nombre: String,
       cargo: String,
       correo: String,
       ciudad: String
   )
   ```
   Dentro de esta función:
   * **`Card`:** Uso el componente `Card` de Material 3, configurando el fondo blanco (`containerColor = Color.White`) y una sombra de elevación (`defaultElevation = 4.dp`).
   * **`Row` horizontal:** Coloca la fotografía a la izquierda y el bloque de texto a la derecha, alineados verticalmente al centro (`Alignment.CenterVertically`) y con un espacio entre ellos de `16.dp`.
   * **`Image`:** Cargo la foto desde los recursos mediante `painterResource(Res.drawable.avatar)`. Con `ContentScale.Crop` aseguro que llene el marco sin deformarse y con `Modifier.size(80.dp).clip(CircleShape)` la recorto en forma de círculo.
   * **`Column` de textos (`Modifier.weight(1f)`):** El modificador `weight(1f)` es fundamental aquí para que esta columna ocupe automáticamente todo el ancho que sobra en la fila. Dentro coloco:
     * El `Text` del nombre con `FontWeight.Bold` y `fontSize = 18.sp`.
     * El `Text` del cargo con `color = Color(0xFFC05C46)` (el tono teja de las diapositivas).
     * El `HorizontalDivider()` con un margen vertical de `8.dp`.
     * Dos `Row` pequeños para `Correo: ` y `Ciudad: `, donde la etiqueta va con `FontWeight.Bold` y el dato con peso normal.

---

## 💡 3. ¿Por qué lo he hecho de esta forma?

* **Sin clases intermedias (código minimalista):** En lugar de crear un `data class TarjetaInfo` y una lista de objetos que complicaría innecesariamente la estructura para este ejercicio, he preferido llamar directamente a la función `@Composable fun Tarjeta(...)` pasándole los valores requeridos. Es mucho más fácil de leer y entender a simple vista.
* **Solo los Modifiers indispensables:** He evitado sobrecargar el código con modificadores de clic, bordes complejos o cálculos raros. Solo he usado los que aportan valor real al diseño (`fillMaxWidth`, `padding`, `size`, `clip`, `weight` y `spacedBy`).
* **Modularidad y principio DRY (Don't Repeat Yourself):** Al aislar la tarjeta en su propio `@Composable`, no tengo que duplicar 50 líneas de código para cada persona; simplemente llamo a `Tarjeta(...)` tres veces cambiando los argumentos.
* **Uso de Compose Resources (`Res.drawable.avatar`):** Es la forma oficial y multiplataforma que se explica en el Tema 2 para manejar imágenes locales en Compose, evitando rutas relativas en disco que podrían fallar en otro equipo.

---

## 🚀 4. Cómo ejecutar el proyecto

Para probar la aplicación en local desde la terminal:

```bash
./gradlew desktopApp:run
```

O bien abriendo el proyecto en **IntelliJ IDEA** y ejecutando la configuración **desktopApp**.
