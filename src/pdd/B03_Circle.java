package pdd;

import java.util.*;

public class B03_Circle {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int n = sc.nextInt();

        int[] position = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            position[i] = sc.nextInt();
            if(position[i] > l/2){
                position[i] = position[i] - l;
            }
            sum += position[i];
        }

        long aim = Math.round((sum*1.0)/n);
        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.abs(position[i] - aim);
        }

        res -= n;
        System.out.println(res);
    }
}
