package HuaWei;

import java.util.*;

public class HuaWeiPrimary {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str = Integer.toBinaryString(n);

        System.out.println(str);
        char[] chars = str.toCharArray();
        int[] res = new int[chars.length];
        int count = 0;
        for(int i = chars.length-1; i >= 2; i--){
            if(chars[i] == '1' && chars[i-1] == '0' && chars[i-2] == '1'){
                res[count++] = i;
            }
        }

        int position = str.indexOf("101");

//        Pattern pattern = Pattern.compile("101");
//        Matcher matcher = pattern.matcher(str);
//        int num = matcher.groupCount();
//        int position = str.indexOf("101");

        if(count > 0) {
            System.out.print(count + " ");
            System.out.print(chars.length-1-res[0]);
        }else{
            System.out.print(0 + " ");
            System.out.print(-1);
        }

    }
}
