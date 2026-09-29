/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.search.TrufflesTaskManager;
import de.audi.tghu.navi.app.search.TrufflesTaskManager$1;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

class TrufflesTaskManager$FocusPreviewMapTask
implements Runnable {
    private final EvoListRow row;
    private final /* synthetic */ TrufflesTaskManager this$0;

    private TrufflesTaskManager$FocusPreviewMapTask(TrufflesTaskManager trufflesTaskManager, EvoListRow evoListRow) {
        this.this$0 = trufflesTaskManager;
        this.row = evoListRow;
    }

    @Override
    public void run() {
        NavLocation navLocation = null;
        if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getNodeType() == 1) {
            TrufflesTaskManager.access$700(this.this$0).hidePreviewMap();
        } else if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getSearchResult().entryType == 2) {
            navLocation = TrufflesTaskManager.access$700(this.this$0).extractNavLocationFromRow(this.row);
            if (navLocation != null && navLocation.isPositionValid()) {
                TrufflesTaskManager.access$700(this.this$0).focusPreviewMapOnPOIs(new NavLocation[]{navLocation});
            } else {
                TrufflesTaskManager.access$200(this.this$0).log(-1601830656, "FocusPreviewMapTask#itemFocused # hidePreviewMap due to location: %1", (Object)navLocation);
                TrufflesTaskManager.access$700(this.this$0).hidePreviewMap();
            }
        } else if (this.row instanceof SearchResultListRow && (((SearchResultListRow)this.row).getSearchResult().entryType == 16 || ((SearchResultListRow)this.row).getSearchResult().entryType == 64)) {
            navLocation = TrufflesTaskManager.access$700(this.this$0).extractNavLocationFromRow(this.row);
            if (navLocation != null && navLocation.isPositionValid()) {
                TrufflesTaskManager.access$700(this.this$0).focusPreviewMapOnCity(navLocation);
            } else {
                TrufflesTaskManager.access$200(this.this$0).log(-1601830656, "FocusPreviewMapTask#itemFocused # hidePreviewMap due to location: %1", (Object)navLocation);
                TrufflesTaskManager.access$700(this.this$0).hidePreviewMap();
            }
        } else if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getSearchResult().source == 4) {
            SearchResult searchResult = ((SearchResultListRow)this.row).getSearchResult();
            navLocation = TrufflesTaskManager.access$700(this.this$0).getNavLocationFromTrufflesCoord(searchResult.position.lon, searchResult.position.lat);
            TrufflesTaskManager.access$700(this.this$0).focusPreviewMapOnNavLocation(navLocation, false);
        } else {
            navLocation = TrufflesTaskManager.access$700(this.this$0).extractNavLocationFromRow(this.row);
            if (navLocation != null && navLocation.isPositionValid()) {
                if (this.row instanceof SearchResultListRow && ((SearchResultListRow)this.row).getSearchResult().source == 5) {
                    TrufflesTaskManager.access$700(this.this$0).focusPreviewMapOnNavLocation(navLocation, true);
                } else {
                    TrufflesTaskManager.access$700(this.this$0).focusPreviewMapOnNavLocation(navLocation, false);
                }
            } else {
                TrufflesTaskManager.access$200(this.this$0).log(-2137614336, "FocusPreviewMapTask#itemFocused # hidePreviewMap due to location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                TrufflesTaskManager.access$700(this.this$0).hidePreviewMap();
            }
        }
        TrufflesTaskManager.access$700(this.this$0).handleIfPoiIsCallable(navLocation, this.row);
    }

    /* synthetic */ TrufflesTaskManager$FocusPreviewMapTask(TrufflesTaskManager trufflesTaskManager, EvoListRow evoListRow, TrufflesTaskManager$1 trufflesTaskManager$1) {
        this(trufflesTaskManager, evoListRow);
    }
}

