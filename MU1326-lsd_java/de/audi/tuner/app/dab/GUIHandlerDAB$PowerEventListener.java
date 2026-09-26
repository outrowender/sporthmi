/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.GUIHandlerDAB;
import de.audi.tuner.app.dab.GUIHandlerDAB$1;
import de.audi.tuner.ifc.IPowerEvent;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

class GUIHandlerDAB$PowerEventListener
implements IPowerEvent {
    private final /* synthetic */ GUIHandlerDAB this$0;

    private GUIHandlerDAB$PowerEventListener(GUIHandlerDAB gUIHandlerDAB) {
        this.this$0 = gUIHandlerDAB;
    }

    @Override
    public void notifyPowerEvent(int n, int n2) {
        if (n == 2) {
            SimpleIntIntMap simpleIntIntMap = GUIHandlerDAB.access$600(this.this$0).getFolderStates();
            GUIHandlerDAB.access$1200(this.this$0).storeDABListLM(simpleIntIntMap);
            if (GUIHandlerDAB.access$700(this.this$0).isSeekActive()) {
                GUIHandlerDAB.access$700(this.this$0).abortSeek();
            }
            if (GUIHandlerDAB.access$900(this.this$0).getChoiceModel(-1970798336).getValue() == 1) {
                GUIHandlerDAB.access$700(this.this$0).forceStationListUpdate(false);
            }
        }
    }

    /* synthetic */ GUIHandlerDAB$PowerEventListener(GUIHandlerDAB gUIHandlerDAB, GUIHandlerDAB$1 gUIHandlerDAB$1) {
        this(gUIHandlerDAB);
    }
}

