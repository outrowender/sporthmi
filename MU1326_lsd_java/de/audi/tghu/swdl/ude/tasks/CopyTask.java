/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEApp;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

public final class CopyTask
implements Runnable {
    private final IEApp ieApp;
    private final LogChannel lc;
    private final File srcFile;
    private final File targetDir;

    public CopyTask(IEApp iEApp, File file, File file2) {
        this.ieApp = iEApp;
        this.lc = iEApp.getLogChannel();
        this.srcFile = file;
        this.targetDir = file2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        File file = null;
        boolean bl = true;
        Thread.currentThread().setName(Thread.currentThread().getName() + "CopyTask");
        BufferedInputStream bufferedInputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            file = new File(this.targetDir, this.srcFile.getName());
            this.lc.log(10000000, "[CopyTask] src:%1 target:%2", (Object)this.srcFile, (Object)file);
            if (file.exists()) {
                this.lc.log(10000000, "[CopyTask] Delete already existing target file '%1' ", (Object)file);
                boolean bl2 = file.delete();
                if (!bl2) {
                    this.lc.log(10000, "[CopyTask] Delete of target file '%1' failed! ", (Object)file);
                    this.ieApp.copyFinished(false);
                    return;
                }
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(this.srcFile));
            filterOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            byte[] byArray = new byte[4096];
            int n = 0;
            while ((n = bufferedInputStream.read(byArray, 0, 4096)) != -1) {
                ((BufferedOutputStream)filterOutputStream).write(byArray, 0, n);
            }
            bl = true;
        }
        catch (Exception exception) {
            this.lc.log(10000, "[CopyTask] Failed! src:%1 target:%2", (Object)this.srcFile, (Object)file);
            this.lc.log(10000, "[CopyTask] Failed!", (Throwable)exception);
            bl = false;
        }
        finally {
            try {
                if (filterOutputStream != null) {
                    filterOutputStream.close();
                    bufferedInputStream.close();
                }
            }
            catch (Exception exception) {
                this.lc.log(10000, "[CopyTask] Can't close input or output stream!", (Throwable)exception);
            }
            this.ieApp.copyFinished(bl);
        }
    }
}

