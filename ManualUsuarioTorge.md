
## MANUAL DE USUARIO TORGE

### CONFIGURACION DEL PROYECTO TORGE

<p align="center">
<img src="/resources/manual/logotorgeiconoventana.png" width="300" height="300"/>
</p>

</br>
          
<p>Te presento el configurador de nuestro proyecto. Lo minimo para ejecutar nuestro proyecto de una forma rápida
 y sencilla mientras</p>

#### Paso 1:
<p align="center>
          
<p>Descargar el proyecto de GitHub actualizado de la rama “develop”.</p>
</br>
<p>Enlace del proyecto: https://github.com/AlexisRuiz00/Proyectopsp-grupo1.git</p>

</p>


#### Paso 2:
<p align="center">
#### WAMP SERVER
</p>

<p>
Es necesario esta aplicación ya que es la encargada de gestionar la base de datos de mysql que ya lleva preinstalado. Una vez se haya instalado WAMP, os aparecerá el siguiente icono en la barra de tareas inferior,
  debes de dar click izquierdo al icono y a la opción phpMyAdmin. PhpMyAdmin nos permitirá de manera gráfica acceder a nuestra base de datos mysql, para ello debemos de crear una base de datos llamada “torgeapp” 
  e importar, para importar un archivo sql, se debe de acceder a la pestaña de phpMyAdmin llamada “Importar”.
</p>
<p>
  Cuando nos encontremos allí, deberemos de darle al boton “Seleccionar Archivo” y seleccionamos el archivo sql que se encuentra incluido en nuestro proyecto,
  el cual tendrá todas las tablas de nuestra BD.
</p>

</br>


#### Paso 3:
<p align="center">
#### FILEZILLA
</p>

<p>
La finalidad de este programa, es actuar como servidor FTP para poder transferir archivos de un lugar a otro a través del protocolo FTP. Tendremos que proceder con la instalación de este, una vez finalizado seguiremos
 con la configuración del mismo. Al iniciar la aplicación esta nos preguntará por cual es la dirección IP y el puerto que se desea usar para utilizar el programa, nosotros tendremos que indicar que la ip sea local, es
 decir, localhost y el puerto 14147. 
</p>

<p align="center">
<img src="/resources/manual/initfilezilla.PNG"/>
</p>

<p>Creamos un usuario con una serie de permisos para que pueda acceder al directorio de nuestro pc que le indicaremos a continuación. El usuario debe ser con nombre usuario1 y contraseña usuario1.</p>

<p align="center">
<img src="/resources/manual/usersfilezilla.PNG"/>
</p>

#### Paso 4:

<p align="center">
#### EJERCUTAR PROYECTO INTELLIJ
</p>

<p>
Llegamos al paso final del manual. Solo nos queda abrir los proyecto y configurar el IDE para su correcto funcionamiento. Para ello, tenemos que abrir las dos aplicaciones por separado, la app de server y la app normal (cliente).
Una vez abierto ambos proyectos, nos asegurarmos que el Proyect Estructure esta configurado, para ello:
</p>
<p>
Si pulsamos sobre File -> Project Structure podremos configurar el proyecto tal y como se muestra en las dos siguientes imágenes.
En el apartado Project seleccionamos el SDK 1.8, en ‘Project language level’ seleccionaremos el 8 y definimos la carpeta out.
</p>
<p align="center">
<img src="/resources/manual/estructureserver.PNG"/>
</p>

<br>

<p align="center">
<img src="/resources/manual/estructurecliente.PNG"/>
</p>

#### Paso 5:

<p align="center">
#### EJECUCCIÓN
</p>

<p>
Primero debemos ejecutar el MainServer y posteriormente el MainAPP de la aplicación cliente para un correcto funcionamiento, sino, la aplicacion nos fallará.
</p>

<p>Esto ha sido todo lo necesario para poder utilizar nuestra aplicación, no obstante, cualquier duda</br>
que tenga siempre puede indicárnosla por correo de cualquier integrate del grupo 2.</p>


<p>Muchas gracias. Att Equipo TORGE.</p>
</p>
