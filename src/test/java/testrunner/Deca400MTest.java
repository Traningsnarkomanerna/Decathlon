package testrunner;

import common.CalcTrackAndField;
import decathlon.Deca400M;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Deca400MTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(1.53775, 82, 1.81, runningTime);
    }

    private Deca400M deca400M;

    @Before
    public void setUp() {
        deca400M = new decathlon.Deca400M();
    }

    @Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        double runningTime = 49;

        deca400M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        double runningTime = 83;

        deca400M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        double runningTime = 82;

        deca400M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        double runningTime = 81;

        deca400M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        double runningTime = 21;

        deca400M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        double runningTime = 20;

        deca400M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        double runningTime = 19;

        deca400M.calculateResult(runningTime);

        int expected = -1;
        int actual = deca400M.getScore();

        assertEquals(expected, actual);
    }
}
