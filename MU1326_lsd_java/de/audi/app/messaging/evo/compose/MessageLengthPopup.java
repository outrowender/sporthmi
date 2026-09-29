/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$EvoActionProxy;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$MessagingDictationServiceListener;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$MyButtonListener;
import de.audi.app.messaging.evo.compose.MessageLengthPopup$NewMessageObserver;
import de.audi.atip.log.LogChannel;

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

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MessageLengthPopup$MyButtonListener messageLengthPopup$MyButtonListener = new MessageLengthPopup$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(1620254976).setButtonListener(messageLengthPopup$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1603477760).setButtonListener(messageLengthPopup$MyButtonListener);
        abstractMsgApplication.getNewMessage().addObserver(new MessageLengthPopup$NewMessageObserver(this, null));
        abstractMsgApplication.getActionProxyService().addSubscriber(new MessageLengthPopup$EvoActionProxy(this, null));
        MessagingDictationService messagingDictationService = abstractMsgApplication.getMessagingDictationService();
        if (messagingDictationService != null) {
            messagingDictationService.addListener(new MessageLengthPopup$MessagingDictationServiceListener(this, null));
        }
    }

    private boolean isInEditView() {
        return this.isInEditView;
    }

    public int getEditViewTerminalId() {
        return this.editViewTerminalId;
    }

    private void setIsInEditView(boolean bl, int n) {
        this.log.log(-2137614336, "[MessageLengthPopup#setIsInEditView] isInEditView = %1, editViewTerminalId = %2", bl, (long)n);
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
        this.log.log(-2137614336, "[MessageLengthPopup#setMessageLength] isSubjectLengthExceeded = %1, isBodyLengthExceeded = %2", bl, bl2);
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
        this.log.log(-2137614336, "[MessageLengthPopup#setDictationDialogActive] isDictationDialogActive = %1", bl);
        this.isDictationDialogActive = bl;
        this.setPopupVisibility();
    }

    private boolean isConfirmed() {
        return this.isConfirmed;
    }

    private void setConfirmed(boolean bl) {
        this.log.log(-2137614336, "[MessageLengthPopup#setConfirmed] isConfirmed = %1", bl);
        this.isConfirmed = bl;
        this.setPopupVisibility();
    }

    private void setPopupVisibility() {
        this.log.log(-2137614336, "[MessageLengthPopup#showPopupOnViolation] isSubjectLengthExceeded = %1, isBodyLengthExceeded = %2", this.isSubjectLengthExceeded(), this.isBodyLengthExceeded());
        if (this.isInEditView() && this.isBodyLengthExceeded() && !this.isDictationDialogActive() && !this.isConfirmed()) {
            int n = this.msgApp.getAccountManager().isEmailMode() ? 1536303360 : 1519526144;
            this.framework.getHmiServiceApp().showPartialPopup(this.getEditViewTerminalId(), n);
        } else {
            this.removePopups();
        }
    }

    private void removePopups() {
        this.log.log(-2137614336, "[MessageLengthPopup#removePopups]");
        this.framework.getHmiServiceApp().removePartialPopup(this.getEditViewTerminalId(), 1519526144);
        this.framework.getHmiServiceApp().removePartialPopup(this.getEditViewTerminalId(), 1536303360);
    }

    private void bodyLengthExceededOkButton(int n, int n2) {
        this.log.log(1078071040, "[MessageLengthPopup#bodyLengthExceededOkButton]");
        this.setConfirmed(true);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ LogChannel access$400(MessageLengthPopup messageLengthPopup) {
        return messageLengthPopup.log;
    }

    static /* synthetic */ void access$500(MessageLengthPopup messageLengthPopup, boolean bl, boolean bl2) {
        messageLengthPopup.setMessageLength(bl, bl2);
    }

    static /* synthetic */ LogChannel access$600(MessageLengthPopup messageLengthPopup) {
        return messageLengthPopup.log;
    }

    static /* synthetic */ void access$700(MessageLengthPopup messageLengthPopup, boolean bl, int n) {
        messageLengthPopup.setIsInEditView(bl, n);
    }

    static /* synthetic */ LogChannel access$800(MessageLengthPopup messageLengthPopup) {
        return messageLengthPopup.log;
    }

    static /* synthetic */ void access$900(MessageLengthPopup messageLengthPopup, boolean bl) {
        messageLengthPopup.setDictationDialogActive(bl);
    }

    static /* synthetic */ void access$1000(MessageLengthPopup messageLengthPopup, int n, int n2) {
        messageLengthPopup.bodyLengthExceededOkButton(n, n2);
    }

    static /* synthetic */ LogChannel access$1100(MessageLengthPopup messageLengthPopup) {
        return messageLengthPopup.log;
    }
}

