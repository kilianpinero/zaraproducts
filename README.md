
# Zara Products Application

This application is designed to provide a REST endpoint that accepts input parameters and returns product and price information based on data from the PRICES table of a company's e-commerce database.



## Features

The application provides a single REST endpoint that accepts the following input parameters:
- Application date: The date for which price information is requested.
- Product identifier: The unique identifier of the product.
- Brand identifier: The unique identifier of the chain.

The endpoint returns the following output data:
- Product identifier: The unique identifier of the product.
- Brand identifier: The unique identifier of the chain.
- Rate to apply: The identifier of the applicable rate.
- Start Date and End Date: The date range for which the rate applies.
- Final price to apply: The final price to apply.



## Data Access

As requested, spring application uses H2 database. This database takes (on runtime) hardcoded information form schema and data from project files:
- /resources/schema.sql
- /resources/data.sql
## Hexagonal Architecture

I have chosen to use Hexagonal Architecture since is best practice and also I like to have code divided in layers.
Hexagonal architecture separates the core business logic from the infrastructure and delivery mechanisms. This separation makes it easier to maintain and test the application. It promotes separation of concerns, testability, flexibility, and domain-driven design.
## ApiFirst

API First is an approach to software development that involves designing and documenting the API before writing any code.
I have chosen to use ApiFirst because I can ensure that the API meets the requirements of the application and reduce the risk of future misunderstandings.
As you may know, ApiFirst generastes source code that helps future implementation and minimizes errors. 
Specifically, it generates API and MODEL (domain) files. So in this case I only had to create infrastructure and application files. 
## Installation

For building and running the application you need:

- JDK 20
- Maven


Build the project using 
```mvn clean install```

Run using ```mvn spring-boot:run```

The web application is accessible via ```http://localhost:8080```

## API Reference

#### Get products

```http
  GET /api/v1/productprices
```

| Parameter   | Type      | Description                       |
| :---------  | :-------  | :-------------------------------- |
| `ProductId` | `integer` | **Required**. Id of product       |
| `BranchId`  | `integer` | **Required**. Id of branch        |
| `applyDate` | `string`  | **Required**. Application date    |




## Demo
This demo has been done in POSTMAN.
Here you have an example of endpoint usage:

```
curl --location 'http://localhost:8080/api/v1/productprices?applyDate=2020-06-15%2000%3A00%3A00&productId=35455&brandId=1' \
--header 'accept: application/json'
```
Response:
```json
[
    {
        "product_id": 35455,
        "brand_id": 1,
        "price_list": 1,
        "start_date": "2020-06-14 00:00:00",
        "end_date": "2020-12-31 23:59:59",
        "price": 35.5
    },
    {
        "product_id": 35455,
        "brand_id": 1,
        "price_list": 3,
        "start_date": "2020-06-15 00:00:00",
        "end_date": "2020-06-15 11:00:00",
        "price": 30.5
    }
]
```

### Running Tests

The application includes integration tests that validate the functionality of the REST endpoint. 

The following tests are included:
- Test 1: Request price information for product 35455 and brand 1 at 10:00 on June 14th.
- Test 2: Request price information for product 35455 and brand 1 at 16:00 on June 14th.
- Test 3: Request price information for product 35455 and brand 1 at 21:00 on June 14th.
- Test 4: Request price information for product 35455 and brand 1 at 10:00 on June 15th.
- Test 5: Request price information for product 35455 and brand 1 at 21:00 on June 16th.

To run tests:
```mvn test```


## Authors

- Kilian Piñero

