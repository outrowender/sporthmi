/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.RemoteHMIServiceEvo$1;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;

class RemoteHMIServiceEvo$LoadViewTask
implements RemoteHMITask {
    private String entryPointContextName;
    private final /* synthetic */ RemoteHMIServiceEvo this$0;

    private RemoteHMIServiceEvo$LoadViewTask(RemoteHMIServiceEvo remoteHMIServiceEvo) {
        this.this$0 = remoteHMIServiceEvo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEntryPointContextName(String string) {
        String string2 = string;
        synchronized (string2) {
            this.entryPointContextName = string;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        String string = this.entryPointContextName;
        synchronized (string) {
            RemoteHMIServiceEvo.access$000(this.this$0, this.entryPointContextName, true);
        }
    }

    @Override
    public boolean isCoalescable() {
        return false;
    }

    @Override
    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        return false;
    }

    @Override
    public Long getDelayMillis() {
        return new Long(0);
    }

    /* synthetic */ RemoteHMIServiceEvo$LoadViewTask(RemoteHMIServiceEvo remoteHMIServiceEvo, RemoteHMIServiceEvo$1 remoteHMIServiceEvo$1) {
        this(remoteHMIServiceEvo);
    }
}

