import java.util.Random;
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

//        Q6. Create a method that generates a random number within a given range. Allow the user to
//        specify the range and call the method to display random numbers.
//                Hint: use Random class

            int min, max;
        System.out.println("Random number generator:");
        System.out.println("Enter the Minimum range number:");
        min = input.nextInt();
        System.out.println("Enter the maximum range number:");
        max = input.nextInt();

        System.out.println("Enter how many numbers to generate: ");
        int numberToGenerate = input.nextInt();
        System.out.println("The random numbers are:");
        for (int i = 0; i <= numberToGenerate-1; i++) {
            randomGenerator(min, max);
            if (i != numberToGenerate-1){
                System.out.print(", ");
            }
        }

//        Q7. Write a program that checks the strength of a password. Create a method that evaluates a
//        password based on criteria like length, inclusion of special characters, and
//        uppercase/lowercase letters.

        int totalScore = 0;
        int lengthScore = 0;
        int specialScore = 0;
        int upperLowerScore = 0;

        System.out.println();
        System.out.println("Checking password strength:");
        System.out.println("Enter your password:");
        input.nextLine();
        String password = input.nextLine();

        lengthScore = checkLength(password);
        specialScore = checkSpecialCharacters(password);
        upperLowerScore = checkUpperCaseLowerCase(password);

        totalScore = lengthScore+specialScore+upperLowerScore;

        if (totalScore >= 8){
            System.out.println("The password is strong");
        } else if (totalScore >=5){
            System.out.println("The password is moderately strong");
        } else {
            System.out.println("The password is weak! please change it!");
        }

//        Q8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
//                Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
//                and each subsequent number in the sequence is the sum of the two preceding ones.

        System.out.println("Generating Fibonacci sequence");
        System.out.println("How many terms to generate?");

        int fibonacciTerms = input.nextInt();
        fibonacciSequence(fibonacciTerms);


    }


//        Q4. Create a method to reverse an array of integers. Implement the method without creating a new array.
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

    //Q6
    public static void randomGenerator(int min, int max){
        Random rand = new Random();
        System.out.print(rand.nextInt(min, max));
    }

//Q7
    public static int checkLength(String pass){
        int score;

        if (pass.length() >=8){
            score = 3;
        }else if (pass.length() >=6){
            score = 2;
        } else {
            score = 0;
        }

        return score;
    }
    public static int checkSpecialCharacters(String pass){
        int score = 0;
        char[] array = pass.toCharArray();

        for (char c: array){
            switch (c){
                case '!':
                case '@':
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '(':
                case ')':
                case '_':
                case '+':
                case '-':
                case '=':
                case '{':
                case '}':
                case '[':
                case ']':
                case '|':
                case ':':
                case ';':
                case '\"':
                case '\'':
                case '<':
                case '>':
                case ',':
                case '?':
                case '/':
                case '\\':
                case '.':
                case '~':
                case '`':
                case '€':
                case '£':
                case '¥':
                case '¢':
                case '±':
                case '÷':
                case '×':
                case '°':
                case '√':
                case '∞':
                case 'µ':
                case '©':
                case '®':
                case '™':
                case '§':
                case 'á':
                case 'é':
                case 'ñ':
                case 'ü':
                case '¼':
                case '½':
                case '¾':
                    score = 2;
                    break;
            }
        }

        return score;
    }
    public static int checkUpperCaseLowerCase(String pass){
        int score;
        boolean hasUpper = false;
        boolean hasLower = false;

        char[] array = pass.toCharArray();
        for (char c:array){
            switch (c){
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    hasUpper = true;
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    hasLower = true;
                    break;
            }

        }

        if (hasUpper && hasLower){
            score = 3;
        } else {
            score = 0;
        }
        return score;
    }

    //Q8
    public static void fibonacciSequence(int fibonacciTerms){
        int first = 0;
        int second = 0;
        int sum;
        for (int i = 0; i < fibonacciTerms; i++) {
            if(i == 0 || i == 1){
                System.out.print(i);
                first = i;
            } else {
                sum = first+ second;
                System.out.print(sum);
                second = first;
                first = sum;
            }

            if (i != fibonacciTerms-1){
                System.out.print(", ");
            }
        }
    }
}
