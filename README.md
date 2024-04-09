## Using The Disaster Relief System Application

This repository contains the source code for the individual assignment #3 created by the student Debojeet Dam
UCID: 30171419

### Requirements

Before compiling and running the application, ensure that you have the following:

- Java Development Kit (JDK) installed on your system.
- The required JAR files placed in the `lib` folder within the project directory.

### Compiling the Application

To compile the source code, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the project directory.

Compile the source files using the following command:

javac -cp lib/\* edu/ucalgary/oop/\*.java

This command compiles all Java files (`*.java`) located in the `edu/ucalgary/oop` directory, with the classpath (`-cp`) set to include all JAR files (`*`) within the `lib` directory.

### Running the Application

After compiling the source code, execute the application using the following command:

java -cp "lib\postgresql-42.7.3.jar;." edu.ucalgary.oop.DisasterVictimInterface

or

java -cp "lib\postgresql-42.7.3.jar;." edu.ucalgary.oop.InquirerInterface

This command runs the `DisasterVictimInterface` class or `InquirerInterface` class, specifying the classpath (`-cp`) to include the `postgresql-42.7.3.jar` file from the `lib` directory (`lib\postgresql-42.7.3.jar`) as well as the current directory (`.`), allowing Java to locate and load the required classes.

Thanks!
