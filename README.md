# PruebaPracticaKonecta

En la carpeta Konecta se encuentra el Backend y en frontKonecta el Frontend.
Tanto en el Backend como en Frontend funcionan de manera local.

Para el Backend se debe cambiar el archivo application.propierties por las conexiones(BD) locales. Adjunto Script de BD

-- Database: appempleados

-- DROP DATABASE IF EXISTS appempleados;

CREATE DATABASE appempleados
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

Las tablas se crearan automaticamente una vez se ejecute el backend.
Dejan la siguiente propiedad tal cual esta:
spring.jpa.hibernate.ddl-auto:update
