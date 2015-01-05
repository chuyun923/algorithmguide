package github.chuyun923.algorithm.maxsubarray;

/**
 * Created by pengliang on 15-1-5.
 */
public class SubArray implements Comparable<SubArray>{
    public int left,right,sum;


    @Override
    public int compareTo(SubArray subArray) {
        if(sum>subArray.sum) {
            return 1;
        }else if(sum == subArray.sum) {
            return 0;
        }else {
            return -1;
        }
    }

    public void printInfo() {
        System.out.println("max subarray sum is :" + sum +"\n"+
                            "subarray start index is :" +left+"\n"+
                            "subArray end index is :" +right

        );
    }
}
