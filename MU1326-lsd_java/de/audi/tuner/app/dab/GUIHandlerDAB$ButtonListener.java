/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.dab.GUIHandlerDAB;
import de.audi.tuner.app.dab.GUIHandlerDAB$1;

class GUIHandlerDAB$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ GUIHandlerDAB this$0;

    private GUIHandlerDAB$ButtonListener(GUIHandlerDAB gUIHandlerDAB) {
        this.this$0 = gUIHandlerDAB;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100506: {
                GUIHandlerDAB.access$700(this.this$0).seekStation(1, n3);
                break;
            }
            case 100505: {
                GUIHandlerDAB.access$700(this.this$0).seekStation(2, n3);
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        switch (n) {
            case 100506: {
                GUIHandlerDAB.access$700(this.this$0).seekStation(6, n3);
                break;
            }
            case 100505: {
                GUIHandlerDAB.access$700(this.this$0).seekStation(7, n3);
                break;
            }
        }
    }

    /* synthetic */ GUIHandlerDAB$ButtonListener(GUIHandlerDAB gUIHandlerDAB, GUIHandlerDAB$1 gUIHandlerDAB$1) {
        this(gUIHandlerDAB);
    }
}

