package PrepareForAli.Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnswerOne {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<CloseArea> dataInput = new ArrayList<>();

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++){
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }

        Arrays.sort(left);

        boolean isExist = false;
        for(int i = n-1; i >= 0; i--){
            int leftRes = -1;
            for(int j = i-1; j >= 0; j--){

                if(right[j] > left[i]){
                    continue;
                }else{
                    leftRes = Math.max(leftRes, right[j]);
                }
            }
            if(leftRes != -1){
                isExist = true;
                System.out.println("["+(leftRes+1)+","+(left[i]-1)+"]");
                return;
            }
        }

        if(!isExist){
            System.out.println("[]");
        }
    }
}
