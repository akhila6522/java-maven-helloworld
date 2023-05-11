# Java HelloWorld build and test with Maven

This repository is for study how to build and test Java package with Maven. Also it can be used in Jenkins.  
This is simple Java program HelloWorld with units that return greetings and asks your name from stdin. The package will build and test with help Maven.  

## src/main/java

There is a code of the java application in this directory.  

### HelloWorld.java

This is main program that invoke functions from another units and combine their response into output.  

### Greeter.java

This unit return a string with greeting.  

### FromUser.java

This unit ask your name and return it as result.  

## src/test/java

There is a code of tests in this directory.  

### FromUserTest.java

This is test that check unit FromUser. It sends datas to stdin and check that them equal to that what the unit is returns.

### GreeterTest.java
This is tests for unit Greeter. It invoke functions from unit Greeter and check if thir returns as expected.

### pom.xml

This is config file for maven. It contains package properties, dependencies and build instructions.  

### Example

    maven clean package

This command will create jar file in directory target. And test's results will be in directory target/surefire-reports.  

## Jenkinsfile

File is Jenkins' declarative pipeline. It contains instructions that get codes from GitHub repository,
build and archive jar file then test it and save test's results.
