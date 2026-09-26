/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.viewmessage.SetMessageReadStatusCommand$1;
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

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetMessageReadStatusCommand#execute]");
        try {
            this.dsiMessagingAccess.setMessageReadStatusRequest(this.messageID, this.read);
        }
        catch (Exception exception) {
            this.logException("[SetMessageReadStatusCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void setMessageReadStatusResponse(int n) {
        this.logger.log(-2137614336, "[SetMessageReadStatusCommand#setMessageReadStatusCommandResponse] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(-2137614336, "[SetMessageReadStatusCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[SetMessageReadStatusCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new SetMessageReadStatusCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(SetMessageReadStatusCommand setMessageReadStatusCommand, boolean bl) {
        setMessageReadStatusCommand.signalResult(bl);
    }
}

