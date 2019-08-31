package PrepareForAli.Exam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test2 {
    static String getIndexAndLongest(String users, int k) {
        char[] chars = users.toCharArray();

        int max = 0;
        int maxIndex = -1;

//        if(chars[0] == 'b'){
//            int start = 0;
//            if(chars[1] == 'g'){
//                start++;
//            }
//            if(chars[chars.length-1] == 'g'){
//                start++;
//            }
//            max = start;
//            maxIndex = 0;
//        }



        for(int i = 0; i < users.length(); i++){
            int temp = 0;
            if(chars[i] == 'b'){
                if(i > 0 && chars[i-1] == 'g'){
                    temp++;
                }
                if(i < users.length()-1 && chars[i+1] == 'g'){
                    temp++;
                }
            }
            if(temp > max){
                max = temp;
                maxIndex = i;
            }
        }

//        if(chars[chars.length-1] == 'b'){
//            int end = 0;
//            if(chars[0] == 'g'){
//                end++;
//            }
//            if(chars[chars.length-2] == 'g'){
//                end++;
//            }
//            if(end > max){
//                max = end;
//                maxIndex = chars.length-1;
//            }
//        }

//        System.out.println("pro");
        int maxB = 0;
        for(int i = 0; i < users.length(); i++){
            int tempK = 0;
            int tempB = 0;
            for(int j = i; j < users.length()+i; j++){
//                System.out.println("pro1");
                if(j >= users.length()) {
//                    System.out.println("pro");
                    int t = j % users.length();
                    if (tempK <= k && chars[t] == 'g') {
                        tempK++;
                    }
                    if (tempK <= k && chars[t] == 'b') {
                        tempB++;
                    }
                }else{
                    if (tempK <= k && chars[j] == 'g') {
                        tempK++;
                    }
                    if (tempK <= k && chars[j] == 'b') {
                        tempB++;
                    }
                }


            }
            maxB = Math.max(tempB, maxB);
        }

        String res = maxIndex+" "+maxB;
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String res;

        String users;
        try {
            users = sc.nextLine();
        } catch (Exception e) {
            users = null;
        }
        int k = sc.nextInt();

        res = getIndexAndLongest(users, k);
        System.out.println(res);
    }
}
