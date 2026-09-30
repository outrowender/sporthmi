/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;

final class ChangeTemplateCommand
extends AbstractDsiMessagingCommand {
    private final ResultHandler resultHandler;
    private final long clientRequestId;
    private final int templateID;
    private final String text;

    ChangeTemplateCommand(AbstractMsgApplication abstractMsgApplication, ResultHandler resultHandler, long l, int n, String string) {
        super(abstractMsgApplication);
        this.resultHandler = resultHandler;
        this.clientRequestId = l;
        this.templateID = n;
        this.text = string;
    }

    public void execute() {
        this.logger.log(10000000, "[ChangeTemplateCommand#execute]");
        try {
            this.dsiMessagingAccess.changeTemplateRequest(this.templateID, this.text);
        }
        catch (Exception exception) {
            this.logException("[ChangeTemplateCommand#execute]", exception);
            this.signalResult(false);
        }
    }

    public void changeTemplateResponse(int n, int n2) {
        this.logger.log(10000000, "[ChangeTemplateCommand#changeTemplateResponse] result = %1, templateID = %2", (long)n, (long)n2);
        this.signalResult(n == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl) {
        try {
            if (this.logger.isDebug()) {
                this.logger.log(10000000, "[ChangeTemplateCommand#signalResult] clientRequestId = %1, isResultOk = %2", (Object)String.valueOf(this.clientRequestId), (Object)String.valueOf(bl));
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

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[ChangeTemplateErrorCommand#execute]");
                ChangeTemplateCommand.this.signalResult(false);
            }
        };
    }

    public static interface ResultHandler {
        public void handleResult(long var1, boolean var3);
    }
}

