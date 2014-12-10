package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 14-12-10.
 */
public class SelectSorting implements SortingAlgorithm {
    @Override
    public int[] sort(int[] src) {
        if(src==null || src.length<=1) return src;
        int i,j,key,pos;
        for(j=0;j<src.length-1;j++) {
            key = src[j];
            pos = j;
            for(i=j+1;i<src.length;i++) {
                if(key>src[i]) {
                    key = src[i];
                    pos = i;
                }
            }
            src[pos] = src[j];
            src[j] = key;
        }
        return src;
    }
}
