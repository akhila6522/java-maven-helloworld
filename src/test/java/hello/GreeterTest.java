package hello;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class GreeterTest {
    private Greeter greeter = new Greeter();

    @Test
    public void greeterSaysHello() {
	    assertThat(greeter.SayHello(), containsString("Hello"));
    }

    @Test
    public void greeterSaysHello2() {
        assertThat(greeter.SayHello(), containsString("Worlds"));
    }
}
