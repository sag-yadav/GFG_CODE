import java.util.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int lastDigit = Math.abs(n % 10);
        System.out.println(lastDigit);
    }
}