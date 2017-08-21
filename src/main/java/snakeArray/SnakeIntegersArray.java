package snakeArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description: Print snake-form array in two ways of code.
 */

public class SnakeIntegersArray {
    private int side;
    private int[][] array;

    public static void main(String[] args) {
        SnakeIntegersArray arr = new SnakeIntegersArray();
        arr.setLengthDepthAndSize();

        arr.fillArrayInner();
        arr.printArray();

        arr.fillArrayOutter();
        arr.printArray();
    }

    private void printArray() {
        System.out.println();
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    private void setLengthDepthAndSize() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter array side: ");
            side = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            array = new int[side][side];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maths solution:
     * We divide square of array in two parts: upper right and lower left triangles.
     * For each part we use different formula.
     * In this way we don't use extra memory.
     */
    private void fillArrayOutter() {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                int min = (i < j ? i : j) < (side - i - 1 < side - j - 1 ? side - i - 1 : side - j - 1) ? (i < j ? i : j) : (side - i - 1 < side - j - 1 ? side - i - 1 : side - j - 1);
                if (i <= j) {
                    /*upperRigth*/
                    array[i][j] = (side - min * 2) * (side - min * 2) - (i - min) - (j - min);
                } else {
                    /*downLeft*/
                    array[i][j] = (side - min * 2 - 2) * (side - min * 2 - 2) + (i - min) + (j - min);
                }
            }
        }
    }

    /**
     * Logic solution:
     * We fill the array line by line, like real snake.
     */
    private void fillArrayInner() {
        int value = 1;

        int minRow = 0;
        int maxRow = side - 1;
        int minColumn = 0;
        int maxColumn = side - 1;

        while (value <= side * side) {
            for (int i = minColumn; i <= maxColumn; i++) {
                array[minRow][i] = value;
                value++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                array[i][maxColumn] = value;
                value++;
            }
            maxColumn--;

            for (int i = maxColumn; i >= minColumn; i--) {
                array[maxRow][i] = value;
                value++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                array[i][minColumn] = value;
                value++;
            }
            minColumn++;
        }
    }
}