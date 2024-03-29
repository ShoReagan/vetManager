public class Word {
    private char[] letters = new char[5];

    public Word(String word){
        if(word.length() != 5){
            throw new IllegalArgumentException("The parameter is not exactly 5 characters");
        }
        for(int i = 0; i < 5; i++) {
            if(validateChar(word.charAt(i)) == true || word.charAt(i) == '.'){
                this.letters[i] = word.charAt(i);
            }
            else {
                throw new IllegalArgumentException("Any character in the word is not between A-Z inclusive");
            }
        }
    }

    public char charAt(int position) {
        if(position < 0 || position > 4)
            throw new IllegalArgumentException("The position parameter is not 0-4 inclusive");
        return letters[position];
    }

    public void setCharAt(char c, int position) {
        if(position < 0 || position > 4)
            throw new IllegalArgumentException("The position parameter is not 0-4 inclusive");
        for(int j = 0; j < 5; j++) {
            if(validateChar(c) == true || c == '.' || c == ' '){
                letters[position] = c;
            }
            else {
                throw new IllegalArgumentException("Any character in the word is not between A-Z inclusive");
            }
        }
    }

    public String toString() {
        String string = new String(letters);
        return string;
    }

     public boolean validateChar(char c) {
        return Character.isLetter(c);
    }
}