/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.app.messaging.core.settings.SetSmscNumberCommand$Result;

public final class SetSmscNumberCommand
extends AbstractDsiMessagingConfigCommand {
    private final String smscNumber;
    private final String oldSmscNumber;

    public SetSmscNumberCommand(AbstractMsgApplication abstractMsgApplication, ICommandCallback iCommandCallback, String string, String string2) {
        super(abstractMsgApplication);
        this.setCommandCallback(iCommandCallback);
        this.smscNumber = string;
        this.oldSmscNumber = string2;
    }

    public String getOldSmscNumber() {
        return this.oldSmscNumber;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SetSmscNumberCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.setSMSCNumberRequest(this.smscNumber);
        }
        catch (Exception exception) {
            this.logException("[SetSmscNumberCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    @Override
    public void setSMSCNumberResponse(int n) {
        this.logger.log(-2137614336, "[SetSmscNumberCommand#setSMSCNumberResponse] result = %1", (long)n);
        this.setResult(new SetSmscNumberCommand$Result(this, n, null));
    }
}

