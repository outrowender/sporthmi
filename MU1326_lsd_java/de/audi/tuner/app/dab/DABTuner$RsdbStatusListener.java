/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DABTuner$1;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.ILogoDatabase;

class DABTuner$RsdbStatusListener
implements IRadioDatabaseListener {
    private final /* synthetic */ DABTuner this$0;

    private DABTuner$RsdbStatusListener(DABTuner dABTuner) {
        this.this$0 = dABTuner;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
        DABTuner.access$1500(this.this$0).setDatabase(iLogoDatabase);
        this.this$0.reNotification(5);
        this.this$0.reNotification(6);
        this.this$0.reNotification(7);
        this.this$0.reNotification(1);
        this.this$0.reNotification(2);
        this.this$0.reNotification(3);
    }

    /* synthetic */ DABTuner$RsdbStatusListener(DABTuner dABTuner, DABTuner$1 dABTuner$1) {
        this(dABTuner);
    }
}

