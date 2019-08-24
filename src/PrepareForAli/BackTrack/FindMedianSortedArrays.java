package PrepareForAli.BackTrack;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //ensure m < n
        if(m > n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0;
        int iMax = m;
        int halfLen = (m+n+1)/2;

        while(iMin <= iMax) {//注意循环结束条件是小于等于
            int i = (iMax + iMin) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;// i is too small
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {//nums2[j]，不是nums2[j]
                iMax = i - 1;// i is too big
            } else {
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = nums2[j-1];
                }else if(j == 0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) {//在m+n为奇数时，直接返回
                    return maxLeft;
                }

                int minRight = 0;
                if(i == m){
                    minRight = nums2[j];//not nums1[i]
                }else if(j == n){
                    minRight = nums1[i];
                }else{
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft+minRight)/2.0;//返回要求是double类型的

            }
        }
        return 0.0;//缺少这句话，编译器会报错，这也是一种技巧
    }
}
