/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.templates.DeleteTemplateCommand$1;
import de.audi.tghu.command.Command;

final class DeleteTemplateCommand
extends AbstractDsiMessagingCommand {
    private final int[] templateIDs;

    DeleteTemplateCommand(AbstractMsgApplication abstractMsgApplication, int[] nArray) {
        super(abstractMsgApplication);
        this.templateIDs = nArray;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[DeleteTemplateCommand#execute]");
        try {
            this.dsiMessagingAccess.deleteTemplateRequest(this.templateIDs);
        }
        catch (Exception exception) {
            this.logException("[DeleteTemplateCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void deleteTemplateResponse(int n) {
        try {
            this.logger.log(-2137614336, "[DeleteTemplateCommand#deleteTemplateResponse] result = %1", (long)n);
            this.signalResult(n == 0);
        }
        catch (Exception exception) {
            this.logException("[DeleteTemplateCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    private void signalResult(boolean bl) {
        this.logger.log(-2137614336, "[DeleteTemplateCommand#signalResult] isResultOk = %1", bl);
        if (bl) {
            this.logger.log(-2137614336, "[DeleteTemplateCommand#signalResult] Scheduling reload of the template list.");
            this.msgApp.getTemplateList().loadTemplates();
            this.msgApp.getModelAccess().setOperationStateChoice(-1148051200, 1);
        } else {
            this.msgApp.getModelAccess().setOperationStateChoice(-1148051200, 2);
        }
        this.commandList.commandFinished();
    }

    @Override
    public Command getErrorCommand() {
        return new DeleteTemplateCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(DeleteTemplateCommand deleteTemplateCommand, boolean bl) {
        deleteTemplateCommand.signalResult(bl);
    }
}

