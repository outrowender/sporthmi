/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.INewMessageObserver;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.IMessagingDictationServiceListener;

public final class MessageLengthPopup
extends AbstractMessagingComponent {
    private volatile boolean isInEditView = false;
    private volatile int editViewTerminalId = 0;
    private volatile boolean isSubjectLengthExceeded = false;
    private volatile boolean isBodyLengthExceeded = false;
    private volatile boolean isDictationDialogActive = false;
    private volatile boolean isConfirmed = false;

    public MessageLengthPopup(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200416).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200415).setButtonListener(myButtonListener);
        abstractMsgApplication.getNewMessage().addObserver(new NewMessageObserver());
        abstractMsgApplication.getActionProxyService().addSubscriber(new EvoActionProxy());
        MessagingDictationService messagingDictationService = abstractMsgApplication.getMessagingDictationService();
        if (messagingDictationService != null) {
            messagingDictationService.addListener(new MessagingDictationServiceListener());
        }
    }

    private boolean isInEditView() {
        return this.isInEditView;
    }

    public int getEditViewTerminalId() {
        return this.editViewTerminalId;
    }

    private void setIsInEditView(boolean bl, int n) {
        this.log.log(10000000, "[MessageLengthPopup#setIsInEditView] isInEditView = %1, editViewTerminalId = %2", bl, (long)n);
        this.editViewTerminalId = n;
        this.isInEditView = bl;
        this.setPopupVisibility();
    }

    private boolean isSubjectLengthExceeded() {
        return this.isSubjectLengthExceeded;
    }

    private boolean isBodyLengthExceeded() {
        return this.isBodyLengthExceeded;
    }

    private void setMessageLength(boolean bl, boolean bl2) {
        this.log.log(10000000, "[MessageLengthPopup#setMessageLength] isSubjectLengthExceeded = %1, isBodyLengthExceeded = %2", bl, bl2);
        this.isSubjectLengthExceeded = bl;
        this.isBodyLengthExceeded = bl2;
        if (!bl2) {
            this.setConfirmed(false);
        }
        this.setPopupVisibility();
    }

    private boolean isDictationDialogActive() {
        return this.isDictationDialogActive;
    }

    private void setDictationDialogActive(boolean bl) {
        this.log.log(10000000, "[MessageLengthPopup#setDictationDialogActive] isDictationDialogActive = %1", bl);
        this.isDictationDialogActive = bl;
        this.setPopupVisibility();
    }

    private boolean isConfirmed() {
        return this.isConfirmed;
    }

    private void setConfirmed(boolean bl) {
        this.log.log(10000000, "[MessageLengthPopup#setConfirmed] isConfirmed = %1", bl);
        this.isConfirmed = bl;
        this.setPopupVisibility();
    }

    private void setPopupVisibility() {
        this.log.log(10000000, "[MessageLengthPopup#showPopupOnViolation] isSubjectLengthExceeded = %1, isBodyLengthExceeded = %2", this.isSubjectLengthExceeded(), this.isBodyLengthExceeded());
        if (this.isInEditView() && this.isBodyLengthExceeded() && !this.isDictationDialogActive() && !this.isConfirmed()) {
            int n = this.msgApp.getAccountManager().isEmailMode() ? 2200155 : 2200154;
            this.framework.getHmiServiceApp().showPartialPopup(this.getEditViewTerminalId(), n);
        } else {
            this.removePopups();
        }
    }

    private void removePopups() {
        this.log.log(10000000, "[MessageLengthPopup#removePopups]");
        this.framework.getHmiServiceApp().removePartialPopup(this.getEditViewTerminalId(), 2200154);
        this.framework.getHmiServiceApp().removePartialPopup(this.getEditViewTerminalId(), 2200155);
    }

    private void bodyLengthExceededOkButton(int n, int n2) {
        this.log.log(1000000, "[MessageLengthPopup#bodyLengthExceededOkButton]");
        this.setConfirmed(true);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private final class EvoActionProxy
    extends DefaultEvoActionProxy
    implements IActionProxySubscriber {
        private EvoActionProxy() {
        }

        public void editViewTransition(int n, int n2) {
            MessageLengthPopup.this.log.log(10000000, "[MessageLengthPopup#editViewTransition]");
            MessageLengthPopup.this.setIsInEditView(n2 == 0, n);
        }
    }

    private final class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200416 || n == 2200415) {
                MessageLengthPopup.this.bodyLengthExceededOkButton(n, n3);
            } else {
                MessageLengthPopup.this.log.log(10000, "[MessageLengthPopup#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private final class NewMessageObserver
    extends INewMessageObserver.DefaultNewMessageObserver {
        private NewMessageObserver() {
        }

        public void indicateMessageLength(int n, int n2) {
            boolean bl = n < 0;
            boolean bl2 = n2 < 0;
            MessageLengthPopup.this.log.log(10000000, "[MessageLengthPopup#indicateMessageLength] maxSubjectLengthExceeded = %1, maxBodyLengthExceeded = %2", bl, bl2);
            MessageLengthPopup.this.setMessageLength(bl, bl2);
        }
    }

    private final class MessagingDictationServiceListener
    extends IMessagingDictationServiceListener.EmptyImplementation {
        private MessagingDictationServiceListener() {
        }

        public void updateCompositionState(IMessagingDictationService.CompositionState compositionState) {
            MessageLengthPopup.this.log.log(10000000, "[MessageLengthPopup#updateCompositionState] compositionState.isDialogActive() = %1", compositionState.isDialogActive());
            MessageLengthPopup.this.setDictationDialogActive(compositionState.isDialogActive());
        }
    }
}

