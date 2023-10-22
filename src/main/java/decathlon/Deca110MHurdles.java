package decathlon;

import common.CalcTrackAndField;

public class Deca110MHurdles {
    private int score;
    private double A = 5.74352;
    private double B = 28.5;
    private double C = 1.92;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {
        // Acceptable values.
        if (runningTime < 10) {
            System.out.println("Value too low");
            score = -1;
        } else if (runningTime >= 10 && runningTime <= 28.5) {
            score = calc.calculateTrack(A, B, C, runningTime);
        } else {
            score = 0;
        }
        return score;
    }

    /*	while (active) {

            try {
                // Acceptable values.
                if (runningTime < 10) {
                    System.out.println("Value too low");
                    runningTime = inputResult.enterResult();
                } else if (runningTime > 28.09) {
                    System.out.println("Value too high");
                    runningTime = inputResult.enterResult();
                } else {
                    score = calc.calculateTrack(A, B, C, runningTime);
                    active = false;
                }
            } catch (Exception e) {

                System.out.println("Please enter numbers");
            }
        }
        System.out.println("The result is " + score);
    }     */
    public int getScore() {
        return score;
    }
}
