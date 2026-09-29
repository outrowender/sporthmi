/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.block;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;

public class DeleteBlockCommand
extends NavCommand {
    private final SimpleDetourHandler simpleDetourHandler;
    private final long uid;

    public DeleteBlockCommand(SimpleDetourHandler simpleDetourHandler, long l) {
        this.simpleDetourHandler = simpleDetourHandler;
        this.uid = l;
    }

    @Override
    public void execute() {
        if (this.simpleDetourHandler.isBlockUidAvailable(this.uid)) {
            this.logger.log(1078071040, "DeleteBlockCommand#execute() - calling deleteBlock()");
            this.getDSIBlocking().deleteBlock(new long[]{this.uid});
        } else {
            this.logger.log(1078071040, "DeleteBlockCommand#execute() - blocking already vanished, do nothing");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void deleteBlockResult(long[] lArray, int n) {
        this.logger.log(1078071040, "DeleteBlockCommand#deleteBlockResult() resultCode = %1", (long)n);
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "DeleteBlockCommand#deleteBlockResult() - got error code %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }

    private void dummyResult() {
        this.simpleDetourHandler.updateListOfBlocks(null);
        this.deleteBlockResult(new long[]{this.uid}, 0);
    }
}

