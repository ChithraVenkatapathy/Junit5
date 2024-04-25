package org.udemy.src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*

 */
public class FirstJunit {
    public int add(int a,int b){
        return Integer.sum(a,b);
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public Integer divid(int a,int b){
        if(a==0){
            throw new ArithmeticException("A should be not zero");
        }else if(b==0){
            return null;
        }
        return a/b;
    }
    public boolean evenOrOdd(int num){
        return num % 2 == 0;
    }

    public int generateRandomNumber (int limit) throws InterruptedException{
        Thread.sleep(500);
        return new Random().nextInt(limit);
    }

    public int[] arraymultiple(int[] array){

        return Arrays.stream(array).map(x->x * 2).toArray();
    }

    public List<Integer> listIterate(List<Integer> num){
        return num.stream().map(x->x*3).toList();
    }
}
