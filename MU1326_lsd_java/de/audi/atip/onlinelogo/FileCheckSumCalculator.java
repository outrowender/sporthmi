/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.onlinelogo;

import de.audi.atip.onlinelogo.FileCheckSumCalculator$Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileCheckSumCalculator {
    public static final String CHECKSUM_ALG;
    private static final int READ_BUFFER_SIZE;

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
            messageDigest = MessageDigest.getInstance("SHA1");
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
            return new String(FileCheckSumCalculator$Base64.encode(byArray));
        }
        return null;
    }
}

