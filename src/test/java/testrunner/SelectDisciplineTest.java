package testrunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SelectDisciplineTest {
//Because the functions are all nested and there is a second scanner created, it is not possible to run these tests yet!
//Loop within the input means we can't also test for a bad input, as it will just loop until it gets a good one.
//so the tests input a bad then a good input, we just assume that the bad input has been caught.
    @Test
    public void testInputSelectionValid() {
        String input = "1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		common.SelectDiscipline selectDiscipline = new common.SelectDiscipline();
		selectDiscipline.inputSelection();
		Assertions.assertEquals(1, selectDiscipline.getDisciplineSelected());
    }
	@Test
    public void testInputSelectionMultipleEmpty() {
        common.SelectDiscipline selectDiscipline = new common.SelectDiscipline();
        String input = "\n\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        selectDiscipline.inputSelection();
        Assertions.assertEquals(2, selectDiscipline.getDisciplineSelected());
    }

    @Test
    public void testInputSelectionInvalid() {
        common.SelectDiscipline selectDiscipline = new common.SelectDiscipline();
        String input = "invalid\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        selectDiscipline.inputSelection();
        Assertions.assertEquals(10, selectDiscipline.getDisciplineSelected());
    }

    @Test
    public void testInputSelectionOutOfRange() {
        common.SelectDiscipline selectDiscipline = new common.SelectDiscipline();
        String input = "100\n3\n20\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        selectDiscipline.inputSelection();
        Assertions.assertEquals(3, selectDiscipline.getDisciplineSelected());
    }


    @Test
    public void testInputSelectionMultipleOutOfRange() {
        common.SelectDiscipline selectDiscipline = new common.SelectDiscipline();
        String input = "100\n200\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        selectDiscipline.inputSelection();
        Assertions.assertEquals(2, selectDiscipline.getDisciplineSelected());
    }

 
}