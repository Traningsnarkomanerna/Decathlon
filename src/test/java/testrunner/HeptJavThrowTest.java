package testrunner;

import common.CalcTrackAndField;
import heptathlon.HeptJavelinThrow;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class HeptJavThrowTest {

    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(15.9803, 3.8, 1.04, distance);
    }

    private HeptJavelinThrow heptJavelinThrow;

    @Before
    public void setUp() {
        heptJavelinThrow = new heptathlon.HeptJavelinThrow();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 55;

        heptJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 101;

        heptJavelinThrow.calculateResult(distance);

        int expected = -1;
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 100;

        heptJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 99;

        heptJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 4.8;

        heptJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 3.8;

        heptJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 2.8;

        heptJavelinThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptJavelinThrow.getScore();

        assertEquals(expected, actual);
    }
}
