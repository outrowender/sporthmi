/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import org.dsi.ifc.global.NavLocation;

public class ModelUpdatePoiLocationCommand
extends NavCommand {
    private final GuiModelAccessDetailsNavi modelAccess;

    public ModelUpdatePoiLocationCommand(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        this.modelAccess = guiModelAccessDetailsNavi;
    }

    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        this.modelAccess.onUpdateLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

