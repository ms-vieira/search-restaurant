# search-restaurant
## _Best matched restaurant_

[![Build Status](https://travis-ci.com/ms-vieira/search-restaurant.svg?token=26erj8ReictAxUzuchaR&branch=master)](https://travis-ci.com/ms-vieira/search-restaurant)

[![codecov](https://codecov.io/gh/ms-vieira/search-restaurant/branch/master/graph/badge.svg?token=49B4JH4B0G)](https://codecov.io/gh/ms-vieira/search-restaurant)

It is an api that makes it possible to search for up to five best restaurants, according to the parameters given.

## Concepts
- The project was built using [Clean Architecture].
- Also applied good practices based on [SOLID].
- Applied the concepts of [Clean Code].
- The [Chain of Responsibility] pattern was used.
- Covered with unit tests using [Junit] and done an integrated test using MockMvc.

## Features

- Reading of .csv file of restaurants and cuisines.
- Filter with up to five parameters given.
- Dealing with parameter validation error.

## Tech

- [Java]
- [Gradle]
- [Spring Boot]
- [Swagger]
- [Lombok]
- [OpenCsv]

## Running the application
- Swagger UI

```sh
./gradlew clean build bootrun
```

- Access to the application specification
```sh
http://localhost:8080/swagger-ui.html
```

- Payload
```json

 Parameters
  
    cuisine - String -> (Chinese, American, Thai, etc.)
    customerRating - Integer -> (1 star ~ 5 stars)
    distance - Integer -> 1 mile ~ 10 miles
    price - Integer -> how much one person will spend on average, $10 ~ $50,
    restaurantName - String -> Restaurant Name
```


[OpenCsv]: <http://opencsv.sourceforge.net/>
[Lombok]: <https://projectlombok.org>
[Swagger]: <http://springfox.github.io/springfox/docs/current>
[Spring Boot]: <https://spring.io/projects/spring-boot>
[Java]: <https://www.oracle.com/br/java>
[Gradle]: <https://gradle.org>
[Clean Architecture]: <https://books.google.com.br/books?id=8ngAkAEACAAJ>
[SOLID]: <https://en.wikipedia.org/wiki/SOLID>
[Clean Code]: <http://cleancoder.com/products>
[Chain of Responsibility]: <https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility>
[Junit]: <https://junit.org/junit5/docs/current/user-guide>
[MockMvc]: <https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html>