package PrepareForAli.GreedyAlgorithm;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        //对1~(n-1)：判断是不是ratings[i] > ratings[i-1]
        for(int i = 1; i < candies.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        int sum = candies[candies.length-1];
        //对于(n-2)~0 判断是不是ratings[i] > ratings[i+1]
        for(int i = candies.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum += candies[i];
        }

        return sum;
    }
}
