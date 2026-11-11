# Entrega Tema 2: Primeras interfaces con Kotlin & Compose

**Módulo:** Desarrollo de Interfaces (2º DAM)  
**Profesor:** Miguel Molina  
**Alumno:** Sergi Vanrell Quevedo  

---

## 📌 1. ¿Qué se ha hecho?

En esta práctica he replicado la interfaz propuesta en el ejercicio de clase: una ventana de escritorio titulada **`"Tarjeta de presentación"`** que contiene **3 tarjetas de presentación** con información distinta, fotografías y textos en múltiples formatos:

1. **Elvira Ocaña Rodríguez** (Desarrolladora DAM) — Fondo blanco clásico.
2. **Ginés Ocaña Rodríguez** (Desarrollador DAM) — Fondo sutilmente diferenciado (`#F8FAFC`).
3. **Gustavo Ocaña Rodríguez** (Desarrollador DAM) — Fondo blanco clásico.

En cada una de las tarjetas se incluye:
* Una **fotografía circular** (`playa.png`) cargada de forma nativa desde los recursos de Compose.
* El **nombre completo** en negrita (`FontWeight.Bold`) y a mayor tamaño (`18.sp`).
* El **cargo o titulación** con un color diferenciado en tono teja/terracota (`Color(0xFFC05C46)`), tal como se muestra en las diapositivas de clase.
* Una **línea divisoria horizontal** (`HorizontalDivider`) que separa el encabezado de los datos de contacto.
* Filas de **contacto (Correo y Ciudad)** donde se combinan distintos formatos tipográficos: la etiqueta en negrita y el dato en peso normal, aplicando control de desbordamiento mediante elipsis (`TextOverflow.Ellipsis`).

---

## 🛠️ 2. ¿Cómo se ha hecho?

He diseñado la solución siguiendo las buenas prácticas de Jetpack Compose y las pautas indicadas en el enunciado:

### 2.1. Dependencias recomendadas
En `desktopApp/build.gradle.kts` y `shared/build.gradle.kts` he añadido las dependencias recomendadas para Compose Material 3 y la gestión de recursos:
```kotlin
dependencies {
    implementation(libs.compose.components.resources)
    implementation(libs.compose.material3)
    implementation(compose.desktop.currentOs)
    ...
}
```

### 2.2. Ventana de la aplicación (`main.kt`)
En `desktopApp/src/main/kotlin/com/example/entregakotlin1/main.kt` configuro el arranque con `application { ... }` y defino la ventana con `Window(title = "Tarjeta de presentación")`, asignando un tamaño inicial de `850.dp x 650.dp` mediante `rememberWindowState`.

### 2.3. Estructura visual y componentes (`App.kt`)
* **`Column` principal:** Apila las 3 tarjetas en vertical ocupando toda la ventana (`fillMaxSize()`), dejando un margen de `16.dp` y usando `verticalArrangement = Arrangement.spacedBy(16.dp)` para mantener un espaciado idéntico y automático entre tarjetas.
* **Componente `Card` de Material 3:** Usado como contenedor principal de cada tarjeta, definiendo bordes redondeados y una elevación sutil (`cardElevation(4.dp)`).
* **Componente `Image`:** Carga la imagen `playa.png` usando `painterResource(Res.drawable.playa)`, ajustada con `ContentScale.Crop` y recortada en forma circular con `Modifier.clip(CircleShape)`.
* **Componente `HorizontalDivider()`:** Inserta la línea separadora con un margen vertical de `8.dp` arriba y abajo.
* **Componente `Text`:** Aplicando diferentes combinaciones de `fontWeight`, `fontSize`, `color` y `overflow`.

### 2.4. Elegancia de programación y experimentación con `Modifier`
* **Composable parametrizado:** En lugar de duplicar código o crear clases complejas, he creado la función `@Composable fun Tarjeta(...)` que recibe como argumentos el nombre, cargo, correo, ciudad, un color de fondo personalizable (`colorFondo: Color = Color.White`) y el modificador opcional `modifier: Modifier = Modifier`.
* **Experimentación con fondos y modificadores:**
  * He probado a dar un **color de fondo diferente para cada elemento**: la tarjeta central utiliza un tono suave gris/azulado (`#F8FAFC`) mientras que las exteriores usan blanco puro (`Color.White`), demostrando la personalización por parámetro.
  * Se aplica `Modifier.weight(1f)` en la columna de textos para que consuma automáticamente todo el ancho libre a la derecha de la fotografía.
  * Se sigue la convención oficial de Compose: `modifier: Modifier = Modifier` como parámetro opcional para que el contenedor padre pueda añadir estilos adicionales si lo desea.

---

## 💡 3. ¿Por qué se ha hecho de esta forma?

1. **Elegancia y principio DRY (Don't Repeat Yourself):**  
   Al extraer la tarjeta en un `@Composable` reutilizable que recibe parámetros, se evita repetir decenas de líneas de código visual. Para crear una nueva tarjeta solo hace falta una llamada a `Tarjeta(...)`.
2. **Código limpio y sin clases innecesarias:**  
   Prescindir de estructuras intermedias pesadas (`data class`, adaptadores, etc.) permite que el código sea directo, conciso y fácil de leer y explicar en clase.
3. **Uso de Compose Resources (`Res.drawable.playa`):**  
   Es la solución estándar y multiplataforma del Tema 2 para acceder a imágenes empaquetadas en el proyecto, garantizando que la imagen funcione en cualquier sistema operativo sin depender de rutas absolutas de disco.
4. **Separación declarativa con `spacedBy` y `weight`:**  
   Aprovechar los modificadores nativos de Compose (`Arrangement.spacedBy` y `Modifier.weight(1f)`) produce interfaces adaptables y fluidas que no se rompen si cambia el tamaño de la ventana.

---

## 🚀 4. Cómo ejecutar el proyecto

Para lanzar la aplicación desde la terminal:

```bash
./gradlew desktopApp:run
```

O bien abriendo el proyecto en **IntelliJ IDEA** y ejecutando la tarea **desktopApp**.
