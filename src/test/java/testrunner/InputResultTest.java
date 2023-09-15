package common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputResultTest {

    @Test
    void testEnterResult_ValidInput() {

        String validInput = "5.5";
        InputStream in = new ByteArrayInputStream(validInput.getBytes());

        System.setIn(in);

        InputResult inputResult = new InputResult();

        double result = inputResult.enterResult();

        System.setIn(System.in);

        assertEquals(5.5, result, 0.001);
    }

    @Test
    //to check if method handles invalid
    void testEnterResult_InvalidInputThenValidInput() {

        String invalidInput = "abc\n7.2";
        InputStream in = new ByteArrayInputStream(invalidInput.getBytes());

        System.setIn(in);

        InputResult inputResult = new InputResult();

        double result = inputResult.enterResult();

        System.setIn(System.in);

        assertEquals(7.2, result, 0.001);
    }

    @Test
    //to check return method is working by saving 10.0
    void testReturnResult() {
        InputResult inputResult = new InputResult();

        inputResult.inputResult = 10.0;

        double result = inputResult.returnResult();

        assertEquals(10.0, result, 0.001);
    }
}
