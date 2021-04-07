# search-restaurant
## _Best matched restaurant_

[![Build Status](https://travis-ci.com/ms-vieira/search-restaurant.svg?token=26erj8ReictAxUzuchaR&branch=master)](https://travis-ci.com/ms-vieira/search-restaurant)

It is an api that makes it possible to search for up to five best restaurants, according to the parameters given.

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
{
    "cuisine": String -> (Chinese, American, Thai, etc.),
    "customerRating": Integer -> (1 star ~ 5 stars),
    "distance": Integer -> 1 mile ~ 10 miles,
    "price": Integer -> how much one person will spend on average, $10 ~ $50,
    "restaurantName": String -> Restaurant Name
}```


[OpenCsv]: <http://opencsv.sourceforge.net/>
[Lombok]: <https://projectlombok.org>
[Swagger]: <http://springfox.github.io/springfox/docs/current>
[Spring Boot]: <https://spring.io/projects/spring-boot>
[Java]: <https://www.oracle.com/br/java>
[Gradle]: <https://gradle.org>
