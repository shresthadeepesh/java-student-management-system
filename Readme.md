## Student Management System

A student management system created using JAVA, MYSQL.

Contains an applet created using Swing, a GUI, and a database.

## Setup
- Initially create a database called "student-management". In case of other database, change the config in the `common.database.Connect.java`.
- Create a table called `students` in the database.
- Required columns are id, name, email, password, address, grade, dob, phone, guardianName, gender, joinedAt.
- You are all done.
- Skip the above steps if you want to set up using a sql file attached in the repo.

### Running the Applet
- Run the main method in the `Main.java` file.

### Running the Student management system war.
- Add the server like Tomcat, Apache, etc.
- Build the artifacts. E.g. in the Intellij IDE, Press `Ctrl + Shift + Alt + S`. Go to artifacts and add the Java WebApplication Exploded.
- Add the war file to the Tomcat server.
- Run the server.
- Go to `http://localhost:8080/student_management_swing_war_exploded`.

#### Available routes for Web Application
- `/`: Home page.
- `/students`: List of students.
- `/students/add`: Add a student.
- `/students/edit?id={id}`: Edit a student.
- `/students/delete?id={id}`: Delete a student.
- `/auth/login`: Login page.
- `/auth/register`: Register page.
- `/auth/forgot-password`: Forgot password page.