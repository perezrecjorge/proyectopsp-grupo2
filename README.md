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
> **[3. Actividad 1 y 2](#3):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Título](#4):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Resumen](#5):**<br>
> **[4. Actividad 3](#6):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Diagrama - Casos de uso](#7):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Anexo](#8):**<br>
> **[5. Actividad 4](#9):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Diagrama de Clases](#10):**<br>
> **[&nbsp;&nbsp;&nbsp;&nbsp; Modelo Entidad - Relación](#11):**<br>

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
# ACTIVIDAD 1 Y  2

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
# ACTIVIDAD 3

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

<p align="center">
<img src="/resources/tabla1casosdeuso.PNG"/>
</p>

<br>

<p align="center">
<img src="/resources/tabla2casosdeuso.PNG"/>
</p>

<br>

<p align="center">
<img src="/resources/tabla3casosdeuso.PNG"/>
</p>

<br>

<p align="center">
<img src="/resources/tabla4casosdeuso.PNG"/>
</p>

<br>

<a name="9"></a>
# ACTIVIDAD 4

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


