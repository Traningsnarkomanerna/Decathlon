package testrunner;

import common.CalcTrackAndField;
import decathlon.DecaDiscusThrow;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecaDiscusThrowTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(12.91, 4, 1.1, distance);
    }

    private DecaDiscusThrow decaDiscusThrow;

    @Before
    public void setUp() {
        decaDiscusThrow = new decathlon.DecaDiscusThrow();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 36;

        decaDiscusThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 86;

        decaDiscusThrow.calculateResult(distance);

        int expected = -1;
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 85;

        decaDiscusThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 84;

        decaDiscusThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 5;

        decaDiscusThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 4;

        decaDiscusThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 3;

        decaDiscusThrow.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaDiscusThrow.getScore();

        assertEquals(expected, actual);
    }
}