/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.NaviInterface$INotifyWhenRealRouteCalulcationisDone;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class CalcRRDAndSendToCallBackCommand
extends NavCommand {
    private static final long TIMEOUT;
    private final NavLocationWgs84 navLocation;
    private final NaviInterface$INotifyWhenRealRouteCalulcationisDone callback;

    public CalcRRDAndSendToCallBackCommand(NavLocationWgs84 navLocationWgs84, NaviInterface$INotifyWhenRealRouteCalulcationisDone naviInterface$INotifyWhenRealRouteCalulcationisDone) {
        this.navLocation = navLocationWgs84;
        this.callback = naviInterface$INotifyWhenRealRouteCalulcationisDone;
    }

    @Override
    public void execute() {
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[]{this.navLocation};
        this.logger.log(1078071040, "CalcRRDAndSendToCallBackCommand#execute() - calling rrdStartCalculationForPosition(), length: %1 ", (long)navLocationWgs84Array.length);
        this.getDSINavigation().rrdStartCalculationForPosition(navLocationWgs84Array);
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.logger.log(1078071040, "%1#updateRrdCalculationInfo() - rrdCalculationInfo = %2", (Object)this.CLASS_NAME, (Object)rrdCalculationInfoArray);
        if (rrdCalculationInfoArray == null) {
            this.logger.log(10000, "%1#updateRrdCalculationInfo() - array rrdCalculationInfo is null", (Object)this.CLASS_NAME);
        } else if (rrdCalculationInfoArray.length != 1) {
            this.logger.log(-2137614336, "%1#updateRrdCalculationInfo() - invalid size=%2", (Object)this.CLASS_NAME, (long)rrdCalculationInfoArray.length);
        } else if (rrdCalculationInfoArray[0] == null) {
            this.logger.log(10000, "%1#updateRrdCalculationInfo() - array element at 0 of rrdCalculationInfo is null", (Object)this.CLASS_NAME);
        } else {
            this.callback.update(rrdCalculationInfoArray[0].rrdInfo, rrdCalculationInfoArray[0].rttInfo);
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void resetRRDCalculationFlag() {
        this.callback.resetRRDCalculationFlag();
    }
}

