import java.util.Scanner;

public class Quint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordList word = new WordList();
        Puzzle puzzle = new Puzzle(word.getWord());
        String guess = new String();
        int counter = 1;

        System.out.println("=========");
        System.out.println("Q U I N T");
        System.out.println("=========\n");
        System.out.println("Guess a 5-letter word");
        System.out.print("guess ");
        

        guess = scanner.nextLine();

        while(true) {
            System.out.print(puzzle.compareGuess(guess.toUpperCase()) + " ");
            if(puzzle.isSolved() == true){
                System.out.println("Guessed in " + counter + " tries");
                break;
            }
            guess = scanner.nextLine();
            counter++;
        }
    }
}