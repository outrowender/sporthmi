/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.via;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocationWgs84;

public class RgSetRubberbandPosition
extends NavCommand {
    private NavLocationWgs84 navPosition;

    public RgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        super("RgSetRubberbandPosition");
        this.navPosition = navLocationWgs84;
    }

    public void execute() {
        this.logger.log(10000000, "RgSetRubberbandPosition#execute() - calling rgSetRubberbandPosition( %1 ) ", (Object)this.navPosition);
        this.getDSINavigation().rgSetRubberbandPosition(this.navPosition);
        this.getCommandList().commandFinished();
    }
}

