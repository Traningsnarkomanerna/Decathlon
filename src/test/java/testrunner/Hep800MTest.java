package testrunner;

import common.CalcTrackAndField;
import heptathlon.Hep800M;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class Hep800MTest {

    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(0.11193, 254, 1.88, runningTime);
    }

    @Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        Hep800M h800M = new Hep800M();

        double runningTime = 120;

        h800M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h800M.getScore();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        Hep800M h800M = new Hep800M();

        double runningTime = 255;

        h800M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h800M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        Hep800M h800M = new Hep800M();

        double runningTime = 254;

        h800M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h800M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        Hep800M h800M = new Hep800M();

        double runningTime = 253;

        h800M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h800M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        Hep800M h800M = new Hep800M();

        double runningTime = 71;

        h800M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h800M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        Hep800M h800M = new Hep800M();

        double runningTime = 70;

        h800M.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h800M.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        Hep800M h800M = new Hep800M();

        double runningTime = 69;

        h800M.calculateResult(runningTime);

        int expected = -1;
        int actual = h800M.getScore();

        assertEquals(expected, actual);
    }
}
