/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LISpellerData;

public class LiGetStateCommand
extends NavCommand {
    @Override
    public void execute() {
        this.logger.log(-2137614336, "LIGetStateCommand#execute() - calling liGetState() ");
        this.getDSINavigation().liGetState();
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        this.logger.log(-2137614336, "LIGetStateCommand#liGetStateResult() ");
        this.dsiResponseContainer.setSpellerState(lISpellerData);
        this.getCommandList().commandFinished();
    }
}

