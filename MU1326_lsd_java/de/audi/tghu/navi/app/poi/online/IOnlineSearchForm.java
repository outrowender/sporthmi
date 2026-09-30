/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public interface IOnlineSearchForm {
    public static final int LIST_HISTORY = 0;
    public static final int LIST_RESULTS = 1;

    public void clearResultList();

    public void setSearchTextLabel(String var1);

    public void resetSpellingSuggestion();

    public void resetHistoryList();

    public void indicateError(int var1, String var2);

    public void setResultsComplete();

    public void updateProvider(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8);

    public int updateResults(int var1, PoiOnlineSearchValuelist var2, int var3, int var4, boolean var5, OnlinePOIResultList var6);

    public void refreshSearchHistory();

    public int getStopOverType();

    public void updateSelectedOnlineDetails(OnlinePOIResultList var1, PoiOnlineSearchValuelistElement var2, NavLocation var3, int var4);

    public void setSpellingsuggestion(String var1);

    public void setSearchLocation(int var1, NavLocation var2);

    public void onlineSearchExit();

    public void enterOnlineSearchForm();

    public void showList(int var1);

    public void startSearchWithSpellingSuggestion();

    public void onlinePOIMainEnter();

    public void onlinePOIMainExit();

    public NavLocation getCurrentlySelectedLocation();

    public void setRequestSpellingSuggestion(boolean var1);

    public void addToSearchHistorySDS(String var1);

    public void resetAfterAbort();

    public void setResultLengthValue(int var1, int var2, int var3);
}

