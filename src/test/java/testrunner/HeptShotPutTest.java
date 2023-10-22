package testrunner;

import static org.junit.Assert.*;

import common.CalcTrackAndField;
import heptathlon.HeptShotPut;
import org.junit.Before;
import org.junit.Test;

public class HeptShotPutTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(56.0211, 1.5, 1.05, distance);
    }
    private HeptShotPut heptShotPut;
    @Before
    public void setUp(){
        heptShotPut = new heptathlon.HeptShotPut();
    }
    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 15;

        heptShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 31;

        heptShotPut.calculateResult(distance);

        int expected = -1;
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 30;

        heptShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 29;

        heptShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 2.5;

        heptShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 1.5;

        heptShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 0.5;

        heptShotPut.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = heptShotPut.getScore();

        assertEquals(expected, actual);
    }
}
