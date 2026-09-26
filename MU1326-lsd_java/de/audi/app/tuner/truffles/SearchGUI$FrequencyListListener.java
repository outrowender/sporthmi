/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.SearchGUI$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import org.dsi.ifc.search.SearchResult;

class SearchGUI$FrequencyListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$FrequencyListListener(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        long l;
        RadioSearchListRow radioSearchListRow = (RadioSearchListRow)evoListRow;
        SearchResult searchResult = radioSearchListRow.getSearchResult();
        SearchGUI.access$700((SearchGUI)this.this$0).truffles.log(-2137614336, "[FrequencySearchHandler.itemSelected] row: %1, dataId: %2", (Object)evoListRow, searchResult.dataId);
        switch (radioSearchListRow.getBand()) {
            case 4: {
                l = RadioObjectIds.getAmFmId(3, radioSearchListRow.getSearchResult().getDataId(), -1, 0, false);
                break;
            }
            case 1: {
                l = RadioObjectIds.getAmFmId(1, radioSearchListRow.getSearchResult().getDataId(), -1, 0, false);
                break;
            }
            default: {
                return;
            }
        }
        SearchGUI.access$502(this.this$0, true);
        TunerObjectContainer tunerObjectContainer = new RadioObjectIds((long)l, (LogChannel)SearchGUI.access$700((SearchGUI)this.this$0).truffles).toc;
        if (tunerObjectContainer != null) {
            if (SearchGUI.access$800(this.this$0).getActiveList() == tunerObjectContainer.getBand()) {
                SearchGUI.access$800(this.this$0).getBaseListModel(n).fireEvent(n4);
            } else {
                SearchGUI.access$800(this.this$0).setActiveList(tunerObjectContainer.getBand());
            }
            TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n4);
        } else {
            SearchGUI.access$700((SearchGUI)this.this$0).truffles.log(10000, "[FrequencySearchHandler.itemSelected] item not found %1", (Object)evoListRow);
        }
    }

    /* synthetic */ SearchGUI$FrequencyListListener(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

