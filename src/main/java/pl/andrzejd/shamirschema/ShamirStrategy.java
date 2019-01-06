package pl.andrzejd.shamirschema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShamirStrategy {

    private int secretNumber;

    private List<Integer> modules;

    private int p;
    private int t;

    public ShamirStrategy(int secretNumber, int t) {
        this.secretNumber = secretNumber;
        Random random = new Random();
        p = 1523;
//        p = random.nextInt();
        this.t = t;

        modules = new ArrayList<>(Arrays.asList(352, 62));

//        for(int i = 0; i < t - 1; i++) {
//            modules.add(random.nextInt());
//        }
    }

    public int getShare(int i) {
        int sum = secretNumber;

        for (Integer module : modules) {
            sum += module * i;
        }

        return sum % p;
    }

    public float revealSecret(List<List<Integer>> list) {
        float sum = 0;

        for (int b= 0; b < list.size(); b++) {
            float down = 1, up = 1;
            for (int i = 0; i < t; i++) {
                int j = (i == 0) ? 1 : 0;
                up *= (-1) * list.get(i).get(0);
                down *= list.get(j).get(0) - list.get(i).get(0);
                System.out.println(up + " " + down);
            }

            System.out.println(((up/down) * list.get(b).get(1)) % p);

            sum += ((up/down) * list.get(b).get(1)) % p;
        }

        return sum;
    }
}
