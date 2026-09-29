/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.app.messaging.core.settings.ActivateStoreSmsOnSentCommand$1;
import de.audi.tghu.command.Command;

final class ActivateStoreSmsOnSentCommand
extends AbstractDsiMessagingConfigCommand {
    private final boolean storeSms;

    ActivateStoreSmsOnSentCommand(AbstractMsgApplication abstractMsgApplication, boolean bl) {
        super(abstractMsgApplication);
        this.storeSms = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ActivateStoreSmsOnSentCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.activateStoreSmsOnSentRequest(this.storeSms);
        }
        catch (Exception exception) {
            this.logException("[ActivateStoreSmsOnSentCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void activateStoreSmsOnSentResponse(int n) {
        this.logger.log(-2137614336, "[ActivateStoreSmsOnSentCommand#activateStoreSmsOnSentResponse] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(-2137614336, "[ActivateStoreSmsOnSentCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[ActivateStoreSmsOnSentCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new ActivateStoreSmsOnSentCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(ActivateStoreSmsOnSentCommand activateStoreSmsOnSentCommand, boolean bl) {
        activateStoreSmsOnSentCommand.signalResult(bl);
    }
}

