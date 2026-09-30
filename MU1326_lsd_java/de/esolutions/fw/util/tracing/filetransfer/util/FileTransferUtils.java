/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.util;

import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;

public class FileTransferUtils {
    public static String QNX_SEPERATOR = "/";
    public static String WIN_SEPERATOR = "\\";

    public static byte[] calcuclateHashWithOpen(byte by, IFile iFile) {
        iFile.close();
        iFile.open(false);
        byte[] byArray = FileTransferUtils.calculateHash(by, iFile);
        iFile.close();
        return byArray;
    }

    public static byte[] calculateHash(byte by, IFile iFile) {
        byte[] byArray = new byte[]{};
        try {
            String string = "MD5";
            if (by == FileTransferConstants.HASH_TYPE_MD5) {
                string = "MD5";
            }
            if (by == FileTransferConstants.HASH_TYPE_SHA1) {
                string = "SHA-1";
            }
            if (by != FileTransferConstants.HASH_TYPE_NONE) {
                MessageDigest messageDigest = MessageDigest.getInstance(string);
                do {
                    byte[] byArray2;
                    if ((byArray2 = iFile.read(512)) == null) continue;
                    messageDigest.update(byArray2);
                } while (iFile.getOffset() < iFile.getSize());
                byArray = messageDigest.digest();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("WARNING: Exception on FileTransferUtils.calculateHash: " + exception.getMessage());
        }
        return byArray;
    }

    public static String getSeperator(String string) {
        if (FileTransferUtils.isWindowsPath(string)) {
            return WIN_SEPERATOR;
        }
        return QNX_SEPERATOR;
    }

    public static boolean isWindowsPath(String string) {
        return string.indexOf("/") == -1;
    }

    public static String getFileNameFromPath(String string) {
        if (string != null) {
            return FileTransferUtils.getFileNameFromPath(string, FileTransferUtils.getSeperator(string));
        }
        return string;
    }

    public static String getFileNameFromPath(String string, String string2) {
        int n = string.lastIndexOf(string2) + 1;
        if (n != -1) {
            string = string.substring(n);
        }
        return string;
    }

    public static String getPath(String string, String string2) {
        int n;
        if (string != null && (n = string.lastIndexOf(string2) + 1) != -1) {
            string = string.substring(0, n);
        }
        return string;
    }

    public static String getPath(String string) {
        if (string != null) {
            return FileTransferUtils.getPath(string, FileTransferUtils.getSeperator(string));
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void writeToDisk(IFile iFile, String string) throws IOException {
        boolean bl;
        iFile.open(false);
        byte[] byArray = iFile.read((int)iFile.getSize());
        iFile.close();
        File file = new File(FileTransferUtils.getPath(string));
        if (!file.exists() && (bl = file.mkdirs())) {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            try {
                if (byArray != null) {
                    ((OutputStream)fileOutputStream).write(byArray);
                }
            }
            catch (IOException iOException) {
            }
            finally {
                ((OutputStream)fileOutputStream).close();
            }
        }
    }

    public static String findAvailableFileName(String string) {
        File file;
        boolean bl;
        int n = 0;
        String string2 = string;
        String string3 = string;
        String string4 = "";
        int n2 = string.lastIndexOf(46);
        if (n2 != -1) {
            string3 = string.substring(0, n2);
            string4 = string.substring(n2);
        }
        boolean bl2 = bl = (file = new File(string)).exists() && file.length() > 0L;
        while (bl) {
            string2 = string3 + Integer.toString(++n) + string4;
            file = new File(string2);
            bl = file.exists() && file.length() > 0L;
        }
        return string2;
    }

    public static String findTempUniqueFileName(String string) {
        if (!string.endsWith(File.separator)) {
            string = string + File.separator;
        }
        Random random = new Random();
        String string2 = string + "fw_temp_" + random.nextInt(9999999);
        File file = new File(string2);
        while (file.exists()) {
            string2 = string + "fw_temp_" + random.nextInt(9999999);
            file = new File(string2);
        }
        return string2;
    }

    public static class IdGenerator {
        private static long lastId = 0L;

        public static synchronized long getUniqueId() {
            return ++lastId;
        }
    }

    public static class RequestIdPool {
        private final HashMap requestMap = new HashMap();
        private static final int usedId = 0;

        public int getId(byte by) {
            int n = 0;
            while (this.isIdInUse(++n)) {
            }
            this.requestMap.put(new Integer(n), new Byte(by));
            return n;
        }

        public byte getOperation(int n) {
            byte by = -1;
            if (this.isIdInUse(n)) {
                by = (Byte)this.requestMap.get(new Integer(n));
            }
            return by;
        }

        public boolean isIdInUse(int n) {
            return this.requestMap.containsKey(new Integer(n));
        }

        public void releaseId(int n) {
            if (this.requestMap.containsKey(new Integer(n))) {
                this.requestMap.remove(new Integer(n));
            }
        }
    }
}

