package oddEvenArrayRows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Enter the length and depth of array [][].
 * Odd rows should be filled with even numbers, and even rows reverse.
 */

public class OddEvenArray {
    private int arrayLength;
    private int arrayDepth;
    private int[][] array;

    public static void main(String[] args) {
        OddEvenArray array = new OddEvenArray();

        array.setLengthAndDepth();
        array.buildArray();

        /* we fill array without extra variables */
        array.fillArrayShortWay();
        System.out.println("\nShort way built:");
        array.printArray();

        /* we fill array in a simple logical way */
        array.fillArrayLogicWay();
        System.out.println("\nLogical way built:");
        array.printArray();
    }


    private void setLengthAndDepth() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter array length: ");
            arrayLength = Integer.parseInt(reader.readLine().replaceAll(" ", ""));
            System.out.print("Enter array depth: ");
            arrayDepth = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildArray() {
        array = new int[arrayLength][arrayDepth];
    }

    private void fillArrayShortWay() {
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayDepth; j++) {
                if (i % 2 == 0) {
                    array[i][j] = i * arrayDepth + (j + 1) * 2;
                } else {
                    array[i][j] = (i - 1) * arrayDepth + (j + 1) * 2 - 1;
                }
            }
        }
    }

    private void fillArrayLogicWay() {
        int even = 0;
        int odd = -1;
        int elementsAmount = (arrayLength * arrayDepth);

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayDepth; j++) {
                if (elementsAmount > 0) {
                    if (i % 2 == 0) {
                        array[i][j] = (even += 2);
                    } else {
                        array[i][j] = (odd += 2);
                    }
                }
                elementsAmount--;
            }
        }
    }

    private void printArray() {
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayDepth; j++) {
                System.out.print("\t" + array[i][j] );
            }
            System.out.print("\n");
        }
    }
}
