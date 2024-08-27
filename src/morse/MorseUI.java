package morse;

import java.util.Scanner;

public class MorseUI {
    public static void main(String[] args) {
        Morse morse = new Morse();
        var sc = new Scanner(System.in);

        System.out.println("Bitte geben Sie eine Morse-Zeichenfolge ein:");
        String morseCode = sc.nextLine();

        int morseCodeInt = morse.getMorseCode(morseCode);
        if (morseCodeInt == -1) {
            System.out.println("Diese Zeichenfolge ist keine gültige Morse-Zeichenfolge!");
        } else {
            System.out.println("Diese Zeichenfolge entspricht dem Morse-Code " + morseCodeInt);
        }
    }
}
