package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-7.
 *
 * 最大子数组最暴力的解决方案
 */
public class MostBruteForceAlgorithm extends MaxSubArrayAl {
    @Override
    public SubArray findMaxMumSubArray(int[] array) {
        SubArray subArray = new SubArray();
        subArray.sum = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0; i < array.length-1; i++)
        {
            for(int j = i; j < array.length-1; j++)
            {
                for(int k = i; k <= j; k++)
                {
                    tmp +=array[k];
                }
                if(tmp>=subArray.sum)
                {
                    subArray.sum = tmp;
                    subArray.left = i;
                    subArray.right = j;
                }

                tmp=0;
            }
        }
        return subArray;
    }

}
