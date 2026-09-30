/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class RGStopGuidanceCommand
extends NavCommand {
    public void execute() {
        if (this.navigation.getMapManager().getRouteCalculationHandler().isCalculatingRubberband()) {
            this.getCommandList().commandAborted("cannot stop route guidance while rubberband is calculated");
            return;
        }
        this.navigation.getDemoModeManager().stopCurrentDemoModeGuidance();
        boolean bl = this.dsiResponseContainer.isRgActive();
        int n = this.dsiResponseContainer.getRgRouteCalculationState();
        this.logger.log(10000000, "RGStopGuidanceCommand#execute() - rgActive: %1, rgRouteCalculationState: %2", bl, (long)n);
        if (bl || n != 0) {
            this.logger.log(10000000, "RGStopGuidanceCommand#execute() - calling rgStopGuidance()");
            this.getDSINavigation().rgStopGuidance();
        } else {
            this.getCommandList().commandFinished();
        }
    }

    public void updateRgActive(boolean bl) {
        this.logger.log(10000000, "RgStopGuidanceCommand#updateRgActive( %1 )", bl);
        super.updateRgActive(bl);
        this.checkFinished();
    }

    public void updateRgRouteCalculationState(int n) {
        this.logger.log(10000000, "RgStopGuidanceCommand#updateRgRouteCalculationState( %1 )", (long)n);
        super.updateRgRouteCalculationState(n);
        this.checkFinished();
    }

    private void checkFinished() {
        if (!this.dsiResponseContainer.isRgActive() && this.dsiResponseContainer.getRgRouteCalculationState() == 0) {
            this.getCommandList().commandFinished();
        }
    }
}

