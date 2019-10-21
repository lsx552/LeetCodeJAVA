package Sort;

public class BubbleSort {
    //冒泡排序
    public void bubbleSort(int[] array) {
        int change = 0;//标志变量用于记录每趟冒泡排序是否发生数据元素位置交换。
        // 如果没有发生交换，说明序列已经有序了，不必继续进行下去了
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    change = 1;
                }
            if (change ==0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {1,2,3,4,5,6};
        bs.bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
