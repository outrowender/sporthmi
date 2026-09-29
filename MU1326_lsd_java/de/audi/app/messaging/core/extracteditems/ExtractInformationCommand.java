/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.extracteditems.ExtractInformationCommand$1;
import de.audi.app.messaging.core.extracteditems.ExtractInformationCommand$ResultHandler;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.ExtractedItem;

public final class ExtractInformationCommand
extends AbstractDsiMessagingCommand {
    private final ExtractInformationCommand$ResultHandler resultHandler;
    private final String messageID;

    public ExtractInformationCommand(AbstractMsgApplication abstractMsgApplication, ExtractInformationCommand$ResultHandler extractInformationCommand$ResultHandler, String string) {
        super(abstractMsgApplication);
        this.resultHandler = extractInformationCommand$ResultHandler;
        this.messageID = string;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ExtractInformationCommand#execute]");
        try {
            this.dsiMessagingAccess.extractInformationRequest(this.messageID);
        }
        catch (Exception exception) {
            this.logException("[ExtractInformationCommand#execute]", exception);
            this.signalResult(1, null);
        }
    }

    @Override
    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        this.logger.log(-2137614336, "[ExtractInformationCommand#extractInformationResponse] result = %1", (long)n);
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
            this.logger.log(-2137614336, "[ExtractInformationCommand#signalResult] result = %1", (long)n);
            this.resultHandler.handleResult(n, extractedItemArray);
        }
        catch (Exception exception) {
            this.logException("[ExtractInformationCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new ExtractInformationCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(ExtractInformationCommand extractInformationCommand, int n, ExtractedItem[] extractedItemArray) {
        extractInformationCommand.signalResult(n, extractedItemArray);
    }
}

