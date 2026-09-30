/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public abstract class AbstractTelSearchCmd
extends Command
implements DSISearchListener {
    protected final DSISearch dsiSearch;

    public AbstractTelSearchCmd(LogChannel logChannel, String string, DSISearch dSISearch) {
        super(logChannel, string);
        this.dsiSearch = dSISearch;
    }

    protected DSISearch getDSISearch() {
        return this.dsiSearch;
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(100000, "[AbstractTelSearchCmd#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
    }

    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#requestSupportedCountriesResult] NOP!");
    }

    public void searchResult(int n, SearchResult searchResult) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#searchResult] NOP!");
    }

    public void addToHistoryResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#addToHistoryResult] NOP!");
    }

    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#requestSuggestionResult] NOP!");
    }

    public void setCurrentPositionResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setCurrentPositionResult] NOP!");
    }

    public void setRoutePointsResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setRoutePointsResult] NOP!");
    }

    public void setLanguageResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setLanguageResult] NOP!");
    }

    public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#updatePotentialConflict] NOP!");
    }

    public void setCarFunctionStatesResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setCarFunctionStatesResult] NOP!");
    }

    public void setRadioStationsResult(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setRadioStationsResult] NOP!");
    }

    public void setSearchFilterResult(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setSearchFilterResult] NOP!");
    }

    public void setActiveProfileResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setActiveProfileResult] NOP!");
    }

    public void setActiveSearchCountriesResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setActiveSearchCountriesResult] NOP!");
    }

    public void resetToFactorySettingsResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#resetToFactorySettingsResult] NOP!");
    }

    public void invalidateData(int[] nArray) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#invalidateData] NOP!");
    }

    public void prepareSourcesResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#prepareSourcesResult] NOP!");
    }

    public void removeFromHistoryResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#removeFromHistoryResult] NOP!");
    }

    public void removeAllFromHistoryResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#removeAllFromHistoryResult] NOP!");
    }

    public void resetAutocompletionResult(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#resetAutocompletionResult] NOP!");
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#sourceDataAvailabilityChanged] NOP!");
    }

    public void createBackupFileResult(int n, String string) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#createBackupFileResult] NOP!");
    }

    public void importBackupFileResult(int n, String string) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#importBackupFileResult] NOP!");
    }

    public void setEnvironmentResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#setEnvironmentResult] NOP!");
    }

    public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
    }

    public void removeAllFromHistoryBySourceResult(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#removeAllFromHistoryBySourceResult] NOP!");
    }

    public void cancelQueryResult(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#cancelQueryResult] NOP!");
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#updateSearchIsActive] NOP!");
    }

    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#updatePotentialConflict] NOP!");
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#updateProfileState] NOP!");
    }

    public void profileChanged(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#profileChanged] NOP!");
    }

    public void profileCopied(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#profileCopied] NOP!");
    }

    public void profileReset(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#profileReset] NOP!");
    }

    public void profileResetAll(int n) {
        this.logger.log(10000000, "[AbstractTelSearchCmd#profileResetAll] NOP!");
    }
}

