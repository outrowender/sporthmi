/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.sdars;

import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler$1;
import de.audi.tuner.app.sdars.CategoryFilter$ICategoryFilter;

class SDARSEPGHandler$CatFilterListener
implements CategoryFilter$ICategoryFilter {
    private final /* synthetic */ SDARSEPGHandler this$0;

    private SDARSEPGHandler$CatFilterListener(SDARSEPGHandler sDARSEPGHandler) {
        this.this$0 = sDARSEPGHandler;
    }

    @Override
    public void categoryFilterChanged(boolean[] blArray) {
        this.this$0.catFilter = blArray;
        this.this$0.updateEPGForAllStations();
    }

    /* synthetic */ SDARSEPGHandler$CatFilterListener(SDARSEPGHandler sDARSEPGHandler, SDARSEPGHandler$1 sDARSEPGHandler$1) {
        this(sDARSEPGHandler);
    }
}

