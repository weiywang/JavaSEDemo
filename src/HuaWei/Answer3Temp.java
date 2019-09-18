package HuaWei;

import java.util.*;
public class Answer3Temp {
    public static void main(String[] args) {
        HashMap<String, String> mapA = new HashMap<>();
        HashMap<String, String> mapB = new HashMap<>();
        StringBuilder res = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < m; i++){
            String temp = sc.nextLine();
            String left = temp.substring(0, 9);
            String right = temp.substring(10, temp.length());
            mapA.put(left, right);
        }

        int n = sc.nextInt();
        sc.nextLine();
        for(int j = 0; j < n; j++){
            String temp = sc.nextLine();
            String left = temp.substring(0, 9);
            String right = temp.substring(10, temp.length());
            mapB.put(left, right);
        }

        Set<String> setA = mapA.keySet();
        for(String str : setA){
            if(mapB.containsKey(str)){
                res.append(mapB.get(str)+","+mapA.get(str)+"\n");
            }else{
                res.append(str+","+mapA.get(str)+"\n");
            }
        }

        System.out.print(res);


    }
}
