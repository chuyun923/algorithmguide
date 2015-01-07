package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-7.
 *
 * 线性时间处理最大子串的问题，思路:
 *
 * 从第一个元素开始，依次加上后面一个元素，直到总和少于0，在重新从下一个元素开始循环
 * 原理：
 *
 *       * * * * * * * * *
 *         ——————
 *
 * 如果带下划线的子串是最大子串，那么子串前面和后面的元素之和应该都是负数(注意这里没有考虑全负数的情况)
 *
 * 时间复杂度 O(n)
 */

public class MostFastAlgorithm extends MaxSubArrayAl {
    @Override
    public SubArray findMaxMumSubArray(int[] array) {
        //最大的子串的和
        SubArray subArray = new SubArray();
        subArray.sum = Integer.MIN_VALUE;
        int sum = array[0];
        int left = 0;
        subArray.left = subArray.right = 0;

        for(int i = 1;i<array.length;i++) {
            if(sum<0) {
                sum = array[i];
                left = i;
            }else {
                sum += array[i];
            }
            
            if(sum>subArray.sum) {
                subArray.left = left;
                subArray.right = i;
                subArray.sum = sum;
            }
        }
        return subArray;
    }
}
