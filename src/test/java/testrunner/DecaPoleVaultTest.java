package testrunner;

import common.CalcTrackAndField;
import decathlon.DecaPoleVault;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DecaPoleVaultTest {

    private final CalcTrackAndField calc = new CalcTrackAndField();

    private int calculateExpectedScore(double distance) {
        return calc.calculateField(0.2797, 100, 1.35, distance);
    }

    private DecaPoleVault decaPoleVault;

    @Before
    public void setUp() {
        decaPoleVault = new decathlon.DecaPoleVault();
    }

    @Test
    public void calculateResult_ValidDistance_EqualsCorrectResult() {
        double distance = 500;

        decaPoleVault.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveUpperBoundary_EqualsNegativeOne() {
        double distance = 1001;

        decaPoleVault.calculateResult(distance);

        int expected = -1;
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnUpperBoundary_EqualsCorrectResult() {
        double distance = 1000;

        decaPoleVault.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowUpperBoundary_EqualsCorrectResult() {
        double distance = 999;

        decaPoleVault.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceAboveLowerBoundary_EqualsCorrectResult() {
        double distance = 101;

        decaPoleVault.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceOnLowerBoundary_EqualsCorrectResult() {
        double distance = 100;

        decaPoleVault.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateResult_DistanceBelowLowerBoundary_EqualsCorrectResult() {
        double distance = 99;

        decaPoleVault.calculateResult(distance);

        int expected = calculateExpectedScore(distance);
        int actual = decaPoleVault.getScore();

        assertEquals(expected, actual);
    }
}
