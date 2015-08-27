package github.chuyun923.algorithm.sorting;


import github.chuyun923.algorithm.SortType;
import github.chuyun923.algorithm.Utils;

/**
 * Created by pengliang on 14-12-10.
 */
public class Client {

    static int[] src = {23,1,34,45,29,
                        23,30,34,21,3,
                        23,65,81,3,5,
                        48,12,35,64,12,
                        56,42,26,97,34};
    public static void main(String[] args) {
        SortingManager sortingManager = new SortingManager(SortType.RADIX_SORT);
        Utils.printIntArray(sortingManager.sort(src));
    }
}
