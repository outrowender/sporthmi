/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$BundleJob;
import de.esolutions.fw.util.commons.Buffer;

public class StartupManager$BundlesJob
implements Runnable {
    final String prefix;
    final StartupManager$BundleJob[] jobs;
    private final /* synthetic */ StartupManager this$0;

    StartupManager$BundlesJob(StartupManager startupManager, String string, int n) {
        this.this$0 = startupManager;
        this.prefix = string;
        this.jobs = new StartupManager$BundleJob[n];
    }

    public String toString() {
        Buffer buffer = new Buffer().append(this.prefix);
        for (int i2 = 0; i2 < this.jobs.length; ++i2) {
            if (i2 > 0) {
                buffer.append(", ");
            }
            buffer.append(this.jobs[i2].getBundleName());
        }
        return buffer.toString();
    }

    @Override
    public void run() {
        for (int i2 = 0; i2 < this.jobs.length; ++i2) {
            this.jobs[i2].run();
        }
    }
}

