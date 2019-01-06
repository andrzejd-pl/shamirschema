package pl.andrzejd.shamirschema;

import java.math.BigInteger;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ShamirStrategy shamirStrategy = new ShamirStrategy(954, 3);

        System.out.println(shamirStrategy.getShare(1));

        System.out.println(shamirStrategy.revealSecret(Arrays.asList(
                Arrays.asList(2, 383),
                Arrays.asList(3, 1045),
                Arrays.asList(4, 308)
        )));
    }
}
