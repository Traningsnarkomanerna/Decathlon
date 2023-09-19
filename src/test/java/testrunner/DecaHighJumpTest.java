package testrunner;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class DecaHighJumpTest extends TestCase {
    @Test
    //Testing if it's showing rounded score after using a distance with 43.75

    public void testDecaHighJump_RoundedScore() {
        var decaHighJump = new decathlon.DecaHighJump();
        double A = 0.8465;
        double B = 75;
        double C = 1.42;

        double distance = 150.75;
        int expectedScore = (int) (A * Math.pow(distance - B, C));
        int actualScore = decaHighJump.calculateResult(distance);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaHighJump_HighScore() {
        var decaHighJump = new decathlon.DecaHighJump();
        double A = 0.8465;
        double B = 75;
        double C = 1.42;

        double distance = 290.0;
        int expectedScore = (int) (A * Math.pow(distance - B, C));
        int actualScore = decaHighJump.calculateResult(distance);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testDecaHighJump_LowScore() {
        var decaHighJump = new decathlon.DecaHighJump();
        double A = 0.8465;
        double B = 75;
        double C = 1.42;

        double distance = 80.0;
        int expectedScore = (int) (A * Math.pow(distance - B, C));
        int actualScore = decaHighJump.calculateResult(distance);

        assertEquals(expectedScore, actualScore);
    }


}