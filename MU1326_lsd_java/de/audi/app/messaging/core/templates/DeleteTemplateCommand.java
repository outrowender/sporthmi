/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;

final class DeleteTemplateCommand
extends AbstractDsiMessagingCommand {
    private final int[] templateIDs;

    DeleteTemplateCommand(AbstractMsgApplication abstractMsgApplication, int[] nArray) {
        super(abstractMsgApplication);
        this.templateIDs = nArray;
    }

    public void execute() {
        this.logger.log(10000000, "[DeleteTemplateCommand#execute]");
        try {
            this.dsiMessagingAccess.deleteTemplateRequest(this.templateIDs);
        }
        catch (Exception exception) {
            this.logException("[DeleteTemplateCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    public void deleteTemplateResponse(int n) {
        try {
            this.logger.log(10000000, "[DeleteTemplateCommand#deleteTemplateResponse] result = %1", (long)n);
            this.signalResult(n == 0);
        }
        catch (Exception exception) {
            this.logException("[DeleteTemplateCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    private void signalResult(boolean bl) {
        this.logger.log(10000000, "[DeleteTemplateCommand#signalResult] isResultOk = %1", bl);
        if (bl) {
            this.logger.log(10000000, "[DeleteTemplateCommand#signalResult] Scheduling reload of the template list.");
            this.msgApp.getTemplateList().loadTemplates();
            this.msgApp.getModelAccess().setOperationStateChoice(2200251, 1);
        } else {
            this.msgApp.getModelAccess().setOperationStateChoice(2200251, 2);
        }
        this.commandList.commandFinished();
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[DeleteTemplateErrorCommand#execute]");
                DeleteTemplateCommand.this.signalResult(false);
            }
        };
    }
}

