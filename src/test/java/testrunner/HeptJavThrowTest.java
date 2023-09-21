package testrunner;

import heptathlon.HeptJavelinThrow;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class HeptJavThrowTest {

    @Test
    public void testJavThrowWithinRange() {
        HeptJavelinThrow jt = new HeptJavelinThrow();
        double A = 15.9803;
        double B = 3.8;
        double C = 1.04;
        double distanceThrown = 10;

        int expectedScore = (int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

}
