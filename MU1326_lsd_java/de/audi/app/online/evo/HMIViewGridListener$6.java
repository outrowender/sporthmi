/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMIViewGridListener$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$startIndex;
    private final /* synthetic */ int val$listLength;
    private final /* synthetic */ String val$overlapFirstId;
    private final /* synthetic */ String val$overlapLastId;
    private final /* synthetic */ String val$direction;
    private final /* synthetic */ int val$overlapLength;
    private final /* synthetic */ int val$overlapFirstIndex;
    private final /* synthetic */ int val$overlapLastIndex;
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$6(HMIViewGridListener hMIViewGridListener, String string, int n, int n2, String string2, String string3, String string4, int n3, int n4, int n5) {
        this.this$0 = hMIViewGridListener;
        this.val$startIndex = n;
        this.val$listLength = n2;
        this.val$overlapFirstId = string2;
        this.val$overlapLastId = string3;
        this.val$direction = string4;
        this.val$overlapLength = n3;
        this.val$overlapFirstIndex = n4;
        this.val$overlapLastIndex = n5;
        super(string);
    }

    @Override
    public void run() {
        HMIViewGridListener.access$1700(this.this$0).log(1078071040, "HMIViewGridListener#requestItems: startIndex=%1, listLength=%2,", (long)this.val$startIndex, (long)this.val$listLength);
        HMIViewGridListener.access$1800(this.this$0).log(1078071040, "HMIViewGridListener#requestItems: (continued): firstId=%1, lastId=%2", (Object)this.val$overlapFirstId, (Object)this.val$overlapLastId);
        RemoteHMIAction remoteHMIAction = this.this$0.getAction(547788800);
        HMIProperties hMIProperties = remoteHMIAction.getParameters();
        hMIProperties.putInt("infiniteListStart", this.val$startIndex);
        hMIProperties.putInt("infiniteListLength", this.val$listLength);
        hMIProperties.putString("infiniteListDirection", this.val$direction);
        hMIProperties.putInt("infiniteListOverlapLength", this.val$overlapLength);
        hMIProperties.putString("infiniteListOverlapFirstId", this.val$overlapFirstId);
        hMIProperties.putString("infiniteListOverlapLastId", this.val$overlapLastId);
        hMIProperties.putInt("infiniteListOverlapFirstIndex", this.val$overlapFirstIndex);
        hMIProperties.putInt("infiniteListOverlapLastIndex", this.val$overlapLastIndex);
        HMIViewGridListener.access$1900(this.this$0, remoteHMIAction);
    }
}

