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
git clone https://github.com/your-username/ai-prompt-catalog.git
```

### Build the Project

```
cd ai-prompt-catalog
docker-compose build
```

The project consists of the following services:
- **Front-End**: A React application serving the user interface.
- **Back-End**: A Spring Boot service providing REST APIs.
- **Database**: A MongoDB instance for data storage.
- **Search Engine**: ElasticSearch for fast and efficient prompt searching.



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

#### Example: Fetch All Prompts
```
curl -X GET "http://localhost:8080/api/prompts" \
  -H "Content-Type: application/json"
```

#### Response:
```json
[
  {
    "id": "1",
    "name": "Example Prompt",
    "description": "A sample description",
    "content": "Prompt content goes here"
  }
]
```



## API Design
### **Register User**
- **Method**: `POST`
- **URL**: `http://localhost:8091/promptstore/api/v1/auth/register`
- **Headers**:
  - `Authorization`: `Bearer <Access Token>`
- **Request Body**:
  ```json
  {
    "username": "example",
    "password": "example"
  }
  
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
    "content": "Prompt content"
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
      "content": "Prompt content goes here"
    }
  ]
  ```



## Configuration

| Environment Variable      | Default Value | Description                                   |
|||--|
| `ELASTICSEARCH_HOST`      | `localhost`   | ElasticSearch host for fast searching         |
| `MONGODB_URI`             | `localhost`   | MongoDB URI for storing prompts               |
| `SERVER_PORT`             | `8080`        | Spring Boot application port                  |



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
