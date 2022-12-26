## Exchange Rate Service

Service is responsible for backend part related to exchange rates.

## Built With
- [Java 11](https://docs.oracle.com/javase/11/)
- [Spring Boot Framework](https://spring.io/projects/spring-boot) (2.3.2)

## Setup
### Local environment pre-requirements
- Install Java 11
- Install Maven 3.6+
- Install Docker

## Getting Started
### Initial steps
1. Clone the repository:
```shell script
git clone https://github.com/SN4NTR/ExchangeRateService.git
```
2. Go to folder with project and build it:
```shell script
mvn clean package
```
3. Go to `docker` folder:
```shell script
cd docker
```
4. Start database docker container:
```
docker-compose up -d
```
> **NOTE**: Database credentials are placed in database.env file in docker folder

5. Run application:
```shell script
mvn spring-boot:run -Dspring-boot.run.profiles=local
```
6. Send test request:
```
curl --location --request GET 'http://localhost:8080/exchange-rates' \
--header 'Authorization: Basic dGVzdDp0ZXN0'
```
> **NOTE**: For local env all username = 'test' and password = 'test'.
