package Sort;

import java.util.Scanner;

public class HeapSort {
    static int len;//声明全局变量，用于记录数组array的长度；
    public static int[] heapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2+1 < len && array[i * 2+1] > array[maxIndex])
            maxIndex = i * 2+1;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 2 < len && array[i * 2 + 2] > array[maxIndex])
            maxIndex = i * 2 + 2;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int[] nums = new int[arr.length];
            for (int i=0;i<arr.length;i++){
                nums[i] = Integer.parseInt(arr[i]);
            }
            heapSort(nums);
            for (int i=0;i<arr.length;i++){
                if(i==arr.length-1){
                    System.out.println(nums[i]);
                }else {
                    System.out.print(nums[i]+" ");
                }

            }
        }
    }

}
