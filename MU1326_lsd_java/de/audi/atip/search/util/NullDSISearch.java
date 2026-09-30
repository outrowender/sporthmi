/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search.util;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public class NullDSISearch
implements DSISearch {
    private final LogChannel lc;

    public NullDSISearch(LogChannel logChannel) {
        this.lc = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.lc.log(100000000, "NullDSISearch.setNotification()");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.lc.log(100000000, "NullDSISearch.setNotification()");
    }

    public void setNotification(DSIListener dSIListener) {
        this.lc.log(100000000, "NullDSISearch.setNotification()");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.lc.log(100000000, "NullDSISearch.clearNotification()");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.lc.log(100000000, "NullDSISearch.clearNotification()");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.lc.log(100000000, "NullDSISearch.clearNotification()");
    }

    public void requestSupportedCountries() {
        this.lc.log(100000000, "NullDSISearch.requestSupportedCountries()");
    }

    public void setActiveSearchCountries(int[] nArray) {
        this.lc.log(100000000, "NullDSISearch.setActiveSearchCountries(%1)", (Object)nArray);
    }

    public void search(SearchQuery searchQuery) {
        this.lc.log(100000000, "NullDSISearch.search(%1)", (Object)searchQuery);
    }

    public void addToHistory(SearchResult searchResult) {
        this.lc.log(100000000, "NullDSISearch.addToHistory(%1)", (Object)searchResult);
    }

    public void requestSuggestion(SearchQuery searchQuery) {
        this.lc.log(100000000, "NullDSISearch.requestSuggestion(%1)", (Object)searchQuery);
    }

    public void cancelQuery(int n) {
        this.lc.log(100000000, "NullDSISearch.cancelQuery(%1)", (long)n);
    }

    public void setCurrentPosition(NavLocationWgs84 navLocationWgs84) {
        this.lc.log(100000000, "NullDSISearch.setCurrentPosition(%1)", (Object)navLocationWgs84);
    }

    public void setRoutePoints(NavLocationWgs84[] navLocationWgs84Array) {
        this.lc.log(100000000, "NullDSISearch.setRoutePoints(%1)", (Object)navLocationWgs84Array);
    }

    public void setLanguage(String string) {
        this.lc.log(100000000, "NullDSISearch.setLanguage(%1)", (Object)string);
    }

    public void setActiveProfile(int n) {
        this.lc.log(100000000, "NullDSISearch.setActiveProfile(%1)", (long)n);
    }

    public void setCarFunctionStates(CarFunction[] carFunctionArray) {
        this.lc.log(100000000, "NullDSISearch.setCarFunctionStates(%1)", (Object)carFunctionArray);
    }

    public void setRadioStations(RadioStation[] radioStationArray) {
        this.lc.log(100000000, "NullDSISearch.setRadioStations(%1)", (Object)radioStationArray);
    }

    public void setActiveSearchCountries(String[] stringArray) {
        this.lc.log(100000000, "NullDSISearch.setActiveSearchCountries(%1)", (Object)stringArray);
    }

    public void prepareSources(int[] nArray) {
        this.lc.log(100000000, "NullDSISearch.prepareSources(%1)", (Object)nArray);
    }

    public void resetToFactorySettings() {
        this.lc.log(100000000, "NullDSISearch.resetToFactorySettings()");
    }

    public void setCurrentPosition(NavPosition navPosition) {
        this.lc.log(100000000, "NullDSISearch.setCurrentPosition(%1)", (Object)navPosition);
    }

    public void setRoutePoints(NavPosition[] navPositionArray) {
        this.lc.log(100000000, "NullDSISearch.setRoutePoints(%1)", (Object)navPositionArray);
    }

    public void setSearchFilter(int n, SearchFilter searchFilter) {
        this.lc.log(100000000, "NullDSISearch.setSearchFilter(%1, %2)", (Object)searchFilter, (long)n);
    }

    public void removeFromHistory(long l) {
        this.lc.log(100000000, "NullDSISearch.removeFromHistory(%1)", l);
    }

    public void resetAutocompletion(int n) {
        this.lc.log(100000000, "NullDSISearch.resetAutocompletion(%1)", (long)n);
    }

    public void setRadioStations(int n, RadioStation[] radioStationArray) {
        this.lc.log(100000000, "NullDSISearch.setRadioStations(%1)", (long)n);
    }

    public void removeAllFromHistory() {
        this.lc.log(100000000, "NullDSISearch.removeAllFromHistory");
    }

    public void createBackupFile(String string) {
        this.lc.log(100000000, "NullDSISearch.createBackupFile path=(%1)", (Object)string);
    }

    public void importBackupFile(String string) {
        this.lc.log(100000000, "NullDSISearch.importBackupFile fullPath=(%1)", (Object)string);
    }

    public void setEnvironment(Environment environment) {
        this.lc.log(100000000, "NullDSISearch.setEnvironment environment=(%1)", (Object)environment);
    }

    public void removeAllFromHistoryBySource(int n) {
        this.lc.log(100000000, "NullDSISearch.removeAllFromHistoryBySource source=(%1)", (long)n);
    }

    public void profileChange(int n) {
        this.lc.log(100000000, "NullDSISearch.profileChange profile=(%1)", (long)n);
    }

    public void profileCopy(int n, int n2) {
        this.lc.log(100000000, "NullDSISearch.profileCopy fromProfile=(%1), toProfile=(%2)", (long)n, (long)n2);
    }

    public void profileReset(int n) {
        this.lc.log(100000000, "NullDSISearch.profileReset profile=(%1)", (long)n);
    }

    public void profileResetAll() {
        this.lc.log(100000000, "NullDSISearch.profileResetAll");
    }
}

