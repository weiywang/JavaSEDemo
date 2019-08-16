package pdd;

import java.util.*;

public class L01_SelectPerfectNumberReference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int k = Integer.parseInt(str.split(" ")[1]);
        char[] ori = in.nextLine().toCharArray();
        int[] count = new int[10];
        for (char i : ori) {
            count[i - '0'] ++;
        }
        int mod = Integer.MAX_VALUE;
        char[] res = new char[n];
        for (int i = 0; i < 10; ++ i) {
            int tmpK =  k - count[i];
            if (tmpK <= 0) {
                mod = 0;
                res = ori;
                break;
            }
            char[] tmpArr = new char[n];
            for (int j = 0; j < n; ++ j) {
                tmpArr[j] = ori[j];
            }
            int tmpMod = 0;
            int l = i - 1;
            int r = i + 1;
            while (tmpK > 0) {
                if (r < 10) {
                    for (int v = 0; v < n && tmpK > 0; v ++) {
                        if (tmpArr[v] - '0' == r) {
                            tmpMod += r - i;
                            tmpArr[v] = (char) ('0' + i);
                            tmpK--;
                        }
                    }
                }
                if (l >= 0) {
                    for (int v = n - 1; v >= 0 && tmpK > 0; -- v) {
                        if (tmpArr[v] - '0' == l) {
                            tmpMod += i - l;
                            tmpArr[v] = (char)('0' + i);
                            tmpK --;
                        }
                    }
                }
                l --;
                r ++;
            }
            if (tmpMod < mod) {
                mod = tmpMod;
                res = tmpArr;
            }

        }

        System.out.println(mod);
        System.out.println(new String(res));
    }
}
