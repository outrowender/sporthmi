/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;

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

    public void execute() {
        this.logger.log(10000000, "[SetSmscNumberCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.setSMSCNumberRequest(this.smscNumber);
        }
        catch (Exception exception) {
            this.logException("[SetSmscNumberCommand#execute]", exception);
            this.setExceptionCause(exception);
        }
    }

    public void setSMSCNumberResponse(int n) {
        this.logger.log(10000000, "[SetSmscNumberCommand#setSMSCNumberResponse] result = %1", (long)n);
        this.setResult(new Result(n));
    }

    public final class Result {
        private final int resultCode;

        private Result(int n) {
            this.resultCode = n;
        }

        public int getResultCode() {
            return this.resultCode;
        }
    }
}

