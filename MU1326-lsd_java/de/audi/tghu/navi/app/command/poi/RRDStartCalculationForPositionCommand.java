/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocationWgs84;

public class RRDStartCalculationForPositionCommand
extends NavCommand {
    private NavLocationWgs84[] list;

    public RRDStartCalculationForPositionCommand(NavLocationWgs84[] navLocationWgs84Array) {
        this.list = navLocationWgs84Array;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "RRDStartCalculationForPositionCommand#execute() - calling rrdStartCalculationForPosition(), length: %1 ", (long)this.list.length);
        this.getDSINavigation().rrdStartCalculationForPosition(this.list);
        this.getCommandList().commandFinished();
    }
}

