/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEApp;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class UnzipTask
implements Runnable {
    private final IEApp ieApp;
    private final LogChannel lc;
    private final File srcZip;
    private final File targetDir;

    public UnzipTask(IEApp iEApp, File file, File file2) {
        this.ieApp = iEApp;
        this.lc = iEApp.getLogChannel();
        this.srcZip = file;
        this.targetDir = file2;
    }

    public void run() {
        Thread.currentThread().setName(Thread.currentThread().getName() + "UnzipTask");
        this.lc.log(10000000, "[UnzipTask] src:%1 target:%2", (Object)this.srcZip, (Object)this.targetDir);
        try {
            this.unzip(this.srcZip, this.targetDir);
            this.ieApp.unzipFinished(true);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[UnzipTask] Failed!", (Throwable)exception);
            this.ieApp.unzipFinished(false);
        }
    }

    private void unzip(File file, File file2) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        Enumeration enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            this.unzip(zipFile, (ZipEntry)enumeration.nextElement(), file2);
        }
        zipFile.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void unzip(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        String string = zipEntry.getName();
        File file2 = new File(file, string);
        if (file2.exists()) {
            this.lc.log(10000000, "[UnzipTask.unzip] Delete already existing target file '%1'", (Object)file2);
            boolean bl = file2.delete();
            if (!bl) {
                this.lc.log(10000000, "[UnzipTask.unzip] Delete of target file '%1' failed!", (Object)file2);
                this.ieApp.unzipFinished(false);
                return;
            }
        } else {
            this.lc.log(10000000, "[UnzipTask.unzip] Extract '%1' --> '%2'", (Object)string, (Object)file2);
        }
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        long l = 0L;
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            byte[] byArray = new byte[4096];
            int n = 0;
            l = 0L;
            while ((n = bufferedInputStream.read(byArray, 0, 4096)) != -1) {
                bufferedOutputStream.write(byArray, 0, n);
                l += (long)n;
            }
            this.close(bufferedInputStream);
            this.close(bufferedOutputStream);
        }
        catch (Exception exception) {
            try {
                this.lc.log(10000, "[UnzipTask.unzip] '%1' failed!", (Object)file2, (Throwable)exception);
                this.close(bufferedInputStream);
                this.close(bufferedOutputStream);
            }
            catch (Throwable throwable) {
                this.close(bufferedInputStream);
                this.close(bufferedOutputStream);
                throw throwable;
            }
        }
        this.lc.log(10000000, "[UnzipTask.unzip] '%1' (%2 bytes)", (Object)file2, l);
    }

    private void close(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        catch (IOException iOException) {
            this.lc.log(10000, "[UnzipTask.close] Closing InputStream failed!", (Throwable)iOException);
        }
    }

    private void close(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        }
        catch (IOException iOException) {
            this.lc.log(10000, "[UnzipTask.close] Closing OutputStream failed!", (Throwable)iOException);
        }
    }
}

