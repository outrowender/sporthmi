/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.deletemessage.DeleteSimMessagesCommand$Result;
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

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[DeleteSimMessagesCommand#execute]");
            this.dsiMessagingAccess.deleteSimCardMessagesRequest(this.accountID, this.delFlag);
        }
        catch (Exception exception) {
            this.logException("[DeleteSimMessagesCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    @Override
    public void deleteSimCardMessagesResponse(int n) {
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[DeleteSimMessagesCommand#deleteSimCardMessagesResponse] result = %1", (long)n);
        }
        this.setResult(new DeleteSimMessagesCommand$Result(this, n, null));
    }
}

