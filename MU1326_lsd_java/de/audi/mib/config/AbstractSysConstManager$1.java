/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.config;

import de.audi.atip.sysapp.carcoding.SperrFlags;
import de.audi.mib.config.AbstractSysConstManager;

class AbstractSysConstManager$1
implements Runnable {
    private final /* synthetic */ AbstractSysConstManager this$0;

    AbstractSysConstManager$1(AbstractSysConstManager abstractSysConstManager) {
        this.this$0 = abstractSysConstManager;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(0);
            SperrFlags sperrFlags = this.this$0.getSperrFlags();
            this.this$0.setSysConstBool(5559, sperrFlags.getNavSperrFlag(0));
            this.this$0.setSysConstBool(5560, sperrFlags.getMediaSperrFlag(0));
            this.this$0.fw.getStartupMgr().logStartupEvent("SperrFlags loading done");
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            this.this$0.lc.log(10000, "Speer flags were not loaded because a InterruptedException");
        }
    }
}

