/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.accounts.IAccountManagerListener;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.ChangeFolderCommand;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.FolderNavigatorObserverProxy;
import de.audi.app.messaging.core.folderbrowsing.Folders;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.IHMIServiceApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Stack;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.MessagingAccount;

public final class FolderNavigator
extends AbstractMessagingComponent {
    static final int FOLDER_CHANGE_DIRECT = 0;
    static final int FOLDER_CHANGE_DOWN = 1;
    static final int FOLDER_CHANGE_UP = 2;
    private volatile FolderNavigatorObserverProxy observerProxy;
    private volatile int upChangeLevelLimit = 0;
    private final Stack pathNodeStack = new Stack();
    private final ChangeFolderCommand.ResultHandler commandResultHandler = new ChangeFolderCommand.ResultHandler(){

        public void handleResult(boolean bl, int n, FolderEntry folderEntry, int n2, int n3, int n4) {
            FolderNavigator.this.handleCommandResult(bl, n, folderEntry, n2, n3, n4);
        }
    };
    private volatile Folder currentFolder = Folder.FOLDER_NONE;
    private volatile Folder lastSubFolder = Folder.FOLDER_NONE;
    private volatile boolean isFolderChangeInProgress = false;

    public FolderNavigator(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        EntryList entryList = abstractMsgApplication.getEntryList();
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200341));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200129));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200164));
        entryList.registerForModelGroup(iHMIServiceApp.getLabelModel(2200329));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200343));
        entryList.registerForModelGroup(iHMIServiceApp.getLabelModel(2200342));
        this.initObserverProxy();
        abstractMsgApplication.getAccountManager().addListener(new AccountManagerListener());
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
    }

    private void initObserverProxy() {
        this.observerProxy = new FolderNavigatorObserverProxy(this.log);
        this.observerProxy.updateCurrentFolder(this.currentFolder);
    }

    public void addObserver(IFolderNavigatorObserver iFolderNavigatorObserver) {
        this.log.log(10000000, "[FolderNavigator#addObserver] observer = %1", (Object)iFolderNavigatorObserver);
        this.observerProxy.addObserver(iFolderNavigatorObserver);
    }

    public void removeObserver(IFolderNavigatorObserver iFolderNavigatorObserver) {
        this.log.log(10000000, "[FolderNavigator#removeObserver] observer = %1", (Object)iFolderNavigatorObserver);
        this.observerProxy.removeObserver(iFolderNavigatorObserver);
    }

    public Folder getCurrentFolder() {
        return this.currentFolder;
    }

    public int getParentFolderType() {
        int n = Folder.FOLDER_NONE.getHmiFolderType();
        int n2 = this.currentFolder.getLevel();
        if (n2 == 1) {
            n = 1;
        } else if (n2 > 1) {
            Folder folder = this.msgApp.getFolderNavigator().getPathNodeAt(n2 - 2);
            n = folder.getHmiFolderType();
        }
        return n;
    }

    private String getParentFolderName() {
        String string = "";
        int n = this.currentFolder.getLevel();
        if (n > 1) {
            Folder folder = this.getPathNodeAt(n - 2);
            string = folder.getFolderEntry().getFolderName();
        }
        return string;
    }

    public Folder getLastSubFolder() {
        return this.lastSubFolder;
    }

    public void changeFolderUp() throws IllegalStateException {
        this.log.log(10000000, "[FolderNavigator#changeFolderUp]");
        this.assertNoFolderChangeInProgress();
        if (!this.isUpChangePermitted()) {
            throw new IllegalStateException(new StringBuffer().append("Up-changes not permitted, current state: this = %1").append(this).toString());
        }
        int n = this.currentFolder.getLevel() - 1;
        int n2 = n > 0 ? this.currentFolder.getHmiFolderType() : 1;
        this.triggerFolderChange(2, -2, n2, n);
    }

    public void changeFolderDown(FolderEntry folderEntry) throws IllegalStateException {
        this.log.log(10000000, "[FolderNavigator#changeFolderDown] subFolderEntry = %1", (Object)folderEntry);
        this.assertNoFolderChangeInProgress();
        int n = this.currentFolder.getHmiFolderType();
        int n2 = this.currentFolder.getLevel();
        if (n2 == 0) {
            try {
                n = Folders.mapToHmiFolderType(folderEntry);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                Logs.logException(this.log, illegalArgumentException, "[FolderNavigator#changeToSubFolder]");
                n = 0;
            }
        }
        this.triggerFolderChange(1, folderEntry.getFolderID(), n, n2 + 1);
    }

    public void changeFolderDirect(int n, boolean bl) throws IllegalArgumentException, IllegalStateException {
        this.log.log(10000000, "[FolderNavigator#changeFolderDirect] predefinedFolderId = %2, limitUpChanges = %1", bl, (long)n);
        this.assertNoFolderChangeInProgress();
        if (!Folders.isPredefinedFolderId(n)) {
            throw new IllegalArgumentException("Argument is not a predefined folder ID.");
        }
        if (n == -2) {
            throw new IllegalArgumentException("Method does not support changes to the parent folder.");
        }
        int n2 = 0;
        int n3 = 0;
        switch (n) {
            case -9: 
            case -1: {
                n2 = 0;
                n3 = 1;
                break;
            }
            case -6: {
                n2 = 1;
                n3 = 2;
                break;
            }
            case -7: {
                n2 = 1;
                n3 = 3;
                break;
            }
            case -8: 
            case -3: {
                n2 = 1;
                n3 = 4;
                break;
            }
            case -4: {
                n2 = 1;
                n3 = 5;
                break;
            }
            case -5: {
                n2 = 1;
                n3 = 6;
                break;
            }
            default: {
                throw new IllegalArgumentException("Unexpected folder ID.");
            }
        }
        this.setUpChangeLevelLimit(bl ? n2 : 0);
        this.triggerFolderChange(0, n, n3, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            Buffer buffer = new Buffer();
            buffer.append("FolderNavigator {pathNodeStack = ");
            buffer.append(this.pathNodeStack);
            buffer.append(", currentFolder = ");
            buffer.append(this.currentFolder);
            buffer.append(", upChangeLevelLimit = ");
            buffer.append(this.upChangeLevelLimit);
            buffer.append('}');
            return buffer.toString();
        }
    }

    private void assertNoFolderChangeInProgress() throws IllegalStateException {
        if (this.isFolderChangeInProgress) {
            throw new IllegalStateException("A folder change is already in progress.");
        }
    }

    private void markFolderChangeInProgress(boolean bl) {
        this.log.log(10000000, "[FolderNavigator#markFolderChangeInProgress] inProgress = %1", bl);
        int n = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200134).setValue(n);
        if (this.isFolderChangeInProgress != bl) {
            this.isFolderChangeInProgress = bl;
            this.observerProxy.indicateFolderChange(bl);
        }
    }

    private void handleCommandResult(boolean bl, int n, FolderEntry folderEntry, int n2, int n3, int n4) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[FolderNavigator#handleCommandResult] success = %1, folderChangeType = %2, folderLevel = %3", (Object)String.valueOf(bl), (Object)String.valueOf(n), (Object)String.valueOf(n4));
            this.log.log(10000000, "[FolderNavigator#handleCommandResult] Pre-update state: this = %1", (Object)this);
        }
        boolean bl2 = !bl;
        try {
            if (bl) {
                int n5 = n4;
                if (n4 < 0) {
                    this.log.log(100000, "[FolderNavigator#handleCommandResult] Invalid new folderLevel = %1, correcting to folderLevel = 0.", (long)n4);
                    n5 = 0;
                }
                this.lastSubFolder = n == 2 ? this.currentFolder : Folder.FOLDER_NONE;
                Folder folder = new Folder(folderEntry, n5, n3, n2);
                this.updatePathNodeStack(folder, n);
                this.setCurrentFolder(folder);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[FolderNavigator#handleCommandResult] Error updating folder context information: ", (Throwable)exception);
            bl2 = true;
        }
        if (bl2) {
            this.reset();
            this.observerProxy.indicateFolderChangeFailed(this.currentFolder.getHmiFolderType());
        }
        this.markFolderChangeInProgress(false);
        if (this.log.isDebug()) {
            this.log.log(10000000, "[FolderNavigator#handleCommandResult] Post-update state: this = %1", (Object)this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void reset() {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.pathNodeStack.clear();
            this.setCurrentFolder(Folder.FOLDER_NONE);
            this.lastSubFolder = Folder.FOLDER_NONE;
        }
    }

    private boolean isUpChangePermitted() {
        boolean bl = this.currentFolder.isValid();
        int n = this.currentFolder.getLevel();
        return bl && n > this.upChangeLevelLimit;
    }

    private void setUpChangeLevelLimit(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("upChangeLevelLimit cannot be negative.");
        }
        this.upChangeLevelLimit = n;
    }

    private void triggerFolderChange(int n, int n2, int n3, int n4) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[FolderNavigator#triggerFolderChange] folderChangeType = %1, folderID = %2, hmiFolderType = %3, folderLevel = %4", (Object)String.valueOf(n), (Object)String.valueOf(n2), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
        }
        try {
            MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
            if (messagingAccount == null) {
                throw new IllegalStateException("No account selected.");
            }
            this.markFolderChangeInProgress(true);
            new ChangeFolderCommand(this.msgApp, this.commandResultHandler, n, n3, n4, n2, this.msgApp.getAccountManager().isEmailMode() ? 2 : 1, messagingAccount.getAccountID(), 4, 2).schedule();
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[FolderNavigator#triggerFolderChange]");
            this.log.log(10000, "[FolderNavigator#triggerFolderChange] Calling handleCommandResult() with error code.");
            this.handleCommandResult(false, n, null, n2, n3, n4);
        }
    }

    private void setCurrentFolder(Folder folder) {
        this.log.log(10000000, "[FolderNavigator#setCurrentFolder] folder = %1", (Object)folder);
        this.currentFolder = folder;
        this.setCurrentFolderModels();
        this.observerProxy.updateCurrentFolder(this.currentFolder);
    }

    private void setCurrentFolderModels() {
        this.log.log(10000000, "[FolderNavigator#setCurrentFolderModels]");
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        int n = this.currentFolder.getLevel();
        iHMIServiceApp.getChoiceModel(2200341).setValue(n);
        int n2 = this.isUpChangePermitted() ? 1 : 0;
        iHMIServiceApp.getChoiceModel(2200129).setValue(n2);
        iHMIServiceApp.getChoiceModel(2200164).setValue(this.currentFolder.getHmiFolderType());
        String string = this.currentFolder.isValid() ? this.currentFolder.getFolderEntry().getFolderName() : "";
        iHMIServiceApp.getLabelModel(2200329).setText(string);
        int n3 = this.getParentFolderType();
        String string2 = this.getParentFolderName();
        iHMIServiceApp.getChoiceModel(2200343).setValue(n3);
        iHMIServiceApp.getLabelModel(2200342).setText(string2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updatePathNodeStack(Folder folder, int n) {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            this.log.log(10000000, "[FolderNavigator#updatePathNodeStack] folder.getRequestFolderId() = %1, folder.getHmiFolderType = %2, folderChangeType = %3", (long)folder.getRequestFolderId(), (long)folder.getHmiFolderType(), (long)n);
            try {
                int n2 = folder.getRequestFolderId();
                int n3 = folder.getLevel();
                if (n == 1) {
                    this.log.log(10000000, "[FolderNavigator#updatePathNodeStack] Change to subfolder.");
                    if (n3 != this.pathNodeStack.size() + 1) {
                        throw new IllegalStateException("Folder level contradicts stack size.");
                    }
                    this.pathNodeStack.push(folder);
                } else if (n == 2) {
                    this.log.log(10000000, "[FolderNavigator#updatePathNodeStack] Change to parent folder.");
                    if (n3 != this.pathNodeStack.size() - 1) {
                        throw new IllegalStateException("Folder level contradicts stack size.");
                    }
                    this.pathNodeStack.setSize(n3);
                } else if (n2 == -1 || n2 == -9) {
                    this.log.log(10000000, "[FolderNavigator#updatePathNodeStack] Direct change to root folder.");
                    if (n3 != 0) {
                        throw new IllegalStateException("Folder level is not 0.");
                    }
                    this.pathNodeStack.clear();
                } else {
                    this.log.log(10000000, "[FolderNavigator#updatePathNodeStack] Direct change to standard folder.");
                    this.pathNodeStack.clear();
                    this.pathNodeStack.push(folder);
                }
            }
            catch (Exception exception) {
                this.log.log(100000, "[FolderNavigator#updatePathNodeStack] Error updating the path node stack: ", (Throwable)exception);
                this.pathNodeStack.clear();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Folder getPathNodeAt(int n) throws IllegalArgumentException {
        Object object = this.messagingBundleContext.getMessagingHmiLock();
        synchronized (object) {
            if (n < 0 || n >= this.pathNodeStack.size()) {
                throw new IllegalArgumentException(new StringBuffer().append("No path node at index = ").append(n).append(".").toString());
            }
            Folder folder = (Folder)this.pathNodeStack.elementAt(n);
            return folder;
        }
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void parentFolderSelected(int n) {
            FolderNavigator.this.log.log(10000000, "[FolderNavigator#parentFolderSelected]");
            FolderNavigator.this.changeFolderUp();
        }
    }

    private final class AccountManagerListener
    extends IAccountManagerListener.DefaultAccountManagerListener {
        private AccountManagerListener() {
        }

        public void selectedAccountChanged() {
            FolderNavigator.this.log.log(10000000, "[FolderNavigator#selectedAccountChanged]");
            FolderNavigator.this.reset();
        }
    }
}

