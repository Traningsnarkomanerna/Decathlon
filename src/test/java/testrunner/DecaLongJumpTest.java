package testrunner;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecaLongJumpTest {

    private decathlon.DecaLongJump decaLongJump;
    @Before
    public void setUp(){
        decaLongJump = new decathlon.DecaLongJump();
    }

    //Testing if the entered result is giving correct point score
    @Test
    public void testResultForCorrectPointsCalc_DecaLongJump(){

        double longJump = 560.00;
        int expectedScore = 502;

        decaLongJump.calculateResult(longJump);

        int actualScore = decaLongJump.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }

    //Checking the result of the lowest range with end result of 0 points
    @Test
    public void testResultOfLowestValue_DecaLongJump(){

        double A = 0.14354;
        double B = 220;
        double C = 1.4;

        double longJumpScore = 224.00;
        int expectedScore = (int) (A * Math.pow((longJumpScore - B), C));
        decaLongJump.calculateResult(longJumpScore);

        int actualScore = decaLongJump.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);

    }
    //Current WR is 8.95 m or 895 cm
    //Testing if calculator can handel higher values from 895cm and above
    @Test
    public void testResultOfHigherValue_DecaLongJump(){

        double A = 0.14354;
        double B = 220;
        double C = 1.4;

        double longJumpScore = 999.00;
        int expectedScore = (int) (A * Math.pow((longJumpScore - B), C));
        decaLongJump.calculateResult(longJumpScore);

        int actualScore = decaLongJump.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }

    //Testing to get the lowest point score of 1 point
    @Test
    public void testResultOnPoint_DecaLongJump(){

        double A = 0.14354;
        double B = 220;
        double C = 1.4;

        double longJumpScore = 224.01;
        int expectedScore = (int) (A * Math.pow((longJumpScore - B), C));
        decaLongJump.calculateResult(longJumpScore);

        int actualScore = decaLongJump.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }

//Testing if calculator can handel wrong result
    /*@Test
    public void negativTestForWrongPointsCalc_DecaLongJump(){
        double longJump = 450.00;
        int expectedScore = 291;

        decaLongJump.calculateResult(longJump);

        int actualScore = decaLongJump.getScore();

        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }*/
}

