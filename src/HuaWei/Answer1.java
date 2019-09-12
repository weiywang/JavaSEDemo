package HuaWei;

import java.util.*;

public class Answer1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] ss =  line.split("\\},");
        String s1 = ss[0].replaceAll("A=\\{","");
        String s2 = ss[1].replaceAll("B=\\{","");
        String s3 = ss[2].replaceAll("R=","");
        String[] s1s = s1.split(",");
        String[] s2s = s2.split(",");
        int[] a = new int[s1s.length];
        int[] b = new int[s2s.length];
        for(int i = 0; i < a.length; i ++){
            a[i] = Integer.parseInt(s1s[i]);
        }
        for(int i = 0; i < b.length; i ++){
            b[i] = Integer.parseInt(s2s[i]);
        }
        int r = Integer.parseInt(s3.trim());
        String s = "";
        for(int i = 0; i < a.length; i++){
            int x = 0;
            for(int j = 0; j < b.length;j++){
                if(b[j]-a[i]>=0 && b[j] - a[i] <= r){
                    x++;
                    s += "(" +a[i]+","+b[j]+"),";
                }else{
                    if(x == 0 && b[j] - a[i] >=0){
                        s += "(" +a[i]+","+b[j]+"),";
                    }
                }
            }
        }
        if(s.endsWith(",")){
            s = s.substring(0,s.length()-1);
        }
        System.out.println(s);
    }

}
