# UniversityBoot

#### _mvn clean install_
#### _cd rest-application_
#### _./mvnw spring-boot::run_


# __Endpoints__
## lectors
### Get all lectors:
#### GET: http://localhost:8080/lectors/get-all

### Get lector by the nameLector:
#### GET: http://localhost:8080/lectors/lector/get-name

### Get lector by the emailLector:
#### GET: http://localhost:8080/lectors/lector/get-email

### Get lector by the idLector:
#### GET: http://localhost:8080/lectors/lector/{idLector}

### Create new lector :
#### POST: http://localhost:8080/lectors/lector/new
#### for example: @RequestBody {"nameLector": "Mike","loginLector": "mike","passwordLector": "1111","emailLector": "mike@tyson.com"}

### Update lector :
#### PUT: http://localhost:8080/lectors/lector/update
#### for example: @RequestBody {"idLector": "1",""nameLector": "Mike","loginLector": "mike","passwordLector": "1111","emailLector": "mike@tyson.com"}

### Delete lector by idLector :
#### DELETE: http://localhost:8080/lectors/lector/{id}/delete
#### for emample:  http://localhost:8080/lectors/lector/1/delete

### Delete lector by Lector :
#### DELETE: http://localhost:8080/lectors/lector/delete
#### for emample: @RequestBody {"idLector": "1",""nameLector": "Mike","loginLector": "mike","passwordLector": "1111","emailLector": "mike@tyson.com"} 



## Groups
### Get all groups:
#### GET: http://localhost:8080/groups/get-all

### Get all names of the groups:
#### GET: http://localhost:8080/groups/get-all-names

### Get group by the name:
#### GET: http://localhost:8080/groups/group/get-name
#### @RequestParam String name 
#### for example :  http://localhost:8080/groups/group/get-name?name=e1

### Create new group:
#### POST: http://localhost:8080/groups/group/new
#### @RequestBody String newName
#### for example :  e2

### Update group:
#### PUT: http://localhost:8080/groups/group/update
#### @RequestBody List <String> names [{"newName": "?"}, {"oldName": "?""}] 
#### for example :  [{"newName": "q1"}, {"oldName": "e1""}]

### Delete group:
#### DELETE: http://localhost:8080/groups/group/delete
#### @RequestBody String name
#### for example : e1


## ReuestsFromLector
### Get all requests from lector:
#### GET: http://localhost:8080/lectors/lector/{id}/requests/all
#### {id} : idLector
#### for example : http://localhost:8080/lectors/lector/1/requests/all

### Get request from lector:
#### GET: http://localhost:8080/lectors/lector/request/{id}
#### {id} : idRequest
#### for example : http://localhost:8080/lectors/lector/request/12

### Update request from lector:
#### PUT: http://localhost:8080/lectors/lector/request/update
#### @RequestBody:
#### {"idRequest": 6, "group": "e1", "numberOfPairs": "2", "subjectOfLector": "fizo", "idLector": 1, "date": "2022-03-14T17:28:49.263+00:00"}

### Delete request from lector:
#### DELETE: http://localhost:8080/lectors/lector/request/delete
#### @RequestBody:
#### {"idRequest": 6, "group": "e1", "numberOfPairs": "2", "subjectOfLector": "fizo", "idLector": 1, "date": "2022-03-14T17:28:49.263+00:00"}


