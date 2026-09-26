/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.TelDSISearchDefaultListener;
import de.audi.app.phone.core.search.TelSearchFilterRequestStruct;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl;
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
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;

public abstract class AbstractTelDSISearchManager
extends AbstractPhoneComponent
implements IDSIClient,
ITelDSISearchAccess {
    private final DSIActivator dsiActivator;
    protected volatile DSISearch dsiSearch;
    private final CommandListManager cmdManager;
    private final DSISearchListener defaultListener;
    private final AbstractTelDSISearchManager$TelDSISearchListenerImpl dsiSearchListener;
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
        this.dsiSearchListener = new AbstractTelDSISearchManager$TelDSISearchListenerImpl(this, null);
        this.dsiActivator = new DSIActivator(iTelApplication.getFrameworkAccess(), (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = AbstractTelDSISearchManager.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName(), (class$org$dsi$ifc$search$DSISearchListener == null ? (class$org$dsi$ifc$search$DSISearchListener = AbstractTelDSISearchManager.class$("org.dsi.ifc.search.DSISearchListener")) : class$org$dsi$ifc$search$DSISearchListener).getName(), new Integer(4), this.dsiSearchListener, this);
        this.cmdManager = new CommandListManager("TelDSISearchManager", iTelApplication.getFrameworkAccess(), this.log, null, null);
    }

    @Override
    public void init() {
        this.cmdManager.start();
        this.dsiActivator.start(this.getApplication().getBundleContext());
    }

    @Override
    public void deinit() {
        this.dsiActivator.stop(this.getApplication().getBundleContext());
        this.cmdManager.destroy();
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSISearch) {
            this.log.log(1078071040, "[AbstractTelDSISearchManager#setDSI] DSISearch available");
            this.dsiSearch = (DSISearch)dSIBase;
            this.schedulePrepareSources(this.getSources());
            this.setSearchFilters();
            this.scheduleSetSearchAvailable(this.dsiSearch);
        } else {
            this.log.log(1078071040, "[AbstractTelDSISearchManager#setDSI] DSISearch is null");
            this.dsiSearch = null;
            this.scheduleSetSearchAvailable(null);
        }
    }

    protected abstract int[] getSources() {
    }

    protected abstract TelSearchFilterRequestStruct[] getSearchFilters() {
    }

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

    @Override
    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }

    @Override
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
            this.log.log(1078071040, "[AbstractTelDSISearchManager#scheduleQuery] searchText is empty, no search performed.");
        }
    }

    @Override
    public void cancelActiveSearchQuery() {
        this.log.log(1078071040, "[AbstractTelDSISearchManager#cancelActiveSearchQuery]");
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
        commandList.add(new TelSearchSearchAvailableCmd(this.log, dSISearch, this.getChoiceModel(1100416000)));
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

    static /* synthetic */ LogChannel access$100(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$200(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$300(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ DSISearchListener access$500(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.defaultListener;
    }

    static /* synthetic */ LogChannel access$600(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$700(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$800(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$900(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1000(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1100(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1200(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1300(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1400(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1500(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1600(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1700(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1800(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$1900(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2000(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2100(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2200(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2300(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2400(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2500(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2600(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2700(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2800(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$2900(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3000(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3100(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3200(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3300(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3400(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3500(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ CommandListManager access$3600(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.cmdManager;
    }

    static /* synthetic */ LogChannel access$3700(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3800(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$3900(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$4000(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$4100(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$4200(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$4300(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }

    static /* synthetic */ LogChannel access$4400(AbstractTelDSISearchManager abstractTelDSISearchManager) {
        return abstractTelDSISearchManager.log;
    }
}

