/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;
import de.audi.tuner.app.epg.dab.DABEpgHandler$EpgDetailRow;

class DABEpgHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$ButtonListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        int n4 = n == -142081792 ? DABEpgHandler.access$2100(this.this$0) - 1 : DABEpgHandler.access$2100(this.this$0) + 1;
        DABEpgHandler$EpgDetailRow dABEpgHandler$EpgDetailRow = (DABEpgHandler$EpgDetailRow)DABEpgHandler.access$1100(this.this$0).getBaseListModel(-1266155264).getRow(n4);
        if (dABEpgHandler$EpgDetailRow != null) {
            DABEpgHandler.access$1300(this.this$0, n4);
            DABEpgHandler.access$1400(this.this$0, dABEpgHandler$EpgDetailRow.getDetails());
        }
    }

    /* synthetic */ DABEpgHandler$ButtonListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

