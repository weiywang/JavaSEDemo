package pdd;

import java.util.*;

public class A02_ConactStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] words = in.nextLine().split(" ");
            if(null == words || words.length < 2) System.out.println("false");
            boolean[] isUsed = new boolean[words.length];
            boolean flag = backtrack(words, new ArrayList<String>(), isUsed);
            if(flag) System.out.println("true");
            else System.out.println("false");
        }
    }

    private static boolean backtrack(String[] words, ArrayList<String> curList, boolean[] isUsed) {
        boolean flag = false;

        //不知道这块代码的作用：递归的终止条件
        if(words.length == curList.size()) {
            String first = curList.get(0);
            String last = curList.get(curList.size()-1);
            return last.charAt(last.length()-1) == first.charAt(0);
        }


        for(int i = 0; i < words.length; ++i) {
            if(isUsed[i]) continue;
            if(curList.size() == 0) {
                curList.add(words[i]);
            } else {
                String prev = curList.get(curList.size()-1);
                if(prev.charAt(prev.length()-1) != words[i].charAt(0)) continue;
                curList.add(words[i]);
            }
            isUsed[i] = true;
            flag = backtrack(words, curList, isUsed);
            isUsed[i] = false;
            curList.remove(curList.size()-1);
            if(flag) break;
        }

        return flag;
    }
}
