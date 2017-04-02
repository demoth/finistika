package com.db.prisma.droolspoc;

import java.util.Random;

/**
 * Created by daniil on 02.04.17.
 */
public class Utils {
    private static final Random RANDOM = new Random();
    private static String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String getRandomAlphanum(int size) {
        char[] data = new char[size];
        for (int i = 0; i < size; i++) {
            data[i] = CHARS.charAt(RANDOM.nextInt(CHARS.length()));
        }
        return String.valueOf(data);
    }

}
