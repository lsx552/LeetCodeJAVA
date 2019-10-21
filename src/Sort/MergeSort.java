package Sort;

import java.util.Arrays;

public class MergeSort {
    //归并排序
    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0;index < res.length; index++) {
            if (i >= left.length)
                res[index] = right[j++];
            else if (j >= right.length)
                res[index] = left[i++];
            else if (left[i] > right[j])
                res[index] = right[j++];
            else
                res[index] = left[i++];
        }
        return res;
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {2, 1, 4, 6, 7, 3, 5};
        int[] res = ms.mergeSort(arr);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
