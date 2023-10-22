package testrunner;
import static org.junit.Assert.*;

import common.CalcTrackAndField;
import heptathlon.Hep200M;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Hep200MTest {

    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(4.99087, 42.5, 1.81, runningTime);
    }

    @Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        Hep200M h200M = new Hep200M();

        double runningTime = 25;

        h200M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h200M.getScore();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        Hep200M h200M = new Hep200M();

        double runningTime = 43.5;

        h200M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h200M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        Hep200M h200M = new Hep200M();

        double runningTime = 42.5;

        h200M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h200M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        Hep200M h200M = new Hep200M();

        double runningTime = 41.5;

        h200M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h200M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        Hep200M h200M = new Hep200M();

        double runningTime = 15;

        h200M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h200M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        Hep200M h200M = new Hep200M();

        double runningTime = 14;

        h200M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h200M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        Hep200M h200M = new Hep200M();

        double runningTime = 13;

        h200M.calculateResult(runningTime);

        int expected = -1;
        int actual = h200M.getScore();

        assertEquals(expected, actual);
    }
}
