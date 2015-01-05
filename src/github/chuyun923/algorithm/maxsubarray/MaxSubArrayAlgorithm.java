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
 */
public class MaxSubArrayAlgorithm {

    public static SubArray findMaxMumSubArray(int[] array,int low,int high) {
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

    private static SubArray findMaxCrossingSubarray(int[] array,int low,int mid,int high) {
        class SearchResult {
            private int index;
            private int sum;
            private int maxSum;
        }

        SearchResult searchLow = new SearchResult(),
                searchHigh = new SearchResult();
        searchLow.index = mid;
        searchHigh.index = mid;
        searchLow.sum = searchLow.maxSum = searchHigh.sum = searchHigh.maxSum = 0;

        //扫描左边
        for(int i = mid-1;i>=0;i--) {
            searchLow.sum += array[i];
            //这个地方可以带上`=`号可以找打一个最长的最大子串，去掉等号，找到最短最大子串
            if(searchLow.sum >= searchLow.maxSum) {
                searchLow.maxSum = searchLow.sum;
                searchLow.index = i;
            }
        }

        for(int j = mid+1;j<=high;j++) {
            searchHigh.sum += array[j];
            if(searchHigh.sum>=searchHigh.maxSum) {
                searchHigh.maxSum = searchHigh.sum;
                searchHigh.index = j;
            }
        }

        SubArray subArray = new SubArray();
        subArray.left = searchLow.index;
        subArray.right = searchHigh.index;
        subArray.sum = array[mid]+searchHigh.maxSum+searchLow.maxSum;
        return subArray;
    }

    private static SubArray findMaxMun(SubArray... subArrayList) {
        SubArray subArrayMax = new SubArray();
        subArrayMax.sum = Integer.MIN_VALUE;
        for(SubArray subArray : subArrayList) {
            if(subArray.compareTo(subArrayMax)>=0) {
                subArrayMax = subArray;
            }
        }
        return subArrayMax;
    }
}

class Test {
    public static void main(String args[]) {
        int array[] = {1 ,-4 ,2 ,-1 ,3,-1};
        SubArray subArray = MaxSubArrayAlgorithm.findMaxMumSubArray(array,0,array.length-1);
        subArray.printInfo();
    }
}
