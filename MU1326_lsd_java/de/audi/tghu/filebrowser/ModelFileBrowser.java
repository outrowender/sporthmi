/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.filebrowser;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelAsiaApp;
import de.audi.tghu.filebrowser.AbstractEvoFileListRow;
import de.audi.tghu.filebrowser.AbstractFileBrowserSession;
import de.audi.tghu.filebrowser.DefaultEvoFileListRowBuilder;
import de.audi.tghu.filebrowser.FileBrowserManager;
import de.audi.tghu.filebrowser.IEvoFileListRowBuilder;
import de.audi.tghu.filebrowser.IFileBrowserModelAccess;
import de.audi.tghu.filebrowser.IModelFileBrowser;
import de.esolutions.fw.util.commons.IntList;
import java.util.HashMap;
import java.util.List;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public class ModelFileBrowser
extends AbstractFileBrowserSession
implements IModelFileBrowser,
DSIFileBrowserListener,
ButtonListener,
ChoiceListener,
TiledListModelListener {
    private static final int BUFFER_SIZE = 25;
    protected static final String DIR_UP = "..";
    protected static final String DIR_CURRENT = ".";
    protected static final int NON_WIDGET_REQUEST_ID = -1;
    protected static final int MAX_ITEM_REQUESTS = 64;
    protected IFileBrowserModelAccess modelAccess = null;
    protected SpellerHandler spellerHandler = null;
    protected IEvoFileListRowBuilder evoRowBuilder = null;
    private int totalFileCount = 0;
    private int totalEntryCount = 0;
    private int selectedFileCount = 0;
    protected IntList itemRequestIds = new IntList(64);
    private ResourceLocator[] resultResources = null;
    private volatile boolean responded = false;
    private AbstractEvoFileListRow focusedRow = null;
    private boolean allFilesSelected = false;
    private int requestedRows = 0;
    private boolean refillForJump = false;
    private boolean refreshPreviewFlag = false;
    private int pendingFocusedRow = -1;
    private boolean isPendingFocusedRowFromFile = false;
    private HashMap directoryHistory = new HashMap();
    private boolean chdirResetFocusedRow = false;
    private volatile boolean isWaitingForSelectAll = false;

    protected ModelFileBrowser(FileBrowserManager fileBrowserManager, int n, Path path, String[] stringArray, IFileBrowserModelAccess iFileBrowserModelAccess, IEvoFileListRowBuilder iEvoFileListRowBuilder) {
        super(fileBrowserManager, n, path, stringArray);
        this.evoRowBuilder = null == iEvoFileListRowBuilder ? new DefaultEvoFileListRowBuilder() : iEvoFileListRowBuilder;
        this.setModelAccess(iFileBrowserModelAccess, stringArray == null);
    }

    private void cleanupModels() {
        ButtonModelApp buttonModelApp;
        ChoiceModelApp choiceModelApp;
        ButtonModelApp buttonModelApp2;
        ButtonModelApp buttonModelApp3;
        ChoiceModelApp choiceModelApp2;
        this.getLog().log(1000000, "[TiledModelFileBrowser].cleanupModels(): session = %1", (long)this.getSession());
        TiledListModelApp tiledListModelApp = this.getListModel();
        if (tiledListModelApp != null) {
            tiledListModelApp.resetListener();
            tiledListModelApp.removeAll();
            tiledListModelApp.setSelectedIndex(-1);
            tiledListModelApp.trigger(ModelTrigger.JOIN_CURSOR);
        }
        if ((choiceModelApp2 = this.getRootFolderReachedModel()) != null) {
            choiceModelApp2.setValue(1);
        }
        if ((buttonModelApp3 = this.getImportButton()) != null) {
            buttonModelApp3.setStatus(0);
        }
        if ((buttonModelApp2 = this.getSelectSingleButton()) != null) {
            buttonModelApp2.setButtonListener(null);
        }
        if ((choiceModelApp = this.getSelectAllChoice()) != null) {
            choiceModelApp.setChoiceListener(null);
        }
        if ((buttonModelApp = this.getSearchButton()) != null) {
            buttonModelApp.setButtonListener(null);
        }
        if (this.spellerHandler != null) {
            this.spellerHandler.cleanup();
        }
        this.spellerHandler = null;
        this.modelAccess = null;
        this.focusedRow = null;
    }

    public void close() {
        this.getLog().log(1000000, "[TiledModelFileBrowser].close(): closing session %1", (long)this.getSession());
        this.cleanupModels();
        super.close();
    }

    protected boolean isSpellerActive() {
        return this.spellerHandler != null && this.spellerHandler.isActive();
    }

    protected boolean setFocusedRow(int n) {
        this.getLog().log(10000000, "[TiledModelFileBrowser].setFocusedRow(%1)", (long)n);
        TiledListModelApp tiledListModelApp = this.getListModel();
        if (tiledListModelApp != null) {
            try {
                if (null != tiledListModelApp.getRow(n)) {
                    this.getLog().log(10000000, "[TiledModelFileBrowser].setFocusedRow(): Focus set to index=%1", (long)n);
                    tiledListModelApp.setSelectedIndex(n);
                    tiledListModelApp.trigger(ModelTrigger.JOIN_CURSOR);
                    return true;
                }
            }
            catch (Exception exception) {
                this.getLog().log(100000, "[TiledModelFileBrowser].setFocusedRow(): Failed to set selected index", (Throwable)exception);
                return false;
            }
        }
        return false;
    }

    private final void getFileCountWithFileTypeFilter(int n, int n2) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (null != dSIFileBrowser) {
            this.getLogDSI().log(10000000, "[TiledModelFileBrowser] -> getFileCountWithFileTypeFilter(%1,%2)", (long)n, (long)n2);
            dSIFileBrowser.getFileCountWithFileTypeFilter(n, n2);
        } else {
            this.getLogDSI().log(100000, "[TiledModelFileBrowser].getFileCountWithFileTypeFilter(%1,%2): Null dsi!", (long)n, (long)n2);
        }
    }

    private final void getViewWindowFromFile(int n, int n2, BrowsedFile browsedFile, int n3) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (null != dSIFileBrowser) {
            this.getLogDSI().log(1000000, "[TiledModelFileBrowser] -> getFileCountWithFileTypeFilter() file = %1", (Object)browsedFile);
            dSIFileBrowser.getViewWindowFromFile(n, n2, browsedFile, n3);
        } else {
            this.getLogDSI().log(100000, "[TiledModelFileBrowser].getFileCountWithFileTypeFilter(%1): Null dsi!", (Object)browsedFile);
        }
    }

    protected void jumpToEntry(int n) {
        this.getLog().log(1000000, "[TiledModelFileBrowser].jumpToEntry(%1)", (long)n);
        if (this.setFocusedRow(n)) {
            return;
        }
        this.getLog().log(1000000, "ModelFileBrowser.jumpToEntry: Trigger list update request.");
        this.isPendingFocusedRowFromFile = false;
        this.pendingFocusedRow = n;
        int n2 = n - 12;
        if (n2 < 0) {
            n2 = 0;
        }
        this.refillForJump = true;
        this.requestedRows = 25;
        this.getFiles(n2, this.requestedRows);
    }

    protected void jumpToEntry(BrowsedFile browsedFile) {
        this.getLog().log(1000000, "[TiledModelFileBrowser].jumpToEntry('%1')", (Object)browsedFile);
        this.isPendingFocusedRowFromFile = true;
        this.pendingFocusedRow = 0;
        this.refillForJump = true;
        this.requestedRows = 25;
        this.getFiles(browsedFile, 0, this.requestedRows);
    }

    public final void setModelAccess(IFileBrowserModelAccess iFileBrowserModelAccess, boolean bl) {
        this.cleanupModels();
        if (iFileBrowserModelAccess != null) {
            ButtonModelApp buttonModelApp;
            ChoiceModelApp choiceModelApp;
            ButtonModelApp buttonModelApp2;
            TiledListModelApp tiledListModelApp;
            this.modelAccess = iFileBrowserModelAccess;
            this.focusedRow = null;
            this.allFilesSelected = false;
            LabelModelApp labelModelApp = this.getPathLabel();
            if (labelModelApp != null) {
                labelModelApp.setText(this.showFullPath() ? this.path2String(this.pwd()) : this.cwd2String(this.pwd()));
            }
            if ((tiledListModelApp = this.getListModel()) != null) {
                tiledListModelApp.setListener(this);
                if (bl) {
                    this.rebuildListFromStart();
                }
                this.getLogDSI().log(1000000, "[TiledModelFileBrowser].setModelAccess() -> getFileCount(%1)", (long)this.getSession());
                this.getDSI().getFileCount(this.getSession());
                this.getLogDSI().log(1000000, "[TiledModelFileBrowser].setModelAccess() -> getFileCountWithFileTypeFilter(%1,%2)", (long)this.getSession(), 1L);
                this.getFileCountWithFileTypeFilter(this.getSession(), 1);
            }
            if ((buttonModelApp2 = this.getSelectSingleButton()) != null) {
                buttonModelApp2.setButtonListener(this);
            }
            if ((choiceModelApp = this.getSelectAllChoice()) != null) {
                choiceModelApp.setChoiceListener(this);
                this.setAllFilesSelectedFlag(false);
            }
            if ((buttonModelApp = this.getImportButton()) != null) {
                buttonModelApp.setStatus(0);
            }
            try {
                ButtonModelApp buttonModelApp3 = this.getSearchButton();
                MatchspellerModelApp matchspellerModelApp = this.getSearchSpeller();
                ListModelApp listModelApp = this.getSearchPreviewList();
                TiledListModelApp tiledListModelApp2 = this.getSearchFilteredList();
                if (buttonModelApp3 != null && listModelApp != null) {
                    this.getLog().log(1000000, "[TiledModelFileBrowser].setModelAccess(): active search speller");
                    buttonModelApp3.setButtonListener(this);
                    if (matchspellerModelApp != null) {
                        this.spellerHandler = new SpellerHandler(matchspellerModelApp, listModelApp);
                    }
                }
                if (tiledListModelApp2 != null) {
                    tiledListModelApp2.setListener(this);
                }
            }
            catch (Exception exception) {
                this.getLog().log(100000, "[TiledModelFileBrowser].setModelAccess(): assign speller failed!", (Throwable)exception);
            }
        }
    }

    private final void showBusyCursor(boolean bl) {
        ChoiceModelApp choiceModelApp;
        TiledListModelApp tiledListModelApp;
        boolean bl2 = this.isSpellerActive();
        this.getLog().log(1000000, "ModelFileBrowser.showBusyCursor(%1) -> spellerActive=%2", bl, bl2);
        if (bl2) {
            tiledListModelApp = this.getSearchFilteredList();
            choiceModelApp = this.getSearchFilteredListSelected();
        } else {
            tiledListModelApp = this.getListModel();
            choiceModelApp = this.getListModelSelected();
        }
        if (null != choiceModelApp && null != tiledListModelApp) {
            int n;
            int n2 = n = bl ? 0 : 1;
            if (choiceModelApp.getStatus() != n) {
                choiceModelApp.setStatus(n);
                if (bl) {
                    tiledListModelApp.fireEvent(-1);
                }
            }
        } else {
            this.getLog().log(100000, "ModelFileBrowser.showBusyCursor(): list=%1 or choice=%2 is null! can't activate busy cursor!", (Object)tiledListModelApp, (Object)choiceModelApp);
        }
    }

    private final void updateDirectoryHistory(Path path, int n) {
        String string = path.getMountPoint().concat("/");
        int n2 = path.folderNames.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            string = string.concat(path.folderNames[i2]).concat("/");
        }
        if (n < 0) {
            this.getLog().log(10000000, "[TiledModelFileBrowser].updateDirectoryHistory(): Removing history for path=%1", (Object)string);
            this.directoryHistory.remove(string);
        } else {
            this.getLog().log(10000000, "[TiledModelFileBrowser].updateDirectoryHistory(): Adding to history index=%2, path=%1", (Object)string, (long)n);
            this.directoryHistory.put(string, new Integer(n));
        }
    }

    private final int getDirectoryHistoryIndex(Path path) {
        int n = -1;
        String string = path.getMountPoint().concat("/");
        int n2 = path.folderNames.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            string = string.concat(path.folderNames[i2]).concat("/");
        }
        Integer n3 = (Integer)this.directoryHistory.get(string);
        if (null != n3) {
            n = n3;
        }
        this.getLog().log(10000000, "[TiledModelFileBrowser].getDirectoryHistoryIndex(): index=%2, path=%1", (Object)string, (long)n);
        return n;
    }

    private final void chdir(Path path) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1000000, "[TiledModelFileBrowser] -> changeFolder(%2,%1)", (Object)path, (long)this.getSession());
            this.focusedRow = null;
            this.setAllFilesSelectedFlag(false);
            this.showBusyCursor(true);
            dSIFileBrowser.changeFolder(this.getSession(), path);
        }
    }

    private boolean isOnTopLevel(Path path) {
        return path.getFolderNames().length == 0;
    }

    public final boolean chdirUp() {
        Path path = this.pwd();
        if (this.isOnTopLevel(path)) {
            return false;
        }
        this.updateDirectoryHistory(path, -1);
        this.chdir(this.cdPath(path, DIR_UP));
        return true;
    }

    private final void getFiles(int n, int n2) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            if (!this.registerItemsRequest(-1)) {
                this.getLogDSI().log(100000, "[TiledModelFileBrowser].getFiles(%1,%2,%3): Could not register item request!", (long)this.getSession(), (long)n, (long)n2);
                return;
            }
            this.getLogDSI().log(1000000, "-> getViewWindow(%1,%2,%3)", (long)this.getSession(), (long)n, (long)n2);
            dSIFileBrowser.getViewWindow(this.getSession(), n2, n);
        }
    }

    private final void getFiles(BrowsedFile browsedFile, int n, int n2) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            if (!this.registerItemsRequest(-1)) {
                this.getLogDSI().log(100000, "[TiledModelFileBrowser].getFiles(%1,%2,%3): Could not register item request!", (Object)browsedFile, (long)this.getSession(), (long)n);
                return;
            }
            this.getLogDSI().log(1000000, "-> getViewWindowFromFile(%1,%2,%3,%4)", (Object)browsedFile, (Object)new Integer(this.getSession()), (Object)new Integer(n), (Object)new Integer(n2));
            this.getViewWindowFromFile(this.getSession(), n2, browsedFile, n);
        }
    }

    private final void refreshPreview() {
        this.refreshPreviewFlag = true;
        this.getFiles(0, 25);
    }

    private final void selectFile(BrowsedFile browsedFile, boolean bl) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1000000, "-> setSelectionSingle(%3,%1,%2)", (Object)browsedFile, bl ? 1L : 0L, (long)this.getSession());
            dSIFileBrowser.setSelectionSingle(this.getSession(), browsedFile, bl);
        }
        browsedFile.setSelected(bl);
    }

    private final void selectAll(boolean bl) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1000000, "-> setSelection(%2,%1)", bl, (long)this.getSession());
            dSIFileBrowser.setSelection(this.getSession(), bl ? 0 : 1);
        }
    }

    private final void addSpellerChars(String string) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1000000, "-> addSpellerChars(%2,%1)", (Object)string, (long)this.getSession());
            dSIFileBrowser.addSpellerChars(this.getSession(), string);
        }
    }

    private final void removeSpellerChar() {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1000000, "-> removeSpellerChar(%1)", (long)this.getSession());
            dSIFileBrowser.removeSpellerChar(this.getSession());
        }
    }

    private final void validateSpellerChars(String string) {
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.getLogDSI().log(1000000, "-> validateSpellerChars(%2,%1)", (Object)string, (long)this.getSession());
            dSIFileBrowser.validateSpellerChars(this.getSession(), string);
        }
    }

    public int getFileCount() {
        return this.totalEntryCount;
    }

    public synchronized ResourceLocator[] getResourceLocators(int n, int n2) {
        this.resultResources = null;
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (dSIFileBrowser != null) {
            this.responded = false;
            this.getLogDSI().log(1000000, "-> getResourceLocatorWindow(%1,%2,%3)", (long)this.getSession(), (long)n, (long)n2);
            dSIFileBrowser.getResourceLocatorWindow(this.getSession(), n2, n);
            try {
                this.wait(20000L);
                if (!this.responded) {
                    this.getLog().log(10000, "getResourceLocatorWindow( %1, %2, %3 ) timed out!", (long)this.getSession(), (long)n, (long)n2);
                }
            }
            catch (Exception exception) {
                this.getLog().log(10000, "getResourceLocatorWindow( %1, %2, %3 ) failed!", (long)this.getSession(), (long)n, (long)n2);
                this.getLog().log(10000, "Exception: ", (Throwable)exception);
            }
        }
        return this.resultResources;
    }

    public void importSpellerActive(boolean bl) {
        if (this.spellerHandler != null) {
            this.getLog().log(1000000, "[TiledModelFileBrowser].importSpellerActive(%1)", bl);
            this.spellerHandler.setActive(bl);
        }
    }

    public void changeFolderResult(int n, int n2, Path path) {
        if (0 == n2 && n == this.getSession()) {
            this.setCurrentPath(path);
            LabelModelApp labelModelApp = this.getPathLabel();
            if (labelModelApp != null) {
                labelModelApp.setText(this.showFullPath() ? this.path2String(this.pwd()) : this.cwd2String(this.pwd()));
            }
            this.getDSI().getFileCount(this.getSession());
            this.getFileCountWithFileTypeFilter(this.getSession(), 1);
            this.enableImportButton(this.getImportButton(), 0);
            TiledListModelApp tiledListModelApp = this.getListModel();
            if (tiledListModelApp != null) {
                this.chdirResetFocusedRow = true;
                this.rebuildListFromStart();
            }
        }
    }

    public void getFileCountResult(int n, int n2, int n3) {
        this.getLogDSI().log(1000000, "[TiledModelFileBrowser] <- getFileCountResult(%1,%2,%3)", (long)n, (long)n2, (long)n3);
        if (0 == n2 && n == this.getSession()) {
            this.totalFileCount = n3;
        }
    }

    public void getFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
        this.getLogDSI().log(1000000, "[TiledModelFileBrowser] <- getFileCountWithFileTypeFilterResult(%1,%2,%3)", (long)n, (long)n2, (long)n4);
        if (0 == n2 && n == this.getSession()) {
            ChoiceModelApp choiceModelApp;
            this.totalFileCount = n4;
            ChoiceModelApp choiceModelApp2 = this.getNoFilesAvailable();
            if (null != choiceModelApp2) {
                if (0 == this.totalFileCount) {
                    choiceModelApp2.setValue(1);
                } else {
                    choiceModelApp2.setValue(0);
                }
            }
            if (null != (choiceModelApp = this.getSearchButtonDisableChoice())) {
                if (0 == this.totalFileCount) {
                    choiceModelApp.setValue(1);
                } else {
                    choiceModelApp.setValue(0);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void getResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        ModelFileBrowser modelFileBrowser = this;
        synchronized (modelFileBrowser) {
            if (0 == n2 && n == this.getSession()) {
                this.responded = true;
                this.resultResources = resourceLocatorArray;
                this.totalEntryCount = n4;
            }
            this.notifyAll();
        }
    }

    protected EvoListRow[] getRowsFromFileSet(BrowsedFileSet browsedFileSet, int n) {
        if (null == browsedFileSet) {
            return new EvoListRow[0];
        }
        BrowsedFile[] browsedFileArray = browsedFileSet.getFiles();
        if (null != browsedFileArray && 0 != browsedFileArray.length) {
            EvoListRow[] evoListRowArray = new EvoListRow[browsedFileArray.length];
            for (int i2 = 0; i2 < browsedFileArray.length; ++i2) {
                evoListRowArray[i2] = this.evoRowBuilder.buildRow(browsedFileArray[i2], n + i2);
            }
            return evoListRowArray;
        }
        return new EvoListRow[0];
    }

    public void getViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        TiledListModelApp tiledListModelApp;
        int n5;
        this.getLogDSI().log(1000000, "[TiledModelFileBrowser] <- getViewWindowResult(%1,%2,%3...)", (long)n, (long)n3, (long)n4);
        try {
            n5 = this.deregisterItemsRequest();
        }
        catch (Exception exception) {
            this.getLogDSI().log(100000, "[TiledModelFileBrowser].getViewWindowResult(): failed to get item request id!", (Throwable)exception);
            return;
        }
        TiledListModelApp tiledListModelApp2 = tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
        if (0 != n2) {
            this.getLogDSI().log(1000000, "[TiledModelFileBrowser].getViewWindowResult(): failed result; ignoring item request id %1", (long)n5);
            if (tiledListModelApp != null) {
                tiledListModelApp.setRows(n5, n3, this.getRowsFromFileSet(null, n3));
            }
            return;
        }
        this.totalEntryCount = n4;
        if (tiledListModelApp != null) {
            if (this.isSpellerActive() && this.refreshPreviewFlag) {
                this.getLogDSI().log(1000000, "ModelFileBrowser.getViewWindowResult. Speller is active!");
                this.refreshPreviewFlag = false;
                if (n3 != 0) {
                    this.getLogDSI().log(1000000, "ModelFileBrowser.getViewWindowResult. offset should be 0");
                }
                this.spellerHandler.updatePreview(browsedFileSet, n4);
                this.spellerHandler.updateMatchCount(n4);
            } else {
                int n6;
                tiledListModelApp.setLength(this.totalEntryCount);
                this.getLogDSI().log(10000000, "[TiledModelFileBrowser].getViewWindowResult(): setting rows in list model: requestId=%1, offset=%2", (long)n5, (long)n3);
                tiledListModelApp.setRows(n5, n3, this.getRowsFromFileSet(browsedFileSet, n3));
                if (this.refillForJump) {
                    this.getLogDSI().log(10000000, "[TiledModelFileBrowser].getViewWindowResult(): Refill from jump; pendingFocusedRow=%2; isPendingFocusedRowFromFile=%1", this.isPendingFocusedRowFromFile, (long)this.pendingFocusedRow);
                    this.refillForJump = false;
                    if (this.pendingFocusedRow >= 0) {
                        if (this.isPendingFocusedRowFromFile) {
                            this.pendingFocusedRow += n3;
                        }
                        this.setFocusedRow(this.pendingFocusedRow);
                        this.pendingFocusedRow = -1;
                    }
                }
                if ((n6 = this.getDirectoryHistoryIndex(this.pwd())) >= 0) {
                    this.getLogDSI().log(1000000, "[ModelFileBrowser].getViewWindowResult(): directory changed and in history - setting focused row to %1", (long)n6);
                    this.chdirResetFocusedRow = false;
                    this.updateDirectoryHistory(this.pwd(), -1);
                    this.jumpToEntry(n6);
                } else if (this.chdirResetFocusedRow) {
                    this.getLogDSI().log(1000000, "[ModelFileBrowser].getViewWindowResult(): directory changed and not in history - setting focused row to 0");
                    this.chdirResetFocusedRow = false;
                    this.setFocusedRow(0);
                }
                ChoiceModelApp choiceModelApp = this.getRootFolderReachedModel();
                if (choiceModelApp != null) {
                    choiceModelApp.setValue(browsedFileSet.getPath().getFolderNames().length == 0 ? 1 : 0);
                }
            }
            this.showBusyCursor(false);
        }
    }

    private final void enableImportButton(ButtonModelApp buttonModelApp, int n) {
        if (buttonModelApp != null) {
            buttonModelApp.setStatus(n);
        }
    }

    public void indicateSelectionResult(int n, int n2, int n3) {
        if (0 == n2 && n == this.getSession()) {
            this.selectedFileCount = n3;
            this.enableImportButton(this.getImportButton(), n3 > 0 ? 1 : 0);
            boolean bl = this.selectedFileCount >= this.totalFileCount && this.selectedFileCount > 0;
            this.setAllFilesSelectedFlag(bl);
            if (this.isWaitingForSelectAll) {
                this.isWaitingForSelectAll = false;
                this.selectAllFiles(bl);
            }
        }
    }

    public void setFileExtensionFilterResult(int n, int n2) {
        this.getLogDSI().log(10000000, "[TiledModelFileBrowser] <- setFileExtensionFilterResult(%1,%2)", (long)n, (long)n2);
        TiledListModelApp tiledListModelApp = this.getListModel();
        if (tiledListModelApp != null) {
            this.rebuildListFromStart();
        }
    }

    public void setFileTypeFilterResult(int n, int n2) {
        TiledListModelApp tiledListModelApp = this.getListModel();
        if (tiledListModelApp != null) {
            this.rebuildListFromStart();
        }
    }

    public void spellerResult(int n, int n2, String string, String string2) {
        if (this.spellerHandler != null) {
            this.spellerHandler.spellerResult(string, string2);
        }
    }

    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        if (this.spellerHandler != null) {
            this.spellerHandler.setValidNonAlphaNumTPCharacters(string2);
        }
    }

    private void rebuildListFromStart() {
        TiledListModelApp tiledListModelApp;
        this.showBusyCursor(true);
        TiledListModelApp tiledListModelApp2 = tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
        if (null != tiledListModelApp) {
            tiledListModelApp.removeAll();
            tiledListModelApp.setSelectedIndex(-1);
        }
        this.getFiles(0, 25);
    }

    private void toggleSelection(AbstractEvoFileListRow abstractEvoFileListRow, TiledListModelApp tiledListModelApp, TiledListModelApp tiledListModelApp2) {
        if (abstractEvoFileListRow != null) {
            this.getLog().log(1000000, "[TiledModelFileBrowser].toggleSelection(%1)", (Object)abstractEvoFileListRow);
            BrowsedFile browsedFile = abstractEvoFileListRow.getBrowsedFile();
            if (!abstractEvoFileListRow.isFolder() && (this.modelAccess == null || this.modelAccess.fileSelected(abstractEvoFileListRow.getOffset(), browsedFile))) {
                boolean bl = !browsedFile.isSelected();
                this.getLog().log(1000000, "[TiledModelFileBrowser].toggleSelection(): newState=%1", bl);
                this.selectFile(browsedFile, bl);
                abstractEvoFileListRow.setSelected(bl);
                tiledListModelApp.setRow(abstractEvoFileListRow.getOffset(), abstractEvoFileListRow);
                if (null != tiledListModelApp2) {
                    tiledListModelApp2.setRow(tiledListModelApp2.getIndexForUniqueID(abstractEvoFileListRow.getUniqueID()), abstractEvoFileListRow);
                }
            }
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.getLog().log(10000000, "[TiledModelFileBrowser].itemReleased(%2,%3,%4...)", (Object)evoListRow, (long)n, (long)n2);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.getLog().log(10000000, "[TiledModelFileBrowser].itemSelected(%1,%2...)", (Object)evoListRow, (long)n2);
        if (null != evoListRow) {
            AbstractEvoFileListRow abstractEvoFileListRow = (AbstractEvoFileListRow)evoListRow;
            BrowsedFile browsedFile = abstractEvoFileListRow.getBrowsedFile();
            if (abstractEvoFileListRow.isFolder()) {
                Path path = this.pwd();
                if (DIR_UP.equals(browsedFile.getFilename())) {
                    this.chdirUp();
                } else if (!DIR_CURRENT.equals(browsedFile.getFilename())) {
                    this.updateDirectoryHistory(path, abstractEvoFileListRow.getOffset());
                    this.chdir(this.cdPath(path, browsedFile.getFilename()));
                }
            } else {
                TiledListModelApp tiledListModelApp = this.getListModel();
                if (null != tiledListModelApp) {
                    TiledListModelApp tiledListModelApp2 = this.isSpellerActive() ? this.getSearchFilteredList() : null;
                    this.toggleSelection(abstractEvoFileListRow, tiledListModelApp, tiledListModelApp2);
                }
            }
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.getLog().log(10000000, "[TiledModelFileBrowser].itemFocused(%1, %2)", (Object)evoListRow, (long)n2);
        this.focusedRow = (AbstractEvoFileListRow)evoListRow;
        if (null != this.modelAccess) {
            ChoiceModelApp choiceModelApp = this.modelAccess.getFileFocused();
            if (null != this.focusedRow) {
                this.modelAccess.fileFocused(this.focusedRow.getOffset(), this.focusedRow.getBrowsedFile());
            }
            if (null != choiceModelApp) {
                choiceModelApp.setValue(null == this.focusedRow || this.focusedRow.isFolder() ? 0 : 1);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean registerItemsRequest(int n) {
        IntList intList = this.itemRequestIds;
        synchronized (intList) {
            if (64 > this.itemRequestIds.size()) {
                this.itemRequestIds.add(n);
                return true;
            }
            this.getLog().log(100000, "[TiledModelFileBrowser].registerItemsRequest(%1): maximum concurrent item requests exceeded!");
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int deregisterItemsRequest() {
        IntList intList = this.itemRequestIds;
        synchronized (intList) {
            int n;
            try {
                n = this.itemRequestIds.get(0);
                this.itemRequestIds.remove(0);
            }
            catch (Throwable throwable) {
                this.itemRequestIds.remove(0);
                throw throwable;
            }
            return n;
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.getLog().log(1000000, "[TiledModelFileBrowser].requestItems(%1,%2,%3...)", (long)n, (long)n2, (long)n3);
        DSIFileBrowser dSIFileBrowser = this.getDSI();
        if (!this.registerItemsRequest(n3)) {
            TiledListModelApp tiledListModelApp;
            TiledListModelApp tiledListModelApp2 = tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
            if (tiledListModelApp != null) {
                tiledListModelApp.setRows(n3, n, this.getRowsFromFileSet(null, n));
            }
            this.getLog().log(100000, "[TiledModelFileBrowser].requestItems(): Maximum number of concurrent item requsts reached!", (long)this.getSession(), (long)n2, (long)n);
            return;
        }
        this.getLogDSI().log(1000000, "[TiledModelFileBrowser] -> getViewWindow(%1,%2,%3)", (long)this.getSession(), (long)n2, (long)n);
        dSIFileBrowser.getViewWindow(this.getSession(), n2, n);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.getLog().log(10000000, "[TiledModelFileBrowser].unrequestItems(%1,%2,%3...)", (long)n, (long)n2, (long)n3);
        TiledListModelApp tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
        this.getLog().log(1000000, "[TiledModelFileBrowser].unrequestItems(): clearing rows startIndex=%1, length=%2", (long)n, (long)n2);
        if (tiledListModelApp != null) {
            tiledListModelApp.clearRows(n, n2);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        TiledListModelApp tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
        ButtonModelApp buttonModelApp = this.getSelectSingleButton();
        ButtonModelApp buttonModelApp2 = this.getSearchButton();
        if (tiledListModelApp != null) {
            if (buttonModelApp != null && n == buttonModelApp.getID()) {
                this.getLog().log(1000000, "[TiledModelFileBrowser].keyPressed(): SelectSingleButton model = %1", (long)n);
                this.toggleSelection(this.focusedRow, tiledListModelApp, null);
            } else if (buttonModelApp2 != null && n == buttonModelApp2.getID()) {
                this.getLog().log(1000000, "SearchButton keyPressed(%1)", (long)n);
                if (this.spellerHandler != null) {
                    buttonModelApp2.fireEvent(n3);
                }
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        TiledListModelApp tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
        ChoiceModelApp choiceModelApp = this.getSelectAllChoice();
        if (tiledListModelApp != null && choiceModelApp != null && n == choiceModelApp.getID()) {
            this.showBusyCursor(true);
            this.getLog().log(1000000, "[TiledModelFileBrowser].itemSelected(): SelectAllButton model = %1", (long)n);
            this.isWaitingForSelectAll = true;
            this.selectAll(!this.allFilesSelected);
        }
    }

    private void selectAllFiles(boolean bl) {
        this.getLogDSI().log(10000000, "[TiledModelFileBrowser].selectAllFiles(%1)", bl);
        TiledListModelApp tiledListModelApp = this.isSpellerActive() ? this.getSearchFilteredList() : this.getListModel();
        EvoListRow[] evoListRowArray = this.getCachedRows(tiledListModelApp);
        for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
            if (null == evoListRowArray[i2]) continue;
            ((AbstractEvoFileListRow)evoListRowArray[i2]).setSelected(bl);
        }
        tiledListModelApp.setRows(-1, 0, evoListRowArray);
        this.showBusyCursor(false);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    final LabelModelApp getPathLabel() {
        return this.modelAccess != null ? this.modelAccess.getPathLabel() : null;
    }

    final boolean showFullPath() {
        return null != this.modelAccess && this.modelAccess.showCwdFullPath();
    }

    final TiledListModelApp getListModel() {
        return this.modelAccess != null ? this.modelAccess.getListModel() : null;
    }

    final ChoiceModelApp getRootReachModel() {
        return this.modelAccess != null ? this.modelAccess.getRootFolderReachedModel() : null;
    }

    final ChoiceModelApp getListModelSelected() {
        return this.modelAccess != null ? this.modelAccess.getListModelSelected() : null;
    }

    final AbstractEvoFileListRow[] getCachedRows(TiledListModelApp tiledListModelApp) {
        if (null != tiledListModelApp) {
            List list = tiledListModelApp.asList();
            return (AbstractEvoFileListRow[])list.toArray(new AbstractEvoFileListRow[list.size()]);
        }
        return new AbstractEvoFileListRow[0];
    }

    final ButtonModelApp getSelectSingleButton() {
        return this.modelAccess != null ? this.modelAccess.getSelectSingleButton() : null;
    }

    final ChoiceModelApp getSelectAllChoice() {
        return this.modelAccess != null ? this.modelAccess.getSelectAllChoice() : null;
    }

    final ButtonModelApp getSearchButton() {
        return this.modelAccess != null ? this.modelAccess.getSearchButton() : null;
    }

    final ChoiceModelApp getSearchButtonDisableChoice() {
        return this.modelAccess != null ? this.modelAccess.getSearchButtonDisableChoice() : null;
    }

    final MatchspellerModelApp getSearchSpeller() {
        return this.modelAccess != null ? this.modelAccess.getSearchSpeller() : null;
    }

    final ListModelApp getSearchPreviewList() {
        return this.modelAccess != null ? this.modelAccess.getSearchPreviewList() : null;
    }

    final ChoiceModelApp getSearchFilteredListSelected() {
        return this.modelAccess != null ? this.modelAccess.getSearchFilteredListSelected() : null;
    }

    final TiledListModelApp getSearchFilteredList() {
        return this.modelAccess != null ? this.modelAccess.getSearchFilteredList() : null;
    }

    final ChoiceModelApp getRootFolderReachedModel() {
        return this.modelAccess != null ? this.modelAccess.getRootFolderReachedModel() : null;
    }

    final ButtonModelApp getImportButton() {
        return this.modelAccess != null ? this.modelAccess.getImportButton() : null;
    }

    final ChoiceModelApp getNoFilesAvailable() {
        return this.modelAccess != null ? this.modelAccess.getNoFilesAvailable() : null;
    }

    private final void setAllFilesSelectedFlag(boolean bl) {
        this.allFilesSelected = bl;
        ChoiceModelApp choiceModelApp = this.getSelectAllChoice();
        if (choiceModelApp != null) {
            choiceModelApp.setValue(bl ? 1 : 0);
        }
    }

    public void startResult(int n, int n2, Path path) {
    }

    public void getResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
    }

    public void getSelectedFilesResult(int n, int n2, int n3) {
    }

    public void getViewWindowWithPreviewsResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, PreviewInfo[] previewInfoArray, int n4) {
    }

    public void createPreviewImageResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
    }

    public void cancelPreviewCreationResult(int n) {
    }

    public void setFileTypeActiveResult(int n) {
    }

    public void setLanguageResult(int n, String string) {
    }

    public void asyncException(int n, String string, int n2) {
        this.getLog().log(10000, "[TiledModelFileBrowser].asyncException(%1,%3,%2)", (Object)String.valueOf(n), (Object)string, (Object)String.valueOf(n2));
        this.isWaitingForSelectAll = false;
    }

    private final class SpellerHandler
    implements MatchspellerListenerAsia {
        private final MatchspellerModelApp speller;
        private final ListModelApp preview;
        private boolean active = false;

        private SpellerHandler(MatchspellerModelApp matchspellerModelApp, ListModelApp listModelApp) {
            this.speller = matchspellerModelApp;
            this.preview = listModelApp;
            listModelApp.setMaxColumns(4);
            matchspellerModelApp.setSpellerListener(this);
            matchspellerModelApp.setMaxLength(128);
        }

        private boolean isActive() {
            return this.active;
        }

        private void setActive(boolean bl) {
            if (bl) {
                this.start();
            } else {
                this.stop();
            }
        }

        private void cleanup() {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.cleanup()");
            this.stop();
            this.speller.setSpellerListener(null);
        }

        private void start() {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.start()");
            this.stop();
            this.active = true;
            this.showBusySpellerCursor(true);
            this.speller.clear();
            this.preview.clear();
            ModelFileBrowser.this.startSpeller();
        }

        private void stop() {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.stop()");
            if (this.isActive()) {
                this.active = false;
                ModelFileBrowser.this.stopSpeller();
                this.showBusySpellerCursor(false);
            }
        }

        private void showBusySpellerCursor(boolean bl) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.showBusyCursor(%1)", bl);
            this.speller.setStatus(bl ? 0 : 1);
            this.preview.setStatus(bl ? 0 : 1);
        }

        private void spellerResult(String string, String string2) {
            ModelFileBrowser.this.getLog().log(1000000, "[ModelFileBrowser#spellerResult] uniqueChars : %1, validChars : %2", (Object)string, (Object)string2);
            if (this.active) {
                this.speller.setText(string);
                this.speller.setValidChars(string2);
                ModelFileBrowser.this.refreshPreview();
            }
        }

        public void keyTyped(int n, int n2, int n3) {
            Object object;
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.keyTyped(%1, %2)", (long)n, (long)n2);
            if (this.speller.getMatchCount() == 1 && (object = this.preview.getCell(0, 3)) != null && object instanceof ObjectListCell) {
                BrowsedFile browsedFile = (BrowsedFile)((ObjectListCell)object).getValue();
                boolean bl = !browsedFile.isSelected();
                ModelFileBrowser.this.selectFile(browsedFile, bl);
                ModelFileBrowser.this.spellerHandler.stop();
                ModelFileBrowser.this.jumpToEntry(browsedFile);
                this.speller.fireEvent(n3);
                return;
            }
            object = ModelFileBrowser.this.getSearchFilteredList();
            if (null != object) {
                object.clearAll();
            }
            ModelFileBrowser.this.rebuildListFromStart();
            this.speller.fireEvent(n3);
        }

        public void textChanged(int n, String string, char c2, int n2) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.textChanged(%1, %2)", (Object)string, (long)c2);
            if (n == this.speller.getID()) {
                if (c2 == '\r') {
                    ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.textChanged: ignore lastest char 13 ( = CR )");
                    return;
                }
                if (string == null || "".equals(string)) {
                    this.start();
                } else if (c2 == '\b') {
                    this.showBusySpellerCursor(true);
                    ModelFileBrowser.this.removeSpellerChar();
                } else {
                    this.showBusySpellerCursor(true);
                    ModelFileBrowser.this.addSpellerChars(new String(new char[]{c2}));
                }
            }
        }

        public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.nonAlphaNumTPCharsChanged(%2, %3, %1)", (Object)string, (long)n, (long)n2);
            ModelFileBrowser.this.validateSpellerChars(string);
        }

        private void updatePreview(BrowsedFileSet browsedFileSet, int n) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.updatePreview(%1, %2)", (Object)browsedFileSet, (long)n);
            this.preview.beginTransaction();
            this.preview.clear();
            BrowsedFile[] browsedFileArray = browsedFileSet.getFiles();
            this.preview.setMaxRows(browsedFileArray.length);
            for (int i2 = 0; i2 < browsedFileArray.length; ++i2) {
                this.preview.addRow(new ListCell[]{IntegerListCell.create(i2), new TextListCell(browsedFileArray[i2].getFilename()), new LongListCell(browsedFileArray[i2].getId()), new ObjectListCell(browsedFileArray[i2])});
            }
            this.preview.endTransaction();
            this.showBusySpellerCursor(false);
        }

        private void updateMatchCount(int n) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.updateMatchCount(%1)", (long)n);
            this.speller.setMatchCount(n);
        }

        private void setValidNonAlphaNumTPCharacters(String string) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.setValidNonAlphaNumTPCharacters( %1 )", (Object)string);
            try {
                ((MatchspellerModelAsiaApp)this.speller).setValidNonAlphaNumTPCharacters(string);
            }
            catch (ClassCastException classCastException) {
                ModelFileBrowser.this.getLog().log(10000, "ModelFileBrowser.SpellerHandler.setValidNonAlphaNumTPCharacters failed! This is no asis speller model!", (Throwable)classCastException);
            }
        }

        public void focusedCharacter(int n, char c2, int n2) {
        }

        public void commandPressed(int n, int n2, int n3) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.commandPressed(%1, %2)", (long)n, (long)n2);
        }

        public void inputModeTPChanged(int n, int n2, int n3) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.inputModeTPChanged(%1, %2, %3)", (long)n, (long)n3, (long)n3);
        }

        public void keyReleased(int n, int n2, int n3) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.keyReleased(%1, %2)", (long)n, (long)n2);
        }

        public void keyPressed(int n, int n2, int n3) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowser.SpellerHandler.keyPressed(%1, %2)", (long)n, (long)n2);
        }

        public void strokesChanged(int n, int n2, String string, char c2) {
            ModelFileBrowser.this.getLog().log(10000000, "ModelFileBrowsers.strokesChanged - modelId=%1, strokes=%2, lastStroke=%3", (Object)String.valueOf(n), (Object)string, (long)c2);
        }

        public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
            ModelFileBrowser.this.getLog().log(10000000, "%ModelFileBrowser.getValidHanziCharsWindow - modelId=%1, offset=%2, windowSize=%3", (Object)String.valueOf(n), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
        }
    }
}

