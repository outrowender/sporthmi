/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;

class SDARSEPGHandler$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$ListListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        SDARSEPGHandler.access$1900(this.this$0, n, n2, n3, n4);
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (Utilities.isPGen1OrBentley()) {
            SDARSEPGHandler.access$1900(this.this$0, n, n2, 1, n4);
        }
    }

    /* synthetic */ SDARSEPGHandler$ListListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

