/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.app.messaging.core.settings.SetEmailIndicationsCommand$1;
import de.audi.tghu.command.Command;

final class SetEmailIndicationsCommand
extends AbstractDsiMessagingConfigCommand {
    private final boolean emailIndications;

    SetEmailIndicationsCommand(AbstractMsgApplication abstractMsgApplication, boolean bl) {
        super(abstractMsgApplication);
        this.emailIndications = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetEmailIndicationsCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.requestSetEmailIndications(this.emailIndications);
        }
        catch (Exception exception) {
            this.logException("[SetEmailIndicationsCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void responseSetEmailIndications(int n) {
        this.logger.log(-2137614336, "[SetEmailIndicationsCommand#responseSetEmailIndications] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(-2137614336, "[SetEmailIndicationsCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[SetEmailIndicationsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new SetEmailIndicationsCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(SetEmailIndicationsCommand setEmailIndicationsCommand, boolean bl) {
        setEmailIndicationsCommand.signalResult(bl);
    }
}

