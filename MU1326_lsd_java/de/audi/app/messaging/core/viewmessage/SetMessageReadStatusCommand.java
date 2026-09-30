/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;

public final class SetMessageReadStatusCommand
extends AbstractDsiMessagingCommand {
    private final String messageID;
    private final boolean read;

    public SetMessageReadStatusCommand(AbstractMsgApplication abstractMsgApplication, String string, boolean bl) {
        super(abstractMsgApplication);
        this.messageID = string;
        this.read = bl;
    }

    public void execute() {
        this.logger.log(10000000, "[SetMessageReadStatusCommand#execute]");
        try {
            this.dsiMessagingAccess.setMessageReadStatusRequest(this.messageID, this.read);
        }
        catch (Exception exception) {
            this.logException("[SetMessageReadStatusCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    public void setMessageReadStatusResponse(int n) {
        this.logger.log(10000000, "[SetMessageReadStatusCommand#setMessageReadStatusCommandResponse] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(10000000, "[SetMessageReadStatusCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[SetMessageReadStatusCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[SetMessageReadStatusErrorCommand#execute]");
                SetMessageReadStatusCommand.this.signalResult(false);
            }
        };
    }
}

