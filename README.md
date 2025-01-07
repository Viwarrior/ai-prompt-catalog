# AI Prompt Catalog
A Spring Boot + React application to create, search, and manage AI prompts efficiently.



## Features

- **Prompt Creation**: Add, update, and delete AI prompts with ease.
- **Fast Searching**: ElasticSearch integration for high-speed query responses.
- **MongoDB Integration**: Scalable and reliable NoSQL database for storing prompts.
- **REST API**: Manage prompts programmatically with a RESTful interface.
- **Modern UI**: React-based user interface for seamless prompt management.



## Architecture
The system consists of the following components:
- **Front-End**: A React-based web application.
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
- **Node.js** and **npm** (for the front-end)



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

Start all the services using Docker Compose:

```
docker-compose up
```



## Usage

### Accessing the Front-End
- Navigate to **http://localhost:3000** in your browser to access the web interface.
- Use the UI to create, search, and manage AI prompts.

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
- **URL**: `promptstore/api/v1/prompts?size=10&page=0`
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



## Configuration
| Environment Variable      | Default Value | Description                                   |
|---------------------------|---------------|-----------------------------------------------|
| `SERVER_CONTEXT_PATH`     | `/promptstore`| Spring Boot application context path          |
| `SECRET_KEY`              | `Ydy2AoPokl8/NFluUbYUWcLVtjoT/Ch2Ga3PzKVYc+R+2IDM7DKmn1mza++Z2Voy` | Secret key for Spring Boot application       |
| `MONGODB_HOST`            | `host.docker.internal` | MongoDB host for storing prompts          |

## How It Works

1. **Prompt Management**:  
   - Prompts are created, updated, and deleted via the REST API or front-end interface.
   
2. **Search Optimization**:  
   - ElasticSearch enables full-text and metadata-based search for prompts.

3. **Data Storage**:  
   - MongoDB stores the prompts and their metadata.

4. **Modern Front-End**:  
   - React provides an intuitive interface for users.



## To Do

- Add user authentication and role-based access control.
- Expand search capabilities (e.g., fuzzy search).
- Implement logging and monitoring for production.
