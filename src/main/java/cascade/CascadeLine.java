package cascade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * print an array of cascade lines: ascend or descend.
 */
public class CascadeLine {
    private int[][] array;
    private int length;
    private int depth;
    private int start;
    private int isRising;

    public static void main(String[] args) {
        CascadeLine cascade = new CascadeLine();
        cascade.readInput();
        cascade.fillandShow();
    }

    private void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter array length: ");
            length = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            System.out.print("Enter array depth: ");
            depth = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            array = new int[length][depth];

            System.out.print("Enter do you want it to grow? (1/0) ");
            isRising = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            System.out.print("Enter first number: ");
            start = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillandShow() {
        if (isRising == 1) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < depth; j++) {
                    if (i > 0) {
                        array[i][j] = start + (j + i);
                    } else {
                        array[i][j] = start + j;
                    }
                    System.out.print(" " + array[i][j]);
                }
                System.out.print("\n");
            }
        } else {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < depth; j++) {
                    if (i == 0) {
                        array[i][j] = start - j;
                    } else {
                        array[i][j] = start - (j + 1);
                    }
                    System.out.print(" " + array[i][j]);
                }
                System.out.print("\n");
            }
        }
    }
}