package testrunner;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Deca100MTest {
private decathlon.Deca100M deca100M;

@Before
public void setUp(){
    deca100M = new decathlon.Deca100M();
}

    //Testing if the entered result is giving correct point score
    @Test
    public void testRunningTimeToGettScoreInRange(){
        //decathlon.Deca100M deca100m = new decathlon.Deca100M();
        double A = 25.4347;
        double B = 18;
        double C = 1.81;

        double runningTime = 10.0;
        int expectedScore = (int) (A * Math.pow((B - runningTime), C));
        deca100M.calculateResult(runningTime);

        int actualScore = deca100M.getScore();

        assertEquals(expectedScore, actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }
    @Test
    public void testRunningTimeOfLowestCorrectValue(){

        double runningTime = 5;
        int expectedScore = 2640;

        deca100M.calculateResult(runningTime);

        int actualScore = deca100M.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }
    @Test
    public void testRunningTimeOfLowestValueOutOfRange() {
        // Test with a running time below the acceptable range
        double runningTime = 4.99;
        int expectedScore = 0;

        int actualScore = deca100M.getScore();

        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);

    }
    @Test
    public void testRunningTimeOfHighCorrectValue(){

        double runningTime = 17.83;
        int expectedScore = 1;

        deca100M.calculateResult(runningTime);

        int actualScore = deca100M.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);
    }
    @Test
    public void testRunningTimeOfHighValueOutOfRange(){

        double runningTime = 17.84;
        int expectedScore = 0;

        deca100M.calculateResult(runningTime);

        int actualScore = deca100M.getScore();
        assertEquals(expectedScore,actualScore);
        System.out.println("Expected: " + expectedScore + " \n" + "Actual: " + actualScore);

    }

}
