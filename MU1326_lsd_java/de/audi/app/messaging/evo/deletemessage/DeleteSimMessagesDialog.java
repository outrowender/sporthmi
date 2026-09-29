/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog$DeleteMessageControllerObserver;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog$EvoActionProxy;
import de.audi.app.messaging.evo.deletemessage.DeleteSimMessagesDialog$MyButtonListener;
import de.audi.atip.log.LogChannel;

public final class DeleteSimMessagesDialog
extends AbstractMessagingComponent {
    private static final int DELETE_SIM_MODE_INBOX_READ;
    private static final int DELETE_SIM_MODE_SENT;
    private volatile boolean isInMessagingState = false;
    private volatile int lastTerminalId = 0;

    public DeleteSimMessagesDialog(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        DeleteSimMessagesDialog$MyButtonListener deleteSimMessagesDialog$MyButtonListener = new DeleteSimMessagesDialog$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1502814464).setButtonListener(deleteSimMessagesDialog$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1486037248).setButtonListener(deleteSimMessagesDialog$MyButtonListener);
        abstractMsgApplication.getDeleteMessageController().addObserver(new DeleteSimMessagesDialog$DeleteMessageControllerObserver(this, null));
        abstractMsgApplication.getActionProxyService().addSubscriber(new DeleteSimMessagesDialog$EvoActionProxy(this, null));
    }

    private void startDialog(int n, int n2) {
        this.log.log(-2137614336, "[DeleteSimMessagesDialog#startDialog] deleteSimMode = %1", (long)n2);
        this.removePopups();
        this.lastTerminalId = n;
        this.setDeleteSimMode(n2);
        this.framework.getHmiServiceApp().showPartialPopup(n, 1452417280);
    }

    private void removePopups() {
        this.log.log(-2137614336, "[DeleteSimMessagesDialog#removePopups]");
        this.framework.getHmiServiceApp().removePartialPopup(this.lastTerminalId, 1485971712);
        this.framework.getHmiServiceApp().removePartialPopup(this.lastTerminalId, 1469194496);
        this.framework.getHmiServiceApp().removePartialPopup(this.lastTerminalId, 1452417280);
    }

    private void setDeleteSimMode(int n) {
        this.log.log(-2137614336, "[DeleteSimMessagesDialog#setDeleteSimMode] deleteSimMode = %1", (long)n);
        this.framework.getHmiServiceApp().getChoiceModel(1519591680).setValue(n);
    }

    private void setDeleteSimMessagesState(int n) {
        this.log.log(-2137614336, "[DeleteSimMessagesDialog#setDeleteSimMessagesState] operationState = %1", (long)n);
        if (this.isInMessagingState()) {
            if (n == 0) {
                this.removePopups();
            } else if (n == 1) {
                this.framework.getHmiServiceApp().showPartialPopup(this.lastTerminalId, 1485971712);
            } else if (n == 2 || n == 3) {
                this.framework.getHmiServiceApp().showPartialPopup(this.lastTerminalId, 1469194496);
            }
        }
    }

    private boolean isInMessagingState() {
        return this.isInMessagingState;
    }

    private void setIsInMessagingState(boolean bl) {
        this.log.log(-2137614336, "[DeleteSimMessagesDialog#setIsInMessagingState] isInMessagingState = %1", bl);
        this.isInMessagingState = bl;
        if (!this.isInMessagingState()) {
            this.removePopups();
        }
    }

    private void deleteSimModeInboxReadButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteSimMessagesDialog#deleteSimModeInboxReadButton]");
        this.startDialog(n2, 0);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimModeSentButton(int n, int n2) {
        this.log.log(1078071040, "[DeleteSimMessagesDialog#deleteSimModeSentButton]");
        this.startDialog(n2, 1);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ void access$300(DeleteSimMessagesDialog deleteSimMessagesDialog, int n, int n2) {
        deleteSimMessagesDialog.deleteSimModeInboxReadButton(n, n2);
    }

    static /* synthetic */ void access$400(DeleteSimMessagesDialog deleteSimMessagesDialog, int n, int n2) {
        deleteSimMessagesDialog.deleteSimModeSentButton(n, n2);
    }

    static /* synthetic */ LogChannel access$500(DeleteSimMessagesDialog deleteSimMessagesDialog) {
        return deleteSimMessagesDialog.log;
    }

    static /* synthetic */ LogChannel access$600(DeleteSimMessagesDialog deleteSimMessagesDialog) {
        return deleteSimMessagesDialog.log;
    }

    static /* synthetic */ void access$700(DeleteSimMessagesDialog deleteSimMessagesDialog, int n) {
        deleteSimMessagesDialog.setDeleteSimMessagesState(n);
    }

    static /* synthetic */ LogChannel access$800(DeleteSimMessagesDialog deleteSimMessagesDialog) {
        return deleteSimMessagesDialog.log;
    }

    static /* synthetic */ void access$900(DeleteSimMessagesDialog deleteSimMessagesDialog, boolean bl) {
        deleteSimMessagesDialog.setIsInMessagingState(bl);
    }
}

