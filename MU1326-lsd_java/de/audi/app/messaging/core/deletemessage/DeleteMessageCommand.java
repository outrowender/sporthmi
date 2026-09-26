/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.deletemessage;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand$1;
import de.audi.app.messaging.core.deletemessage.DeleteMessageCommand$ResultHandler;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.ListChangedInformation;

public final class DeleteMessageCommand
extends AbstractDsiMessagingCommand {
    private final DeleteMessageCommand$ResultHandler resultHandler;
    private final String[] messageIDs;
    private final boolean deleteList;
    private volatile boolean hasResponse = false;
    private volatile int result = 0;
    private volatile boolean hasListChanged = false;

    DeleteMessageCommand(AbstractMsgApplication abstractMsgApplication, DeleteMessageCommand$ResultHandler resultHandler, String[] stringArray, boolean bl) {
        super(abstractMsgApplication);
        this.resultHandler = resultHandler;
        this.messageIDs = stringArray;
        this.deleteList = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[DeleteMessageCommand#execute]");
        try {
            this.dsiMessagingAccess.deleteMessageRequest(this.messageIDs, this.deleteList);
        }
        catch (Exception exception) {
            this.logException("[DeleteMessageCommand#execute]", exception);
            this.signalResult(1);
        }
    }

    @Override
    public void deleteMessageResponse(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[DeleteMessageCommand#deleteMessageResponse] result = %1, deleted = %2, num = %3", (long)n, (long)n2, (long)n3);
        this.result = n;
        this.hasResponse = true;
        this.signalResultIfDone();
    }

    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
        this.logger.log(-2137614336, "[DeleteMessageCommand#indicateListChanged] information = %1", (Object)listChangedInformation);
        super.indicateListChanged(listChangedInformation);
        if (listChangedInformation.getReason() == 4) {
            this.hasListChanged = true;
        }
        this.signalResultIfDone();
    }

    private void signalResultIfDone() {
        boolean bl;
        boolean bl2 = bl = this.hasResponse && (this.result != 0 || this.hasListChanged);
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[DeleteMessageCommand#signalResultIfDone] hasResponse = %1, result = %2, hasListChanged = %3, isDone = %4", (Object)String.valueOf(this.hasResponse), (Object)String.valueOf(this.result), (Object)String.valueOf(this.hasListChanged), (Object)String.valueOf(bl));
        }
        if (bl) {
            this.signalResult(this.result);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n) {
        try {
            this.logger.log(-2137614336, "[DeleteMessageCommand#signalResult] result = %1", (long)n);
            this.resultHandler.handleResult(n);
        }
        catch (Exception exception) {
            this.logException("[DeleteMessageCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new DeleteMessageCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(DeleteMessageCommand deleteMessageCommand, int n) {
        deleteMessageCommand.signalResult(n);
    }
}

