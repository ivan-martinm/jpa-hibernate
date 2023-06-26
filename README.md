Proyecto de JPA con Hibernate para gestión de un concurso televisivo ficticio, desarrollado como tarea en el módulo de Acceso a datos del ciclo de Desarrollo de Aplicaciones Multiplataforma.

El objetivo del proyecto era el uso de una api de persistencia en Java para, a partir de un modelo entidad-relación previo, confeccionar un diagrama UML y crear la aplicación Java correspondiente.

El modelo entidad-relación original como punto de partida:

![alt text](https://github.com/ivan-martinm/jpa-hibernate/blob/main/imagenes/MER.png?raw=true)

De cara a la implementación del diagrama UML se permitían cambios para adaptar relaciones y adiciones de atributos, y se estableció como requisito obligatorio la implementación del patrón DAO, quedando al final de la siguiente forma:

![alt text](https://github.com/ivan-martinm/jpa-hibernate/blob/main/imagenes/UML.png?raw=true)

El proyecto usa Java 17, Hibernate 6.6.2 y Project Lombok (todas declaradas en el fichero pom.xml). Se incluye también el fichero /src/main/resources/hibernate.cfg.xml con la información necesaria para la conexión a la base de datos (preconfigurado para la creación automática del schema y las tablas al ejecutar la aplicación).

Se usó Mysql como sistema gestor de bases de datos, ejecutado en una instancia de contenedor Docker.