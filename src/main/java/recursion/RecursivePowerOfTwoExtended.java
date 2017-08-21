package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Class: RecursivePowerOfTwoExtended
 * Version: 0.1
 * <p>
 * Created by: Georgii Rozhnev, https://github.com/grozhnev
 * Date: 2017-08-21
 * <p>
 * Description: this class counts the result of selected power of 2.
 *        Note: this class uses BigInteger, so we can use large powers of two
 *
 */
public class RecursivePowerOfTwoExtended {
    private BigInteger powOfTwo;
    private BigInteger result = BigInteger.valueOf(2);


    public static void main(String[] args) {
        RecursivePowerOfTwoExtended recursion = new RecursivePowerOfTwoExtended();
        recursion.printRecursion();
    }

    private BigInteger countPower(BigInteger power) {
        if (Long.valueOf(power.toString()) >  0) {
            result = result.multiply(countPower(power.subtract(BigInteger.ONE)));
            //System.out.println("\n#"+power+"\n"+result);
        }
        return result;
    }

    private void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the power of 2: ");
            powOfTwo = BigInteger.valueOf(Integer.parseInt(reader.readLine().replaceAll(" ", "")));
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
