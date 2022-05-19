import java.util.*;
//        1) Sum Lists: You have two numbers represented by a linked list, where each node contains a single
//        digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
//        function that adds the two numbers and returns the sum as a linked list.
//
//        EXAMPLE
//        Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
//        Output: 2 -> 1 -> 9. That is, 912.
//
//        FOLLOW UP
//        Suppose the digits are stored in forward order. Repeat the above problem.
//        Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
//        Output: 9 -> 1 -> 2. That is, 912.
public class sumLists {
    public static void main (String[] args) {
        //creates new linked lists to set up the problem
    LinkedList<Integer> first = new LinkedList<>();
    LinkedList<Integer> second = new LinkedList<>();

//fills in linked lists
    first.addFirst(7);
    first.add(1);
    first.addLast(6);

    second.addFirst(5);
    second.add(9);
    second.addLast(2);


        String start = "start";
        //retrieves each value from each linked list and stores it as a single number
        int forward1 = listValue(start, first);
        int forward2 = listValue(start, second);

        //same thing as above, but reverse order
        int reverse1 = listValue("", first);
        int reverse2 = listValue("", second);

        //sums the two numbers for both problems
        int forwardResult = sum(forward1, forward2);
        int reverseResult = sum(reverse1, reverse2);

        System.out.println("Number 1: " + forward1);
        System.out.println("Number 2: " + forward2);
        System.out.println("Forward order: " + forwardResult);
        System.out.println("Reverse order: " + reverseResult);
    }

    //iterates through all the values and sums them up
    public static int sum(int ...values) {
        int sum = 0;
        for(int i=0; i<values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    //if first word is start, goes through linked list forwards, else goes through it reversed
    //returns the int value of the built string
    public static int listValue(String firstNum, LinkedList<Integer> list) {
        Iterator<Integer> iterator;
        StringBuilder num = new StringBuilder();

        if (Objects.equals(firstNum, "start")) {
            iterator = list.iterator();
        } else {
            iterator = list.descendingIterator();
        }

        while (iterator.hasNext()) {
            num.append(iterator.next());
        }

        return Integer.valueOf(num.toString());
    }
}
