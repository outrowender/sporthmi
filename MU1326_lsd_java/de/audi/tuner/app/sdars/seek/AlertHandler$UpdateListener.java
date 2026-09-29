/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.sdars.seek.AlertHandler$1;
import de.audi.tuner.sds.DefaultUpdateListener;

class AlertHandler$UpdateListener
extends DefaultUpdateListener {
    private int activeBand = -1;
    private final /* synthetic */ AlertHandler this$0;

    private AlertHandler$UpdateListener(AlertHandler alertHandler) {
        this.this$0 = alertHandler;
    }

    @Override
    public void updatedWaveband(int n) {
        if (this.activeBand != n) {
            this.activeBand = n;
            AlertHandler.access$700(this.this$0, AlertHandler.access$1200(this.this$0));
        }
    }

    /* synthetic */ AlertHandler$UpdateListener(AlertHandler alertHandler, AlertHandler$1 alertHandler$1) {
        this(alertHandler);
    }
}

