/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.accounts.IAccountListObserver;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.accounts.AccountListSubMenuListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MessagingAccount;

public final class AccountListSubMenu
extends AbstractMessagingComponent
implements BaseListModelListener {
    private static final AccountListSubMenuListRow[] LIST_ROWS = new AccountListSubMenuListRow[]{new AccountListSubMenuListRow(0), new AccountListSubMenuListRow(1), new AccountListSubMenuListRow(2)};
    private static final int AUTO_SELECT_FOLDER_ID = -1;
    private final String instanceId;
    private final BaseListModelApp listModel;
    private final boolean isSubmenuEnabled;
    private volatile MessagingAccount accountSelectedInList;

    public AccountListSubMenu(MessagingBundleContext messagingBundleContext, BaseListModelApp baseListModelApp, String string, boolean bl) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.instanceId = string;
        this.listModel = baseListModelApp;
        this.isSubmenuEnabled = bl;
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(this);
    }

    public void associate(AccountList accountList) {
        accountList.addObserver(new AccountListObserver());
    }

    private void checkAndSelectAccount() {
        MessagingAccount messagingAccount;
        if (this.accountSelectedInList != null && ((messagingAccount = this.msgApp.getAccountManager().getSelectedAccount()) == null || messagingAccount.getAccountID() != this.accountSelectedInList.getAccountID())) {
            this.log.log(10000000, "[AccountListSubMenu(%1)#checkAndSelectAccount] Selecting account.");
            this.msgApp.getAccountManager().selectAccount(this.accountSelectedInList.getAccountID());
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        int n5 = ((AccountListSubMenuListRow)evoListRow).getType();
        this.log.log(1000000, "[AccountListSubMenu(%1)#itemSelected] row type = %2", (Object)this.instanceId, (long)n5);
        this.checkAndSelectAccount();
        this.listModel.setSelectedIndex(n2);
        int n6 = -1;
        if (n5 == 0) {
            n6 = -3;
        } else if (n5 == 1) {
            n6 = -5;
        }
        this.msgApp.getFolderNavigator().changeFolderDirect(n6, true);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n4);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private final class AccountListObserver
    extends IAccountListObserver.EmptyImplementation {
        private AccountListObserver() {
        }

        public void indicateSelectionPending(int n, int n2, boolean bl) {
            if (AccountListSubMenu.this.log.isDebug()) {
                Buffer buffer = new Buffer();
                buffer.append("[AccountListSubMenu(").append(AccountListSubMenu.this.instanceId).append(")#indicateSelectionPending] ");
                buffer.append("isSubmenuEnabled = ").append(AccountListSubMenu.this.isSubmenuEnabled).append(", ");
                buffer.append("oldIndex = ").append(n).append(", ");
                buffer.append("newIndex = ").append(n2).append(", ");
                buffer.append("isObservedAccountChange = ").append(bl);
                AccountListSubMenu.this.log.log(10000000, buffer.toString());
            }
            if (!bl && n2 != -1) {
                AccountListSubMenu.this.msgApp.getEntryList().setAwaitFolderChange(true);
            }
            if (AccountListSubMenu.this.isSubmenuEnabled) {
                AccountListSubMenu.this.listModel.removeAll();
                AccountListSubMenu.this.listModel.setSelectedIndex(-1);
            }
        }

        public void indicateItemSelected(MessagingAccount messagingAccount) {
            AccountListSubMenu.this.log.log(10000000, "[AccountListSubMenu(%1)#indicateItemSelected], messagingAccount = %2", (Object)AccountListSubMenu.this.instanceId, (Object)messagingAccount);
            AccountListSubMenu.this.accountSelectedInList = messagingAccount;
            AccountListSubMenu.this.checkAndSelectAccount();
            AccountListSubMenu.this.msgApp.getFolderNavigator().changeFolderDirect(-1, true);
            AccountListSubMenu.this.msgApp.getEntryList().setAwaitFolderChange(false);
            if (AccountListSubMenu.this.isSubmenuEnabled) {
                AccountListSubMenu.this.listModel.append(LIST_ROWS);
            } else {
                AccountListSubMenu.this.listModel.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            }
            AccountListSubMenu.this.listModel.fireEvent(0);
        }

        public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
            AccountListSubMenu.this.log.log(10000000, "[AccountListSubMenu(%1)#indicateItemSelectedWhilyBusy], messagingAccount = %2", (Object)AccountListSubMenu.this.instanceId, (Object)messagingAccount);
            AccountListSubMenu.this.accountSelectedInList = messagingAccount;
            EntryList.FolderChangeRequest folderChangeRequest = new EntryList.FolderChangeRequest(messagingAccount.getAccountID(), -1);
            AccountListSubMenu.this.msgApp.getEntryList().setQueuedFolderChangeRequest(folderChangeRequest);
            if (AccountListSubMenu.this.isSubmenuEnabled) {
                AccountListSubMenu.this.listModel.append(LIST_ROWS);
            } else {
                AccountListSubMenu.this.listModel.trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
            }
            AccountListSubMenu.this.listModel.fireEvent(0);
        }
    }
}

