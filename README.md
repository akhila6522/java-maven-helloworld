# Java HelloWorld build and test with Maven

This repository is for study how to build and test Java package with Maven. Also it can be used in Jenkins.  
This is simple Java program HelloWorld with units that return greetings and asks your name from stdin. The package will build and test with help Maven.  

## src/main/java

There is a code of the java application in this directory.  

### HelloWorld.java

This is main program that invoke functions from another units and combine their response into output.  

    package hello;

    import org.joda.time.LocalTime;

    public class HelloWorld {
        public static void main(String[] args) {
	        LocalTime currentTime = new LocalTime();
    	    System.out.println("The current local time is: " + currentTime);
	        Greeter greeter = new Greeter();
	        FromUser user = new FromUser();
	        System.out.println(greeter.SayHello() + " from " + user.UserName());
        }
    }


### Greeter.java

This unit return a string with greeting.  

    package hello;

    public class Greeter {
        public String SayHello() {
	        return "Hello World!";
	    }
    }


### FromUser.java

This unit ask your name and return it as result.  

    package hello;

    import java.util.Scanner;

    public class FromUser {
        public String UserName() {
            Scanner in = new Scanner(System.in);
            System.out.println("What is your name? -> ");
            String userName = in.nextLine();
            return userName;
        }
    }

## src/test/java

There is a code of tests in this directory.  

### FromUserTest.java

This is test that check unit FromUser. It sends datas to stdin and check that them equal to that what the unit is returns.

    package hello;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

    import org.junit.jupiter.api.Test;
    import java.util.Scanner;

    public class FromUserTest {
        private FromUser user = new FromUser();
        
        @Test
        void fromUserUserName()
            throws Exception {
                withTextFromSystemIn("John", "Peter").execute(() -> {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
                    assertEquals("Peter", user.UserName());
                });
            }
    }

### GreeterTest.java
This is tests for unit Greeter. It invoke functions from unit Greeter and check if thir returns as expected.

    package hello;

    import static org.hamcrest.core.StringContains.containsString;
    import static org.hamcrest.MatcherAssert.assertThat;

    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.Disabled;

    public class GreeterTest {
        private Greeter greeter = new Greeter();

        @Test
        public void greeterSaysHello() {
            assertThat(greeter.SayHello(), containsString("Hello"));
        }

        @Disabled("Must be ignored")
        @Test
        public void greeterSaysHello2() {
            assertThat(greeter.SayHello(), containsString("World"));
        }
    }

### pom.xml

This is config file for maven. It contains package properties,dependencies and build instructions.  

### Example

    maven clean package

This command will create jar file in directory target. And test's results will be in directory target/surefire-reports.  
