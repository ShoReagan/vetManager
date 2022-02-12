public class Substitution extends Cypher {
    private char[] encryptKey = new char[26];
    private char[] decryptKey = new char[26];

    public Substitution(String key) {
        if(key.length() != 26)
            throw new IllegalArgumentException("The key is not exactly 26 characters");    
        for(int i = 0; i < 26; i++) {
            for(int j = i + 1; j < 26; j++) {
                if(key.charAt(i) == key.charAt(j))
                    throw new IllegalArgumentException("The key does not have all unique characters");
            }
        }
        for(int k = 0; k < 26; k++) {
            this.encryptKey[k] = key.charAt(k);
        }
        this.decryptKey = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    }

    public String encrypt(String unencrypted) {
        StringBuilder ans = new StringBuilder(unencrypted);

        for(int i = 0; i < unencrypted.length(); i++) {
            if(Character.isLetter(unencrypted.charAt(i))) {
                if(Character.isUpperCase(unencrypted.charAt(i))) {
                    ans.setCharAt(i, Character.toUpperCase(encryptKey[unencrypted.charAt(i) - 'A']));
                }
                else
                    ans.setCharAt(i, encryptKey[unencrypted.charAt(i) - 'a']);
            }
        }

        return ans.toString();
    }

    public String decrypt(String encrypted) {
        StringBuilder ans = new StringBuilder(encrypted);

        for(int i = 0; i < encrypted.length(); i++) {
            if(Character.isLetter(encrypted.charAt(i))) {
                if(Character.isUpperCase(encrypted.charAt(i))) {
                    ans.setCharAt(i, Character.toUpperCase(decryptKey[encrypted.charAt(i) - 'A']));
                }
                else
                    ans.setCharAt(i, decryptKey[encrypted.charAt(i) - 'a']);
            }
        }

        return ans.toString();
    }
}