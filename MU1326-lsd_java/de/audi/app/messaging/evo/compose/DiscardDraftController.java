/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.compose.DiscardDraftController$MyButtonListener;
import de.audi.atip.log.LogChannel;

public final class DiscardDraftController
extends AbstractMessagingComponent {
    public DiscardDraftController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        DiscardDraftController$MyButtonListener discardDraftController$MyButtonListener = new DiscardDraftController$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1788027136).setButtonListener(discardDraftController$MyButtonListener);
    }

    private void discardDraftButton(int n, int n2) {
        this.log.log(1078071040, "[DiscardDraftController#discardDraftButton]");
        this.msgApp.getNewMessage().setIsAutoPositionCursorNeeded(n != 1788027136);
        this.msgApp.getNewMessage().clear();
        this.msgApp.getNewMessage().resetIsAutoPositionCursorNeeded();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$100(DiscardDraftController discardDraftController, int n, int n2) {
        discardDraftController.discardDraftButton(n, n2);
    }

    static /* synthetic */ LogChannel access$200(DiscardDraftController discardDraftController) {
        return discardDraftController.log;
    }
}

