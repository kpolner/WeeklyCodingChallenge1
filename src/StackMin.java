import java.util.*;
//        2) Stack Min: How would you design a stack which, in addition to push and pop,
//            has a function min which returns the minimum element?
//            Push, pop and min should all operate in O(1) time.
public class StackMin {
    private int minimum;
    Stack<Integer> st = new Stack<>();
    //pushes the number while checking if it's the min
    public void push(int number) {
        if(st.isEmpty())
        {
            minimum = number;
        }else if(number<minimum)
        {
            minimum = number;
        }
        st.push(number);
    }
    //if the popped number is the current min, finds new min, else pops regularly
    public void pop() {
        if(st.peek() == minimum)
        {
            st.pop();
            minimum = st.peek();
            for(int i=0; i<st.size(); i++)
            {
                if(st.get(i) < minimum)
                {
                    minimum = st.get(i);
                }
            }
        }
        else{
            st.pop();
        }
    }
    //returns min number in the stack
    public int min() {
        return minimum;
    }
    public static void main(String[] args)
    {


        //creates a stack with test numbers then finds min
        StackMin allInts = new StackMin();
        allInts.push(5);
        allInts.push(27);
        allInts.push(702);
        allInts.push(3);
        allInts.push(55);
        System.out.println("minimum: " + allInts.min());

        //pops 55 and 3 off the stack and finds new min
        allInts.pop();
        allInts.pop();
        System.out.println("minimum after pops: " + allInts.min());
    }
}
