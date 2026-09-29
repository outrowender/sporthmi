/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.handler.IMobilityHorizonHandler;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class MobilityHorizonHandler
implements IMobilityHorizonHandler {
    private static final int[] CONSIDERED_LOCATION_TYPES = new int[]{1};
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final MapMain mainMap;
    private DSIMobilityHorizon dsiMobilityHorizon;

    public MobilityHorizonHandler(NavigationEnv navigationEnv, MapMain mapMain, LogChannel logChannel) {
        this.env = navigationEnv;
        this.mainMap = mapMain;
        this.logChannel = logChannel;
    }

    @Override
    public void setDSIMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
        this.logChannel.log(1078071040, "MobilityHorizonHandler#setDSIMobilityHorizon() - mobilityHorizon: %1 ", (Object)dSIMobilityHorizon);
        if (dSIMobilityHorizon != null) {
            dSIMobilityHorizon.setNotification(new int[]{2, 3, 1, 4}, (DSIListener)this);
            int n = this.retrieveDriveTrainMode();
            dSIMobilityHorizon.setDriveTrainMode(n);
            dSIMobilityHorizon.setConsideredLocationTypes(CONSIDERED_LOCATION_TYPES);
        } else {
            this.deinitDSI();
            this.mainMap.getActiveContext().updateMobilityHorizonStatus(0);
        }
        this.dsiMobilityHorizon = dSIMobilityHorizon;
    }

    private int retrieveDriveTrainMode() {
        if (Util.isRangeMapModeBEV(this.env.getFramework())) {
            return 0;
        }
        if (Util.isRangeMapModePHEV(this.env.getFramework())) {
            return 1;
        }
        this.logChannel.log(10000, "MobilityHorizonHandler#retrieveDriveTrainMode() - could not determine drive train mode - using default: DRIVETRAINMODE_SECONDARY=%1 ", 1L);
        return 1;
    }

    private final void deinitDSI() {
        this.logChannel.log(-2137614336, "MobilityHorizonHandler#deinit()");
        if (this.dsiMobilityHorizon != null) {
            try {
                this.dsiMobilityHorizon.clearNotification(this);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "MobilityHorizonHandler#deinitDSI() - ERROR=%1", (Throwable)exception);
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(1078071040, "MobilityHorizonHandler#asyncException() - errorCode: %2, requestType: %3, errorMsg: %1", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray, int n) {
        if (n == 1) {
            this.logChannel.log(14808325, "MobilityHorizonHandler#updateLocations() - not implemented ");
        }
    }

    @Override
    public void updateConsideredLocationTypes(int[] nArray, int n) {
        if (n == 1) {
            this.logChannel.log(14808325, "MobilityHorizonHandler#updateConsideredLocationTypes() - not implemented ");
        }
    }

    @Override
    public void updateDriveTrainMode(int n, int n2) {
        if (n2 == 1) {
            this.logChannel.log(1078071040, "MobilityHorizonHandler#updateDriveTrainMode() - driveTrainMode: %1 ", (long)n);
        }
    }

    @Override
    public void updateMobilityHorizonStatus(int n, int n2) {
        if (n2 == 1) {
            this.logChannel.log(1078071040, "MobilityHorizonHandler#updateMobilityHorizonStatus() - status: %1 ", (long)n);
            this.mainMap.getActiveContext().updateMobilityHorizonStatus(n);
        }
    }

    @Override
    public void requestLocationRangeLevelResult(int n, int n2) {
        this.logChannel.log(14808325, "MobilityHorizonHandler#requestLocationRangeLevelResult() - unexpected call! ");
    }

    @Override
    public void locationRangeLevelChanged(int n) {
        this.logChannel.log(14808325, "MobilityHorizonHandler#locationRangeLevelChanged() - unexpected call! ");
    }
}

