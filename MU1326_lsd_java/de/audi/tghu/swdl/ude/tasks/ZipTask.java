/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.IEClient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ZipTask
implements Runnable {
    public static final int BUFFER_SIZE = 4096;
    private final IEApp ieApp;
    private final LogChannel lc;

    public ZipTask(IEApp iEApp) {
        this.ieApp = iEApp;
        this.lc = iEApp.getLogChannel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Thread.currentThread().setName(Thread.currentThread().getName() + "ZipTask");
        this.lc.log(10000000, "[ZipTask.run]");
        ZipOutputStream zipOutputStream = null;
        boolean bl = true;
        try {
            List list = this.ieApp.getFiles();
            int n = list.size();
            if (n == 0) {
                this.lc.log(1000000, "[ZipTask.run] No files to zip found! ");
                this.ieApp.zipFinished(false);
                return;
            }
            this.lc.log(10000000, "[ZipTask.run] Found %1 files ", (long)n);
            this.log(list);
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(IEClient.FILE_ZIP)));
            zipOutputStream.setMethod(8);
            for (int i2 = 0; i2 < n; ++i2) {
                File file = (File)list.get(i2);
                String string = file.getAbsolutePath().substring(IEClient.EXCHANGE_DIR_LENGTH);
                this.addToZip(zipOutputStream, file, string);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "[ZipTask.run] failed! ", (Throwable)exception);
            bl = false;
        }
        finally {
            try {
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            }
            catch (Exception exception) {
                this.lc.log(10000, "[ZipTask.run] Closing ZipOutputStream failed!", (Throwable)exception);
            }
        }
        this.ieApp.zipFinished(bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addToZip(ZipOutputStream zipOutputStream, File file, String string) throws IOException {
        InputStream inputStream = null;
        try {
            ZipEntry zipEntry = new ZipEntry(string);
            zipOutputStream.putNextEntry(zipEntry);
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] byArray = new byte[4096];
            int n = 0;
            long l = 0L;
            while ((n = inputStream.read(byArray, 0, 4096)) != -1) {
                zipOutputStream.write(byArray, 0, n);
                l += (long)n;
            }
            this.lc.log(10000000, "[ZipTask.addToZip] bytes:%3 entry:'%2' file:'%1'", (Object)file, (Object)string, l);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[ZipTask.addToZip] entry:'%2' file:'%1'", (Object)file, (Object)string, (Object)exception);
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (Exception exception) {
                    this.lc.log(10000, "[ZipTask.addToZip] entry:'%2' file:'%1'", (Object)file, (Object)string, (Object)exception);
                }
            }
            zipOutputStream.closeEntry();
        }
    }

    private void log(List list) {
        if (this.lc.isDebug()) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                this.lc.log(10000000, "[ZipTask.run] [%2] %1", list.get(i2), (long)i2);
            }
        }
    }
}

