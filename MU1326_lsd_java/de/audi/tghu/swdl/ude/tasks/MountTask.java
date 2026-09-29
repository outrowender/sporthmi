/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude.tasks;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.ude.IEApplication;
import java.io.File;

public class MountTask
implements Runnable {
    private final IEApplication app;
    private final LogChannel lc;

    public MountTask(IEApplication iEApplication) {
        this.app = iEApplication;
        this.lc = iEApplication.getLogChannel();
    }

    @Override
    public void run() {
        File file = this.app.getMedium();
        if (file == null) {
            this.lc.log(10000, "[MountTask] No medium found!");
            this.app.mountFinished(false);
            return;
        }
        if (!file.isDirectory()) {
            this.lc.log(10000, "[MountTask] '%1' isn't a directory!", (Object)file);
            this.app.mountFinished(false);
            return;
        }
        String string = new StringBuffer().append("mount -uw ").append(file).toString();
        this.lc.log(-2137614336, "[MountTask] Exec '%1'", (Object)string);
        try {
            Runtime.getRuntime().exec(string);
            Thread.sleep(0);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[MountTask] Mounting '%1' writable failed!", (Object)file, (Throwable)exception);
            this.app.mountFinished(false);
            return;
        }
        this.app.mountFinished(true);
    }
}

