/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public class TelDSISearchDefaultListener
implements DSISearchListener {
    final LogChannel log;

    public TelDSISearchDefaultListener(LogChannel logChannel) {
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(-1601830656, "[TelDSISearchDefaultListener#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
    }

    @Override
    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#requestSupportedCountriesResult] NOP!");
    }

    @Override
    public void searchResult(int n, SearchResult searchResult) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#searchResult] NOP!");
    }

    @Override
    public void addToHistoryResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#addToHistoryResult] NOP!");
    }

    @Override
    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#requestSuggestionResult] NOP!");
    }

    @Override
    public void setCurrentPositionResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setCurrentPositionResult] NOP!");
    }

    @Override
    public void setRoutePointsResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setRoutePointsResult] NOP!");
    }

    @Override
    public void setLanguageResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setLanguageResult] NOP!");
    }

    public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#updatePotentialConflict] NOP!");
    }

    @Override
    public void setCarFunctionStatesResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setCarFunctionStatesResult] NOP!");
    }

    @Override
    public void setRadioStationsResult(int n, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setRadioStationsResult] NOP!");
    }

    @Override
    public void setSearchFilterResult(int n, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setSearchFilterResult] NOP!");
    }

    @Override
    public void setActiveProfileResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setActiveProfileResult] NOP!");
    }

    @Override
    public void setActiveSearchCountriesResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setActiveSearchCountriesResult] NOP!");
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#resetToFactorySettingsResult] NOP!");
    }

    @Override
    public void invalidateData(int[] nArray) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#invalidateData] NOP!");
    }

    @Override
    public void prepareSourcesResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#prepareSourcesResult] NOP!");
    }

    @Override
    public void removeFromHistoryResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#removeFromHistoryResult] NOP!");
    }

    @Override
    public void removeAllFromHistoryResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#removeAllFromHistoryResult] NOP!");
    }

    @Override
    public void resetAutocompletionResult(int n, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#resetAutocompletionResult] NOP!");
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#sourceDataAvailabilityChanged] NOP!");
    }

    @Override
    public void createBackupFileResult(int n, String string) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#createBackupFileResult] NOP!");
    }

    @Override
    public void importBackupFileResult(int n, String string) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#importBackupFileResult] NOP!");
    }

    @Override
    public void setEnvironmentResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#setEnvironmentResult] NOP!");
    }

    public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#requestSuggestionResult2] NOP!");
    }

    @Override
    public void removeAllFromHistoryBySourceResult(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#removeAllFromHistoryBySourceResult] NOP!");
    }

    @Override
    public void cancelQueryResult(int n, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#cancelQueryResult] NOP!");
    }

    @Override
    public void updateSearchIsActive(int n, boolean bl, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#updateSearchIsActive] NOP!");
    }

    @Override
    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#updatePotentialConflict] NOP!");
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#updateProfileState] NOP!");
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#profileChanged] NOP!");
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#profileCopied] NOP!");
    }

    @Override
    public void profileReset(int n, int n2) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#profileReset] NOP!");
    }

    @Override
    public void profileResetAll(int n) {
        this.log.log(-2137614336, "[TelDSISearchDefaultListener#profileResetAll] NOP!");
    }
}

