/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestHMIListener;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$1;
import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

class IntelliDestHMIListener$MyOptionModelListener
extends DefaultOptionListener {
    private final /* synthetic */ IntelliDestHMIListener this$0;

    private IntelliDestHMIListener$MyOptionModelListener(IntelliDestHMIListener intelliDestHMIListener) {
        this.this$0 = intelliDestHMIListener;
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        Object object;
        IntelliDestHMIListener.access$300(this.this$0).log(1078071040, new StringBuffer().append(IntelliDestHMIListener.access$200(this.this$0)).append("#OptionModelListener.keyPressed modelID = %1, targetModelID=%2, targetRow = %3").toString(), (long)n, (long)n2, (long)n3);
        EvoListRow evoListRow = IntelliDestHMIListener.access$400(this.this$0).getRow(n3);
        NavLocation navLocation = null;
        if (n2 == IntelliDestHMIListener.access$400(this.this$0).getID()) {
            navLocation = IntelliDestHMIListener.access$500(this.this$0).extractNavLocationFromRow(evoListRow);
        } else if (n2 == 1595803136) {
            navLocation = IntelliDestHMIListener.access$600(this.this$0).getNavLocation(n3);
        } else if (n2 == -1239480832) {
            evoListRow = IntelliDestHMIListener.access$700(this.this$0).getBaseListModel(220202496).getRow(n3);
            navLocation = IntelliDestHMIListener.access$500(this.this$0).extractNavLocationFromRow(evoListRow);
        }
        long l = -1L;
        if (evoListRow instanceof SearchResultListRow && ((SearchResult)(object = ((SearchResultListRow)evoListRow).getSearchResult())).getSource() == 5) {
            l = ((SearchResult)object).getDataId();
        }
        switch (n) {
            case 401380: {
                IntelliDestHMIListener.access$500(this.this$0).parkingNearDestination(navLocation);
                break;
            }
            case 401990: {
                IntelliDestHMIListener.access$500(this.this$0).poiNearDestination(navLocation);
                break;
            }
            case 401013: {
                IntelliDestHMIListener.access$500(this.this$0).saveAsFavorite(evoListRow, navLocation, n2);
                break;
            }
            case 401043: {
                IntelliDestHMIListener.access$800(this.this$0).showPoiDetailScreen(navLocation);
                break;
            }
            case 401478: {
                IntelliDestHMIListener.access$500(this.this$0).openAddressInputForm(navLocation);
                break;
            }
            case 401012: {
                IntelliDestHMIListener.access$500(this.this$0).destOptShowInMap(navLocation, l);
                break;
            }
            case 401485: {
                IntelliDestHMIListener.access$500(this.this$0).startAddLocationToContact(navLocation);
                break;
            }
            case 401029: {
                object = (NaviSearchResultListRow)IntelliDestHMIListener.access$400(this.this$0).getRow(n3);
                IntelliDestHMIListener.access$900(this.this$0).getMainSearch().removeFromHistory(((SearchResultListRow)object).getSearchResult().getDataId());
                IntelliDestHMIListener.access$400(this.this$0).remove((EvoListRow)object);
                break;
            }
            case 401622: {
                IntelliDestHMIListener.access$500(this.this$0).optionShowContactDetailsForAdbResult(n3);
                break;
            }
            case 401005: {
                PoiUtil.callPoi(navLocation, IntelliDestHMIListener.access$700(this.this$0), IntelliDestHMIListener.access$1000(this.this$0), IntelliDestHMIListener.access$1100(this.this$0));
                break;
            }
        }
        IntelliDestHMIListener.access$700(this.this$0).getHMIService().getOptionModel(n).fireEvent(n5);
    }

    /* synthetic */ IntelliDestHMIListener$MyOptionModelListener(IntelliDestHMIListener intelliDestHMIListener, IntelliDestHMIListener$1 intelliDestHMIListener$1) {
        this(intelliDestHMIListener);
    }
}

