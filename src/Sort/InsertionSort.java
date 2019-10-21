package Sort;

public class InsertionSort {
    //插入排序
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i -1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {2, 1, 4, 6, 7, 3, 5};
        is.insertionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
