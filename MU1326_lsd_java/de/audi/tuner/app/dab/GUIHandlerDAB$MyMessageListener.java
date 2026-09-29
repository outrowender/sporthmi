/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.GUIHandlerDAB;
import de.audi.tuner.app.dab.GUIHandlerDAB$1;
import de.audi.tuner.ifc.listener.MessageListener;

class GUIHandlerDAB$MyMessageListener
extends MessageListener {
    private final /* synthetic */ GUIHandlerDAB this$0;

    private GUIHandlerDAB$MyMessageListener(GUIHandlerDAB gUIHandlerDAB) {
        this.this$0 = gUIHandlerDAB;
    }

    @Override
    public void unitsChanged() {
        GUIHandlerDAB.access$700(this.this$0).setNotification(new int[]{29});
    }

    /* synthetic */ GUIHandlerDAB$MyMessageListener(GUIHandlerDAB gUIHandlerDAB, GUIHandlerDAB$1 gUIHandlerDAB$1) {
        this(gUIHandlerDAB);
    }
}

