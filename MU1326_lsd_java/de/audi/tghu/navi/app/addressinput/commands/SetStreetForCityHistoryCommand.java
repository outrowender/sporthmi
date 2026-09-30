/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class SetStreetForCityHistoryCommand
extends NavCommand {
    public void execute() {
        this.getDSINavigation().liSetStreetForCityHistory(this.dsiResponseContainer.getLiCurrentLD().street);
    }

    public void liHistoryResult(int n) {
        if (n == 0) {
            this.logger.log(10000000, this.CLASS_NAME + "#updateLiCityHistory#liHistoryResult() - result OK");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000000, this.CLASS_NAME + "#updateLiCityHistory#liHistoryResult() - commandAborted");
            this.getCommandList().commandAborted(n);
        }
    }
}

