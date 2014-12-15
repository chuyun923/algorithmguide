package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 14-12-15.
 */
public class MergeSorting implements SortingAlgorithm{
    @Override
    public int[] sort(int[] src) {
        return mergeSort(src,0,src.length-1);
    }

    /**
     * In src,st to middle and middle+1 to end is already sorted!
     * @param src
     * @param st
     * @param middle
     * @param end
     */
    private void merge(int[] src,int st,int middle,final int end) {
        int[] array1 = new int[middle-st+2];
        int[] array2 = new int[end-middle+1];
        //设置哨兵
        array1[array1.length-1] = Integer.MAX_VALUE;
        array2[array2.length-1] = Integer.MAX_VALUE;

        System.arraycopy(src,st,array1,0,middle-st+1);
        System.arraycopy(src,middle+1,array2,0,end-middle);
        int sortedPos = 0,index1 = 0,index2 = 0;
        while(sortedPos<end-st+1) {
            if(array1[index1]<=array2[index2]) {
                src[sortedPos+st] = array1[index1++];
            }else {
                src[sortedPos+st] = array2[index2++];
            }
            sortedPos++;
        }
    }

    private int[] mergeSort(int[] src,int st,int end) {
        if(end<=st) return src;
        int middle =(end-st)/2+st;
//        System.out.println(st +"   "+middle+"   "+end);
        mergeSort(src,st,middle);
        mergeSort(src,middle+1,end);
        merge(src,st,middle,end);
        return src;
    }
}
