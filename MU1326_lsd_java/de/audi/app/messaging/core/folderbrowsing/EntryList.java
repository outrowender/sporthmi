/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.folderbrowsing.AbstractEntryListRowData;
import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigator;
import de.audi.app.messaging.core.folderbrowsing.Folders;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;
import de.audi.app.messaging.core.folderbrowsing.ListDataRequest;
import de.audi.app.messaging.core.folderbrowsing.ListDataResponse;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Times;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultTiledListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
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
    private static final int DEFAULT_REQUEST_PADDING = 20;
    private static final long OPERATION_TIMEOUT = 190000L;
    private static final int OPERATION_STATE_CHANGE_BEGIN_OR_CONTINUE = 0;
    private static final int OPERATION_STATE_CHANGE_CONTINUE_AND_EXTEND = 1;
    private static final int OPERATION_STATE_CHANGE_TERMINATE_OK = 2;
    private static final int OPERATION_STATE_CHANGE_TERMINATE_FAILED = 3;
    private final TiledListModelApp listModel;
    private final ModelGroup folderContentModelGroup = new ModelGroup();
    private final Collection folderContentModelGroupCandidates = new ArrayList(16);
    private final CopyOnWriteArrayList entryListObservers = new CopyOnWriteArrayList();
    private final ListEntriesCommand.ResultHandler commandResultHandler = new ListEntriesCommand.ResultHandler(){

        public void handleResult(ListDataResponse listDataResponse) {
            EntryList.this.handleCommandResult(listDataResponse);
        }
    };
    private int operationState = 1;
    private final Timer operationTimer = this.createOperationTimer();
    private boolean ignoreUpdates = false;
    public boolean isFolderChangeInProgress = false;
    public boolean awaitFolderChange = false;
    private boolean isDeletionMode = false;
    private EntryListRow focusedRow;
    private IEntryPropertyFactory entryPropertyFactory = new IEntryPropertyFactory.NullFactory();
    private Folder currentFolder = Folder.FOLDER_NONE;
    private int lastRequestId = -1;
    private FolderChangeRequest queuedFolderChangeRequest = null;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;

    public EntryList(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.listModel = this.framework.getHmiServiceApp().getTiledListModel(2200493);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void init(AbstractMsgApplication abstractMsgApplication) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            super.init(abstractMsgApplication);
            this.listModel.setListener(new MyTiledListModelListener());
            this.registerForModelGroup(this.listModel.getMenu());
            this.registerForModelGroup(this.listModel);
            this.listModel.getMenu().setListener(new MyMenuModelListener());
            abstractMsgApplication.getFolderNavigator().addObserver(new FolderNavigatorObserver());
            abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dispose() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            super.dispose();
            this.operationTimer.cancel();
        }
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = EntryList.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new MyMsgListener(), ServiceProperties.createServiceProperties());
            Dictionary dictionary = ServiceProperties.createServiceProperties();
            dictionary.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
            iServiceRegistry.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = EntryList.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)new MyI18NTarget(), dictionary);
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
            this.log.log(10000000, "[EntryList#setEntryPropertyFactory] entryPropertyFactory = %1", (Object)iEntryPropertyFactory);
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
    public void setQueuedFolderChangeRequest(FolderChangeRequest folderChangeRequest) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(1000000, "[EntryList#setQueuedFolderChangeRequest] folderChangeRequest = %1", (Object)String.valueOf(folderChangeRequest));
            this.queuedFolderChangeRequest = folderChangeRequest;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FolderChangeRequest getQueuedFolderChangeRequest() {
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
            this.log.log(1000000, "[EntryList#setAwaitFolderChange] awaitFolderChange = %1, this.awaitFolderChange = %2, this.isFolderChangeInProgress = %3", bl, this.awaitFolderChange, this.isFolderChangeInProgress);
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
            this.log.log(10000000, "[EntryList#setIgnoreUpdates] ignoreUpdates = %1", bl);
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
            this.log.log(10000000, "[EntryList#handleHmiSettingsChanged] currentFolder.isValid() = %1 ", this.currentFolder.isValid());
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
                    this.log.log(1000000, "[EntryList#handleCommandResult] lastRequestId = %2, listDataResponse = %1", (Object)listDataResponse, (long)this.lastRequestId);
                }
                boolean bl2 = (listDataRequest = listDataResponse.getListDataRequest()).getModelRequestId() != -1;
                boolean bl3 = this.isFolderMatch(listDataResponse);
                if (bl2 || bl3) {
                    this.updateListModel(listDataResponse, bl3);
                } else if (this.log.isInfo()) {
                    this.log.log(1000000, "[EntryList#handleCommandResult] Response does not pertain to a model request or does not pertain to the current folder. Skipping list model update.");
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
        this.log.log(10000000, "[EntryList#updateListModel]");
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
        this.log.log(10000000, "[EntryList#setFocus]");
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
                this.log.log(10000000, "[EntryList#setFocus] Setting cursor to subfolder after folder up-change.");
                this.listModel.getMenu().setFocusedItem(this.listModel.getID(), FocusAdvice.VIEWPORT_SECOND_POSITION, entryListRow.getUniqueID());
            } else {
                bl = true;
            }
        } else if (listDataRequest.hasListChanged()) {
            if (this.isKeepOffsetChange(listDataRequest.getListChangedInformation())) {
                EntryListRow entryListRow = listDataRequest.getFocusedRow();
                EntryListRow entryListRow2 = this.findRowToFocus(entryListRowArray, entryListRow);
                if (entryListRow2 != null) {
                    this.log.log(10000000, "[EntryList#setFocus] Setting cursor to previously focused item after list change.");
                    this.listModel.getMenu().setFocusedItem(this.listModel.getID(), FocusAdvice.KEEP_POSITION, entryListRow2.getUniqueID());
                    this.emitItemToSelect(entryListRow2);
                }
            } else {
                bl = true;
            }
        }
        if (bl) {
            this.log.log(10000000, "[EntryList#setFocus] Resetting cursor position.");
            this.listModel.getMenu().trigger(ModelTrigger.RESET_CURSOR_POS);
        } else {
            this.log.log(10000000, "[EntryList#setFocus] Not resetting cursor position.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void signalListReady(boolean bl) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(1000000, "[EntryList#signalListReady] isReady = %1", bl);
            int n = bl ? 1 : 0;
            this.listModel.setStatus(n);
        }
    }

    private void changeOperationState(int n) {
        boolean bl;
        int n2;
        this.log.log(1000000, "[EntryList#changeOperationState] this.operationState = %1, operationStateChange = %2", (long)this.operationState, (long)n);
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
            FolderChangeRequest folderChangeRequest = this.getQueuedFolderChangeRequest();
            this.setQueuedFolderChangeRequest(null);
            this.msgApp.getAccountManager().selectAccount(folderChangeRequest.getAccountId());
            this.msgApp.getFolderNavigator().changeFolderDirect(folderChangeRequest.getFolderId(), true);
        }
        if (this.operationState != n2) {
            this.operationState = n2;
            this.msgApp.getModelAccess().setOperationStateChoice(2200351, n2);
            this.emitIndicateOperationState(n2);
        }
    }

    private void setUnsynchedOperationState(int n) {
        this.log.log(10000000, "[EntryList#logUnsyncedOperationState] operationState = %1", (long)n);
    }

    private void clear() {
        this.log.log(10000000, "[EntryList#clear]");
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
            this.log.log(10000000, "[EntryList#selectEntry] index = %1", (long)n);
            boolean bl = false;
            if (n >= 0 && n < this.getLength() && (evoListRow = this.listModel.getRow(n)) != null) {
                this.entrySelected(evoListRow);
                bl = true;
            }
            return bl;
        }
    }

    public void toggleEntryRow(EntryListRow entryListRow, int n, boolean bl) {
        this.log.log(10000000, "[EntryList#toggleEntryRow]");
        entryListRow.toggleRow(entryListRow, bl);
        this.listModel.setRow(n, entryListRow);
    }

    public void deselectAllRows() {
        this.log.log(10000000, "[EntryList#deselectAllRows]");
        try {
            for (int i2 = 0; i2 < this.listModel.getLength(); ++i2) {
                EntryListRow entryListRow = (EntryListRow)this.listModel.getRow(i2);
                if (entryListRow == null) continue;
                this.toggleEntryRow(entryListRow, i2, false);
            }
        }
        catch (Exception exception) {
            this.log.log(1000000, "[EntryList#deselectAllRows]", (Throwable)exception);
        }
    }

    private boolean isKeepOffsetChange(ListChangedInformation listChangedInformation) {
        int n;
        boolean bl = false;
        bl = listChangedInformation == null ? true : (n = listChangedInformation.getReason()) == 1 || n == 4 || n == 5 || n == 3 || n == 2 || n == 8;
        return bl;
    }

    private void autoLoadListItems(boolean bl, ListChangedInformation listChangedInformation) {
        this.log.log(10000000, "[EntryList#autoLoadListItems]");
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
        this.log.log(10000000, "[EntryList#loadListItems]");
        ListDataRequest listDataRequest = new ListDataRequest(++this.lastRequestId, n3, n, n2, bl, listChangedInformation, this.focusedRow, this.listModel.getMenu().getAdvice());
        new ListEntriesCommand(this.msgApp, this.commandResultHandler, listDataRequest).schedule();
    }

    private void folderSelected(ListEntry listEntry) {
        FolderEntry folderEntry = listEntry.getFolderEntry();
        this.log.log(10000000, "[EntryList#folderSelected] folderEntry = %1", (Object)folderEntry);
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
                this.log.log(10000000, "[EntryList#findSubFolderToFocus] subFolderId = %1, indexToFocus = %2, rowToFocus = %3", (Object)String.valueOf(n), (Object)String.valueOf(n2), (Object)String.valueOf(entryListRow));
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
        this.log.log(10000000, "[EntryList#findRowToFocus] rowToFocus = %1", (Object)String.valueOf(entryListRow2));
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
        this.log.log(1000000, "[EntryList#entrySelected] listEntry = %1", (Object)listEntry);
        this.setFocusedItem(entryListRow);
        if (!ListEntries.isMessage(listEntry)) {
            this.folderSelected(listEntry);
        }
        this.emitIndicateItemSelected(listEntry, evoListRow.getUniqueID());
    }

    public void setSelectedItemTypeModel(boolean bl) {
        this.log.log(1000000, "[EntryList#setSelectedItemTypeModel] isMessage = %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200352).setValue(n);
    }

    private Timer createOperationTimer() {
        TimerListener timerListener = new TimerListener(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void fireTimer(Timer timer) {
                Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
                synchronized (object) {
                    EntryList.this.log.log(10000, "[EntryList#fireTimer] Operation timed out.");
                    if (EntryList.this.operationState == 0) {
                        EntryList.this.changeOperationState(3);
                    }
                }
            }

            public void cancelTimer(Timer timer) {
                EntryList.this.log.log(10000000, "[EntryList#cancelTimer]");
            }
        };
        return new Timer("(EntryList)", 190000L, true, timerListener);
    }

    private void setFocusedItem(EntryListRow entryListRow) {
        this.log.log(10000000, "[EntryList#setFocusedItem] row = %1", (Object)entryListRow);
        this.focusedRow = entryListRow;
        if (this.focusedRow != null) {
            this.emitIndicateItemFocused(this.focusedRow);
        }
    }

    public void setSelectedListItem(long l) {
        this.listModel.setSelectedUniqueID(l);
    }

    public void addObserver(IEntryListObserver iEntryListObserver) {
        this.log.log(10000000, "[EntryList#addObserver] observer = %1", (Object)iEntryListObserver);
        this.entryListObservers.add(iEntryListObserver);
    }

    private void emitIndicateItemFocused(EntryListRow entryListRow) {
        this.log.log(10000000, "[EntryList#emitIndicateItemFocused]");
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
        this.log.log(10000000, "[EntryList#emitIndicateItemSelected]");
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
        this.log.log(10000000, "[EntryList#emitIndicateItemSelected]");
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
        this.log.log(10000000, "[EntryList#emitIndicateListDataResponseOnFolderChange]");
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
        this.log.log(10000000, "[EntryList#emitIndicateOperationState]");
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
        this.log.log(10000000, "[EntryList#emitItemToSelect]");
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class MyI18NTarget
    implements I18NTarget {
        private MyI18NTarget() {
        }

        public void setLanguage(Language language) {
            if (EntryList.this.log.isInfo()) {
                EntryList.this.log.log(1000000, "[EntryList#setLanguage] language = %1", (Object)String.valueOf(language));
            }
            EntryList.this.handleHmiSettingsChanged();
        }
    }

    private class MyMsgListener
    implements MsgListener {
        private MyMsgListener() {
        }

        public void processMsg(int n) {
            if (n == 11) {
                EntryList.this.log.log(1000000, "[EntryList#processMsg] message = %1 (UNITS_CHANGED)", (long)n);
                EntryList.this.handleHmiSettingsChanged();
            }
        }
    }

    public static final class FolderChangeRequest {
        private final int accountId;
        private final int folderId;

        public FolderChangeRequest(int n, int n2) {
            this.accountId = n;
            this.folderId = n2;
        }

        public int getAccountId() {
            return this.accountId;
        }

        public int getFolderId() {
            return this.folderId;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("FolderChangeRequest {");
            buffer.append("accountId = ").append(this.getAccountId());
            buffer.append(", folderId = ").append(this.getFolderId());
            buffer.append('}');
            return buffer.toString();
        }
    }

    private final class MyMenuModelListener
    implements MenuModelListener {
        private MyMenuModelListener() {
        }

        public void itemFocused(int n, int n2, long l, int n3) {
            EntryList.this.log.log(1000000, "[EntryList#MyMenuModelListener#itemFocused] model = %1", (long)n2);
            if (n2 != EntryList.this.listModel.getID()) {
                EntryList.this.setFocusedItem(null);
            }
        }
    }

    private class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void indicateListChanged(ListChangedInformation listChangedInformation) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                try {
                    EntryList.this.log.log(10000000, "[EntryList#indicateListChanged]");
                    if (!EntryList.this.ignoreUpdates) {
                        EntryList.this.setUnsynchedOperationState(0);
                        EntryList.this.autoLoadListItems(true, listChangedInformation);
                    } else {
                        EntryList.this.log.log(100000, "[EntryList#indicateListChanged] Context information on current folder is invalid. Ignoring call.");
                    }
                }
                catch (Exception exception) {
                    Logs.logException(EntryList.this.log, exception, "[EntryList#indicateListChanged]");
                    EntryList.this.setUnsynchedOperationState(3);
                }
            }
        }
    }

    private final class FolderNavigatorObserver
    extends IFolderNavigatorObserver.EmptyImplementation {
        private FolderNavigatorObserver() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void indicateFolderChange(boolean bl) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                EntryList.this.log.log(10000000, "[EntryList#indicateFolderChange] inProgress = %1", bl);
                EntryList.this.isFolderChangeInProgress = true;
                if (bl) {
                    EntryList.this.changeOperationState(0);
                    EntryList.this.setAwaitFolderChange(false);
                } else if (!EntryList.this.currentFolder.isValid()) {
                    EntryList.this.changeOperationState(3);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateCurrentFolder(Folder folder) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                EntryList.this.log.log(10000000, "[EntryList#updateCurrentFolder] currentFolder = %1", (Object)folder);
                EntryList.this.currentFolder = folder;
                boolean bl = folder.isValid();
                EntryList.this.setIgnoreUpdates(!bl);
                if (!bl) {
                    EntryList.this.clear();
                }
            }
        }
    }

    private class MyTiledListModelListener
    extends DefaultTiledListModelListener {
        private MyTiledListModelListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                EntryList.this.log.log(1000000, "[EntryList#itemSelected] index = %2, row = %1", (Object)evoListRow, (long)n2);
                if (evoListRow == null) {
                    EntryList.this.log.log(100000, "[EntryList#MyTiledListModelListener#itemSelected] selectedRow is null!");
                } else if (!EntryList.this.isDeletionMode) {
                    EntryList.this.entrySelected(evoListRow);
                    EntryList.this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
                } else {
                    EntryList.this.emitIndicateItemSelected(evoListRow, n, n2, n3, n4);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                EntryList.this.log.log(1000000, "[EntryList#itemFocused] index = %2, row = %1", (Object)evoListRow, (long)n2);
                EntryList.this.setFocusedItem((EntryListRow)evoListRow);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void requestItems(int n, int n2, int n3, int n4, int n5) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                try {
                    EntryList.this.log.log(1000000, "[EntryList#requestItems] startIndex = %1, length = %2, requestID = %3", (long)n, (long)n2, (long)n3);
                    EntryList.this.setUnsynchedOperationState(0);
                    EntryList.this.loadListItems(n, n2, n3, false, null);
                }
                catch (Exception exception) {
                    Logs.logException(EntryList.this.log, exception, "[EntryList#requestItems]");
                    EntryList.this.setUnsynchedOperationState(3);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void unrequestItems(int n, int n2, int n3, int n4) {
            Object object = EntryList.this.messagingBundleContext.getMessagingHmiLock();
            synchronized (object) {
                EntryList.this.log.log(1000000, "[EntryList#unrequestItems] startIndex = %1, length = %2", (long)n, (long)n2);
                EntryList.this.listModel.clearRows(n, n2);
            }
        }
    }
}

