/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.tghu.command.Command;

final class ActivateStoreSmsOnSentCommand
extends AbstractDsiMessagingConfigCommand {
    private final boolean storeSms;

    ActivateStoreSmsOnSentCommand(AbstractMsgApplication abstractMsgApplication, boolean bl) {
        super(abstractMsgApplication);
        this.storeSms = bl;
    }

    public void execute() {
        this.logger.log(10000000, "[ActivateStoreSmsOnSentCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.activateStoreSmsOnSentRequest(this.storeSms);
        }
        catch (Exception exception) {
            this.logException("[ActivateStoreSmsOnSentCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    public void activateStoreSmsOnSentResponse(int n) {
        this.logger.log(10000000, "[ActivateStoreSmsOnSentCommand#activateStoreSmsOnSentResponse] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(10000000, "[ActivateStoreSmsOnSentCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[ActivateStoreSmsOnSentCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[ActivateStoreSmsOnSentErrorCommand#execute]");
                ActivateStoreSmsOnSentCommand.this.signalResult(false);
            }
        };
    }
}

