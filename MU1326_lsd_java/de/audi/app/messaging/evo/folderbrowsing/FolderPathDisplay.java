/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.setup.SetupManager;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay$FolderNavigatorObserver;
import de.audi.app.messaging.evo.folderbrowsing.FolderPathDisplay$SetupManagerObserver;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MessagingAccount;

public final class FolderPathDisplay
extends AbstractMessagingComponent {
    private static final int FOLDER_TEXT_IDX_NONE;
    private static final int FOLDER_TEXT_IDX_ROOT_MOBILE_DYNAMIC;
    private static final int FOLDER_TEXT_IDX_ROOT_MOBILE_STATIC;
    private static final int FOLDER_TEXT_IDX_ROOT_SIM;
    private static final int FOLDER_TEXT_IDX_DELETED;
    private static final int FOLDER_TEXT_IDX_DRAFT;
    private static final int FOLDER_TEXT_IDX_INBOX;
    private static final int FOLDER_TEXT_IDX_OUTBOX;
    private static final int FOLDER_TEXT_IDX_SENT;
    private static final int FOLDER_TEXT_IDX_USER;

    public FolderPathDisplay(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        EntryList entryList = abstractMsgApplication.getEntryList();
        entryList.registerForModelGroup(iHMIServiceApp.getLabelModel(-2087509760));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(-2037178112));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(-2053955328));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(-2070732544));
        abstractMsgApplication.getFolderNavigator().addObserver(new FolderPathDisplay$FolderNavigatorObserver(this, null));
        abstractMsgApplication.getSetupManager().addObserver(new FolderPathDisplay$SetupManagerObserver(this, null));
    }

    private void setCurrentPathModels() {
        Object object;
        this.log.log(-2137614336, "[FolderPathDisplay#setCurrentPathModels]");
        Folder folder = this.msgApp.getFolderNavigator().getCurrentFolder();
        boolean bl = false;
        String string = null;
        String string2 = "";
        int n = 0;
        int n2 = folder.getHmiFolderType();
        MessagingAccount messagingAccount = this.msgApp.getAccountManager().getSelectedAccount();
        if (messagingAccount != null) {
            object = this.msgApp.getSetupManager();
            bl = ((SetupManager)object).isBasedOnBtConnection(messagingAccount);
            string = ((SetupManager)object).getBtDeviceName(messagingAccount);
            string2 = AccountManager.getDynamicAccountName(messagingAccount, string);
            n = AccountManager.getAccountTextType(bl, string2);
        }
        object = this.framework.getHmiServiceApp();
        object.getLabelModel(-2087509760).setText(string2);
        object.getChoiceModel(-2037178112).setValue(n);
        int n3 = FolderPathDisplay.getFolderTextIdx(n, n2);
        object.getChoiceModel(-2053955328).setValue(n3);
        int n4 = this.msgApp.getFolderNavigator().getParentFolderType();
        int n5 = FolderPathDisplay.getFolderTextIdx(n, n4);
        object.getChoiceModel(-2070732544).setValue(n5);
    }

    private static int getFolderTextIdx(int n, int n2) {
        int n3 = 0;
        switch (n2) {
            case 2: {
                n3 = 4;
                break;
            }
            case 3: {
                n3 = 5;
                break;
            }
            case 4: {
                n3 = 6;
                break;
            }
            case 5: {
                n3 = 7;
                break;
            }
            case 1: {
                if (n == 2) {
                    n3 = 3;
                    break;
                }
                if (n == 1) {
                    n3 = 2;
                    break;
                }
                n3 = 1;
                break;
            }
            case 6: {
                n3 = 8;
                break;
            }
            case 7: {
                n3 = 9;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        return n3;
    }

    static /* synthetic */ LogChannel access$200(FolderPathDisplay folderPathDisplay) {
        return folderPathDisplay.log;
    }

    static /* synthetic */ void access$300(FolderPathDisplay folderPathDisplay) {
        folderPathDisplay.setCurrentPathModels();
    }

    static /* synthetic */ LogChannel access$400(FolderPathDisplay folderPathDisplay) {
        return folderPathDisplay.log;
    }
}

