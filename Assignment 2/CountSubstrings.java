import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

/**
 * This program will ask the user for a file name. If the user inputs a 
 * wrong file name, the program will catch it, but if they enter a correct
 * one, then the code will go on. It will ask the user for a word
 * to search for in the file, and the program will find the amount
 * of times it appears and the time it took to look for it.
 *
 * @Monishkumar Sivakumar
 * @2020/02/16
 */
public class CountSubstrings
{
    List<String> ListOne = new ArrayList<String>();
    List<String> ListTwo = new ArrayList<String>();
    List<Character> aPat = new ArrayList<Character>();
    List<Character> lPat = new LinkedList<Character>();
    List<Character> lList = new LinkedList<Character>();
    List<Character> aList = new ArrayList<Character>();
    int lCount = 0;
    int aCount = 0;

    
    public CountSubstrings() throws IOException
    {
         /* This block of code asks the user for a filename and it will
           check if it exists*/
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter the path for the input file: ");
            String filename = userInput.nextLine();
            checkFile(filename);
        
         /* This block of code creates the files, 2 different ones
          * one for the arraylist and the other for linkedlist
          */   
            File userFile = new File(filename);
            Scanner fileReaderOne = new Scanner(userFile);
            Scanner fileReaderTwo = new Scanner(userFile);
            
         /* this block of code will ask the user for a word
          * to search for in the file
          */
            System.out.println("Enter the pattern to look for: ");
            String pattern = userInput.nextLine();
    
         /* This makes a linkedlist and arraylist with the 
            word that the code will search for in it*/   
            for (int i = 0; i < pattern.length(); i++) {
                aPat.add(pattern.charAt(i));
                lPat.add(pattern.charAt(i));
            }           
        
         /* for arraylists, this block of code will
            add all the words in the file into an array list*/
            long lTimeOne = System.currentTimeMillis(); 
            while (fileReaderOne.hasNext()){

                ListOne.add(fileReaderOne.next());
            } 

            fileReaderOne.close();
    
         /* this block of code finds the amount of times the word
            appears in the file*/   
            for (int i = 0; i < ListOne.size(); i++){
                String wordList = ListOne.get(i);
                for (int j = 0; j < wordList.length(); j++){
                    lList.add(wordList.charAt(j));
                }
                int lNum = findBrute(lList, lPat);
                if (lNum != -1){
                    lCount = lCount + 1;
                }
            }
            long lTimeTwo = System.currentTimeMillis();
            
         /* for linkedlists, this block of code will
            add all the words in the file into a link list*/
            long aTimeOne = System.currentTimeMillis();
            while (fileReaderTwo.hasNext()){
                ListTwo.add(fileReaderTwo.next());
            }
            fileReaderTwo.close();
            
         /* this block of code finds the amount of times the word
            appears in the file*/   
            for (int i = 0; i < ListTwo.size(); i++){
                String wordList = ListTwo.get(i);
                for (int j = 0; j < wordList.length(); j++){
                    aList.add(wordList.charAt(j));
                }
                int aNum = findBrute(aList, aPat);
                if (aNum != -1){
                    aCount = aCount + 1;
                }
            }   
            long aTimeTwo = System.currentTimeMillis(); 
            
         /* This block of code prints out the amount of times
            the word appeared in linkedlists, and arraylists as
            well as how long it took for each one*/   
            System.out.println("Using ArrayLists: " + aCount  
            + " matches, derived in " + (aTimeTwo - aTimeOne) + " milliseconds.");
            System.out.println("Using LinkedLists: " + lCount 
            + " matches, derived in " + (lTimeTwo - lTimeOne) + " milliseconds.");  
    
    }
    
    public static void userInput() throws IOException{
        CountSubstrings input = new CountSubstrings();
    }
    
    /* this method will check if the file name exists*/
    private void checkFile(String fName){
        try {
        File userFile = new File(fName);
        Scanner fileReader = new Scanner(userFile);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    /*  Returns the lowest index at which substring pattern begins in text (or else -1). */
    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n - m; i++) { // try every starting index// within text
             int k = 0; // k is index into pattern
             while (k < m && text.get(i + k) == pattern.get(k))
             // kth character of pattern matches
             k++;
             if (k == m) // if we reach the end of the pattern,
             return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }
}
