/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;

public class MekkaCompassUpdater {
    public static final double KAABA_POSITION_LATITUDE;
    public static final double KAABA_POSITION_LONGITUDE;
    public static final NavLocationWgs84 kaabaPosition;
    private final NavigationEnv navigationEnv;
    private final IVehicle vehicle;
    public final ChoiceModelApp directionToMekkaModel;

    public MekkaCompassUpdater(NavigationEnv navigationEnv, IVehicle iVehicle) {
        this.navigationEnv = navigationEnv;
        this.vehicle = iVehicle;
        this.directionToMekkaModel = navigationEnv.getChoiceModel(1445070336);
    }

    private int getDirectionToKaaba() {
        PosPosition posPosition = this.vehicle.getFrontUnitPosition();
        if (posPosition == null) {
            return -1;
        }
        if (posPosition.getLatitude() == 0 && posPosition.getLatitude() == 0) {
            return -1;
        }
        int n = posPosition.getDirectionAngle();
        if (n == -65536) {
            return -1;
        }
        int n2 = Util.computeAbsoluteDirection(posPosition, kaabaPosition.getLongitude(), kaabaPosition.getLatitude());
        return (360 - n2 + n) % 360;
    }

    public void onSoPosPositionUpdated() {
        if (this.directionToMekkaModel != null) {
            int n = this.getDirectionToKaaba();
            this.navigationEnv.getLogChannel().log(-2137614336, "QiblaUpdater#onSoPosPositionUpdated() - direction to Kaaba: %1", (long)n);
            this.directionToMekkaModel.setValue(n);
        } else {
            this.navigationEnv.getLogChannel().log(-2137614336, "QiblaUpdater#onSoPosPositionUpdated() - model not available");
        }
    }

    static {
        kaabaPosition = new NavLocationWgs84(NavigationUtilities.degreeToWgs84(39.826181), NavigationUtilities.degreeToWgs84(21.4225));
    }
}

