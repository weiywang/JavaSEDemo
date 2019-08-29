package PrepareForAli.Arrays;

public class Trap {
    public int trap(int[] height) {
        if(height.length < 2){//不是<=2，2个值也可能接到雨水，但数组的下表是从i=0开始的
            return 0;
        }

        int maxIndex = 0;//初始化为0，不是-1？

        for(int i = 0; i < height.length; i++){
            if(height[i] > height[maxIndex]){
                maxIndex = i;
            }
        }

        int total = 0;
        int topIndex = 0;//初始化为0？

        for(int i = 0; i < maxIndex; i++){
            if(height[i] > height[topIndex]){
                topIndex = i;
            }else{
                total += (height[topIndex] - height[i]);
            }
        }

        topIndex = height.length-1;//初始化为最后一个值
        for(int i = height.length-1; i > maxIndex; i--){
            if(height[i] > height[topIndex]){
                topIndex = i;
            }else{
                total += (height[topIndex] - height[i]);
            }
        }

        return total;
    }
}
