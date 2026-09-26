/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.rsdb.IRSDBResult;
import de.audi.tuner.app.uni.UniDsiUpManager;

class UniDsiUpManager$RsdbResultListener
implements IRSDBResult {
    private final int type;
    private final /* synthetic */ UniDsiUpManager this$0;

    public UniDsiUpManager$RsdbResultListener(UniDsiUpManager uniDsiUpManager, int n) {
        this.this$0 = uniDsiUpManager;
        this.type = n;
    }

    @Override
    public void resultAvailable() {
        UniDsiUpManager.access$400(this.this$0);
        if (this.type == 2) {
            UniDsiUpManager.access$900(this.this$0).start();
        }
    }
}

