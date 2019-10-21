package bishizhenti;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AUC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            float[][] pred = new float[N][2];
            for (int i=0;i<N;i++) {
                pred[i][0] = sc.nextFloat();
                pred[i][1] = sc.nextFloat();

            }
            System.out.println(calAUC(pred));
        }
    }
    public static String  calAUC(float[][] pred) {
        int n_pos = 0,n_neg = 0;
        float res = 0;
        List<Float> pos_p = new ArrayList<>();
        List<Float> neg_p = new ArrayList<>();
        for (int i=0;i<pred.length;i++) {
            if (pred[i][0] == 1) {
                n_pos += 1;
                pos_p.add(pred[i][1]);
            } else {
                n_neg += 1;
                neg_p.add(pred[i][1]);
            }
        }


        int pair_num = n_pos*n_neg;
        int count = 0;
        for (int m=0;m<n_pos;m++) {
            for(int n=0;n<n_neg;n++) {
                if(pos_p.get(m)>neg_p.get(n)) {
                    count +=1;
                }
            }
        }
        res = (float) count/pair_num;
        DecimalFormat df = new DecimalFormat("0.00");
        String auc = df.format(res);
        return auc;
    }
}
