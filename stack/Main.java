package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


        Stack st = new Stack(3);

//        st.pop();
        st.push(77);
        st.push(2);
        st.push(3);
        st.push(54);
        st.push(32);
        st.push(43);
//        System.out.println(st.peek());

//        st.push(4);
//        System.out.println(st.isEmpty());))
//
        System.out.println(st.pop());
        System.out.println(st.pop());



//        System.out.println(st.isEmpty());

        System.out.println(st.isFull());



    }
}
