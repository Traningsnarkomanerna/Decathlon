package testrunner;

import heptathlon.Hep100MHurdles;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Hep100MHurdlesTest {

    @Test
    public void testCorrectResultsHep100MHurdles() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 14;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 978;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesHep100MHurdlesAbove() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 26.41;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 0;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesHep100MHurdlesOnPoint() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 26.4;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesHep100MHurdlesBelow() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 26.39;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testLowerBoundaryValuesResultsHep100MHurdlesOnPoint() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 9;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 1799;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testLowerBoundaryValuesResultsHep100MHurdlesAbove() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 9.01;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 1798;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testLowerBoundaryValuesHep100MHurdlesBelow() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double distance = 8.99;

        h100MH.calculateResult(distance);

        int actual = h100MH.getScore();
        int expected = 1799;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }
}

