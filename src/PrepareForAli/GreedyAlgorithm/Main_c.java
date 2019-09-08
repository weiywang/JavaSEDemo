package PrepareForAli.GreedyAlgorithm;


import java.util.*;

public class Main_c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = solu(n+m-1, m) % 1000000007;
        System.out.print(res);

    }
    public static int solu(int n, int k){
        if(n > 34 || (n == 34 && k>= 16 && k <=18)){
            //throw new IllegalArgumentException(0)
            return 0;
        }
        check_(n, k);
        if(k <= 1){
            return k == 0 ? 1 : n;
        }
        if(k > (n >>>1)){
            return solu(n, n-k);
        }
        return solu(n-1, k-1) + solu(n-1, k);
    }

    public static void check_(int n, int k){
        if(k < 0 || k > n){
            return;
        }
    }
}
