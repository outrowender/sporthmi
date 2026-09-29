/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

public class StoreCurrentLDCommand
extends NavCommand {
    public static final String STORED_LI_CURRENT_LD;

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation != null) {
            this.getCommandList().put("liCurrentLD", navLocation);
        }
        this.getCommandList().commandFinished();
    }
}

