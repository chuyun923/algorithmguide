package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 14-12-18.
 */
public class Bubblesorting implements SortingAlgorithm {
    @Override
    public int[] sort(int[] src) {
        int i,j,tmp;
        for(i=0;i<src.length-1;i++) {
            for(j=0;j<src.length-i-1;j++) {
                if(src[j]>src[j+1]) {
                    tmp = src[j];
                    src[j] = src[j+1];
                    src[j+1] = tmp;
                }
            }
        }
        return src;
    }
}
