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

    public void execute() {
        this.logger.log(1000000, "DeletePersonalPOICommand#execute() - calling deletePersonalPOIDataBases() ");
        this.getDSINavigation().deletePersonalPOIDataBases(this.paths);
    }

    public void deletePersonalPOIDataBasesResult(int n) {
        this.logger.log(1000000, "DeletePersonalPOICommand#deletePersonalPOIDataBasesResult( %1 )", (long)n);
        if (n == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n);
        }
    }
}

