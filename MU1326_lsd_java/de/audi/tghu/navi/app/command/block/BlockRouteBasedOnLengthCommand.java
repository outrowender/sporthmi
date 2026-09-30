/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.block;

import de.audi.tghu.navi.app.command.NavCommand;

public class BlockRouteBasedOnLengthCommand
extends NavCommand {
    public static final String BLOCK_UID = "BLOCK_UID";
    private final int offset;
    private final int length;

    public BlockRouteBasedOnLengthCommand(int n, int n2) {
        this.offset = n;
        this.length = n2;
    }

    public void execute() {
        this.logger.log(1000000, "BlockRouteBasedOnLengthCommand#execute() - calling blockRouteBasedOnLength( %1, %2 )", (long)this.offset, (long)this.length);
        this.getDSIBlocking().blockRouteBasedOnLength(this.offset, this.length);
    }

    public void blockRouteBasedOnLengthResult(long l, int n) {
        this.logger.log(1000000, "BlockRouteBasedOnLengthCommand#blockRouteBasedOnLengthResult()");
        this.getCommandList().put(BLOCK_UID, new Long(l));
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "BlockRouteBasedOnLengthCommand#blockRouteBasedOnLengthResult() - got error code %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }
}

