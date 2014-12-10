package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 14-12-10.
 *
 * 插入排序
 */

public class InsertSorting implements SortingAlgorithm {
    @Override
    public int[] sort(int[] src) {
        if(src==null || src.length<=1) return src;
        int i,j,key;
        for(j=1;j<src.length;j++) {
            i = j-1;
            key = src[j];
            while(i>=0 && src[i]>key) {
                src[i+1] = src[i];
                i--;
            }
            src[i+1] = key;
        }
        return src;
    }
}
