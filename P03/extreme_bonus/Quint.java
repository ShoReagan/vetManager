import java.util.Scanner;

public class Quint {

    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordList word = new WordList();
        Puzzle puzzle = new Puzzle(word.getWord());
        String guess = new String("AAAAA");
        int counter = 1;
        String str = new String("     ");

        System.out.println("=========");
        System.out.println("Q U I N T");
        System.out.println("=========\n");
        System.out.println("Guess a 5-letter word");
        System.out.print("guess ");
    while(true){
        try {
            guess = scanner.nextLine();
            while(true) {
                str = puzzle.compareGuess(guess.toUpperCase());
                for(int i = 0; i < 5; i++) {
                    if(Character.isLowerCase(str.charAt(i)) == true)
                        System.out.print(ANSI_YELLOW_BACKGROUND + str.charAt(i) + ANSI_RESET);
                    else if(Character.isUpperCase(str.charAt(i)) == true)
                        System.out.print(ANSI_GREEN_BACKGROUND + str.charAt(i) + ANSI_RESET);
                    else
                        System.out.print(ANSI_BLACK_BACKGROUND + str.charAt(i) + ANSI_RESET);     
                }
                System.out.print(" ");
                if(puzzle.isSolved() == true){
                    System.out.println("Guessed in " + counter + " tries");
                    System.exit(0);
                }
                guess = scanner.nextLine();
                counter++;
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println(e);
            System.out.print("guess: ");
        }
    }
    }
}