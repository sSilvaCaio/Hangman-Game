import java.util.List;
import java.util.Random;
import java.util.Scanner;

import wordslist.WordsReader;

public class App {
    public static void main(String[] args) throws Exception {
        //create an instance of the class WordsReader
        WordsReader reader = new WordsReader();

        //creates an array with the readFile method from WordsReader class
        List<String> allWords = reader.readFile("src/words.txt");

        //crates an instance of Random, from java.util.Random
        Random random = new Random();

        /*uses the Random class to generate a random number. 
        It'll be used to select a random word from the array allWords
        the range of random words is equals to the array size*/
        int intRandom = random.nextInt(allWords.size());

        //get a random word
        String word = allWords.get(intRandom);

        //turns the string into an array so I can separate the letters
        char[] charArray = word.toLowerCase().toCharArray();

        //create an instance of Scanner to make inputs
        Scanner keyboard = new Scanner(System.in);

        //create an array of the player guesses, starting fulling it with blank spaces
        char[] gameArray = new char[charArray.length];
        for (int i = 0; i<charArray.length; i++ ){
            gameArray[i] = '_';
        }

        //creates a variable of points to know when to finish the game and a life variable
        byte points = 0;
        byte life = 6;

        //prints the start of the game and the number of letters of the word
        System.out.println("WELCOME TO THE HANGMAN GAME!");
        System.out.printf("The word you have to guess is %d letters long.", charArray.length );
        System.out.printf("\nYou have %d lifes!\n\n\n", life);
        System.out.println(gameArray);

        //game loop, verifying if the player didn't win or lose yet
        while(points < charArray.length && life>0){

            System.out.print("Write a letter: ");
            
            //input a letter
            char key = keyboard.next().toLowerCase().charAt(0);
            
            //create a bool to verify if the player got the letter right
            boolean updated = false;
            
            //verify if the guessed letter is right and replace it on the gameArray
            for (int i = 0; i < charArray.length; i++){
                if(charArray[i] == key){
                    gameArray[i] = key;
                    points++;
                    updated = true;
                }
            }
            
            //if the update variable isn't true, the player guessed wrong, it loses life
            if(!updated){
                System.out.println("\nWrong letter, you lost 1 life");
                life--;
                System.out.println("\nLifes="+life);
            }else{
                System.out.println();
            }

            //print the spaces em letter from the game
            System.out.println(gameArray);
        }

        //win/lose message
        if (points==charArray.length) {
            System.out.printf("\nCongratulations player, you win!!!\nYou succesfully guessed the word '%s' with %d remaining lifes!!", word, life);
        } else{
            System.out.printf("\nOh no, you lost! \nThe word was '%s'.\nBetter luck next time, this one was a nice try!", word);
        }
        keyboard.close();
    }
}
