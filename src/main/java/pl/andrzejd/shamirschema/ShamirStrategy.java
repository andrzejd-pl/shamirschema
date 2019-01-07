package pl.andrzejd.shamirschema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ShamirStrategy {

    private class Fraction<T, N> {
        public T up;
        public N down;

        public Fraction(T up, N down) {
            this.up = up;
            this.down = down;
        }
    }

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

        for (List<Integer> aList : list) {
            Fraction<Integer, Integer> fraction = functionL(
                    aList.get(0),
                    list.stream()
                            .map(i -> i.get(0))
                            .collect(Collectors.toList())
            );

            System.out.println(fraction.up + " " + fraction.down);
            sum += (((float) (fraction.up / fraction.down)) * aList.get(1)) % p;
        }

        return sum;
    }

    public Fraction<Integer, Integer> functionL(int xI, List<Integer> x) {
        int up = 1, down = 1;

        for (Integer xJ : x) {
            if (xJ == xI) {
                continue;
            }

            down *= (xI - xJ);
            up *= (-1) * xJ;
        }

        return new Fraction<>(up, down);
    }
}
