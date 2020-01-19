<p align="center">
<img src="/resources/cabeies5.PNG"/>
</p>

# <p align="center">PROYECTO PSP 19/20</p>
## <p align="center">Torge: Comunicación</p>

<p align="center">
<img src="/resources/comuheader1.png" width="700" height="350"/>
</p>

<br>
<br>

# <p align="center">Índice:</p>
> **[1. Licencia y Autores](#1):**<br>
> **[2. Presentación](#2):**<br>
> **[3. FASE 1: Actividad 1 y 2](#3):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Título](#4):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Resumen](#5):**<br>
> **[4. FASE 1: Actividad 3](#6):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Diagrama - Casos de uso](#7):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Anexo](#8):**<br>
> **[5. FASE 1: Actividad 4](#9):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Diagrama de Clases](#10):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Modelo Entidad - Relación](#11):**<br>
> **[6. FASE 1: Actividad 5](#12):**<br>
> **[7. FASE 2: Actividad 2](#13):**<br>
> **[7. FASE 2: Actividad 3](#14):**<br>

<br>

<a name="1"></a>
# LICENCIA Y AUTORES

Este material ha sido producido por <b>Jorge Perez</b> y <b>Victor Ruiz</b> bajo licencia Creative Commons.  

<br>

<p align="center">
<img src="/resources/LicenciaCC.png" height="40" width="140"/>  
</p>



<br>

<a name="2"></a>
# PRESENTACIÓN
¡Hola! Somos el grupo 2, formado por los alumnos Jorge Perez y Victor Ruiz, 
nos encargaremos de realizar un proyecto de la asignatura de PSP de 2ºDAM 
en el I.E.S Ramón del Valle Inclán.

<br>

<a name="3"></a>
# FASE 1: ACTIVIDAD 1 Y  2

<i>Descripcion de actividad: Definicion del problema. Requisitos funcionales.</i><br>

<a name="4"></a>
### <b>TÍTULO:</b>

*<b>Torge:</b> Comunicación.*

El nombre de nuestra APP nace de la combinacion de los nombres de los desarrolladores.
<p align="center">
	Vic<b>TOR</b> + Jor<b>GE</b> = <b>TORGE</b>
</p>

<a name="5"></a>
### <b> RESUMEN: </b>

Nuestro proyecto se basa en la creación de una aplicación basada en Java, que consiste en la comunicación alumno/profesor y comunicación grupal de clase.

Para la realización de dicha aplicación utilizaremos el entorno de desarrollo IntelliJ, basado en lenguaje Java como hemos mencionado anteriormente.
El diseño de nuestra APP estará basado en la arquitectura MVC (Modelo - Vista - Controlador).

<b>Todo la documentación y desarrollo de la misma estará presente en este repositorio de GitHub.</b>

Los requisitos funcionales que envolveran la APP, asi mismo, que estan requeridos por el profesor y que se realizaran durante curso (Fecha de Entrega preestablecida: 12/Noviembre/2019) son:

*&nbsp;&nbsp;&nbsp;&nbsp;1. La aplicación debe programarse usando hilos, de forma que las funcionalidades a implementar puedan ser ejecutadas de forma concurrente. 
De esta forma, tendremos hilos para la interfaz gräfica, hilos para la comunicación en red, hilos para el acceso a soportes de almacenamiento como ficheros o base de datos, etc.*

*&nbsp;&nbsp;&nbsp;&nbsp;2. Tendrá funcionalidades de red a través de sockets que use los protocolos TCP /UDP. La app permitirá conexiones unicast y multicast. 
Por otra parte, deberás diseñar tu propio protocolo de red para el intercambio de los datos que maneje tu aplicación.*

*&nbsp;&nbsp;&nbsp;&nbsp;3. La aplicación implementará clientes de protocolos standard como correo, FTP etc. Integrará un servidor de chat para la comunicación entre los usuarios. 
Por otra parte, la aplicación deberá implementar un servidor web.*

*&nbsp;&nbsp;&nbsp;&nbsp;4. Por otra parte, habilitaremos nuestra aplicación con una capa de segurdad (criptografia, politica de acceso a usuarios, roles tanto para el acceso a la información como la transmision de la misma).*

*&nbsp;&nbsp;&nbsp;&nbsp;5. Finalmente, nuestra aplicación dispondrá de algún servicio implementado en la nube haciendo uso de la tecnologia de microservicios.*


Por ello, hemos desarrollado un grupo de ideas que pueden llegar a satisfacer dichos requisitos funcionales:

1. Versión de escritorio y otra en red (web).
2. Un formulario de registro de usuario.
3. La comunicación será: 
	- Privada entre alumno y profesor(admin).
	- Pública (y sólo pública) de forma grupal entre los alumnos. 
4. El admin tendrá acceso en cualquier caso de todos los mensajes.
5. El admin recibirá los mensajes y responderá según le parezca. Los que no responda se quedan en espera.
6. Los mensajes que comiencen a redactar los alumnos y no se envíen se guardarán como un borrador. Cada alumno solo podrá guardar dos borradores.
7. La comunicación y los mensajes tendrán un cifrado de extremo a extremo.

<br>

<a name="6"></a>
# FASE 1: ACTIVIDAD 3

<a name="7"></a>
### <b>DIAGRAMA CASOS DE USO</b>

<br>

<p align="center">
<img src="/resources/diagramacasosdeuso.png"/>
</p>

<br>

<a name="8"></a>
### <b>ANEXO</b>

<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-1</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Inicio de sesion.</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>Se abre la pantalla de inicio de sesión para acceder a la cuenta.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Profesor (admin), alumno(s)</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>El usuario se ha registrado previamente.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. Usuario introduce sus datos nombre de usuario y contraseña
2. en los campos correspondientes.<br>
3. Usuario pulsa botón acceder.<br>
4. El sistema valida la cuenta y verifica que existe.<br>
5. El sistema comprueba si el usuario es el administrador o es 6. alumno. Si es profesor, accede a la vista específica de admin.<br>
7. Usuario accede a su cuenta. Podrá visualizar y acceder a: <br>
7.1 Consulta listado de noticias.<br>
7.2 Chat alumno.<br>
7.3 Cuenta bancaria / Excursiones.<br>
7.4 Modificar perfil.<br>
7.5 Crear nueva noticia.
<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El usuario ha iniciado sesión.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Nombre de usuario y/o contraseña erróneo(s). Se vuelve a la pantalla de inicio o se solicita recuperar cuenta.
Usuario no registrado.
</td>

</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-2</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Recuperar cuenta</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>- Se accede a un formulario en el que se pide el correo o algún medio que el usuario pueda verificar para recuperar su cuenta.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Profesor (admin), alumno(s)</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>El usuario se ha registrado previamente.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. Introducir un dato de verificación: correo eléctronico o nº de teléfono.<br>
2. El usuario accede a la vista de recuperación de la cuenta si ha habido un error o no recuerda algún dato o ambos.<br>
3. La persona elige entre el e-mail o teléfono para recibir un código de verificación, que el profesor (admin) tiene que corroborar.<br>
4. En el caso de que sea el Profesor (admin) quien tenga que recuperar su cuenta, lo hará por un medio alternativo que el resto de usuarios.<br>
5. Tras verse cumplido lo anterior, la persona puede cambiar su contraseña.
<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>La persona recupera su cuenta, y vuelve a la vista de inicio de sesión.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Error en el código de recuperación.
Los datos facilitados para la recuperación son erróneos o no corresponden con ninguno de los almacenados en el sistema.

</td>

</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-3</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Registro del usuario</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>- Se accede a un formulario en el que el usuario tiene que aportar datos. Algunos datos son obligatorios, otros no.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td>Profesor (admin), alumno(s)</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>Rellenar, al menos, todos los campos obligatorios.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. El usuario accede a la vista del formulario de registro.<br>
2. El usuario introduce sus datos, se verifica que al menos sean los obligatorios.<br>
3. Se comprueba que no existe ya un usuario en el sistema con igual nick de usuario o correo electrónico.<br>
4. Se comprueba que la contraseña sea una cadena alfanumérica de al menos 8 caracteres.<br>
5. Se accede a la vista del perfil del usuario.<br>

<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>La persona ya tiene una cuenta creada. Se abre la vista de inicio de sesión.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Ya existe un usuario con el mismo nombre o correo electrónico.
Algún campo obligatorio está vacío o tiene datos erróneos. Se vuelve a ese campo para corregirlo.

</td>

</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-4</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Consulta listado de noticias</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>-El o los alumnos acceden al tablón principal de publicaciones.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td> Alumno</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>- Haber iniciado sesión.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. Se abre la vista de publicaciones del profesor.<br>

<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>El sistema carga todas las noticias del profesor.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Los alumnos no pueden visualizar las publicaciones por problemas con el servidor.<br>

</td>

</table>

<br>
<br>


<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-5</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Chat alumno</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>-Sala de chat público con la que los alumnos pueden enviarse mensajes.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td> Alumno</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>- Haber iniciado sesión.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. El alumno entra en el chat grupal.<br>
2. El alumno envía mensajes a sus compañeros y a la vez recibe mensajes de los mismos.
<br>

<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>Los mensajes del chat solo se mostrarán a los alumnos conectados en el chat, y se borrarán al salir de la sesión.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Los mensajes no llegan al usuario alumno (error del servidor).<br>

</td>

</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-6</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Cuenta bancaria excursiones.</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>-Aparece el IBAN de la cuenta a la que hay ingresar el dinero para las excursiones.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td> Alumnos.</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>- Haber iniciado sesión.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. El alumno entra a la vista de cuenta bancaria.<br><br>
2. El alumno pulsa un botón "Ingresar" que aumentará un contador.
	  3. Cuando el contador llegue al nº total de alumnos que van a la excursión, el profesor por su parte podrá pulsar un botón que sea "Pagar Excursión".<br>
<br>

<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>- Se paga la excursión.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Error en el contador de los ingresos.<br>

</td>

</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-7</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Modificar perfil.</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>-Cambiar los datos del perfil del usuario alumno o del profesor (admin).</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td> Profesor (admin), alumno</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>- Haber iniciado sesión.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1. Acceden a la vista de edición de perfil.<br>
2. Modificar los datos que se quiera y guardar cambios
.<br>
<br>

<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>- Actualización directa del perfil del usuario alumno..<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Modificación no permitida.<br>
Error en la actualización del perfil.
<br>

</td>

</table>


</table>

<br>
<br>

<table style="width:100%">
  <tr>
    <td><b>ID: </b></td>
    <td>CU-8</td>
  </tr>
  <tr>
    <td><b>Nombre: </b></td>
    <td>Crear noticia nueva.</td>
  </tr>
  <tr>
    <td><b>Descripción:</b></td>
    <td>-El profesor redacta y publica una noticia para que la vean los alumnos.</td>

  </tr>
  <tr>
    <td><b>Actores:</b></td>
    <td> Profesor (admin).</td>
  </tr>
  <tr>
  <td><b>Precondiciones:</b></td>
  <td>- El profesor inicia sesión.</td>
  </tr>
    <tr>
  <td><b>Curso normal:</b></td>
  <td>1.Accede a la vista del tablón principal.<br>
2.Escribir y publicar noticia.<br>

.<br>
<br>

<br>
  </td>
  </tr>
  <tr>
  <td><b>Postcondiciones:</b></td>
  <td>- Que la noticia se publique correctamente.<br>
Que los alumnos puedan visualizar la noticia publicada
.<br>
  </td>
</td>
  </tr>
  <tr>
  <td><b>Alternativas/Excepciones:</b></td>
  <td>Error en la publicación.
<br>

</td>

</table>

<br>

<a name="9"></a>
# FASE 1: ACTIVIDAD 4

<a name="10"></a>
### <b>DIAGRAMA DE CLASES</b>

<br>

<p align="center">
<img src="/resources/diagramadeclases.png"/>
</p>

<br>

<a name="11"></a>
### <b>MODELO ENTIDAD - RELACION</b>

<br>

<p align="center">
<img src="/resources/modeloER.png"/>
</p>

<br>

<a name="12"></a>
# FASE 1: ACTIVIDAD 5

### <b>VISTA INICIO</b>
<p align="center">
<img src="/resources/vistas/VistaInicio.png"/>
</p>

### <b>VISTA INICIAR SESIÓN</b>
<p align="center">
<img src="/resources/vistas/VistaIniciarSesion.png"/>
</p>

### <b>VISTA REGISTRO</b>
<p align="center">
<img src="/resources/vistas/VistaRegistro.png"/>
</p>

### <b>VISTA MENU PRINCIPAL DE ALUMNOS</b>
<p align="center">
<img src="/resources/vistas/VistaMenuAlumno.png"/>
</p>

### <b>VISTA MENU PRINCIPAL DE PROFESORES</b>
<p align="center">
<img src="/resources/vistas/VistaMenuProfesor.png"/>
</p>

### <b>VISTA NOTICIAS</b>
<p align="center">
<img src="/resources/vistas/VistaNoticias.png"/>
</p>

### <b>VISTA CHAT GRUPAL</b>
<p align="center">
<img src="/resources/vistas/VistaChatGrupal.png"/>
</p>

### <b>VISTA CHAT PRIVADO</b>
<p align="center">
<img src="/resources/vistas/VistaCuentaBancaria.png"/>
</p>

### <b>VISTA MODIFICAR PERFIL</b>
<p align="center">
<img src="/resources/vistas/VistaModificarPerfil.png"/>
</p>

<br>

<a name="13"></a>
# FASE 2: ACTIVIDAD 2

Las partes que requieren la aplicación de hilos son las siguientes: 

&nbsp;&nbsp;&nbsp;&nbsp;<b>CU-4. Consulta de listado de noticias:</b> se realizará mediante hilos normales (clases que extiendan de Thread o implementen Runnable).

&nbsp;&nbsp;&nbsp;&nbsp;<b>CU-5. Chat alumno:</b> el chat grupal de alumnos y profesor se realizará empleando sockets y múltiples hilos. Se creará una clase Profesor desde la que se iniciará el socket del servidor (ServerSocket) y clase  Alumno (Socket) y estos intercambiarán mensajes entre ellos. Se usará el protocolo UDP.

&nbsp;&nbsp;&nbsp;&nbsp;<b>CU-6. Cuenta bancaria excursiones:</b> se realizará mediante la técnica del productor-consumidor. En este caso, habrá múltiples productores (Alumnos) que pulsarán un botón (el recurso a consumir, en este caso se trata de la cola del programa) solo una vez. Cuando todos los alumnos hayan pagado, es decir, todos hayan pulsado el botón, el profesor (consumidor) podrá realizar la acción “Pagar la excursión” pulsando otro botón. Debemos de asegurar que un alumno pueda pulsar el botón una única vez, y por otra parte que la capacidad de la cola sea igual que el nº de alumnos que vayan a asistir a la excursión.

<br>

<a name="14"></a>
# FASE 2: ACTIVIDAD 3

## DESCRIPCION DE CLASES, ATRIBUTOS, METODOS

HOLA

## DIAGRAMAS DE SECUENCIA

### <b>MainApp.start()</b>
<p align="center">
<img src="/resources/diagramasecuencia/mainapp-start.png"/>
</p>

### <b>MainApp.InitRootLayout()</b>
<p align="center">
<img src="/resources/diagramasecuencia/mainapp-initrootlayout.png"/>
</p>

### <b>MainApp.MuestraVistaMenuInicio()</b>
<p align="center">
<img src="/resources/diagramasecuencia/mainapp-muestravistamenuinicio.png"/>
</p>






