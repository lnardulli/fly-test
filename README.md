# Fly Content / Test
This is an application on spring boot to calculate the rating of content.
  
### Building

Being on the root of the project.

#This will compile it using mvn in the first stage and the build the actual image with the jar
```bash
docker build -f Dockerfile.multistage -t fly-ws .
```

#Using docker-compose it'll start a mysql database, import some basic content and run the webserver
```bash
docker-compose up
```

#Command to download the rating. This won't start a ws but just hit and endpoint on the same host.
```bash
docker exec -it fly-ws java -Dspring.main.web-application-type=none -jar /app.jar "$NAME_OF_FILE"
```
> Please, specify a name to the file, ending in .csv, it'll be created in the exports/ dir.

### URL rest

| Url      | Method |
| ------ | ------ |
| /v1/api/list  | GET |
| /v1/api/export-rating  | GET |
