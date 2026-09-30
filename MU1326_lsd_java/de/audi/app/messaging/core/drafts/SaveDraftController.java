/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.StatusInformation;

public final class SaveDraftController
extends AbstractMessagingComponent {
    private static final int SAVE_DRAFT_RESULT_OK = 0;
    private static final int SAVE_DRAFT_RESULT_ERROR_GENERAL = 1;
    private static final int SAVE_DRAFT_RESULT_ERROR_MEMORY_DEPLETED = 2;
    private volatile boolean autoSaveOnCompositionExit = false;
    private volatile Message lastSavedMessage;
    private final SaveAsDraftCommand.LastSavedMessageGetter lastSavedMessageGetter = new SaveAsDraftCommand.LastSavedMessageGetter(){

        public Message get() {
            return SaveDraftController.this.lastSavedMessage;
        }
    };
    private final SaveAsDraftCommand.ResultHandler commandResultHandler = new SaveAsDraftCommand.ResultHandler(){

        public void handleResult(int n, String string, Message message) {
            SaveDraftController.this.handleCommandResult(n, string, message);
        }
    };

    public SaveDraftController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        MyButtonListener myButtonListener = new MyButtonListener();
        this.framework.getHmiServiceApp().getButtonModel(2200494).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200385).setButtonListener(myButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(2200301).setButtonListener(myButtonListener);
        abstractMsgApplication.getActionProxyService().addSubscriber(new CoreActionProxy());
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
    }

    public void setAutoSavePolicy(boolean bl) {
        this.log.log(10000000, "[SaveDraftController#setAutoSavePolicy] autoSaveOnCompositionExit = %1", bl);
        this.autoSaveOnCompositionExit = bl;
    }

    private void setSaveDraftState(int n, int n2) {
        this.framework.getHmiServiceApp().getChoiceModel(2200300).setValue(n2);
        this.msgApp.getModelAccess().setOperationStateChoice(2200327, n);
    }

    public void saveDraftIfJustified(boolean bl) {
        if (this.framework.getSysConst(4062) == 1) {
            this.log.log(1000000, "[SaveDraftController#saveDraftIfJustified] Template-only system, skipping save procedure.");
        } else if (this.msgApp.getAccountManager().getSelectedAccount() == null) {
            this.log.log(1000000, "[SaveDraftController#saveDraftIfJustified] No account selected, skipping save procedure.");
        } else {
            Message message = this.msgApp.getNewMessage().getTruncatedMessage();
            MessageDetails messageDetails = message.getMessageDetails();
            int n = messageDetails.getMessagingAccountID();
            MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n);
            if (!Accounts.supportsDrafts(messagingAccount) && this.log.isInfo()) {
                this.log.log(1000000, "[SaveDraftController#saveDraftIfJustified] Account does not support drafts, skipping save procedure.");
            } else {
                boolean bl2;
                boolean bl3 = this.lastSavedMessage == null || message.getChangeId() > this.lastSavedMessage.getChangeId();
                boolean bl4 = bl ? this.isBlankWithoutAttachments(messageDetails) : Messages.isBlank(messageDetails);
                boolean bl5 = !"".equals(messageDetails.getMessageID());
                boolean bl6 = message.getChangeId() != message.getInitialChangeId();
                boolean bl7 = bl5 && !bl6;
                boolean bl8 = bl2 = bl3 && !bl4 && !bl7;
                if (this.log.isInfo()) {
                    Buffer buffer = new Buffer();
                    buffer.append("[SaveDraftController#saveDraftIfJustified] ");
                    buffer.append("isSaveJustified = ").append(bl2).append(", ");
                    buffer.append("discardAttachments = ").append(bl).append(", ");
                    buffer.append("lastSavedMessage = ").append(this.lastSavedMessage).append(", ");
                    buffer.append("currentMessage = ").append(message).append(", ");
                    buffer.append("isBlankDraftCandidate = ").append(bl4).append(", ");
                    this.log.log(1000000, buffer.toString());
                }
                if (bl2) {
                    this.saveAsDraft(bl);
                }
            }
        }
    }

    public void saveAsDraft(boolean bl) {
        try {
            this.log.log(10000000, "[SaveDraftController#saveAsDraft] discardAttachments = %1", bl);
            this.setSaveDraftState(0, 1);
            Message message = this.msgApp.getNewMessage().getTruncatedMessage();
            MessageDetails messageDetails = message.getMessageDetails();
            boolean bl2 = messageDetails.getAttachments() != null && messageDetails.getAttachments().length > 0;
            AttachmentInformation[] attachmentInformationArray = bl ? new AttachmentInformation[]{} : messageDetails.getAttachments();
            String string = messageDetails.getBody();
            String string2 = this.msgApp.getTextLookup().getAttachmentsDiscardedHint();
            if (!Strings.isNullOrEmpty(string2) && bl2 && bl) {
                this.log.log(1000000, "[SaveDraftController#saveAsDraft] discardAttachments = true && attachments available -> add text");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(string2);
                stringBuffer.append(string);
                string = stringBuffer.toString();
            }
            new SaveAsDraftCommand(this.msgApp, this.lastSavedMessageGetter, this.commandResultHandler, message, string, attachmentInformationArray).schedule();
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SaveDraftController#saveAsDraft]");
            this.setSaveDraftState(2, 1);
        }
    }

    private void handleCommandResult(int n, String string, Message message) {
        int n2;
        int n3;
        int n4 = n3 = n == 0 ? 1 : 2;
        if (n == 0) {
            n2 = 0;
            MessageDetails messageDetails = Messages.copy(message.getMessageDetails());
            messageDetails.messageID = string;
            this.lastSavedMessage = new Message(message.getHmiMessageId(), message.getInitialChangeId(), message.getChangeId(), messageDetails);
            this.emitIndicateDraftSaved(message, string);
        } else {
            n2 = n == 7 ? 2 : 1;
        }
        this.setSaveDraftState(n3, n2);
    }

    private boolean isBlankWithoutAttachments(MessageDetails messageDetails) {
        MessageDetails messageDetails2 = new MessageDetails(messageDetails.getMessagingAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), messageDetails.getDateTime(), messageDetails.getMessageStatus(), messageDetails.getReplyTo(), messageDetails.getBody(), new AttachmentInformation[0], messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
        return Messages.isBlank(messageDetails2);
    }

    private void emitIndicateDraftSaved(Message message, String string) {
        try {
            this.msgApp.getNewMessage().indicateDraftSaved(message, string);
        }
        catch (Exception exception) {
            Logs.logException(this.log, exception, "[SaveDraftController#emitIndicateDraftSaved]");
        }
    }

    private void saveAsDraftButton(int n, int n2) {
        this.log.log(1000000, "[SaveDraftController#saveAsDraftButton] modelID = %1", (long)n);
        if (!this.msgApp.getNewMessage().exceedsMaxBodyLength()) {
            this.saveAsDraft(false);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void forceSaveAsDraftButton(int n, int n2) {
        this.log.log(1000000, "[SaveDraftController#forceSaveAsDraftButton]");
        this.saveAsDraft(false);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private final class CoreActionProxy
    extends DefaultCoreActionProxy
    implements IActionProxySubscriber {
        private CoreActionProxy() {
        }

        public void messageCompositionTransition(int n, int n2) {
            SaveDraftController.this.log.log(10000000, "[SaveDraftController#messageCompositionTransition]");
            if (SaveDraftController.this.autoSaveOnCompositionExit && n2 == 1) {
                SaveDraftController.this.saveDraftIfJustified(true);
            }
        }
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 2200494 || n == 2200385) {
                SaveDraftController.this.saveAsDraftButton(n, n3);
            } else if (n == 2200301) {
                SaveDraftController.this.forceSaveAsDraftButton(n, n3);
            } else {
                SaveDraftController.this.log.log(10000, "[SaveDraftController#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private final class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public void indicateMessageStatus(StatusInformation statusInformation) {
            String string;
            String string2;
            Message message;
            SaveDraftController.this.log.log(10000000, "[SaveDraftController#indicateMessageStatus]");
            if (statusInformation.getStatus() == 1 && (message = SaveDraftController.this.lastSavedMessage) != null && (string2 = statusInformation.getMessageId()).equals(string = message.getMessageDetails().getMessageID())) {
                SaveDraftController.this.log.log(1000000, "[SaveDraftController#indicateMessageStatus] Most recently saved draft has been deleted, clearing cached information on that draft.");
                SaveDraftController.this.lastSavedMessage = null;
            }
        }
    }
}

