/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;
import de.audi.atip.hmi.model.DefaultButtonListener;

public final class SpeedThresholdPopup
extends AbstractMessagingComponent {
    public SpeedThresholdPopup(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200401).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200402).setButtonListener(myButtonListener);
        abstractMsgApplication.getActionProxyService().addSubscriber(new EvoActionProxy());
    }

    private void compositionSpeedPopupOkButton(int n, int n2) {
        this.log.log(1000000, "[SpeedThresholdPopup#compositionSpeedPopupOkButton]");
        this.repositionCompositionScreenCursor();
    }

    private void repositionCompositionScreenCursor() {
        this.log.log(10000000, "[SpeedThresholdPopup#repositionCompositionScreenCursor]");
        this.msgApp.getNewMessage().setCursorPosition(3);
    }

    private final class EvoActionProxy
    extends DefaultEvoActionProxy
    implements IActionProxySubscriber {
        private EvoActionProxy() {
        }

        public void compositionSpeedThresholdPopupReturn(int n) {
            SpeedThresholdPopup.this.log.log(10000000, "[SpeedThresholdPopup#compositionSpeedThresholdPopupReturn]");
            SpeedThresholdPopup.this.repositionCompositionScreenCursor();
        }
    }

    private final class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200401 || n == 2200402) {
                SpeedThresholdPopup.this.compositionSpeedPopupOkButton(n, n3);
            } else {
                SpeedThresholdPopup.this.log.log(10000, "[SpeedThresholdPopup#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }
}

