# Entrega: Tarjeta de Presentación (Tema 2 - Kotlin & Compose)

**Asignatura:** Desarrollo de Interfaces  
**Tema:** Primeras interfaces con Kotlin & Compose  

---

## 1. ¿Qué se ha hecho?

Se ha creado la interfaz de escritorio solicitada en el ejercicio evaluable:
* Una ventana principal con el título **`"Tarjeta de presentación"`**.
* **3 tarjetas de presentación** con información distinta:
  1. **Elvira Ocaña Rodríguez** (Desarrolladora DAM)
  2. **Ginés Ocaña Rodríguez** (Desarrollador DAM)
  3. **Gustavo Ocaña Rodríguez** (Desarrollador DAM)
* En cada tarjeta se incluye:
  * Una **imagen** circular de perfil (`avatar.png`) cargada mediante Compose Resources.
  * **Textos en diferentes formatos:** nombre en negrita (`FontWeight.Bold`) y tamaño superior (`18.sp`), cargo en color terracota/teja, y datos de contacto (`Correo:` y `Ciudad:`) combinando etiquetas en negrita con valores en formato regular.
  * Una línea divisoria horizontal (`HorizontalDivider`) que separa el cargo del bloque de contacto.

---

## 2. ¿Cómo se ha hecho?

El código se ha diseñado de forma minimalista, limpia y directa, usando únicamente los componentes y modificadores necesarios:

1. **Dependencias:**  
   Se incluyeron en `desktopApp/build.gradle.kts` las librerías recomendadas:
   * `libs.compose.material3`
   * `libs.compose.components.resources`

2. **Función Composable reutilizable (`Tarjeta`):**  
   En lugar de crear clases complejas, se definió un único `@Composable fun Tarjeta(...)` que recibe directamente los parámetros de cada persona (`nombre`, `cargo`, `correo`, `ciudad`) y genera la tarjeta correspondiente.

3. **Estructura de maquetación:**
   * **`Column` principal:** Organiza las 3 tarjetas verticalmente con un espaciado uniforme (`Arrangement.spacedBy(16.dp)`).
   * **`Card`:** Contenedor de cada tarjeta con esquinas redondeadas, fondo blanco y una elevación sutil para dar relieve.
   * **`Row` horizontal:** Coloca la fotografía a la izquierda y la columna de datos a la derecha.
   * **`Image`:** Se carga con `painterResource(Res.drawable.avatar)`, escalado con `ContentScale.Crop` y recortado en forma circular con `.clip(CircleShape)`.
   * **`Column` interior (`Modifier.weight(1f)`):** Ocupa el ancho restante de la tarjeta para presentar el nombre, cargo, `HorizontalDivider()` y las filas de correo y ciudad.

---

## 3. ¿Por qué se ha hecho de esta forma?

* **Simplicidad y claridad:** Siguiendo el principio de mantener el código lo más directo y legible posible, sin sobrecargar con modificadores redundantes ni clases innecesarias.
* **Paradigma declarativo de Compose:** Al crear una función composable parametrizada, reutilizamos la misma plantilla visual para los tres perfiles sin duplicar código de maquetación.
* **Fidelidad al diseño:** Se han aplicado únicamente los estilos indispensables para que la interfaz sea visualmente idéntica al ejemplo de las diapositivas y el enunciado.

---

## 4. Ejecución

Para iniciar la aplicación:

```bash
./gradlew desktopApp:run
```
