package testrunner;

import common.CalcTrackAndField;
import decathlon.DecaShotPut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecaShotPutTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(51.39, 1.5, 1.05, distance);
    }

    private DecaShotPut decaShotPut;

    @Before
    public void setUp() {
        decaShotPut = new decathlon.DecaShotPut();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 15;

        decaShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 31;

        decaShotPut.calculateResult(distance);

        int expected = -1;
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 30;

        decaShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 29;

        decaShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 2.5;

        decaShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 1.5;

        decaShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 0.5;

        decaShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaShotPut.getScore();

        assertEquals(expected, actual);
    }
/*
    @Test
    public void testUpperBoundaryValuesDecaShotPutOnPoint() {
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
        DecaShotPut dSP = new DecaShotPut();

        double distance = 1.54;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }  */
}
