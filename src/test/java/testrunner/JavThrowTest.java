package testrunner;

import decathlon.DecaJavelinThrow;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class JavThrowTest {
    @Test
    public void testJavThrowWithinRange() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = 10;

        int expectedScore = (int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }
}


   /*
   @Test
    public void testJavThrowOverRange() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = 120;

        int expectedScore = 0;             //(int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testJavThrowUnderRange() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = 5;

        String expectedScore =         //(int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testJavThrowBadInput() {
        DecaJavelinThrow jt = new DecaJavelinThrow();
        double A = 10.14;
        double B = 7;
        double C = 1.08;
        double distanceThrown = ;

        String expectedScore =         //(int) (A * Math.pow((B - distanceThrown), C));
        int actualScore = jt.getScore();
        assertEquals(expectedScore, actualScore);
    }

    */


