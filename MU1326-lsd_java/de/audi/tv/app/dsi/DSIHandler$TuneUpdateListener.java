/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DSIHandler$1;
import org.dsi.ifc.tvtuner.ProgramInfo;

class DSIHandler$TuneUpdateListener
extends TVEventDefaultListener {
    private final /* synthetic */ DSIHandler this$0;

    private DSIHandler$TuneUpdateListener(DSIHandler dSIHandler) {
        this.this$0 = dSIHandler;
    }

    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
        DSIHandler.access$802(this.this$0, programInfo.serviceInfo);
    }

    /* synthetic */ DSIHandler$TuneUpdateListener(DSIHandler dSIHandler, DSIHandler$1 dSIHandler$1) {
        this(dSIHandler);
    }
}

