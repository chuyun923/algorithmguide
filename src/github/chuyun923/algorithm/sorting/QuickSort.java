package github.chuyun923.algorithm.sorting;

import java.util.Arrays;

/**
 * Created by pengliang on 15-8-13.
 *
 * 快排  时间复杂度为nlg(n)
 * 当然，存在最差情况：如果输入已经是有序的。
 */
public class QuickSort implements SortingAlgorithm{
    @Override
    public int[] sort(int[] src) {
        quickSort(src,0,src.length-1);
        System.out.println(Arrays.toString(src));
        return src;
    }


    private void quickSort(int[] src,int s,int e) {
        if(s<e) {
            int tmp = partion(src,s,e);
            quickSort(src,s,tmp-1);
            quickSort(src,tmp+1,e);
        }
    }

    private int partion(int[] src,int s,int e) {
        int i,j,x;
        x = src[s];

        for(i = s,j=s+1;j<=e;j++) {
            //需要交换
            if(src[j] <= x) {
                int tmp = src[i+1];
                src[i+1] = src[j];
                src[j] = tmp;
                i++;
            }
        }

        src[s] = src[i];
        src[i] = x;

        return i;
    }
}
