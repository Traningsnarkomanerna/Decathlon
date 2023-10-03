package testrunner;

import heptathlon.Hep800M;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Hep800MTest {

    @Test
    public void test1() { //to check if the result has been rounded down
        Hep800M test = new Hep800M();

        test.calculateResult(250);
        //int expected =1;
        int actual = test.getScore();   //A*(B-P) C
        int expected = (int) Math.floor(0.11193 * Math.pow( 254-250, 1.88));
        assertEquals(expected, actual);
    }
    @Test
    public void test2() { //to check a typical number, when B=P, the result should be 0 according to the formula
        Hep800M test = new Hep800M();

        test.calculateResult(254);
        int expected =0;
        int actual = test.getScore();
        assertEquals(expected, actual);
    }

    @Test
    public void test3() { // put in a random valid number to check if the calculator works properly
        Hep800M test = new Hep800M();

        test.calculateResult(70);
        int expected =2026;
        int actual = test.getScore();
        assertEquals(expected, actual);
    }

//test case 1,2 failed as the developer has set two acceptable values in the program which is not included in the requirement
}
