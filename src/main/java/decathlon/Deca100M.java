package decathlon;

import common.*;

public class Deca100M {
    private int score;
    private double A = 25.4347;
    private double B = 18;
    private double C = 1.81;
    CalcTrackAndField calc = new CalcTrackAndField();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {
        if (runningTime < 5) {
            System.out.println("Value too low");
            score = -1;
        } else if (runningTime >= 18) {
            score = 0;
        } else {
            score = calc.calculateTrack(A, B, C, runningTime);
        }
        return score;
    }

    public int getScore() {
        return score;
    }
}

