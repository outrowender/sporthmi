/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import de.audi.tghu.navi.app.command.NavCommand;

public class RRDStopCalculationCommand
extends NavCommand {
    public void execute() {
        if (this.dsiResponseContainer.isRRDActive()) {
            this.logger.log(1000000, "RRDStopCalculationCommand#execute() - calling rrdStopCalculation() ");
            this.getDSINavigation().rrdStopCalculation();
        } else {
            this.logger.log(1000000, "RRDStopCalculationCommand#execute() - not calling rrdStopCalculation() ");
            this.getCommandList().commandFinished();
        }
    }

    public void updateRrdActive(boolean bl) {
        super.updateRrdActive(bl);
        this.logger.log(1000000, "RRDStopCalculationCommand#updateRrdActive(%1)", bl);
        this.getCommandList().commandFinished();
    }
}

