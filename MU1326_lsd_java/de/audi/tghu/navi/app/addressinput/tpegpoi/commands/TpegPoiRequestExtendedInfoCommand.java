/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PoiExtendedInfo;

public class TpegPoiRequestExtendedInfoCommand
extends NavCommand {
    private NavLocation location;

    public TpegPoiRequestExtendedInfoCommand(NavLocation navLocation) {
        this.location = navLocation;
    }

    public TpegPoiRequestExtendedInfoCommand() {
        this.location = null;
    }

    public void execute() {
        if (this.location == null) {
            this.location = this.dsiResponseContainer.getLiCurrentLD();
        }
        this.logger.log(1000000, "TpegPoiRequestExtendedInfoCommand#execute() calling poiRequestExtendedInfo with location = %1", (Object)LocationFormatter.formatLocationShort(this.location));
        this.getDSINavigation().poiRequestExtendedInfo(this.location);
    }

    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        this.logger.log(1000000, "TpegPoiRequestExtendedInfoCommand#poiRequestExtendedInfoResult() extendedInfo = %1, success = %2", (Object)poiExtendedInfo, (Object)Boolean.toString(bl));
        if (bl) {
            this.dsiResponseContainer.setPoiExtendedInfo(poiExtendedInfo);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("received success tag is false from south side");
        }
    }
}

