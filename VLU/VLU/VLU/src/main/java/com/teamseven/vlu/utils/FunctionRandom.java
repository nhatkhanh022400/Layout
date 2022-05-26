package com.teamseven.vlu.utils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class FunctionRandom {

    public static String randomID(int length) {
        byte[] array = new byte[256];
        Random random = new Random();
        random.nextBytes(array);
        String randomString = new String(array, StandardCharsets.UTF_8);
        StringBuilder stringBuffer = new StringBuilder();

        for (int i = 0; i < randomString.length(); i++) {
            char character = randomString.charAt(i);

            if (((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') || (character >= '0' && character <= '9')) && (length > 0)) {
                stringBuffer.append(character);
                length--;
            }
        }

        return stringBuffer.toString();
    }
}
