package HuaWei;

import java.util.*;

public class HuaWei {


    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine().replaceAll(",\"\"","<");


        String[] strs = inputStr.split(",");
        int n = strs.length;

        System.out.println(n);

        for(int i = 0; i < n; i++){
            if(strs[i].contains("<")){
                strs[i] = strs[i].substring(1, strs[i].length()-1);
                strs[i] = strs[i].replaceAll("<",",\"");
            }
            if(strs[i].equals(" ")){
                strs[i] = "--";
            }
            if(i == n-1) {
                System.out.print(strs[i]);
            }
            else System.out.println(strs[i]);
        }
    }

}
