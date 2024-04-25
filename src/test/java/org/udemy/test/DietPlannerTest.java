package org.udemy.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.udemy.src.Coder;
import org.udemy.src.DietPlan;
import org.udemy.src.DietPlanner;
import org.udemy.src.Gender;

import java.lang.reflect.Executable;

public class DietPlannerTest {
    @Test
    public void calculateDiet(){
        //given
        Coder code=new Coder(1.6,22.34,45, Gender.MALE);
        DietPlanner dietPlanner=new DietPlanner(10,20,70);
        DietPlan dietPlan= dietPlanner.calculateDiet(code);
        //when
        DietPlan dietPlan1=new DietPlan(1043,26,23,183);
        //then
        Assertions.assertAll(
                ()->Assertions.assertEquals(dietPlan.getCalories(),dietPlan1.getCalories()),
                ()->Assertions.assertEquals(dietPlan.getFat(),dietPlan1.getFat()),
                ()->Assertions.assertEquals(dietPlan.getProtein(),dietPlan1.getProtein()),
        ()->Assertions.assertEquals(dietPlan.getCarbohydrate(),dietPlan1.getCarbohydrate())
        );
    }

    @Test
    public void calculateDietforFemale(){
        //given
        Coder code =new Coder(1.6,22.34,23,Gender.FEMALE);
        DietPlanner dietPlanner=new DietPlanner(10,20,70);
        DietPlan expeectde=new DietPlan(1043,32,28,224);
        //when
        DietPlan actual=dietPlanner.calculateDiet(code);
        //then
        Assertions.assertAll(
                ()->Assertions.assertEquals(expeectde.getCarbohydrate(),actual.getCarbohydrate()),
                ()->Assertions.assertEquals(expeectde.getFat(),actual.getFat()),
                ()->Assertions.assertEquals(expeectde.getProtein(),actual.getProtein()),
                ()->Assertions.assertEquals(expeectde.getCarbohydrate(),actual.getCarbohydrate())

        );

    }
    @Test
    public void coveringConstructor() throws RuntimeException{
        //given
            int protin =10;
            int corbo=10;
            int fat=20;
        //when
         Assertions.assertThrows(RuntimeException.class,()->new DietPlanner(protin,corbo,fat));
         //then


    }
}
