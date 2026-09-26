/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController$1;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;
import org.dsi.ifc.messaging.MessagingAccount;

final class PhoneRingMenuController$EvoActionProxy
extends DefaultEvoActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ PhoneRingMenuController this$0;

    private PhoneRingMenuController$EvoActionProxy(PhoneRingMenuController phoneRingMenuController) {
        this.this$0 = phoneRingMenuController;
    }

    @Override
    public void messagingTransition(int n, int n2) {
        PhoneRingMenuController.access$600(this.this$0).log(-2137614336, "[PhoneRingMenuController#messagingTransition]");
        if (n2 == 0) {
            MessagingAccount messagingAccount = PhoneRingMenuController.access$700(this.this$0).getAccountManager().getSelectedAccount();
            if (messagingAccount != null) {
                PhoneRingMenuController.access$500(this.this$0, messagingAccount);
            } else {
                PhoneRingMenuController.access$800(this.this$0).log(-1601830656, "[PhoneRingMenuController#messagingTransition] No account selected.");
            }
        }
    }

    /* synthetic */ PhoneRingMenuController$EvoActionProxy(PhoneRingMenuController phoneRingMenuController, PhoneRingMenuController$1 phoneRingMenuController$1) {
        this(phoneRingMenuController);
    }
}

