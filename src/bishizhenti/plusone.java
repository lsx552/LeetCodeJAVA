package bishizhenti;
import java.util.Scanner;
public class plusone {



        public static int minIncrementForUnique(int[] A) {
            int[] arr = new int[80001];
            for (int c : A) {
                arr[c]++;
            }
            int count = 0;
            for (int i = 0; i < 80001; i++) {
                if (arr[i] <= 1) {
                    continue;
                }
                if (arr[i] >= 2) {
                    arr[i + 1] = arr[i + 1] + arr[i] - 1;
                    count += arr[i] - 1;
                    arr[i] = 1;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] str = line.split(",");
                int [] num=new int[str.length];
                for(int i=0; i<num.length; i++){
                    num[i]=Integer.parseInt(str[i]);
                }
                System.out.println(minIncrementForUnique(num));
            }
        }

}
