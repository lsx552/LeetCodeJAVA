package bishizhenti;

import java.util.Arrays;
import java.util.Scanner;

public class suanshizhuanyi {
    //给出一个仅包含加减乘除四种运算符的算式(不含括号)，如1+2*3/4，
    // 在保持运算符顺序不变的情况下，现在你可以进行若干次如下操作：如果交换相邻的两个数，表达式值不变，
    // 那么你就可以交换这两个数。
    //现在你可以进行任意次操作，使得算式的数字序列字典序最小，然后输出结果，数字之间的字典序定义为若a<b则a的字典序小于b。
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while(sc.hasNext()){
            n = sc.nextInt();
            int[] num = new int[n];
            char[] op = new char[n-1];
            for(int i=0;i<n;i++){
                num[i] = sc.nextInt();

                if(i <n-1) {
                    String strop = sc.next();
                    op[i] = strop.charAt(0);
                }
            }
            int[] sorted_arr = sort(num,op);
            String out = "";
            String strnum = Arrays.toString(sorted_arr);
            System.out.println(strnum);
            for(int i=0;i<n-1;i++) {

                out  = out +sorted_arr[i] +" ";
                out += op[i] + " ";
            }
            int lastnum = sorted_arr[n-1];
            //char charlast = strnum.charAt(n-2);
            out += lastnum;
            System.out.println(out);
        }
    }
    public static  int[] sort(int[] arr,char[] op) {
        int low=0,high=0;
        for(int i=0;i<op.length-1;i++){
            if(op[i]=='+'){
                high++;
                if(op[i+1]=='+'){
                    continue;
                }else {
                    quickSort(arr,low,high-1);
                    low =i+1;
                    high = i+1;
                }
            }
            if(op[i]=='*'){
                high++;
                if(op[i+1]=='*'){
                    continue;
                }else {
                    quickSort(arr,low,high-1);
                    low = i+1;
                    high = i+1;
                }
            }
            if(op[i]=='/'){

                high ++;
                if(op[i+1]=='/'){
                    continue;
                }else {
                    quickSort(arr,low+1,high);
                    low = i+1;
                    high = i+1;
                }
            }
            if(op[i]=='-'){

                high ++;
                if(op[i+1]=='-'){
                    continue;
                }else {
                    quickSort(arr,low+1,high);
                    low = i+1;
                    high = i+1;
                }
            }
        }
        return arr;
    }
    public static void quickSort (int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);//找寻基准数据的正确索引
            quickSort(arr, 0 ,index - 1);
            quickSort(arr, index +1 , high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
        }
    }

    public static int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high --;// 当队尾的元素大于等于基准数据时,向前挪动high指针
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];

            while (low < high && arr[low] <= temp) {
                low ++;// 当队首元素小于等于tmp时,向前挪动low指针
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        arr[low] = temp;// 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        return low;
    }
}
