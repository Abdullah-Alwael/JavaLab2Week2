import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
//        1.Write a program to find all the longest word in a given dictionary.
        System.out.println("Checking longest word in the array");

        String[] longestWords = { "cat", "dog", "red", "is", "am" };
        int longest = 0;

        System.out.println("The array:");
        for (String word:longestWords){
            System.out.print("\""+word+"\", ");
            if (word.length() > longest){
                longest = word.length();
            }
        }
        System.out.println();
        System.out.println("Longest words are: ");
        for (String word:longestWords){
            if (word.length() == longest){
                System.out.print("\""+word+"\", ");
            }
        }

        //2. Write a program that displays the number of occurrences of an element in the array.
        System.out.println();
        System.out.println("Checking the occurrences of an element in an array");
        Scanner input = new Scanner(System.in);

        System.out.println("How many elements in the array?");
        int[] occurrences = new int[input.nextInt()];

        for (int i = 0; i <= occurrences.length-1; i++) {
            System.out.println("Please enter the "+(i+1)+" number:");
            occurrences[i]= input.nextInt();
        }

        System.out.println("enter a number to check how many times it occurs:");
        int occurringNumber = input.nextInt();
        int occurs = 0;

        for (int n:occurrences){
            if (n == occurringNumber){
                occurs++;
            }
        }

        System.out.println(occurringNumber + " occurs "+occurs+" times");
//TODO do not use sort!
//        3.Write a program to find the k largest elements in a given array. Elements in the array can be in
//        any order. do not use sort?

        System.out.println("Checking the largest element in an array:");
        System.out.println("How many elements in the array?");
        int[] largestElements = new int[input.nextInt()]; // sort first

        for (int i = 0; i <= largestElements.length-1; i++) {
            System.out.println("Please enter the "+(i+1)+" number:");
            largestElements[i]= input.nextInt();
        }

        Arrays.sort(largestElements);

        System.out.println("The 3 largest elements are:");
        System.out.println(largestElements[largestElements.length-1] + " "
                +largestElements[largestElements.length-2] + " "
                +largestElements[largestElements.length-3]);

        //Q4
        System.out.println("Reversing an array:");
        System.out.println("How many elements in the array?");
        int[] reverseThisArray = new int[input.nextInt()];
        //enter the elements
        for (int i = 0; i <= reverseThisArray.length-1; i++) {
            System.out.println("Please enter the "+(i+1)+" number:");
            reverseThisArray[i]= input.nextInt();
        }
        //reverse the array
        arrayReverse(reverseThisArray);


    }

//        4. Create a method to reverse an array of integers. Implement the method without creating a new array.
    public static void arrayReverse(int[] array){
        System.out.println("Reversed array is:");
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
