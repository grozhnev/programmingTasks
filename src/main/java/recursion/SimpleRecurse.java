package recursion;

public class SimpleRecurse {

    public static void main(String[] args){
        SimpleRecurse rec = new SimpleRecurse();
        rec.recurse(32);
    }

    void recurse(int number){
        System.out.print(number + " ");
        if (number > 0) {
            recurse(number-1);
        }
    }
}