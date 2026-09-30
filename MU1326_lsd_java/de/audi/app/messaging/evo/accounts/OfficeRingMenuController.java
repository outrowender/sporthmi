/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.IAccountListObserver;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import org.dsi.ifc.messaging.MessagingAccount;

public final class OfficeRingMenuController
extends AbstractMessagingComponent {
    public OfficeRingMenuController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().getEmailAccountList().addObserver(new AccountListObserver());
    }

    private final class AccountListObserver
    extends IAccountListObserver.EmptyImplementation {
        private AccountListObserver() {
        }

        public void indicateItemSelected(MessagingAccount messagingAccount) {
            OfficeRingMenuController.this.log.log(10000000, "[OfficeRingMenuController#indicateItemSelected]");
            OfficeRingMenuController.this.framework.getHMIService().getChoiceModel(3995).setValue(1);
        }
    }
}

