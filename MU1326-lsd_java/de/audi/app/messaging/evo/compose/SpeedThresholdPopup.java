/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.compose.SpeedThresholdPopup$EvoActionProxy;
import de.audi.app.messaging.evo.compose.SpeedThresholdPopup$MyButtonListener;
import de.audi.atip.log.LogChannel;

public final class SpeedThresholdPopup
extends AbstractMessagingComponent {
    public SpeedThresholdPopup(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        SpeedThresholdPopup$MyButtonListener speedThresholdPopup$MyButtonListener = new SpeedThresholdPopup$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1368596736).setButtonListener(speedThresholdPopup$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1385373952).setButtonListener(speedThresholdPopup$MyButtonListener);
        abstractMsgApplication.getActionProxyService().addSubscriber(new SpeedThresholdPopup$EvoActionProxy(this, null));
    }

    private void compositionSpeedPopupOkButton(int n, int n2) {
        this.log.log(1078071040, "[SpeedThresholdPopup#compositionSpeedPopupOkButton]");
        this.repositionCompositionScreenCursor();
    }

    private void repositionCompositionScreenCursor() {
        this.log.log(-2137614336, "[SpeedThresholdPopup#repositionCompositionScreenCursor]");
        this.msgApp.getNewMessage().setCursorPosition(3);
    }

    static /* synthetic */ void access$200(SpeedThresholdPopup speedThresholdPopup, int n, int n2) {
        speedThresholdPopup.compositionSpeedPopupOkButton(n, n2);
    }

    static /* synthetic */ LogChannel access$300(SpeedThresholdPopup speedThresholdPopup) {
        return speedThresholdPopup.log;
    }

    static /* synthetic */ LogChannel access$400(SpeedThresholdPopup speedThresholdPopup) {
        return speedThresholdPopup.log;
    }

    static /* synthetic */ void access$500(SpeedThresholdPopup speedThresholdPopup) {
        speedThresholdPopup.repositionCompositionScreenCursor();
    }
}

