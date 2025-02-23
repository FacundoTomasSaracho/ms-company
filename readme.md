# IT Patagonia Technical Challenge

Este repositorio contiene dos microservicios que forman parte de un desafío técnico para IT Patagonia. Los dos microservicios están diseñados para cumplir con la tarea de manejar información de empresas y transacciones financieras de manera separada, permitiendo así una arquitectura limpia y escalable.

## Arquitectura

El proyecto está compuesto por dos microservicios:

- **ms-company**: Este microservicio se encarga de la gestión de las empresas. Contiene la lógica relacionada con las compañías y sus interacciones dentro del sistema.
- **ms-transactions**: Este microservicio maneja las transacciones financieras. La lógica relacionada con las transacciones, como la obtención de transacciones recientes, se encuentra aquí.

### Razón de la separación

Decidí separar la responsabilidad en dos microservicios debido al principio de **arquitectura limpia**. Esto hace que cada microservicio tenga su propio esquema de base de datos y sus propias tablas, lo que facilita el mantenimiento y la escalabilidad del sistema. Al separar estas responsabilidades, se logra una mayor claridad en la arquitectura y se reduce el riesgo de que el sistema se vuelva más complejo con el tiempo, especialmente cuando los microservicios escalen.

## Diseño y Consideraciones Técnicas

- **Bases de datos separadas**: Cada microservicio tiene su propio esquema de base de datos para evitar dependencias innecesarias y facilitar la gestión independiente de cada servicio.
- **Consultas optimizadas**: Las consultas sobre fechas se benefician de índices específicos para acelerar las búsquedas.
- **Comunicaciones entre microservicios**: Para manejar las solicitudes HTTP entre los microservicios, utilicé **Retrofit**. Aunque en una implementación ideal hubiera preferido usar **Feign**, me encontré con problemas de versiones de dependencias y no tuve el tiempo suficiente para solucionarlos.
- **Obtención de transacciones**: El microservicio `ms-company` solicita las transacciones realizadas en el último mes al microservicio `ms-transactions`. Para este propósito, agregué un campo `transaction_date` para permitir el filtrado eficiente de transacciones por fecha. `ms-company` simplemente recibe un `companyId` como respuesta de `ms-transactions`.

## Limitaciones

Debido a restricciones de tiempo, no pude implementar algunas de las siguientes características como me hubiera gustado:

- **Manejo de excepciones**: No implementé un manejo de excepciones robusto en todos los casos.
- **Nombres de clases y variables**: Algunos nombres de clases, métodos y variables podrían no ser tan descriptivos o coherentes como en una implementación final.
- **Tests**: Se incluyeron tests pero no en todas las capas.

A pesar de estas limitaciones, el desafío fue muy interesante, y aunque no era extremadamente complejo, la parte más desafiante fue pensar en la arquitectura adecuada para asegurar que el sistema sea escalable y limpio.

## Tecnologías utilizadas

- **Java** (para los microservicios)
- **Spring Boot** (para la implementación de los microservicios)
- **Retrofit** (para las solicitudes HTTP entre microservicios)
- **MySQL** (como sistema de gestión de bases de datos)
- **JPA/Hibernate** (para la persistencia de datos)


