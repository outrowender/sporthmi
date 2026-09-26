/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.browser.NullBrowseListContextImpl;
import de.audi.app.media.content.media.AbstractMediaBrowserListRow;
import de.audi.app.media.content.media.AbstractMediaListRow;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.ListRequest;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.CharacterInfo;

public abstract class AbstractMediaBrowserList
extends AbstractMediaTerminalComponent
implements IBrowseListListener,
TiledListModelListener {
    private static final String LOGCLASS;
    private static final int LIST_REQUEST_CLIENT_BROWSER_ID_MAIN;
    private static final NullBrowseListContextImpl INVALID_BROWSE_LIST_CONTEXT;
    protected final LogChannel logChannel;
    private final ModelGroup browserModelGroup;
    private final Object browserListMutex = new Object();
    private final int WINDOW_RADIUS;
    private volatile MediaListEntry[] previousBrowsingFolder = IBrowseListContext.EMPTY_BROWSE_FOLDER;
    private volatile MediaListEntry folderChangeFocus;
    protected volatile boolean waitingForListAfterFolderChange;
    private AbstractMediaBrowserListRow currentFocusedRow;
    private volatile int rootLevelStackLength = 1;
    private volatile IBrowseListContext browseListContext = INVALID_BROWSE_LIST_CONTEXT;
    protected static final ListRequest NO_WIDGET_REQUEST;
    protected static final int NO_FOCUS_INDEX;
    protected volatile ListRequest listRequest = NO_WIDGET_REQUEST;
    private boolean clearListRequested = false;

    public AbstractMediaBrowserList(IMediaTerminal iMediaTerminal, LogChannel logChannel) {
        super(iMediaTerminal);
        this.logChannel = logChannel;
        this.browserModelGroup = new ModelGroup();
        this.WINDOW_RADIUS = 20;
    }

    protected abstract AbstractMediaBrowserListRow createListRow(MediaListEntry mediaListEntry, int n) {
    }

    protected abstract TiledListModelApp getList() {
    }

    protected abstract ChoiceModelApp getListStatusChoice() {
    }

    protected abstract ChoiceModelApp getTitleSelectedModel() {
    }

    protected abstract ChoiceModelApp getPlayableFilesAvailableModel() {
    }

    protected ChoiceModelApp getSDSPlayableFilesAvailableModel() {
        return null;
    }

    protected abstract AbstractMediaBrowserListRow fillList(AbstractMediaBrowserListRow[] abstractMediaBrowserListRowArray, int n) {
    }

    protected abstract IProgressIndication getListProgressIndicationHandler() {
    }

    public void init() {
        this.logChannel.log(1078071040, "[%1.init]", (Object)"AbstractMediaBrowserList");
        this.getModelGroup().add(this.getPlayableFilesAvailableModel());
        this.getModelGroup().add(this.getList());
        this.getModelGroup().add(this.getList().getMenu());
    }

    public void deinit() {
        this.logChannel.log(1078071040, "[%1.deinit]", (Object)"AbstractMediaBrowserList");
        this.getModelGroup().removeAll();
    }

    public void activate(IBrowseListContext iBrowseListContext) {
        this.logChannel.log(1078071040, "[%1.activate]", (Object)"AbstractMediaBrowserList");
        this.browseListContext = iBrowseListContext;
        this.previousBrowsingFolder = IBrowseListContext.EMPTY_BROWSE_FOLDER;
        this.resetBrowseFolderData();
        this.resetList();
        this.browseListContext.addBrowseListListener(this, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void resetList() {
        this.logChannel.log(1078071040, "[%1.resetList]", (Object)"AbstractMediaBrowserList");
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            ChoiceModelApp choiceModelApp;
            TiledListModelApp tiledListModelApp = this.getList();
            this.clearListRequested = true;
            ChoiceModelApp choiceModelApp2 = this.getListStatusChoice();
            if (null != choiceModelApp2) {
                choiceModelApp2.setStatus(0);
            }
            if (null != (choiceModelApp = this.getTitleSelectedModel())) {
                choiceModelApp.setValue(0);
            }
            tiledListModelApp.setStatus(0);
            this.currentFocusedRow = null;
        }
        this.waitingForListAfterFolderChange = false;
        this.discardListRequest();
        this.setRootLevelStackLength(1);
    }

    protected final void clearList() {
        this.logChannel.log(1078071040, "[%1.clearList]", (Object)"AbstractMediaBrowserList");
        this.getList().removeAll();
        this.flushList();
    }

    private void discardListRequest() {
        this.logChannel.log(1078071040, "[%1.discardListRequest]", (Object)"AbstractMediaBrowserList");
        ListRequest listRequest = this.listRequest;
        if (listRequest.isValid()) {
            this.listRequest = NO_WIDGET_REQUEST;
            this.getList().setRows(listRequest.getRequestId(), listRequest.getStartIndex(), new EvoListRow[0]);
        }
        this.browseListContext.discardListRequest(1);
    }

    public void deactivate() {
        this.logChannel.log(1078071040, "[%1.deactivate]", (Object)"AbstractMediaBrowserList");
        this.browseListContext = INVALID_BROWSE_LIST_CONTEXT;
    }

    protected void flushList() {
        this.logChannel.log(1078071040, "[%1.flushList really]", (Object)"AbstractMediaBrowserList");
        this.getModelGroup().flush();
    }

    protected ModelGroup getModelGroup() {
        return this.browserModelGroup;
    }

    public final void blockList() {
        this.logChannel.log(-2137614336, "[%1.blockList]", (Object)"AbstractMediaBrowserList");
        ChoiceModelApp choiceModelApp = this.getListStatusChoice();
        if (null != choiceModelApp) {
            choiceModelApp.setStatus(0);
        }
        this.getList().setStatus(0);
        if (null == choiceModelApp) {
            this.getList().fireEvent(this.getTerminal().getTerminalID());
        }
    }

    public void unblockList() {
        this.logChannel.log(-2137614336, "[%1.unblockList]", (Object)"AbstractMediaBrowserList");
        ChoiceModelApp choiceModelApp = this.getListStatusChoice();
        if (null != choiceModelApp) {
            choiceModelApp.setStatus(1);
        }
        this.getList().setStatus(1);
        this.flushList();
        if (this.getListProgressIndicationHandler() != null) {
            this.getListProgressIndicationHandler().stopIndication();
        }
    }

    public boolean isListBlocked() {
        ChoiceModelApp choiceModelApp = this.getListStatusChoice();
        if (null != choiceModelApp) {
            return choiceModelApp.getStatus() == 0;
        }
        return this.getList().getStatus() == 0;
    }

    protected boolean setFocusedCursorPosition(EvoListRow evoListRow) {
        if (-1L == evoListRow.getUniqueID()) {
            this.logChannel.log(1078071040, "[%1.setFocusedCursorPosition] No valid unique id to focus.", (Object)"AbstractMediaBrowserList");
            return false;
        }
        this.logChannel.log(1078071040, "[%1.setFocusedCursorPosition] uId='%2'", (Object)"AbstractMediaBrowserList", evoListRow.getUniqueID());
        this.getList().getMenu().setFocusedItem(this.getList().getID(), FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void setCurrentFocusedRow(AbstractMediaBrowserListRow abstractMediaBrowserListRow) {
        this.logChannel.log(1078071040, "[%1.setCurrentFocusedRow] '%2'", (Object)"AbstractMediaBrowserList", (Object)abstractMediaBrowserListRow);
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            this.currentFocusedRow = abstractMediaBrowserListRow;
        }
    }

    protected final Object getBrowserListMutex() {
        return this.browserListMutex;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean getClearListFlag() {
        IBrowseListContext iBrowseListContext = this.getBrowseListContext();
        synchronized (iBrowseListContext) {
            boolean bl = this.clearListRequested;
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setClearListFlag(boolean bl) {
        IBrowseListContext iBrowseListContext = this.getBrowseListContext();
        synchronized (iBrowseListContext) {
            this.clearListRequested = bl;
        }
    }

    protected IBrowseListContext getBrowseListContext() {
        return this.browseListContext;
    }

    protected final void requestListEntryBased(long l, int n) {
        this.logChannel.log(1078071040, "[%1.requestListEntryBased] entryID='%2', cT='%3'.", (Object)"AbstractMediaBrowserList", l, (long)n);
        if (this.getListProgressIndicationHandler() != null) {
            this.getListProgressIndicationHandler().startIndication();
        }
        if (this.getListSize() > this.WINDOW_RADIUS) {
            this.logChannel.log(1078071040, "[%1.requestListEntryBased] Request window.", (Object)"AbstractMediaBrowserList");
            this.browseListContext.requestListByEntryId(l, n, this.WINDOW_RADIUS, 1);
        } else {
            this.logChannel.log(1078071040, "[%1.requestListEntryBased] Request full list.", (Object)"AbstractMediaBrowserList");
            this.browseListContext.requestListByEntryId(0L, n, this.getListSize(), 1);
        }
    }

    protected final void requestListIndexBased(int n, int n2) {
        this.logChannel.log(1078071040, "[%1.requestListIndexBased] '%2'", (Object)"AbstractMediaBrowserList", (long)n);
        if (this.getListProgressIndicationHandler() != null) {
            this.getListProgressIndicationHandler().startIndication();
        }
        if (this.getListSize() > n2) {
            this.logChannel.log(1078071040, "[%1.requestListIndexBased] Request window.", (Object)"AbstractMediaBrowserList");
            this.browseListContext.requestListByIndex(n, n2, 1);
        } else {
            this.logChannel.log(1078071040, "[%1.requestListIndexBased] Request full list.", (Object)"AbstractMediaBrowserList");
            this.browseListContext.requestListByIndex(0, this.getListSize(), 1);
        }
    }

    protected final void requestListIndexBased(int n) {
        this.requestListIndexBased(n, this.WINDOW_RADIUS);
    }

    public final void changeToRootFolder() {
        this.logChannel.log(-2137614336, "[%1.changeToRootFolder]", (Object)"AbstractMediaBrowserList");
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        if (mediaListEntryArray.length <= this.getRootLevelStackLength()) {
            this.logChannel.log(1078071040, "[%1.changeToRootFolder] Root folder reached. Ignore.", (Object)"AbstractMediaBrowserList");
            return;
        }
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[this.getRootLevelStackLength()];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, this.getRootLevelStackLength());
        this.changeFolder(mediaListEntryArray2);
    }

    public final boolean changeToParentFolder() {
        this.logChannel.log(-2137614336, "[%1.changeToParentFolder]", (Object)"AbstractMediaBrowserList");
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        if (mediaListEntryArray.length <= this.getRootLevelStackLength()) {
            this.logChannel.log(1078071040, "[%1.changeToParentFolder] Parent folder reached. Ignore.", (Object)"AbstractMediaBrowserList");
            return false;
        }
        int n = mediaListEntryArray.length - 1;
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[n];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, n);
        this.changeFolder(mediaListEntryArray2);
        return true;
    }

    public void changeToSubFolder(MediaListEntry mediaListEntry) {
        this.logChannel.log(-2137614336, "[%1.changeToSubFolder] '%2'.", (Object)"AbstractMediaBrowserList", (Object)mediaListEntry);
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        if (mediaListEntryArray == IBrowseListContext.EMPTY_BROWSE_FOLDER) {
            this.logChannel.log(1078071040, "[%1.changeToSubFolder] No current folder available. Ignore.", (Object)"AbstractMediaBrowserList");
            return;
        }
        MediaListEntry[] mediaListEntryArray2 = new MediaListEntry[mediaListEntryArray.length + 1];
        System.arraycopy((Object)mediaListEntryArray, 0, (Object)mediaListEntryArray2, 0, mediaListEntryArray.length);
        mediaListEntryArray2[mediaListEntryArray.length] = mediaListEntry;
        this.changeFolder(mediaListEntryArray2);
    }

    public void changeFolder(MediaListEntry[] mediaListEntryArray) {
        if (this.logChannel.getCurrentLogThreshold() >= 1078071040) {
            this.logChannel.log(-2137614336, "[%1.changeFolder] '%2'.", (Object)"AbstractMediaBrowserList", (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        }
        this.discardListRequest();
        this.clearListRequested = true;
        this.blockList();
        this.setChangeFolderRunning(true);
        this.browseListContext.changeFolder(mediaListEntryArray);
    }

    protected final void resetFolderChangeIndication() {
        this.logChannel.log(1078071040, "[%1.resetFolderChangeIndication]", (Object)"AbstractMediaBrowserList");
        this.waitingForListAfterFolderChange = false;
    }

    public final MediaListEntry[] getCurrentBrowsingFolder() {
        return this.browseListContext.getBrowseFolder();
    }

    protected final int getListSize() {
        return this.browseListContext.getListSize();
    }

    protected final void setRootLevelStackLength(int n) {
        this.logChannel.log(-2137614336, "[%1.setRootLevelStackLength] '%2'", (Object)"AbstractMediaBrowserList", (long)n);
        this.rootLevelStackLength = n;
    }

    protected int getRootLevelStackLength() {
        return this.rootLevelStackLength;
    }

    protected final int getFolderLevel() {
        int n = this.getCurrentBrowsingFolder().length - this.getRootLevelStackLength() + 1;
        return n > 0 ? n : 0;
    }

    protected final boolean isBrowsingSubfolder() {
        MediaListEntry[] mediaListEntryArray = this.getCurrentBrowsingFolder();
        if (mediaListEntryArray == null) {
            return false;
        }
        return mediaListEntryArray.length > this.getRootLevelStackLength();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final AbstractMediaBrowserListRow getCurrentFocusedRow() {
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            return this.currentFocusedRow;
        }
    }

    protected abstract void updateBrowseFolderData() {
    }

    protected abstract void resetBrowseFolderData() {
    }

    protected abstract void setChangeFolderRunning(boolean bl) {
    }

    protected void setPlayableFileAvailable(boolean bl) {
        this.logger.hmi().log(1078071040, "[%2.setPlayableFileAvailable] '%1'", bl, (Object)"AbstractMediaBrowserList");
        this.getPlayableFilesAvailableModel().setValue(bl ? 1 : 0);
        ChoiceModelApp choiceModelApp = this.getSDSPlayableFilesAvailableModel();
        if (choiceModelApp != null) {
            choiceModelApp.setValue(bl ? 1 : 0);
        }
    }

    protected void emptyList() {
        this.logger.hmi().log(1078071040, "[%1.emptyList]", (Object)"AbstractMediaBrowserList");
        this.updateList(new MediaListEntry[0], 0);
        this.unblockList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateList(MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(1078071040, "[%1.updateList] index='%2'", (Object)"AbstractMediaBrowserList", (long)n);
        AbstractMediaBrowserListRow[] abstractMediaBrowserListRowArray = new AbstractMediaBrowserListRow[mediaListEntryArray.length];
        int n2 = 0;
        int n3 = n;
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            Object object2;
            Object object3;
            Object object4 = null;
            int n4 = 0;
            while (n4 < mediaListEntryArray.length) {
                object3 = mediaListEntryArray[n4];
                object2 = this.createListRow((MediaListEntry)object3, n3);
                if (this.waitingForListAfterFolderChange) {
                    if (object4 == null) {
                        if (null == this.folderChangeFocus) {
                            object4 = object2;
                        } else if (((AbstractMediaBrowserListRow)object2).isListEntry(this.folderChangeFocus)) {
                            this.logChannel.log(-2137614336, "[%1.updateList] Focus entry found.", (Object)"AbstractMediaBrowserList");
                            object4 = object2;
                        }
                    }
                } else if (((AbstractMediaBrowserListRow)object2).equals(this.currentFocusedRow)) {
                    object4 = object2;
                }
                abstractMediaBrowserListRowArray[n2] = object2;
                ++n2;
                ++n4;
                ++n3;
            }
            if (this.logger.hmi().isDebug2()) {
                for (n4 = 0; n4 < abstractMediaBrowserListRowArray.length; ++n4) {
                    object3 = abstractMediaBrowserListRowArray[n4];
                    object2 = new Buffer(50);
                    ((Buffer)object2).append("uId='").append(((EvoListRow)object3).getUniqueID()).append("',entryID='").append(((AbstractMediaListRow)object3).getEntryID()).append("','");
                    ((Buffer)object2).append(((AbstractMediaBrowserListRow)object3).getTitle() != null ? ((AbstractMediaBrowserListRow)object3).getTitle().getI18NString() : "").append("'");
                    this.logger.hmi().log(14808325, "[%1.updateList] %2", (Object)"AbstractMediaBrowserList", object2);
                }
            }
            this.logChannel.log(-2137614336, "[%1.updateList] Update model.", (Object)"AbstractMediaBrowserList");
            TiledListModelApp tiledListModelApp = this.getList();
            tiledListModelApp.setSelectedIndex(-1);
            boolean bl = !this.listRequest.isValid();
            object2 = this.fillList(abstractMediaBrowserListRowArray, n);
            if (object2 == null) {
                if (object4 != null) {
                    if (this.logChannel.isDebug()) {
                        this.logChannel.log(-2137614336, "[%1.updateList] Set focus (int, row='%2').", (Object)"AbstractMediaBrowserList", object4);
                    }
                    if (bl && this.setFocusedCursorPosition((EvoListRow)object4)) {
                        this.logChannel.log(-2137614336, "[%1.updateList] Focus changed.", (Object)"AbstractMediaBrowserList");
                        this.currentFocusedRow = object4;
                    }
                }
            } else {
                this.logChannel.log(-2137614336, "[%1.updateList] Set focus (ext, row='%2').", (Object)"AbstractMediaBrowserList", object2);
                if (this.setFocusedCursorPosition((EvoListRow)object2)) {
                    this.logChannel.log(-2137614336, "[%1.updateList] Focus changed.", (Object)"AbstractMediaBrowserList");
                    this.currentFocusedRow = object4;
                }
            }
        }
        this.waitingForListAfterFolderChange = false;
    }

    @Override
    public int getClientId() {
        return 1;
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(1078071040, "[%1.responseList]", (Object)"AbstractMediaBrowserList");
        if (bl) {
            this.errorListRequestAborted();
            return;
        }
        if (this.getListSize() > 0) {
            try {
                this.updateList(mediaListEntryArray, n);
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "[%1.responseList]", (Object)"AbstractMediaBrowserList", (Throwable)exception);
            }
        } else {
            this.logger.hmi().log(1078071040, "[%1.responseList] List size changed to 0. Ignore response.", (Object)"AbstractMediaBrowserList");
        }
        this.unblockList();
    }

    private void errorListRequestAborted() {
        this.logChannel.log(1078071040, "[%1.errorListRequestAborted]", (Object)"AbstractMediaBrowserList");
        if (this.waitingForListAfterFolderChange) {
            this.updateList(new MediaListEntry[0], 0);
        }
        if (this.listRequest.isValid()) {
            ListRequest listRequest = this.listRequest;
            this.listRequest = NO_WIDGET_REQUEST;
            this.getList().setRows(listRequest.getRequestId(), listRequest.getStartIndex(), new EvoListRow[0]);
        }
        this.unblockList();
    }

    @Override
    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        if (bl) {
            this.logChannel.log(1078071040, "[%1.browseFolderChanged] Error received", (Object)"AbstractMediaBrowserList");
            this.unblockList();
            return;
        }
        this.logChannel.log(1078071040, "[%1.browseFolderChanged] size='%2' '%3'", (Object)"AbstractMediaBrowserList", (Object)Integer.toString(n), (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        this.folderChangeFocus = this.getFocusEntryForFolderChange(mediaListEntryArray);
        this.previousBrowsingFolder = mediaListEntryArray;
        this.updateBrowseFolderData();
        this.setPlayableFileAvailable(n != 0);
        this.getList().setLength(n);
        if (n == 0) {
            Object object = this.getBrowserListMutex();
            synchronized (object) {
                this.currentFocusedRow = null;
            }
            this.emptyList();
            return;
        }
        this.logChannel.log(-2137614336, "[%1.browseFolderChanged] Browse folder changed.", (Object)"AbstractMediaBrowserList");
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            this.currentFocusedRow = null;
        }
        if (this.folderChangeFocus != null) {
            this.logChannel.log(-2137614336, "[%1.browseFolderChanged] Focus entry.", (Object)"AbstractMediaBrowserList");
            this.requestListEntryBased(this.folderChangeFocus.getEntryID(), this.folderChangeFocus.getContentType());
        } else {
            this.logChannel.log(-2137614336, "[%1.browseFolderChanged] No focus specified.", (Object)"AbstractMediaBrowserList");
            this.requestListIndexBased(0, this.WINDOW_RADIUS);
        }
        this.waitingForListAfterFolderChange = true;
    }

    protected MediaListEntry getFocusEntryForFolderChange(MediaListEntry[] mediaListEntryArray) {
        if (mediaListEntryArray.length < this.previousBrowsingFolder.length) {
            this.logChannel.log(1078071040, "[%1.browseFolderChanged] Go to parent.", (Object)"AbstractMediaBrowserList");
            return this.previousBrowsingFolder[mediaListEntryArray.length];
        }
        this.logChannel.log(1078071040, "[%1.browseFolderChanged] Go to sub folder.", (Object)"AbstractMediaBrowserList");
        return null;
    }

    @Override
    public void listUpdated(int n) {
        this.logChannel.log(1078071040, "[%1.listUpdated] '%2'", (Object)"AbstractMediaBrowserList", (long)n);
        this.setPlayableFileAvailable(n != 0);
        if (n == 0) {
            this.emptyList();
            return;
        }
        this.updateListAroundFocus();
    }

    protected void updateListAroundFocus() {
        this.logChannel.log(1078071040, "[%1.updateListAroundFocus]", (Object)"AbstractMediaBrowserList");
        AbstractMediaBrowserListRow abstractMediaBrowserListRow = this.getCurrentFocusedRow();
        if (abstractMediaBrowserListRow == null) {
            this.logChannel.log(-2137614336, "[%1.listUpdated] No current focused row.", (Object)"AbstractMediaBrowserList");
            this.requestListIndexBased(0, this.WINDOW_RADIUS);
        } else {
            this.requestListEntryBased(abstractMediaBrowserListRow.getEntryID(), abstractMediaBrowserListRow.getEntryContentType());
        }
    }

    @Override
    public void notifyMetadataEntryAvailable(boolean bl) {
    }

    @Override
    public void notifyFilesystemEntryAvailable(boolean bl) {
    }

    @Override
    public void notifyCoverartsAvailable(boolean bl) {
    }

    @Override
    public void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
    }

    @Override
    public void resetSelectionResult(boolean bl, int n) {
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[%1.itemSelected] '%2'", (Object)"AbstractMediaBrowserList", (Object)evoListRow);
        AbstractMediaBrowserListRow abstractMediaBrowserListRow = (AbstractMediaBrowserListRow)evoListRow;
        this.getChoiceModel(-1274019072).setValue(abstractMediaBrowserListRow.isPlayListContent() ? 1 : 0);
        if (abstractMediaBrowserListRow.isFolder()) {
            if (abstractMediaBrowserListRow.isEnabled()) {
                this.changeToSubFolder(abstractMediaBrowserListRow.getFolderMediaEntry());
                return;
            }
            this.logChannel.log(1078071040, "[%1.itemSelected] item is disabled -> Ignore", (Object)"AbstractMediaBrowserList");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[%1.itemFocused] '%2' (vIdx='%3').", (Object)"AbstractMediaBrowserList", (Object)evoListRow);
        Object object = this.getBrowserListMutex();
        synchronized (object) {
            if (evoListRow == null) {
                this.logChannel.log(-1601830656, "[%1.itemFocused] Focused row is null. Ignore.", (Object)"AbstractMediaBrowserList");
                this.currentFocusedRow = null;
                return;
            }
            this.currentFocusedRow = (AbstractMediaBrowserListRow)evoListRow;
        }
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        if (this.isListBlocked()) {
            this.logChannel.log(1078071040, "[%1.requestItems] List blocked.", (Object)"AbstractMediaBrowserList");
            this.getList().setRows(n3, n, new EvoListRow[0]);
            return;
        }
        this.logChannel.log(1078071040, "[%1.requestItems] startIdx='%2' len='%3'", (Object)"AbstractMediaBrowserList", (long)n, (long)n2);
        this.listRequest = new ListRequest(n3, n);
        this.requestListIndexBased(n, n2);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(1078071040, "[%1.unrequestItems] idx='%2' len='%3'", (Object)"AbstractMediaBrowserList", (long)n, (long)n2);
        this.getList().clearRows(n, n2);
    }

    protected final void setPreviousBrowsingFolder(MediaListEntry[] mediaListEntryArray) {
        this.previousBrowsingFolder = mediaListEntryArray;
    }

    protected final MediaListEntry[] getPreviousBrowsingFolder() {
        return this.previousBrowsingFolder;
    }

    static {
        INVALID_BROWSE_LIST_CONTEXT = new NullBrowseListContextImpl();
        NO_WIDGET_REQUEST = new ListRequest();
    }
}

