package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-7.
 *
 * 最大子数组最暴力的解决方案
 *
 * 思路：对每一个元素，找出从它开始的最长子串，然后找出最大的
 *
 * 时间复杂度：o(n^3)
 */
public class MostBruteForceAlgorithm extends MaxSubArrayAl {
    @Override
    public SubArray findMaxMumSubArray(int[] array) {
        SubArray subArray = new SubArray();
        subArray.sum = Integer.MIN_VALUE;
        int tmp = 0;
        //每一个元素都要走一遍
        for(int i = 0; i < array.length-1; i++)
        {
            //当前元素需要叠加的宽度，当前元素之前的元素不需要考虑
            for(int j = i; j < array.length-1; j++)
            {
                //叠加运算
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
