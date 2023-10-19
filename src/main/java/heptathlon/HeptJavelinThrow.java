package heptathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class HeptJavelinThrow {

    private int score;
    private double A = 15.9803;
    private double B = 3.8;
    private double C = 1.04;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on distance and height. Measured in metres.
    public void calculateResult(double distance) {
        while (active) {

          try { //result = (int) (A * Math.pow((distance - 3.8), C)
                  //the score should be 0 if the result is smaller than 3.8
                if (distance <= 3.8) {
                    score = 0;
                    active = false;
                } else if (distance > 100) {   //world record 80.00 m
                    System.out.println("Value too high");
                    distance = inputResult.enterResult();
                } else {
                    score = calc.calculateField(A, B, C, distance);
                    active = false;
                }
            } catch (Exception e) {

                System.out.println("Please enter numbers");
            }
        }
        System.out.println("The result is: " + score);
    }

    public int getScore() {
        return score;
    }

}
