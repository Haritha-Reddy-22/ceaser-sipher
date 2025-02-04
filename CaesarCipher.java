import java.util.Scanner;

public class CaesarCipher {
    // Encrypts text using a shift of s
    public static String encrypt(String text, int s) {
        StringBuilder result = new StringBuilder();
        s = s % 26 + 26;
        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    result.append((char) ('A' + (i - 'A' + s) % 26 ));
                } else {
                    result.append((char) ('a' + (i - 'a' + s) % 26 ));
                }
            } else {
                result.append(i);
            }
        }
        return result.toString();
    }

    // Decrypts text using a shift of s
    public static String decrypt(String text, int s) {
        return encrypt(text, -s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to be encrypted:");
        String text = scanner.nextLine();

        System.out.println("Enter the shift value:");
        int s = scanner.nextInt();

        String encryptedText = encrypt(text, s);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, s);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
