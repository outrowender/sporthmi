/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;

final class DeleteSimMessagesCommand
extends AbstractDsiMessagingCommand {
    private final int accountID;
    private final int delFlag;

    public DeleteSimMessagesCommand(AbstractMsgApplication abstractMsgApplication, ICommandCallback iCommandCallback, int n, int n2) {
        super(abstractMsgApplication);
        this.setCommandCallback(iCommandCallback);
        this.accountID = n;
        this.delFlag = n2;
    }

    public void execute() {
        try {
            this.logger.log(10000000, "[DeleteSimMessagesCommand#execute]");
            this.dsiMessagingAccess.deleteSimCardMessagesRequest(this.accountID, this.delFlag);
        }
        catch (Exception exception) {
            this.logException("[DeleteSimMessagesCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    public void deleteSimCardMessagesResponse(int n) {
        if (this.logger.isDebug()) {
            this.logger.log(10000000, "[DeleteSimMessagesCommand#deleteSimCardMessagesResponse] result = %1", (long)n);
        }
        this.setResult(new Result(n));
    }

    final class Result {
        private final int resultCode;

        private Result(int n) {
            this.resultCode = n;
        }

        public int getResultCode() {
            return this.resultCode;
        }
    }
}

