/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.block;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.BlockElement;

public class SetBlockDescriptionCommand
extends NavCommand {
    private long[] uid;
    private String description;

    public SetBlockDescriptionCommand(long[] lArray, String string) {
        this.uid = lArray;
        this.description = string;
    }

    public void execute() {
        this.logger.log(10000000, "PersistBlockCommand#execute() - calling setBlockDescription()");
        this.getDSIBlocking().setBlockDescription(this.uid, this.description);
    }

    public void setBlockDescriptionResult(long[] lArray, int n) {
        this.logger.log(10000000, "BlockRouteBasedOnLengthCommand#setBlockDescriptionResult()");
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "BlockRouteBasedOnLengthCommand#setBlockDescriptionResult() - got error code %1 !", (long)n);
            this.getCommandList().commandAborted(n);
        }
    }

    private void dummyResults() {
        this.navigation.getSimpleDetourHandler().updateListOfBlocks(new BlockElement[]{new BlockElement(this.uid[0], 3, 0, true, false, this.description)});
        this.setBlockDescriptionResult(this.uid, 0);
    }
}

