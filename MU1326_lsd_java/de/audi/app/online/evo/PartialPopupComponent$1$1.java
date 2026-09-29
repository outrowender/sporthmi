/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.PartialPopupComponent;
import de.audi.app.online.evo.PartialPopupComponent$1;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;

class PartialPopupComponent$1$1
implements RemoteHMITask {
    private final /* synthetic */ Object val$payload;
    private final /* synthetic */ PartialPopupComponent$1 this$1;

    PartialPopupComponent$1$1(PartialPopupComponent$1 partialPopupComponent$1, Object object) {
        this.this$1 = partialPopupComponent$1;
        this.val$payload = object;
    }

    @Override
    public void run() {
        PartialPopupComponent.access$100(PartialPopupComponent$1.access$000(this.this$1), (HMIProperties)this.val$payload);
        PartialPopupComponent.access$200(PartialPopupComponent$1.access$000(this.this$1)).flushModelGroup();
    }

    @Override
    public boolean isCoalescable() {
        return false;
    }

    @Override
    public Long getDelayMillis() {
        return new Long(0);
    }

    @Override
    public boolean coalesceWith(RemoteHMITask remoteHMITask) {
        return false;
    }
}

