/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$1;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$1;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$2;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$3;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$4;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$5;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$6;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl$7;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

class AbstractTelDSISearchManager$TelDSISearchListenerImpl
implements DSISearchListener,
ICommandResponseSupplier {
    private final /* synthetic */ AbstractTelDSISearchManager this$0;

    private AbstractTelDSISearchManager$TelDSISearchListenerImpl(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        this.this$0 = abstractTelDSISearchManager;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        AbstractTelDSISearchManager.access$100(this.this$0).log(-1601830656, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
    }

    @Override
    public void requestSupportedCountriesResult(int n, Country[] countryArray) {
        AbstractTelDSISearchManager.access$200(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSupportedCountriesResult] NOP!");
    }

    @Override
    public void searchResult(int n, SearchResult searchResult) {
        AbstractTelDSISearchManager.access$300(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#searchResult] searchResult=%1, success=%2", (Object)searchResult, (long)n);
        CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$1(this, n, searchResult));
    }

    @Override
    public void addToHistoryResult(int n) {
        AbstractTelDSISearchManager.access$700(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#addToHistoryResult] NOP!");
    }

    @Override
    public void requestSuggestionResult(int n, int n2, Suggestion[] suggestionArray) {
        AbstractTelDSISearchManager.access$800(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSuggestionResult] success=%2, suggestions=%1", (Object)Converter.array2String(suggestionArray), (long)n);
        CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$2(this, n, n2, suggestionArray));
    }

    @Override
    public void cancelQueryResult(int n, int n2) {
        AbstractTelDSISearchManager.access$1000(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#cancelQueryResult] success=%2, suggestions=%1", (long)n2);
        CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$3(this, n, n2));
    }

    @Override
    public void setCurrentPositionResult(int n) {
        AbstractTelDSISearchManager.access$1200(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setCurrentPositionResult] NOP!");
    }

    @Override
    public void setRoutePointsResult(int n) {
        AbstractTelDSISearchManager.access$1300(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setRoutePointsResult] NOP!");
    }

    @Override
    public void setLanguageResult(int n) {
        AbstractTelDSISearchManager.access$1400(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setLanguageResult] NOP!");
    }

    @Override
    public void updateSearchIsActive(int n, boolean bl, int n2) {
        AbstractTelDSISearchManager.access$1500(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateSearchIsActive] isActive=%1", bl);
        if (n2 == 1) {
            CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$4(this, n, bl, n2));
        } else {
            AbstractTelDSISearchManager.access$1700(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateSearchIsActive] invalid update --> NOP!");
        }
    }

    public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
        AbstractTelDSISearchManager.access$1800(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updatePotentialConflict] NOP!");
    }

    @Override
    public void setCarFunctionStatesResult(int n) {
        AbstractTelDSISearchManager.access$1900(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setCarFunctionStatesResult] NOP!");
    }

    @Override
    public void setRadioStationsResult(int n, int n2) {
        AbstractTelDSISearchManager.access$2000(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setRadioStationsResult] NOP!");
    }

    @Override
    public void setSearchFilterResult(int n, int n2) {
        AbstractTelDSISearchManager.access$2100(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setSearchFilterResult] NOP!");
        CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$5(this, n, n2));
    }

    @Override
    public void setActiveProfileResult(int n) {
        AbstractTelDSISearchManager.access$2300(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setActiveProfileResult] NOP!");
    }

    @Override
    public void setActiveSearchCountriesResult(int n) {
        AbstractTelDSISearchManager.access$2400(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setActiveSearchCountriesResult] NOP!");
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        AbstractTelDSISearchManager.access$2500(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#resetToFactorySettingsResult] NOP!");
    }

    @Override
    public void invalidateData(int[] nArray) {
        CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$6(this, nArray));
    }

    @Override
    public void prepareSourcesResult(int n) {
        CommandResponse.execute(this, new AbstractTelDSISearchManager$TelDSISearchListenerImpl$7(this, n));
    }

    @Override
    public void removeFromHistoryResult(int n) {
        AbstractTelDSISearchManager.access$2800(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#removeFromHistoryResult] NOP!");
    }

    @Override
    public void removeAllFromHistoryResult(int n) {
        AbstractTelDSISearchManager.access$2900(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#removeAllFromHistoryResult] NOP!");
    }

    @Override
    public void resetAutocompletionResult(int n, int n2) {
        AbstractTelDSISearchManager.access$3000(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#resetAutocompletionResult] NOP!");
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        AbstractTelDSISearchManager.access$3100(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#sourceDataAvailabilityChanged] NOP!");
    }

    @Override
    public void createBackupFileResult(int n, String string) {
        AbstractTelDSISearchManager.access$3200(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#createBackupFileResult] NOP!");
    }

    @Override
    public void importBackupFileResult(int n, String string) {
        AbstractTelDSISearchManager.access$3300(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#importBackupFileResult] NOP!");
    }

    @Override
    public void setEnvironmentResult(int n) {
        AbstractTelDSISearchManager.access$3400(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setEnvironmentResult] NOP!");
    }

    public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
        AbstractTelDSISearchManager.access$3500(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSuggestionResult2] NOP!");
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return AbstractTelDSISearchManager.access$500(this.this$0);
    }

    @Override
    public CommandList getActiveCommandList() {
        return AbstractTelDSISearchManager.access$3600(this.this$0).getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return AbstractTelDSISearchManager.access$3700(this.this$0);
    }

    @Override
    public String getHandlerName() {
        return "TelDSISearchListenerImpl";
    }

    @Override
    public void removeAllFromHistoryBySourceResult(int n) {
        AbstractTelDSISearchManager.access$3800(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#removeAllFromHistoryBySourceResult] NOP!");
    }

    @Override
    public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
        AbstractTelDSISearchManager.access$3900(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updatePotentialConflict] NOP!");
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        AbstractTelDSISearchManager.access$4000(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateProfileState] NOP!");
    }

    @Override
    public void profileChanged(int n, int n2) {
        AbstractTelDSISearchManager.access$4100(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileChanged] NOP!");
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        AbstractTelDSISearchManager.access$4200(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileCopied] NOP!");
    }

    @Override
    public void profileReset(int n, int n2) {
        AbstractTelDSISearchManager.access$4300(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileReset] NOP!");
    }

    @Override
    public void profileResetAll(int n) {
        AbstractTelDSISearchManager.access$4400(this.this$0).log(-2137614336, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileResetAll] NOP!");
    }

    /* synthetic */ AbstractTelDSISearchManager$TelDSISearchListenerImpl(AbstractTelDSISearchManager abstractTelDSISearchManager, AbstractTelDSISearchManager$1 abstractTelDSISearchManager$1) {
        this(abstractTelDSISearchManager);
    }

    static /* synthetic */ AbstractTelDSISearchManager access$400(AbstractTelDSISearchManager$TelDSISearchListenerImpl abstractTelDSISearchManager$TelDSISearchListenerImpl) {
        return abstractTelDSISearchManager$TelDSISearchListenerImpl.this$0;
    }
}

