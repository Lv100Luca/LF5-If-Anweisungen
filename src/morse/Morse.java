package morse;

import java.util.HashMap;

public class Morse {
    public int getMorseCode(String morseCode) {
        var digit = morseDigitsMap().get(morseCode);

        if (digit == null) {
            return -1;
        }

        return digit;
    }

    private HashMap<String, Integer> morseDigitsMap() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("-----", 0);
        map.put(".----", 1);
        map.put("..---", 2);
        map.put("...--", 3);
        map.put("....-", 4);
        map.put(".....", 5);
        map.put("-....", 6);
        map.put("--...", 7);
        map.put("---..", 8);
        map.put("----.", 9);

        return map;
    }
}


