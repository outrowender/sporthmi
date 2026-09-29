/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$7
implements Runnable {
    private final /* synthetic */ long val$uniqueListRowID;
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$7(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, long l) {
        this.this$0 = intelliDestGuiSearchHandler;
        this.val$uniqueListRowID = l;
    }

    @Override
    public void run() {
        IntelliDestGuiSearchHandler.access$900(this.this$0).log(-2137614336, "%1#focusPreviewMapOnSearchResult NAV_DEST_FAVORITES_BASE_LIST", (Object)"IntelliDestGuiSearchHandler");
        NavLocation navLocation = IntelliDestGuiSearchHandler.access$700(this.this$0).getFavoriteNavLocationByUniqueId(this.val$uniqueListRowID);
        this.this$0.focusPreviewMapOnNavLocation(navLocation, true);
    }
}

