package HuaWei.Experience;

public class RotateNums {
    public void re(int[] nums, int start ,int end){

        while(start<end){
            int temp=nums[start];
            nums[start++]=nums[end];
            nums[end--]=temp;
        }
    }

    public void rotate(int[] nums, int numsSize, int k) {

        if(numsSize<k){
            k=k%numsSize;
            re(nums,0,numsSize-k-1);
            re(nums,numsSize-k,numsSize-1);
            re(nums,0,numsSize-1);
        }else{

            re(nums,0,numsSize-k-1);
            re(nums,numsSize-k,numsSize-1);
            re(nums,0,numsSize-1);
        }
    }
}
