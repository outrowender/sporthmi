/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.ArtistTitleList;
import de.audi.tuner.app.sdars.ArtistTitleList$1;
import de.audi.tuner.app.sdars.CategoryFilter$ICategoryFilter;

class ArtistTitleList$CatFilterListener
implements CategoryFilter$ICategoryFilter {
    private final /* synthetic */ ArtistTitleList this$0;

    private ArtistTitleList$CatFilterListener(ArtistTitleList artistTitleList) {
        this.this$0 = artistTitleList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void categoryFilterChanged(boolean[] blArray) {
        Object object = ArtistTitleList.access$800(this.this$0);
        synchronized (object) {
            ArtistTitleList.access$1502(this.this$0, blArray);
            ArtistTitleList.access$1400(this.this$0);
        }
    }

    /* synthetic */ ArtistTitleList$CatFilterListener(ArtistTitleList artistTitleList, ArtistTitleList$1 artistTitleList$1) {
        this(artistTitleList);
    }
}

