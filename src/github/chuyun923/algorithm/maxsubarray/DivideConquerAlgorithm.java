package github.chuyun923.algorithm.maxsubarray;

import java.util.List;

/**
 * Created by pengliang on 15-1-5.
 *
 * 思路：用分治法来解决这个问题，我们可以目标数组分成两个字数组(可以从中间来分)，那么分开之后最大子串有三种情况存在：
 *
 * 1、最大子串在子数组的左边
 * 2、最大子串在子数组的右边
 * 3、最大子串横跨中间值(最大子串包括中间值)
 *
 * 复杂度：O(n*lgn)
 */
public class DivideConquerAlgorithm extends MaxSubArrayAl {

    private SubArray findMaxMumSubArray(int[] array,int low,int high) {
        SubArray subArray = new SubArray();
        if(low==high) {
            subArray.left = low;
            subArray.right = high;
            subArray.sum = array[low];
            return subArray;
        }
        SubArray subArrayLeft;
        SubArray subArrayRight;

        int mid = (low+high)/2;

        subArrayLeft = findMaxMumSubArray(array,low,mid);
        subArrayRight = findMaxMumSubArray(array,mid+1,high);
        subArray = findMaxCrossingSubarray(array,low,mid,high);

        return findMaxMun(subArrayLeft,subArray,subArrayRight);

    }

    @Override
    public SubArray findMaxMumSubArray(int[] array) {
        return findMaxMumSubArray(array,0,array.length-1);
    }
}


