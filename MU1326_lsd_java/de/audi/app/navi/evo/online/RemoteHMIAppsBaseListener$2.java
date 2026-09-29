/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class RemoteHMIAppsBaseListener$2
implements TimerListener {
    private final /* synthetic */ RemoteHMIAppsBaseListener this$0;

    RemoteHMIAppsBaseListener$2(RemoteHMIAppsBaseListener remoteHMIAppsBaseListener) {
        this.this$0 = remoteHMIAppsBaseListener;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.logChannel.log(-2137614336, "RemoteHMIAppsBaseListener#createDownloadListener#Timer#fireTimer: Called");
        if (this.this$0.miniAppsModel.getStatus() == 0) {
            this.this$0.configureModelsMiniApps(3, 48);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

