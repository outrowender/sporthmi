/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AMFMTuner$1;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.ILogoDatabase;

class AMFMTuner$RsdbStatusListener
implements IRadioDatabaseListener {
    private final /* synthetic */ AMFMTuner this$0;

    private AMFMTuner$RsdbStatusListener(AMFMTuner aMFMTuner) {
        this.this$0 = aMFMTuner;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
        AMFMTuner.access$1300(this.this$0).setDatabase(iLogoDatabase);
        this.this$0.reNotification(2);
        this.this$0.reNotification(1);
        this.this$0.reNotification(20);
    }

    /* synthetic */ AMFMTuner$RsdbStatusListener(AMFMTuner aMFMTuner, AMFMTuner$1 aMFMTuner$1) {
        this(aMFMTuner);
    }
}

