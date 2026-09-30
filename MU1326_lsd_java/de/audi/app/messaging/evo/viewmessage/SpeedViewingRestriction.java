/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.sysapp.SpeedThresholdListener;

public final class SpeedViewingRestriction
extends AbstractMessagingComponent {
    public SpeedViewingRestriction(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingService().addSpeedThresholdListener(new MySpeedThresholdListener());
    }

    private void enableViewingRestriction(boolean bl) {
        this.log.log(10000000, "[SpeedViewingRestriction#enableViewingRestriction] enable = %1", bl);
        int n = bl ? 4 : 0;
        this.framework.getHmiServiceApp().getChoiceModel(2200425).setValue(n);
    }

    private final class MySpeedThresholdListener
    implements SpeedThresholdListener {
        private MySpeedThresholdListener() {
        }

        public void exceedsUpperThreshold(int n) {
            if (n == 11) {
                SpeedViewingRestriction.this.log.log(1000000, "[SpeedViewingRestriction#exceedsUpperThreshold]");
                SpeedViewingRestriction.this.enableViewingRestriction(true);
            }
        }

        public void belowLowerThreshold(int n) {
            if (n == 11) {
                SpeedViewingRestriction.this.log.log(1000000, "[SpeedViewingRestriction#belowLowerThreshold]");
                SpeedViewingRestriction.this.enableViewingRestriction(false);
            }
        }
    }
}

