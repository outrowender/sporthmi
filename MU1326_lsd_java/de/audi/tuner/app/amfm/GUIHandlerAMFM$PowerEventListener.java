/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.GUIHandlerAMFM;
import de.audi.tuner.app.amfm.GUIHandlerAMFM$1;
import de.audi.tuner.ifc.IPowerEvent;

class GUIHandlerAMFM$PowerEventListener
implements IPowerEvent {
    private final /* synthetic */ GUIHandlerAMFM this$0;

    private GUIHandlerAMFM$PowerEventListener(GUIHandlerAMFM gUIHandlerAMFM) {
        this.this$0 = gUIHandlerAMFM;
    }

    @Override
    public void notifyPowerEvent(int n, int n2) {
        if (n == 2 && GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(-1987575552).getValue() == 1) {
            GUIHandlerAMFM.access$1000(this.this$0).forceStationListUpdate(false);
        }
    }

    /* synthetic */ GUIHandlerAMFM$PowerEventListener(GUIHandlerAMFM gUIHandlerAMFM, GUIHandlerAMFM$1 gUIHandlerAMFM$1) {
        this(gUIHandlerAMFM);
    }
}

