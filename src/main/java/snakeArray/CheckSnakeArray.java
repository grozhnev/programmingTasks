package snakeArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * print snake array
 */
public class CheckSnakeArray {
    private int len;
    private int dep;
    private int[][] array;

    public static void main(String[] args) {
        CheckSnakeArray arr = new CheckSnakeArray();
        arr.setLengthDepthAndSize();
        arr.fillArray();
        arr.printArray();
    }

    private void setLengthDepthAndSize() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter array length: ");
            len = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            System.out.print("Enter array depth: ");
            dep = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            array = new int[len][dep];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillArray() {
        int last = 1;
        int minRow = 0;
        int maxRow = len - 1;
        int minColumn = 0;
        int maxColumn = dep - 1;

        while (last <= (len * dep)) {
            for (int i = minColumn; i <= maxColumn; i++) {
                array[minRow][i] = last++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                array[i][maxColumn] = last++;
            }
            maxColumn--;

            for (int i = maxColumn; i >= minColumn; i--) {
                array[maxRow][i] = last++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                array[i][minColumn] = last++;
            }
            minColumn++;
        }
    }

    private void printArray() {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < dep; j++) {
                System.out.print("\t" + array[i][j]);
            }
            System.out.print("\n");
        }
    }
}