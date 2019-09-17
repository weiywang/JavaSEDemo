package HuaWei;

import java.util.*;
public class Answer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //将所有两个以上的'-'替换成空格
        String line2 = line.replaceAll("-{2,}"," ");
        //将所有非0-9a-zA-Z\\-的字符替换成空格，\\-表示'-'
        String line3 = line2.replaceAll("[^0-9a-zA-Z\\-]", " ");
        //将所有非0-9a-zA-Z字符加'-'的字符替换成空格
        String line6 = line3.replaceAll("[^0-9a-zA-Z]-", " ");
        //将所有-'加非0-9a-zA-Z非0-9a-zA-Z字符加'-'的字符替换成空格
        String line7 = line6.replaceAll("-[^0-9a-zA-Z]", " ");

        //将字符串s按照空格进行分割，分割成字符串数组
        //注意，按什么分割，则分割后不再包含改字符
        String[] line4 = line7.split("\\s+");
        String res = "";
        for(int i = line4.length-1; i >=0; i--){
            res = res + line4[i] + " ";
        }
        System.out.println(res.trim());
    }
}
