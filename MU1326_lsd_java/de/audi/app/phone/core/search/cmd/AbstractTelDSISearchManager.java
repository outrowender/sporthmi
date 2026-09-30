/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.TelDSISearchDefaultListener;
import de.audi.app.phone.core.search.TelSearchFilterRequestStruct;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.app.phone.core.search.cmd.TelSearchCancelQueryCmd;
import de.audi.app.phone.core.search.cmd.TelSearchPrepareSourcesCmd;
import de.audi.app.phone.core.search.cmd.TelSearchQueryCmd;
import de.audi.app.phone.core.search.cmd.TelSearchSearchAvailableCmd;
import de.audi.app.phone.core.search.cmd.TelSearchSetSearchFilterCmd;
import de.audi.atip.log.LogChannel;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.Country;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public abstract class AbstractTelDSISearchManager
extends AbstractPhoneComponent
implements IDSIClient,
ITelDSISearchAccess {
    private final DSIActivator dsiActivator;
    protected volatile DSISearch dsiSearch;
    private final CommandListManager cmdManager;
    private final DSISearchListener defaultListener;
    private final TelDSISearchListenerImpl dsiSearchListener;
    private final Monitor searchQueryMonitor;
    private volatile TelSearchQueryCmd searchQueryCmd;
    private final int matchMode;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearchListener;

    public AbstractTelDSISearchManager(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Search");
        boolean bl = this.getApplication().getFrameworkAccess().isCn() || this.getApplication().getFrameworkAccess().isJp() || this.getApplication().getFrameworkAccess().isTaiwan();
        this.matchMode = bl ? 1 : 0;
        this.searchQueryMonitor = new Monitor(this.log);
        this.defaultListener = new TelDSISearchDefaultListener(this.log);
        this.dsiSearchListener = new TelDSISearchListenerImpl();
        this.dsiActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = AbstractTelDSISearchManager.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName(), (class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = AbstractTelDSISearchManager.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener).getName(), new Integer(4), this.dsiSearchListener, this);
        this.cmdManager = new CommandListManager("TelDSISearchManager", iTelApplication.getFrameworkAccess(), this.log, null, null);
    }

    public void init() {
        this.cmdManager.start();
        this.dsiActivator.start(this.getApplication().getBundleContext());
    }

    public void deinit() {
        this.dsiActivator.stop(this.getApplication().getBundleContext());
        this.cmdManager.destroy();
    }

    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSISearch) {
            this.log.log(1000000, "[AbstractTelDSISearchManager#setDSI] DSISearch available");
            this.dsiSearch = (DSISearch)dSIBase;
            this.schedulePrepareSources(this.getSources());
            this.setSearchFilters();
            this.scheduleSetSearchAvailable(this.dsiSearch);
        } else {
            this.log.log(1000000, "[AbstractTelDSISearchManager#setDSI] DSISearch is null");
            this.dsiSearch = null;
            this.scheduleSetSearchAvailable(null);
        }
    }

    protected abstract int[] getSources();

    protected abstract TelSearchFilterRequestStruct[] getSearchFilters();

    protected void setSearchFilters() {
        DSISearch dSISearch = this.dsiSearch;
        TelSearchFilterRequestStruct[] telSearchFilterRequestStructArray = this.getSearchFilters();
        if (dSISearch != null && telSearchFilterRequestStructArray != null) {
            for (int i2 = 0; i2 < telSearchFilterRequestStructArray.length; ++i2) {
                TelSearchFilterRequestStruct telSearchFilterRequestStruct = telSearchFilterRequestStructArray[i2];
                if (telSearchFilterRequestStruct == null) continue;
                this.scheduleSetSearchFilter(telSearchFilterRequestStruct.getSource(), telSearchFilterRequestStruct.getSearchFilter());
            }
        }
    }

    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }

    public synchronized void scheduleQuery(String string, int[] nArray, ITelSearchQueryListener iTelSearchQueryListener) {
        this.cancelActiveSearchQuery();
        if (string != null && string.length() > 0) {
            CommandList commandList = new CommandList(this.cmdManager);
            SearchQuery searchQuery = TelSearchQueryCmd.getNextSearchQuery(nArray, string, this.matchMode);
            this.searchQueryCmd = new TelSearchQueryCmd(this.log, this.dsiSearch, searchQuery, iTelSearchQueryListener);
            commandList.add(this.searchQueryCmd);
            commandList.setErrorCommand(new TelSearchCancelQueryCmd(this.log, this.dsiSearch, searchQuery.getQueryId(), iTelSearchQueryListener));
            commandList.addMonitor(this.searchQueryMonitor);
            commandList.execute("SEARCH_QUERY");
        } else {
            this.log.log(1000000, "[AbstractTelDSISearchManager#scheduleQuery] searchText is empty, no search performed.");
        }
    }

    public void cancelActiveSearchQuery() {
        this.log.log(1000000, "[AbstractTelDSISearchManager#cancelActiveSearchQuery]");
        if (this.searchQueryCmd != null) {
            this.searchQueryCmd.setCancel();
            this.searchQueryCmd = null;
        }
        this.searchQueryMonitor.stopMonitoredLists(null);
    }

    private synchronized void scheduleSetSearchFilter(int n, SearchFilter searchFilter) {
        CommandList commandList = new CommandList(this.cmdManager);
        commandList.add(new TelSearchSetSearchFilterCmd(this.log, this.dsiSearch, n, searchFilter));
        commandList.execute("SEARCH_FILTER");
    }

    private synchronized void scheduleSetSearchAvailable(DSISearch dSISearch) {
        CommandList commandList = new CommandList(this.cmdManager);
        commandList.add(new TelSearchSearchAvailableCmd(this.log, dSISearch, this.getChoiceModel(300865)));
        commandList.execute("SEARCH_AVAILABLE");
    }

    private synchronized void schedulePrepareSources(int[] nArray) {
        CommandList commandList = new CommandList(this.cmdManager);
        commandList.add(new TelSearchPrepareSourcesCmd(this.log, this.dsiSearch, nArray));
        commandList.execute("SEARCH_PREPARE_SOURCES");
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class TelDSISearchListenerImpl
    implements DSISearchListener,
    ICommandResponseSupplier {
        private TelDSISearchListenerImpl() {
        }

        public void asyncException(int n, String string, int n2) {
            AbstractTelDSISearchManager.this.log.log(100000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
        }

        public void requestSupportedCountriesResult(int n, Country[] countryArray) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSupportedCountriesResult] NOP!");
        }

        public void searchResult(final int n, final SearchResult searchResult) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#searchResult] searchResult=%1, success=%2", (Object)searchResult, (long)n);
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                    try {
                        dSISearchListener = (DSISearchListener)dSIListener;
                    }
                    catch (ClassCastException classCastException) {
                        AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#searchResult] %1", (Throwable)classCastException);
                    }
                    dSISearchListener.searchResult(n, searchResult);
                }
            });
        }

        public void addToHistoryResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#addToHistoryResult] NOP!");
        }

        public void requestSuggestionResult(final int n, final int n2, final Suggestion[] suggestionArray) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSuggestionResult] success=%2, suggestions=%1", (Object)Converter.array2String(suggestionArray), (long)n);
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                    try {
                        dSISearchListener = (DSISearchListener)dSIListener;
                    }
                    catch (ClassCastException classCastException) {
                        AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSuggestionResult] %1", (Throwable)classCastException);
                    }
                    dSISearchListener.requestSuggestionResult(n, n2, suggestionArray);
                }
            });
        }

        public void cancelQueryResult(final int n, final int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#cancelQueryResult] success=%2, suggestions=%1", (long)n2);
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                    try {
                        dSISearchListener = (DSISearchListener)dSIListener;
                    }
                    catch (ClassCastException classCastException) {
                        AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#cancelQueryResult] %1", (Throwable)classCastException);
                    }
                    dSISearchListener.cancelQueryResult(n, n2);
                }
            });
        }

        public void setCurrentPositionResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setCurrentPositionResult] NOP!");
        }

        public void setRoutePointsResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setRoutePointsResult] NOP!");
        }

        public void setLanguageResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setLanguageResult] NOP!");
        }

        public void updateSearchIsActive(final int n, final boolean bl, final int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateSearchIsActive] isActive=%1", bl);
            if (n2 == 1) {
                CommandResponse.execute(this, new CommandResponse(){

                    public void call(DSIListener dSIListener) {
                        DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                        try {
                            dSISearchListener = (DSISearchListener)dSIListener;
                        }
                        catch (ClassCastException classCastException) {
                            AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateSearchIsActive] %1", (Throwable)classCastException);
                        }
                        dSISearchListener.updateSearchIsActive(n, bl, n2);
                    }
                });
            } else {
                AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateSearchIsActive] invalid update --> NOP!");
            }
        }

        public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updatePotentialConflict] NOP!");
        }

        public void setCarFunctionStatesResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setCarFunctionStatesResult] NOP!");
        }

        public void setRadioStationsResult(int n, int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setRadioStationsResult] NOP!");
        }

        public void setSearchFilterResult(final int n, final int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setSearchFilterResult] NOP!");
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                    try {
                        dSISearchListener = (DSISearchListener)dSIListener;
                    }
                    catch (ClassCastException classCastException) {
                        AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setSearchFilterResult] %1", (Throwable)classCastException);
                    }
                    dSISearchListener.setSearchFilterResult(n, n2);
                }
            });
        }

        public void setActiveProfileResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setActiveProfileResult] NOP!");
        }

        public void setActiveSearchCountriesResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setActiveSearchCountriesResult] NOP!");
        }

        public void resetToFactorySettingsResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#resetToFactorySettingsResult] NOP!");
        }

        public void invalidateData(final int[] nArray) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                    try {
                        dSISearchListener = (DSISearchListener)dSIListener;
                    }
                    catch (ClassCastException classCastException) {
                        AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#invalidateData] %1", (Throwable)classCastException);
                    }
                    dSISearchListener.invalidateData(nArray);
                }
            });
        }

        public void prepareSourcesResult(final int n) {
            CommandResponse.execute(this, new CommandResponse(){

                public void call(DSIListener dSIListener) {
                    DSISearchListener dSISearchListener = AbstractTelDSISearchManager.this.defaultListener;
                    try {
                        dSISearchListener = (DSISearchListener)dSIListener;
                    }
                    catch (ClassCastException classCastException) {
                        AbstractTelDSISearchManager.this.log.log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#prepareSourcesResult] %1", (Throwable)classCastException);
                    }
                    dSISearchListener.prepareSourcesResult(n);
                }
            });
        }

        public void removeFromHistoryResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#removeFromHistoryResult] NOP!");
        }

        public void removeAllFromHistoryResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#removeAllFromHistoryResult] NOP!");
        }

        public void resetAutocompletionResult(int n, int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#resetAutocompletionResult] NOP!");
        }

        public void sourceDataAvailabilityChanged(int n, boolean bl) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#sourceDataAvailabilityChanged] NOP!");
        }

        public void createBackupFileResult(int n, String string) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#createBackupFileResult] NOP!");
        }

        public void importBackupFileResult(int n, String string) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#importBackupFileResult] NOP!");
        }

        public void setEnvironmentResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#setEnvironmentResult] NOP!");
        }

        public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSuggestionResult2] NOP!");
        }

        public DSIListener getDSIDefaultHandler() {
            return AbstractTelDSISearchManager.this.defaultListener;
        }

        public CommandList getActiveCommandList() {
            return AbstractTelDSISearchManager.this.cmdManager.getActiveCommandList();
        }

        public LogChannel getLogChannel() {
            return AbstractTelDSISearchManager.this.log;
        }

        public String getHandlerName() {
            return "TelDSISearchListenerImpl";
        }

        public void removeAllFromHistoryBySourceResult(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#removeAllFromHistoryBySourceResult] NOP!");
        }

        public void updatePotentialConflict(int n, boolean bl, ConflictMatch conflictMatch, int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updatePotentialConflict] NOP!");
        }

        public void updateProfileState(int n, int n2, int n3) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateProfileState] NOP!");
        }

        public void profileChanged(int n, int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileChanged] NOP!");
        }

        public void profileCopied(int n, int n2, int n3) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileCopied] NOP!");
        }

        public void profileReset(int n, int n2) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileReset] NOP!");
        }

        public void profileResetAll(int n) {
            AbstractTelDSISearchManager.this.log.log(10000000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#profileResetAll] NOP!");
        }
    }
}

