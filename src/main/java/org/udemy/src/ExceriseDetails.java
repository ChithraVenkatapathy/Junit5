package org.udemy.src;

public class ExceriseDetails {
    public static String calculate(int numberDaysExcerceised,int hoursOfTimeCalculated) {
        final int SESSION_TIMING = 45;
        if(numberDaysExcerceised <0 || hoursOfTimeCalculated <0){
            throw new ArithmeticException();
        }
        int timing = hoursOfTimeCalculated + numberDaysExcerceised * SESSION_TIMING;
        double averageTime = timing / 7.0;
        if (averageTime <= 20) {
            return "bad";
        } else if (averageTime >= 20 && averageTime <= 40) {
            return "average";
        } else {
            return "good";
        }

    }

}
