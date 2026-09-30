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

    public void asyncException(int n, String string, int n2) {
        this.log.log(100000, "[TelDSISearchDefaultListener#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
    }

    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#requestSupportedCountriesResult] NOP!");
    }

    public void searchResult(int n, SearchResult searchResult) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#searchResult] NOP!");
    }

    public void addToHistoryResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#addToHistoryResult] NOP!");
    }

    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#requestSuggestionResult] NOP!");
    }

    public void setCurrentPositionResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setCurrentPositionResult] NOP!");
    }

    public void setRoutePointsResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setRoutePointsResult] NOP!");
    }

    public void setLanguageResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setLanguageResult] NOP!");
    }

    public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#updatePotentialConflict] NOP!");
    }

    public void setCarFunctionStatesResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setCarFunctionStatesResult] NOP!");
    }

    public void setRadioStationsResult(int n, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setRadioStationsResult] NOP!");
    }

    public void setSearchFilterResult(int n, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setSearchFilterResult] NOP!");
    }

    public void setActiveProfileResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setActiveProfileResult] NOP!");
    }

    public void setActiveSearchCountriesResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setActiveSearchCountriesResult] NOP!");
    }

    public void resetToFactorySettingsResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#resetToFactorySettingsResult] NOP!");
    }

    public void invalidateData(int[] nArray) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#invalidateData] NOP!");
    }

    public void prepareSourcesResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#prepareSourcesResult] NOP!");
    }

    public void removeFromHistoryResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#removeFromHistoryResult] NOP!");
    }

    public void removeAllFromHistoryResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#removeAllFromHistoryResult] NOP!");
    }

    public void resetAutocompletionResult(int n, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#resetAutocompletionResult] NOP!");
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#sourceDataAvailabilityChanged] NOP!");
    }

    public void createBackupFileResult(int n, String string) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#createBackupFileResult] NOP!");
    }

    public void importBackupFileResult(int n, String string) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#importBackupFileResult] NOP!");
    }

    public void setEnvironmentResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#setEnvironmentResult] NOP!");
    }

    public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#requestSuggestionResult2] NOP!");
    }

    public void removeAllFromHistoryBySourceResult(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#removeAllFromHistoryBySourceResult] NOP!");
    }

    public void cancelQueryResult(int n, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#cancelQueryResult] NOP!");
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#updateSearchIsActive] NOP!");
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#updatePotentialConflict] NOP!");
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#updateProfileState] NOP!");
    }

    public void profileChanged(int n, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#profileChanged] NOP!");
    }

    public void profileCopied(int n, int n2, int n3) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#profileCopied] NOP!");
    }

    public void profileReset(int n, int n2) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#profileReset] NOP!");
    }

    public void profileResetAll(int n) {
        this.log.log(10000000, "[TelDSISearchDefaultListener#profileResetAll] NOP!");
    }
}

