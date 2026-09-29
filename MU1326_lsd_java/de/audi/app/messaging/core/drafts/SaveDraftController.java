/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$LastSavedMessageGetter;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$ResultHandler;
import de.audi.app.messaging.core.drafts.SaveDraftController$1;
import de.audi.app.messaging.core.drafts.SaveDraftController$2;
import de.audi.app.messaging.core.drafts.SaveDraftController$CoreActionProxy;
import de.audi.app.messaging.core.drafts.SaveDraftController$MyButtonListener;
import de.audi.app.messaging.core.drafts.SaveDraftController$MyDsiMessagingListener;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;

public final class SaveDraftController
extends AbstractMessagingComponent {
    private static final int SAVE_DRAFT_RESULT_OK;
    private static final int SAVE_DRAFT_RESULT_ERROR_GENERAL;
    private static final int SAVE_DRAFT_RESULT_ERROR_MEMORY_DEPLETED;
    private volatile boolean autoSaveOnCompositionExit = false;
    private volatile Message lastSavedMessage;
    private final SaveAsDraftCommand$LastSavedMessageGetter lastSavedMessageGetter = new SaveDraftController$1(this);
    private final SaveAsDraftCommand$ResultHandler commandResultHandler = new SaveDraftController$2(this);

    public SaveDraftController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        SaveDraftController$MyButtonListener saveDraftController$MyButtonListener = new SaveDraftController$MyButtonListener(this, null);
        this.framework.getHmiServiceApp().getButtonModel(-1366089472).setButtonListener(saveDraftController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(1100161280).setButtonListener(saveDraftController$MyButtonListener);
        this.framework.getHmiServiceApp().getButtonModel(-309190400).setButtonListener(saveDraftController$MyButtonListener);
        abstractMsgApplication.getActionProxyService().addSubscriber(new SaveDraftController$CoreActionProxy(this, null));
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new SaveDraftController$MyDsiMessagingListener(this, null));
    }

    public void setAutoSavePolicy(boolean bl) {
        this.log.log(-2137614336, "[SaveDraftController#setAutoSavePolicy] autoSaveOnCompositionExit = %1", bl);
        this.autoSaveOnCompositionExit = bl;
    }

    private void setSaveDraftState(int n, int n2) {
        this.framework.getHmiServiceApp().getChoiceModel(-325967616).setValue(n2);
        this.msgApp.getModelAccess().setOperationStateChoice(127082752, n);
    }

    public void saveDraftIfJustified(boolean bl) {
        if (this.framework.getSysConst(4062) == 1) {
            this.log.log(1078071040, "[SaveDraftController#saveDraftIfJustified] Template-only system, skipping save procedure.");
        } else if (this.msgApp.getAccountManager().getSelectedAccount() == null) {
            this.log.log(1078071040, "[SaveDraftController#saveDraftIfJustified] No account selected, skipping save procedure.");
        } else {
            Message message = this.msgApp.getNewMessage().getTruncatedMessage();
            MessageDetails messageDetails = message.getMessageDetails();
            int n = messageDetails.getMessagingAccountID();
            MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n);
            if (!Accounts.supportsDrafts(messagingAccount) && this.log.isInfo()) {
                this.log.log(1078071040, "[SaveDraftController#saveDraftIfJustified] Account does not support drafts, skipping save procedure.");
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
                    this.log.log(1078071040, buffer.toString());
                }
                if (bl2) {
                    this.saveAsDraft(bl);
                }
            }
        }
    }

    public void saveAsDraft(boolean bl) {
        try {
            this.log.log(-2137614336, "[SaveDraftController#saveAsDraft] discardAttachments = %1", bl);
            this.setSaveDraftState(0, 1);
            Message message = this.msgApp.getNewMessage().getTruncatedMessage();
            MessageDetails messageDetails = message.getMessageDetails();
            boolean bl2 = messageDetails.getAttachments() != null && messageDetails.getAttachments().length > 0;
            AttachmentInformation[] attachmentInformationArray = bl ? new AttachmentInformation[]{} : messageDetails.getAttachments();
            String string = messageDetails.getBody();
            String string2 = this.msgApp.getTextLookup().getAttachmentsDiscardedHint();
            if (!Strings.isNullOrEmpty(string2) && bl2 && bl) {
                this.log.log(1078071040, "[SaveDraftController#saveAsDraft] discardAttachments = true && attachments available -> add text");
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
        this.log.log(1078071040, "[SaveDraftController#saveAsDraftButton] modelID = %1", (long)n);
        if (!this.msgApp.getNewMessage().exceedsMaxBodyLength()) {
            this.saveAsDraft(false);
        }
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    private void forceSaveAsDraftButton(int n, int n2) {
        this.log.log(1078071040, "[SaveDraftController#forceSaveAsDraftButton]");
        this.saveAsDraft(false);
        this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
    }

    static /* synthetic */ Message access$000(SaveDraftController saveDraftController) {
        return saveDraftController.lastSavedMessage;
    }

    static /* synthetic */ void access$100(SaveDraftController saveDraftController, int n, String string, Message message) {
        saveDraftController.handleCommandResult(n, string, message);
    }

    static /* synthetic */ void access$500(SaveDraftController saveDraftController, int n, int n2) {
        saveDraftController.saveAsDraftButton(n, n2);
    }

    static /* synthetic */ void access$600(SaveDraftController saveDraftController, int n, int n2) {
        saveDraftController.forceSaveAsDraftButton(n, n2);
    }

    static /* synthetic */ LogChannel access$700(SaveDraftController saveDraftController) {
        return saveDraftController.log;
    }

    static /* synthetic */ LogChannel access$800(SaveDraftController saveDraftController) {
        return saveDraftController.log;
    }

    static /* synthetic */ boolean access$900(SaveDraftController saveDraftController) {
        return saveDraftController.autoSaveOnCompositionExit;
    }

    static /* synthetic */ LogChannel access$1000(SaveDraftController saveDraftController) {
        return saveDraftController.log;
    }

    static /* synthetic */ LogChannel access$1100(SaveDraftController saveDraftController) {
        return saveDraftController.log;
    }

    static /* synthetic */ Message access$002(SaveDraftController saveDraftController, Message message) {
        saveDraftController.lastSavedMessage = message;
        return saveDraftController.lastSavedMessage;
    }
}

