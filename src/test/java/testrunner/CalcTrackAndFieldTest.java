package testrunner;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTrackAndFieldTest {

    @Test
    public void calculateField_ValidDistance_CorrectResult() {
        common.CalcTrackAndField fieldTest = new common.CalcTrackAndField();
        double A = 10.14; // number belongs to DecaJavelinThrow
        double B = 7; // number belongs to DecaJavelinThrow
        double C = 1.08; // number belongs to DecaJavelinThrow

        double distance = 50;
        int expected = 589;
        int actual = fieldTest.calculateField(A, B, C, distance);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateTrack_ValidRunningTime_CorrectResult() {
        common.CalcTrackAndField trackTest = new common.CalcTrackAndField();
        double A = 4.99087; // number belongs to Hep200M
        double B = 42.5; // number belongs to Hep200M
        double C = 1.81; // number belongs to Hep200M

        double runningTime = 20;
        int expected = 1398;
        int actual = trackTest.calculateTrack(A, B, C, runningTime);

        assertEquals(expected, actual);

    }
}
