/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.settings;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messagingconfig.AbstractDsiMessagingConfigCommand;
import de.audi.app.messaging.core.settings.RestoreFactorySettingsCommand$1;
import de.audi.app.messaging.core.settings.RestoreFactorySettingsCommand$ResultHandler;
import de.audi.tghu.command.Command;

final class RestoreFactorySettingsCommand
extends AbstractDsiMessagingConfigCommand {
    private final RestoreFactorySettingsCommand$ResultHandler resultHandler;

    RestoreFactorySettingsCommand(AbstractMsgApplication abstractMsgApplication, RestoreFactorySettingsCommand$ResultHandler restoreFactorySettingsCommand$ResultHandler) {
        super(abstractMsgApplication);
        this.resultHandler = restoreFactorySettingsCommand$ResultHandler;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RestoreFactorySettingsCommand#execute]");
        try {
            this.dsiMessagingConfigAccess.restoreFactorySettingsRequest();
        }
        catch (Exception exception) {
            this.logException("[RestoreFactorySettingsCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        this.logger.log(-2137614336, "[RestoreFactorySettingsCommand#restoreFactorySettingsResponse] result = %1", (long)n);
        this.signalResult(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(-2137614336, "[RestoreFactorySettingsCommand#signalResult] result = %1", (long)n);
            this.resultHandler.handleResult(n);
        }
        catch (Exception exception) {
            this.logException("[RestoreFactorySettingsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new RestoreFactorySettingsCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(RestoreFactorySettingsCommand restoreFactorySettingsCommand, int n) {
        restoreFactorySettingsCommand.signalResult(n);
    }
}

