package pdd;

import java.util.*;

public class A01_NearlyRise {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] aa = in.nextLine().split(" ");
            String[] bb = in.nextLine().split(" ");
            int[] a = new int[aa.length];
            int[] b = new int[bb.length];
            for(int i = 0; i < aa.length; ++i) {
                a[i] = Integer.parseInt(aa[i]);
            }
            for(int i = 0; i < bb.length; ++i) {
                b[i] = Integer.parseInt(bb[i]);
            }
            int cur = 0;
            for(; cur < a.length - 1; ++cur) {
                if(a[cur] >= a[cur+1]) break;
            }

            //left1、right1什么意思？left1、right1是替换cur这个下表对应的值的时候的左右区间
            int left1 = cur == 0 ? Integer.MIN_VALUE : a[cur-1];
            int right1 = a[cur+1];

            //left2、right2什么意思？left2、right2是替换cur+1这个下表对应的值时的左右区间
            int left2 = a[cur];
            int right2 = cur == a.length-2 ? Integer.MAX_VALUE : a[cur+2];
            //此处应该是a[cur+1]吧？不对，替换cur+1，应该使用cur+2作右边界

            Arrays.sort(b);
            int i = b.length - 1;
            for(; i >= 0; --i) {
                if(left1 < b[i] && b[i] < right1) {
                    a[cur] = b[i];
                    break;
                } else if(left2 < b[i] && b[i] < right2) {
                    a[cur+1] = b[i];
                    break;
                }
            }
            if(i == -1) {
                System.out.println("NO");
            } else {
                for(i = 0; i < a.length; ++i) {
                    //不需要输出找到的最大数字
                    System.out.print(a[i]);
                    if(i != a.length-1) System.out.print(" ");
                }
                System.out.print("\n");
            }
        }
    }
}
