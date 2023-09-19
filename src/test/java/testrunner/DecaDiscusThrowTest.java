package decathlon;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class DecaDiscusThrowTest extends TestCase {
    @Test
    //Testing if it's showing rounded score after using a distance with 43.75

    public void testDecaDiscusThrow_RoundedScore() {
        var decaDiscusThrow = new decathlon.DecaDiscusThrow();
        double A = 12.91;
        double B = 4;
        double C = 1.1;

        double distance = 43.75;
        int expectedScore = (int) (A * Math.pow(distance - B, C));
        int actualScore = decaDiscusThrow.calculateResult(distance);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaDiscusThrow_HighScore() {
        var decaDiscusThrow = new decathlon.DecaDiscusThrow();
        double A = 12.91;
        double B = 4;
        double C = 1.1;

        double distance = 70.0;
        int expectedScore = (int) (A * Math.pow(distance - B, C));
        int actualScore = decaDiscusThrow.calculateResult(distance);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaDiscusThrow_LowScore() {
        var decaDiscusThrow = new decathlon.DecaDiscusThrow();
        double A = 12.91;
        double B = 4;
        double C = 1.1;

        double distance = 20.0;
        int expectedScore = (int) (A * Math.pow(distance - B, C));
        int actualScore = decaDiscusThrow.calculateResult(distance);

        assertEquals(expectedScore, actualScore);
    }

}