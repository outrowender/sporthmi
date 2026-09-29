/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.drafts;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.compose.Message;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$1;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$LastSavedMessageGetter;
import de.audi.app.messaging.core.drafts.SaveAsDraftCommand$ResultHandler;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.util.MessageContacts;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

final class SaveAsDraftCommand
extends AbstractDsiMessagingCommand {
    private final SaveAsDraftCommand$LastSavedMessageGetter lastSavedMessageGetter;
    private final SaveAsDraftCommand$ResultHandler resultHandler;
    private Message message;
    private final String messageID;
    private final int type;
    private final RecipientList recipients;
    private final String subject;
    private final String body;
    private final int messagingAccountID;
    private final AttachmentInformation[] attachments;

    SaveAsDraftCommand(AbstractMsgApplication abstractMsgApplication, SaveAsDraftCommand$LastSavedMessageGetter lastSavedMessageGetter, SaveAsDraftCommand$ResultHandler resultHandler, Message message, String string, AttachmentInformation[] attachmentInformationArray) {
        super(abstractMsgApplication);
        this.lastSavedMessageGetter = lastSavedMessageGetter;
        this.resultHandler = resultHandler;
        this.message = message;
        this.messageID = message.getMessageDetails().getMessageID();
        this.type = message.getMessageDetails().getType();
        this.recipients = new RecipientList(MessageContacts.getRawAddresses(message.getMessageDetails().getRecipientsTo()), MessageContacts.getRawAddresses(message.getMessageDetails().getRecipientsCc()), MessageContacts.getRawAddresses(message.getMessageDetails().getRecipientsBcc()));
        this.subject = message.getMessageDetails().getSubject();
        this.body = string;
        this.messagingAccountID = message.getMessageDetails().getMessagingAccountID();
        this.attachments = attachmentInformationArray;
    }

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[SaveAsDraftCommand#execute]");
            boolean bl = true;
            Message message = this.lastSavedMessageGetter.get();
            String string = this.messageID;
            if (message != null) {
                boolean bl2;
                boolean bl3 = !"".equals(this.messageID);
                boolean bl4 = message.getHmiMessageId() != this.message.getHmiMessageId();
                boolean bl5 = bl2 = message.getChangeId() != this.message.getChangeId();
                if (!bl3 && !bl4) {
                    string = message.getMessageDetails().getMessageID();
                }
                if (!bl4 && !bl2) {
                    bl = false;
                }
            }
            if (this.logger.isInfo()) {
                this.logger.log(1078071040, "[SaveAsDraftCommand#execute] hasToBeSaved = %1, adjustedMessageId = %2, message = %3, lastSavedMessage = %4", (Object)String.valueOf(bl), (Object)String.valueOf(string), (Object)String.valueOf(this.message), (Object)String.valueOf(message));
            }
            if (bl) {
                this.dsiMessagingAccess.saveAsDraftRequest(string, this.type, this.recipients, this.subject, this.body, this.messagingAccountID, this.attachments);
            } else {
                this.signalResult(0, string, this.message);
            }
        }
        catch (Exception exception) {
            this.logException("[SaveAsDraftCommand#execute]", exception);
            this.signalResult(1, "", this.message);
        }
    }

    @Override
    public void saveAsDraftResponse(int n, String string) {
        this.logger.log(-2137614336, "[SaveAsDraftCommand#saveAsDraftResponse] result = %2, messageID = %1", (Object)string, (long)n);
        this.signalResult(n, string, this.message);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n, String string, Message message) {
        try {
            this.logger.log(-2137614336, "[SaveAsDraftCommand#signalResult] result = %1", (long)n);
            this.resultHandler.handleResult(n, string, message);
        }
        catch (Exception exception) {
            this.logException("[SaveAsDraftCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new SaveAsDraftCommand$1(this, this.msgApp);
    }

    static /* synthetic */ Message access$000(SaveAsDraftCommand saveAsDraftCommand) {
        return saveAsDraftCommand.message;
    }

    static /* synthetic */ void access$100(SaveAsDraftCommand saveAsDraftCommand, int n, String string, Message message) {
        saveAsDraftCommand.signalResult(n, string, message);
    }
}

