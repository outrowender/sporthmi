/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class DeletePersonalPOICommand
extends NavCommand {
    private final String[] paths;

    public DeletePersonalPOICommand(String[] stringArray) {
        this.paths = stringArray;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "DeletePersonalPOICommand#execute() - calling deletePersonalPOIDataBases() ");
        this.getDSINavigation().deletePersonalPOIDataBases(this.paths);
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
        this.logger.log(1078071040, "DeletePersonalPOICommand#deletePersonalPOIDataBasesResult( %1 )", (long)n);
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

