package github.chuyun923.algorithm.sorting;

import github.chuyun923.algorithm.SortType;

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
            case SELECT_SORT:
                sortingAlgorithm = new SelectSorting();
                break;
            case MERGE_SORT:
                sortingAlgorithm = new MergeSorting();
                break;
            default:
                break;
        }
    }

    public int[] sort(int[] src) {
        return sortingAlgorithm.sort(src);
    }

}
