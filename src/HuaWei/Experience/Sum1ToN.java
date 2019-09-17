package HuaWei.Experience;

import java.util.*;
public class Sum1ToN {
    private int res = 0;
    private void print(List<Integer> list) {
        for (Integer k : list) {
            System.out.print(k + "+");
        }
    }

    private int count(List<Integer> list){
        int tempRes = 0;
        for(Integer num : list){
            tempRes += num;
        }
        return tempRes;
    }

    private void f(int n, List<Integer> list, int start) {
        if (n == 1) {
            print(list);
            System.out.println(1);
        } else {
            for (int i = start; i <=n / 2; i++) {
                list.add(i);
                f(n - i, list, i);
                list.remove(list.size() -1);
            }
            print(list);
            res = Math.max(res, count(list));
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Sum1ToN exam = new Sum1ToN();
        exam.f(9,list, 1);
        System.out.println(exam.res);
    }
}
