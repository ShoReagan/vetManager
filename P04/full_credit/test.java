public class test{
    public static void main(String[] args) {
        String hello = "Hello, -  world";
        StringBuilder ans = new StringBuilder(hello);
        char[] de = new char[26];
        char[] en = new char[26];
        de = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        en = "qwertyuiopasdfghjklzxcvbnm".toCharArray();

        for(int i = 0; i < hello.length(); i++) {
            if(Character.isLetter(hello.charAt(i))) {
                if(Character.isUpperCase(hello.charAt(i))) {
                    ans.setCharAt(i, Character.toUpperCase(en[hello.charAt(i) - 'A']));
                }
                else
                    ans.setCharAt(i, en[hello.charAt(i) - 'a']);
            }
        }
        System.out.println(hello + "\n" + ans);
    }
}