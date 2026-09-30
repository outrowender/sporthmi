/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;

public class RgStopRubberBandCommand
extends NavCommand {
    private boolean checkRubberbandActiveFlag = false;
    private boolean stopGuidance = false;

    public RgStopRubberBandCommand(boolean bl) {
        super("RgStopRubberBandCommand");
        this.checkRubberbandActiveFlag = bl;
        this.stopGuidance = false;
    }

    public RgStopRubberBandCommand(boolean bl, boolean bl2) {
        super("RgStopRubberBandCommand");
        this.checkRubberbandActiveFlag = bl;
        this.stopGuidance = bl2;
    }

    public void execute() {
        boolean bl = this.navigation.getMapManager().getRouteCalculationHandler().isRubberbandActive();
        this.logger.log(10000000, "RgStopRubberBandCommand#execute() - checkRubberbandActiveFlag: %1, stopGuidance: %2, isRubberbandActive: %3 ", this.checkRubberbandActiveFlag, this.stopGuidance, bl);
        if (!this.checkRubberbandActiveFlag || this.navigation.getMapManager().getRouteCalculationHandler().isRubberbandActive()) {
            this.logger.log(10000000, "RgStopRubberBandCommand#execute() - call rgStopRubberbandManipulation()");
            this.getDSINavigation().rgStopRubberbandManipulation();
            int n = this.dsiResponseContainer.getRgRouteCalculationState();
            if (this.stopGuidance && n != 0) {
                this.logger.log(10000000, "RgStopRubberBandCommand#execute() - call rgStopGuidance()");
                this.getDSINavigation().rgStopGuidance();
            }
            this.checkFinish();
        } else {
            this.getCommandList().commandFinished();
        }
    }

    public void abort() {
        super.abort();
        this.navigation.getMapManager().getRouteCalculationHandler().setRubberbandActive(false);
    }

    public void updateRgActive(boolean bl) {
        try {
            super.updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logger.log(10000, "RgStopRubberBandCommand#updateRgActive() - %1", (Throwable)exception);
        }
        this.checkFinish();
    }

    public void updateRgRouteCalculationState(int n) {
        try {
            super.updateRgRouteCalculationState(n);
        }
        catch (Exception exception) {
            this.logger.log(10000, "RgStopRubberBandCommand#updateRgRouteCalculationState() - %1", (Throwable)exception);
        }
        this.checkFinish();
    }

    private void checkFinish() {
        int n = this.dsiResponseContainer.getRgRouteCalculationState();
        this.logger.log(10000000, "RgStopRubberBandCommand#checkFinish() - routeCalcState = %1", (long)n);
        if (n == 0) {
            this.navigation.getMapManager().getRouteCalculationHandler().setRubberbandActive(false);
            this.getCommandList().commandFinished();
        }
    }
}

