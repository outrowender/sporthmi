/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBListRow;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.addressbook.core.common.search.organizer.ViewWindowRequestInfo;
import de.audi.app.addressbook.core.common.search.organizer.commands.AddSpellerCharsCommand;
import de.audi.app.addressbook.core.common.search.organizer.commands.AddSpellerStrokeCommand;
import de.audi.app.addressbook.core.common.search.organizer.commands.GetValidHanziCharsWindowCommand;
import de.audi.app.addressbook.core.common.search.organizer.commands.RemoveSpellerCharCommand;
import de.audi.app.addressbook.core.common.search.organizer.commands.StartSpellerCommand;
import de.audi.app.addressbook.core.common.search.organizer.commands.ValidateSpellerCharsCommand;
import de.audi.app.addressbook.core.common.search.organizer.commands.ViewWindowCommand;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;
import org.osgi.framework.BundleContext;

public abstract class AbstractADBOrganizerSearch
implements TiledListModelListener,
SpellerListener,
MatchspellerListenerAsia,
ADBOrganizerSearch {
    protected LogChannel log;
    private TiledListModelApp listModel;
    protected MatchspellerModelApp spellerModel;
    protected ResourceLocatorModelApp contactPicture;
    protected BaseListModelApp indicesListModel;
    protected IndexInformation[] indexInfos;
    protected int currentSearchMode;
    protected volatile int focusedListIndex = -1;
    protected ADBApplication appAdr;
    protected int currentViewType = 0;
    protected int currentSpellerHandle = -1;
    protected HMIModelApp syncModel;
    protected volatile boolean rowIsOpen = false;
    protected volatile long currentlyOpenedRowId;
    protected volatile int currentlyOpenedChildCount;
    private final Object lock = new Object();
    protected static final char BACKSPACE = '\b';
    private volatile boolean cursorPositioningOnListUpdatesEnabled = true;

    public AbstractADBOrganizerSearch(TiledListModelApp tiledListModelApp, MatchspellerModelApp matchspellerModelApp, ResourceLocatorModelApp resourceLocatorModelApp, HMIModelApp hMIModelApp, ADBApplication aDBApplication, LogChannel logChannel) {
        this(tiledListModelApp, matchspellerModelApp, resourceLocatorModelApp, null, hMIModelApp, aDBApplication, logChannel);
    }

    public AbstractADBOrganizerSearch(TiledListModelApp tiledListModelApp, MatchspellerModelApp matchspellerModelApp, ResourceLocatorModelApp resourceLocatorModelApp, BaseListModelApp baseListModelApp, HMIModelApp hMIModelApp, ADBApplication aDBApplication, LogChannel logChannel) {
        this.listModel = tiledListModelApp;
        this.spellerModel = matchspellerModelApp;
        this.contactPicture = resourceLocatorModelApp;
        this.indicesListModel = baseListModelApp;
        this.syncModel = hMIModelApp;
        this.appAdr = aDBApplication;
        this.log = logChannel;
        tiledListModelApp.setListener(this);
        if (matchspellerModelApp != null) {
            matchspellerModelApp.setMaxLength(64);
            if (aDBApplication.getFramework().isAsia()) {
                matchspellerModelApp.setSpellerListenerAsia(this);
                this.currentSearchMode = 1;
            } else {
                matchspellerModelApp.setSpellerListener(this);
                this.currentSearchMode = 0;
            }
        }
    }

    public AbstractADBOrganizerSearch(TiledListModelApp tiledListModelApp, HMIModelApp hMIModelApp, ADBApplication aDBApplication, LogChannel logChannel) {
        this(tiledListModelApp, null, null, hMIModelApp, aDBApplication, logChannel);
    }

    protected void setViewType(int n) {
        this.currentViewType = n;
        this.updateCurrentIndex();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int getListLength() {
        Object object = this.lock;
        synchronized (object) {
            return this.listModel.getLength();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int calculateAdbPositionFromListIndex(int n) {
        int n2 = n <= 0 ? 0 : n;
        Object object = this.lock;
        synchronized (object) {
            int n3;
            int n4 = n3 = this.rowIsOpen ? this.listModel.getIndexForUniqueID(this.currentlyOpenedRowId) : 0;
            if (this.rowIsOpen && n3 < n2) {
                n2 -= this.currentlyOpenedChildCount;
            }
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected EvoListRow getRow(int n) {
        Object object = this.lock;
        synchronized (object) {
            return this.listModel.getRow(n);
        }
    }

    public int getCurrentSpellerHandle() {
        return this.currentSpellerHandle;
    }

    public void enableCusorPositioningOnListUpdates(boolean bl) {
        this.cursorPositioningOnListUpdatesEnabled = bl;
    }

    public void init() {
    }

    public void deinit(BundleContext bundleContext) {
    }

    public void startSearch() {
        this.log.log(1000000, "AbstractADBOrganizerSearch#startSearch()");
        this.resetState();
        if (this.spellerModel != null) {
            this.startSpeller();
        } else {
            this.refreshFromStart();
        }
    }

    protected void startSpeller() {
        this.log.log(1000000, "AbstractADBOrganizerSearch#startSpeller(): viewType: %1", (Object)ADBDbgUtils.dbgViewType(this.currentViewType));
        this.spellerModel.clear();
        StartSpellerCommand.createStartSpellerCommand(this.appAdr, this, this.currentViewType, 1, this.currentSearchMode);
    }

    private void resetState() {
        this.log.log(1000000, "AbstractADBOrganizerSearch#resetState()");
        this.rowIsOpen = false;
    }

    public void refresh() {
        long l = this.appAdr.getFocusedEntryId();
        this.log.log(1000000, "AbstractADBOrganizerSearch#refresh(): focusedEntryId: %1", l);
        if (l == 0L) {
            this.refreshFromStart();
        } else {
            this.refreshByEntryId(l);
        }
    }

    public void refreshByEntryId(long l) {
        this.log.log(1000000, "AbstractADBOrganizerSearch#refreshByEntryId(): entryId: %1", l);
        ViewWindowRequestInfo viewWindowRequestInfo = new ViewWindowRequestInfo(l, this.currentViewType, this.currentSpellerHandle, true);
        ViewWindowCommand.createViewWindowCommand(this.appAdr, viewWindowRequestInfo, this);
    }

    public void refreshFromStart() {
        this.log.log(1000000, "AbstractADBOrganizerSearch#refreshFromStart()");
        ViewWindowRequestInfo viewWindowRequestInfo = new ViewWindowRequestInfo(0, this.currentViewType, this.currentSpellerHandle, true, true);
        ViewWindowCommand.createViewWindowCommand(this.appAdr, viewWindowRequestInfo, this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshByPosition() {
        int n;
        Object object = this.lock;
        synchronized (object) {
            n = this.calculateAdbPositionFromListIndex(this.focusedListIndex);
        }
        this.log.log(1000000, "AbstractADBOrganizerSearch#refreshByPosition(): adbListPosition: %1", (long)n);
        object = new ViewWindowRequestInfo(n, this.currentViewType, this.currentSpellerHandle, true, false);
        ViewWindowCommand.createViewWindowCommand(this.appAdr, (ViewWindowRequestInfo)object, this);
    }

    public void enableFiltering(boolean bl) {
        if (bl) {
            switch (this.appAdr.getAdbMode()) {
                case 0: {
                    this.setViewType(1);
                    break;
                }
                case 1: {
                    this.setViewType(2);
                    break;
                }
                case 2: {
                    this.setViewType(16);
                    break;
                }
            }
        } else {
            this.setViewType(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateRow(EvoListRow evoListRow) {
        Object object = this.lock;
        synchronized (object) {
            int n = this.listModel.getIndexForUniqueID(evoListRow.getUniqueID());
            if (n != -1) {
                this.listModel.setRow(n, evoListRow);
            } else {
                this.log.log(10000, "AbstractADBOrganizerSearch#updateRow(): row could not be found in list model: %1", (Object)evoListRow);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateList(DataSet[] dataSetArray, ViewWindowRequestInfo viewWindowRequestInfo) {
        EvoListRow[] evoListRowArray = this.createSearchListRows(dataSetArray);
        Object object = this.lock;
        synchronized (object) {
            int n;
            BaseListModelApp baseListModelApp = this.listModel.getCopy();
            if (viewWindowRequestInfo.isClearListOnUpdate()) {
                baseListModelApp.removeAll();
                this.resetState();
            }
            int n2 = this.rowIsOpen ? viewWindowRequestInfo.getTotalEntries() + this.currentlyOpenedChildCount : viewWindowRequestInfo.getTotalEntries();
            baseListModelApp.setLength(n2);
            int n3 = this.rowIsOpen ? baseListModelApp.getIndexForUniqueID(this.currentlyOpenedRowId) : 0;
            int n4 = n = dataSetArray != null && dataSetArray.length > 0 ? dataSetArray[0].getEntryPosition() : 0;
            if (this.rowIsOpen && n3 < n) {
                n += this.currentlyOpenedChildCount;
            }
            this.log.log(1000000, "AbstractADBOrganizerSearch#updateList(): listUpdateIndex: %1, rows.length: %2", (long)n, evoListRowArray != null ? (long)evoListRowArray.length : -1L);
            baseListModelApp.setRows(viewWindowRequestInfo.getRequestId(), n, evoListRowArray);
            ModelGroup modelGroup = new ModelGroup();
            modelGroup.add(this.listModel);
            this.listModel.update(baseListModelApp);
            MenuModelApp menuModelApp = this.listModel.getMenu();
            if (menuModelApp != null && this.cursorPositioningOnListUpdatesEnabled) {
                modelGroup.add(menuModelApp);
                this.updateCursorPos(viewWindowRequestInfo, menuModelApp, evoListRowArray);
            } else {
                this.log.log(100000, "AbstractADBOrganizerSearch#updateList(): no menu model available, not able to control the cursor position.");
            }
            modelGroup.flush();
            modelGroup.removeAll();
        }
    }

    private void updateCursorPos(ViewWindowRequestInfo viewWindowRequestInfo, MenuModelApp menuModelApp, EvoListRow[] evoListRowArray) {
        if (viewWindowRequestInfo.isResetCursorOnUpdate()) {
            this.log.log(1000000, "AbstractADBOrganizerSearch#updateCursorPos(): triggering cursor pos reset");
            menuModelApp.resetFocusedItem();
            menuModelApp.trigger(ModelTrigger.RESET_CURSOR_POS);
        } else if (evoListRowArray != null && evoListRowArray.length > 0 && viewWindowRequestInfo.isClearListOnUpdate()) {
            this.log.log(1000000, "AbstractADBOrganizerSearch#updateCursorPos(): setting focused menu item to anchor list row");
            EvoListRow evoListRow = evoListRowArray[0];
            if (viewWindowRequestInfo.getMovement() == 3) {
                for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                    if (((ADBListRow)((Object)evoListRowArray[i2])).getEntryId() != viewWindowRequestInfo.getRefEntryId()) continue;
                    evoListRow = evoListRowArray[i2];
                    break;
                }
            }
            this.log.log(1000000, "AbstractADBOrganizerSearch#updateCursorPos(): refEntryId: %1, anchorRow.entryId: %2, anchorRow.uniqueId: %3", viewWindowRequestInfo.getRefEntryId(), ((ADBListRow)((Object)evoListRow)).getEntryId(), evoListRow.getUniqueID());
            menuModelApp.setFocusedItem(this.listModel.getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSearchResultDetails(ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray, ADBSearchListRow aDBSearchListRow) {
        Object object = this.lock;
        synchronized (object) {
            if (aDBSearchListRow != null && this.listModel.getIndexForUniqueID(aDBSearchListRow.getUniqueID()) == -1) {
                this.log.log(100000, "AbstractADBOrganizerSearch#setSearchResultDetails(): parentRow couldn't be found in listModel.");
                return;
            }
            if (aDBEntryDetailsListRowArray != null && aDBEntryDetailsListRowArray.length != 0 && aDBSearchListRow != null) {
                this.log.log(1000000, "AbstractADBOrganizerSearch#setSearchResultDetails(): entryDetails.length: %1, parentRow.getEntryId(): %2", (long)aDBEntryDetailsListRowArray.length, aDBSearchListRow.getEntryId());
                BaseListModelApp baseListModelApp = this.listModel.getCopy();
                if (this.rowIsOpen) {
                    baseListModelApp.removeAndClose(this.currentlyOpenedRowId, this.currentlyOpenedChildCount);
                    EvoListRow evoListRow = baseListModelApp.getRowByUniqueID(this.currentlyOpenedRowId);
                    if (evoListRow != null) {
                        this.setRowOpenState(evoListRow, false, baseListModelApp);
                    }
                }
                baseListModelApp.insertAfterAndOpen(aDBSearchListRow.getUniqueID(), aDBEntryDetailsListRowArray);
                this.setRowOpenState((EvoListRow)((Object)aDBSearchListRow), true, baseListModelApp);
                this.rowIsOpen = true;
                this.currentlyOpenedRowId = aDBSearchListRow.getUniqueID();
                this.currentlyOpenedChildCount = aDBEntryDetailsListRowArray.length;
                this.listModel.update(baseListModelApp);
            } else {
                this.log.log(10000, "AbstractADBOrganizerSearch#setSearchResultDetails(): either entryDetails or parentRow is null: entryDetails: %1, parentRow: %2", (Object)aDBEntryDetailsListRowArray, (Object)aDBSearchListRow);
            }
        }
    }

    public void setRowOpenState(EvoListRow evoListRow, boolean bl, BaseListModelApp baseListModelApp) {
    }

    public void spellerResult(int n, DataSet[] dataSetArray, int n2, String string, String string2) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "AbstractADBOrganizerSearch#spellerResult(): validChars: %1, uniqueChars: %2, totalHits: %3", (Object)string, (Object)string2, (long)n2);
            this.log.log(10000000, "AbstractADBOrganizerSearch#spellerResult(): previewListData: %1", (Object)ADBDbgUtils.dbg(dataSetArray));
        }
        this.currentSpellerHandle = n;
        this.spellerModel.setText(string2);
        this.spellerModel.setValidChars(string);
        this.spellerModel.setMatchCount(n2);
        this.refreshFromStart();
    }

    public void validateSpellerCharsResult(String string) {
        this.log.log(1000000, "AbstractADBOrganizerSearch#validateSpellerCharsResult(): validChars: %1", (Object)string);
        this.spellerModel.setValidNonAlphaNumTPCharacters(string);
    }

    public void setValidHanziChars(String string, int n) {
        this.log.log(1000000, "AbstractADBOrganizerSearch#setValidHanziChars(): validHanziChars: %1, totalCount: %2", (Object)string, (long)n);
        this.spellerModel.setValidHanziChars(string, n);
    }

    public HMIModelApp getListSyncModel() {
        return this.syncModel;
    }

    public MatchspellerModelApp getSpellerModel() {
        return this.spellerModel;
    }

    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray) {
        this.log.log(10000000, "AbstractADBOrganizerSearch#updateAlphabeticalIndex(): updating indices");
        this.indexInfos = indexInformationArray;
        this.updateCurrentIndex();
    }

    private void updateCurrentIndex() {
        if (this.indicesListModel != null) {
            ADBModelUtils.fillIndices(this.indexInfos, this.indicesListModel, this.currentViewType);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Object object = this.lock;
        synchronized (object) {
            if (evoListRow != null && evoListRow instanceof ADBSearchListRow) {
                ADBSearchListRow aDBSearchListRow = (ADBSearchListRow)((Object)evoListRow);
                this.log.log(10000000, "AbstractADBOrganizerSearch#itemSelected( ADBSearchListRow ): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
                if (this.rowIsOpen && evoListRow.getUniqueID() == this.currentlyOpenedRowId) {
                    BaseListModelApp baseListModelApp = this.listModel.getCopy();
                    baseListModelApp.removeAndClose(this.currentlyOpenedRowId, this.currentlyOpenedChildCount);
                    this.setRowOpenState(evoListRow, false, baseListModelApp);
                    this.rowIsOpen = false;
                    this.listModel.update(baseListModelApp);
                } else {
                    this.appAdr.entrySelected(this, aDBSearchListRow, n, n4);
                }
            } else if (evoListRow != null && evoListRow instanceof ADBEntryDetailsListRow) {
                this.log.log(10000000, "AbstractADBOrganizerSearch#itemSelected( ADBEntryDetailsListRow ): row: %1", (Object)evoListRow);
                this.appAdr.detailsSelected((ADBEntryDetailsListRow)evoListRow, n, n4);
            } else {
                this.log.log(10000, "AbstractADBOrganizerSearch#itemSelected(): row is null or has an unknown type!");
            }
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.focusedListIndex = n2;
        if (evoListRow != null && evoListRow instanceof ADBListRow) {
            ADBListRow aDBListRow = (ADBListRow)((Object)evoListRow);
            this.log.log(1000000, "AbstractADBOrganizerSearch#itemFocused(): \"%1\", entryId: %2", (Object)aDBListRow.getCombinedName(), aDBListRow.getEntryId());
            this.appAdr.setFocusedEntryId(aDBListRow.getEntryId());
            this.appAdr.setFocusedEntryType(aDBListRow.getEntryType());
            if (this.contactPicture != null) {
                ADBModelUtils.updatePicture(aDBListRow.getContactPicture(), this.contactPicture, this.log);
            }
        } else {
            this.log.log(10000, "AbstractADBOrganizerSearch#itemFocused(): row is null or has an unknown type!");
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.log.log(10000000, "AbstractADBOrganizerSearch#requestItems(): startIndex: %1, length: %2", (long)n, (long)n2);
        ViewWindowRequestInfo viewWindowRequestInfo = new ViewWindowRequestInfo(n3, this.calculateAdbPositionFromListIndex(n), this.currentViewType, this.currentSpellerHandle, n2);
        ViewWindowCommand.createViewWindowCommand(this.appAdr, viewWindowRequestInfo, this);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.log.log(10000000, "AbstractADBOrganizerSearch#textChanged(): id: %2, text: %1, latestChar: %3", (Object)string, (long)n, (long)c2);
        if ("".equals(string)) {
            this.startSpeller();
        } else if (c2 == '\b') {
            RemoveSpellerCharCommand.createRemoveSpellerCharCommand(this.appAdr, this, this.currentSpellerHandle);
        } else {
            AddSpellerCharsCommand.createAddSpellerCharsCommand(this.appAdr, this, this.currentSpellerHandle, new String(new char[]{c2}));
        }
    }

    public void strokesChanged(int n, int n2, String string, char c2) {
        this.log.log(1000000, "AbstractADBOrganizerSearch#strokesChanged(): strokes: %1, lastStroke: %2", (Object)string, (long)c2);
        if (c2 == '\b') {
            RemoveSpellerCharCommand.createRemoveSpellerCharCommand(this.appAdr, this, this.currentSpellerHandle);
        } else {
            AddSpellerStrokeCommand.createAddSpellerStrokeCommand(this.appAdr, this, this.currentSpellerHandle, new String(new char[]{c2}));
        }
    }

    public void inputModeTPChanged(int n, int n2, int n3) {
        this.log.log(10000000, "AbstractADBOrganizerSearch#inputModeTPChanged(): modelID: %1, mode: %2", (long)n, (long)n2);
        this.currentSearchMode = n2 == 0 ? 1 : 0;
        this.startSpeller();
    }

    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
        ValidateSpellerCharsCommand.createValidateSpellerCharsCommand(this.appAdr, this, this.currentSpellerHandle, string, (HMIModel)((Object)this.spellerModel));
    }

    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
        GetValidHanziCharsWindowCommand.createGetValidHanziCharsWindowCommand(this.appAdr, this, this.currentSpellerHandle, n3, n4);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }
}

