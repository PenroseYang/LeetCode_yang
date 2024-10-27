package 链表.排序专题;

/**
 * @author yangzhe14
 * @since 2024/10/7
 */
public class 数组归并排序 {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3};
        mergeSort(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || left < 0 || right >= arr.length || left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    // 左右两段都是排序过的，现在开始把两段开始合并
    private static void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int[] sortedArr = new int[right - left + 1];

        int firstArrIndex = left;
        int secondArrIndex = mid + 1;

        int sortedIndex = 0;
        while (firstArrIndex <= mid && secondArrIndex <= right) {
            if (arr[firstArrIndex] < arr[secondArrIndex]) {
                sortedArr[sortedIndex] = arr[firstArrIndex];
                firstArrIndex++;
            } else {
                sortedArr[sortedIndex] = arr[secondArrIndex];
                secondArrIndex++;
            }
            sortedIndex++;
        }

        for (int i = firstArrIndex; i <= mid; i++) {
            sortedArr[sortedIndex] = arr[i];
            sortedIndex++;
        }

        for (int i = secondArrIndex; i <= right; i++) {
            sortedArr[sortedIndex] = arr[i];
            sortedIndex++;
        }

        // 往原来的数组里拷贝一遍
        for (int i = left; i <= right; i++) {
            arr[i] = sortedArr[i - left];
        }
    }
}