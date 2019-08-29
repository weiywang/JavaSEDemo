package PrepareForYunCong;

public class QuickSort {
    public int[] quickSort(int[] a, int left, int right){
        if(left < right){
            int pivotIndex = partition(a, 0, right);
            quickSort(a, 0, pivotIndex);
            quickSort(a, pivotIndex+1, right);
        }
        return a;
    }

    public int partition(int[] a, int left, int right){
        int pivot = a[left];
        int i = left;
        int j = right;

        while(i != j){
            while(a[j]>pivot && i < j){
                j--;
            }
            while(a[i]<pivot && i < j){
                i++;
            }

            if(i < j){
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }

        a[left] = a[j];
        a[j] = pivot;
        return j;
    }
}
