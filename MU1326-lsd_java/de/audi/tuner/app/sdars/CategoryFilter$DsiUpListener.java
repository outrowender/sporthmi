/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.CategoryFilter;
import de.audi.tuner.app.sdars.CategoryFilter$1;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;

class CategoryFilter$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ CategoryFilter this$0;

    private CategoryFilter$DsiUpListener(CategoryFilter categoryFilter) {
        this.this$0 = categoryFilter;
    }

    @Override
    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        CategoryFilter.access$302(this.this$0, stationInfoExtArray);
        CategoryFilter.access$400(this.this$0);
    }

    @Override
    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        CategoryFilter.access$502(this.this$0, categoryInfoExtArray);
        CategoryFilter.access$400(this.this$0);
    }

    /* synthetic */ CategoryFilter$DsiUpListener(CategoryFilter categoryFilter, CategoryFilter$1 categoryFilter$1) {
        this(categoryFilter);
    }
}

