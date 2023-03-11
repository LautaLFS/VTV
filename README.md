# Verificación Técnica Vehicular - README
## Introducción

Este proyecto tiene como objetivo desarrollar un software para la Verificación Técnica Vehicular que permita realizar el control obligatorio periódico del estado mecánico y de emisión de gases contaminantes de los automotores para la prueba tecnica proporcionada por Certant

## Tecnologías utilizadas
Para el desarrollo de este software se utilizó el SDK Java 11 junto con SpringBoot 2.5.1. La documentación de la API se realizó utilizando Swagger y se utilizaron los tests de JUNIT5 para realizar las pruebas correspondientes.

## Estructura del proyecto
Se utilizó el patrón RESTful para la estructura del proyecto, lo que significa que se utilizan URLs para acceder a los diferentes recursos de la aplicación. Los datos se envían y reciben en formato JSON.

## Funcionamiento del software
Existen dos tipos de dueños de vehículo: "común" o "exento". Un dueño de vehículo exento no abona el valor de la inspección.

Para poder establecer que un vehículo finalizó una inspección de la VTV con el estado aprobatorio (apto) se tienen en cuenta dos tipos de controles: basados en observaciones y basados en mediciones.

Las observaciones son el primer paso de una inspección y se relacionan con aquello que un inspector de la VTV puede analizar visualmente: se revisan las luces, patente, espejos, chasis, vidrios y seguridad y emergencia del vehículo.

Las mediciones son determinadas por la maquinaria que evalúa la suspensión, dirección y tren delantero; sistema de frenos y contaminación ambiental.

Una vez que se obtienen todos los datos se determina si un vehículo está: "apto" (si tiene observaciones y mediciones aptas), "condicional" (si tiene por lo menos una observación o medición condicional) o "rechazado" (si tiene por lo menos una observación o medición rechazada).

Un vehículo apto tiene una oblea con validez de un año.

La aplicación permite realizar inspecciones de vehículos y generar los reportes correspondientes. Cada inspección tiene un número de inspección, una fecha de inspección, un estado de inspección, si está o no exento, el inspector a cargo y el automóvil inspeccionado.

Además, la aplicación permite listar al final del día los datos de los autos, con sus respectivos atributos a saber: dominio, marca, modelo y nombre del propietario.
## Base de datos
Se proporciona un script SQL para crear la base de datos utilizada por la aplicación. Para levantar la base de datos con este script, se deben seguir los siguientes pasos:

- Crear una base de datos en un motor de base de datos que soporte SQL. Se recomienda utilizar MySQL o PostgreSQL.
- Ejecutar el script SQL proporcionado en la base de datos creada.
## Levantar la aplicación
Para levantar la aplicación, seguir los siguientes pasos:

1. Descargar o clonar el repositorio.
2. Abrir el proyecto en un IDE que soporte Java y SpringBoot, como por ejemplo Eclipse o IntelliJ IDEA.
3. Configurar la conexión a la base de datos en el archivo application-dev.yaml estableciendo las variables de entorno pertinentes El archivo se encuentra en la ruta src/main/resources
4. Ejecutar la clase "VtvApplication.java" como una aplicación Java.
5. Acceder a la documentación Swagger de la aplicación en la dirección http://localhost:8080/api/v1/swagger-ui.html
## Autor
- Furiasse Lautaro
