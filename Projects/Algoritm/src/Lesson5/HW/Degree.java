package Lesson5.HW;

public class Degree {
    public static void main(String[] args) { // первая задача
        System.out.println(degree(2, 4));
    }

    public static int degree(int n, int k) {
        if (k==1){
            return n*k;
        }
        return n*degree(n, k-1);
    }
}
