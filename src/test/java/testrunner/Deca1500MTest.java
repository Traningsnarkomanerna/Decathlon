package testrunner;

import common.CalcTrackAndField;
import decathlon.Deca1500M;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Deca1500MTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(0.03768, 480, 1.85, runningTime);
    }

    private Deca1500M deca1500M;

    @Before
    public void setUp() {
        deca1500M = new decathlon.Deca1500M();
    }

    @org.junit.Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        double runningTime = 300.20;

        deca1500M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        double runningTime = 481;

        deca1500M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        double runningTime = 480;

        deca1500M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        double runningTime = 479;

        deca1500M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        double runningTime = 151;

        deca1500M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        double runningTime = 150;

        deca1500M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        double runningTime = 149;

        deca1500M.calculateResult(runningTime);

        int expected = -1;
        int actual = deca1500M.getScore();

        assertEquals(expected, actual);
    }
}
