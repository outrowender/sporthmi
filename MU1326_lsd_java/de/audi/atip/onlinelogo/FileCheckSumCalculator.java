/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.onlinelogo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileCheckSumCalculator {
    public static final String CHECKSUM_ALG = "SHA1";
    private static final int READ_BUFFER_SIZE = 1024;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String calcChecksum(String string) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] byArray = null;
        byte[] byArray2 = new byte[1024];
        File file = new File(string);
        if (!file.canRead()) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance(CHECKSUM_ALG);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        if (messageDigest != null) {
            try {
                int n;
                int n2 = 0;
                while ((n = fileInputStream.read(byArray2)) != -1) {
                    n2 += n;
                    messageDigest.update(byArray2, 0, n);
                }
                byArray = messageDigest.digest();
                fileInputStream.close();
            }
            catch (IOException iOException) {
                byArray = null;
            }
            finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException iOException) {
                        fileInputStream = null;
                    }
                }
            }
        }
        if (byArray != null) {
            return new String(Base64.encode(byArray));
        }
        return null;
    }

    public static class Base64 {
        static final char[] DIGITS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

        public static byte[] decode(byte[] byArray) {
            int n;
            if (byArray.length == 0) {
                return byArray;
            }
            int n2 = byArray.length - 1;
            while (byArray[n2] == 61) {
                --n2;
            }
            int n3 = byArray.length - 1 - n2;
            int n4 = byArray.length * 6 / 8 - n3;
            byte[] byArray2 = new byte[n4];
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            int n8 = (n2 + 1) / 4;
            for (n = 0; n < n8; ++n) {
                int n9;
                n7 = 0;
                for (n9 = 0; n9 < 4; ++n9) {
                    n7 = n7 << 6 | Base64.decodeDigit(byArray[n5++]);
                }
                for (n9 = n6 + 2; n9 >= n6; --n9) {
                    byArray2[n9] = (byte)(n7 & 0xFF);
                    n7 >>>= 8;
                }
                n6 += 3;
            }
            switch (n3) {
                case 1: {
                    n7 = 0;
                    for (n = 0; n < 3; ++n) {
                        n7 = n7 << 6 | Base64.decodeDigit(byArray[n5++]);
                    }
                    n7 <<= 6;
                    n7 >>>= 8;
                    for (n = n6 + 1; n >= n6; --n) {
                        byArray2[n] = (byte)(n7 & 0xFF);
                        n7 >>>= 8;
                    }
                    break;
                }
                case 2: {
                    n7 = 0;
                    for (n = 0; n < 2; ++n) {
                        n7 = n7 << 6 | Base64.decodeDigit(byArray[n5++]);
                    }
                    n7 <<= 6;
                    n7 <<= 6;
                    n7 >>>= 8;
                    byArray2[n6] = (byte)((n7 >>>= 8) & 0xFF);
                    break;
                }
            }
            return byArray2;
        }

        static int decodeDigit(byte by) {
            char c2 = (char)by;
            if (c2 <= 'Z' && c2 >= 'A') {
                return c2 - 65;
            }
            if (c2 <= 'z' && c2 >= 'a') {
                return c2 - 97 + 26;
            }
            if (c2 <= '9' && c2 >= '0') {
                return c2 - 48 + 52;
            }
            switch (c2) {
                case '+': {
                    return 62;
                }
                case '/': {
                    return 63;
                }
            }
            throw new IllegalArgumentException("Invalid char to decode: " + by);
        }

        public static byte[] encode(byte[] byArray) {
            int n;
            int n2 = byArray.length / 3;
            int n3 = (byArray.length + 2) / 3 * 4;
            byte[] byArray2 = new byte[n3];
            int n4 = byArray.length - n2 * 3;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            for (n = 0; n < n2; ++n) {
                int n8;
                n7 = 0;
                for (n8 = 0; n8 < 3; ++n8) {
                    n7 = n7 << 8 | byArray[n5++] & 0xFF;
                }
                for (n8 = n6 + 3; n8 >= n6; --n8) {
                    byArray2[n8] = (byte)DIGITS[n7 & 0x3F];
                    n7 >>>= 6;
                }
                n6 += 4;
            }
            switch (n4) {
                case 1: {
                    n7 = byArray[n5++];
                    n7 <<= 8;
                    n7 <<= 8;
                    for (n = n6 + 3; n >= n6; --n) {
                        byArray2[n] = (byte)DIGITS[n7 & 0x3F];
                        n7 >>>= 6;
                    }
                    byArray2[byArray2.length - 1] = 61;
                    byArray2[byArray2.length - 2] = 61;
                    break;
                }
                case 2: {
                    n7 = byArray[n5++];
                    n7 = n7 << 8 | byArray[n5++] & 0xFF;
                    n7 <<= 8;
                    for (n = n6 + 3; n >= n6; --n) {
                        byArray2[n] = (byte)DIGITS[n7 & 0x3F];
                        n7 >>>= 6;
                    }
                    byArray2[byArray2.length - 1] = 61;
                    break;
                }
            }
            return byArray2;
        }
    }
}

