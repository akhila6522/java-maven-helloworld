package hello;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class GreeterTest {
    private Greeter greeter = new Greeter();

    @Test
    public void greeterSaysHello() {
	    assertThat(greeter.SayHello(), containsString("Hello"));
    }

    @Test
    public void greeterSaysHello2() {
        assertThat(greeter.SayHello(), containsString("World"));
    }
}
