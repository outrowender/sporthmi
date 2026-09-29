/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.folderbrowsing.ListDataRequest;
import de.audi.app.messaging.core.folderbrowsing.ListDataResponse;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand$1;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand$ResultHandler;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.ListEntry;

final class ListEntriesCommand
extends AbstractDsiMessagingCommand {
    static final long TIMEOUT;
    private static final int VALUE_INVALID;
    private final ListEntriesCommand$ResultHandler resultHandler;
    private final ListDataRequest listDataRequest;

    ListEntriesCommand(AbstractMsgApplication abstractMsgApplication, ListEntriesCommand$ResultHandler listEntriesCommand$ResultHandler, ListDataRequest listDataRequest) {
        super(abstractMsgApplication);
        this.resultHandler = listEntriesCommand$ResultHandler;
        this.listDataRequest = listDataRequest;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[ListEntriesCommand#execute]");
        try {
            this.dsiMessagingAccess.listEntriesRequest(this.listDataRequest.getRequestId(), this.listDataRequest.getOffset(), this.listDataRequest.getLength());
        }
        catch (Exception exception) {
            this.logException("[ListEntriesCommand#execute]", exception);
            this.signalResult(this.listDataRequest.getRequestId(), 1, new ListEntry[0], -1, -1, -1);
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        this.logger.log(-2137614336, "[ListEntriesCommand#listEntriesResponse] result = %1", (long)n2);
        this.signalResult(n, n2, listEntryArray, n3, n4, n5);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        try {
            this.logger.log(-2137614336, "[ListEntriesCommand#signalResult] result = %1", (long)n2);
            ListEntry[] listEntryArray2 = listEntryArray;
            if (n2 == 0 && listEntryArray == null) {
                this.logNullParameter("[ListEntriesCommand#signalResult]");
                listEntryArray2 = new ListEntry[]{};
            }
            ListDataResponse listDataResponse = new ListDataResponse(this.listDataRequest, n, n2, listEntryArray2, n3, n4, n5);
            this.resultHandler.handleResult(listDataResponse);
        }
        catch (Exception exception) {
            this.logException("[ListEntriesCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new ListEntriesCommand$1(this, this.msgApp);
    }

    static /* synthetic */ ListDataRequest access$000(ListEntriesCommand listEntriesCommand) {
        return listEntriesCommand.listDataRequest;
    }

    static /* synthetic */ void access$100(ListEntriesCommand listEntriesCommand, int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        listEntriesCommand.signalResult(n, n2, listEntryArray, n3, n4, n5);
    }
}

