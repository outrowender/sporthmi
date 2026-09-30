/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.NaviInterface;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class CalcRRDAndSendToCallBackCommand
extends NavCommand {
    private static final long TIMEOUT = 15000L;
    private final NavLocationWgs84 navLocation;
    private final NaviInterface.INotifyWhenRealRouteCalulcationisDone callback;

    public CalcRRDAndSendToCallBackCommand(NavLocationWgs84 navLocationWgs84, NaviInterface.INotifyWhenRealRouteCalulcationisDone iNotifyWhenRealRouteCalulcationisDone) {
        this.navLocation = navLocationWgs84;
        this.callback = iNotifyWhenRealRouteCalulcationisDone;
    }

    public void execute() {
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[]{this.navLocation};
        this.logger.log(1000000, "CalcRRDAndSendToCallBackCommand#execute() - calling rrdStartCalculationForPosition(), length: %1 ", (long)navLocationWgs84Array.length);
        this.getDSINavigation().rrdStartCalculationForPosition(navLocationWgs84Array);
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.logger.log(1000000, "%1#updateRrdCalculationInfo() - rrdCalculationInfo = %2", (Object)this.CLASS_NAME, (Object)rrdCalculationInfoArray);
        if (rrdCalculationInfoArray == null) {
            this.logger.log(10000, "%1#updateRrdCalculationInfo() - array rrdCalculationInfo is null", (Object)this.CLASS_NAME);
        } else if (rrdCalculationInfoArray.length != 1) {
            this.logger.log(10000000, "%1#updateRrdCalculationInfo() - invalid size=%2", (Object)this.CLASS_NAME, (long)rrdCalculationInfoArray.length);
        } else if (rrdCalculationInfoArray[0] == null) {
            this.logger.log(10000, "%1#updateRrdCalculationInfo() - array element at 0 of rrdCalculationInfo is null", (Object)this.CLASS_NAME);
        } else {
            this.callback.update(rrdCalculationInfoArray[0].rrdInfo, rrdCalculationInfoArray[0].rttInfo);
            this.getCommandList().commandFinished();
        }
    }

    public long getTimeout() {
        return 15000L;
    }

    public void resetRRDCalculationFlag() {
        this.callback.resetRRDCalculationFlag();
    }
}

