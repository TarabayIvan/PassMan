package com.ivantarabay.passman;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&()_+-=[]{}<>";
    private final SecureRandom random;

    public PasswordGenerator() {
        this.random = new SecureRandom();
    }

    public String generate(int length, boolean includeNumbers, boolean includeSpecialChars) {
        if (length <= 7) {
            throw new IllegalArgumentException("Password length must be at least 8");
        }

        StringBuilder password = new StringBuilder();
        List<String> charSets = new ArrayList<>();
        charSets.add(LOWERCASE);
        charSets.add(UPPERCASE);

        if (includeNumbers) {
            charSets.add(NUMBERS);
        }
        if (includeSpecialChars) {
            charSets.add(SPECIAL_CHARS);
        }

        // Select at least one character from each set
        for (String charSet : charSets) {
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // Fill the password
        while (password.length() < length) {
            String charSet = charSets.get(random.nextInt(charSets.size()));
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // Shuffle the password
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }
} 