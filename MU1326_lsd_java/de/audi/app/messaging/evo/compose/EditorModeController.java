/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.compose.CoreEditorModeController;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.sysapp.SpeedThresholdListener;

public final class EditorModeController
extends CoreEditorModeController {
    private volatile boolean isSpeedThresholdExceeded = false;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public EditorModeController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingService().addSpeedThresholdListener(new MySpeedThresholdListener());
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = EditorModeController.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new MyMsgListener(), ServiceProperties.createServiceProperties());
    }

    private boolean isSpeedThresholdExceeded() {
        return this.isSpeedThresholdExceeded;
    }

    private void setSpeedThresholdExceeded(boolean bl) {
        this.log.log(10000000, "[EditorModeController#setSpeedThresholdExceeded] isSpeedThresholdExceeded = %1", bl);
        this.isSpeedThresholdExceeded = bl;
        this.setTextEditorMode();
    }

    private void setTextEditorMode() {
        boolean bl = this.isSpeedThresholdExceeded() || this.isLockingAvailable();
        int n = bl ? 1 : 0;
        this.log.log(10000000, "[EditorModeController#setTextEditorMode] textEditorMode = %1", (long)n);
        this.msgApp.getNewMessage().getSubjectTextEditor().setMode(n);
        this.msgApp.getNewMessage().getBodyTextEditor().setMode(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class MyMsgListener
    implements MsgListener {
        private MyMsgListener() {
        }

        public void processMsg(int n) {
            boolean bl;
            boolean bl2 = n == 206;
            boolean bl3 = bl = n == 207;
            if (bl2 || bl) {
                EditorModeController.this.log.log(1000000, "[EditorModeController#MyMsgListener#processMsg] LOCK_FEATURE_ACTIVATED=%1, LOCK_FEATURE_DEACTIVATED=%1", bl2, bl);
                EditorModeController.this.setTextEditorMode();
            }
        }
    }

    private final class MySpeedThresholdListener
    implements SpeedThresholdListener {
        private MySpeedThresholdListener() {
        }

        public void exceedsUpperThreshold(int n) {
            if (n == 11) {
                EditorModeController.this.log.log(1000000, "[EditorModeController#exceedsUpperThreshold]");
                EditorModeController.this.setSpeedThresholdExceeded(true);
            }
        }

        public void belowLowerThreshold(int n) {
            if (n == 11) {
                EditorModeController.this.log.log(1000000, "[EditorModeController#belowLowerThreshold]");
                EditorModeController.this.setSpeedThresholdExceeded(false);
            }
        }
    }
}

