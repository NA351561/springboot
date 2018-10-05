first go to directory
open terminal
run--> mvn clean install

run the application
go to app.java
run as java application

in rest client or post man

http://localhost:8080/family/expense
Headers-- content-type:application/json
Body:
{
"mobileNo": 1234567890,
"firstName": "abc",
"lastName": "xyz",
"dob": "797920207000",
"occupation": "project Engineer",
"income": 25586,
"rent": 8500,
"noOfAdults": 2,
"noOfChildren": 1,
"adultExpenses": 5000,
"childExpenses": 1000
}

Response:{"name":"abc","expense":19500.0,"message":"adult expense :5000.0 is greater than average adult expense:200.0"}

http://localhost:8080/family/details
Headers-- content-type:application/json
Body:
{
"mobileNo": 1234567890,
"firstName": "abc",
"lastName": "xyz",
"dob": "797920207000",
"occupation": "project Engineer",
"income": 25586,
"rent": 8500,
"noOfAdults": 2,
"noOfChildren": 1,
"adultExpenses": 5000,
"childExpenses": 1000
}

Response:{"mobileNo":1234567890,"firstName":"abc","lastName":"xyz","dob":"797920207000","occupation":"project Engineer","income":25586.0,"rent":8500.0,"noOfAdults":2,"noOfChildren":1,"adultExpenses":5000.0,"childExpenses":1000.0}
