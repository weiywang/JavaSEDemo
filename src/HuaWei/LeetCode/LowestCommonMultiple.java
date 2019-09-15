package HuaWei.LeetCode;

import java.util.*;

public class LowestCommonMultiple {
    public static int MAX = 10001;

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1;

        //找出1-10000的质数
        boolean[] prime = new boolean[MAX];

        for(int i = 0; i < MAX; i++){
            prime[i] = true;
        }

        for(int i = 2; i < MAX; i++){
            if(!prime[i]) continue;
            for(int j = 2; j < i; j++){
                if(j % i == 0) prime[i] = false;
            }
        }


        //分解质因数，找出最大对应最大幂
        int[] mi = new int[MAX];
        for(int i = 0; i <= n; i++){
            mi[i] = 0;
        }
        int count;
        for(int i = 2; i <= n; i++){
            int k = i;
            for(int j = 2; j <= n; j++){
                if(!prime[j]) continue;
                count = 0;
                while(k % j == 0){
                    k = k / j;
                    count++;
                }

                if(count > mi[j]) mi[j] = count;
                //已能被0-j的质数整除，不需要继续找j之后的质数，退出本层循环
                if(k == 0) break;
            }
        }


        //每个质数最大幂相乘，即为最小公倍数
        for(int i = 2; i <= n; i++){//循环条件是<=n3
            if(!prime[i]) continue;
            for(int j =0; j < mi[i]; j++){
                res = (res * i) % 987654321;
            }
        }

        System.out.print(res);
    }
}
