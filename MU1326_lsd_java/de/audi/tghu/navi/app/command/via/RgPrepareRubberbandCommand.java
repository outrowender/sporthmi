/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;

public class RgPrepareRubberbandCommand
extends NavCommand {
    private boolean bStopGuidance = true;
    private boolean respRgRouteCalculationState_OK = false;

    public RgPrepareRubberbandCommand(boolean bl) {
        super("RgPrepareRubberbandCommand");
        this.bStopGuidance = bl;
    }

    public void execute() {
        this.logger.log(10000000, "RgPrepareRubberbandCommand#execute() - calling rgPrepareRubberbandManipulation( %1 ) ", this.bStopGuidance);
        this.getDSINavigation().rgPrepareRubberbandManipulation(this.bStopGuidance);
    }

    public void updateRgActive(boolean bl) {
        try {
            super.updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logger.log(10000, "RgPrepareRubberbandCommand#updateRgActive() - %1", (Throwable)exception);
        }
        this.checkFinish();
    }

    public void updateRgRouteCalculationState(int n) {
        this.respRgRouteCalculationState_OK = n == 2;
        try {
            super.updateRgRouteCalculationState(n);
        }
        catch (Exception exception) {
            this.logger.log(10000, "RgPrepareRubberbandCommand#updateRgRouteCalculationState() - %1", (Throwable)exception);
        }
        this.checkFinish();
    }

    private void checkFinish() {
        this.logger.log(10000000, "RgPrepareRubberbandCommand#checkFinish() - RgActive = %1, respRgRouteCalculationState_OK = %2", this.dsiResponseContainer.isRgActive(), this.respRgRouteCalculationState_OK);
        if (!this.dsiResponseContainer.isRgActive() && this.respRgRouteCalculationState_OK) {
            this.getCommandList().commandFinished();
        }
    }
}

