/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;

public class RgConfigurePoiInfoCommand
extends NavCommand {
    @Override
    public void execute() {
        int n = Util.getRouteInfoConfigMode(this.env.getFramework());
        if (1 == n) {
            this.getDSINavigation().rgConfigurePoiInfo(new NavPoiInfoConfiguration(new int[0]));
            this.logger.log(-2137614336, "RgConfigurePoiInfoCommand#execute(), rgConfigurePoiInfo(int [])");
        } else if (2 == n) {
            this.getDSINavigation().rgConfigurePoiInfo(new NavPoiInfoConfiguration(new int[]{1}));
            this.logger.log(-2137614336, "RgConfigurePoiInfoCommand#execute(), rgConfigurePoiInfo(int [DSINavigation.NAVPOIINFOTYPE_CONTROLLEDACCESS])");
        }
        this.getCommandList().commandFinished();
    }
}

