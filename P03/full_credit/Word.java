public class Word {
    private char[] letters = new char[5];

    public Word(String word) { 
        for(int i = 0; i < 5; i++) {
            this.letters[i] = word.charAt(i);
        }
    }

    public char charAt(int position) {
        return letters[position];
    }

    public void setCharAt(char c, int position) {
        letters[position] = c;
    }

    public String toString() {
        String string = new String(letters);
        return string;
    }
}