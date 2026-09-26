/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;
import de.audi.tuner.app.rsdb.IRSDBResult;

class AMFMDSIUpManager$RsdbResultListener
implements IRSDBResult {
    private final int type;
    private final /* synthetic */ AMFMDSIUpManager this$0;

    public AMFMDSIUpManager$RsdbResultListener(AMFMDSIUpManager aMFMDSIUpManager, int n) {
        this.this$0 = aMFMDSIUpManager;
        this.type = n;
    }

    @Override
    public void resultAvailable() {
        AMFMDSIUpManager.access$1602(this.this$0, true);
        AMFMDSIUpManager.access$1200(this.this$0);
        if (this.type == 2) {
            AMFMDSIUpManager.access$1700(this.this$0).start();
        }
    }
}

