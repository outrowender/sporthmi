/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.vcardexchange;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.AbstractADBHandler;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeMediaHandler;
import de.audi.app.addressbook.core.vcardexchange.VCardExchangeViewListener;
import de.audi.app.addressbook.core.vcardexchange.VCardImportFileBrowserModelAccess;
import de.audi.app.addressbook.core.vcardexchange.VCardImportProgress;
import de.audi.app.addressbook.core.vcardexchange.commands.FinishVCardImportCommand;
import de.audi.app.addressbook.core.vcardexchange.commands.VCardExportCommand;
import de.audi.app.addressbook.core.vcardexchange.commands.VCardImportCommand;
import de.audi.app.addressbook.core.vcardexchange.search.organizer.VCardExchangeOrganizerSearch;
import de.audi.app.addressbook.core.vcardexchange.search.organizer.VCardExchangeOrganizerSearchListRow;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.filebrowser.IFileBrowser;
import de.audi.tghu.filebrowser.IFileBrowserManager;
import de.audi.tghu.filebrowser.IModelFileBrowser;
import org.dsi.ifc.filebrowser.Path;

public class VCardExchangeADBHandler
extends AbstractADBHandler {
    public static final int MODE_UNDEFINED;
    public static final int MODE_IMPORT;
    public static final int MODE_EXPORT;
    private int importExportMode = 0;
    private static final int EXCHANGELOCATION_UNDEFINED;
    public static final int EXCHANGELOCATION_SD_1;
    public static final int EXCHANGELOCATION_SD_2;
    public static final int EXCHANGELOCATION_USB_1;
    public static final int EXCHANGELOCATION_USB_2;
    private int exchangeLocation = -1;
    private LogChannel log;
    private IHMIServiceApp hmiService;
    private VCardExchangeMediaHandler mediaHandler;
    private VCardExchangeOrganizerSearch vCardExportListHandler;
    private IFileBrowserManager fileBrowserManager;
    private IModelFileBrowser importFileBrowser;
    private VCardImportFileBrowserModelAccess fileBrowserModelAccess;
    private VCardImportProgress importProgress = new VCardImportProgress();
    private boolean importAborted = false;

    public VCardExchangeADBHandler(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess, iFrameworkAccess.getLogChannel("App.AddressBook.VCardExchange"), iFrameworkAccess.getLogChannel("App.AddressBook.VCardExchangeCmdList"));
        this.log = this.getLog();
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
        this.mediaHandler = new VCardExchangeMediaHandler(this, this.log);
        this.vCardExportListHandler = new VCardExchangeOrganizerSearch(this.hmiService.getTiledListModel(598739456), this, this.log);
        this.fileBrowserModelAccess = new VCardImportFileBrowserModelAccess(iFrameworkAccess.getHmiServiceApp());
        new VCardExchangeViewListener(this.getLog(), this);
    }

    public VCardExchangeMediaHandler getMediaHandler() {
        return this.mediaHandler;
    }

    public VCardExchangeOrganizerSearch getVCardExportListHandler() {
        return this.vCardExportListHandler;
    }

    public void setExchangeLocation(int n) {
        this.exchangeLocation = n;
    }

    public int getExchangeLocation() {
        return this.exchangeLocation;
    }

    public int getImportExportMode() {
        return this.importExportMode;
    }

    public void setFileBrowserManager(IFileBrowserManager iFileBrowserManager) {
        this.log.log(-2137614336, "VCardExchangeADBHandler#setFileBrowserManager(): got fileBrowserManager: %1", (Object)iFileBrowserManager);
        this.fileBrowserManager = iFileBrowserManager;
    }

    public VCardImportProgress getImportProgress() {
        return this.importProgress;
    }

    public boolean isImportAborted() {
        return this.importAborted;
    }

    public void startExportListView(int n) {
        this.log.log(-2137614336, "VCardExchangeADBHandler#startExportListView()");
        this.importExportMode = 2;
        this.exchangeLocation = n;
        this.vCardExportListHandler.reset();
        this.vCardExportListHandler.refreshFromStart();
    }

    public void exportVCards() {
        this.log.log(-2137614336, "VCardExchangeADBHandler#exportVCards()");
        long[] lArray = this.vCardExportListHandler.getSelectedEntries();
        int n = this.vCardExportListHandler.getListMode();
        if (this.vCardExportListHandler.isExchangeSetEmpty() || this.exchangeLocation == -1) {
            this.log.log(-2137614336, "VCardExchangeADBHandler#exportVCards(): No entries or export target selected. Cancelling export.");
        } else {
            String string = this.mediaHandler.getMountPoint(this.exchangeLocation);
            if (string == null || string.length() == 0) {
                this.log.log(10000, "VCardExchangeADBHandler#exportVCards(): mountPoint for exchangeLocation %1 not available!", (long)this.exchangeLocation);
            } else {
                this.log.log(-2137614336, "VCardExchangeADBHandler#exportVCards(): Scheduling export command.");
                VCardExportCommand.createVCardExportCommand(this, -1, this.vCardExportListHandler.getExportMemoryType(), string, lArray, n);
            }
        }
    }

    public void cancelExport() {
        this.log.log(1078071040, "VCardExchangeADBHandler#cancelExport()");
        this.hmiService.getChoiceModel(2058357248).setValue(this.hmiService.getChoiceModel(2058357248).getValue() == 0 ? 1 : 0);
    }

    public void startFileBrowsing(int n) {
        String string;
        this.importExportMode = 1;
        this.setExchangeLocation(n);
        if (this.fileBrowserManager == null) {
            this.log.log(10000, "VCardExchangeADBHandler#startFileBrowsing(): filebrowser manager not available!");
            return;
        }
        if (this.importFileBrowser != null) {
            this.importFileBrowser.close();
            this.importFileBrowser = null;
        }
        if ((string = this.mediaHandler.getMountPoint(n)) == null || string.length() == 0) {
            this.log.log(10000, "VCardExchangeADBHandler#startFileBrowsing(): mountPoint for importLocation %1 not available, reset models!", (long)n);
            this.fileBrowserManager.resetModels(this.fileBrowserModelAccess);
            return;
        }
        this.importFileBrowser = this.fileBrowserManager.open(new Path(string, new String[0]), new String[]{"vcf"}, this.fileBrowserModelAccess);
    }

    public void oneFolderUp() {
        if (this.importFileBrowser == null) {
            this.log.log(10000, "VCardExchangeADBHandler#oneFolderUp(): importFileBrowser not available!");
            return;
        }
        this.importFileBrowser.chdirUp();
    }

    public void importVCards() {
        if (this.importFileBrowser == null) {
            this.log.log(10000, "VCardExchangeADBHandler#importVCards(): importFileBrowser not available!");
            return;
        }
        this.importAborted = false;
        this.hmiService.getLabelModel(1353714176).setStatus(0);
        this.importProgress.reset();
        int n = this.framework.getSysConst(4259);
        IFileBrowser iFileBrowser = this.importFileBrowser.getSelection();
        int n2 = iFileBrowser != null ? iFileBrowser.getFileCount() : 0;
        for (int i2 = 0; i2 < n2; i2 += n) {
            VCardImportCommand.createVCardImportCommand(this, iFileBrowser, i2, n, 0);
        }
        FinishVCardImportCommand.createFinishVCardImportCommand(this, iFileBrowser);
    }

    public void cancelImport() {
        this.log.log(1078071040, "VCardExchangeADBHandler#cancelImport()");
        this.hmiService.getChoiceModel(816843264).setValue(this.hmiService.getChoiceModel(816843264).getValue() == 0 ? 1 : 0);
    }

    public void abortImport() {
        this.importAborted = true;
    }

    @Override
    public void entrySelected(ADBSearch aDBSearch, ADBSearchListRow aDBSearchListRow, int n, int n2) {
        this.vCardExportListHandler.toggleEntrySelection((VCardExchangeOrganizerSearchListRow)aDBSearchListRow);
    }

    @Override
    public void handleInvalidData(int n, boolean bl) {
        this.log.log(-2137614336, "VCardExchangeADBHandler#handleInvalidData(): reason: %2, reloadMainList: %1", bl, (Object)ADBDbgUtils.dbgInvalidDataReason(n));
        if (bl) {
            if (n == 4 || n == 3 || n == 1 || n == 2) {
                this.vCardExportListHandler.reset();
                this.vCardExportListHandler.refreshFromStart();
            } else {
                this.vCardExportListHandler.refresh();
            }
        }
    }

    @Override
    public int getInitStartupCompleteMask() {
        return 485;
    }

    @Override
    public void setAdbReady(boolean bl) {
    }
}

