package 链表.排序专题;

/**
 * @author yangzhe14
 * @since 2024/10/7
 */
public class 数组快排 {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3};
        quickSort(arr);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr);

    }

    // todo 这里得再做一遍笔记啊！！！
    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || start >= end || start < 0 || end >= arr.length) {
            return;
        }

        int partition = partition(arr, start, end);

        // 找寻中间的分治点
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    public static int partition(int[] arr, int left, int right) {
        int swapValue = arr[left];
        int lowIndex = left;

        // todo 完了完了，连fori都不会了，这个可能从来就不会，fori是先执行条件判断，再执行循环体，最后再i++执行
        // 所以每次判断自己的条件就行了，能进入代码的，肯定都是条件卡完了的，不需要管i++
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < swapValue) {
                // lowIndex之内的，都是比swap要小的
                lowIndex++;
                swap(arr, lowIndex, i);
            }
        }
        swap(arr, lowIndex, left);
        return lowIndex;
    }

    public static void swap(int[] arr, int left, int right) {
        int leftValue = arr[left];
        arr[left] = arr[right];
        arr[right] = leftValue;
    }
}