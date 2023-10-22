package testrunner;

import common.CalcTrackAndField;
import heptathlon.HeptHightJump;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class HeptHighJumpTest {

    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(1.84523, 75, 1.348, distance);
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 150;

        hHJ.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = hHJ.getScore();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 271;

        hHJ.calculateResult(distance);

        int expected = -1;
        int actual = hHJ.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 270;

        hHJ.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = hHJ.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 269;

        hHJ.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = hHJ.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 76;

        hHJ.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = hHJ.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 75;

        hHJ.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = hHJ.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        HeptHightJump hHJ = new HeptHightJump();

        double distance = 74;

        hHJ.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = hHJ.getScore();

        assertEquals(expected, actual);
    }
}

