package testrunner;
import decathlon.DecaPoleVault;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DecaPoleVaultTest {

    @Test
    public void PoleVaultingWithinRange(){
        DecaPoleVault pv = new DecaPoleVault();
        double A = 0.2797;
        double B = 100;
        double C = 1.35;
        double distance = 10;

        int expected = (int) (A * Math.pow((distance - B), C));
        int actual = pv.getScore();

        assertEquals(expected, actual);
    }

}
