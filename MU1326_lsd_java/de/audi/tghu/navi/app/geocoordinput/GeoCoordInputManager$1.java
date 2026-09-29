/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.geocoordinput;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager;
import org.dsi.ifc.global.NavLocation;

class GeoCoordInputManager$1
extends NavCommand {
    private final /* synthetic */ boolean val$setPreviewMapLocation;
    private final /* synthetic */ GeoCoordInputManager this$0;

    GeoCoordInputManager$1(GeoCoordInputManager geoCoordInputManager, boolean bl) {
        this.this$0 = geoCoordInputManager;
        this.val$setPreviewMapLocation = bl;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        GeoCoordInputManager.access$000(this.this$0).onUpdateLocation(navLocation);
        GuiTooltipInformationContainer guiTooltipInformationContainer = GeoCoordInputManager.access$000(this.this$0).createMapTooltipInformationContainer(navLocation, null);
        if (this.val$setPreviewMapLocation) {
            this.this$0.coordinateUpdateSetPreviewMap(guiTooltipInformationContainer);
        }
        this.getCommandList().commandFinished();
    }
}

