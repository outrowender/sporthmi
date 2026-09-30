/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public interface DSISearchListener
extends DSIListener {
    public void requestSupportedCountriesResult(int var1, Country[] var2);

    public void searchResult(int var1, SearchResult var2);

    public void addToHistoryResult(int var1);

    public void requestSuggestionResult(int var1, int var2, Suggestion[] var3);

    public void cancelQueryResult(int var1, int var2);

    public void setCurrentPositionResult(int var1);

    public void setRoutePointsResult(int var1);

    public void setLanguageResult(int var1);

    public void updateSearchIsActive(int var1, boolean var2, int var3);

    public void updatePotentialConflict(int var1, boolean var2, ConflictMatch var3, int var4);

    public void setCarFunctionStatesResult(int var1);

    public void setRadioStationsResult(int var1, int var2);

    public void setSearchFilterResult(int var1, int var2);

    public void setActiveProfileResult(int var1);

    public void setActiveSearchCountriesResult(int var1);

    public void resetToFactorySettingsResult(int var1);

    public void invalidateData(int[] var1);

    public void prepareSourcesResult(int var1);

    public void removeFromHistoryResult(int var1);

    public void removeAllFromHistoryResult(int var1);

    public void removeAllFromHistoryBySourceResult(int var1);

    public void resetAutocompletionResult(int var1, int var2);

    public void sourceDataAvailabilityChanged(int var1, boolean var2);

    public void createBackupFileResult(int var1, String var2);

    public void importBackupFileResult(int var1, String var2);

    public void setEnvironmentResult(int var1);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

