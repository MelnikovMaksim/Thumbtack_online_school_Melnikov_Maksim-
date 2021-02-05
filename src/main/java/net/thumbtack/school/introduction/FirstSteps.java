package net.thumbtack.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x+y;
    }

    public int mul(int x, int y) {
        return x*y;
    }

    public int div(int x, int y) {
        return x/y;
    }

    public int mod(int x, int y) {
        return x%y;
    }

    public boolean isEqual(int x, int y) {
        return x==y;
    }

    public boolean isGreater(int x, int y) {
        return x>y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x>=xLeft & x<=xRight  &  y>=yTop & y<=yBottom;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum+=array[i];
        }
        return sum;
    }

    public int mul(int[] array) {
        if (array.length==0)
                return 0;
        int mul = 1;
        for (int i=0; i<array.length; i++) {
            mul*=array[i];
        }
        return mul;
    }

    public int min(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<array.length; i++) {
            if (array[i]< minValue)
                minValue =array[i];
        }
        return minValue;
    }

    public int max(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<array.length; i++) {
            if (array[i]>maxValue)
                maxValue=array[i];
        }
        return maxValue;
    }

    public double average(int[] array) {
        if (array.length==0)
            return 0;
        return (double)sum(array)/array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        if (array.length<=1)
            return true;
        int i;
        for (i=0; i<array.length-1; i++){
            if (array[i]<=array[i+1])
                break;
        }
        return i==array.length-1;
    }

    public void cube(int[] array) {
        for (int i=0; i<array.length; i++) {
            array[i]*=array[i]*array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int i=0; i<array.length; i++) {
            if (array[i]==value){
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp;
            temp=array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length/2; i++)
            if (array[i]!=array[array.length-1-i])
                return false;
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++)
            sum+=sum(matrix[i]);
        return sum;
    }

    public int max(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<matrix.length; i++)
            if (maxValue < max(matrix[i]))
                maxValue = max(matrix[i]);
        return maxValue;
    }

    public int diagonalMax(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i]>maxValue)
                maxValue=matrix[i][i];
        return maxValue;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        int i;
        for (i = 0; i < matrix.length; i++) {
            if (isSortedDescendant(matrix[i])==false)
                break;
        }
        return i==matrix.length;
    }
}
