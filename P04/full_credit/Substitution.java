public class Substitution extends Cypher {
    private char encryptKey[26];
    private char decryptKey[26];

    public Substitution(String key) {
        if(key.length() != 26)
            throw new IllegalArgumentException("The key is not exactly 26 characters");    
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                if(key.charAt(i) == key.charAt(j))
                    throw new IllegalArgumentException("The key does not have all unique characters");
                }
            }
    }

    public String encrypt(String unencrypted) {


    }

    public String decrypt(String encrypted) {


    }
}