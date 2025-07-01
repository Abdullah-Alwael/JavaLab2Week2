import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
//        Q1.Write a program to find all the longest word in a given dictionary.
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

        //Q2. Write a program that displays the number of occurrences of an element in the array.
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

//        Q3.Write a program to find the k largest elements in a given array. Elements in the array can be in
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


//        Q5. Write a menu-driven Java program with following option:
//
//        1. Accept elements of an array
//        2. Display elements of an array
//        3. Search the element within array
//        4. Sort the array
//        5. To Stop
        System.out.println("Menu array:");
        System.out.println("How many elements in the array?");
        int[] menuArray = new int[input.nextInt()];
        int choice = 0;
        int numberToFind;
        boolean isFound = false;
        
        do{
            System.out.println("Enter one of the action numbers:");

            System.out.println("1. Accept elements of an array");
            System.out.println("2. Display elements of an array");
            System.out.println("3. Search the element within array");
            System.out.println("4. Sort the array");
            System.out.println("5. To Stop");
            choice = input.nextInt();

            switch (choice){
                case 1: //"1. Accept elements of an array"
                    for (int i = 0; i <= menuArray.length-1; i++) {
                        System.out.println("Please enter the "+(i+1)+" number:");
                        menuArray[i] = input.nextInt();
                    }
                    break;
                case 2: //"2. Display elements of an array"
                    for (int n : menuArray){
                        System.out.print(n + " ,");
                    }
                    System.out.println();
                    break;
                case 3: //"3. Search the element within array"
                    System.out.println("What number to look for?");
                    numberToFind = input.nextInt();
                    for (int i = 0; i <= menuArray.length-1; i++) {
                        if (menuArray[i] == numberToFind){
                            isFound = true;
                            System.out.println("Number "+numberToFind+" is found at location "+(i+1));
                        }
                    }
                    if (!isFound){
                        System.out.println("The number "+numberToFind+" could not be found in the array");
                    }
                    isFound = false;
                    break;
                case 4: //"4. Sort the array"
                    sortNumbers(menuArray);
                    System.out.println("The Array was sorted");
                    break;
                case 5: //"5. To Stop"
                    // the choice is already = 5;
                    break;
                default:
                    System.out.println("Not an option!, try again");
            }
        }while (choice != 5);


    }


//        4. Create a method to reverse an array of integers. Implement the method without creating a new array.
    public static void arrayReverse(int[] array){
        System.out.println("Reversed array is:");
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    // Q5
    public static void sortNumbers(int[] numbers){
        int temp = 0;
        for (int i = 0; i <= numbers.length-1; i++) {
            for (int j = i+1; j <= numbers.length-1; j++) {
                if (numbers[j] < numbers[i]){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

}
