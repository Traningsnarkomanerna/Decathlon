package testrunner;

import static org.junit.Assert.*;

import common.CalcTrackAndField;
import decathlon.DecaLongJump;
import heptathlon.HeptLongJump;
import org.junit.Before;
import org.junit.Test;

public class HeptLongJumpTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(0.188807, 210, 1.41, distance);
    }

    private HeptLongJump heptLongJump;

    @Before
    public void setUp() {
        heptLongJump = new heptathlon.HeptLongJump();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 1200;

        heptLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 1501;

        heptLongJump.calculateResult(distance);

        int expected = -1;
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 1500;

        heptLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 1499;

        heptLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 211;

        heptLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 210;

        heptLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 209;

        heptLongJump.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptLongJump.getScore();

        assertEquals(expected, actual);
    }
}
