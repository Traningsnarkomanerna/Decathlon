package testrunner;
import static org.junit.Assert.*;
import org.junit.Test;


public class Hep200MTest {

    @Test
    public void testCalcResultsInRange(){
        heptathlon.Hep200M hep200m = new heptathlon.Hep200M();
        double A = 4.99087;
        double B = 42.5;
        double C = 1.81;
        double runningTime = 15.0;

        int expectedScore = (int) (A * Math.pow((B - runningTime), C));
        hep200m.calculateResult(runningTime);
        int actualScore = hep200m.getScore();

        assertEquals(expectedScore, actualScore);

    }
    @Test
    public void testCalculateResultsTooHigh(){
        heptathlon.Hep200M hep200m = new heptathlon.Hep200M();
        double runningTime = 1000.0;

        hep200m.calculateResult(runningTime);

        int expectedScore = 0;
        int actualScore = hep200m.getScore();

        assertEquals(expectedScore, actualScore);
    }
    @Test
    public void testCalculateResultsTooLow(){
        heptathlon.Hep200M hep200m = new heptathlon.Hep200M();
        double runningTime = 13.9;

        hep200m.calculateResult(runningTime);

        int expectedScore = 2158;
        int actualScore = hep200m.getScore();

        assertEquals(expectedScore, actualScore);

    }

}
