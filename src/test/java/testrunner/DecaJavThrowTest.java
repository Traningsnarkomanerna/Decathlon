package testrunner;

import common.CalcTrackAndField;
import decathlon.DecaJavelinThrow;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecaJavThrowTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(10.14, 7, 1.08, distance);
    }

    private DecaJavelinThrow decaJavelinThrow;

    @Before
    public void setUp() {
        decaJavelinThrow = new decathlon.DecaJavelinThrow();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 66;

        decaJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 111;

        decaJavelinThrow.calculateResult(distance);

        int expected = -1;
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 110;

        decaJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 109;

        decaJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 8;

        decaJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 7;

        decaJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 6;

        decaJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaJavelinThrow.getScore();

        assertEquals(expected, actual);
    }
}


   /*
   @Test
    public void testJavThrowOverRange() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = 120;

        int expectedScore = 0;             //(int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testJavThrowUnderRange() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = 5;

        String expectedScore =         //(int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testJavThrowBadInput() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = ;

        String expectedScore =         //(int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

    */


