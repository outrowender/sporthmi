/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.IAccountListObserver$EmptyImplementation;
import de.audi.app.messaging.core.folderbrowsing.EntryList$FolderChangeRequest;
import de.audi.app.messaging.evo.accounts.AccountListSubMenu;
import de.audi.app.messaging.evo.accounts.AccountListSubMenu$1;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MessagingAccount;

final class AccountListSubMenu$AccountListObserver
extends IAccountListObserver$EmptyImplementation {
    private final /* synthetic */ AccountListSubMenu this$0;

    private AccountListSubMenu$AccountListObserver(AccountListSubMenu accountListSubMenu) {
        this.this$0 = accountListSubMenu;
    }

    @Override
    public void indicateSelectionPending(int n, int n2, boolean bl) {
        if (AccountListSubMenu.access$100(this.this$0).isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("[AccountListSubMenu(").append(AccountListSubMenu.access$200(this.this$0)).append(")#indicateSelectionPending] ");
            buffer.append("isSubmenuEnabled = ").append(AccountListSubMenu.access$300(this.this$0)).append(", ");
            buffer.append("oldIndex = ").append(n).append(", ");
            buffer.append("newIndex = ").append(n2).append(", ");
            buffer.append("isObservedAccountChange = ").append(bl);
            AccountListSubMenu.access$400(this.this$0).log(-2137614336, buffer.toString());
        }
        if (!bl && n2 != -1) {
            AccountListSubMenu.access$500(this.this$0).getEntryList().setAwaitFolderChange(true);
        }
        if (AccountListSubMenu.access$300(this.this$0)) {
            AccountListSubMenu.access$600(this.this$0).removeAll();
            AccountListSubMenu.access$600(this.this$0).setSelectedIndex(-1);
        }
    }

    @Override
    public void indicateItemSelected(MessagingAccount messagingAccount) {
        AccountListSubMenu.access$700(this.this$0).log(-2137614336, "[AccountListSubMenu(%1)#indicateItemSelected], messagingAccount = %2", (Object)AccountListSubMenu.access$200(this.this$0), (Object)messagingAccount);
        AccountListSubMenu.access$802(this.this$0, messagingAccount);
        AccountListSubMenu.access$900(this.this$0);
        AccountListSubMenu.access$1000(this.this$0).getFolderNavigator().changeFolderDirect(-1, true);
        AccountListSubMenu.access$1100(this.this$0).getEntryList().setAwaitFolderChange(false);
        if (AccountListSubMenu.access$300(this.this$0)) {
            AccountListSubMenu.access$600(this.this$0).append(AccountListSubMenu.access$1200());
        } else {
            AccountListSubMenu.access$600(this.this$0).trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
        }
        AccountListSubMenu.access$600(this.this$0).fireEvent(0);
    }

    @Override
    public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
        AccountListSubMenu.access$1300(this.this$0).log(-2137614336, "[AccountListSubMenu(%1)#indicateItemSelectedWhilyBusy], messagingAccount = %2", (Object)AccountListSubMenu.access$200(this.this$0), (Object)messagingAccount);
        AccountListSubMenu.access$802(this.this$0, messagingAccount);
        EntryList$FolderChangeRequest entryList$FolderChangeRequest = new EntryList$FolderChangeRequest(messagingAccount.getAccountID(), -1);
        AccountListSubMenu.access$1400(this.this$0).getEntryList().setQueuedFolderChangeRequest(entryList$FolderChangeRequest);
        if (AccountListSubMenu.access$300(this.this$0)) {
            AccountListSubMenu.access$600(this.this$0).append(AccountListSubMenu.access$1200());
        } else {
            AccountListSubMenu.access$600(this.this$0).trigger(ModelTrigger.CLOSE_SELECTION_DRAWER);
        }
        AccountListSubMenu.access$600(this.this$0).fireEvent(0);
    }

    /* synthetic */ AccountListSubMenu$AccountListObserver(AccountListSubMenu accountListSubMenu, AccountListSubMenu$1 accountListSubMenu$1) {
        this(accountListSubMenu);
    }
}

