/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupManager$1;
import java.io.File;

class StartupManager$StartupFinished
implements Runnable {
    private final /* synthetic */ StartupManager this$0;

    private StartupManager$StartupFinished(StartupManager startupManager) {
        this.this$0 = startupManager;
    }

    public final String toString() {
        return "StartupFinished";
    }

    @Override
    public final void run() {
        System.out.println("######################################");
        System.out.println(new StringBuffer().append("# HMI STARTUP FINISHED [").append(this.this$0.getFramework().getMonotonicTime() - StartupManager.access$1100(this.this$0)).append("ms]").toString());
        System.out.println("######################################");
        this.this$0.logStartupEvent(StartupManager.access$300(this.this$0), 1078071040, "StartupFinished#run() - HMI STARTUP FINISHED");
        StartupManager.access$1202(this.this$0, true);
        if (StartupManager.access$1300(this.this$0) != null) {
            this.this$0.logStartupEvent(StartupManager.access$300(this.this$0), 1078071040, "StartupFinished#run() - Remove StartupFilter from event queue");
            StartupManager.access$1300(this.this$0).getEventDispatcherAdmin().removeEventFilter(StartupManager.access$1400(this.this$0));
        }
        if (StartupManager.access$1500(this.this$0) != null) {
            StartupManager.access$1500(this.this$0).cancel();
        }
        if (StartupManager.access$100(this.this$0).isTarget()) {
            try {
                File file = new File("/tmp/MMX-startup-finished");
                file.delete();
                file.createNewFile();
            }
            catch (Exception exception) {
                this.this$0.logStartupEvent(StartupManager.access$300(this.this$0), 10000, "StartupFinished#run() - Exception on writing /tmp/MMX-startup-finished", exception);
            }
        }
        StartupManager.access$100(this.this$0).getMsgDistrib().sendMessage(3);
        if (StartupManager.access$1600(this.this$0) != null && StartupManager.access$1300(this.this$0) != null) {
            this.this$0.logStartupEvent(StartupManager.access$300(this.this$0), -2137614336, new StringBuffer().append("StartupFinished#run() - Forward ").append(StartupManager.access$1600(this.this$0)).toString());
            StartupManager.access$1700(this.this$0).log(-2137614336, "StartupManager: forward %1", (Object)StartupManager.access$1600(this.this$0));
            StartupManager.access$1300(this.this$0).getEventDispatcher().postEvent(StartupManager.access$1600(this.this$0));
            StartupManager.access$1602(this.this$0, null);
        }
    }

    /* synthetic */ StartupManager$StartupFinished(StartupManager startupManager, StartupManager$1 startupManager$1) {
        this(startupManager);
    }
}

