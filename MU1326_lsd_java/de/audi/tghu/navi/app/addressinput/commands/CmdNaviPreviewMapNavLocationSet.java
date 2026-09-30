/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.LIValueListElement;

public class CmdNaviPreviewMapNavLocationSet
extends NavCommand {
    private final IPreviewMap previewMap;
    private final NavLocationWgs84 destination;

    public CmdNaviPreviewMapNavLocationSet(LIValueListElement lIValueListElement, IPreviewMap iPreviewMap) {
        this.previewMap = iPreviewMap;
        this.destination = new NavLocationWgs84(lIValueListElement.getLongitude(), lIValueListElement.getLatitude());
    }

    public CmdNaviPreviewMapNavLocationSet(NavLocation navLocation, IPreviewMap iPreviewMap) {
        this.previewMap = iPreviewMap;
        this.destination = Util.navLocationToWgs84(navLocation);
    }

    public void execute() {
        if (this.previewMap == null) {
            this.getCommandList().commandAborted("previewMap is null");
            return;
        }
        this.env.getLogChannel().log(10000000, "%1#execute longitude = %2, latitude = %3", (Object)this.CLASS_NAME, (long)this.destination.getLongitude(), (long)this.destination.getLatitude());
        this.previewMap.setPreviewLocation(Util.wgs84ToNavLocation(this.destination), 1, null, null);
        this.getCommandList().commandFinished();
    }
}

