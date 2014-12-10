package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 14-12-10.
 */
public class SortingManager {
    private SortingAlgorithm sortingAlgorithm;

    public SortingManager(SortType sortType) {
        switch (sortType) {
            case INSERT_SORT:
                sortingAlgorithm = new InsertSorting();
                break;
            default:
                break;
        }
    }

    public int[] sort(int[] src) {
        return sortingAlgorithm.sort(src);
    }

}
