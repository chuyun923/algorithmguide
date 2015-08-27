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
            case BUBBLE_SORT:
                sortingAlgorithm = new Bubblesorting();
                break;
            case QUICKSORT:
                sortingAlgorithm = new QuickSort();
            case HEAP_SORT:
                sortingAlgorithm = new HeapSort();
            case COUNT_SORT:
                sortingAlgorithm = new CountSort();
            case RADIX_SORT:
                sortingAlgorithm = new RadixSort();
            default:
                break;
        }
    }

    public int[] sort(int[] src) {
        return sortingAlgorithm.sort(src);
    }

}
