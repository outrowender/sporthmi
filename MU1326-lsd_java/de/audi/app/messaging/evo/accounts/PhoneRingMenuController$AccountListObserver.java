/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.IAccountListObserver$EmptyImplementation;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController$1;
import org.dsi.ifc.messaging.MessagingAccount;

final class PhoneRingMenuController$AccountListObserver
extends IAccountListObserver$EmptyImplementation {
    private final /* synthetic */ PhoneRingMenuController this$0;

    private PhoneRingMenuController$AccountListObserver(PhoneRingMenuController phoneRingMenuController) {
        this.this$0 = phoneRingMenuController;
    }

    @Override
    public void indicateItemSelected(MessagingAccount messagingAccount) {
        PhoneRingMenuController.access$500(this.this$0, messagingAccount);
    }

    @Override
    public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
        PhoneRingMenuController.access$500(this.this$0, messagingAccount);
    }

    /* synthetic */ PhoneRingMenuController$AccountListObserver(PhoneRingMenuController phoneRingMenuController, PhoneRingMenuController$1 phoneRingMenuController$1) {
        this(phoneRingMenuController);
    }
}

