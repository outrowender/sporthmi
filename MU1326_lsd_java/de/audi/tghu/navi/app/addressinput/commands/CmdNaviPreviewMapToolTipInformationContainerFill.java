/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import org.dsi.ifc.global.NavLocation;

public class CmdNaviPreviewMapToolTipInformationContainerFill
extends NavCommand {
    private GuiTooltipInformationContainer guiTooltipInformationContainer;

    public CmdNaviPreviewMapToolTipInformationContainerFill(GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.guiTooltipInformationContainer = guiTooltipInformationContainer;
    }

    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        PreviewMapUtils.fillToolTipInformationContainerByNavLocation(this.env, navLocation, null, this.guiTooltipInformationContainer);
        this.getCommandList().commandFinished();
    }
}

