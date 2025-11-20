------------------------------------------------------------
-- CURSO
------------------------------------------------------------
INSERT INTO curso (id, titulo, descripcion, imagen_url, activo)
VALUES 
(1, 'Curso de JavaScript desde Cero', 
 'Curso introductorio de JavaScript pensado para principiantes, con énfasis en la lógica, estructuras básicas, arrays, funciones, manejo del DOM y buenas prácticas modernas.',
 'https://wallpapers.com/images/featured-small/fondods-de-programacion-en-4k-v5t1j2ccxxojs52q.webp', 
 1);

------------------------------------------------------------
-- MÓDULOS (4 módulos, acomodados a las nuevas lecciones)
------------------------------------------------------------
INSERT INTO modulo (id, titulo, numero_orden, curso_id)
VALUES 
(1, 'Fundamentos de JavaScript', 1, 1),
(2, 'Control de Flujo en JavaScript', 2, 1),
(3, 'Arrays, Fechas y Utilidades', 3, 1),
(4, 'Funciones, Strings y DOM', 4, 1);

------------------------------------------------------------
-- LECCIONES (20 lecciones, acomodadas a los módulos)
------------------------------------------------------------
INSERT INTO leccion (id, titulo, contenido, video_url, intro1, intro2, intro3, numero_orden, modulo_id)
VALUES
-- MÓDULO 1: Fundamentos
(1, '¿Qué es JavaScript?', 
 'En esta lección conocerás qué es JavaScript, para qué se usa en la web y por qué es tan importante en el desarrollo frontend y full stack.',
 'https://www.youtube.com/watch?v=x5YUu0eUc8s&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=1',
 'JavaScript es un lenguaje de programación pensado principalmente para la web.\nSe ejecuta en el navegador y trabaja junto con HTML y CSS para crear páginas completas.\nTen en mente que su objetivo principal es dar interactividad y dinamismo a las páginas web.',
 'Con JavaScript puedes hacer que una página responda a clics, movimientos del mouse y acciones del usuario.\nEsto lo diferencia de HTML y CSS, que se enfocan más en estructura y estilo.\nRecuerda que JavaScript es el encargado de la lógica y el comportamiento en la interfaz.',
 'Actualmente JavaScript se usa tanto en el frontend como en el backend con entornos como Node.js.\nSin embargo, en este curso nos centraremos en su uso dentro del navegador.\nPiensa en JavaScript como la pieza que permite que una página deje de ser estática y se vuelva interactiva.',
 1, 1),

(2, 'Variables y Tipos de Datos en JavaScript', 
 'Aprenderás qué es una variable, cómo declararla y qué tipos de datos básicos maneja JavaScript para almacenar información.',
 'https://www.youtube.com/watch?v=kXMpu07zjN4&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=2',
 'Una variable es como una “caja” donde guardamos información que el programa necesita usar.\nEn JavaScript declaramos variables para almacenar números, textos, valores lógicos y más.\nRecuerda que la idea clave es que una variable sirve para guardar y reutilizar datos.',
 'Entre los tipos de datos primitivos tenemos number, string y boolean, entre otros.\nPor ejemplo, un número como 10 es number, mientras que "Hola" es un string.\nSaber qué tipo de dato estás usando te ayuda a elegir las operaciones correctas.',
 'Conocer los tipos de datos evita errores al comparar o sumar valores.\nNo es lo mismo sumar dos numbers que sumar un number con un string.\nA medida que practiques, identificar rápidamente el tipo de dato te ayudará a razonar mejor sobre el código.',
 2, 1),

(3, 'Asignación, console.log y typeof en JavaScript', 
 'En esta lección verás cómo asignar valores a variables, cómo mostrar información en la consola y cómo averiguar el tipo de dato con typeof.',
 'https://www.youtube.com/watch?v=b5JnlnSLY8g&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=3',
 'El operador "=" se utiliza para asignar un valor a una variable ya declarada.\nPor ejemplo, con x = 5 estamos guardando el número 5 dentro de la variable x.\nTen claro que "=" aquí no compara, sino que guarda o actualiza el valor.',
 'console.log es una herramienta básica para depurar y entender qué está pasando en tu programa.\nAl usar console.log(x) puedes ver en la consola el valor actual de una variable.\nEsto te ayuda a responder preguntas como “¿qué valor tiene esta variable en este momento?”.',
 'El operador typeof te devuelve el tipo de dato de una variable o expresión.\nPor ejemplo, typeof 10 devuelve "number" y typeof "hola" devuelve "string".\nUsar typeof es útil para confirmar qué tipo de dato estás manejando antes de operar con él.',
 3, 1),

(4, '¿Cuál es la diferencia entre var, let y const en JavaScript?', 
 'Aprenderás las diferencias entre var, let y const, y cuándo conviene usar cada una para escribir código más seguro y ordenado.',
 'https://www.youtube.com/watch?v=a8SJJPvkGIE&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=4',
 'var fue la forma clásica de declarar variables en JavaScript durante muchos años.\nSin embargo, var tiene un alcance más amplio y puede provocar comportamientos inesperados.\nPor eso, en código moderno se recomienda evitar var cuando sea posible.',
 'let se usa para declarar variables cuyo valor puede cambiar.\nTiene alcance de bloque, lo que significa que solo existe dentro de las llaves donde se declara.\nEsto hace el código más predecible y ayuda a evitar errores de redeclaración.',
 'const se utiliza cuando el valor no debería cambiar una vez asignado.\nTambién tiene alcance de bloque y es muy común en código moderno.\nEn general, se recomienda usar const por defecto y let solo cuando necesites reasignar el valor.',
 4, 1),

(5, 'Operadores en JavaScript', 
 'En esta lección verás operadores aritméticos, de comparación y lógicos, que se usan para calcular, comparar valores y construir condiciones.',
 'https://www.youtube.com/watch?v=A9TBH7tKwVk&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=5',
 'Los operadores aritméticos como +, -, * y / permiten hacer operaciones matemáticas básicas.\nPor ejemplo, 2 + 3 devuelve 5 y 10 / 2 devuelve 5.\nCada vez que necesites calcular algo, seguramente usarás un operador aritmético.',
 'Los operadores de comparación como ===, > o <= devuelven true o false.\nPor ejemplo, 5 === 5 es true, mientras que 5 === "5" es false.\nEstos operadores son la base de las condiciones dentro de if y otros controles de flujo.',
 'Los operadores lógicos como &&, || y ! permiten combinar varias condiciones.\nCon && todas las condiciones deben ser verdaderas; con || basta con que una lo sea.\nAprender a combinarlos te permitirá crear decisiones más complejas en tu código.',
 5, 1),

-- MÓDULO 2: Control de flujo
(6, 'Condicionales if + else en JavaScript', 
 'Aprenderás a tomar decisiones en tu código usando if y else, y a ejecutar diferentes bloques según se cumplan o no ciertas condiciones.',
 'https://www.youtube.com/watch?v=XYs3nHEKfeY&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=7',
 'Una estructura if evalúa una condición que debe devolver true o false.\nSi la condición es verdadera, se ejecuta el bloque de código dentro del if.\nEsto permite que el programa responda de forma distinta según los datos que reciba.',
 'La parte else se ejecuta cuando la condición del if no se cumple.\nEs decir, else representa el camino alternativo cuando la condición es falsa.\nGracias a if y else, puedes cubrir tanto el caso positivo como el caso contrario.',
 'Las condicionales son esenciales para decidir qué hacer en cada situación.\nPor ejemplo, puedes mostrar un mensaje distinto si el usuario está logueado o no.\nMientras más practiques, más natural será pensar en problemas como “si pasa esto, hago esto otro”.',
 1, 2),

(7, 'Switch en JavaScript', 
 'Verás cómo usar la sentencia switch cuando tienes muchos casos que comparar sobre un mismo valor, haciendo el código más ordenado que múltiples if.',
 'https://www.youtube.com/watch?v=fP-5psZySBA&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=8',
 'switch evalúa una expresión, por ejemplo una variable o una opción elegida por el usuario.\nLuego compara ese valor con distintos casos definidos dentro de la estructura.\nCuando encuentra un caso que coincide, ejecuta el bloque de código asociado.',
 'En cada caso suele usarse la palabra clave break.\nbreak detiene la ejecución del switch para que no se sigan ejecutando otros casos.\nSi olvidamos el break, el programa puede seguir ejecutando los siguientes casos incluso sin coincidir.',
 'El caso default se ejecuta cuando ninguno de los casos coincide con el valor evaluado.\nEs una forma de manejar situaciones “por defecto” o valores inesperados.\nAsí te aseguras de que siempre haya un comportamiento aunque el valor no esté contemplado.',
 2, 2),

(8, 'Estructura repetitiva while en JavaScript', 
 'En esta lección aprenderás el ciclo while, que repite un bloque de código mientras una condición se mantenga verdadera.',
 'https://www.youtube.com/watch?v=JHC2HNKkHd4&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=10',
 'El ciclo while revisa una condición antes de ejecutar el bloque.\nSi la condición es verdadera, se ejecuta el bloque de código.\nLuego vuelve a comprobar la condición para decidir si repite o no.',
 'Es muy importante actualizar dentro del while las variables que intervienen en la condición.\nSi la condición nunca cambia, el ciclo puede volverse infinito.\nPor ejemplo, contar hacia arriba o hacia abajo ayuda a que en algún momento la condición deje de cumplirse.',
 'while es útil cuando no sabemos cuántas veces se repetirá la acción.\nPor ejemplo, leer datos hasta que el usuario ingrese un valor específico.\nAsí el programa se mantiene repitiendo mientras se cumpla una condición concreta.',
 3, 2),

(9, 'Estructura repetitiva for en JavaScript', 
 'Aprenderás el ciclo for, muy usado para recorrer rangos de números o recorrer arrays de manera controlada.',
 'https://www.youtube.com/watch?v=-0t2bLM4SD4&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=11',
 'El for reúne en una sola línea la inicialización, la condición y la actualización.\nPor ejemplo: for (let i = 0; i < 10; i++) recorre números del 0 al 9.\nEsto lo hace muy claro para repeticiones contadas.',
 'Dentro del for, la variable de índice cambia en cada iteración.\nEsa variable suele usarse para acceder a posiciones de un array o para armar textos.\nLa condición decide cuándo el ciclo debe detenerse.',
 'El ciclo for es especialmente útil para trabajar con arrays.\nPuedes recorrer todos los elementos de una lista usando el índice.\nAsí puedes procesar, mostrar o modificar cada elemento del array de manera ordenada.',
 4, 2),

(10, 'Estructura repetitiva do...while en JavaScript', 
 'Verás el ciclo do...while, que garantiza que el bloque de código se ejecute al menos una vez antes de comprobar la condición.',
 'https://www.youtube.com/watch?v=y5zeqdSafPo&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=12',
 'En do...while primero se ejecuta el bloque de código.\nSolo después de ejecutarlo se evalúa la condición asociada.\nSi la condición es verdadera, el ciclo se repite; si no, se detiene.',
 'Esta estructura es útil cuando necesitamos que algo ocurra mínimo una vez.\nPor ejemplo, mostrar siempre un menú al usuario y luego decidir si repetir.\nA diferencia de while, aquí la primera ejecución no depende de la condición.',
 'Aunque se parece a while, el orden de evaluación marca la diferencia.\nRecuerda: while comprueba primero y do...while ejecuta primero.\nSi necesitas garantizar una primera ejecución, do...while es una buena opción.',
 5, 2),

-- MÓDULO 3: Arrays, fechas y utilidades
(11, 'Alert, Confirm y Prompt en JavaScript', 
 'En esta lección conocerás las funciones alert, confirm y prompt, que permiten mostrar mensajes y pedir datos simples al usuario en el navegador.',
 'https://www.youtube.com/watch?v=75zUnuLtmUY&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=15',
 'alert muestra una ventana emergente con un mensaje y un botón de aceptar.\nSe usa para comunicar algo básico al usuario, como un aviso o una alerta.\nNo devuelve un valor útil, solo muestra información.',
 'confirm muestra un cuadro con un mensaje y dos botones: Aceptar y Cancelar.\nEsta función devuelve true si el usuario acepta y false si cancela.\nEs muy útil cuando necesitas una confirmación rápida antes de continuar.',
 'prompt permite mostrar un mensaje y un campo de texto para que el usuario escriba algo.\nLa función devuelve el texto ingresado o null si se cancela.\nEs ideal para hacer pruebas sencillas o pedir datos muy básicos sin crear formularios.',
 1, 3),

(12, 'Manejo de fechas en JavaScript', 
 'Aprenderás a usar el objeto Date para trabajar con fechas y horas, y a obtener información como año, mes y día.',
 'https://www.youtube.com/watch?v=SqmjZcx9xn4&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=16',
 'El objeto Date representa un instante específico en el tiempo.\nCon new Date() puedes obtener la fecha y hora actual.\nTambién puedes crear fechas pasando parámetros como año, mes y día.',
 'Existen métodos como getFullYear, getMonth y getDate.\nEstos métodos te permiten leer partes concretas de la fecha.\nPor ejemplo, getFullYear te da el año completo y getMonth el mes (empezando en 0).',
 'Trabajar con fechas es útil para mostrar horarios, vencimientos o registros.\nTambién puedes comparar fechas para saber si algo está antes o después.\nAunque Date puede parecer complejo al inicio, dominar lo básico ya te permite hacer mucho.',
 2, 3),

(13, 'Arrays en JavaScript - Parte 1', 
 'Conocerás qué es un array, cómo se declara y cómo almacenar múltiples valores en una sola variable.',
 'https://www.youtube.com/watch?v=Kgl6XMs_CR8&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=19',
 'Un array es una lista ordenada de elementos.\nCada elemento se guarda en una posición identificada por un índice numérico.\nEsto permite almacenar muchos valores relacionados dentro de una misma variable.',
 'En JavaScript, los índices de los arrays empiezan en 0.\nEs decir, el primer elemento está en la posición 0, el segundo en la 1 y así sucesivamente.\nRecordar esto es clave para responder preguntas sobre posiciones.',
 'Los arrays facilitan trabajar con colecciones de datos como listas de nombres o productos.\nEn lugar de crear muchas variables, guardas todo en un solo array.\nDespués podrás recorrerlo y operar con cada uno de sus elementos.',
 3, 3),

(14, 'Arrays en JavaScript - Parte 2', 
 'Seguirás profundizando en arrays viendo cómo agregar, eliminar y modificar elementos dentro de la colección.',
 'https://www.youtube.com/watch?v=JZJ2F0IthMQ&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=20',
 'Para agregar elementos al final del array se usa normalmente el método push.\nPor ejemplo, miArray.push(10) añade el valor 10 al final de la lista.\nCada vez que agregas un elemento, la longitud del array aumenta.',
 'Para cambiar un valor en una posición concreta, se accede por índice.\nPor ejemplo, miArray[1] = 50 reemplaza el valor en el índice 1 por 50.\nAsí puedes actualizar datos sin recrear todo el array.',
 'También es importante entender que la propiedad length indica cuántos elementos hay.\nAl agregar elementos, length crece; al eliminar, puede disminuir.\nConocer estos detalles te ayuda a controlar mejor el contenido del array.',
 4, 3),

(15, 'Arrays en JavaScript - Parte 3: Recorridos', 
 'En esta lección trabajarás distintos recorridos de arrays, entendiendo cómo acceder a cada elemento con ciclos.',
 'https://www.youtube.com/watch?v=lynYZc6KJjs&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=21',
 'Un uso muy común del ciclo for es recorrer arrays.\nNormalmente se inicia el índice en 0 y se detiene cuando llega a length.\nEn cada vuelta del ciclo se accede al elemento correspondiente usando el índice.',
 'Recorrer un array significa visitar cada posición una por una.\nEsto te permite leer, mostrar o modificar los valores que contiene.\nPor ejemplo, puedes sumar todos los números de un array usando un recorrido.',
 'Entender los recorridos es clave para procesar listas de datos.\nCombinar for con arrays te dará mucha flexibilidad para resolver problemas.\nPronto verás que esta técnica aparece en casi todos los ejercicios de lógica.',
 5, 3),

(16, 'Métodos de arrays en JavaScript', 
 'Aprenderás métodos importantes como push, pop, shift, unshift y otros que facilitan el trabajo con arrays.',
 'https://www.youtube.com/watch?v=BxGRts-WLgM&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=22',
 'push agrega uno o varios elementos al final del array y devuelve la nueva longitud.\npop elimina el último elemento y lo devuelve al llamante.\nAmbos métodos trabajan con el “final” de la lista.',
 'shift elimina el primer elemento del array.\nunshift agrega uno o varios elementos al inicio.\nEstos métodos permiten manejar también el principio de la lista de forma fácil.',
 'En general, los métodos de array encapsulan operaciones frecuentes.\nGracias a ellos escribes menos código para tareas como agregar o quitar elementos.\nSaber qué hace cada uno te ayuda a elegir la herramienta adecuada para cada problema.',
 6, 3),

-- MÓDULO 4: Funciones, strings y DOM
(17, 'Funciones en JavaScript', 
 'En esta lección verás qué es una función, cómo declararla y cómo reutilizar código llamando a la misma lógica varias veces.',
 'https://www.youtube.com/watch?v=aYdvt6myUkc&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=23',
 'Una función es un bloque de código que realiza una tarea específica.\nSe define una vez, pero se puede llamar muchas veces desde diferentes partes del programa.\nEsto evita repetir el mismo código una y otra vez.',
 'Las funciones pueden recibir parámetros.\nLos parámetros son valores de entrada que la función utiliza para trabajar.\nAl cambiar los parámetros, la misma función puede producir resultados distintos.',
 'La palabra clave return se usa para indicar el resultado de la función.\nEl valor devuelto puede guardarse en una variable o usarse directamente en expresiones.\nEntender bien return te ayudará a razonar qué “sale” de cada función.',
 1, 4),

(18, 'Métodos de strings en JavaScript - Parte 1', 
 'Conocerás métodos básicos para trabajar con strings, como obtener su longitud y transformar texto.',
 'https://www.youtube.com/watch?v=JW6v7K2Jo98&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=25',
 'Un string es una cadena de texto, por ejemplo un nombre o un mensaje.\nEn JavaScript se representa entre comillas simples o dobles.\nSon muy usados para mostrar información al usuario.',
 'La propiedad length te dice cuántos caracteres tiene un string.\nEsto incluye letras, números, espacios y símbolos.\nEs muy útil cuando necesitas validar la cantidad de caracteres que ingresó el usuario.',
 'Métodos como toUpperCase y toLowerCase permiten cambiar todo el texto a mayúsculas o minúsculas.\nEstos métodos no modifican el string original, sino que devuelven uno nuevo.\nSon ideales para formatear texto antes de compararlo o guardarlo.',
 2, 4),

(19, 'Métodos de strings en JavaScript - Parte 2', 
 'Seguirás explorando métodos de strings para buscar, reemplazar y extraer partes del texto.',
 'https://www.youtube.com/watch?v=IX7KehpCSjs&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=26',
 'Métodos como indexOf e includes ayudan a saber si una palabra aparece dentro de un texto.\nindexOf devuelve la posición donde empieza la subcadena o -1 si no la encuentra.\nincludes devuelve true si la subcadena está presente y false si no lo está.',
 'El método replace permite sustituir una parte del texto por otra.\nPor ejemplo, puedes cambiar una palabra por otra dentro de una frase.\nEsto es útil cuando necesitas corregir o normalizar cadenas antes de mostrarlas.',
 'Métodos como slice o substring sirven para extraer una parte del string.\nRecibes un nuevo texto que contiene solo el fragmento que te interesa.\nEsta técnica es muy usada para trabajar con códigos, fechas en texto u otros formatos.',
 3, 4),

(20, '¿Qué es el DOM?', 
 'En esta lección conocerás el DOM, la representación de la página web como un árbol de nodos que JavaScript puede manipular.',
 'https://www.youtube.com/watch?v=4ILE0y58J00&list=PLQxX2eiEaqbwnzKnmqHDl0rkRvp_T7Q_W&index=28',
 'El DOM es una forma en que el navegador representa internamente el documento HTML.\nCada etiqueta se convierte en un nodo dentro de un árbol.\nGracias a esto, JavaScript puede acceder a los elementos y modificarlos.',
 'Trabajar con el DOM te permite cambiar texto, atributos y estilos desde JavaScript.\nPor ejemplo, puedes actualizar el contenido de un párrafo o cambiar el color de un botón.\nEsto hace posible que la página reaccione a las acciones del usuario.',
 'Funciones como document.getElementById permiten obtener elementos específicos.\nUna vez que tienes la referencia a un elemento, puedes cambiar sus propiedades.\nEntender este flujo será clave para crear interfaces dinámicas en tus proyectos.',
 4, 4);

------------------------------------------------------------
-- PREGUNTAS (3 por lección = 60 preguntas)
------------------------------------------------------------
INSERT INTO pregunta (id, enunciado, explicacion, numero_orden, leccion_id)
VALUES
-- LECCIÓN 1: ¿Qué es JavaScript?
(1, 'JavaScript se usa principalmente para:', 
 'JavaScript nació para agregar interactividad y comportamiento dinámico a las páginas web dentro del navegador.', 
 1, 1),
(2, 'En el contexto de la web, JavaScript se considera:', 
 'Dentro del navegador, JavaScript actúa como el lenguaje de programación que aporta lógica a la interfaz de usuario.', 
 2, 1),
(3, 'Una característica importante de JavaScript es que:', 
 'JavaScript permite reaccionar a eventos como clics, movimientos del mouse o entradas de teclado, haciendo la página más viva.', 
 3, 1),

-- LECCIÓN 2: Variables y tipos de datos
(4, 'Una variable en JavaScript sirve para:', 
 'Las variables son contenedores donde guardamos información que el programa necesita usar o modificar.', 
 1, 2),
(5, '¿Cuál de los siguientes es un tipo de dato primitivo en JavaScript?', 
 'Los tipos primitivos incluyen valores básicos que no son colecciones, como number, string o boolean.', 
 2, 2),
(6, '¿Por qué es importante conocer los tipos de datos?', 
 'Entender los tipos ayuda a evitar errores al operar valores y facilita leer el código de otros desarrolladores.', 
 3, 2),

-- LECCIÓN 3: Asignación, console.log y typeof
(7, 'El operador "=" en JavaScript se usa principalmente para:', 
 'El operador de asignación "=" se emplea para guardar un valor dentro de una variable declarada.', 
 1, 3),
(8, 'console.log en JavaScript sirve para:', 
 'console.log imprime información en la consola del navegador, ideal para debug y para entender qué está haciendo el código.', 
 2, 3),
(9, 'El operador typeof permite:', 
 'typeof devuelve un string que describe el tipo de dato de una variable o expresión en tiempo de ejecución.', 
 3, 3),

-- LECCIÓN 4: var, let y const
(10, 'Una diferencia clave entre var y let es que:', 
 'let tiene alcance de bloque y ayuda a evitar errores de redeclaración y de alcance que son comunes con var.', 
 1, 4),
(11, 'const se utiliza cuando:', 
 'const se usa cuando el valor de la referencia no debería cambiar durante la ejecución del programa.', 
 2, 4),
(12, 'En código moderno de JavaScript se recomienda principalmente usar:', 
 'En JavaScript moderno se prefieren let y const porque ofrecen un manejo de alcance más predecible.', 
 3, 4),

-- LECCIÓN 5: Operadores
(13, 'Los operadores aritméticos en JavaScript se utilizan para:', 
 'Con ellos puedes realizar operaciones matemáticas como suma, resta, multiplicación y división.', 
 1, 5),
(14, 'Un operador de comparación como "===" devuelve:', 
 'Los operadores de comparación devuelven un valor booleano que indica si la comparación es verdadera o falsa.', 
 2, 5),
(15, 'Los operadores lógicos como && y || se usan para:', 
 'Estos operadores permiten combinar varias condiciones en una sola expresión lógica dentro de un if u otra estructura.', 
 3, 5),

-- LECCIÓN 6: Condicionales if/else
(16, 'La estructura if se utiliza para:', 
 'if evalúa una condición y solo ejecuta su bloque de código cuando el resultado es verdadero.', 
 1, 6),
(17, 'La parte else de un if se ejecuta cuando:', 
 'else representa el camino alternativo que se toma si la condición del if resulta falsa.', 
 2, 6),
(18, '¿Por qué son importantes las condicionales en un programa?', 
 'Las condicionales permiten que el programa tome decisiones diferentes según los datos, creando lógica más realista.', 
 3, 6),

-- LECCIÓN 7: Switch
(19, 'La sentencia switch es especialmente útil cuando:', 
 'switch simplifica el código cuando se compara el mismo valor contra muchos casos posibles.', 
 1, 7),
(20, 'Dentro de un switch, la palabra clave break sirve para:', 
 'break evita que se sigan ejecutando los casos posteriores una vez que se encontró el caso correcto.', 
 2, 7),
(21, 'El caso default en un switch se usa para:', 
 'default se ejecuta cuando ninguno de los casos definidos coincide con el valor evaluado.', 
 3, 7),

-- LECCIÓN 8: while
(22, 'El ciclo while repite un bloque de código mientras:', 
 'while vuelve a ejecutar su bloque siempre que la condición se mantenga verdadera.', 
 1, 8),
(23, 'Un riesgo común al usar while es:', 
 'Si la condición nunca se vuelve falsa, el programa puede quedar atrapado en un bucle infinito.', 
 2, 8),
(24, '¿Qué se suele hacer dentro de un while para evitar bucles infinitos?', 
 'Normalmente se actualizan variables relacionadas con la condición para que en algún momento deje de cumplirse.', 
 3, 8),

-- LECCIÓN 9: for
(25, 'El ciclo for se caracteriza por:', 
 'for agrupa inicialización, condición y actualización en una sola línea, ideal para repeticiones contadas.', 
 1, 9),
(26, 'Una forma típica de usar for es para:', 
 'for se usa mucho para ejecutar un bloque de código un número fijo de veces, como recorrer un rango de índices.', 
 2, 9),
(27, '¿Por qué es tan usado el for con arrays?', 
 'Porque permite recorrer cada posición del array usando el índice dentro del cuerpo del ciclo.', 
 3, 9),

-- LECCIÓN 10: do...while
(28, 'La principal diferencia entre while y do...while es que:', 
 'do...while ejecuta el bloque al menos una vez antes de comprobar la condición.', 
 1, 10),
(29, 'El ciclo do...while es útil cuando:', 
 'Se necesita que el usuario o el programa realice una acción al menos una vez antes de decidir si repetir.', 
 2, 10),
(30, 'En un do...while, la condición se evalúa:', 
 'En do...while la condición se evalúa después de ejecutar el bloque de código.', 
 3, 10),

-- LECCIÓN 11: alert, confirm y prompt
(31, 'La función alert se utiliza para:', 
 'alert muestra un mensaje sencillo al usuario en una ventana emergente.', 
 1, 11),
(32, 'La función confirm devuelve:', 
 'confirm devuelve un valor booleano según la elección del usuario en el cuadro de diálogo.', 
 2, 11),
(33, 'La función prompt permite:', 
 'prompt muestra un cuadro de texto donde el usuario puede escribir información que el programa puede leer.', 
 3, 11),

-- LECCIÓN 12: Manejo de fechas
(34, 'El objeto Date en JavaScript sirve para:', 
 'Date representa fechas y horas, permitiendo trabajar con tiempo dentro del programa.', 
 1, 12),
(35, 'Para obtener la fecha y hora actual, se suele:', 
 'Crear una nueva instancia de Date sin parámetros devuelve la fecha y hora actual del sistema.', 
 2, 12),
(36, 'Métodos como getFullYear y getMonth se usan para:', 
 'Estos métodos permiten leer partes específicas de la fecha almacenada en el objeto Date.', 
 3, 12),

-- LECCIÓN 13: Arrays Parte 1
(37, 'Un array en JavaScript es:', 
 'Un array es una estructura que almacena una colección de elementos ordenados y accesibles por índice.', 
 1, 13),
(38, 'El primer elemento de un array se encuentra en el índice:', 
 'Los índices de un array en JavaScript empiezan en cero.', 
 2, 13),
(39, '¿Por qué es útil usar arrays?', 
 'Permiten manejar listas de datos relacionados de forma compacta y ordenada en una sola variable.', 
 3, 13),

-- LECCIÓN 14: Arrays Parte 2
(40, 'Para agregar un elemento al final de un array se usa normalmente:', 
 'push añade un nuevo elemento al final del array y actualiza su longitud.', 
 1, 14),
(41, 'Para modificar un elemento en una posición concreta del array, se suele:', 
 'Se accede al índice deseado y se asigna un nuevo valor a esa posición.', 
 2, 14),
(42, '¿Qué ocurre con la longitud del array cuando se agregan elementos?', 
 'Cada vez que se agrega un elemento nuevo, la propiedad length aumenta en uno.', 
 3, 14),

-- LECCIÓN 15: Arrays Parte 3 - Recorridos
(43, 'Un uso típico del for con arrays es:', 
 'for se usa para visitar cada índice del array y procesar su elemento.', 
 1, 15),
(44, 'En un recorrido de array, la variable de índice suele:', 
 'La variable de índice recorre valores desde cero hasta la longitud del array menos uno.', 
 2, 15),
(45, 'Recorrer un array permite:', 
 'Procesar, mostrar o transformar los datos almacenados en cada posición del array.', 
 3, 15),

-- LECCIÓN 16: Métodos de arrays
(46, 'El método push en un array sirve para:', 
 'push agrega uno o varios elementos al final del array, devolviendo la nueva longitud.', 
 1, 16),
(47, 'El método pop realiza la operación de:', 
 'pop elimina el último elemento del array y lo devuelve como resultado.', 
 2, 16),
(48, 'Los métodos de array ayudan a:', 
 'Abstraer operaciones comunes sobre listas para escribir menos código y de forma más clara.', 
 3, 16),

-- LECCIÓN 17: Funciones
(49, 'Una función en JavaScript se puede describir como:', 
 'Una función agrupa instrucciones que pueden reutilizarse simplemente llamando a su nombre.', 
 1, 17),
(50, 'Los parámetros de una función sirven para:', 
 'Permiten que la función reciba valores externos y trabaje con ellos internamente.', 
 2, 17),
(51, 'La palabra clave return permite:', 
 'return indica qué valor devuelve la función al lugar donde fue llamada.', 
 3, 17),

-- LECCIÓN 18: Métodos de strings Parte 1
(52, 'Un string en JavaScript representa:', 
 'Un string representa una cadena de texto, como nombres, mensajes o cualquier información textual.', 
 1, 18),
(53, 'La propiedad length de un string indica:', 
 'length dice cuántos caracteres tiene el string, incluyendo espacios.', 
 2, 18),
(54, 'Métodos como toUpperCase y toLowerCase sirven para:', 
 'Estos métodos permiten transformar todo el texto a mayúsculas o minúsculas.', 
 3, 18),

-- LECCIÓN 19: Métodos de strings Parte 2
(55, 'Un uso común de indexOf o includes es:', 
 'Se usan para comprobar si una subcadena está presente dentro de un string.', 
 1, 19),
(56, 'El método replace permite:', 
 'replace toma una parte del texto y la sustituye por otra.', 
 2, 19),
(57, 'Métodos como slice o substring sirven para:', 
 'slice y substring permiten extraer una parte del texto original sin modificarlo.', 
 3, 19),

-- LECCIÓN 20: ¿Qué es el DOM?
(58, 'El DOM se puede definir como:', 
 'El DOM es la representación del documento HTML como un árbol de nodos que el navegador expone a JavaScript.', 
 1, 20),
(59, 'Una ventaja de trabajar con el DOM es que:', 
 'Permite cambiar dinámicamente el contenido y los estilos de la página desde JavaScript.', 
 2, 20),
(60, 'document.getElementById se utiliza para:', 
 'Este método devuelve la referencia a un elemento del DOM que tenga un id concreto.', 
 3, 20);

------------------------------------------------------------
-- OPCIONES (3 por pregunta = 180, con respuestas correctas en posiciones variadas)
------------------------------------------------------------
INSERT INTO opcion (id, texto, correcta, numero_orden, pregunta_id)
VALUES
-- P1
(1, 'Dar interactividad y dinamismo a las páginas web', 1, 1, 1),
(2, 'Diseñar exclusivamente la apariencia con estilos', 0, 2, 1),
(3, 'Administrar bases de datos en el servidor', 0, 3, 1),

-- P2
(4, 'Un lenguaje de programación orientado a la web', 1, 2, 2),
(5, 'Un editor de código integrado en el navegador', 0, 1, 2),
(6, 'Un sistema operativo para móviles', 0, 3, 2),

-- P3
(7, 'Puede responder a eventos del usuario como clics y teclas', 1, 3, 3),
(8, 'Solo sirve para mostrar texto estático', 0, 1, 3),
(9, 'Se usa únicamente para crear bases de datos', 0, 2, 3),

-- P4
(10, 'Guardar y manejar datos que el programa necesita', 1, 1, 4),
(11, 'Crear automáticamente estilos CSS', 0, 2, 4),
(12, 'Instalar programas en la computadora del usuario', 0, 3, 4),

-- P5
(13, 'number', 1, 3, 5),
(14, 'tabla', 0, 1, 5),
(15, 'ventana', 0, 2, 5),

-- P6
(16, 'Porque permite usar correctamente los valores en operaciones y comparaciones', 1, 2, 6),
(17, 'Porque evita que el navegador muestre la consola', 0, 1, 6),
(18, 'Porque todos los tipos de datos se comportan igual', 0, 3, 6),

-- P7
(19, 'Asignar un valor a una variable', 1, 1, 7),
(20, 'Comparar dos valores', 0, 2, 7),
(21, 'Sumar dos números estrictamente', 0, 3, 7),

-- P8
(22, 'Mostrar información y mensajes en la consola del navegador', 1, 2, 8),
(23, 'Cerrar automáticamente la pestaña actual', 0, 1, 8),
(24, 'Enviar datos al servidor sin permiso', 0, 3, 8),

-- P9
(25, 'Saber qué tipo de dato tiene una variable o expresión', 1, 3, 9),
(26, 'Convertir números a texto siempre', 0, 1, 9),
(27, 'Borrar el contenido de una variable', 0, 2, 9),

-- P10
(28, 'let tiene alcance de bloque y var no', 1, 2, 10),
(29, 'var siempre es más seguro que let', 0, 1, 10),
(30, 'let solo funciona fuera de funciones', 0, 3, 10),

-- P11
(31, 'Cuando el valor no debe cambiar durante la ejecución', 1, 1, 11),
(32, 'Cuando se quiere redeclarar la variable muchas veces', 0, 2, 11),
(33, 'Cuando no importa si el valor se modifica por error', 0, 3, 11),

-- P12
(34, 'let y const en lugar de var', 1, 3, 12),
(35, 'var en todos los casos posibles', 0, 1, 12),
(36, 'Solo var y nunca const', 0, 2, 12),

-- P13
(37, 'Realizar operaciones matemáticas como suma y resta', 1, 1, 13),
(38, 'Definir el estilo visual de los botones', 0, 2, 13),
(39, 'Crear nuevas pestañas en el navegador', 0, 3, 13),

-- P14
(40, 'Un valor booleano: true o false', 1, 2, 14),
(41, 'Siempre un número entero', 0, 1, 14),
(42, 'Un texto con la operación realizada', 0, 3, 14),

-- P15
(43, 'Combinar varias condiciones en una expresión lógica', 1, 3, 15),
(44, 'Dibujar gráficos en pantalla', 0, 1, 15),
(45, 'Crear nuevas variables sin declararlas', 0, 2, 15),

-- P16
(46, 'Ejecutar código solo cuando se cumple una condición', 1, 1, 16),
(47, 'Repetir siempre el mismo código sin condición', 0, 2, 16),
(48, 'Detener por completo el programa', 0, 3, 16),

-- P17
(49, 'Cuando la condición del if resulta falsa', 1, 3, 17),
(50, 'Cuando la condición del if es verdadera', 0, 1, 17),
(51, 'Siempre, sin importar la condición', 0, 2, 17),

-- P18
(52, 'Porque permiten caminos distintos según los datos de entrada', 1, 2, 18),
(53, 'Porque evitan que el código use variables', 0, 1, 18),
(54, 'Porque eliminan la necesidad de ciclos', 0, 3, 18),

-- P19
(55, 'Hay que comparar un mismo valor contra muchos casos', 1, 1, 19),
(56, 'Solo se trabaja con números aleatorios', 0, 2, 19),
(57, 'No existen condiciones ni casos', 0, 3, 19),

-- P20
(58, 'Detener la ejecución de más casos después de uno coincidente', 1, 3, 20),
(59, 'Reiniciar todas las variables del programa', 0, 1, 20),
(60, 'Obligar a ejecutar siempre el caso default', 0, 2, 20),

-- P21
(61, 'Cubrir la situación en que ningún caso coincide', 1, 2, 21),
(62, 'Definir el primer caso obligatorio del switch', 0, 1, 21),
(63, 'Eliminar el valor evaluado', 0, 3, 21),

-- P22
(64, 'Mientras la condición se mantenga verdadera', 1, 1, 22),
(65, 'Mientras la condición nunca se evalúe', 0, 2, 22),
(66, 'Durante un número fijo de 10 repeticiones', 0, 3, 22),

-- P23
(67, 'Que el ciclo nunca termine si la condición no cambia', 1, 2, 23),
(68, 'Que el código no se ejecute ni una sola vez', 0, 1, 23),
(69, 'Que se borren todas las variables', 0, 3, 23),

-- P24
(70, 'Actualizar las variables que intervienen en la condición', 1, 3, 24),
(71, 'Evitar usar condiciones en el ciclo', 0, 1, 24),
(72, 'No modificar nada para que sea más rápido', 0, 2, 24),

-- P25
(73, 'Reunir inicialización, condición y actualización en una sola línea', 1, 1, 25),
(74, 'Ejecutar código sin necesidad de condición', 0, 2, 25),
(75, 'Crear variables globales automáticamente', 0, 3, 25),

-- P26
(76, 'Repetir una acción un número determinado de veces', 1, 2, 26),
(77, 'Mostrar un solo mensaje y terminar', 0, 1, 26),
(78, 'Eliminar todas las variables del programa', 0, 3, 26),

-- P27
(79, 'Recorrer y procesar cada elemento del array', 1, 3, 27),
(80, 'Ignorar por completo el contenido del array', 0, 1, 27),
(81, 'Crear siempre un nuevo array vacío', 0, 2, 27),

-- P28
(82, 'do...while ejecuta primero el bloque y luego evalúa la condición', 1, 1, 28),
(83, 'while siempre se ejecuta al menos una vez', 0, 2, 28),
(84, 'do...while no utiliza condiciones', 0, 3, 28),

-- P29
(85, 'Cuando se quiere ejecutar el código mínimo una vez', 1, 2, 29),
(86, 'Cuando nunca se quiere ejecutar el bloque', 0, 1, 29),
(87, 'Cuando no hay ninguna condición posible', 0, 3, 29),

-- P30
(88, 'Después de ejecutar el bloque de código', 1, 3, 30),
(89, 'Antes de ejecutar el bloque de código', 0, 1, 30),
(90, 'Solo al inicio del programa', 0, 2, 30),

-- P31
(91, 'Mostrar un mensaje informativo al usuario', 1, 1, 31),
(92, 'Pedir un texto escrito por el usuario', 0, 2, 31),
(93, 'Cerrar automáticamente la página web', 0, 3, 31),

-- P32
(94, 'true si el usuario acepta y false si cancela', 1, 2, 32),
(95, 'Un número entero con la cantidad de clics', 0, 1, 32),
(96, 'Siempre una cadena vacía', 0, 3, 32),

-- P33
(97, 'Solicitar un texto y devolverlo como string', 1, 3, 33),
(98, 'Mostrar solo un mensaje sin interacción', 0, 1, 33),
(99, 'Cambiar el color de fondo de la página', 0, 2, 33),

-- P34
(100, 'Trabajar con fechas y horas en el programa', 1, 1, 34),
(101, 'Crear archivos de imagen en el navegador', 0, 2, 34),
(102, 'Instalar actualizaciones del sistema operativo', 0, 3, 34),

-- P35
(103, 'new Date()', 1, 2, 35),
(104, 'getDate()', 0, 1, 35),
(105, 'Date.now() sin más explicación', 0, 3, 35),

-- P36
(106, 'Leer partes específicas como año, mes o día', 1, 3, 36),
(107, 'Borrar por completo la fecha almacenada', 0, 1, 36),
(108, 'Convertir la fecha en un número aleatorio', 0, 2, 36),

-- P37
(109, 'Una colección ordenada de elementos accesibles por índice', 1, 1, 37),
(110, 'Una función que siempre devuelve texto', 0, 2, 37),
(111, 'Una variable que solo guarda un número', 0, 3, 37),

-- P38
(112, 'Índice 0', 1, 2, 38),
(113, 'Índice 1', 0, 1, 38),
(114, 'Índice -1', 0, 3, 38),

-- P39
(115, 'Porque permite manejar muchas piezas de datos como una sola colección', 1, 3, 39),
(116, 'Porque reemplaza por completo a las variables', 0, 1, 39),
(117, 'Porque solo permite guardar un valor', 0, 2, 39),

-- P40
(118, 'push', 1, 1, 40),
(119, 'pop', 0, 2, 40),
(120, 'shift', 0, 3, 40),

-- P41
(121, 'Acceder al índice y asignar un nuevo valor', 1, 2, 41),
(122, 'Crear un nuevo array sin ese índice', 0, 1, 41),
(123, 'Usar pop siempre', 0, 3, 41),

-- P42
(124, 'Aumenta en uno por cada elemento agregado', 1, 3, 42),
(125, 'Se mantiene siempre igual', 0, 1, 42),
(126, 'Disminuye aunque se agreguen elementos', 0, 2, 42),

-- P43
(127, 'Recorrer todas las posiciones del array con un índice', 1, 1, 43),
(128, 'Crear un solo elemento vacío', 0, 2, 43),
(129, 'Eliminar el array en cada iteración', 0, 3, 43),

-- P44
(130, 'Ir cambiando de índice desde 0 hasta length - 1', 1, 2, 44),
(131, 'Mantenerse siempre en el índice 0', 0, 1, 44),
(132, 'Cambiar entre valores negativos', 0, 3, 44),

-- P45
(133, 'Aplicar lógica sobre cada elemento almacenado', 1, 3, 45),
(134, 'Evitar que el programa use datos', 0, 1, 45),
(135, 'Convertir el array siempre en un string', 0, 2, 45),

-- P46
(136, 'Agregar elementos al final del array', 1, 1, 46),
(137, 'Eliminar el primer elemento del array', 0, 2, 46),
(138, 'Ordenar el array automáticamente', 0, 3, 46),

-- P47
(139, 'Quitar el último elemento del array y devolverlo', 1, 2, 47),
(140, 'Agregar un elemento al inicio', 0, 1, 47),
(141, 'Vaciar por completo el array', 0, 3, 47),

-- P48
(142, 'Realizar operaciones comunes sobre listas de forma fácil y legible', 1, 3, 48),
(143, 'Evitar que se puedan modificar arrays', 0, 1, 48),
(144, 'Sustituir por completo el uso de ciclos', 0, 2, 48),

-- P49
(145, 'Un bloque reutilizable de código que realiza una tarea específica', 1, 1, 49),
(146, 'Una variable que cambia de valor constantemente', 0, 2, 49),
(147, 'Un comentario especial dentro del código', 0, 3, 49),

-- P50
(148, 'Permitir que la función reciba valores externos', 1, 2, 50),
(149, 'Eliminar todas las variables globales', 0, 1, 50),
(150, 'Evitar que la función se ejecute', 0, 3, 50),

-- P51
(151, 'Indicar qué valor se devuelve al terminar la función', 1, 3, 51),
(152, 'Detener el navegador por completo', 0, 1, 51),
(153, 'Obligar a la función a no recibir parámetros', 0, 2, 51),

-- P52
(154, 'Texto o cadena de caracteres', 1, 1, 52),
(155, 'Solo números enteros', 0, 2, 52),
(156, 'Archivos binarios', 0, 3, 52),

-- P53
(157, 'La cantidad de caracteres del string', 1, 2, 53),
(158, 'El número de palabras separadas por espacios', 0, 1, 53),
(159, 'El tamaño del archivo en disco', 0, 3, 53),

-- P54
(160, 'Convertir el texto a mayúsculas o minúsculas', 1, 3, 54),
(161, 'Eliminar el string por completo', 0, 1, 54),
(162, 'Convertir el string en un número aleatorio', 0, 2, 54),

-- P55
(163, 'Verificar si una subcadena aparece dentro del texto', 1, 1, 55),
(164, 'Cambiar el color del navegador', 0, 2, 55),
(165, 'Cerrar todas las pestañas', 0, 3, 55),

-- P56
(166, 'Sustituir parte del texto por otra cadena', 1, 2, 56),
(167, 'Cambiar el tipo de dato de número a string', 0, 1, 56),
(168, 'Ejecutar un ciclo for automáticamente', 0, 3, 56),

-- P57
(169, 'Extraer una parte del string original', 1, 3, 57),
(170, 'Eliminar el texto de forma permanente', 0, 1, 57),
(171, 'Convertir el string en un array vacío', 0, 2, 57),

-- P58
(172, 'Una representación del documento HTML como árbol de nodos', 1, 1, 58),
(173, 'Un archivo de imagen de la página', 0, 2, 58),
(174, 'Una base de datos local del navegador', 0, 3, 58),

-- P59
(175, 'Actualizar contenido y estilos desde JavaScript', 1, 2, 59),
(176, 'Impedir que el usuario vea la página', 0, 1, 59),
(177, 'Eliminar el HTML original del servidor', 0, 3, 59),

-- P60
(178, 'Obtener un elemento del DOM usando su atributo id', 1, 3, 60),
(179, 'Crear un nuevo documento HTML vacío', 0, 1, 60),
(180, 'Cerrar la pestaña actual del navegador', 0, 2, 60);
