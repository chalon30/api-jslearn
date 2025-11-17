USE railway;

INSERT INTO curso (id, titulo, descripcion, imagen_url, activo)
VALUES 
(1, 'Curso de JavaScript desde Cero', 'Aprende JavaScript moderno paso a paso con ejercicios prácticos.', 'https://wallpapers.com/images/featured-small/fondods-de-programacion-en-4k-v5t1j2ccxxojs52q.webp', 1);

INSERT INTO modulo (id, titulo, numero_orden, curso_id)
VALUES 
(1, 'Introducción a JavaScript', 1, 1),
(2, 'Fundamentos del Lenguaje', 2, 1),
(3, 'Funciones y DOM', 3, 1),
(4, 'Arreglos y Objetos', 4, 1);

INSERT INTO leccion (id, titulo, contenido, video_url, intro1, intro2, intro3, numero_orden, modulo_id)
VALUES
(1, '¿Qué es JavaScript?', 
 'JavaScript es un lenguaje interpretado que permite crear interactividad y dinamismo en la web.',
 'https://www.youtube.com/watch?v=upDLs1sn7g4',
 'JavaScript nació para agregar comportamiento a las páginas web.',
 'Actualmente es uno de los lenguajes más usados del mundo.',
 'Es esencial para cualquier desarrollador frontend.',
 1, 1),

(2, 'Cómo funciona JavaScript en el navegador',
 'JavaScript se ejecuta dentro del navegador mediante un motor como V8 o SpiderMonkey.',
 'https://www.youtube.com/watch?v=KGkiIBTq0y0',
 'Los navegadores interpretan y ejecutan el código JS.',
 'Cada navegador usa un motor diferente.',
 'JS permite manipular elementos y responder a eventos.',
 2, 1),

(3, 'Variables y Tipos de Datos',
 'JavaScript utiliza var, let y const para declarar variables y manejar diferentes tipos de datos.',
 'https://www.youtube.com/watch?v=efJ2J9n7B2k',
 'Las variables almacenan valores que puedes modificar.',
 'let y const son las palabras clave modernas.',
 'Es importante conocer los tipos: string, number, boolean.',
 1, 2),

(4, 'Operadores en JavaScript',
 'Los operadores permiten realizar cálculos y comparar valores.',
 'https://www.youtube.com/watch?v=i6Oi-YtXnAU',
 'Existen operadores aritméticos, lógicos y de comparación.',
 'Son esenciales para controlar la lógica del programa.',
 'Aprender operadores facilita entender condicionales.',
 2, 2),

(5, 'Condicionales: if, else, switch',
 'Las estructuras condicionales permiten ejecutar código según una condición.',
 'https://www.youtube.com/watch?v=IsG4Xd6LlsM',
 'if y else son las más usadas en lógica básica.',
 'switch sirve para múltiples comparaciones.',
 'Controlarán decisiones dentro del programa.',
 3, 2),

(6, 'Funciones en JavaScript',
 'Las funciones agrupan lógica reutilizable dentro del programa.',
 'https://www.youtube.com/watch?v=N8ap4k_1QEQ',
 'Una función puede recibir parámetros.',
 'Puede devolver un valor.',
 'Las funciones flecha son una alternativa moderna.',
 1, 3),

(7, 'Funciones Flecha (Arrow Functions)',
 'Las arrow functions permiten una sintaxis más corta y moderna.',
 'https://www.youtube.com/watch?v=h33Srr5J9nY',
 'Son útiles en callbacks.',
 'No tienen su propio this.',
 'Son ideales para código compacto.',
 2, 3),

(8, 'Introducción al DOM',
 'El DOM permite manipular la estructura HTML desde JavaScript.',
 'https://www.youtube.com/watch?v=0ik6X4DJKCc',
 'Puedes cambiar texto, atributos y estilos.',
 'Es clave para hacer páginas dinámicas.',
 'El DOM representa el contenido como nodos.',
 3, 3),

(9, 'Arreglos y Objetos en JavaScript',
 'Los arreglos y objetos son las estructuras de datos más importantes en JS.',
 'https://www.youtube.com/watch?v=We2Kv1HMGvc',
 'Los arrays almacenan listas de valores.',
 'Los objetos almacenan datos en forma de clave/valor.',
 'Son fundamentales para manejar información.',
 1, 4);

INSERT INTO pregunta (id, enunciado, explicacion, numero_orden, leccion_id)
VALUES
(1, 'JavaScript es un lenguaje orientado a:', 'JavaScript permite crear interactividad en la web y está orientado a objetos.', 1, 1),
(2, '¿Dónde se ejecuta JavaScript normalmente?', 'JavaScript se ejecuta dentro del navegador mediante motores especializados.', 1, 2),
(3, '¿Cuál palabra clave es la más moderna para declarar variables?', 'let y const son más seguras y modernas que var.', 1, 3),
(4, '¿Cuál operador compara valores estrictamente?', '=== compara valor y tipo en JavaScript.', 1, 4),
(5, '¿Qué estructura permite evaluar condiciones?', 'Las estructuras if/else permiten controlar la lógica del programa.', 1, 5),
(6, 'Una función sirve para:', 'Las funciones permiten reutilizar código.', 1, 6),
(7, '¿Qué característica distingue a las arrow functions?', 'No tienen su propio this y deben usarse con cuidado.', 1, 7),
(8, '¿Qué permite hacer el DOM?', 'El DOM permite manipular elementos HTML desde JS.', 1, 8),
(9, '¿Qué estructura almacena pares clave-valor?', 'Los objetos permiten almacenar información estructurada.', 1, 9);

INSERT INTO opcion (id, texto, correcta, numero_orden, pregunta_id)
VALUES
(1, 'Web e interactividad', 1, 1, 1),
(2, 'Compilación avanzada', 0, 2, 1),
(3, 'Redes', 0, 3, 1),

(4, 'En el navegador', 1, 1, 2),
(5, 'En Photoshop', 0, 2, 2),
(6, 'En MySQL', 0, 3, 2),

(7, 'let', 1, 1, 3),
(8, 'var', 0, 2, 3),
(9, 'global', 0, 3, 3),

(10, '===', 1, 1, 4),
(11, '=', 0, 2, 4),
(12, '!==', 0, 3, 4),

(13, 'if / else', 1, 1, 5),
(14, 'html()', 0, 2, 5),
(15, 'createTable()', 0, 3, 5),

(16, 'Reutilizar código', 1, 1, 6),
(17, 'Crear imágenes', 0, 2, 6),
(18, 'Instalar programas', 0, 3, 6),

(19, 'No tienen this propio', 1, 1, 7),
(20, 'Se ejecutan solas', 0, 2, 7),
(21, 'Son clases', 0, 3, 7),

(22, 'Manipular HTML', 1, 1, 8),
(23, 'Editar videos', 0, 2, 8),
(24, 'Compilar archivos', 0, 3, 8),

(25, 'Objetos', 1, 1, 9),
(26, 'Directorios', 0, 2, 9),
(27, 'Imágenes', 0, 3, 9);
