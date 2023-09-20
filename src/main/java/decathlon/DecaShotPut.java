package decathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class DecaShotPut {

    private int score;
    private double A = 51.39;
    private double B = 1.5;
    private double C = 1.05;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on distance and height. Measured in meters.
    public void calculateResult(double distance) {

        try {
            // Acceptable values.
            if (distance < 1.53)
                score = 0;
            else if (distance >= 1.53 && distance <= 30) {
                score = calc.calculateField(A, B, C, distance);
            } else {
                score = 1732;
            }
        } catch (Exception e) {

            System.out.println("The result is: " + score);
        }
    }


    /* while (active) {

                try {
                    // Acceptable values.
                    if (distance < 1.52) {
                        System.out.println("Value too low");
                        distance = inputResult.enterResult();
                    } else if (distance > 30) {

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

        } */
    public int getScore() {
        return score;
    }
}
