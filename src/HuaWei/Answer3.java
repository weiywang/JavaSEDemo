package HuaWei;

import java.util.*;
public class Answer3 {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<String, String> mapA = new HashMap<>();
        for(int i = 0; i < m; i++){
            String temp = sc.nextLine();
            String left = temp.substring(0, 9);
            String right = temp.substring(10, temp.length());
            mapA.put(left, right);
        }

        int n = sc.nextInt();
        HashMap<String, String> mapB = new HashMap<>();
        for(int i = 0; i < n; i++){
            String temp = sc.nextLine();
            String left = temp.substring(0, 9);
            String right = temp.substring(10, temp.length());
            mapB.put(left, right);
        }

        Set<String> setA = mapA.keySet();
        for(String str : setA){
            if(mapB.containsKey(str)){
                res.append(mapB.get(str)+mapA.get(str)+"\n");
            }else{
                res.append(str+mapA.get(str)+"\n");
            }
        }

        System.out.println(res);


    }
}
