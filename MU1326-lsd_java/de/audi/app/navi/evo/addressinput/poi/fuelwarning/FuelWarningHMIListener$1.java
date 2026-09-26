/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningHMIListener;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class FuelWarningHMIListener$1
extends NavCommand {
    private final /* synthetic */ FuelWarningHMIListener this$0;

    FuelWarningHMIListener$1(FuelWarningHMIListener fuelWarningHMIListener) {
        this.this$0 = fuelWarningHMIListener;
    }

    @Override
    public void execute() {
        FuelWarningHMIListener.access$000(this.this$0).setPreviewPOIsOnboardAroundCCP(new NavLocation[]{this.dsiResponseContainer.getSelectedLocation()}, 2, null, null);
        this.getCommandList().commandFinished();
    }
}

