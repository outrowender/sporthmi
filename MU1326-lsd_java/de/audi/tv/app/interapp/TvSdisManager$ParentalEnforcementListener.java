/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.interapp.TvSdisManager;
import de.audi.tv.app.interapp.TvSdisManager$1;

class TvSdisManager$ParentalEnforcementListener
extends DefaultButtonListener {
    private final /* synthetic */ TvSdisManager this$0;

    private TvSdisManager$ParentalEnforcementListener(TvSdisManager tvSdisManager) {
        this.this$0 = tvSdisManager;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        TvSdisManager.access$800(this.this$0).enforceTV();
    }

    /* synthetic */ TvSdisManager$ParentalEnforcementListener(TvSdisManager tvSdisManager, TvSdisManager$1 tvSdisManager$1) {
        this(tvSdisManager);
    }
}

