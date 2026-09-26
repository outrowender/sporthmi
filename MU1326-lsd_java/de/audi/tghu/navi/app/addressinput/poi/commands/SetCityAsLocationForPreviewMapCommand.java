/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueListElement;

public class SetCityAsLocationForPreviewMapCommand
extends NavCommand {
    private final IPreviewMap previewMap;
    private final LIValueListElement element;

    public SetCityAsLocationForPreviewMapCommand(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        this.previewMap = iPreviewMap;
        this.element = lIValueListElement;
    }

    @Override
    public void execute() {
        if (this.previewMap == null) {
            this.getCommandList().commandAborted("SetCityLocationForPreviewMapCommand#execute - previewMap is null");
            return;
        }
        if (this.element == null) {
            this.getCommandList().commandAborted("SetCityLocationForPreviewMapCommand#execute - LIValueListElement is null");
            return;
        }
        this.env.getCommandLogChannel().log(-2137614336, "SetCityLocationForPreviewMapCommand#execute - element.longitude=%1, element.latitude=%2", (long)this.element.getLongitude(), (long)this.element.getLatitude());
        NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(this.element.getLongitude(), this.element.getLatitude());
        this.previewMap.setPreviewLocationCity(Util.wgs84ToNavLocation(navLocationWgs84), 1, null, null);
        this.getCommandList().commandFinished();
    }
}

