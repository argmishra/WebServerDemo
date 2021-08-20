Tracking web server
==========  
        
## Problem

Implement a small webserver (in Go, Python, or Java). Feel free to use a framework, if desired. 

1. /ping - returns response code 200 and string OK when file /tmp/ok is present, if file is not present returns 503 service unavailable 
2. /img - returns a 1x1 gif image, and log the request. 

Server needs to scale to many concurrent users and be efficient. Propose improvements you'd like to work on and - time permits - implement.

        		
## Solution
1. File present - Implemented 
2. File absent - Implemented
3. Image download - Implemented
4. Actuator end point - Implemented (http://localhost:8080/actuator)
5. Swagger Integration - Implemented (http://localhost:8080/swagger-ui.html)
6. Generic Exception Handling and Validations - Implemented (Refer to java classes)
7. In Memory Database -  Implemented (Refer properties file) 
8. Run Script - Implemented
9. Integration Testing - Implemented
10. Code Coverage - Implemented


```curl
curl -X GET "http://localhost:8080/ping?path=/home/amishra/repo/anurag/a.txt" -H "Content-Type: application/json"

curl -X GET "http://localhost:8080/ping?path=/home/amishra/repo/anurag" -H "Content-Type: application/json"

Open in browser = http://localhost:8080/image
```
