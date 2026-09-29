/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerProxyManager$1;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.ILogoDatabase;

class TunerProxyManager$RsdbStatusListener
implements IRadioDatabaseListener {
    private final /* synthetic */ TunerProxyManager this$0;

    private TunerProxyManager$RsdbStatusListener(TunerProxyManager tunerProxyManager) {
        this.this$0 = tunerProxyManager;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
        TunerProxyManager.access$402(this.this$0, iLogoDatabase);
    }

    /* synthetic */ TunerProxyManager$RsdbStatusListener(TunerProxyManager tunerProxyManager, TunerProxyManager$1 tunerProxyManager$1) {
        this(tunerProxyManager);
    }
}

