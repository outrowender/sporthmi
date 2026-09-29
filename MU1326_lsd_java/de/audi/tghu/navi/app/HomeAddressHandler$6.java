/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class HomeAddressHandler$6
extends NavCommand {
    private final /* synthetic */ GuiModelAccessForPreviewMapDetailScreen val$detailsModelAccess;
    private final /* synthetic */ NavLocation val$homeAddressLocation;
    private final /* synthetic */ HomeAddressHandler this$0;

    HomeAddressHandler$6(HomeAddressHandler homeAddressHandler, String string, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, NavLocation navLocation) {
        this.this$0 = homeAddressHandler;
        this.val$detailsModelAccess = guiModelAccessForPreviewMapDetailScreen;
        this.val$homeAddressLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        GuiTooltipInformationContainer guiTooltipInformationContainer = null;
        if (this.val$detailsModelAccess != null) {
            guiTooltipInformationContainer = this.val$detailsModelAccess.createMapTooltipInformationContainer(this.val$homeAddressLocation, null);
        }
        this.this$0.mapInterface.getPreviewMap().setPreviewFavoriteHome(this.val$homeAddressLocation, 12, this.val$detailsModelAccess, guiTooltipInformationContainer);
        this.getCommandList().commandFinished();
    }
}

