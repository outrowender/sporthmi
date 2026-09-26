/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.accounts.AccountListSubMenu$AccountListObserver;
import de.audi.app.messaging.evo.accounts.AccountListSubMenuListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MessagingAccount;

public final class AccountListSubMenu
extends AbstractMessagingComponent
implements BaseListModelListener {
    private static final AccountListSubMenuListRow[] LIST_ROWS = new AccountListSubMenuListRow[]{new AccountListSubMenuListRow(0), new AccountListSubMenuListRow(1), new AccountListSubMenuListRow(2)};
    private static final int AUTO_SELECT_FOLDER_ID;
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

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.listModel.setListener(this);
    }

    public void associate(AccountList accountList) {
        accountList.addObserver(new AccountListSubMenu$AccountListObserver(this, null));
    }

    private void checkAndSelectAccount() {
        MessagingAccount messagingAccount;
        if (this.accountSelectedInList != null && ((messagingAccount = this.msgApp.getAccountManager().getSelectedAccount()) == null || messagingAccount.getAccountID() != this.accountSelectedInList.getAccountID())) {
            this.log.log(-2137614336, "[AccountListSubMenu(%1)#checkAndSelectAccount] Selecting account.");
            this.msgApp.getAccountManager().selectAccount(this.accountSelectedInList.getAccountID());
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        int n5 = ((AccountListSubMenuListRow)evoListRow).getType();
        this.log.log(1078071040, "[AccountListSubMenu(%1)#itemSelected] row type = %2", (Object)this.instanceId, (long)n5);
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

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    static /* synthetic */ LogChannel access$100(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.log;
    }

    static /* synthetic */ String access$200(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.instanceId;
    }

    static /* synthetic */ boolean access$300(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.isSubmenuEnabled;
    }

    static /* synthetic */ LogChannel access$400(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.log;
    }

    static /* synthetic */ AbstractMsgApplication access$500(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.msgApp;
    }

    static /* synthetic */ BaseListModelApp access$600(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.listModel;
    }

    static /* synthetic */ LogChannel access$700(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.log;
    }

    static /* synthetic */ MessagingAccount access$802(AccountListSubMenu accountListSubMenu, MessagingAccount messagingAccount) {
        accountListSubMenu.accountSelectedInList = messagingAccount;
        return accountListSubMenu.accountSelectedInList;
    }

    static /* synthetic */ void access$900(AccountListSubMenu accountListSubMenu) {
        accountListSubMenu.checkAndSelectAccount();
    }

    static /* synthetic */ AbstractMsgApplication access$1000(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$1100(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.msgApp;
    }

    static /* synthetic */ AccountListSubMenuListRow[] access$1200() {
        return LIST_ROWS;
    }

    static /* synthetic */ LogChannel access$1300(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1400(AccountListSubMenu accountListSubMenu) {
        return accountListSubMenu.msgApp;
    }
}

