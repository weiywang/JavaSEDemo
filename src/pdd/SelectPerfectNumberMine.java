package pdd;

import java.util.*;

public class SelectPerfectNumberMine {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] phoneNumber = sc.nextLine().toCharArray();
        int[] numbers = new int[10];//初始化后值为0

        for(int i = 0;i < n;i++){
            numbers[phoneNumber[i] - '0']++;
        }

        int cost = Integer.MAX_VALUE;
        char[] res = new char[n];//char[] res是不行的，必须初始化

        for(int i = 0;i < 10;i++){
            int tempK = k - numbers[i];
            if(tempK <= 0){
                cost = 0;
                res = phoneNumber;
                break;
            }

            int tempCost = 0;//初始化为0
            char[] tempRes = new char[n];//char[] tempRes是不行的，必须初始化
            for(int j = 0;j < n;j++){
                tempRes[j] = phoneNumber[j];
            }

            int l = i-1;//i=0时也没有关系，因为phoneNumber中没有值为-1的数
            int r = i+1;//i=9时也没有关系，因为phoneNumber中没有值为10的数


            //对参考答案中的本循环有疑问,对参考答案中的l,r 循环的执行顺序以及遍历顺序做了调整
            while(tempK > 0){//这个循环条件写不好，写成了 l >= 0 && r <= 9

                if(l >= 0){
                    for(int v = 0;v < n && tempK > 0;v++){
                        if(tempRes[v] == l + '0'){
                            tempRes[v] = (char)(l + '0');
                            tempCost += i - l;
                            tempK--;
                        }
                    }
                }

                if(r < 10) {
                    for (int v = n-1; v >= 0 && tempK > 0; v--) {//因为小循环中仍需要操作tempK,故循环条件要包含tempK > 0
                        if(tempRes[v] == r + '0'){
                            tempRes[v] = (char)(r + '0');
                            tempK--;
                            tempCost += r - i;//不能写成tempCost++
                        }
                    }
                }
                l--;
                r++;
            }
            if(tempCost < cost){
                cost = tempCost;
                res = tempRes;
            }
        }
        System.out.println(cost);
        System.out.println(new String(res));//res
    }
}
