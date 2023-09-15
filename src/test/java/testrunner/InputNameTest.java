package testrunner;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputNameTest {

    @Test
    public void testInputName() {
        String inputName = "Umar";
        InputStream inputStream = new ByteArrayInputStream(inputName.getBytes());
        System.setIn(inputStream);

        common.InputName inputNameInstance = new common.InputName();

        String result = inputNameInstance.addCompetitor();

        System.setIn(System.in);

        Assert.assertEquals("Umar", result);
    }
}
