/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public interface IOnlineSearchForm {
    public static final int LIST_HISTORY;
    public static final int LIST_RESULTS;

    default public void clearResultList() {
    }

    default public void setSearchTextLabel(String string) {
    }

    default public void resetSpellingSuggestion() {
    }

    default public void resetHistoryList() {
    }

    default public void indicateError(int n, String string) {
    }

    default public void setResultsComplete() {
    }

    default public void updateProvider(int n, String string, String string2, String string3, String string4, String string5, String string6, String string7) {
    }

    default public int updateResults(int n, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n2, int n3, boolean bl, OnlinePOIResultList onlinePOIResultList) {
    }

    default public void refreshSearchHistory() {
    }

    default public int getStopOverType() {
    }

    default public void updateSelectedOnlineDetails(OnlinePOIResultList onlinePOIResultList, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation, int n) {
    }

    default public void setSpellingsuggestion(String string) {
    }

    default public void setSearchLocation(int n, NavLocation navLocation) {
    }

    default public void onlineSearchExit() {
    }

    default public void enterOnlineSearchForm() {
    }

    default public void showList(int n) {
    }

    default public void startSearchWithSpellingSuggestion() {
    }

    default public void onlinePOIMainEnter() {
    }

    default public void onlinePOIMainExit() {
    }

    default public NavLocation getCurrentlySelectedLocation() {
    }

    default public void setRequestSpellingSuggestion(boolean bl) {
    }

    default public void addToSearchHistorySDS(String string) {
    }

    default public void resetAfterAbort() {
    }

    default public void setResultLengthValue(int n, int n2, int n3) {
    }
}

