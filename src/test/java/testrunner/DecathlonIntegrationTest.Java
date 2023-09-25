package testrunner;

import common.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DecathlonIntegrationTest {
    //it isn't possible to do a unit test of the main method, so this is an integration test
    //it also isn't possible to run this test as it is, because the main method is in a loop that can't be broken out of, except for an uncaught exception.
    //The scoring also takes its input from a second scanner, so it is not possible to test the scoring.
    
    @Test
    public void testDecathlon() {
        String input = "Bob Fish\n1\n100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Main.main(new String[]{});
        // Add assertions to test the behavior of the application
    }
}