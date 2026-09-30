/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.accounts.AccountManager;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.Folder;
import de.audi.app.messaging.core.folderbrowsing.IFolderNavigatorObserver;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.setup.ISetupManagerObserver;
import de.audi.app.messaging.core.setup.SetupManager;
import de.audi.atip.hmi.IHMIServiceApp;
import org.dsi.ifc.messaging.MessagingAccount;

public final class FolderPathDisplay
extends AbstractMessagingComponent {
    private static final int FOLDER_TEXT_IDX_NONE = 0;
    private static final int FOLDER_TEXT_IDX_ROOT_MOBILE_DYNAMIC = 1;
    private static final int FOLDER_TEXT_IDX_ROOT_MOBILE_STATIC = 2;
    private static final int FOLDER_TEXT_IDX_ROOT_SIM = 3;
    private static final int FOLDER_TEXT_IDX_DELETED = 4;
    private static final int FOLDER_TEXT_IDX_DRAFT = 5;
    private static final int FOLDER_TEXT_IDX_INBOX = 6;
    private static final int FOLDER_TEXT_IDX_OUTBOX = 7;
    private static final int FOLDER_TEXT_IDX_SENT = 8;
    private static final int FOLDER_TEXT_IDX_USER = 9;

    public FolderPathDisplay(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        IHMIServiceApp iHMIServiceApp = this.framework.getHmiServiceApp();
        EntryList entryList = abstractMsgApplication.getEntryList();
        entryList.registerForModelGroup(iHMIServiceApp.getLabelModel(2200451));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200454));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200453));
        entryList.registerForModelGroup(iHMIServiceApp.getChoiceModel(2200452));
        abstractMsgApplication.getFolderNavigator().addObserver(new FolderNavigatorObserver());
        abstractMsgApplication.getSetupManager().addObserver(new SetupManagerObserver());
    }

    private void setCurrentPathModels() {
        Object object;
        this.log.log(10000000, "[FolderPathDisplay#setCurrentPathModels]");
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
        object.getLabelModel(2200451).setText(string2);
        object.getChoiceModel(2200454).setValue(n);
        int n3 = FolderPathDisplay.getFolderTextIdx(n, n2);
        object.getChoiceModel(2200453).setValue(n3);
        int n4 = this.msgApp.getFolderNavigator().getParentFolderType();
        int n5 = FolderPathDisplay.getFolderTextIdx(n, n4);
        object.getChoiceModel(2200452).setValue(n5);
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

    private final class SetupManagerObserver
    implements ISetupManagerObserver {
        private SetupManagerObserver() {
        }

        public void indicateConfigurationChanged() {
            FolderPathDisplay.this.log.log(10000000, "[FolderPathDisplay#indicateConfigurationChanged]");
            FolderPathDisplay.this.setCurrentPathModels();
        }
    }

    private final class FolderNavigatorObserver
    extends IFolderNavigatorObserver.EmptyImplementation {
        private FolderNavigatorObserver() {
        }

        public void updateCurrentFolder(Folder folder) {
            FolderPathDisplay.this.log.log(10000000, "[FolderPathDisplay#updateCurrentFolder]");
            FolderPathDisplay.this.setCurrentPathModels();
        }
    }
}

