/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEActivator;
import de.audi.tghu.swdl.ude.IEApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class CleanupTask
implements Runnable {
    private final LogChannel lc;
    private final ArrayList files = new ArrayList(20);

    public CleanupTask(IEApp iEApp) {
        this.lc = iEApp.getLogChannel();
    }

    public void add(String string) {
        this.add(new File(string));
    }

    public void add(File file) {
        this.lc.log(10000000, "[CleanupTask.add] %1", (Object)file);
        if (file.exists()) {
            this.files.add(file);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        if (IEActivator.KEEP_TMP_FILES) {
            this.lc.log(1000000, "[CleanupTask] Don't delete tmp files (-Duser.data.export.keep.tmp.files=true)");
            return;
        }
        if (this.files.isEmpty()) {
            this.lc.log(10000000, "[CleanupTask] No files added for deletion.");
            return;
        }
        Thread.currentThread().setName(Thread.currentThread().getName() + "CleanupTask");
        try {
            this.lc.log(10000000, "[CleanupTask]");
            Iterator iterator = this.files.iterator();
            while (iterator.hasNext()) {
                File file = (File)iterator.next();
                this.lc.log(10000000, "[CleanupTask] Delete %1", (Object)file);
                file.delete();
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "[CleanupTask] Failed!", (Throwable)exception);
        }
        finally {
            this.files.clear();
        }
    }
}

