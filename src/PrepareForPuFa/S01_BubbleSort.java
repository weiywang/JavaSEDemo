package PrepareForPuFa;

public class S01_BubbleSort {
    public static int[] bubbleSort(int[] array){
        if(array.length == 0){
            return array;
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1-i; j++){
                if(array[j+1] < array[j]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] Args){
        int[] array = {1,3,2,5,8,4,6};
        int[] res = bubbleSort(array);
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
