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

