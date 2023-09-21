package testrunner;

import static org.junit.Assert.*;

import heptathlon.HeptLongJump;
import org.junit.Test;

public class HeptLongJumpTest {
    @Test
    public void testHeptLongJumpCorrectResult(){
        HeptLongJump lj = new HeptLongJump();

        double A = 0.188807;
        double B = 210;
        double C = 1.41;
        double distance = 700;

        lj.calculateResult(distance);

        int expectedScore = (int) (A * Math.pow((distance - B), C));
        int actualScore = lj.getScore();

        assertEquals(expectedScore, actualScore);
    }
}
