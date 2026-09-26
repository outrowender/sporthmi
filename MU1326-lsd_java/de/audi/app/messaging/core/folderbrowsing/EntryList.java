/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.app.messaging.core.folderbrowsing.EntryList$2;
import de.audi.app.messaging.core.folderbrowsing.EntryList$FolderChangeRequest;
import de.audi.app.messaging.core.folderbrowsing.EntryList$FolderNavigatorObserver;
import de.audi.app.messaging.core.folderbrowsing.EntryList$MyDsiMessagingListener;
import de.audi.app.messaging.core.folderbrowsing.EntryList$MyI18NTarget;
import de.audi.app.messaging.core.folderbrowsing.EntryList$MyMenuModelListener;
import de.audi.app.messaging.core.folderbrowsing.EntryList$MyMsgListener;
import de.audi.app.messaging.core.folderbrowsing.EntryList$MyTiledListModelListener;
import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.folderbrowsing.Folders;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory$NullFactory;
import de.audi.app.messaging.core.folderbrowsing.ListDataRequest;
import de.audi.app.messaging.core.folderbrowsing.ListDataResponse;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand$ResultHandler;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Times;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;

public final class EntryList
extends AbstractMessagingComponent {
    private static final int DEFAULT_REQUEST_PADDING;
    private static final long OPERATION_TIMEOUT;
    private static final int OPERATION_STATE_CHANGE_BEGIN_OR_CONTINUE;
    private static final int OPERATION_STATE_CHANGE_CONTINUE_AND_EXTEND;
    private static final int OPERATION_STATE_CHANGE_TERMINATE_OK;
    private static final int OPERATION_STATE_CHANGE_TERMINATE_FAILED;
    private final TiledListModelApp listModel;
    private final ModelGroup folderContentModelGroup = new ModelGroup();
    private final Collection folderContentModelGroupCandidates = new ArrayList(16);
    private final CopyOnWriteArrayList entryListObservers = new CopyOnWriteArrayList();
    private final ListEntriesCommand$ResultHandler commandResultHandler = new EntryList$1(this);
    private int operationState = 1;
    private final Timer operationTimer = this.createOperationTimer();
    private boolean ignoreUpdates = false;
    public boolean isFolderChangeInProgress = false;
    public boolean awaitFolderChange = false;
    private boolean isDeletionMode = false;
    private EntryListRow focusedRow;
    private IEntryPropertyFactory entryPropertyFactory = new IEntryPropertyFactory$NullFactory();
    private Folder currentFolder = Folder.FOLDER_NONE;
    private int lastRequestId = -1;
    private EntryList$FolderChangeRequest queuedFolderChangeRequest = null;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public EntryList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getTiledListModel(-1382866688);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            super.init(abstractMsgApplication);
            this.listModel.setListener(new EntryList$MyTiledListModelListener(this, null));
            this.registerForModelGroup(this.listModel.getMenu());
            this.registerForModelGroup(this.listModel);
            this.listModel.getMenu().setListener(new EntryList$MyMenuModelListener(this, null));
            abstractMsgApplication.getFolderNavigator().addObserver(new EntryList$FolderNavigatorObserver(this, null));
            abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new EntryList$MyDsiMessagingListener(this, null));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void dispose() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            super.dispose();
            this.operationTimer.cancel();
        }
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = EntryList.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new EntryList$MyMsgListener(this, null), ServiceProperties.createServiceProperties());
            Dictionary dictionary = ServiceProperties.createServiceProperties();
            dictionary.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
            iServiceRegistry.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = EntryList.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)new EntryList$MyI18NTarget(this, null), dictionary);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[EntryList#connect]");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setEntryPropertyFactory(IEntryPropertyFactory iEntryPropertyFactory) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(-2137614336, "[EntryList#setEntryPropertyFactory] entryPropertyFactory = %1", (Object)iEntryPropertyFactory);
            this.entryPropertyFactory = iEntryPropertyFactory;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLength() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.listModel.getLength();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setQueuedFolderChangeRequest(EntryList$FolderChangeRequest entryList$FolderChangeRequest) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(1078071040, "[EntryList#setQueuedFolderChangeRequest] folderChangeRequest = %1", (Object)String.valueOf(entryList$FolderChangeRequest));
            this.queuedFolderChangeRequest = entryList$FolderChangeRequest;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private EntryList$FolderChangeRequest getQueuedFolderChangeRequest() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            return this.queuedFolderChangeRequest;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAwaitFolderChange(boolean bl) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(1078071040, "[EntryList#setAwaitFolderChange] awaitFolderChange = %1, this.awaitFolderChange = %2, this.isFolderChangeInProgress = %3", bl, this.awaitFolderChange, this.isFolderChangeInProgress);
            boolean bl2 = this.awaitFolderChange;
            this.awaitFolderChange = bl;
            if (!bl2 && bl) {
                this.changeOperationState(0);
            } else if (bl2 && !bl && !this.isFolderChangeInProgress) {
                this.changeOperationState(3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setIgnoreUpdates(boolean bl) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(-2137614336, "[EntryList#setIgnoreUpdates] ignoreUpdates = %1", bl);
            this.ignoreUpdates = bl;
        }
    }

    public void setDeletionMode(boolean bl) {
        this.isDeletionMode = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerForModelGroup(HMIModelApp hMIModelApp) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.folderContentModelGroupCandidates.add(hMIModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleHmiSettingsChanged() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(-2137614336, "[EntryList#handleHmiSettingsChanged] currentFolder.isValid() = %1 ", this.currentFolder.isValid());
            if (this.currentFolder.isValid()) {
                try {
                    this.setUnsynchedOperationState(0);
                    this.autoLoadListItems(true, null);
                }
                catch (Exception exception) {
                    Logs.logException(this.log, exception, "[EntryList#handleHmiSettingsChanged]");
                    this.setUnsynchedOperationState(3);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleCommandResult(ListDataResponse listDataResponse) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            try {
                boolean bl;
                ListDataRequest listDataRequest;
                if (this.log.isInfo()) {
                    this.log.log(1078071040, "[EntryList#handleCommandResult] lastRequestId = %2, listDataResponse = %1", (Object)listDataResponse, (long)this.lastRequestId);
                }
                boolean bl2 = (listDataRequest = listDataResponse.getListDataRequest()).getModelRequestId() != -1;
                boolean bl3 = this.isFolderMatch(listDataResponse);
                if (bl2 || bl3) {
                    this.updateListModel(listDataResponse, bl3);
                } else if (this.log.isInfo()) {
                    this.log.log(1078071040, "[EntryList#handleCommandResult] Response does not pertain to a model request or does not pertain to the current folder. Skipping list model update.");
                }
                boolean bl4 = bl = listDataResponse.getResult() == 0;
                if (bl && this.getQueuedFolderChangeRequest() != null) {
                    this.changeOperationState(1);
                } else {
                    int n = bl ? 2 : 3;
                    this.changeOperationState(n);
                    this.setUnsynchedOperationState(this.operationState);
                    if (this.isFolderChangeResponse(listDataResponse)) {
                        this.emitIndicateListDataResponseOnFolderChange();
                    }
                }
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#handleCommandResult]");
                this.changeOperationState(3);
            }
        }
    }

    private boolean isFolderMatch(ListDataResponse listDataResponse) {
        MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
        Folder folder = this.msgApp.getFolderNavigator().getCurrentFolder();
        boolean bl = messagingAccount != null && listDataResponse.getAccountId() == messagingAccount.getAccountID();
        return bl && folder.isValid() && listDataResponse.getFolderId() == folder.getFolderEntry().getFolderID();
    }

    private boolean isFolderChangeResponse(ListDataResponse listDataResponse) {
        boolean bl = false;
        ListChangedInformation listChangedInformation = listDataResponse.getListDataRequest().getListChangedInformation();
        if (listChangedInformation != null) {
            bl = listChangedInformation.getReason() == 6;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private EntryListRow[] toEntryListRows(ListDataResponse listDataResponse) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            ListEntry[] listEntryArray = listDataResponse.getListEntries();
            EntryListRow[] entryListRowArray = new EntryListRow[listEntryArray.length];
            long l = Times.getCurrentTime(this.framework);
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                AbstractEntryListRowData abstractEntryListRowData = this.msgApp.getEntryListRowDataFactory().create(listEntryArray[i2], this.entryPropertyFactory, listDataResponse.getOffset() + i2, l, this.msgApp.getTextLookup());
                entryListRowArray[i2] = new EntryListRow(abstractEntryListRowData);
            }
            return entryListRowArray;
        }
    }

    private void updateListModel(ListDataResponse listDataResponse, boolean bl) {
        ListChangedInformation listChangedInformation;
        this.log.log(-2137614336, "[EntryList#updateListModel]");
        ListDataRequest listDataRequest = listDataResponse.getListDataRequest();
        BaseListModelApp baseListModelApp = this.listModel.getCopy();
        if (listDataRequest.hasListChanged()) {
            baseListModelApp.clearAll();
            listChangedInformation = listDataRequest.getListChangedInformation();
            int n = listChangedInformation != null ? listChangedInformation.getListSize() : this.getLength();
            baseListModelApp.setLength(n);
        }
        if (listDataResponse.getResult() != 0) {
            int n = Math.min(this.getLength(), listDataResponse.getOffset());
            n = Math.max(0, n);
            this.log.log(10000, "[EntryList#updateListModel] Error loading list data, truncating list to size %1.", (long)n);
            baseListModelApp.setLength(n);
        }
        listChangedInformation = bl ? this.toEntryListRows(listDataResponse) : null;
        baseListModelApp.setRows(listDataRequest.getModelRequestId(), listDataResponse.getOffset(), (EvoListRow[])listChangedInformation);
        this.listModel.update(baseListModelApp);
        if (bl && listChangedInformation != null) {
            this.setFocus(listDataResponse, (EntryListRow[])listChangedInformation);
        }
    }

    private void setFocus(ListDataResponse listDataResponse, EntryListRow[] entryListRowArray) {
        this.log.log(-2137614336, "[EntryList#setFocus]");
        boolean bl = false;
        ListDataRequest listDataRequest = listDataResponse.getListDataRequest();
        if (this.isFolderChangeResponse(listDataResponse)) {
            Folder folder = this.msgApp.getFolderNavigator().getLastSubFolder();
            boolean bl2 = folder.isValid();
            EntryListRow entryListRow = null;
            if (bl2) {
                entryListRow = this.findSubFolderToFocus(entryListRowArray, folder);
            }
            if (entryListRow != null) {
                this.log.log(-2137614336, "[EntryList#setFocus] Setting cursor to subfolder after folder up-change.");
                this.listModel.getMenu().setFocusedItem(this.listModel.getID(), FocusAdvice.VIEWPORT_SECOND_POSITION, entryListRow.getUniqueID());
            } else {
                bl = true;
            }
        } else if (listDataRequest.hasListChanged()) {
            if (this.isKeepOffsetChange(listDataRequest.getListChangedInformation())) {
                EntryListRow entryListRow = listDataRequest.getFocusedRow();
                EntryListRow entryListRow2 = this.findRowToFocus(entryListRowArray, entryListRow);
                if (entryListRow2 != null) {
                    this.log.log(-2137614336, "[EntryList#setFocus] Setting cursor to previously focused item after list change.");
                    this.listModel.getMenu().setFocusedItem(this.listModel.getID(), FocusAdvice.KEEP_POSITION, entryListRow2.getUniqueID());
                    this.emitItemToSelect(entryListRow2);
                }
            } else {
                bl = true;
            }
        }
        if (bl) {
            this.log.log(-2137614336, "[EntryList#setFocus] Resetting cursor position.");
            this.listModel.getMenu().trigger(ModelTrigger.RESET_CURSOR_POS);
        } else {
            this.log.log(-2137614336, "[EntryList#setFocus] Not resetting cursor position.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void signalListReady(boolean bl) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(1078071040, "[EntryList#signalListReady] isReady = %1", bl);
            int n = bl ? 1 : 0;
            this.listModel.setStatus(n);
        }
    }

    private void changeOperationState(int n) {
        boolean bl;
        int n2;
        this.log.log(1078071040, "[EntryList#changeOperationState] this.operationState = %1, operationStateChange = %2", (long)this.operationState, (long)n);
        switch (n) {
            case 0: 
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        boolean bl2 = this.operationState == 0;
        boolean bl3 = n2 == 0;
        boolean bl4 = !bl2 && bl3;
        boolean bl5 = bl2 && !bl3;
        boolean bl6 = bl = bl2 && bl3;
        if (!bl && n == 1) {
            throw new IllegalStateException(new StringBuffer().append("Cannot continue operation, this.operationState = %1").append(this.operationState).toString());
        }
        if (bl4) {
            this.setQueuedFolderChangeRequest(null);
            this.operationTimer.start();
            Iterator iterator = this.folderContentModelGroupCandidates.iterator();
            while (iterator.hasNext()) {
                this.folderContentModelGroup.add((HMIModelApp)iterator.next());
            }
        } else if (bl5) {
            this.operationTimer.cancel();
            this.folderContentModelGroup.flush();
            this.folderContentModelGroup.removeAll();
        } else if (bl && n == 1) {
            this.operationTimer.cancel();
            this.operationTimer.start();
            EntryList$FolderChangeRequest entryList$FolderChangeRequest = this.getQueuedFolderChangeRequest();
            this.setQueuedFolderChangeRequest(null);
            this.msgApp.getAccountManager().selectAccount(entryList$FolderChangeRequest.getAccountId());
            this.msgApp.getFolderNavigator().changeFolderDirect(entryList$FolderChangeRequest.getFolderId(), true);
        }
        if (this.operationState != n2) {
            this.operationState = n2;
            this.msgApp.getModelAccess().setOperationStateChoice(529735936, n2);
            this.emitIndicateOperationState(n2);
        }
    }

    private void setUnsynchedOperationState(int n) {
        this.log.log(-2137614336, "[EntryList#logUnsyncedOperationState] operationState = %1", (long)n);
    }

    private void clear() {
        this.log.log(-2137614336, "[EntryList#clear]");
        this.listModel.removeAll();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListEntry getEntry(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            EntryListRow entryListRow;
            ListEntry listEntry = null;
            if (n >= 0 && n < this.listModel.getLength() && (entryListRow = (EntryListRow)this.listModel.getRow(n)) != null) {
                listEntry = entryListRow.getListEntry();
            }
            return listEntry;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean selectEntry(int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            EvoListRow evoListRow;
            this.log.log(-2137614336, "[EntryList#selectEntry] index = %1", (long)n);
            boolean bl = false;
            if (n >= 0 && n < this.getLength() && (evoListRow = this.listModel.getRow(n)) != null) {
                this.entrySelected(evoListRow);
                bl = true;
            }
            return bl;
        }
    }

    public void toggleEntryRow(EntryListRow entryListRow, int n, boolean bl) {
        this.log.log(-2137614336, "[EntryList#toggleEntryRow]");
        entryListRow.toggleRow(entryListRow, bl);
        this.listModel.setRow(n, entryListRow);
    }

    public void deselectAllRows() {
        this.log.log(-2137614336, "[EntryList#deselectAllRows]");
        try {
            for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
                EntryListRow entryListRow = (EntryListRow)this.listModel.getRow(i2);
                if (entryListRow == null) continue;
                this.toggleEntryRow(entryListRow, i2, false);
            }
        }
        catch (Exception exception) {
            this.log.log(1078071040, "[EntryList#deselectAllRows]", (Throwable)exception);
        }
    }

    private boolean isKeepOffsetChange(ListChangedInformation listChangedInformation) {
        int n;
        boolean bl = false;
        bl = listChangedInformation == null ? true : (n = listChangedInformation.getReason()) == 1 || n == 4 || n == 5 || n == 3 || n == 2 || n == 8;
        return bl;
    }

    private void autoLoadListItems(boolean bl, ListChangedInformation listChangedInformation) {
        this.log.log(-2137614336, "[EntryList#autoLoadListItems]");
        int n = listChangedInformation != null ? listChangedInformation.getListSize() : this.getLength();
        boolean bl2 = this.focusedRow != null && (!bl || this.isKeepOffsetChange(listChangedInformation));
        int n2 = Math.max(0, n - 1);
        int n3 = bl2 ? this.focusedRow.getItemOffset() : 0;
        int n4 = Math.min(n2, n3);
        int n5 = n4 - 20;
        int n6 = n4 + 20;
        int n7 = Math.max(0, n5);
        int n8 = Math.min(n, n6);
        int n9 = n8 - n7;
        int n10 = Math.max(0, n9);
        this.loadListItems(n7, n10, -1, bl, listChangedInformation);
    }

    private void loadListItems(int n, int n2, int n3, boolean bl, ListChangedInformation listChangedInformation) {
        this.log.log(-2137614336, "[EntryList#loadListItems]");
        ListDataRequest listDataRequest = new ListDataRequest(++this.lastRequestId, n3, n, n2, bl, listChangedInformation, this.focusedRow, this.listModel.getMenu().getAdvice());
        new ListEntriesCommand(this.msgApp, this.commandResultHandler, listDataRequest).schedule();
    }

    private void folderSelected(ListEntry listEntry) {
        FolderEntry folderEntry = listEntry.getFolderEntry();
        this.log.log(-2137614336, "[EntryList#folderSelected] folderEntry = %1", (Object)folderEntry);
        this.setSelectedItemTypeModel(false);
        FolderNavigator folderNavigator = this.msgApp.getFolderNavigator();
        folderNavigator.changeFolderDown(folderEntry);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            List list = this.listModel.asList();
            Object[] objectArray = new ListEntry[list.size()];
            int n = 0;
            Object object2 = list.iterator();
            while (object2.hasNext()) {
                objectArray[n] = ((EntryListRow)object2.next()).getListEntry();
            }
            object2 = new Buffer();
            ((Buffer)object2).append("EntryList {Buffered list entries = ");
            ((Buffer)object2).append(Arrays.toMultiLineString(objectArray));
            ((Buffer)object2).append('}');
            return ((Buffer)object2).toString();
        }
    }

    private EntryListRow findSubFolderToFocus(EntryListRow[] entryListRowArray, Folder folder) {
        EntryListRow entryListRow = null;
        try {
            if (folder.isValid()) {
                int n = folder.getFolderEntry().getFolderID();
                int n2 = this.findFolderById(n, entryListRowArray);
                if (n2 >= 0 && n2 < entryListRowArray.length) {
                    entryListRow = entryListRowArray[n2];
                }
                this.log.log(-2137614336, "[EntryList#findSubFolderToFocus] subFolderId = %1, indexToFocus = %2, rowToFocus = %3", (Object)String.valueOf(n), (Object)String.valueOf(n2), (Object)String.valueOf(entryListRow));
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[EntryList#findSubFolderToFocus] Error trying to find subfolder to focus: ", (Throwable)exception);
        }
        return entryListRow;
    }

    private EntryListRow findRowToFocus(EntryListRow[] entryListRowArray, EntryListRow entryListRow) {
        EntryListRow entryListRow2;
        block5: {
            entryListRow2 = null;
            try {
                if (entryListRow == null) break block5;
                ListEntry listEntry = entryListRow.getListEntry();
                for (int i2 = 0; i2 < entryListRowArray.length; ++i2) {
                    Object object;
                    Object object2;
                    EntryListRow entryListRow3 = entryListRowArray[i2];
                    ListEntry listEntry2 = entryListRow3.getListEntry();
                    if (ListEntries.isMessage(listEntry2) && ListEntries.isMessage(listEntry)) {
                        object2 = listEntry2.getMessageListEntry();
                        object = listEntry.getMessageListEntry();
                        if (!((MessageListEntry)object).getMessageID().equals(((MessageListEntry)object2).getMessageID())) continue;
                        entryListRow2 = entryListRow3;
                    } else {
                        if (!ListEntries.isFolder(listEntry2) || !ListEntries.isFolder(listEntry)) continue;
                        object2 = listEntry2.getFolderEntry();
                        object = listEntry.getFolderEntry();
                        if (((FolderEntry)object).getFolderID() != ((FolderEntry)object2).getFolderID()) continue;
                        entryListRow2 = entryListRow3;
                    }
                    break;
                }
            }
            catch (Exception exception) {
                this.log.log(10000, "[EntryList#findRowToFocus] Error trying to find item to focus: ", (Throwable)exception);
            }
        }
        this.log.log(-2137614336, "[EntryList#findRowToFocus] rowToFocus = %1", (Object)String.valueOf(entryListRow2));
        return entryListRow2;
    }

    private int findFolderById(int n, EntryListRow[] entryListRowArray) {
        int n2 = -1;
        if (!Folders.isPredefinedFolderId(n)) {
            for (int i2 = 0; i2 < entryListRowArray.length; ++i2) {
                FolderEntry folderEntry;
                ListEntry listEntry = entryListRowArray[i2].getListEntry();
                if (!ListEntries.isFolder(listEntry) || (folderEntry = listEntry.getFolderEntry()).getFolderID() != n) continue;
                n2 = i2;
                break;
            }
        } else if (Folders.isStandardFolder(Folders.mapToHmiFolderType(n))) {
            for (int i3 = 0; i3 < entryListRowArray.length; ++i3) {
                FolderEntry folderEntry;
                ListEntry listEntry = entryListRowArray[i3].getListEntry();
                if (!ListEntries.isFolder(listEntry) || !Folders.isFolderTypeEqual(folderEntry = listEntry.getFolderEntry(), n)) continue;
                n2 = i3;
                break;
            }
        } else {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal folderId = ").append(n).toString());
        }
        return n2;
    }

    private void entrySelected(EvoListRow evoListRow) {
        EntryListRow entryListRow = (EntryListRow)evoListRow;
        ListEntry listEntry = entryListRow.getListEntry();
        this.log.log(1078071040, "[EntryList#entrySelected] listEntry = %1", (Object)listEntry);
        this.setFocusedItem(entryListRow);
        if (!ListEntries.isMessage(listEntry)) {
            this.folderSelected(listEntry);
        }
        this.emitIndicateItemSelected(listEntry, evoListRow.getUniqueID());
    }

    public void setSelectedItemTypeModel(boolean bl) {
        this.log.log(1078071040, "[EntryList#setSelectedItemTypeModel] isMessage = %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(546513152).setValue(n);
    }

    private Timer createOperationTimer() {
        EntryList$2 entryList$2 = new EntryList$2(this);
        return new Timer("(EntryList)", 0, true, entryList$2);
    }

    private void setFocusedItem(EntryListRow entryListRow) {
        this.log.log(-2137614336, "[EntryList#setFocusedItem] row = %1", (Object)entryListRow);
        this.focusedRow = entryListRow;
        if (this.focusedRow != null) {
            this.emitIndicateItemFocused(this.focusedRow);
        }
    }

    public void setSelectedListItem(long l) {
        this.listModel.setSelectedUniqueID(l);
    }

    public void addObserver(IEntryListObserver iEntryListObserver) {
        this.log.log(-2137614336, "[EntryList#addObserver] observer = %1", (Object)iEntryListObserver);
        this.entryListObservers.add(iEntryListObserver);
    }

    private void emitIndicateItemFocused(EntryListRow entryListRow) {
        this.log.log(-2137614336, "[EntryList#emitIndicateItemFocused]");
        Iterator iterator = this.entryListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IEntryListObserver)iterator.next()).indicateItemFocused(entryListRow);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#emitIndicateItemFocused]");
            }
        }
    }

    private void emitIndicateItemSelected(ListEntry listEntry, long l) {
        this.log.log(-2137614336, "[EntryList#emitIndicateItemSelected]");
        Iterator iterator = this.entryListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IEntryListObserver)iterator.next()).indicateItemSelected(listEntry, l);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#emitIndicateItemSelected]");
            }
        }
    }

    private void emitIndicateItemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "[EntryList#emitIndicateItemSelected]");
        Iterator iterator = this.entryListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IEntryListObserver)iterator.next()).indicateItemSelected(evoListRow, n, n2, n3, n4);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#emitIndicateItemSelected]");
            }
        }
    }

    private void emitIndicateListDataResponseOnFolderChange() {
        this.log.log(-2137614336, "[EntryList#emitIndicateListDataResponseOnFolderChange]");
        Iterator iterator = this.entryListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IEntryListObserver)iterator.next()).indicateListDataResponseOnFolderChange();
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#emitIndicateListDataResponseOnFolderChange]");
            }
        }
    }

    private void emitIndicateOperationState(int n) {
        this.log.log(-2137614336, "[EntryList#emitIndicateOperationState]");
        Iterator iterator = this.entryListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IEntryListObserver)iterator.next()).indicateOperationState(n);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#emitIndicateOperationState]");
            }
        }
    }

    private void emitItemToSelect(EvoListRow evoListRow) {
        this.log.log(-2137614336, "[EntryList#emitItemToSelect]");
        Iterator iterator = this.entryListObservers.iterator();
        while (iterator.hasNext()) {
            try {
                ((IEntryListObserver)iterator.next()).indicateItemToSelect(evoListRow);
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[EntryList#emitItemToSelect]");
            }
        }
    }

    static /* synthetic */ void access$000(EntryList entryList, ListDataResponse listDataResponse) {
        entryList.handleCommandResult(listDataResponse);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ MessagingBundleContext access$700(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$800(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ int access$900(EntryList entryList) {
        return entryList.operationState;
    }

    static /* synthetic */ void access$1000(EntryList entryList, int n) {
        entryList.changeOperationState(n);
    }

    static /* synthetic */ LogChannel access$1100(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ MessagingBundleContext access$1200(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$1300(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ LogChannel access$1400(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ boolean access$1500(EntryList entryList) {
        return entryList.isDeletionMode;
    }

    static /* synthetic */ void access$1600(EntryList entryList, EvoListRow evoListRow) {
        entryList.entrySelected(evoListRow);
    }

    static /* synthetic */ IFrameworkAccess access$1700(EntryList entryList) {
        return entryList.framework;
    }

    static /* synthetic */ void access$1800(EntryList entryList, EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        entryList.emitIndicateItemSelected(evoListRow, n, n2, n3, n4);
    }

    static /* synthetic */ MessagingBundleContext access$1900(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$2000(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ void access$2100(EntryList entryList, EntryListRow entryListRow) {
        entryList.setFocusedItem(entryListRow);
    }

    static /* synthetic */ MessagingBundleContext access$2200(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$2300(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ void access$2400(EntryList entryList, int n) {
        entryList.setUnsynchedOperationState(n);
    }

    static /* synthetic */ void access$2500(EntryList entryList, int n, int n2, int n3, boolean bl, ListChangedInformation listChangedInformation) {
        entryList.loadListItems(n, n2, n3, bl, listChangedInformation);
    }

    static /* synthetic */ LogChannel access$2600(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ MessagingBundleContext access$2700(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$2800(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ TiledListModelApp access$2900(EntryList entryList) {
        return entryList.listModel;
    }

    static /* synthetic */ LogChannel access$3000(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ MessagingBundleContext access$3100(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$3200(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ Folder access$3300(EntryList entryList) {
        return entryList.currentFolder;
    }

    static /* synthetic */ MessagingBundleContext access$3400(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$3500(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ Folder access$3302(EntryList entryList, Folder folder) {
        entryList.currentFolder = folder;
        return entryList.currentFolder;
    }

    static /* synthetic */ void access$3600(EntryList entryList) {
        entryList.clear();
    }

    static /* synthetic */ MessagingBundleContext access$3700(EntryList entryList) {
        return entryList.messagingBundleContext;
    }

    static /* synthetic */ LogChannel access$3800(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ boolean access$3900(EntryList entryList) {
        return entryList.ignoreUpdates;
    }

    static /* synthetic */ void access$4000(EntryList entryList, boolean bl, ListChangedInformation listChangedInformation) {
        entryList.autoLoadListItems(bl, listChangedInformation);
    }

    static /* synthetic */ LogChannel access$4100(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ LogChannel access$4200(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ LogChannel access$4300(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ void access$4400(EntryList entryList) {
        entryList.handleHmiSettingsChanged();
    }

    static /* synthetic */ LogChannel access$4500(EntryList entryList) {
        return entryList.log;
    }

    static /* synthetic */ LogChannel access$4600(EntryList entryList) {
        return entryList.log;
    }
}

