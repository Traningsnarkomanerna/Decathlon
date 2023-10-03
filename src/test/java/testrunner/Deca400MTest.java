package testrunner;

import decathlon.Deca400M;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Deca400MTest {
    @Test
    public void shouldCalculate400m() {
        Deca400M deca400M = new Deca400M();
        double A = 1.53775;
        double B = 82;
        double C = 1.81;

        double runningTime = 49.0;
        int expectedScore = (int) (A * Math.pow((B - runningTime), C));
        deca400M.calculateResult(runningTime);

        int actualScore = deca400M.getScore();

        assertEquals(expectedScore, actualScore);
    }
}
