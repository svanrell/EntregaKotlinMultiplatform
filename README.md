# Entrega: Tarjeta de Presentación en Kotlin y Compose Desktop

**Asignatura:** Desarrollo de Interfaces (DI)  
**Profesor:** Miguel Molina  
**Tema 2:** Primeras interfaces con Kotlin & Compose  

---

## 📋 1. ¿Qué se ha hecho?

Se ha diseñado e implementado una aplicación de escritorio con **Kotlin Multiplatform** y **Jetpack Compose** que replica fielmente la interfaz solicitada en el ejercicio evaluable del Tema 2:

* **Ventana principal:** Titulada `"Tarjeta de presentación"`, con dimensiones proporcionales y fondo neutro (`#F1F5F9`) para contrastar con las tarjetas.
* **3 tarjetas de presentación:** Cada una con datos diferenciados para tres perfiles:
  1. **Elvira Ocaña Rodríguez** — Desarrolladora DAM
  2. **Ginés Ocaña Rodríguez** — Desarrollador DAM
  3. **Gustavo Ocaña Rodríguez** — Desarrollador DAM
* **Fotografía de perfil:** Imagen circular en cada tarjeta cargada mediante el sistema de recursos de Compose (`Res.drawable.avatar`), adaptada mediante recorte circular (`CircleShape`) y escala de contenido (`ContentScale.Crop`).
* **Línea divisoria:** Separador visual horizontal (`HorizontalDivider`) entre la cabecera y los datos de contacto.
* **Texto en distintos formatos y estilos:**
  * **Nombre:** Tipografía en negrita (`FontWeight.Bold`), tamaño mayor (`18.sp`) y color principal oscuro (`#1E293B`).
  * **Cargo:** Color personalizado en tono terracota/teja (`#C05C46`), acorde a los apuntes de la asignatura.
  * **Etiquetas de contacto (`Correo:` y `Ciudad:`):** Resaltadas en negrita (`FontWeight.Bold`).
  * **Valores de contacto:** Peso normal (`FontWeight.Normal`), color secundario atenuado (`#475569`) y control de desbordamiento mediante elipsis (`TextOverflow.Ellipsis`).

---

## 🛠️ 2. ¿Cómo se ha hecho?

### 2.1. Gestión de Dependencias
Siguiendo las recomendaciones de la diapositiva 34 y del enunciado, en `desktopApp/build.gradle.kts` y `shared/build.gradle.kts` se añadieron las dependencias requeridas:
```kotlin
dependencies {
    implementation(libs.compose.components.resources)
    implementation(libs.compose.material3)
    implementation(compose.desktop.currentOs)
    ...
}
```

### 2.2. Modelo de Datos y Separación de Responsabilidades
Para aplicar el principio de elegancia de programación, los datos se separaron de la vista mediante la clase de datos:
```kotlin
data class TarjetaInfo(
    val nombre: String,
    val cargo: String,
    val correo: String,
    val ciudad: String,
    val colorFondo: Color = Color.White,
    val colorBorde: Color = Color(0xFFE2E8F0)
)
```
La colección de tarjetas se define en una lista y se itera limpiamente con `tarjetas.forEach { ... }`.

### 2.3. Creación de Composables Reutilizables
Se desarrollaron dos componentes `@Composable` modulares:
* **`TarjetaPresentacion(...)`:** Encargado de construir la estructura completa de una tarjeta recibiendo los datos como parámetros.
* **`DatoContacto(...)`:** Componente granular que maqueta las filas de `"Etiqueta: Valor"`, permitiendo combinar diferentes pesos tipográficos de forma homogénea.

### 2.4. Experimentación con `Modifier`s
Se exploraron y aplicaron activamente los distintos modificadores explicados en las diapositivas 26 a 32:
* **`Modifier.padding(...)`:** Control del espaciado interno (relleno de 20.dp en la tarjeta y separación en las divisiones).
* **`Modifier.fillMaxWidth()` y `Modifier.fillMaxSize()`:** Expansión de los contenedores para aprovechar el ancho disponible.
* **`Modifier.size(80.dp)`:** Dimensionado fijo para la imagen de perfil.
* **`Modifier.clip(CircleShape)`:** Recorte geométrico para transformar la fotografía cuadrada en un avatar circular.
* **`Modifier.border(...)`:** Contorno con borde sutil tanto para la imagen (`CircleShape`) como para la propia tarjeta (`BorderStroke`).
* **`Modifier.weight(1f)`:** En la `Column` de textos, permitiendo que ocupe todo el espacio sobrante horizontal a la derecha de la imagen sin solapamientos.
* **`Modifier.background(...)`:** Asignación del color de fondo suave para la ventana principal.
* **`Modifier.clickable { ... }`:** Interactividad que imprime en consola la tarjeta seleccionada al hacer clic sobre ella.
* **`Modifier.verticalScroll(rememberScrollState())`:** Permite desplazamiento vertical en caso de redimensionar la ventana a un tamaño menor.

---

## 💡 3. ¿Por qué se ha hecho de esta forma?

1. **Adopción del Paradigma Declarativo (UI = f(estado)):**  
   Compose elimina la manipulación manual de vistas tipo Swing o JavaFX. La interfaz se describe en función de los datos de entrada, permitiendo que Compose redibuje de forma óptima los componentes necesarios.
2. **Cumplimiento de la Convención Oficial de Compose:**  
   Siguiendo la directriz de la diapositiva 32, todo componente que emite elementos gráficos recibe `modifier: Modifier = Modifier` como parámetro opcional. Esto otorga al contenedor padre la flexibilidad de posicionar o alterar el componente sin violar el encapsulamiento.
3. **Uso de Compose Multiplatform Resources:**  
   En lugar de rutas relativas frágiles o llamadas a `ImageIcon`, se utilizó el sistema oficial de Jetpack Compose (`painterResource(Res.drawable.avatar)`), el cual gestiona la caché, la resolución de densidad y la compatibilidad multiplataforma de forma nativa.
4. **Legibilidad, Mantenibilidad y DRY (Don't Repeat Yourself):**  
   Encapsular la tarjeta en una función `@Composable` parametrizada permite añadir tantas tarjetas como sea necesario simplemente agregando un nuevo elemento a la lista, sin duplicar ni una sola línea de código visual.

---

## 🚀 4. Cómo ejecutar el proyecto

### Desde la terminal:
```bash
./gradlew desktopApp:run
```

### Desde IntelliJ IDEA / Android Studio:
1. Abrir el proyecto `EntregaKotlin1`.
2. Seleccionar la tarea de ejecución **desktopApp** en la barra superior.
3. Pulsar el botón verde **Run** (o `Shift + F10`).
