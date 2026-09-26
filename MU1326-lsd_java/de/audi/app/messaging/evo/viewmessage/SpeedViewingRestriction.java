/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.viewmessage.SpeedViewingRestriction$MySpeedThresholdListener;
import de.audi.atip.log.LogChannel;

public final class SpeedViewingRestriction
extends AbstractMessagingComponent {
    public SpeedViewingRestriction(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingService().addSpeedThresholdListener(new SpeedViewingRestriction$MySpeedThresholdListener(this, null));
    }

    private void enableViewingRestriction(boolean bl) {
        this.log.log(-2137614336, "[SpeedViewingRestriction#enableViewingRestriction] enable = %1", bl);
        int n = bl ? 4 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(1771249920).setValue(n);
    }

    static /* synthetic */ LogChannel access$100(SpeedViewingRestriction speedViewingRestriction) {
        return speedViewingRestriction.log;
    }

    static /* synthetic */ void access$200(SpeedViewingRestriction speedViewingRestriction, boolean bl) {
        speedViewingRestriction.enableViewingRestriction(bl);
    }

    static /* synthetic */ LogChannel access$300(SpeedViewingRestriction speedViewingRestriction) {
        return speedViewingRestriction.log;
    }
}

