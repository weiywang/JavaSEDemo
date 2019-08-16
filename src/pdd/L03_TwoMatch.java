package pdd;

import java.util.*;

public class L03_TwoMatch {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);

        int max=0,min=Integer.MAX_VALUE;
        for(int i=0,j=n-1;i<n/2;i++,j--){
            max=Math.max(max,a[i]+a[j]);
            min=Math.min(min,a[i]+a[j]);
        }
        System.out.println(max-min);
    }
}
