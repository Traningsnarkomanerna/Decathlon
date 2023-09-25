package testrunner;

import common.CalcTrackAndField;
import decathlon.DecaShotPut;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class DecaShotPutTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(51.39, 1.5, 1.05, distance);
    }

    @ParameterizedTest
    @ValueSource(doubles = {30.01, 30.0, 29.99, 1.54, 1.53, 1.52})
    void testBoundaryValues(double distance) {
        DecaShotPut dSP = new DecaShotPut();
        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = calculateExpectedScore(distance);

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testCorrectResultsDecaShotPut() {
        DecaShotPut dSP = new DecaShotPut();

        double distance = 16;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 851;

        Assertions.assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }
/*
    @Test
    public void testUpperBoundaryValuesDecaShotPutAbove() {
        DecaShotPut dSP = new DecaShotPut();

        double distance = 30.01;

        dSP.calculateResult(distance);

        int actual = dSP.getScore();
        int expected = 1732;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }


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
