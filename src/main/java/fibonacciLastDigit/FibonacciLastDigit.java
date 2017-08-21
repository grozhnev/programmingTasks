package fibonacciLastDigit;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class: FibonacciLastDigit
 * Version: 0.1
 * <p>
 * Created by: Georgii Rozhnev, https://github.com/grozhnev
 * Date: 2017-08-21
 * <p>
 * Description:  Enter the n-th number of Fibonacci list.
 * And you'll see the last digit of this number.
 */
public class FibonacciLastDigit {
    private static int countFib(int inputNumber) {
        HashMap<Integer, Integer> fib = new HashMap<>();
        fib.put(0, 1);
        fib.put(1, 1);

        for (int i = 2; i <= inputNumber; i++) {
            fib.put(i, (fib.get(i - 1) % 10 + fib.get(i - 2) % 10));
        }
        return fib.get(inputNumber - 1) % 10;
    }

    public static void main(String[] args) {
        System.out.print("Enter n-th number in Fibonacci row: ");
        Scanner sc = new Scanner(System.in);
        int orderOfNumber = sc.nextInt();
        System.out.println("Fibonacci's " + orderOfNumber + "th number last digit is " + countFib(orderOfNumber));
    }
}
