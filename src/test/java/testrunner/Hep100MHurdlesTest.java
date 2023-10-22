package testrunner;

import common.CalcTrackAndField;
import heptathlon.Hep100MHurdles;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class Hep100MHurdlesTest {
    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double runningTime) {
        return calc.calculateTrack(9.23076, 26.7, 1.835, runningTime);
    }

    @Test
    public void calculateResult_ValidRunningTime_EqualsCorrectResult() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 18;

        h100MH.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h100MH.getScore();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveUpperBoundary_EqualsCorrectResult() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 27.7;

        h100MH.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h100MH.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnUpperBoundary_EqualsCorrectResult() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 26.7;

        h100MH.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h100MH.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowUpperBoundary_EqualsCorrectResult() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 25.7;

        h100MH.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h100MH.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeAboveLowerBoundary_EqualsCorrectResult() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 10;

        h100MH.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h100MH.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeOnLowerBoundary_EqualsCorrectResult() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 9;

        h100MH.calculateResult(runningTime);

        int expected = calculateExpectedScore(runningTime);
        int actual = h100MH.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_RunningTimeBelowLowerBoundary_EqualsNegativeOne() {
        Hep100MHurdles h100MH = new Hep100MHurdles();

        double runningTime = 8;

        h100MH.calculateResult(runningTime);

        int expected = -1;
        int actual = h100MH.getScore();

        assertEquals(expected, actual);
    }
}

