import java.util.Arrays;

import static java.util.Collections.swap;

class ReverseString {
    public static void main(String[] args) {

        String s = "abcdefghijklmnopqrstuvwxyz";

        char array[] = s.toCharArray();

        System.out.println( s );
        new ReverseString().reverseString( array,0);
        System.out.println( new String(array) );
    }


    public void reverseString(char arr[],int i){


        if( i>=(arr.length/2) ) return;

        swap( arr,i,arr.length-1-i );

        reverseString(arr,i+1);


    }

    public static void swap(char []arr,int i,int j ){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}