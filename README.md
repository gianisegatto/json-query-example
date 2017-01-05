# Json Query Example

This application can show you how to use Jackson-JQ to transfor you client response based on a Json-Query. 

### Stack
- [java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Programming language
- [spring-boot 1.4.2](https://github.com/spring-projects/spring-boot) - Provide application services
- [tomcat](http://tomcat.apache.org/) - Web container server, embeded in spring-boot
- [jackson-jq](https://github.com/eiiches/jackson-jq) - Java library for html parser

### Setup
1. Install [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html), if you don't have it yet.
2. Install [maven](https://maven.apache.org/index.html), if you don't have it yet.

### Build
**Building in a local environment:**
- Clone the code from the repository:
- Open the terminal go to some folder and type
```
git clone https://github.com/gianisegatto/json-query-example.git
```
- Open the terminal
- Go to the folder that the code was cloned and type
```
mvn clean install
```
### Run Server application
- Open the terminal
- Go to the folder that the code was cloned and type
```
mvn spring-boot:run
```
### Executing
- Open the terminal and type
```
curl http://localhost:8080/products
```
- The response should be
```json
[
  {
    "id": 0,
    "name": "name 0",
    "description": "description 0",
    "attributes": [
      {
        "id": 0,
        "name": "Attribute name 0",
        "description": "Attribute description 0"
      },
      {
        "id": 1,
        "name": "Attribute name 1",
        "description": "Attribute description 1"
      },
      {
        "id": 2,
        "name": "Attribute name 2",
        "description": "Attribute description 2"
      },
      {
        "id": 3,
        "name": "Attribute name 3",
        "description": "Attribute description 3"
      },
      {
        "id": 4,
        "name": "Attribute name 4",
        "description": "Attribute description 4"
      },
      {
        "id": 5,
        "name": "Attribute name 5",
        "description": "Attribute description 5"
      },
      {
        "id": 6,
        "name": "Attribute name 6",
        "description": "Attribute description 6"
      },
      {
        "id": 7,
        "name": "Attribute name 7",
        "description": "Attribute description 7"
      },
      {
        "id": 8,
        "name": "Attribute name 8",
        "description": "Attribute description 8"
      },
      {
        "id": 9,
        "name": "Attribute name 9",
        "description": "Attribute description 9"
      }
    ]
  },
  {
    "id": 1,
    "name": "name 1",
    "description": "description 1",
    "attributes": [
      {
        "id": 0,
        "name": "Attribute name 0",
        "description": "Attribute description 0"
      },
      {
        "id": 1,
        "name": "Attribute name 1",
        "description": "Attribute description 1"
      },
      {
        "id": 2,
        "name": "Attribute name 2",
        "description": "Attribute description 2"
      },
      {
        "id": 3,
        "name": "Attribute name 3",
        "description": "Attribute description 3"
      },
      {
        "id": 4,
        "name": "Attribute name 4",
        "description": "Attribute description 4"
      },
      {
        "id": 5,
        "name": "Attribute name 5",
        "description": "Attribute description 5"
      },
      {
        "id": 6,
        "name": "Attribute name 6",
        "description": "Attribute description 6"
      },
      {
        "id": 7,
        "name": "Attribute name 7",
        "description": "Attribute description 7"
      },
      {
        "id": 8,
        "name": "Attribute name 8",
        "description": "Attribute description 8"
      },
      {
        "id": 9,
        "name": "Attribute name 9",
        "description": "Attribute description 9"
      }
    ]
  },
  ...
]
```

#### Call asking to response format be [{"key": "name", "numberOfAttributes": 10}...]
- Open the terminal and type
```
curl --request GET \
  --url http://localhost:8080/products \
  --header 'jsonQuery: [.[] | {key: .name, numberOfAttributes: .attributes  | length}]' \
  --header 'content-type: application/json'
```
- The response should be
```json
[
  {
    "numberOfAttributes": 10,
    "key": "name 0"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 1"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 2"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 3"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 4"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 5"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 6"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 7"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 8"
  },
  {
    "numberOfAttributes": 10,
    "key": "name 9"
  }
]
```

#### Call asking to response return the first item of the list
- Open the terminal and type
```
curl --request GET \
  --url http://localhost:8080/products \
  --header 'jsonQuery: .[0]' \
  --header 'content-type: application/json'
```
- The response should be
```json
{
  "id": 0,
  "name": "name 0",
  "description": "description 0",
  "attributes": [
    {
      "id": 0,
      "name": "Attribute name 0",
      "description": "Attribute description 0"
    },
    {
      "id": 1,
      "name": "Attribute name 1",
      "description": "Attribute description 1"
    },
    {
      "id": 2,
      "name": "Attribute name 2",
      "description": "Attribute description 2"
    },
    {
      "id": 3,
      "name": "Attribute name 3",
      "description": "Attribute description 3"
    },
    {
      "id": 4,
      "name": "Attribute name 4",
      "description": "Attribute description 4"
    },
    {
      "id": 5,
      "name": "Attribute name 5",
      "description": "Attribute description 5"
    },
    {
      "id": 6,
      "name": "Attribute name 6",
      "description": "Attribute description 6"
    },
    {
      "id": 7,
      "name": "Attribute name 7",
      "description": "Attribute description 7"
    },
    {
      "id": 8,
      "name": "Attribute name 8",
      "description": "Attribute description 8"
    },
    {
      "id": 9,
      "name": "Attribute name 9",
      "description": "Attribute description 9"
    }
  ]
}
```
