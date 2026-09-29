/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController;

class PLAController$2
implements Runnable {
    private final /* synthetic */ IPLAStatus val$status;
    private final /* synthetic */ int val$mode;
    private final /* synthetic */ PLAController this$0;

    PLAController$2(PLAController pLAController, IPLAStatus iPLAStatus, int n) {
        this.this$0 = pLAController;
        this.val$status = iPLAStatus;
        this.val$mode = n;
    }

    @Override
    public void run() {
        PLAController.access$100(this.this$0, this.val$status);
        PLAController.access$202(this.this$0, this.val$mode);
        PLAController.access$302(this.this$0, this.val$status);
        PLAController.access$400(this.this$0).setDataChanged();
        PLAController.access$400(this.this$0).triggerRepaint();
    }
}

