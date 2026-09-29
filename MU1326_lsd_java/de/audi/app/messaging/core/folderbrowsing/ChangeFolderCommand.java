/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.dsi.messaging.AbstractDsiMessagingCommand;
import de.audi.app.messaging.core.folderbrowsing.ChangeFolderCommand$1;
import de.audi.app.messaging.core.folderbrowsing.ChangeFolderCommand$ResultHandler;
import de.audi.tghu.command.Command;
import org.dsi.ifc.messaging.FolderEntry;

final class ChangeFolderCommand
extends AbstractDsiMessagingCommand {
    static final long TIMEOUT;
    private final ChangeFolderCommand$ResultHandler resultHandler;
    private final int folderChangeType;
    private final int hmiFolderType;
    private final int folderLevel;
    private final int folderID;
    private final int filter;
    private final int accountID;
    private final int sortCriteria;
    private final int order;

    ChangeFolderCommand(AbstractMsgApplication abstractMsgApplication, ChangeFolderCommand$ResultHandler changeFolderCommand$ResultHandler, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        super(abstractMsgApplication);
        this.resultHandler = changeFolderCommand$ResultHandler;
        this.folderChangeType = n;
        this.hmiFolderType = n2;
        this.folderLevel = n3;
        this.folderID = n4;
        this.filter = n5;
        this.accountID = n6;
        this.sortCriteria = n7;
        this.order = n8;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void execute() {
        try {
            this.logger.log(-2137614336, "[ChangeFolderCommand#execute]");
            this.dsiMessagingAccess.changeFolderRequest(this.folderID, this.filter, this.accountID, this.sortCriteria, this.order);
        }
        catch (Exception exception) {
            this.logException("[ChangeFolderCommand#execute]", exception);
            this.signalResult(false, null);
        }
    }

    @Override
    public void changeFolderResponse(FolderEntry folderEntry, int n) {
        this.logger.log(-2137614336, "[ChangeFolderCommand#changeFolderResponse] result = %1", (long)n);
        this.signalResult(n == 0, folderEntry);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalResult(boolean bl, FolderEntry folderEntry) {
        try {
            this.logger.log(-2137614336, "[ChangeFolderCommand#signalResult] isResultOk = %1", bl);
            this.resultHandler.handleResult(bl, this.folderChangeType, folderEntry, this.folderID, this.hmiFolderType, this.folderLevel);
        }
        catch (Exception exception) {
            this.logException("[ChangeFolderCommand#signalResult]", exception);
        }
        finally {
            this.commandList.commandFinished();
        }
    }

    @Override
    public Command getErrorCommand() {
        return new ChangeFolderCommand$1(this, this.msgApp);
    }

    static /* synthetic */ void access$000(ChangeFolderCommand changeFolderCommand, boolean bl, FolderEntry folderEntry) {
        changeFolderCommand.signalResult(bl, folderEntry);
    }
}

