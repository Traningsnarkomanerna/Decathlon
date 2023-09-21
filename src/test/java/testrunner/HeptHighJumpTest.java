package testrunner;

import heptathlon.HeptHightJump;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HeptHighJumpTest {

    @Test
    public void testCorrectResultsHeptHighJump() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 170;

        hHJ.calculateResult(distance);

        int actual = hHJ.getScore();
        int expected = 855;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesHeptHighJumpAbove() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 271;

        hHJ.calculateResult(distance);

        int actual = hHJ.getScore();
        int expected = 2269;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }


    @Test
    public void testUpperBoundaryValuesHeptHighJumpOnPoint() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 270;

        hHJ.calculateResult(distance);


        int actual = hHJ.getScore();
        int expected = 2254;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testUpperBoundaryValuesHeptHighJumpBelow() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 269;

        hHJ.calculateResult(distance);

        int actual = hHJ.getScore();
        int expected = 2238;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesHeptHighJumpBelow() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 75;

        hHJ.calculateResult(distance);

        int actual = hHJ.getScore();
        int expected = 0;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesHeptHighJumpOnPoint() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 76;

        hHJ.calculateResult(distance);

        int actual = hHJ.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesHeptHighJumpAbove() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 77;

        hHJ.calculateResult(distance);

        int actual = hHJ.getScore();
        int expected = 4;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }
}

