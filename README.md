./gradlew clean

./gradlew build --warning-mode all

./gradlew bootRun --warning-mode all --args='--spring.profiles.active=test'

http://localhost:8080/swagger-ui/index.html

--------------------------------------------------


POST http://localhost:8080/customer/

{
"name": "name1",
"surName": "surName1",
"tc": "12345678901",
"cardNo": "12345"
}

GET http://localhost:8080/customer/

GET http://localhost:8080/customer/1

POST http://localhost:8080/payment/
{
"customer": {
"id": 10
},
"amount":122.45
}

GET http://localhost:8080/payment/findAll

GET http://localhost:8080/payment/1

GET http://localhost:8080/payment/findAllByCardNoAndCreatedDateBetween?start=2024-01-01 00:00:00&end=2026-01-01 00:00:00&cardNo=12345

GET http://localhost:8080/payment/findAllByCustomer_CardNo?cardNo=12345

GET http://localhost:8080/payment/findAllByCreatedDateBetween?start=2024-01-01 00:00:00&end=2026-01-01 00:00:00