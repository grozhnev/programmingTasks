package cascade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * print an array of cascade angle descend or ascend.
 */
public class CascadeAngle {

    int[][] array;
    private int length;
    private int depth;
    private int start;
    private int rising;

    public static void main(String[] args) {
        CascadeAngle cascade = new CascadeAngle();
        cascade.readInput();
        cascade.fillandShowArray();
    }

    private void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter array length : ");
            length = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            System.out.print("Enter array depth: ");
            depth = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            array = new int[length][depth];

            System.out.print("Enter do you want it to grow? (1/0) ");
            rising = Integer.parseInt(reader.readLine().replaceAll(" ", ""));

            System.out.print("Enter first number: ");
            start = Integer.parseInt(reader.readLine().replaceAll(" ", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillandShowArray() {
        if (rising == 1) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < depth; j++) {
                    if (i == 0) {
                        array[i][j] = start + (j + i);
                    } else {
                        if (j <= i) {
                            array[i][j] = array[i - 1][i];
                        } else {
                            array[i][j] = start + (j);
                        }
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
                        if (j <= i) {
                            array[i][j] = array[i - 1][i];
                        } else {
                            array[i][j] = start - (j);
                        }
                    }
                    System.out.print(" " + array[i][j]);
                }
                System.out.print("\n");
            }
        }
    }
}