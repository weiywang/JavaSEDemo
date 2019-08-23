package PrepareForAli.BackTrack;

import java.util.*;

public class NQueen {


    private List<List<String>> res;

    private int[] resArray;

    private int n;



    public List<List<String>> solveNQueens(int n) {

        this.n = n;

        res = new ArrayList<List<String>>();

        resArray = new int[n];

        backTrack(0);

        return res;
    }


    //解决不了的问题1：backTrack返回值的问题 直接在类中声明成员变量
    //解决不了的问题2：如何返回List<List<String>> res,或者说在什么时候返回 直接在类中声明成员变量
    //解决不了的问题3:int[]是值传递，List<List<String>> res 是值传递还是引用传递


    //返回类型为void的方法可以没有return语句
    public void backTrack(int k){
        if(k >= n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(j == resArray[i]){
                        stringBuilder.append('Q');
                    }else {
                        stringBuilder.append('.');
                    }
                }
                temp.add(stringBuilder.toString());
            }
            res.add(temp);
            return;
        }
        else {
            for (int i = 0; i < n; i++) {
                resArray[k] = i;
                if (isValid(k)) {
                    backTrack(k + 1);
                }
            }
        }
        //这里没有返回，for循环前加else
        //return
        return;
    }



    public boolean isValid(int k){
        for(int i = 0; i < k; i++){
            if(resArray[i] == resArray[k] || (Math.abs(resArray[i] - resArray[k]) == k-i)){
                return false;
            }
        }
        return true;
    }


    //这个写法是错误的
//    public boolean isValid(int[] resArray, int k){
//        for(int i = 0; i < k; i++){
//            for(int j = i+1; j < k; j++){
//                if(resArray[i] == resArray[j] || (Math.abs(resArray[i] - resArray[j]) == j-i)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    public void main(String[] Args){
//        solveNQueens(8);
//    }
}
