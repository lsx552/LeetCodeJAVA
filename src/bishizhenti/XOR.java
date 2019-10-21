package bishizhenti;

import java.util.Scanner;

public class XOR {
    //给出n个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int num=0;
            int start =0;
            for(int i=0;i<n;i++){
                int tmp=0;
                for(int j=i;j>=start;j--){
                    tmp^=arr[j];
                    if(tmp==0){
                        num++;
                        start = i+1;
                        break;
                    }
                }
            }
            System.out.println(num);
        }
    }
}
