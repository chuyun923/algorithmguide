package github.chuyun923.algorithm.sorting;

/**
 * Created by pengliang on 15/8/27.
 *
 * 基数排序
 * 主要是用来弥补一些计数排序的痛点：如果待排序列并不是特别大，而待排序列中的元素范围较大，怎么破？
 *
 * 核心原理就是  比较数范围(数的位数) 和 序列的大小
 * 在数的位数不大 待排序列较大的情况下，直接使用计数排序
 * 否则 把数的位数分一分 让每一次计数排序的数位减少
 *
 * 本算法只用于演示10进制如果每次比较一位的基数排序
 * 通用算法需要考虑输入序列和数的范围
 */
public class RadixSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] src) {
        int numberwidth = getMaxBit(src);
        for(int i=1;i<=numberwidth;i++) {
            int[] tmp = new int[src.length];
            int[] counter = initCounter(src,i);

            for(int j=src.length-1;j>=0;j--) {
                tmp[counter[getBitByPos(src[j],i)]-1] = src[j];
                counter[getBitByPos(src[j],i)] --;
            }
            src = tmp;
        }
        return src;
    }

    private int[] initCounter(int[] src,int pos) {
        int[] counter = new int[10];

        //计数
        for(int d : src) {
            counter[getBitByPos(d,pos)]++;
        }

        //计数累加
        for(int i=0;i<counter.length-1;i++) {
            counter[i+1] += counter[i];
        }
        return counter;
    }


    private int getMaxBit(int[] src) {
        int max = Integer.MIN_VALUE;
        for(int d : src) {
            if(max<d) {
                max = d;
            }
        }

        int maxbitcount = 1;
        while(max/10 != 0) {
            maxbitcount++;
            max = max/10;
        }

        return maxbitcount;
    }

    private int getBitByPos(int data,int pos) {
        return (data / (int)(Math.pow(10,pos-1)))%10;
    }

}
