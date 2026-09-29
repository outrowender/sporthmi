/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.sdars.seek.AlertHandler$1;
import de.audi.tuner.app.sdars.seek.AlertRow;

class AlertHandler$AlertListModelListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ AlertHandler this$0;

    private AlertHandler$AlertListModelListener(AlertHandler alertHandler) {
        this.this$0 = alertHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AlertHandler.access$900(this.this$0, (AlertRow)evoListRow, n4);
    }

    /* synthetic */ AlertHandler$AlertListModelListener(AlertHandler alertHandler, AlertHandler$1 alertHandler$1) {
        this(alertHandler);
    }
}

