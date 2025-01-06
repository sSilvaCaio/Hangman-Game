import java.util.List;
import java.util.Random;
import java.util.Scanner;

import wordslist.WordsReader;

public class App {
    public static void main(String[] args) throws Exception {
        
        WordsReader reader = new WordsReader();

        //creates an array using the strings from the txt file
        List<String> allWords = reader.readFile("src/words.txt");

        Random random = new Random();

        /*generate a random number.
        the range of random words is equals to the array size*/
        int intRandom = random.nextInt(allWords.size());

        //get a random word
        String word = allWords.get(intRandom);

        //turns the string into an array
        char[] charArray = word.toLowerCase().toCharArray();

        Scanner keyboard = new Scanner(System.in);

        //create an array of the player guesses, start fulling it with blank spaces
        char[] gameArray = new char[charArray.length];
        for (int i = 0; i<charArray.length; i++ ){
            gameArray[i] = '_';
        }
        
        byte points = 0;
        byte life = 6;
        
        System.out.println("WELCOME TO THE HANGMAN GAME!");
        System.out.printf("The word you have to guess is %d letters long.", charArray.length );
        System.out.printf("\nYou have %d lifes!\n\n\n", life);
        System.out.println(gameArray);

        while(points < charArray.length && life>0){

            System.out.print("Write a letter: ");
            
            //player input a letter
            char key = keyboard.next().toLowerCase().charAt(0);
            
            boolean updated = false;
            
            //verify if the guessed letter is right and replace it on the gameArray
            for (int i = 0; i < charArray.length; i++){
                if(charArray[i] == key){
                    gameArray[i] = key;
                    points++;
                    updated = true;
                }
            }
            
            if(!updated){
                System.out.println("\nWrong letter, you lost 1 life");
                life--;
                System.out.println("\nLifes="+life);
            }else{
                System.out.println();
            }

            System.out.println(gameArray);
        }

        if (points==charArray.length) {
            System.out.printf("\nCongratulations player, you win!!!\nYou succesfully guessed the word '%s' with %d remaining lifes!!", word, life);
        } else{
            System.out.printf("\nOh no, you lost! \nThe word was '%s'.\nBetter luck next time, this one was a nice try!", word);
        }
        keyboard.close();
    }
}
