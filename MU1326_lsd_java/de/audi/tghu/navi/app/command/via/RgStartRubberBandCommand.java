/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;

public class RgStartRubberBandCommand
extends NavCommand {
    private int iRouteSectionIndex = -1;

    public RgStartRubberBandCommand(int n) {
        super("RgStartRubberBandCommand");
        this.iRouteSectionIndex = n;
    }

    public void execute() {
        this.logger.log(10000000, "RgStartRubberBandCommand#execute() - calling rgStartRubberbandManipulation( %1 ) ", (long)this.iRouteSectionIndex);
        this.getDSINavigation().rgStartRubberbandManipulation(this.iRouteSectionIndex);
    }

    public void rgStartRubberbandManipulationResult(int n) {
        this.getCommandList().commandFinished();
    }
}

