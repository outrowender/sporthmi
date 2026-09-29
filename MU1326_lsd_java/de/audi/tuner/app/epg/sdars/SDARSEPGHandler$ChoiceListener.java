/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;

class SDARSEPGHandler$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$ChoiceListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(SDARSEPGHandler.access$1300(this.this$0));
        int n4 = SDARSEPGHandler.access$1400(this.this$0).toggleStore(tunerObjectContainer);
        SDARSEPGHandler.access$1500(this.this$0).getChoiceModel(344588544).setValue(n4);
    }

    /* synthetic */ SDARSEPGHandler$ChoiceListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

