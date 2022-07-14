# Manage Students

Manage Students is a Java Project developed to practice my skills in software development using the Java language along with a Test Driven Development (TDD) approach. My goal was to familiarize myself with TDD, agile development, and at the same time put into practice core concepts associated with the programming language.

Manage Students is a software to manage students, as could naturally be understood from the name of the project at the first place. Information on functionality, class and packages organization, and so on, will be provided as new user stories be implemented.

I am developing this project while reading lessons provided by Jeff Langr in his excellent book "Agile Java: crafting code with Test-Driven Development". I consider this book a must read for anyone who wishes to start with the discipline of TDD. The code in this repository differs in some aspects from the code provided by J. Langr, because I am trying to develop the solutions as I am reading the lessons and the requirements for the system. In anyway, much of the code is very close to the original provided by the author of the book. At the end of each lesson, there are exercises that are basically requirements and user stories for another project (a chess game), which I am developing. In this case, all the code was originally developed by me, and you can check it out in the corresponding repository.

## Organization

The production and test code of this project are organized into three packages: `sis.courseinfo`, `sis.report`, and `sis.studentinfo`. The test code is located at the test source folder, but it holds the same package structure as the production code.

There is a test class for each production class in this project. All the test classes are inserted in a test suite.

## Functionalities

All the functionalities of the system can be checked in the tests available in the test source folder. There are functionalities related to students, course sessions, and reports.

It is possible to create students, and to enroll students in sessions. The sessions can be regular course sessions (16 weeks long) or summer course sessions (eight weeks long). When a student is enrolled in a session, he or she earns credits. Each session can have its own number of credits.

Sessions are created for each Department, and so they hold specific information, such as Department name, and Department number. Each session holds a collection of enrolled students. Reports can be created to inform about Departments where sessions are being offered or to inform about list of students enrolled in a particular session.

Students enrolled in a session will receive one of five possible grades (A, B, C, D or F). Report cards can be generated according to each of these grades. Some students may be considered as honors students, and the way the grade of these students is calculated is different.

The project is under development, and as the development process goes on, I will add more information.

## Studied and Applied Topics

While developing this project I am getting in touch with lots of information. Of course I won't put everything in here, but I will try to point some of the topics in the following list.

- Test-Driven Development;
- Unit testing with JUnit (in this project I am using the JUnit 4 framework, but later I will update it to make use of JUnit jupiter);
- Object Oriented Programming;
- Inheritance;
- Interfaces;
- Polymorphism;
- Strings and String builders;
- Enums;
- Conditional flow;
- ArrayLists and the List interface;
- Some design patterns such as factory method, and template method.

Get easy on me, I am just struggling to be able to call myself a junior java developer.
