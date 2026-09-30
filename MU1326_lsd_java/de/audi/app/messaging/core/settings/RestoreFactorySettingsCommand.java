/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.tghu.command.Command;

final class RestoreFactorySettingsCommand
extends AbstractDsiMessagingConfigCommand {
    private final ResultHandler resultHandler;

    RestoreFactorySettingsCommand(AbstractMsgApplication abstractMsgApplication, ResultHandler resultHandler) {
        super(abstractMsgApplication);
        this.resultHandler = resultHandler;
    }

    public void execute() {
        this.logger.log(10000000, "[RestoreFactorySettingsCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.restoreFactorySettingsRequest();
        }
        catch (Exception exception) {
            this.logException("[RestoreFactorySettingsCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    public void restoreFactorySettingsResponse(int n) {
        this.logger.log(10000000, "[RestoreFactorySettingsCommand#restoreFactorySettingsResponse] result = %1", (long)n);
        this.signalResult(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(10000000, "[RestoreFactorySettingsCommand#signalResult] result = %1", (long)n);
            this.resultHandler.handleResult(n);
        }
        catch (Exception exception) {
            this.logException("[RestoreFactorySettingsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[RestoreFactorySettingsErrorCommand#execute]");
                RestoreFactorySettingsCommand.this.signalResult(1);
            }
        };
    }

    static interface ResultHandler {
        public void handleResult(int var1);
    }
}

