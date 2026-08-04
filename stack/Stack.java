package stack;


//Interview Rating: 10/10.


public class Stack<T> {

    private T []data;
    private int ptr;
    private int capacity;

    //constructor
    public Stack(int cap){
        data = (T[])new Object[cap];
        ptr = -1;
        capacity = cap;
    }


    //pop
    public T pop(){
        //special case                        || ptr == -1
        if( ptr == -1 ){
            throw new RuntimeException("underflow");
        }
        T poppedValue = data[ptr];
        data[ptr--] = null;
        return poppedValue;
    }

    //isFull
    public boolean isFull(){
        return ptr+1 == capacity ;
    }

    //isEmpty
    public boolean isEmpty(){
        return ptr == -1 ;
    }

    //push
    public void push( T value ){

        //special case
        if( ptr+1 == capacity ){

            //yha code likh array ko expand krne ka
            data = copyAndAllocateNewMemory();
            capacity = capacity*2;
        }
        data[++ptr] = value;
    }

    public T peek(){
        if( ptr == -1 )
            throw new RuntimeException("peek not available :underflow");
        return data[ptr];
    }

    private T[] copyAndAllocateNewMemory(  ){
        int newCapacity = capacity*2;

        //making new array of double capacity
        T []newData = (T[])new Object[newCapacity];

        //copying data
        for( int i = 0;i<=ptr;i++ )
            newData[i] = data[i];

        return newData;

    }
}
