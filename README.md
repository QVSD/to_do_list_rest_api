# ToDo API (Spring Boot)

A simple REST API for managing a ToDo list.  
This project demonstrates **Spring Boot**, **Spring Data JPA**, and connecting to a relational database (MySQL/PostgreSQL).
I've made this just to practice and learn Spring Boot, so when the future me is going to be seeing this it's going to start laughing about this, but here is where we started from champ :D  
---

## How to Run

1. Clone the repository:
   ``` bash
   git clone https://github.com/QVSD/todo-api.git
   cd todo-api
    ```
2. Configure the database in `src/main/resources/application.properties`:

   ``` properties
   spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Start the application:

   ```bash
   ./gradlew bootRun
   ```

   The API will be available at: `http://localhost:8080`

---

## API Endpoints

### Get all ToDos

```http
GET /todos
```

### Get a ToDo by ID

```http
GET /todos/{id}
```

### Create a new ToDo

``` http
POST /todos
Content-Type: application/json

{
  "title": "Buy bread",
  "description": "From the store",
  "done": false
}
```

### Update an existing ToDo

``` http
PUT /todos/{id}
Content-Type: application/json

{
  "title": "Buy milk",
  "description": "From the supermarket",
  "done": true
}
```

### Delete a ToDo

```http
DELETE /todos/{id}
```

---

## Error Handling

If a resource is not found, the API returns:

``` json
{
  "timestamp": "2025-09-27T18:05:46.389896300",
  "status": 404,
  "message": "ToDo not found with id 999"
}
```

---

## Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* MySQL
* Gradle

---

```

