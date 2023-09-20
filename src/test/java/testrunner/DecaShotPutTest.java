package testrunner;

import common.CalcTrackAndField;
import decathlon.DecaShotPut;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecaShotPutTest {

    @Test
    public void testCorrectResultsDecaShotPut() {
        //CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double distance = 16;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 851;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesDecaShotPutAbove() {
        CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double A = 51.39;
        double B = 1.5;
        double C = 1.05;
        double distance = 30.01;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 1732;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }


    @Test
    public void testUpperBoundaryValuesDecaShotPutOnPoint() {
        //CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double distance = 30;

        dSP.calculateResult(distance);


        int actual = dSP.getScore();
        int expected = 1731;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testUpperBoundaryValuesDecaShotPutBelow() {
        //CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double distance = 29.99;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 1731;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesDecaShotPutBelow() {
        //CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double distance = 1.52;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 0;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesResultsShotPutOnPoint() {
        //CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double distance = 1.53;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesResultsDeca110MHurdlesAbove() {
        //CalcTrackAndField dShotPut = new CalcTrackAndField();
        DecaShotPut dSP = new DecaShotPut();

        double distance = 1.54;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }
}
