/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.MessageDetails;

public final class GetMessageContentsCommand
extends AbstractDsiMessagingCommand {
    private final int accountID;
    private final String messageID;
    private final int download;
    private final ResultHandler resultHandler;

    public GetMessageContentsCommand(AbstractMsgApplication abstractMsgApplication, int n, String string, int n2, ResultHandler resultHandler) {
        super(abstractMsgApplication);
        this.accountID = n;
        this.messageID = string;
        this.download = n2;
        this.resultHandler = resultHandler;
    }

    public long getTimeout() {
        return 180000L;
    }

    public void execute() {
        this.logger.log(10000000, "[GetMessageContentsCommand#execute]");
        try {
            try {
                this.msgApp.getNewMessage().indicateMessageDownload();
            }
            catch (Exception exception) {
                this.logException("[GetMessageContentsCommand#execute]", exception);
            }
            this.dsiMessagingAccess.getMessageContentsRequest(this.accountID, this.messageID, this.download);
        }
        catch (Exception exception) {
            this.logException("[GetMessageContentsCommand#execute]", exception);
            this.signalResult(false, null);
        }
    }

    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
        try {
            boolean bl;
            this.logger.log(10000000, "[GetMessageContentsCommand#getMessageContentsResponse] result = %1", (long)n);
            boolean bl2 = bl = n == 0;
            if (bl && messageDetails == null) {
                this.logNullParameter("[GetMessageContentsCommand#getMessageContentsResponse]");
                bl = false;
            }
            this.signalResult(bl, messageDetails);
        }
        catch (Exception exception) {
            this.logException("[GetMessageContentsCommand#getMessageContentsResponse]", exception);
            this.signalResult(false, null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl, MessageDetails messageDetails) {
        this.logger.log(10000000, "[GetMessageContentsCommand#signalResult] isResultOk = %1", bl);
        try {
            this.resultHandler.handleResult(bl, messageDetails, this.download);
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
                this.logger.log(10000000, "[GetMessageContentsErrorCommand#execute]");
                GetMessageContentsCommand.this.signalResult(false, null);
            }
        };
    }

    public static interface ResultHandler {
        public void handleResult(boolean var1, MessageDetails var2, int var3);
    }
}

