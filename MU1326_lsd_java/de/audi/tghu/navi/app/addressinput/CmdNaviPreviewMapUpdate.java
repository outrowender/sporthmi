/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class CmdNaviPreviewMapUpdate
extends NavCommand {
    private final IPreviewMap previewMap;
    private final boolean city;
    private final int previewMapClientId;
    private final GuiModelAccessForPreviewMapDetailScreen guiModelUpdating;
    private final GuiTooltipInformationContainer guiTooltipInformation;

    public CmdNaviPreviewMapUpdate(IPreviewMap iPreviewMap, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this(iPreviewMap, false, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public CmdNaviPreviewMapUpdate(IPreviewMap iPreviewMap, boolean bl, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.previewMap = iPreviewMap;
        this.city = bl;
        this.previewMapClientId = n;
        this.guiModelUpdating = guiModelAccessForPreviewMapDetailScreen;
        this.guiTooltipInformation = guiTooltipInformationContainer;
    }

    public void execute() {
        if (this.previewMap != null) {
            NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "CmdNaviPreviewMapUpdate#execute() - navLocation = %1", (Object)LocationFormatter.formatState(navLocation));
            }
            if (navLocation != null && navLocation.isPositionValid()) {
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "CmdNaviPreviewMapUpdate#execute() - navLocation.getLongitude() = %1, navLocation.getLatitude() = %2", (long)navLocation.getLongitude(), (long)navLocation.getLatitude());
                }
                this.env.getContainer().setPreviewLocation(navLocation);
                this.previewMap.setStoreFocusForEnterOnce(true);
                if (this.city) {
                    if (this.logger.isDebug2()) {
                        this.logger.log(100000000, "CmdNaviPreviewMapUpdate#execute() - previewLocationCity(position) is called!");
                    }
                    this.previewMap.setPreviewLocationCity(navLocation, this.previewMapClientId, this.guiModelUpdating, this.guiTooltipInformation);
                } else {
                    if (this.logger.isDebug2()) {
                        this.logger.log(100000000, "CmdNaviPreviewMapUpdate#execute() - previewLocationAroundReferencePoint(position, null) is called!");
                    }
                    this.previewMap.setPreviewLocationAroundReferencePoint(navLocation, null, this.previewMapClientId, this.guiModelUpdating, this.guiTooltipInformation);
                }
                this.env.getChoiceModel(401057).setValue(1);
            } else {
                this.env.getContainer().setPreviewLocation(null);
                this.previewMap.setStoreFocusForEnterOnce(false);
                if (this.logger.isDebug2()) {
                    this.logger.log(100000000, "CmdNaviPreviewMapUpdate#execute() - location invalid");
                }
                this.env.getChoiceModel(401057).setValue(0);
            }
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("PreviewMap is null");
        }
    }
}

