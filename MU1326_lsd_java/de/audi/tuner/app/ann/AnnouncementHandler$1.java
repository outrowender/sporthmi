/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.ann.AnnouncementHandler;

class AnnouncementHandler$1
extends DefaultChoiceListener {
    private final /* synthetic */ AnnouncementHandler this$0;

    AnnouncementHandler$1(AnnouncementHandler announcementHandler) {
        this.this$0 = announcementHandler;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AnnouncementHandler.access$400(this.this$0).setValue(n2);
        AnnouncementHandler.access$500(this.this$0).storeSupressTAPopup(TunerModels.checkboxConstantToBoolean(n2));
    }
}

