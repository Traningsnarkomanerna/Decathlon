package testrunner;

import common.CalcTrackAndField;
import decathlon.Deca110MHurdles;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Deca110MHurdlesTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(5.74352, 28.5, 1.92, runningTime);
    }

    private Deca110MHurdles deca110MHurdles;

    @Before
    public void setUp() {
        deca110MHurdles = new decathlon.Deca110MHurdles();
    }

    @Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        double runningTime = 14;

        deca110MHurdles.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        double runningTime = 29;

        deca110MHurdles.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        double runningTime = 28.09;

        deca110MHurdles.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        double runningTime = 27;

        deca110MHurdles.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        double runningTime = 11;

        deca110MHurdles.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        double runningTime = 10;

        deca110MHurdles.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        double runningTime = 9;

        deca110MHurdles.calculateResult(runningTime);

        int expected = -1;
        int actual = deca110MHurdles.getScore();

        assertEquals(expected, actual);
    }
}


