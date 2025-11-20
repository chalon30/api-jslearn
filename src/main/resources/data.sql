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

------------------------------------------------------------
-- 3 PREGUNTAS POR CADA LECCIÓN (27 PREGUNTAS)
------------------------------------------------------------
INSERT INTO pregunta (id, enunciado, explicacion, numero_orden, leccion_id)
VALUES
(1, 'JavaScript es un lenguaje orientado a:', 'JavaScript permite crear interactividad en la web y está orientado a la web y a objetos.', 1, 1),
(2, '¿Para qué se creó inicialmente JavaScript?', 'JavaScript nació para agregar comportamiento e interactividad a páginas web estáticas.', 2, 1),
(3, 'Hoy en día, JavaScript es especialmente importante para:', 'JavaScript es fundamental para el desarrollo frontend y también se usa en el backend.', 3, 1),

(4, '¿Dónde se ejecuta normalmente JavaScript en una página web?', 'JavaScript se ejecuta dentro del navegador mediante motores especializados.', 1, 2),
(5, '¿Cómo se llama el programa del navegador que interpreta JavaScript?', 'Cada navegador tiene un motor o engine que interpreta y ejecuta el código JavaScript.', 2, 2),
(6, '¿Qué permite hacer JavaScript dentro del navegador?', 'JavaScript permite manipular el DOM y responder a eventos del usuario.', 3, 2),

(7, '¿Cuál palabra clave es la más moderna para declarar variables?', 'let y const son más modernas y seguras que var.', 1, 3),
(8, '¿Qué palabra clave se usa para declarar constantes en JavaScript?', 'const se usa para declarar variables cuyo valor no cambiará.', 2, 3),
(9, '¿Cuál de estos NO es un tipo de dato primitivo en JavaScript?', 'Los tipos primitivos incluyen string, number, boolean, null, undefined, symbol y bigint.', 3, 3),

(10, '¿Cuál operador compara valores y tipos estrictamente?', '=== compara valor y tipo en JavaScript.', 1, 4),
(11, '¿Cuál de estos es un operador aritmético?', 'Los operadores aritméticos se usan para sumar, restar, multiplicar, etc.', 2, 4),
(12, '¿Cuál de estos es un operador lógico en JavaScript?', 'Los operadores lógicos permiten combinar condiciones.', 3, 4),

(13, '¿Qué estructura permite evaluar una condición verdadera o falsa?', 'if / else se usan para tomar decisiones según una condición.', 1, 5),
(14, '¿Qué estructura es útil cuando hay muchos casos a evaluar?', 'switch es útil cuando se compara una misma expresión con varios valores.', 2, 5),
(15, '¿Qué hace la sentencia else?', 'else se ejecuta cuando la condición del if es falsa.', 3, 5),

(16, 'Una función sirve principalmente para:', 'Las funciones permiten reutilizar código agrupando instrucciones.', 1, 6),
(17, '¿Cómo se llama el valor que una función puede devolver?', 'El valor devuelto por una función se conoce como valor de retorno.', 2, 6),
(18, '¿Qué palabra clave se usa para devolver un valor desde una función?', 'La palabra clave return envía un valor de vuelta al lugar donde se llamó la función.', 3, 6),

(19, '¿Qué característica distingue a las arrow functions?', 'Las arrow functions no tienen su propio this.', 1, 7),
(20, '¿Cuál es una ventaja de las arrow functions?', 'Las arrow functions permiten una sintaxis más corta y legible en muchos casos.', 2, 7),
(21, '¿En qué caso son muy usadas las arrow functions?', 'Las arrow functions se usan mucho como callbacks en métodos de arrays y eventos.', 3, 7),

(22, '¿Qué permite hacer el DOM con respecto a una página HTML?', 'El DOM permite manipular elementos HTML desde JavaScript.', 1, 8),
(23, '¿Cómo representa el DOM a una página web?', 'El DOM representa el documento como un árbol de nodos.', 2, 8),
(24, '¿Qué método se usa para obtener un elemento por su id?', 'document.getElementById(\"id\") obtiene un elemento específico del DOM.', 3, 8),

(25, '¿Qué estructura almacena pares clave-valor en JavaScript?', 'Los objetos permiten almacenar información estructurada en pares clave-valor.', 1, 9),
(26, '¿Qué estructura se usa para almacenar una lista ordenada de elementos?', 'Los arreglos almacenan listas ordenadas de valores.', 2, 9),
(27, '¿Cómo se accede al tercer elemento de un arreglo llamado numeros?', 'Los arreglos son de índice cero, así que el tercer elemento está en la posición 2.', 3, 9);

------------------------------------------------------------
-- OPCIONES (RESPUESTA CORRECTA EN POSICIONES VARIADAS)
------------------------------------------------------------
INSERT INTO opcion (id, texto, correcta, numero_orden, pregunta_id)
VALUES
-- P1 (correcta en posición 1)
(1, 'Web e interactividad', 1, 1, 1),
(2, 'Compilación avanzada', 0, 2, 1),
(3, 'Redes', 0, 3, 1),

-- P2 (correcta en posición 2)
(4, 'Agregar interactividad a páginas web', 1, 2, 2),
(5, 'Administrar bases de datos', 0, 1, 2),
(6, 'Diseñar sistemas operativos', 0, 3, 2),

-- P3 (correcta en posición 3)
(7, 'Desarrolladores frontend y full stack', 1, 3, 3),
(8, 'Solo administradores de redes', 0, 1, 3),
(9, 'Solo diseñadores gráficos', 0, 2, 3),

-- P4 (correcta en posición 1)
(10, 'En el navegador', 1, 1, 4),
(11, 'En Photoshop', 0, 2, 4),
(12, 'En MySQL', 0, 3, 4),

-- P5 (correcta en posición 3)
(13, 'if / else', 1, 3, 5),
(14, 'html()', 0, 1, 5),
(15, 'createTable()', 0, 2, 5),

-- P6 (correcta en posición 2)
(16, 'Manipular la página y responder a eventos', 1, 2, 6),
(17, 'Crear nuevos navegadores', 0, 1, 6),
(18, 'Formatear el disco duro', 0, 3, 6),

-- P7 (correcta en posición 2)
(19, 'let', 1, 2, 7),
(20, 'var', 0, 1, 7),
(21, 'global', 0, 3, 7),

-- P8 (correcta en posición 1)
(22, 'const', 1, 1, 8),
(23, 'change', 0, 2, 8),
(24, 'static', 0, 3, 8),

-- P9 (correcta en posición 3)
(25, 'array', 1, 3, 9),
(26, 'string', 0, 1, 9),
(27, 'number', 0, 2, 9),

-- P10 (correcta en posición 2)
(28, '===', 1, 2, 10),
(29, '=', 0, 1, 10),
(30, '!=', 0, 3, 10),

-- P11 (correcta en posición 1)
(31, '+', 1, 1, 11),
(32, '&&', 0, 2, 11),
(33, '===', 0, 3, 11),

-- P12 (correcta en posición 3)
(34, '&&', 1, 3, 12),
(35, '+', 0, 1, 12),
(36, '/', 0, 2, 12),

-- P13 (correcta en posición 3)
(37, 'if / else', 1, 3, 13),
(38, 'html()', 0, 1, 13),
(39, 'createTable()', 0, 2, 13),

-- P14 (correcta en posición 1)
(40, 'switch', 1, 1, 14),
(41, 'for', 0, 2, 14),
(42, 'while', 0, 3, 14),

-- P15 (correcta en posición 2)
(43, 'Se ejecuta si la condición del if es falsa', 1, 2, 15),
(44, 'Repite el código infinitamente', 0, 1, 15),
(45, 'Cierra el programa', 0, 3, 15),

-- P16 (correcta en posición 2)
(46, 'Reutilizar código', 1, 2, 16),
(47, 'Crear imágenes', 0, 1, 16),
(48, 'Instalar programas', 0, 3, 16),

-- P17 (correcta en posición 3)
(49, 'Valor de retorno', 1, 3, 17),
(50, 'Valor fijo', 0, 1, 17),
(51, 'Valor nulo', 0, 2, 17),

-- P18 (correcta en posición 1)
(52, 'return', 1, 1, 18),
(53, 'back', 0, 2, 18),
(54, 'send', 0, 3, 18),

-- P19 (correcta en posición 1)
(55, 'No tienen this propio', 1, 1, 19),
(56, 'Son clases', 0, 2, 19),
(57, 'Se ejecutan solas automáticamente', 0, 3, 19),

-- P20 (correcta en posición 3)
(58, 'Tienen una sintaxis más corta', 1, 3, 20),
(59, 'Solo funcionan en Node.js', 0, 1, 20),
(60, 'Siempre son más rápidas', 0, 2, 20),

-- P21 (correcta en posición 2)
(61, 'En callbacks y funciones de arreglo', 1, 2, 21),
(62, 'Solo en declaraciones globales', 0, 1, 21),
(63, 'Solo en archivos HTML', 0, 3, 21),

-- P22 (correcta en posición 2)
(64, 'Manipular elementos HTML', 1, 2, 22),
(65, 'Editar videos', 0, 1, 22),
(66, 'Compilar archivos', 0, 3, 22),

-- P23 (correcta en posición 1)
(67, 'Como un árbol de nodos', 1, 1, 23),
(68, 'Como una lista de correos', 0, 2, 23),
(69, 'Como una base de datos relacional', 0, 3, 23),

-- P24 (correcta en posición 3)
(70, 'document.getElementById()', 1, 3, 24),
(71, 'document.makeId()', 0, 1, 24),
(72, 'window.createId()', 0, 2, 24),

-- P25 (correcta en posición 3)
(73, 'Objetos', 1, 3, 25),
(74, 'Directorios', 0, 1, 25),
(75, 'Imágenes', 0, 2, 25),

-- P26 (correcta en posición 2)
(76, 'Arreglo (array)', 1, 2, 26),
(77, 'Objeto', 0, 1, 26),
(78, 'Función', 0, 3, 26),

-- P27 (correcta en posición 1)
(79, 'numeros[2]', 1, 1, 27),
(80, 'numeros[3]', 0, 2, 27),
(81, 'numeros(3)', 0, 3, 27);
