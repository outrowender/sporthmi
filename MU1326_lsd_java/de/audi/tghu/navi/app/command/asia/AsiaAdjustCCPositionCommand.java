/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.asia;

import de.audi.tghu.navi.app.command.NavCommand;

public class AsiaAdjustCCPositionCommand
extends NavCommand {
    private int positivePopup;
    private int negativePopup;

    public AsiaAdjustCCPositionCommand(int n, int n2) {
        this.positivePopup = n;
        this.negativePopup = n2;
    }

    public void execute() {
        this.logger.log(1000000, "AsiaAdjustCCPPositionCommand#execute() call rgSwitchToNextPossibleRoad");
        this.getDSINavigation().rgSwitchToNextPossibleRoad();
    }

    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        this.logger.log(1000000, "AsiaAdjustCCPPositionCommand#rgSwitchToNextPossibleRoadResult( %1 )", bl);
        int n = bl ? this.positivePopup : this.negativePopup;
        this.env.getHMIService().getChoiceModel(n).setValue(0);
        this.env.getHMIService().getChoiceModel(n).setValue(1);
        this.getCommandList().commandFinished();
    }
}

