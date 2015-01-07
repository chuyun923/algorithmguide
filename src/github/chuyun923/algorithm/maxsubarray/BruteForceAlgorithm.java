package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-7.
 *
 * 使用暴力求解
 * 思路是找到数组中每一个元素所在的最大子数组，然后比较，找出其中最大的就是最大子数组
 * 复杂度：O(n^2)
 */
public class BruteForceAlgorithm {

    public static SubArray getMaxSubArray(int array[]) {
        SubArray subArray = new SubArray();
        SubArray temp = new SubArray();
        subArray.sum = Integer.MIN_VALUE;
        if(array.length==1) {
            subArray.sum = array[0];
            subArray.left = subArray.right = 0;
            return subArray;
        }
        for(int i=0;i<array.length;i++) {
            temp = MaxSubArrayAlgorithm.findMaxCrossingSubarray(array,0,i,array.length-1);
            if(temp.compareTo(subArray)>=0) {
                subArray = temp;
            }
        }

        return subArray;

    }
}
