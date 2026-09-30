/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public interface DSISearchReply {
    public static final String IPL_COMM_UUID = "0ff5e332-b87e-54b7-b7a5-4443f1ccedcd";
    public static final String IPL_COMM_INTERFACE_KEY = "401b0058-41e3-5f0a-90d4-8867c2944111";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.25";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.25";

    public void requestSupportedCountriesResult(int var1, Country[] var2) throws MethodException;

    public void searchResult(int var1, SearchResult var2) throws MethodException;

    public void addToHistoryResult(int var1) throws MethodException;

    public void requestSuggestionResult(int var1, int var2, Suggestion[] var3) throws MethodException;

    public void cancelQueryResult(int var1, int var2) throws MethodException;

    public void setCurrentPositionResult(int var1) throws MethodException;

    public void setRoutePointsResult(int var1) throws MethodException;

    public void setLanguageResult(int var1) throws MethodException;

    public void updateSearchIsActive(int var1, boolean var2, int var3) throws MethodException;

    public void updatePotentialConflict(int var1, boolean var2, ConflictMatch var3, int var4) throws MethodException;

    public void setCarFunctionStatesResult(int var1) throws MethodException;

    public void setRadioStationsResult(int var1, int var2) throws MethodException;

    public void setSearchFilterResult(int var1, int var2) throws MethodException;

    public void setActiveProfileResult(int var1) throws MethodException;

    public void setActiveSearchCountriesResult(int var1) throws MethodException;

    public void resetToFactorySettingsResult(int var1) throws MethodException;

    public void invalidateData(int[] var1) throws MethodException;

    public void prepareSourcesResult(int var1) throws MethodException;

    public void removeFromHistoryResult(int var1) throws MethodException;

    public void removeAllFromHistoryResult(int var1) throws MethodException;

    public void removeAllFromHistoryBySourceResult(int var1) throws MethodException;

    public void resetAutocompletionResult(int var1, int var2) throws MethodException;

    public void sourceDataAvailabilityChanged(int var1, boolean var2) throws MethodException;

    public void createBackupFileResult(int var1, String var2) throws MethodException;

    public void importBackupFileResult(int var1, String var2) throws MethodException;

    public void setEnvironmentResult(int var1) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

