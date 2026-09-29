/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand$1;
import de.audi.app.messaging.core.viewmessage.GetMessageContentsCommand$ResultHandler;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.MessageDetails;

public final class GetMessageContentsCommand
extends AbstractDsiMessagingCommand {
    private final int accountID;
    private final String messageID;
    private final int download;
    private final GetMessageContentsCommand$ResultHandler resultHandler;

    public GetMessageContentsCommand(AbstractMsgApplication abstractMsgApplication, int n, String string, int n2, GetMessageContentsCommand$ResultHandler getMessageContentsCommand$ResultHandler) {
        super(abstractMsgApplication);
        this.accountID = n;
        this.messageID = string;
        this.download = n2;
        this.resultHandler = getMessageContentsCommand$ResultHandler;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[GetMessageContentsCommand#execute]");
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

    @Override
    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
        try {
            boolean bl;
            this.logger.log(-2137614336, "[GetMessageContentsCommand#getMessageContentsResponse] result = %1", (long)n);
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
        this.logger.log(-2137614336, "[GetMessageContentsCommand#signalResult] isResultOk = %1", bl);
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

    @Override
    public Command getErrorCommand() {
        return new GetMessageContentsCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(GetMessageContentsCommand getMessageContentsCommand, boolean bl, MessageDetails messageDetails) {
        getMessageContentsCommand.signalResult(bl, messageDetails);
    }
}

