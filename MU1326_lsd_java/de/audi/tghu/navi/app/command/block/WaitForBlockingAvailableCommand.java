/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.block;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.block.IWaitForBlockingAvailableListener;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;

public class WaitForBlockingAvailableCommand
extends NavCommand
implements IWaitForBlockingAvailableListener {
    private final SimpleDetourHandler simpleDetourHandler;
    private final boolean forceNoWait;

    public WaitForBlockingAvailableCommand(SimpleDetourHandler simpleDetourHandler, boolean bl) {
        this.simpleDetourHandler = simpleDetourHandler;
        this.forceNoWait = bl;
        simpleDetourHandler.registerAsListener(this);
    }

    public void execute() {
        this.logger.log(10000000, "WaitForBlockingAvailableCommand#execute()");
        if (this.forceNoWait && !this.dsiResponseContainer.isRgActive()) {
            this.logger.log(10000000, "WaitForBlockingAvailableCommand#execute() - route guidance not active, ignore current navigation status");
            this.finishCommand();
        } else if (this.simpleDetourHandler.isBlockingPossible()) {
            this.logger.log(10000000, "WaitForBlockingAvailableCommand#execute() - blocking enabled");
            this.finishCommand();
        } else {
            this.logger.log(10000000, "WaitForBlockingAvailableCommand#execute() - blocking disabled, wait for re-enable");
        }
    }

    private void finishCommand() {
        this.simpleDetourHandler.derigisterAsListener(this);
        this.getCommandList().commandFinished();
    }

    public void updateBlockingAvailable(boolean bl) {
        this.logger.log(10000000, "WaitForBlockingAvailableCommand#updateBlockingAvailable( %1 )", bl);
        if (this.simpleDetourHandler.isBlockingPossible()) {
            this.logger.log(10000000, "WaitForBlockingAvailableCommand#updateBlockingAvailable() - blocking re-enabled");
            this.finishCommand();
        }
    }
}

