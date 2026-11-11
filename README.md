# Ejercicio evaluable - Tema 2: Kotlin & Compose

- **Asignatura:** Desarrollo de Interfaces
- **Alumno:** Sergi Vanrell Quevedo
- **Profesor:** Miguel Molina

---

## 1. Qué se ha hecho

Para esta práctica he desarrollado una aplicación de escritorio que muestra una ventana con el título "Tarjeta de presentación" y tres tarjetas con perfiles diferentes, tal como se pedía en el ejercicio:

1. **Elvira Ocaña Rodríguez** (Desarrolladora DAM)
2. **Ginés Ocaña Rodríguez** (Desarrollador DAM)
3. **Gustavo Ocaña Rodríguez** (Desarrollador DAM)

Cada tarjeta contiene:
- Una fotografía circular a la izquierda (`playa.png`).
- El nombre de la persona en negrita y con un tamaño de letra más grande.
- El cargo en color teja/rojizo (`#C05C46`), igual que en las diapositivas de clase.
- Una línea horizontal (`HorizontalDivider`) para separar el encabezado del contacto.
- Los datos de contacto de correo y ciudad, con las etiquetas ("Correo:" y "Ciudad:") en negrita y los valores en texto normal.

---

## 2. Cómo se ha hecho

El proyecto está montado sobre Kotlin Multiplatform Desktop con Compose:

- **Dependencias:** He añadido en `desktopApp/build.gradle.kts` y `shared/build.gradle.kts` las dos dependencias recomendadas en los apuntes: `compose.material3` y `compose.components.resources`.
- **Ventana (`main.kt`):** He definido la ventana con `Window`, poniéndole el título "Tarjeta de presentación" y un tamaño inicial de 850x650 dp para que el contenido se vea holgado.
- **Estructura principal (`App.kt`):**
  - Todo va dentro de un `Column` que ocupa toda la pantalla con un `padding(16.dp)` para que las tarjetas no toquen los bordes.
  - Para separar las tarjetas he usado `verticalArrangement = Arrangement.spacedBy(16.dp)`, lo que deja 16 dp de separación automática entre cada una sin tener que añadir espacios a mano.
- **Función reutilizable `Tarjeta`:**
  - He creado un `@Composable fun Tarjeta(...)` que recibe como parámetros el nombre, cargo, correo, ciudad y opcionalmente un color de fondo y un modificador.
  - Al hacer esto, solo tengo que llamar a la función tres veces cambiando los datos de cada persona.
- **Componentes y modificadores usados:**
  - `Card`: Para la tarjeta, con fondo blanco y una elevación suave de 4 dp que le da sombra.
  - `Row`: Para alinear en horizontal la foto a la izquierda y el texto a la derecha.
  - `Image`: Para cargar `playa.png` desde recursos con `painterResource(Res.drawable.playa)`, recortándola en forma de círculo con `.clip(CircleShape)` y usando `ContentScale.Crop` para que no se deforme.
  - `Column` con `weight(1f)`: Le indica a Compose que el bloque de texto debe ocupar todo el espacio que sobra a la derecha de la imagen.
  - `HorizontalDivider`: La línea separadora con un margen vertical de 8 dp arriba y abajo.
  - `Text`: Formateando cada línea con `FontWeight.Bold`, distintos tamaños (`18.sp`), colores y `TextOverflow.Ellipsis`.
  - **Prueba con distintos fondos:** En la segunda tarjeta he probado a pasarle un color de fondo ligeramente diferente (`#F8FAFC`) para comprobar la personalización por parámetro.

---

## 3. Por qué se ha hecho de esta forma

- **Hacer un composable reutilizable en vez de copiar código:** Si no hiciera una función propia para la tarjeta, tendría que duplicar toda la estructura de filas, columnas, imágenes y textos tres veces. De esta forma el código queda mucho más corto, limpio y si quiero cambiar un estilo lo cambio en un solo sitio.
- **Sin clases auxiliares innecesarias:** Para una interfaz sencilla como esta no hacía falta crear clases de datos (`data class`) ni modelos complejos; pasar los argumentos directamente a la función hace que el código sea directo y fácil de entender.
- **Cargar la imagen con Compose Resources:** Al usar `Res.drawable.playa` me aseguro de que la imagen se incluya dentro de la aplicación y funcione en cualquier ordenador, sin depender de rutas absolutas de mi disco duro.
- **Uso de modificadores sencillos:** He usado los modificadores estrictamente necesarios (`padding`, `fillMaxWidth`, `clip`, `weight`, `spacedBy`) para que la interfaz se adapte bien y sea lo más parecida posible al diseño de la tarea.

---

## 4. Cómo ejecutar el proyecto

Desde la terminal en la raíz del proyecto:

```bash
./gradlew desktopApp:run
```

O abriendo el proyecto con IntelliJ IDEA y ejecutando la tarea **desktopApp**.
