package snakeArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description: print the string and see the spiral of it.
 */
public class SnakeWrittenPhrase {
    private int len;
    private int dep;
    private String phrase;
    private char[][] array;

    public static void main(String[] args) {
        SnakeWrittenPhrase arr = new SnakeWrittenPhrase();
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

            array = new char[len][dep];

            System.out.print("Enter string: ");
            phrase = reader.readLine();

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

        while (last <= (len*dep)){

            for (int i = minColumn; i <= maxColumn; i++) {
                if( last > phrase.length()) {
                    array[maxRow][i] = ' ';
                } else {
                    array[minRow][i] = phrase.charAt(last-1);
                }
                last++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                if( last >  phrase.length()) {
                    array[i][maxColumn] = ' ';
                } else {
                    array[i][maxColumn] = phrase.charAt(last-1);
                }
                last++;
            }
            maxColumn--;

            for (int i = maxColumn; i >= minColumn; i--) {
                if( last >  phrase.length()) {
                    array[maxRow][i] = ' ';
                } else {
                array[maxRow][i] = phrase.charAt(last-1);
                }
                last++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                if( last >  phrase.length()) {
                    array[i][minColumn] = ' ';
                } else {
                    array[i][minColumn] = phrase.charAt(last-1);
                }
                last++;
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