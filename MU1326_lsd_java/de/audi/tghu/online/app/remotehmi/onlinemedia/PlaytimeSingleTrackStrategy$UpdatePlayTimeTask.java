/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeSingleTrackStrategy;

public class PlaytimeSingleTrackStrategy$UpdatePlayTimeTask
extends AbstractRemoteHMITask {
    int timePlaying;
    int timeTotal;
    private final /* synthetic */ PlaytimeSingleTrackStrategy this$0;

    public PlaytimeSingleTrackStrategy$UpdatePlayTimeTask(PlaytimeSingleTrackStrategy playtimeSingleTrackStrategy, String string, int n, int n2) {
        this.this$0 = playtimeSingleTrackStrategy;
        super(string);
        this.timePlaying = n;
        this.timeTotal = n2;
    }

    @Override
    public void run() {
        PlaytimeSingleTrackStrategy.access$000(this.this$0, this.timePlaying, this.timeTotal);
    }

    @Override
    public boolean isCoalescable() {
        return true;
    }

    @Override
    public Long getDelayMillis() {
        return new Long(0L);
    }

    @Override
    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!(remoteHMITask instanceof PlaytimeSingleTrackStrategy$UpdatePlayTimeTask)) {
            return false;
        }
        this.this$0.logChannel.log(1078071040, "UpdatePlayTimeTask#coalesceWith: avoided update of playtime: %1", (long)((PlaytimeSingleTrackStrategy$UpdatePlayTimeTask)remoteHMITask).timePlaying);
        return true;
    }
}

