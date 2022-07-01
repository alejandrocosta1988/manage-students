# Manage Students

Manage Students is a Java Project developed to practice my skills in software development using the Java language along with a Test Driven Development (TDD) approach. My goal was to familiarize myself with TDD, agile development, and at the same time put into practice concepts associated with the core programming language.

Manage Students is a software to manage students, as could naturally be understood from the name of the project at the first place. Information on class structure, and functionality will be provided as new user stories will be selected to be worked on.

## Packages

### `studentinfo`

Package `studentinfo` contains code related to students.

#### Classes

`Student` holds information on a student. A `Student` instance receives the student name from the constructor.

### `courseinfo`

Package `courseinfo` contains code related to courses sessions.

#### Classes

`CourseSession` holds information on a course session (department name, course number, students enrolled in the course session, initial date). When an instance of this class is created, the name of the department is provided along with the number of the course, and the start date of the course.

This class includes methods to get specific students enrolled in the course, as well as to get the end date of the course.