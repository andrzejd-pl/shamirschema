package pl.andrzejd.shamirschema;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ShamirStrategy shamirStrategy = new ShamirStrategy(954, 3);

        System.out.println(shamirStrategy.getShare(1));
        System.out.println(shamirStrategy.getShare(2));
        System.out.println(shamirStrategy.getShare(3));
        System.out.println(shamirStrategy.getShare(4));

        System.out.println(shamirStrategy.revealSecret(Arrays.asList(
                Arrays.asList(2, shamirStrategy.getShare(2)),
                Arrays.asList(3, shamirStrategy.getShare(3)),
                Arrays.asList(4, shamirStrategy.getShare(4))
        )));
    }
}
