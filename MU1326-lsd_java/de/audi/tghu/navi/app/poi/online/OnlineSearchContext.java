/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.poi.online.PoiOnlineSearchArea;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class OnlineSearchContext {
    private OnlinePOIResultList resultList;
    private int resultsLength = 0;
    private int indexOfCurrentFirstItem = 0;
    private PoiOnlineSearchArea searchArea;

    public OnlineSearchContext(LogChannel logChannel) {
        this.resultList = new OnlinePOIResultList(logChannel);
    }

    public int getIndexOfCurrentFirstItem() {
        return this.indexOfCurrentFirstItem;
    }

    public int getResultsLength() {
        return this.resultsLength;
    }

    public void setResultsLength(int n) {
        this.resultsLength = n;
    }

    public OnlinePOIResultList getResultList() {
        return this.resultList;
    }

    public void updateResults(int n, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n2, int n3, boolean bl, OnlinePOIResultList onlinePOIResultList) {
        this.indexOfCurrentFirstItem = n2;
        this.resultsLength = 0;
    }

    public PoiOnlineSearchArea getSearchArea() {
        return this.searchArea;
    }

    public void setSearchArea(PoiOnlineSearchArea poiOnlineSearchArea) {
        this.searchArea = poiOnlineSearchArea;
    }
}

