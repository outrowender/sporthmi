/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.Template;

final class GetTemplatesCommand
extends AbstractDsiMessagingCommand {
    GetTemplatesCommand(AbstractMsgApplication abstractMsgApplication) {
        super(abstractMsgApplication);
    }

    public void execute() {
        try {
            this.logger.log(10000000, "[GetTemplatesCommand#execute]");
            this.dsiMessagingAccess.getTemplatesRequest();
        }
        catch (Exception exception) {
            this.logException("[GetTemplatesCommand#execute]", exception);
            this.signalResult(false, null);
        }
    }

    public void getTemplatesResponse(int n, Template[] templateArray) {
        try {
            boolean bl;
            this.logger.log(10000000, "[GetTemplatesCommand#getTemplatesResponse] result = %2, templates = %1", (Object)String.valueOf(templateArray), (long)n);
            super.getTemplatesResponse(n, templateArray);
            boolean bl2 = bl = n == 0;
            if (bl && templateArray == null) {
                this.logNullParameter("[GetTemplatesCommand#getTemplatesResponse]");
                bl = false;
            }
            this.signalResult(bl, templateArray);
        }
        catch (Exception exception) {
            this.logException("[GetTemplatesCommand#getTemplatesResponse]", exception);
            this.signalResult(false, null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl, Template[] templateArray) {
        this.logger.log(10000000, "[GetTemplatesCommand#signalResult] isResultOk = %1", bl);
        try {
            if (bl) {
                this.msgApp.getTemplateList().getTemplatesResponse(templateArray);
            }
        }
        catch (Exception exception) {
            this.logException("[GetMessageContentsCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[GetMessageContentsCommand#execute]");
                GetTemplatesCommand.this.signalResult(false, null);
            }
        };
    }
}

