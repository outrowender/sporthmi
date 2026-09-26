/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.app.messaging.core.settings.SetPushSmsCommand$1;
import de.audi.tghu.command.Command;

final class SetPushSmsCommand
extends AbstractDsiMessagingConfigCommand {
    private final boolean pushSms;

    SetPushSmsCommand(AbstractMsgApplication abstractMsgApplication, boolean bl) {
        super(abstractMsgApplication);
        this.pushSms = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetPushSmsCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.requestSetPushSms(this.pushSms);
        }
        catch (Exception exception) {
            this.logException("[SetPushSmsCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void responseSetPushSms(int n) {
        this.logger.log(-2137614336, "[SetPushSmsCommand#responseSetPushSms] result = %1", (long)n);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            this.logger.log(-2137614336, "[SetPushSmsCommand#signalResult] isResultOk = %1", bl);
        }
        catch (Exception exception) {
            this.logException("[SetPushSmsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new SetPushSmsCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(SetPushSmsCommand setPushSmsCommand, boolean bl) {
        setPushSmsCommand.signalResult(bl);
    }
}

