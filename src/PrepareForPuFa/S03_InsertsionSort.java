package PrepareForPuFa;

public class S03_InsertsionSort {
    /**
     * 插入排序
     * @param array
     * @return
     */

    //主要思想是把array[i]插入到已有序的array[0] - array[i-1]
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            //从已有序的数列的最后一个数（也是最大的数）开始遍历，如果大于新加入的数，则往后移一位，为新加入的数空出一个位子
            //如此循环
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
