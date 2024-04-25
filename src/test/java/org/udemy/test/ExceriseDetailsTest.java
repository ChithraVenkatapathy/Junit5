package org.udemy.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.udemy.src.ExceriseDetails;

import java.lang.reflect.Executable;

public class ExceriseDetailsTest {

    @Test
    public void calculateTestforbad(){
        //given
        int numberDaysExcerceised=1;
        int hoursOfTimeCalculated=20;
        String expected="bad";
        //when
        String actual=ExceriseDetails.calculate(numberDaysExcerceised,hoursOfTimeCalculated);
        //Then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void calculateTestforaverage(){
        //given
        int numberDaysExcerceised=3;
        int hoursOfTimeCalculated=35;
        String expected="average";
        //when
        String actual=ExceriseDetails.calculate(numberDaysExcerceised,hoursOfTimeCalculated);
        //Then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void calculateTestforgood(){
        //given
        int numberDaysExcerceised=3;
        int hoursOfTimeCalculated=220;
        String expected="good";
        //when
        String actual=ExceriseDetails.calculate(numberDaysExcerceised,hoursOfTimeCalculated);
        //Then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void calculateTestforExceptionThrown(){
        //given
        int numberDaysExcerceised=3;
        int hoursOfTimeCalculated=-34;

        //when

        //Then
        Assertions.assertThrows(ArithmeticException.class,()->ExceriseDetails.calculate(numberDaysExcerceised,hoursOfTimeCalculated));
    }

}
