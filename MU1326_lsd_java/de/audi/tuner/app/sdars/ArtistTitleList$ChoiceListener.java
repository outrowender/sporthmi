/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.sdars.ArtistTitleList;
import de.audi.tuner.app.sdars.ArtistTitleList$1;

class ArtistTitleList$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ ArtistTitleList this$0;

    private ArtistTitleList$ChoiceListener(ArtistTitleList artistTitleList) {
        this.this$0 = artistTitleList;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n2 >= 0 && n2 < ArtistTitleList.access$1200(this.this$0).length) {
            ArtistTitleList.access$1300(this.this$0).setValue(n2);
            ArtistTitleList.access$1400(this.this$0);
        }
    }

    /* synthetic */ ArtistTitleList$ChoiceListener(ArtistTitleList artistTitleList, ArtistTitleList$1 artistTitleList$1) {
        this(artistTitleList);
    }
}

