public class T0058_LengthOfLastWord {
    public static void main(String[] args) {
        int length = lengthOfLastWord("Hello World");
        System.out.println(length);
    }

    public static int lengthOfLastWord(String s) {
        if(s.isEmpty() || s.equals(" ")) return 0;
        if (s.length() == 1) return 1;
        int length = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
               if (length == 0) continue;
               break;
            }
            length++;
        }
        return length;
    }
}
