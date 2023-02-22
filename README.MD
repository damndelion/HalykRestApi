## crete database

- install docker (https://docs.docker.com/desktop/install/windows-install/)
- pull postgres image `docker pull postgres:12.12`
- run postgres container `docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:12.12`
- create table **User**
- build image from DockerFile `docker build -t halyk-rest-api:1.0 . `
- `docker run -p 8080:8080 halyk-rest-api:1.0`


links:
- https://www.baeldung.com/spring-jdbc-jdbctemplate