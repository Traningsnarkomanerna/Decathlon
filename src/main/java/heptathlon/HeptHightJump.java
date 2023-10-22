package heptathlon;

import common.CalcTrackAndField;

public class HeptHightJump {
    private int score;
    private double A = 1.84523;
    private double B = 75;
    private double C = 1.348;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on distance and height. Measured in centimeters.
    public int calculateResult(double distance) {
        // Acceptable values.
        if (distance < 76)
            score = 0;
        else if (distance >= 76 && distance <= 270) {
            score = calc.calculateField(A, B, C, distance);
        } else {
            System.out.println("Value too high");
            score = -1;
        }
        return score;
    }

    /*while (active) {

        try {
            // Acceptable values in cm
            if (distance < 76) {
                System.out.println("Value too low");
                distance = inputResult.enterResult();
            } else if (distance > 270) {

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
}*/
    public int getScore() {
        return score;
    }
}
