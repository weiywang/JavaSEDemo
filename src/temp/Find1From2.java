package temp;

public class Find1From2 {
    public static int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res= res ^ a[i];
        }
        return res;
    }
}
