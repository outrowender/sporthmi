/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.compose.CoreEditorModeController;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.evo.compose.EditorModeController$MyMsgListener;
import de.audi.app.messaging.evo.compose.EditorModeController$MySpeedThresholdListener;
import de.audi.atip.log.LogChannel;

public final class EditorModeController
extends CoreEditorModeController {
    private volatile boolean isSpeedThresholdExceeded = false;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public EditorModeController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingService().addSpeedThresholdListener(new EditorModeController$MySpeedThresholdListener(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = EditorModeController.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)new EditorModeController$MyMsgListener(this, null), ServiceProperties.createServiceProperties());
    }

    private boolean isSpeedThresholdExceeded() {
        return this.isSpeedThresholdExceeded;
    }

    private void setSpeedThresholdExceeded(boolean bl) {
        this.log.log(-2137614336, "[EditorModeController#setSpeedThresholdExceeded] isSpeedThresholdExceeded = %1", bl);
        this.isSpeedThresholdExceeded = bl;
        this.setTextEditorMode();
    }

    private void setTextEditorMode() {
        boolean bl = this.isSpeedThresholdExceeded() || this.isLockingAvailable();
        int n = bl ? 1 : 0;
        this.log.log(-2137614336, "[EditorModeController#setTextEditorMode] textEditorMode = %1", (long)n);
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

    static /* synthetic */ LogChannel access$200(EditorModeController editorModeController) {
        return editorModeController.log;
    }

    static /* synthetic */ void access$300(EditorModeController editorModeController, boolean bl) {
        editorModeController.setSpeedThresholdExceeded(bl);
    }

    static /* synthetic */ LogChannel access$400(EditorModeController editorModeController) {
        return editorModeController.log;
    }

    static /* synthetic */ LogChannel access$500(EditorModeController editorModeController) {
        return editorModeController.log;
    }

    static /* synthetic */ void access$600(EditorModeController editorModeController) {
        editorModeController.setTextEditorMode();
    }
}

