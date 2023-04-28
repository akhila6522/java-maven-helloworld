package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

import org.junit.jupiter.api.Test;

public class FromUserTest {
    private FromUser user = new FromUser();
    
    @Test
    void fromUserUserName()
        throws Exception {
            withTextFromSystemIn("John").execute(() -> {
                assertEquals("John", user.UserName());
            });
        }
}
