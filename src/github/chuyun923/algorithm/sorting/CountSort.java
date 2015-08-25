package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 15/8/25.
 *
 * 计数排序，时间复杂度O(n)---->前提是所有数的范围 <n
 * 需要额外的空间来帮助，比较适合于待排序列中数据范围比较集中的场景
 */
public class CountSort implements SortingAlgorithm {

    private int numberRange = 0;
    private int offset = 0;

    @Override
    public int[] sort(int[] src) {
        return countSort(src);
    }

    private int[] countSort(int[] data) {
        initRange(data);
        int[] counter = new int[numberRange];
        initCounter(counter,data);
        int[] result = new int[data.length];

        for(int i=result.length-1;i>=0;i--) {
            int currentData = data[i];
            result[counter[currentData-offset]-1] = currentData;
            counter[currentData-offset]--;
        }

        data = result;
        return data;
    }

    private void initCounter(int[] counter,int[] data) {
        //计数
        for(int d : data) {
            counter[d-offset]++;
        }

        //计数累加
        for(int i=0;i<counter.length-1;i++) {
            counter[i+1] += counter[i];
        }
    }

    /**
     * 查找输入序列的范围
     * @param data
     */
    private void initRange(int[] data) {
        int min = Integer.MAX_VALUE,max=Integer.MIN_VALUE;

        for(int d : data) {
           if(d<min) {
               min = d;
           }
           if(d>max) {
               max = d;
           }
        }

        offset = min;
        numberRange = max - min + 1;
    }
}
