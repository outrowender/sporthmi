/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;

public class OnlineMediaComponent$ProcessBufferEventTask
extends AbstractRemoteHMITask {
    IOnlineMediaSession session;
    private final /* synthetic */ OnlineMediaComponent this$0;

    public OnlineMediaComponent$ProcessBufferEventTask(OnlineMediaComponent onlineMediaComponent, String string, IOnlineMediaSession iOnlineMediaSession) {
        this.this$0 = onlineMediaComponent;
        super(string);
        this.session = iOnlineMediaSession;
    }

    @Override
    public void run() {
        this.this$0.processGenericEvent("MEDIA_BUFFER_FILLED_CHANGED", this.session, null);
    }

    @Override
    public boolean isCoalescable() {
        return true;
    }

    @Override
    public Long getDelayMillis() {
        return new Long(0);
    }

    @Override
    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        if (!(remoteHMITask instanceof OnlineMediaComponent$ProcessBufferEventTask)) {
            return false;
        }
        OnlineMediaComponent.access$200(this.this$0).log(1078071040, "ProcessBufferEventTask#processBufferEvent coalesceWith: avoided processing");
        return true;
    }
}

