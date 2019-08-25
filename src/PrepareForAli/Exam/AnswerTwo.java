package PrepareForAli.Exam;

import java.util.Scanner;

public class AnswerTwo {

    public static String res = "";

    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder res = new StringBuilder(str);

        int count = 0;
        while(!isHW(res.toString()) && res.length() >= 0){
            if(res.charAt(0) == res.charAt(res.length()-1)){
                continue;
            }else {
                count++;
                StringBuilder temp1 = new StringBuilder(res);
                temp1 = temp1.deleteCharAt(0);
                if (isHW(temp1.toString())) {
                    System.out.println(count + "," + temp1.toString());
                    break;
                } else {
                    StringBuilder temp2 = new StringBuilder(res);
                    temp2 = temp2.deleteCharAt(temp2.length() - 1);
                    if (isHW(temp2.toString())) {
                        System.out.println(count + "," + temp2.toString());
                        break;
                    }
                }

                res.deleteCharAt(0);
                res.deleteCharAt(res.length() - 1);
                count++;
            }

        }


        if(count == 0){
            System.out.println(count + "," + res.toString());
        }


    }

    public static boolean isHW(String str){
        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(chars[i] != chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
