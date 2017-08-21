package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * recursion.RecursivePowOfTwo class contains recursive method that counts the result of selected power of 2.
 * <p>
 * written in simple note
 * v 0.21
 */

public class RecursivePowOfTwo {
    public int result = 2;
    private int powOfTwo;

    public static void main(String[] args) {
        RecursivePowOfTwo recursion = new RecursivePowOfTwo();
        recursion.printRecursion();
    }

    private int countPower(int power) {
        if (power > 0) {
            result *= countPower(power - 1);
            System.out.println(result);
        }
        return result;
    }

    private void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the power of 2: ");
            powOfTwo = Integer.parseInt(reader.readLine().replaceAll(" ", ""));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void printRecursion() {
        readInput();
        countPower(powOfTwo);
        System.out.println("\nPower of 2 in " + powOfTwo + " is " + result);
    }
}
