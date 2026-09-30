/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class AddCityToHistoryCommand
extends NavCommand {
    private CityHistory cityHistory;
    private final NavLocation navLocation;

    public AddCityToHistoryCommand(CityHistory cityHistory) {
        this.cityHistory = cityHistory;
        this.navLocation = null;
    }

    public AddCityToHistoryCommand(NavLocation navLocation, CityHistory cityHistory) {
        this.navLocation = navLocation;
        this.cityHistory = cityHistory;
    }

    public void execute() {
        if (this.navLocation == null) {
            if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
                boolean bl = this.dsiResponseContainer.refinementCriterionAvailable(3);
                this.getCommandList().commandFinishedWithPostSequence(this.cityHistory.addLastCityCommandList(this.dsiResponseContainer.getLiCurrentLD(), bl));
            } else {
                this.getCommandList().commandAborted("AddCityToHistoryCommand#execute the NavLocation is no valid");
            }
        } else if (this.navLocation.isPositionValid()) {
            boolean bl = this.dsiResponseContainer.refinementCriterionAvailable(3);
            this.getCommandList().commandFinishedWithPostSequence(this.cityHistory.addLastCityCommandList(this.navLocation, bl));
        } else {
            this.getCommandList().commandAborted("AddCityToHistoryCommand#execute the NavLocation is no valid");
        }
    }
}

