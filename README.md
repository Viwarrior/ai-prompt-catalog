# AI Prompt Catalog
A Spring Boot application to create, search, and manage AI prompts efficiently.



## Features

- **Prompt Creation**: Add, update, and delete AI prompts with ease.
- **Fast Searching**: ElasticSearch integration for high-speed query responses.
- **MongoDB Integration**: Scalable and reliable NoSQL database for storing prompts.
- **REST API**: Manage prompts programmatically with a RESTful interface.



## Architecture
The system consists of the following components:
- **Back-End**: A Spring Boot service exposing RESTful APIs.
- **Database**: MongoDB for storing prompt data.
- **Search Engine**: ElasticSearch for optimized search capabilities.

![Architecture Diagram](artifacts/architecture.png)



## Requirements

- **Java 17**
- **Spring Boot 3.xx**
- **MongoDB** (Installed locally or accessible via Docker)
- **ElasticSearch**
- **Maven** (for building the project)



## Quick Start

### Clone the Repository

```
git clone https://github.com/avinash-550/ai-prompt-catalog.git
```

### Build the Project

```bash
mvn clean install
```



### Run the Services

#### Start the dependencies
```bash
docker-compose -f docker/docker-compose-depencencies.yaml up --build -d
```
#### Create index for prompts in ES
```bash
curl -X PUT "http://localhost:9200/prompts" -H 'Content-Type: application/json' -d'
{
  "settings": {
    "number_of_shards": 1,
    "number_of_replicas": 0
  },
  "mappings": {
    "properties": {
      "name": {
        "type": "text"
      },
      "description": {
        "type": "text"
      },
      "content": {
        "type": "text"
      },
      "version": {
        "type": "integer"
      }
    }
  }
}'
```
#### Start the SpringBoot application
```bash
mvn spring-boot:run
```



## Usage

### Accessing the REST API
- Use tools like `curl`, Postman, or similar clients to interact with the backend services.


## API Design
### **Register User**
- **Method**: `POST`
- **URL**: `http://localhost:8091/promptstore/api/v1/auth/register`
- **Request Body**:
  ```json
  {
    "username": "example",
    "password": "example"
  }
  ```
- **Response**:
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdmluYXNoIiwiaWF0IjoxNzM2MjczMDgwLCJleHAiOjE3MzYzMDkwODB9.hz3wcy16uapZvo0X_8fLAGCyqQMriaKoFJ6NVpwBBsA"
  }
  ```


### **Login**
- **Method**: `POST`
- **URL**: `http://localhost:8091/promptstore/api/v1/auth/login`
- **Request Body**:
    ```json
  {
    "username": "example",
    "password": "example"
  }
  ```
- **Response**:
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdmluYXNoIiwiaWF0IjoxNzM2MjczMDgwLCJleHAiOjE3MzYzMDkwODB9.hz3wcy16uapZvo0X_8fLAGCyqQMriaKoFJ6NVpwBBsA"
  }
  ```
  
### **Create Prompt**
- **Method**: `POST`
- **URL**: `http://localhost:8091/promptstore/api/v1/prompts`
- **Headers**:
  - `Authorization`: `Bearer <Access Token>`
- **Request Body**:
  ```json
  {
    "name": "New Prompt",
    "description": "Prompt description",
    "content": "Prompt content"
  }
  ```
- **Response**:
  ```json
  {
    "name": "New Prompt",
    "description": "Prompt description",
    "content": "Prompt content",
    "version": 1,
  }
  ```

### **Get All Prompts**
- **Method**: `GET`
- **Headers**:
  - `Authorization`: `Bearer <Access Token>`
- **URL**: `http://localhost:8091/promptstore/api/v1/prompts?size=10&page=0`
- **Response**:
  ```json
  [
    {
      "name": "Example Prompt",
      "description": "A sample description",
      "content": "Prompt content goes here",
      "version": 1,
    }
  ]
  ```

### **Search Prompts**
- **Method**: `GET`
- **URL**: `http://localhost:8091/promptstore/api/v1/prompts/search?query=quiz&size=2&page=1`
- **Headers**:
  - `Authorization`: `Bearer <Access Token>`
- **Response**:
  ```json
  [
    {
        "name": "History Quiz Generator2",
        "description": "A prompt to generate trivia questions on world history.",
        "version": 1,
        "content": "Create five multiple-choice questions about the events of World War II, including correct answers and explanations."
    },
    {
        "name": "History Quiz Generator3",
        "description": "A prompt to generate trivia questions on world history.",
        "version": 1,
        "content": "Create five multiple-choice questions about the events of World War II, including correct answers and explanations."
    }
  ]
  ```
## Configuration
| Environment Variable      | Default Value | Description                                   |
|---------------------------|---------------|-----------------------------------------------|
| `SERVER_CONTEXT_PATH`     | `/promptstore`| Spring Boot application context path          |
| `SECRET_KEY`              | `Ydy2AoPokl8/NFluUbYUWcLVtjoT/Ch2Ga3PzKVYc+R+2IDM7DKmn1mza++Z2Voy` | Secret key for JWT auth      |
| `MONGODB_HOST`            | `host.docker.internal` | MongoDB host for storing prompts          |
| `MONGODB_PORT`            | `27017` | MongoDB port for storing prompts          |
| `MONGODB_DATABASE`        | `promptstore` | MongoDB database for storing prompts          |
| `MONGODB_USERNAME`        | `db_user` | MongoDB username for storing prompts          |
| `MONGODB_PASSWORD`        | `db_password` | MongoDB password for storing prompts          |
| `ELASTICSEARCH_URI`       | `http://localhost:9200` | Elasticsearch URI for indexing prompts    |


## How It Works

1. **Prompt Management**:  
   - Prompts are created, updated, and deleted via the REST API or front-end interface.
   
2. **Search Optimization**:  
   - ElasticSearch enables full-text and metadata-based search for prompts.

3. **Data Storage**:  
   - MongoDB stores the prompts and their metadata.



## To Do
- Add front end code.
- Add role-based access control.
- Implement logging and monitoring for production.
- Add contract tests.
