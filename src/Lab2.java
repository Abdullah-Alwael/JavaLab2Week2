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

//        3.Write a program to find the k largest elements in a given array. Elements in the array can be in
//        any order. do not use sort

        System.out.println("Checking the largest element in an array:");
        System.out.println("How many elements in the array?");
        int[] largestElements = new int[input.nextInt()]; // do not use sort;

        int firstLargest = 0, secondLargest = 0, thirdLargest = 0;

        for (int i = 0; i <= largestElements.length-1; i++) { // the input loop, set first max number
            System.out.println("Please enter the "+(i+1)+" number:");
            largestElements[i] = input.nextInt();
            if (i == 0){ // assume first is largest
                firstLargest = largestElements[i];
            }
            // set largest-first element
            if (largestElements[i] > firstLargest){
                firstLargest = largestElements[i];
            }
        }

        for (int i = 0; i <= largestElements.length-1; i++){ // set second largest

            // set second-largest element
            if (largestElements[i] == firstLargest){
                continue;
            }
            if (largestElements[i] > secondLargest){
                secondLargest = largestElements[i];
            }
        }

        for (int i = 0; i <= largestElements.length-1; i++){
            // set 3rd largest
            if (largestElements[i] == firstLargest || largestElements[i] == secondLargest){
                continue;
            }
            if (largestElements[i] > thirdLargest){
                thirdLargest = largestElements[i];
            }
        }

        System.out.println("The 3 largest elements are:");
        System.out.println(firstLargest + " "
                +secondLargest+ " "
                +thirdLargest);

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
