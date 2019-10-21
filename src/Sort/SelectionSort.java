package Sort;

public class SelectionSort {
    //选择排序
    public void selectionSort(int[] array) {
        for (int i = 0; i <array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j<array.length;j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = {2, 1, 4, 6, 7, 3, 5};
        ss.selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
