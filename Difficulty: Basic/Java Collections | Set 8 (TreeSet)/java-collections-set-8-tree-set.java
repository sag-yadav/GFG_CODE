import java.util.*;

class gfg1 {
    void task(TreeSet<String> ts, char a, char b, char c, char d) {

        System.out.println(ts.headSet(String.valueOf(a)));

        System.out.println(ts.tailSet(String.valueOf(b)));

        System.out.println(ts.subSet(String.valueOf(c), String.valueOf(d)));
    }
}