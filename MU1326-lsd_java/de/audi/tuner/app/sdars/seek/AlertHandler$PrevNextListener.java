/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.sdars.seek.AlertHandler$1;
import de.audi.tuner.ifc.IPrevNext;

class AlertHandler$PrevNextListener
implements IPrevNext {
    private final /* synthetic */ AlertHandler this$0;

    private AlertHandler$PrevNextListener(AlertHandler alertHandler) {
        this.this$0 = alertHandler;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        AlertHandler.access$1100(this.this$0, bl, 0);
    }

    /* synthetic */ AlertHandler$PrevNextListener(AlertHandler alertHandler, AlertHandler$1 alertHandler$1) {
        this(alertHandler);
    }
}

