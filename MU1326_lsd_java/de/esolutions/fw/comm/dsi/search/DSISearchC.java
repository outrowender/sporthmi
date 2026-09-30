/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public interface DSISearchC {
    public void requestSupportedCountries() throws MethodException;

    public void setActiveSearchCountries(String[] var1) throws MethodException;

    public void search(SearchQuery var1) throws MethodException;

    public void addToHistory(SearchResult var1) throws MethodException;

    public void requestSuggestion(SearchQuery var1) throws MethodException;

    public void cancelQuery(int var1) throws MethodException;

    public void setCurrentPosition(NavPosition var1) throws MethodException;

    public void setRoutePoints(NavPosition[] var1) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void setActiveProfile(int var1) throws MethodException;

    public void setCarFunctionStates(CarFunction[] var1) throws MethodException;

    public void setRadioStations(int var1, RadioStation[] var2) throws MethodException;

    public void setSearchFilter(int var1, SearchFilter var2) throws MethodException;

    public void prepareSources(int[] var1) throws MethodException;

    public void resetToFactorySettings() throws MethodException;

    public void removeFromHistory(long var1) throws MethodException;

    public void removeAllFromHistory() throws MethodException;

    public void removeAllFromHistoryBySource(int var1) throws MethodException;

    public void resetAutocompletion(int var1) throws MethodException;

    public void createBackupFile(String var1) throws MethodException;

    public void importBackupFile(String var1) throws MethodException;

    public void setEnvironment(Environment var1) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

