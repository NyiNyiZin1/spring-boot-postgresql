# Example Implementation of a Spring Boot PostgreSql && JSONB manipulation

## Prerequisites

* JDK 17
* Spring Boot 3.0.2
* this project uses Lombok, so enable annotation processing in your IDE

## Note
* This is call Json Object=> in Student.class jsonObj is json String
* This is call Json String=> in Teacher.class Student is json Object

* {
"id": 3,
"teacherName": "nyi",
"classRoomId": 1,
"student": { //Json Object
"id": 1,
"name": "mg mg",
"classRoomId": 1,
"jsonObj": "{\"jsonString\" : \"json string\"}" // Json String
}
}
