package testrunner;

import static org.junit.Assert.*;

import heptathlon.HeptShotPut;
import org.junit.Test;

public class HeptShotPutTest {
    @Test
    public void testHeptShotPutCorrectResult(){
        HeptShotPut sp = new HeptShotPut();

        double A = 56.0211;
        double B = 1.5;
        double C = 1.05;
        double distance = 29;

        sp.calculateResult(distance);

        int expectedScore = (int) (A * Math.pow((distance - B), C));
        int actualScore = sp.getScore();

        assertEquals(expectedScore, actualScore);
    }
}
