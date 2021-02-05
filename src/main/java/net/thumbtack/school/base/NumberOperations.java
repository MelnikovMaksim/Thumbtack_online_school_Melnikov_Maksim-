package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {
    public static Integer find(int[] array, int value){
        for (Integer i = 0; i < array.length; i++) //foreach - java.lang.ArrayIndexOutOfBoundsException
            if (array[i] == value)
                return i;
        return null;
    }

    public static Integer find(double[] array, double value, double eps){
        for (Integer i = 0; i < array.length; i++)
            if (Math.abs(array[i]-value)<=eps)
                return i;
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max){
        Double result = weight/volume;
        if (result<=max & result>=min)
            return result;
        else return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value){
        for (Integer i = 0; i < array.length; i++)
            if (array[i].equals(value))
                return i;
        return null;
    }

    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max){
        if (weight.divide(volume).compareTo(max)<=0 & weight.divide(volume).compareTo(min)>=0)
            return weight.divide(volume);
        else return null;
    }
}
