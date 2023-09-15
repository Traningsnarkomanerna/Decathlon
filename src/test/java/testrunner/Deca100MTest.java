package decathlon;
import static org.junit.Assert.*;
import org.junit.Test;

public class Deca100MTest {

    @Test
    public void testCalcResultWithinRange(){
        Deca100M deca100m = new Deca100M();
        double A = 25.4347;
        double B = 18;
        double C = 1.81;

        double runningTime = 10.0;
        int expectedScore = (int) (A * Math.pow((B - runningTime), C));
        deca100m.calculateResult(runningTime);

        int actualScore = deca100m.getScore();

        assertEquals(expectedScore, actualScore);
    }

}
