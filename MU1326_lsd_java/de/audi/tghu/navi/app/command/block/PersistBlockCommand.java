/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.block;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.BlockElement;

public class PersistBlockCommand
extends NavCommand {
    private long[] uid;

    public PersistBlockCommand(long[] lArray) {
        this.uid = lArray;
    }

    public void execute() {
        this.logger.log(10000000, "PersistBlockCommand#execute() - calling persistBlock()");
        this.getDSIBlocking().persistBlock(this.uid);
    }

    public void persistBlockResult(long[] lArray, int n) {
        this.logger.log(10000000, "PersistBlockCommand#persistBlockResult()");
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "PersistBlockCommand#persistBlockResult() - got error code %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }

    private void dummyResults() {
        String string = this.navigation.getSimpleDetourHandler().getBlocks()[0].getDescription();
        this.navigation.getSimpleDetourHandler().updateListOfBlocks(new BlockElement[]{new BlockElement(this.uid[0], 3, 0, true, true, string)});
        this.persistBlockResult(this.uid, 0);
    }
}

