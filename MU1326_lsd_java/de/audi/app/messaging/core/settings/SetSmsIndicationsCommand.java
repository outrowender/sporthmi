/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.tghu.command.Command;

final class SetSmsIndicationsCommand
extends AbstractDsiMessagingConfigCommand {
    private final boolean smsIndications;

    SetSmsIndicationsCommand(AbstractMsgApplication abstractMsgApplication, boolean bl) {
        super(abstractMsgApplication);
        this.smsIndications = bl;
    }

    public void execute() {
        this.logger.log(10000000, "[SetSmsIndicationsCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.requestSetSmsIndications(this.smsIndications);
        }
        catch (Exception exception) {
            this.logException("[SetSmsIndicationsCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    public void responseSetSmsIndications(int n) {
        this.logger.log(10000000, "[SetSmsIndicationsCommand#responseSetSmsIndications] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(10000000, "[SetSmsIndicationsCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[SetSmsIndicationsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[SetSmsIndicationsErrorCommand#execute]");
                SetSmsIndicationsCommand.this.signalResult(false);
            }
        };
    }
}

