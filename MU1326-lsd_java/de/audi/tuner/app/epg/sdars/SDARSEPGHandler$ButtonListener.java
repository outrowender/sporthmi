/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;

class SDARSEPGHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$ButtonListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        SDARSEPGHandler.access$1200(this.this$0, n3);
    }

    /* synthetic */ SDARSEPGHandler$ButtonListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

