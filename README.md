# Fly Content / Test
This is an application on spring boot to calculate the rating of content.
  
### Building

On the root of proyect.

- mvn clean install

- docker build -t application .

- docker-compose up

Command to download de rating:

 - docker exec -it my-web-container java -Dspring.main.web-application-type=none -jar /app.jar "NAME_OF_FILE"

> Please, specify name of file to download the file

### URL rest

| Url      | Method |
| ------ | ------ |
| /v1/api/list  | GET |
| /v1/api/export-rating  | GET |