package testrunner;

import decathlon.Deca110MHurdles;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Deca110MHurdlesTest {

    @Test
    public void testCorrectResultsDeca110MHurdles() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 14;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 975;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesDeca110MHurdlesAbove() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 28.1;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 0;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testUpperBoundaryValuesDeca110MHurdlesOnPoint() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 28.09;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testUpperBoundaryValuesDeca110MHurdlesBelow() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 28.08;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesDeca110MHurdlesOnPoint() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 10;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 1556;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesDeca110MHurdlesAbove() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 10.01;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 1554;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }

    @Test
    public void testLowerBoundaryValuesDeca110MHurdlesBelow() {
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double distance = 9.99;

        d110MH.calculateResult(distance);

        int actual = d110MH.getScore();
        int expected = 1558;

        assertEquals(expected, actual);
        System.out.println("Expected: " + expected + " \n" + "Actual: " + actual);
    }
}


