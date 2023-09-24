package testrunner;

import decathlon.Deca1500M;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class Deca1500MTest {
    @Test
    public void test1() { //to check if the result has been rounded down
        Deca1500M test = new Deca1500M();

        test.calculateResult(70);
        //int expected =1;
        int actual = test.getScore();   //A*(B-P) C
        int expected = (int) Math.floor(0.03768 * Math.pow( 480-70, 1.85));
        assertEquals(expected, actual);
    }
    @Test
    public void test2() { //to check a typical number, when B=P, the result should be 0 according to the formula
        Deca1500M test = new Deca1500M();

        test.calculateResult(480);
        int expected =0;
        int actual = test.getScore();
        assertEquals(expected, actual);
    }

    @Test
    public void test3() { // put in a random valid number to check if the calculator works properly
        Deca1500M test = new Deca1500M();

        test.calculateResult(60);
        int expected =2686;
        int actual = test.getScore();
        assertEquals(expected, actual);
    }

//All test cases failed as the developer has set two acceptable values in the program which is not included in the requirement

}
