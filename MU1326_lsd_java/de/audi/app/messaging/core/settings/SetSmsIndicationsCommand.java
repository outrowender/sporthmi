/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.app.messaging.core.settings.SetSmsIndicationsCommand$1;
import de.audi.tghu.command.Command;

final class SetSmsIndicationsCommand
extends AbstractDsiMessagingConfigCommand {
    private final boolean smsIndications;

    SetSmsIndicationsCommand(AbstractMsgApplication abstractMsgApplication, boolean bl) {
        super(abstractMsgApplication);
        this.smsIndications = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetSmsIndicationsCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.requestSetSmsIndications(this.smsIndications);
        }
        catch (Exception exception) {
            this.logException("[SetSmsIndicationsCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void responseSetSmsIndications(int n) {
        this.logger.log(-2137614336, "[SetSmsIndicationsCommand#responseSetSmsIndications] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(-2137614336, "[SetSmsIndicationsCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[SetSmsIndicationsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new SetSmsIndicationsCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(SetSmsIndicationsCommand setSmsIndicationsCommand, boolean bl) {
        setSmsIndicationsCommand.signalResult(bl);
    }
}

