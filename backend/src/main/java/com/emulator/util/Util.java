package com.emulator.util;

import java.util.Random;

public final class Util {
    public static String generateRandomId(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static String convertSize(String sizeInBytes) {
        long size = Long.parseLong(sizeInBytes);

        if (size < 1024) {
            return size + " B";
        }

        double sizeInKB = size / 1024.0;
        if (sizeInKB >= 1024) {
            double sizeInMB = sizeInKB / 1024.0;
            return String.format("%.2f MB", sizeInMB);
        } else {
            return String.format("%.2f KB", sizeInKB);
        }
    }
}
