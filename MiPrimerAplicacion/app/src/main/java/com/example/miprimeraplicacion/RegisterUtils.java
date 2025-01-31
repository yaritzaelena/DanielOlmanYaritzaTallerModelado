package com.example.miprimeraplicacion;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegisterUtils {

    public static boolean isVisaOrMastercard(String cardNumber) {
        if (cardNumber.length() == 16) {
            if (cardNumber.startsWith("4")) {
                return true; // Es Visa
            } else if (cardNumber.startsWith("51") || cardNumber.startsWith("52") ||
                    cardNumber.startsWith("53") || cardNumber.startsWith("54") || cardNumber.startsWith("55")) {
                return true; // Es Mastercard
            }
        }
        return false;
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        // Patrones para letras, números y símbolos especiales
        String letters = "[a-zA-Z]";
        String numbers = "[0-9]";
        String specialChars = "[!@#$%^&*(),.?\":{}|<>]";

        // Comprueba si la contraseña contiene cada tipo
        boolean hasLetters = password.matches(".*" + letters + ".*");
        boolean hasNumbers = password.matches(".*" + numbers + ".*");
        boolean hasSpecialChars = password.matches(".*" + specialChars + ".*");

        // Al menos dos tipos de caracteres
        int typeCount = 0;
        if (hasLetters) typeCount++;
        if (hasNumbers) typeCount++;
        if (hasSpecialChars) typeCount++;

        return typeCount >= 2;
    }


}
