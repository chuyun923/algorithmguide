package github.chuyun923.algorithm.sorting;

import static github.chuyun923.algorithm.Utils.log2;
import static github.chuyun923.algorithm.sorting.HeapHelper.*;
/**
 * Created by pengliang on 15-8-18.
 *
 * 堆排序 时间复杂度  n(lgn)
 *
 * 先按照输入的内容构造大顶堆 或者小顶堆
 *
 * 根元素必然是当前的最值  每次取出堆顶元素 调整剩下的堆到稳定结构 继续递归
 */
public class HeapSort implements SortingAlgorithm {


    @Override
    public int[] sort(int[] src) {
        HeapHelper.config(src);
        int[] heap = buildMaxHeap(src);
        int size = heap.length;
        while (size>1) {
            int tmp = src[0];
            src[0] = src[size-1];
            src[size-1] = tmp;
            maintainMaxHeap(src,0,size-1);
            size--;
        }

        return src;
    }


    /**
     * 从输入序列创建一个大顶堆
     * @param src
     * @return
     */
    private int[] buildMaxHeap(int[] src) {
        //n个元素的堆的高度为 |_lgn_| + 1
        // 倒数第二层
        int hight_1 = (int) log2(src.length);
        int start = (int)(Math.pow(2,hight_1)-1);

        while (start >=1) {
            maintainMaxHeap(src,start-1,src.length);
            start--;
        }

        return src;
    }


    /**
     * 维护一个大顶堆，前提是除了堆顶，两个子树都已经是大顶堆
     * @param
     * @return
     */
    private int[] maintainMaxHeap(int[] src,int rootIndex,int size) {
        //拿出这个堆的左子树 和 右子树的根节点
        if(!hasLeftChild(rootIndex,size)) return src;

        int leftRoot = getLeftChild(rootIndex);
        int rightRoot = Integer.MIN_VALUE;
        if(hasRightChild(rootIndex,size)) {
            rightRoot = getRightChild(rootIndex);
        }

        if(src[rootIndex]>=leftRoot && src[rootIndex] >=rightRoot) return src;

        if(leftRoot>=rightRoot) {
            int tmp = src[rootIndex];
            src[rootIndex] = leftRoot;
            src[2*(rootIndex+1)-1] = tmp;
            maintainMaxHeap(src,2*(rootIndex+1)-1,size);
        }else {
            int tmp = src[rootIndex];
            src[rootIndex] = rightRoot;
            src[2*(rootIndex+1)] = tmp;
            maintainMaxHeap(src,2*(rootIndex+1),size);
        }

        return src;
    }





}

/**
 * 注意，所有数组的索引在进行二叉树计算时都需要加+1
 * 计算完事之后，取数组的内容又需要减一
 */
class HeapHelper {
    private static int[] src;

    /**
     * 返回序列为i的节点的父亲
     * @param i
     * @return
     */
    public static int getParent(int i) {
        return src[(int)log2(i+1)-1];
    }


    public static int getLeftChild(int i) {
        return src[2*(i+1)-1];
    }

    public static int getRightChild(int i) {
        return src[2*(i+1)];
    }

    public static boolean hasLeftChild(int i) {
        return 2*(i+1) <= src.length;
    }

    public static boolean hasRightChild(int i) {
        return 2*(i+1)+1 <= src.length;
    }

    public static boolean hasLeftChild(int i,int size) {
        return 2*(i+1) <= size;
    }

    public static boolean hasRightChild(int i,int size) {
        return 2*(i+1)+1 <= size;
    }

    public static void config(int[] src) {
        HeapHelper.src = src;
    }
}

