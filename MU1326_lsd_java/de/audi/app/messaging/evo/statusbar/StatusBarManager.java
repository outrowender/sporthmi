/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.statusbar;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;

public final class StatusBarManager
extends AbstractMessagingComponent {
    public StatusBarManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new NewMessageIndicationManagerObserver());
    }

    private synchronized void setStatusBarIcons() {
        boolean bl = this.msgApp.getNewMessageIndicationManager().isMemoryDepleted();
        boolean bl2 = this.msgApp.getNewMessageIndicationManager().newMessagesAvailable();
        if (this.log.isInfo()) {
            this.log.log(1000000, "[StatusBarManager#setStatusBarIcons] newMessageAvailable = %1, memoryDepleted = %2", (Object)String.valueOf(bl2), (Object)String.valueOf(bl));
        }
        int n = bl2 ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(4447).setValue(n);
        int n2 = bl ? 1 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(4446).setValue(n2);
    }

    private class NewMessageIndicationManagerObserver
    implements INewMessageIndicationManagerObserver {
        private NewMessageIndicationManagerObserver() {
        }

        public void indicateIndicationStateChanged(int n) {
            StatusBarManager.this.log.log(10000000, "[StatusBarManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
            StatusBarManager.this.setStatusBarIcons();
        }
    }
}

