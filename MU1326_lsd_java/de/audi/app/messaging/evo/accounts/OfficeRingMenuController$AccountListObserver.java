/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.IAccountListObserver$EmptyImplementation;
import de.audi.app.messaging.evo.accounts.OfficeRingMenuController;
import de.audi.app.messaging.evo.accounts.OfficeRingMenuController$1;
import org.dsi.ifc.messaging.MessagingAccount;

final class OfficeRingMenuController$AccountListObserver
extends IAccountListObserver$EmptyImplementation {
    private final /* synthetic */ OfficeRingMenuController this$0;

    private OfficeRingMenuController$AccountListObserver(OfficeRingMenuController officeRingMenuController) {
        this.this$0 = officeRingMenuController;
    }

    @Override
    public void indicateItemSelected(MessagingAccount messagingAccount) {
        OfficeRingMenuController.access$100(this.this$0).log(-2137614336, "[OfficeRingMenuController#indicateItemSelected]");
        OfficeRingMenuController.access$200(this.this$0).getHMIService().getChoiceModel(3995).setValue(1);
    }

    /* synthetic */ OfficeRingMenuController$AccountListObserver(OfficeRingMenuController officeRingMenuController, OfficeRingMenuController$1 officeRingMenuController$1) {
        this(officeRingMenuController);
    }
}

