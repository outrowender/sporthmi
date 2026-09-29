/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.TunerProxyManager$DummyDABTuner;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.ILogoDatabase;

class TunerProxyManager$DummyDABTuner$2
implements IRadioDatabaseListener {
    private final /* synthetic */ TunerProxyManager$DummyDABTuner this$0;

    TunerProxyManager$DummyDABTuner$2(TunerProxyManager$DummyDABTuner tunerProxyManager$DummyDABTuner) {
        this.this$0 = tunerProxyManager$DummyDABTuner;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
    }
}

