package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-7.
 */
class Test {
    public static void main(String args[]) {
        int array[] = {-1 ,4 ,-2 ,-1 ,-3,-1};
        MaxSubArrayAl maxSubArrayAl = new BruteForceAlgorithm();
        MaxSubArrayAl maxSubArrayAl1 = new DivideConquerAlgorithm();
        MaxSubArrayAl maxSubArrayAl2 = new MostBruteForceAlgorithm();
        MaxSubArrayAl maxSubArrayAl3 = new MostFastAlgorithm();
        SubArray subArray = maxSubArrayAl.findMaxMumSubArray(array);
        SubArray subArray1 = maxSubArrayAl1.findMaxMumSubArray(array);
        SubArray subArray2 = maxSubArrayAl2.findMaxMumSubArray(array);
        SubArray subArray3 = maxSubArrayAl3.findMaxMumSubArray(array);
//        subArray.printInfo();
//        subArray1.printInfo();
        subArray3.printInfo();
    }
}
