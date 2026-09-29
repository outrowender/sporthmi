/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.app.uni.UnifiedTuner$1;
import de.audi.tuner.ifc.ILogoDatabase;

class UnifiedTuner$RsdbStatusListener
implements IRadioDatabaseListener {
    private final /* synthetic */ UnifiedTuner this$0;

    private UnifiedTuner$RsdbStatusListener(UnifiedTuner unifiedTuner) {
        this.this$0 = unifiedTuner;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
        UnifiedTuner.access$1200(this.this$0).setDatabase(iLogoDatabase);
        this.this$0.reNotification(4);
        this.this$0.reNotification(3);
    }

    /* synthetic */ UnifiedTuner$RsdbStatusListener(UnifiedTuner unifiedTuner, UnifiedTuner$1 unifiedTuner$1) {
        this(unifiedTuner);
    }
}

