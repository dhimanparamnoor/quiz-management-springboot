
# Quiz Management System (Spring Boot)

A RESTful Quiz Management System built using **Spring Boot**.
This application allows users to manage a **question bank** and dynamically generate **quizzes based on category and number of questions**.

---

# Features

### Question Management

* Add new questions
* Update existing questions
* Delete questions
* Fetch all questions
* Fetch questions based on category (Java, Python, etc.)

### Quiz Management

* Create quiz from question bank
* Generate quiz using category and number of questions
* Fetch quiz questions
* Submit quiz responses
* Automatically calculate quiz score

---

# Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **Maven**
* **Postman**

---

# Project Architecture

The project follows a **layered architecture**:

Controller → Service → Repository → Database

* **Controller Layer** – Handles API requests
* **Service Layer** – Contains business logic
* **Repository Layer** – Interacts with database
* **Database** – PostgreSQL

---

# API Endpoints

## Question APIs

### Add Question

POST /question/add

Example Request

```
{
  "category": "Java",
  "difficultyLevel": "Easy",
  "option1": "100",
  "option2": "127",
  "option3": "255",
  "option4": "999",
  "questionTitle": "Maximum value for byte in Java",
  "rightAnswer": "127"
}
```

### Get All Questions

GET /question/allQuestions

---

### Get Questions by Category

GET /question/category/{category}

Example:

```
GET /question/category/java
```

---

### Update Question

PUT /question/update/{id}

---

### Delete Question

DELETE /question/delete/{id}

---

# Quiz APIs

### Create Quiz

POST /quiz/create?category=java&numQ=5&title=JQuiz

Parameters:

| Parameter | Description         |
| --------- | ------------------- |
| category  | Question category   |
| numQ      | Number of questions |
| title     | Quiz title          |

---

### Get Quiz Questions

GET /quiz/get/{id}

---

### Submit Quiz

POST /quiz/submit/{quizId}

Example Request

```
[
  {
    "id": 5,
    "response": "A special method"
  },
  {
    "id": 17,
    "response": "public"
  }
]
```

---

# Database

The application uses **PostgreSQL** to store questions and quiz data.

---

# Postman Collection

A Postman collection is included to test all APIs.

Location:

```
postman/quiz_springboot.postman_collection.json
```

---

# How to Run the Project

1. Clone the repository

```
git clone https://github.com/dhimanparamnoor/quiz-management-springboot.git
```

2. Open the project in **IntelliJ / VS Code / Eclipse**

3. Configure **PostgreSQL database** in `application.properties`

4. Run the Spring Boot application

5. Test APIs using **Postman**

---

# Future Improvements

* JWT Authentication
* User login system
* Timer-based quizzes
* Leaderboard system
* Frontend using React

---

# Author

Paramnoor Dhiman
