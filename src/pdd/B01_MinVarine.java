package pdd;

import java.util.*;

public class B01_MinVarine {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        Double res = Double.MAX_VALUE;
        for(int i = 0; i < n-2; i++){
            double average = (double)(numbers[i]+numbers[i+1]+numbers[i+2])/3;
            double var = (Math.pow((numbers[i]-average),2)+Math.pow((numbers[i+1]-average),2)+
                    Math.pow((numbers[i+2]-average),2))/3;
            res = Math.min(res, var);
        }
        System.out.printf("%.2f", res);
    }

}
