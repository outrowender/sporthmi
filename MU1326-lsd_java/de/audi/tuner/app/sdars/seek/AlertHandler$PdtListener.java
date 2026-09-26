/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.SdarsRadioText;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.sdars.seek.AlertHandler$1;
import de.audi.tuner.ifc.listener.IPdtListener;

class AlertHandler$PdtListener
implements IPdtListener {
    private final /* synthetic */ AlertHandler this$0;

    private AlertHandler$PdtListener(AlertHandler alertHandler) {
        this.this$0 = alertHandler;
    }

    @Override
    public void updatePdt(int n, SdarsRadioText sdarsRadioText) {
        AlertHandler.access$1000(this.this$0, n, sdarsRadioText);
    }

    /* synthetic */ AlertHandler$PdtListener(AlertHandler alertHandler, AlertHandler$1 alertHandler$1) {
        this(alertHandler);
    }
}

