package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-7.
 *
 * 最大数组子串
 */
public abstract class MaxSubArrayAl {
    public abstract SubArray findMaxMumSubArray(int array[]);

    /**
     * 找出指定数组中，包含mid下标元素的最大子串
     * @param array
     * @param low
     * @param current
     * @param high
     * @return
     */
    public static SubArray findMaxCrossingSubarray(int[] array,int low,int current,int high) {
        class SearchResult {
            private int index;
            private int sum;
            private int maxSum;
        }

        SearchResult searchLow = new SearchResult(),
                searchHigh = new SearchResult();
        searchLow.index = current;
        searchHigh.index = current;
        searchLow.sum = searchLow.maxSum = searchHigh.sum = searchHigh.maxSum = 0;

        //扫描左边
        for(int i = current-1;i>=low;i--) {
            searchLow.sum += array[i];
            //这个地方可以带上`=`号可以找打一个最长的最大子串，去掉等号，找到最短最大子串
            if(searchLow.sum >= searchLow.maxSum) {
                searchLow.maxSum = searchLow.sum;
                searchLow.index = i;
            }
        }

        for(int j = current+1;j<=high;j++) {
            searchHigh.sum += array[j];
            if(searchHigh.sum>=searchHigh.maxSum) {
                searchHigh.maxSum = searchHigh.sum;
                searchHigh.index = j;
            }
        }

        SubArray subArray = new SubArray();
        subArray.left = searchLow.index;
        subArray.right = searchHigh.index;
        subArray.sum = array[current]+searchHigh.maxSum+searchLow.maxSum;
        return subArray;
    }

    public static SubArray findMaxMun(SubArray... subArrayList) {
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
