/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.tghu.command.Command;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

final class SendMessageCommand
extends AbstractDsiMessagingCommand {
    private final String draftId;
    private final int requestId;
    private final int type;
    private final RecipientList recipients;
    private final String subject;
    private final String message;
    private AttachmentInformation[] attachments;
    private final int messagingAccountID;
    private volatile boolean hasResponse = false;
    private volatile int resultCode = 0;
    private volatile int[] indicationResultCodes = null;

    SendMessageCommand(AbstractMsgApplication abstractMsgApplication, ICommandCallback iCommandCallback, String string, int n, int n2, RecipientList recipientList, String string2, String string3, AttachmentInformation[] attachmentInformationArray, int n3) {
        super(abstractMsgApplication);
        this.setCommandCallback(iCommandCallback);
        this.requestId = n;
        this.draftId = string;
        this.type = n2;
        this.recipients = recipientList;
        this.subject = string2;
        this.message = string3;
        this.attachments = attachmentInformationArray;
        this.messagingAccountID = n3;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public String getDraftId() {
        return this.draftId;
    }

    public RecipientList getRecipients() {
        return this.recipients;
    }

    public long getTimeout() {
        return 65000L;
    }

    protected Command canceled() {
        this.logger.log(1000000, "[SendMessageCommand#canceled]");
        if (this.hasResponse) {
            this.setResultIfDone(true);
        } else {
            this.setExceptionCause(new SendMessageCommandStoppedBeforeDSIResponseException("Command list canceled before a response was received."));
        }
        return null;
    }

    public Command getErrorCommand() {
        return null;
    }

    public void execute() {
        try {
            this.logger.log(10000000, "[SendMessageCommand#execute]");
            this.dsiMessagingAccess.sendMessageRequest(this.requestId, this.type, this.recipients, this.subject, this.message, this.attachments, this.messagingAccountID);
        }
        catch (Exception exception) {
            this.logException("[SendMessageCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    public void sendMessageResponse(int n, int n2) {
        this.logger.log(10000000, "[SendMessageCommand#sendMessageResponse] result = %1, requestId = %2", (long)n, (long)n2);
        this.resultCode = n;
        this.hasResponse = true;
        this.setResultIfDone(false);
    }

    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        if (n == this.requestId) {
            this.indicationResultCodes = nArray;
            this.setResultIfDone(false);
        } else {
            super.indicateSendMessage(nArray, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
        }
    }

    public void setResultIfDone(boolean bl) {
        boolean bl2;
        boolean bl3 = this.resultCode != 0;
        boolean bl4 = this.indicationResultCodes != null;
        boolean bl5 = this.hasResponse && (bl3 || bl4);
        boolean bl6 = bl2 = bl || bl5;
        if (this.logger.isDebug()) {
            Buffer buffer = new Buffer();
            buffer.append("[SendMessageCommand#setResultIfDone] ");
            buffer.append("terminateUnconditionally = ").append(bl).append(", ");
            buffer.append("hasResponse = ").append(this.hasResponse).append(", ");
            buffer.append("resultCode = ").append(this.resultCode).append(", ");
            buffer.append("indicationResultCodes = ").append(Arrays.toString(this.indicationResultCodes)).append(", ");
            buffer.append("isDone = ").append(bl5).append(", ");
            buffer.append("terminate = ").append(bl2);
            this.logger.log(10000000, buffer.toString());
        }
        if (bl2) {
            this.setResult(new Result(this.resultCode, this.indicationResultCodes));
        }
    }

    public final class Result {
        private final int resultCode;
        private final int[] indicationResultCodes;

        private Result(int n, int[] nArray) {
            this.resultCode = n;
            this.indicationResultCodes = nArray;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public int[] getIndicationResultCodes() {
            return this.indicationResultCodes;
        }
    }

    private class SendMessageCommandStoppedBeforeDSIResponseException
    extends RuntimeException {
        private static final long serialVersionUID = -3557478780797436403L;

        public SendMessageCommandStoppedBeforeDSIResponseException(String string) {
            super(string);
        }
    }
}

