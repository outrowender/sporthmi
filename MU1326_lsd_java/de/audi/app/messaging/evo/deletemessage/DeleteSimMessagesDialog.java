/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.deletemessage.IDeleteMessageControllerObserver;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;
import de.audi.atip.hmi.model.DefaultButtonListener;

public final class DeleteSimMessagesDialog
extends AbstractMessagingComponent {
    private static final int DELETE_SIM_MODE_INBOX_READ = 0;
    private static final int DELETE_SIM_MODE_SENT = 1;
    private volatile boolean isInMessagingState = false;
    private volatile int lastTerminalId = 0;

    public DeleteSimMessagesDialog(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200409).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200408).setButtonListener(myButtonListener);
        abstractMsgApplication.getDeleteMessageController().addObserver(new DeleteMessageControllerObserver());
        abstractMsgApplication.getActionProxyService().addSubscriber(new EvoActionProxy());
    }

    private void startDialog(int n, int n2) {
        this.log.log(10000000, "[DeleteSimMessagesDialog#startDialog] deleteSimMode = %1", (long)n2);
        this.removePopups();
        this.lastTerminalId = n;
        this.setDeleteSimMode(n2);
        this.framework.getHmiServiceApp().showPartialPopup(n, 2200150);
    }

    private void removePopups() {
        this.log.log(10000000, "[DeleteSimMessagesDialog#removePopups]");
        this.framework.getHmiServiceApp().removePartialPopup(this.lastTerminalId, 2200152);
        this.framework.getHmiServiceApp().removePartialPopup(this.lastTerminalId, 2200151);
        this.framework.getHmiServiceApp().removePartialPopup(this.lastTerminalId, 2200150);
    }

    private void setDeleteSimMode(int n) {
        this.log.log(10000000, "[DeleteSimMessagesDialog#setDeleteSimMode] deleteSimMode = %1", (long)n);
        this.framework.getHmiServiceApp().getChoiceModel(2200410).setValue(n);
    }

    private void setDeleteSimMessagesState(int n) {
        this.log.log(10000000, "[DeleteSimMessagesDialog#setDeleteSimMessagesState] operationState = %1", (long)n);
        if (this.isInMessagingState()) {
            if (n == 0) {
                this.removePopups();
            } else if (n == 1) {
                this.framework.getHmiServiceApp().showPartialPopup(this.lastTerminalId, 2200152);
            } else if (n == 2 || n == 3) {
                this.framework.getHmiServiceApp().showPartialPopup(this.lastTerminalId, 2200151);
            }
        }
    }

    private boolean isInMessagingState() {
        return this.isInMessagingState;
    }

    private void setIsInMessagingState(boolean bl) {
        this.log.log(10000000, "[DeleteSimMessagesDialog#setIsInMessagingState] isInMessagingState = %1", bl);
        this.isInMessagingState = bl;
        if (!this.isInMessagingState()) {
            this.removePopups();
        }
    }

    private void deleteSimModeInboxReadButton(int n, int n2) {
        this.log.log(1000000, "[DeleteSimMessagesDialog#deleteSimModeInboxReadButton]");
        this.startDialog(n2, 0);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void deleteSimModeSentButton(int n, int n2) {
        this.log.log(1000000, "[DeleteSimMessagesDialog#deleteSimModeSentButton]");
        this.startDialog(n2, 1);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private final class EvoActionProxy
    extends DefaultEvoActionProxy
    implements IActionProxySubscriber {
        private EvoActionProxy() {
        }

        public void messagingTransition(int n, int n2) {
            DeleteSimMessagesDialog.this.log.log(10000000, "[DeleteSimMessagesDialog#messagingTransition]");
            DeleteSimMessagesDialog.this.setIsInMessagingState(n2 == 0);
        }
    }

    private final class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200409) {
                DeleteSimMessagesDialog.this.deleteSimModeInboxReadButton(n, n3);
            } else if (n == 2200408) {
                DeleteSimMessagesDialog.this.deleteSimModeSentButton(n, n3);
            } else {
                DeleteSimMessagesDialog.this.log.log(10000, "[DeleteSimMessagesDialog#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private final class DeleteMessageControllerObserver
    implements IDeleteMessageControllerObserver {
        private DeleteMessageControllerObserver() {
        }

        public void indicateDeleteSimMessagesState(int n) {
            DeleteSimMessagesDialog.this.log.log(10000000, "[DeleteSimMessagesDialog#indicateDeleteSimMessagesState]");
            DeleteSimMessagesDialog.this.setDeleteSimMessagesState(n);
        }
    }
}

