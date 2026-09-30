/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class RgStopGuidanceGeneralCommand
extends NavCommand {
    public void execute() {
        this.navigation.getDemoModeManager().stopCurrentDemoModeGuidance();
        boolean bl = this.dsiResponseContainer.isRgActive();
        int n = this.dsiResponseContainer.getRgRouteCalculationState();
        this.logger.log(10000000, "RgStopGuidanceGeneralCommand#execute() - rgActive: %1, rgRouteCalculationState: %2", bl, (long)n);
        if (bl || n != 0) {
            this.logger.log(10000000, "RgStopGuidanceGeneralCommand#execute() - calling rgStopGuidance()");
            this.getDSINavigation().rgStopGuidance();
        } else {
            this.getCommandList().commandFinished();
        }
    }

    public void updateRgActive(boolean bl) {
        this.logger.log(10000000, "RgStopGuidanceGeneralCommand#updateRgActive( %1 )", bl);
        super.updateRgActive(bl);
        this.checkFinished();
    }

    public void updateRgRouteCalculationState(int n) {
        this.logger.log(10000000, "RgStopGuidanceGeneralCommand#updateRgRouteCalculationState( %1 )", (long)n);
        super.updateRgRouteCalculationState(n);
        this.checkFinished();
    }

    private void checkFinished() {
        if (!this.dsiResponseContainer.isRgActive() && this.dsiResponseContainer.getRgRouteCalculationState() == 0) {
            this.getCommandList().commandFinished();
        }
    }
}

