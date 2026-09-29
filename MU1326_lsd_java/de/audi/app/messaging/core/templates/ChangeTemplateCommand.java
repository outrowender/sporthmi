/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.templates.ChangeTemplateCommand$1;
import de.audi.app.messaging.core.templates.ChangeTemplateCommand$ResultHandler;
import de.audi.tghu.command.Command;

final class ChangeTemplateCommand
extends AbstractDsiMessagingCommand {
    private final ChangeTemplateCommand$ResultHandler resultHandler;
    private final long clientRequestId;
    private final int templateID;
    private final String text;

    ChangeTemplateCommand(AbstractMsgApplication abstractMsgApplication, ChangeTemplateCommand$ResultHandler resultHandler, long l, int n, String string) {
        super(abstractMsgApplication);
        this.resultHandler = resultHandler;
        this.clientRequestId = l;
        this.templateID = n;
        this.text = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ChangeTemplateCommand#execute]");
        try {
            this.dsiMessagingAccess.changeTemplateRequest(this.templateID, this.text);
        }
        catch (Exception exception) {
            this.logException("[ChangeTemplateCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    @Override
    public void changeTemplateResponse(int n, int n2) {
        this.logger.log(-2137614336, "[ChangeTemplateCommand#changeTemplateResponse] result = %1, templateID = %2", (long)n, (long)n2);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            if (this.logger.isDebug()) {
                this.logger.log(-2137614336, "[ChangeTemplateCommand#signalResult] clientRequestId = %1, isResultOk = %2", (Object)String.valueOf(this.clientRequestId), (Object)String.valueOf(bl));
            }
            this.resultHandler.handleResult(this.clientRequestId, bl);
        }
        catch (Exception exception) {
            this.logException("[ChangeTemplateCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new ChangeTemplateCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(ChangeTemplateCommand changeTemplateCommand, boolean bl) {
        changeTemplateCommand.signalResult(bl);
    }
}

