/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.ExtractedItem;

public final class ExtractInformationCommand
extends AbstractDsiMessagingCommand {
    private final ResultHandler resultHandler;
    private final String messageID;

    public ExtractInformationCommand(AbstractMsgApplication abstractMsgApplication, ResultHandler resultHandler, String string) {
        super(abstractMsgApplication);
        this.resultHandler = resultHandler;
        this.messageID = string;
    }

    public long getTimeout() {
        return 120000L;
    }

    public void execute() {
        this.logger.log(10000000, "[ExtractInformationCommand#execute]");
        try {
            this.dsiMessagingAccess.extractInformationRequest(this.messageID);
        }
        catch (Exception exception) {
            this.logException("[ExtractInformationCommand#execute]", exception);
            this.signalResult(1, null);
        }
    }

    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        this.logger.log(10000000, "[ExtractInformationCommand#extractInformationResponse] result = %1", (long)n);
        int n2 = n;
        ExtractedItem[] extractedItemArray2 = extractedItemArray;
        if (n == 0 && extractedItemArray == null) {
            this.logNullParameter("[ExtractInformationCommand#extractInformationResponse]");
            n2 = 1;
            extractedItemArray2 = new ExtractedItem[]{};
        }
        this.signalResult(n2, extractedItemArray2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n, ExtractedItem[] extractedItemArray) {
        try {
            this.logger.log(10000000, "[ExtractInformationCommand#signalResult] result = %1", (long)n);
            this.resultHandler.handleResult(n, extractedItemArray);
        }
        catch (Exception exception) {
            this.logException("[ExtractInformationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand(this.msgApp){

            public void execute() {
                this.logger.log(10000000, "[ExtractInformationErrorCommand#execute]");
                ExtractInformationCommand.this.signalResult(1, new ExtractedItem[0]);
            }
        };
    }

    public static interface ResultHandler {
        public void handleResult(int var1, ExtractedItem[] var2);
    }
}

