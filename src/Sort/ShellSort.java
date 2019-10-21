package Sort;

public class ShellSort {
    //希尔排序
    public void ShellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }
    }
    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int[] arr = {2, 1, 4, 6, 7, 3, 5};
        ss.ShellSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
