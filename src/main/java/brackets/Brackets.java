package brackets;

/**
 * This class can check is the amount of '(' equals to  amount of ')' in one string.
 */
public class Brackets {
    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        String str = " ))(()((()((ER)(E)(R)(ER)(ER)(E)RR)E)()()ER()";

        if (brackets.checkString(str)) {
            System.out.print(str + " has equal number of open and close brackets: '(' and ')'. ");
        } else {
            System.out.print(str + " number of open '(' and close ')' brackets is different. ");
        }
    }

    private boolean checkString(String inputString) {
        int flag = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '(') {
                flag++;
            } else if (inputString.charAt(i) == ')') {
                flag--;
            }
        }
        return flag == 0;
    }
}