package ian.toasterbot;
public class TextToBinary {


    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int position = 0;

        for (int x = binary.length() - 1; x >= 0; x--) {
            
            short digit = 1;
            if (binary.charAt(x) == '0') {
                digit = 0;
            }

            double multiplier = Math.pow(2, position);
            decimal += digit * multiplier;
            position++;
        }
        return decimal;
    }
    
    public static String decimalToBinary(int decimal) {
        if (decimal <= 0) {
            return "0";
        }
        String binary = "";
        while (decimal > 0) {
            short remainder = (short) (decimal % 2);
            decimal = decimal / 2;
            binary = String.valueOf(remainder) + binary;
        }
        return binary;
    }

    public static String binaryToText(String binaryText) {
        String[] binaryNumbers = binaryText.split(" ");
        String text = "";
    
        for (String currentBinary : binaryNumbers) {
            int decimal = binaryToDecimal(currentBinary);
            char letra = (char) decimal;
            text += letra;
        }
        return text;
    }

    public static String textToBinary(String originalText) {
        String binaryText = "";
        for (int i = 0; i < originalText.length(); i++) {
            char currentChar = originalText.charAt(i);
            int ascii = (int) currentChar;
            String binary = decimalToBinary(ascii);
            binaryText += binary + " ";
        }
        return binaryText;
    }
}
