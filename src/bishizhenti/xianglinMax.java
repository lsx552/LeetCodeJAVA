package bishizhenti;

import java.util.Arrays;
import java.util.Scanner;

public class xianglinMax {
    //有一个无序整型数组，如何求出该数组排序后的任意两个相邻元素的最大差值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
             int n = sc.nextInt();
             int[] arr = new int[n];
             for (int i=0;i<n;i++){
                 arr[i] = sc.nextInt();
             }
             System.out.println(getMax(arr));
        }
    }
    public static int getMax(int[] array){
        // 1. 获取数组中的最大值和最小值，构建数组的长度
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int distance = max - min;
        // 如果max和min相等，说明数组所有元素都相等，返回0
        if (distance == 0) {
            return 0;
        }
        // 2. 初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 3. 遍历原始数组，确定每个桶的最大最小值
        for (int i = 0; i < array.length; i++) {
            // 确定数组元素所属的桶小标
            int index = ((array[i] - min) * (bucketNum - 1)) / distance;
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }

        // 4. 遍历桶，找到最大差值
        // 这里采用临时变量leftMax,在每一轮迭代时存储当前左侧桶的最大值，
        // 而两个桶之间的差值，则是buckets[i].min - leftIndex
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;

    }

    /**
     * 桶
     */
    private static class Bucket{
        Integer min;
        Integer max;
    }

}
