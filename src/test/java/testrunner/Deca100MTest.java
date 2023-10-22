package testrunner;

import static org.junit.Assert.*;

import common.CalcTrackAndField;
import decathlon.Deca100M;
import org.junit.Before;
import org.junit.Test;

public class Deca100MTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(25.4347, 18, 1.81, runningTime);
    }

    private Deca100M deca100M;

    @Before
    public void setUp() {
        deca100M = new decathlon.Deca100M();
    }

    @Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        double runningTime = 10;

        deca100M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        double runningTime = 19;

        deca100M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        double runningTime = 18;

        deca100M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        double runningTime = 17;

        deca100M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        double runningTime = 6;

        deca100M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        double runningTime = 5;

        deca100M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        double runningTime = 4;

        deca100M.calculateResult(runningTime);

        int expected = -1;
        int actual = deca100M.getScore();

        assertEquals(expected, actual);
    }
}
