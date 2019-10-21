package leetcode;

public class UglyNumber_263 {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(6));
    }
    public static int getUglyNumber(int N) {
        if(N<=0) return 0;
        int[] arr = new int[N];
        arr[0] = 1;
        int nextIndex = 1;
        int t2 = 0,t3=0,t5=0;
        int min = 0;
        while (nextIndex<N) {
            min = getMin(arr[t2]*2,arr[t3]*3,arr[t5]*5);
            arr[nextIndex] = min;
            while (arr[t2]*2<=arr[nextIndex]) {
                t2++;
            }
            while (arr[t3]*3<=arr[nextIndex]) {
                t3++;
            }
            while (arr[t5]*5<=arr[nextIndex]) {
                t5++;
            }
            nextIndex++;
        }
        int res = arr[N-1];
        return res;
    }

    public static int getMin(int num1,int num2,int num3) {
        int min = Math.min(num1,num2);
        min = Math.min(min,num3);
        return min;
    }
}
