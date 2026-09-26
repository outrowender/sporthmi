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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(-1601830656, "[AbstractTelSearchCmd#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
    }

    @Override
    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#requestSupportedCountriesResult] NOP!");
    }

    @Override
    public void searchResult(int n, SearchResult searchResult) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#searchResult] NOP!");
    }

    @Override
    public void addToHistoryResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#addToHistoryResult] NOP!");
    }

    @Override
    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#requestSuggestionResult] NOP!");
    }

    @Override
    public void setCurrentPositionResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setCurrentPositionResult] NOP!");
    }

    @Override
    public void setRoutePointsResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setRoutePointsResult] NOP!");
    }

    @Override
    public void setLanguageResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setLanguageResult] NOP!");
    }

    public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#updatePotentialConflict] NOP!");
    }

    @Override
    public void setCarFunctionStatesResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setCarFunctionStatesResult] NOP!");
    }

    @Override
    public void setRadioStationsResult(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setRadioStationsResult] NOP!");
    }

    @Override
    public void setSearchFilterResult(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setSearchFilterResult] NOP!");
    }

    @Override
    public void setActiveProfileResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setActiveProfileResult] NOP!");
    }

    @Override
    public void setActiveSearchCountriesResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setActiveSearchCountriesResult] NOP!");
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#resetToFactorySettingsResult] NOP!");
    }

    @Override
    public void invalidateData(int[] nArray) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#invalidateData] NOP!");
    }

    @Override
    public void prepareSourcesResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#prepareSourcesResult] NOP!");
    }

    @Override
    public void removeFromHistoryResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#removeFromHistoryResult] NOP!");
    }

    @Override
    public void removeAllFromHistoryResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#removeAllFromHistoryResult] NOP!");
    }

    @Override
    public void resetAutocompletionResult(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#resetAutocompletionResult] NOP!");
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#sourceDataAvailabilityChanged] NOP!");
    }

    @Override
    public void createBackupFileResult(int n, String string) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#createBackupFileResult] NOP!");
    }

    @Override
    public void importBackupFileResult(int n, String string) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#importBackupFileResult] NOP!");
    }

    @Override
    public void setEnvironmentResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#setEnvironmentResult] NOP!");
    }

    public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
    }

    @Override
    public void removeAllFromHistoryBySourceResult(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#removeAllFromHistoryBySourceResult] NOP!");
    }

    @Override
    public void cancelQueryResult(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#cancelQueryResult] NOP!");
    }

    @Override
    public void updateSearchIsActive(int n, boolean bl, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#updateSearchIsActive] NOP!");
    }

    @Override
    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#updatePotentialConflict] NOP!");
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#updateProfileState] NOP!");
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#profileChanged] NOP!");
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#profileCopied] NOP!");
    }

    @Override
    public void profileReset(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#profileReset] NOP!");
    }

    @Override
    public void profileResetAll(int n) {
        this.logger.log(-2137614336, "[AbstractTelSearchCmd#profileResetAll] NOP!");
    }
}

