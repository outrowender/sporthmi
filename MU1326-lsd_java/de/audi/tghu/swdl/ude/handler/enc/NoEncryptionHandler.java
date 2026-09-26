/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.handler.enc;

import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.IEClient;
import de.audi.tghu.swdl.ude.handler.enc.EncryptionHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class NoEncryptionHandler
extends EncryptionHandler {
    public NoEncryptionHandler(IEApp iEApp) {
        super(iEApp);
    }

    public void encrypt(File file, String string) {
        this.lc.log(-2137614336, "[NoEncryptionHandler.encrypt] %1", (Object)file);
        int n = this.copy(file, IEClient.FILE_ZIP_ENC);
        this.encryptFile(IEClient.FILE_ZIP_ENC.getAbsolutePath(), n);
    }

    public void decrypt(File file, String string) {
        this.lc.log(-2137614336, "[NoEncryptionHandler.decrypt] %1", (Object)file);
        int n = this.copy(file, IEClient.FILE_ZIP_DEC);
        this.decryptFile(IEClient.FILE_ZIP_DEC.getAbsolutePath(), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int copy(File file, File file2) {
        this.lc.log(-2137614336, "[NoEncryptionHandler.copy] src: %1", (Object)file);
        this.lc.log(-2137614336, "[NoEncryptionHandler.copy] target: %1 (%2 bytes)", (Object)file2);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            file2.delete();
            file2.getParentFile().mkdirs();
            file2.createNewFile();
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            byte[] byArray = new byte[4096];
            int n = -1;
            while ((n = ((InputStream)fileInputStream).read(byArray)) != -1) {
                ((OutputStream)fileOutputStream).write(byArray, 0, n);
            }
            int n2 = 1;
            this.close(fileInputStream);
            this.close(fileOutputStream);
            return n2;
        }
        catch (Exception exception) {
            try {
                this.lc.log(10000, "[NoEncryptionHandler.copy] src: %1 (%2 bytes)", (Object)file, file.length());
                this.lc.log(10000, "[NoEncryptionHandler.copy] target: %1 (%2 bytes)", (Object)file2, file2.length());
                this.lc.log(10000, "[NoEncryptionHandler.copy]", (Throwable)exception);
                int n = 3;
                this.close(fileInputStream);
                this.close(fileOutputStream);
                return n;
            }
            catch (Throwable throwable) {
                this.close(fileInputStream);
                this.close(fileOutputStream);
                throw throwable;
            }
        }
    }

    private void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (Exception exception) {
                this.lc.log(10000, "[NoEncryptionHandler.close] Closing input stream failed!", (Throwable)exception);
            }
        }
    }

    private void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            }
            catch (Exception exception) {
                this.lc.log(10000, "[NoEncryptionHandler.close] Closing output stream failed!", (Throwable)exception);
            }
        }
    }
}

