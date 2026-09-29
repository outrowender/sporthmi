/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDSIUpManager;
import de.audi.tuner.app.rsdb.IRSDBResult;

class DABDSIUpManager$RsdbResultListener
implements IRSDBResult {
    private final int type;
    private final /* synthetic */ DABDSIUpManager this$0;

    public DABDSIUpManager$RsdbResultListener(DABDSIUpManager dABDSIUpManager, int n) {
        this.this$0 = dABDSIUpManager;
        this.type = n;
    }

    @Override
    public void resultAvailable() {
        DABDSIUpManager.access$900(this.this$0);
        if (this.type == 2) {
            DABDSIUpManager.access$1300(this.this$0).start();
        }
    }
}

