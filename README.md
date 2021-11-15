# micronaut-grpc-demo
Aplicação Micronaut GRPC utilizando Kotlin e arquitetura Hexagonal

#Baixando e configurando um container Postgres:

Postgres:

docker run -e "TZ=America/Sao_Paulo" -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=paula@123 -d postgres

PgAdmin:

docker run --name pgadmin -p 15432:80 -e "PGADMIN_DEFAULT_EMAIL=paulocesaaars@gmail.com" -e "PGADMIN_DEFAULT_PASSWORD=paula@123" -d dpage/pgadmin4