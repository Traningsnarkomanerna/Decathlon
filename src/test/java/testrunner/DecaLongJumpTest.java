package testrunner;

import static org.junit.Assert.*;

import common.CalcTrackAndField;
import decathlon.DecaLongJump;
import org.junit.Before;
import org.junit.Test;

public class DecaLongJumpTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(0.14354, 220, 1.4, distance);
    }
    private DecaLongJump decaLongJump;
    @Before
    public void setUp(){
        decaLongJump = new decathlon.DecaLongJump();
    }
    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 1200;

        decaLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 1501;

        decaLongJump.calculateResult(distance);

        int expected = -1;
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 1500;

        decaLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 1499;

        decaLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 221;

        decaLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 220;

        decaLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 219;

        decaLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaLongJump.getScore();

        assertEquals(expected, actual);
    }

    /*

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

