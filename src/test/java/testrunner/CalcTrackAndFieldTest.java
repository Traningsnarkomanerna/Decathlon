package testrunner;
import static org.junit.Assert.*;
import org.junit.Test;
public class CalcTrackAndFieldTest {

    @Test
    public void calcFieldTest(){
        common.CalcTrackAndField fieldTest = new common.CalcTrackAndField();
        double A = 10.14; // number belongs to DecaJavelinThrow
        double B = 7; // number belongs to DecaJavelinThrow
        double C = 1.08; // number belongs to DecaJavelinThrow

        double distance = 50;
        int expectedScore = 589;
        int actualScore = fieldTest.calculateField(A, B, C, distance);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void calcTrackTest(){
        common.CalcTrackAndField trackTest = new common.CalcTrackAndField();
        double A = 4.99087; // number belongs to Hep200M
        double B = 42.5; // number belongs to Hep200M
        double C = 1.81; // number belongs to Hep200M

        double distance = 20;
        int expectedScore = 1398;
        int actualScore = trackTest.calculateTrack(A, B, C, distance);

        assertEquals(expectedScore, actualScore);

    }
}
