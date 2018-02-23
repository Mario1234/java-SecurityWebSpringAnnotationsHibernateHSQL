# java-SecurityWebSpringAnnotationsHibernateHSQL
Antes de realizar este ejercicio realizar el ejercicio java-WebSpringJPAannotationsHibernateHSQL.

Aplicacion web con spring security, anotaciones de spring, spring, hibernate y hsqldb.

Ejecutar consulta SQL:
CREATE TABLE ROL(ID INTEGER PRIMARY KEY,NOMBRE VARCHAR(10),ID_USUARIO INTEGER)
INSERT INTO USUARIO VALUES(0,'James','Bond')
INSERT INTO USUARIO VALUES(1,'mario','ey')
INSERT INTO ROL VALUES(0,'R_NORMAL',0)
INSERT INTO ROL VALUES(1,'R_ESPIA',1)

Asi podremos administrar roles de los usuarios. 
Utiliza el Apellido del usuario como si fuese su contrasenia.

Usa Maven: 
Configurar como proyecto Maven:
Click Derecho->Configure->Convert to Maven Project
Descargar librerias necesarias:
Click Derecho->Maven->Update Project
Para Probarlo:
Click Derecho->Run As->Run Configurations...->Maven build
Goals = tomcat7:run
y click en RUN
