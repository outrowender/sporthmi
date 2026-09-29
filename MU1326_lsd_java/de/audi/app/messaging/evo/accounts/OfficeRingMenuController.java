/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.accounts.OfficeRingMenuController$AccountListObserver;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;

public final class OfficeRingMenuController
extends AbstractMessagingComponent {
    public OfficeRingMenuController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().getEmailAccountList().addObserver(new OfficeRingMenuController$AccountListObserver(this, null));
    }

    static /* synthetic */ LogChannel access$100(OfficeRingMenuController officeRingMenuController) {
        return officeRingMenuController.log;
    }

    static /* synthetic */ IFrameworkAccess access$200(OfficeRingMenuController officeRingMenuController) {
        return officeRingMenuController.framework;
    }
}

