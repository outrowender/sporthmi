/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.hmi.model.DefaultButtonListener;

public final class DiscardDraftController
extends AbstractMessagingComponent {
    public DiscardDraftController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200426).setButtonListener(myButtonListener);
    }

    private void discardDraftButton(int n, int n2) {
        this.log.log(1000000, "[DiscardDraftController#discardDraftButton]");
        this.msgApp.getNewMessage().setIsAutoPositionCursorNeeded(n != 2200426);
        this.msgApp.getNewMessage().clear();
        this.msgApp.getNewMessage().resetIsAutoPositionCursorNeeded();
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private final class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200426) {
                DiscardDraftController.this.discardDraftButton(n, n3);
            } else {
                DiscardDraftController.this.log.log(10000, "[DiscardDraftController#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }
}

