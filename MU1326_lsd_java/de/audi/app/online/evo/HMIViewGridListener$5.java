/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class HMIViewGridListener$5
extends AbstractRemoteHMITask {
    private final /* synthetic */ HMIViewGridListener this$0;

    HMIViewGridListener$5(HMIViewGridListener hMIViewGridListener, String string) {
        this.this$0 = hMIViewGridListener;
        super(string);
    }

    @Override
    public void run() {
        Object object;
        if (!HMIViewGridListener.access$300(this.this$0).getGridList().isEventListening()) {
            object = "HMIViewGridListener#keyPressedVirtualButton: Current grid list went out of scope, new grid list was not yet rendered, so going back may lead to wrong screen.";
            HMIViewGridListener.access$1200(this.this$0).log(-1601830656, (String)object);
        }
        HMIViewGridListener.access$1300(this.this$0).log(-2137614336, "HMIViewGridListener#keyPressedVirtualButton: going back to historical screen");
        object = this.this$0.getOldCursor().getFocus();
        RemoteHMIAction remoteHMIAction = HMIViewGridListener.access$1500(this.this$0, 104, object.getIndex(), object.getId(), HMIViewGridListener.access$1400(this.this$0));
        HMIViewGridListener.access$1600(this.this$0, remoteHMIAction);
    }
}

