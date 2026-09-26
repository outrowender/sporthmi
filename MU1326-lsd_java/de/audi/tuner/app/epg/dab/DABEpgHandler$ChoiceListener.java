/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;

class DABEpgHandler$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$ChoiceListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(DABEpgHandler.access$1600(this.this$0));
        int n4 = DABEpgHandler.access$2200(this.this$0).toggleStore(tunerObjectContainer);
        DABEpgHandler.access$1100(this.this$0).getChoiceModel(-1534525184).setValue(n4);
    }

    /* synthetic */ DABEpgHandler$ChoiceListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

