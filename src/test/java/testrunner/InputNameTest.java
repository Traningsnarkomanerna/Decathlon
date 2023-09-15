package common;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputNameTest extends TestCase {

    @Test
    public void testInputName() {
        String inputName = "Umar";
        InputStream inputStream = new ByteArrayInputStream(inputName.getBytes());
        System.setIn(inputStream);

        InputName inputNameInstance = new InputName();

        String result = inputNameInstance.addCompetitor();

        System.setIn(System.in);

        assertEquals("Umar", result);
    }
}
