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
//                assertEquals("John", user.UserName());
                assertEquals("Peter", user.UserName());
            });
        }
}
