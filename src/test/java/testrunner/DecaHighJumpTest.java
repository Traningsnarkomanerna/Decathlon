package testrunner;

import static org.junit.Assert.*;

import common.CalcTrackAndField;
import decathlon.DecaHighJump;
import org.junit.Before;
import org.junit.Test;

public class DecaHighJumpTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(0.8465, 75, 1.42, distance);
    }

    private DecaHighJump decaHighJump;

    @Before
    public void setUp() {
        decaHighJump = new decathlon.DecaHighJump();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 200;

        decaHighJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 301;

        decaHighJump.calculateResult(distance);

        int expected = -1;
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 300;

        decaHighJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 299;

        decaHighJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 76;

        decaHighJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 75;

        decaHighJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 74;

        decaHighJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaHighJump.getScore();

        assertEquals(expected, actual);
    }
}