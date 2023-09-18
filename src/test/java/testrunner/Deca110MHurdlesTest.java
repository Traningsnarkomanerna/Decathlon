package testrunner;

import common.CalcTrackAndField;
import decathlon.Deca110MHurdles;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Deca110MHurdlesTest {

    @Test
    public void testCorrectResultsDeca110MHurdles() {
        CalcTrackAndField d110MHurdles = new CalcTrackAndField();
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double A = 5.74352;
        double B = 28.5;
        double C = 1.92;
        double runningTime = 14;

        d110MH.calculateResult(runningTime);

        int actual = d110MH.getScore();
        int expected = 975;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesDeca110MHurdlesAbove() {
        CalcTrackAndField d110MHurdles = new CalcTrackAndField();
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double A = 5.74352;
        double B = 28.5;
        double C = 1.92;
        double runningTime = 28.1;


        int actual = d110MH.getScore();
        int expected = 0;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesDeca110MHurdlesOnPoint() {
        CalcTrackAndField d110MHurdles = new CalcTrackAndField();
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double A = 5.74352;
        double B = 28.5;
        double C = 1.92;
        double runningTime = 28.09;

        d110MH.calculateResult(runningTime);

        int actual = d110MH.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testUpperBoundaryValuesDeca110MHurdlesBelow() {
        CalcTrackAndField d110MHurdles = new CalcTrackAndField();
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double A = 5.74352;
        double B = 28.5;
        double C = 1.92;
        double runningTime = 28.08;

        d110MH.calculateResult(runningTime);

        int actual = d110MH.getScore();
        int expected = 1;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }

    @Test
    public void testLowerBoundaryValuesResultsDeca110MHurdlesOnPoint() {
        CalcTrackAndField d110MHurdles = new CalcTrackAndField();
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double A = 5.74352;
        double B = 28.5;
        double C = 1.92;
        double runningTime = 10;

        d110MH.calculateResult(runningTime);

        int actual = d110MH.getScore();
        int expected = 1556;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }
    @Test
    public void testLowerBoundaryValuesResultsDeca110MHurdlesAbove() {
        CalcTrackAndField d110MHurdles = new CalcTrackAndField();
        Deca110MHurdles d110MH = new Deca110MHurdles();

        double A = 5.74352;
        double B = 28.5;
        double C = 1.92;
        double runningTime = 10.01;

        d110MH.calculateResult(runningTime);

        int actual = d110MH.getScore();
        int expected = 1554;

        assertEquals(expected, actual);
        System.out.println("Expected: " +expected +" \n"+ "Actual: " +actual);
    }
}


