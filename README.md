TaskBuddyPro

About the Project
TaskBuddyPro is a simple Java Spring Boot project that helps manage tasks using REST APIs.
I created this project to practice core Java concepts and understand how backend APIs work.

The focus of this project is not advanced frameworks but strong fundamentals, like OOPS, collections, file handling, and exception handling.

What This Project Does
Add a task
View all tasks
Update a task
Delete a task
Store task data in a file instead of a database
Test APIs using Postman

Technologies Used
Java
Spring Boot
Maven
REST API
Postman
File handling (no database)

Project Structure
com.example.taskbuddy
│
├── controller   → Handles API requests
├── model        → Task class
├── service      → Business logic
├── exception    → Custom exceptions
└── resources    → File used to store tasks

Concepts Covered
OOPS
Used encapsulation in the Task class by keeping fields private and using getters and setters
Used constructors to create task objects
Service layer hides implementation details
Collections
Used ArrayList to store tasks in memory
Iterated through collections to search and update tasks
Handled cases where data is missing or empty

Exception Handling
Used try-catch blocks while reading and writing files
Created a custom exception when a task is not found
Handled errors properly so the application does not crash

File Handling
Used File, FileReader, FileWriter
Used BufferedReader and BufferedWriter for better performance
Stored task data in a text file
Handled file not found scenarios

String Manipulation and Regex
Used split() to read data from file
Used replace() and substring() where needed
Used basic regex to validate task input
API Endpoints

Method	URL	Description
POST	/tasks	Create a task
GET	/tasks	Get all tasks
PUT	/tasks/{id}	Update a task
DELETE	/tasks/{id}	Delete a task

How I Tested the Project
I tested all APIs using Postman by sending JSON requests and checking responses for different scenarios like valid data, invalid data, and missing IDs.

Why File Handling Instead of Database
I used file handling instead of a database to focus more on Java logic and core concepts. This helped me understand how data can be stored and retrieved manually.

How to Run
Open the project in any IDE
Run the Spring Boot application
Use Postman to test APIs on http://localhost:8080

What I Learned
How REST APIs work
How to structure a Java backend project
How OOPS concepts are used in real projects
How to handle errors properly
How to read and write data using files
