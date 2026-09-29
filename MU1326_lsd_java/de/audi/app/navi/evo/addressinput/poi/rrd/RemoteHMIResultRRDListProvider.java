/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.rrd;

import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class RemoteHMIResultRRDListProvider
implements IRRDListProvider {
    private static final int CALCULATION_LIMIT_RHMI_RESULT;
    private final LogChannel poiLogChannel;
    private final IVehicle vehicle;
    private final Navigation navigation;

    public RemoteHMIResultRRDListProvider(NavigationEnv navigationEnv, IVehicle iVehicle, Navigation navigation) {
        this.vehicle = iVehicle;
        this.poiLogChannel = navigationEnv.getPOILogChannel();
        this.navigation = navigation;
    }

    @Override
    public NavLocationWgs84[] getRRDCalculationList() {
        this.poiLogChannel.log(1078071040, "RemoteHMIResultRRDListProvider#getRRDCalculationList: Called");
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[]{};
        NaviOnlineService naviOnlineService = this.navigation.getInterAppService().getNaviOnlineService();
        if (naviOnlineService != null) {
            int[] nArray = naviOnlineService.getRequestedLatitudes();
            int[] nArray2 = naviOnlineService.getRequestedLongitudes();
            if (nArray != null && nArray.length > 0 && nArray2 != null && nArray2.length > 0) {
                int n = Math.min(10, nArray.length);
                navLocationWgs84Array = new NavLocationWgs84[n];
                for (int i2 = 0; i2 < n; ++i2) {
                    navLocationWgs84Array[i2] = new NavLocationWgs84();
                    navLocationWgs84Array[i2].latitude = nArray[i2];
                    navLocationWgs84Array[i2].longitude = nArray2[i2];
                    this.poiLogChannel.log(1078071040, "RemoteHMIResultRRDListProvider#getRRDCalculationList: lat %1, lon %2", (long)nArray[i2], (long)nArray2[i2]);
                }
            } else {
                this.poiLogChannel.log(-1601830656, "RemoteHMIResultRRDListProvider#triggerRRDCalculation() - Failed to trigger RRD calculation!");
            }
            this.poiLogChannel.log(1078071040, "RemoteHMIResultRRDListProvider#getRRDCalculationList: requesting RRD with %1 entries", (long)navLocationWgs84Array.length);
        } else {
            this.poiLogChannel.log(-1601830656, "RemoteHMIResultRRDListProvider#getRRDCalculationList: naviService empty, no calculation possible");
        }
        return navLocationWgs84Array;
    }

    @Override
    public void updateDirectionAndAirDistance(PosPosition posPosition) {
        this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: Called");
        NaviOnlineService naviOnlineService = this.navigation.getInterAppService().getNaviOnlineService();
        int[] nArray = new int[]{};
        int[] nArray2 = new int[]{};
        int[] nArray3 = new int[]{};
        int[] nArray4 = new int[]{};
        if (naviOnlineService.getRequestedLatitudes() != null && naviOnlineService.getRequestedLongitudes() != null) {
            nArray = naviOnlineService.getRequestedLatitudes();
            nArray2 = naviOnlineService.getRequestedLongitudes();
            nArray3 = new int[nArray.length];
            nArray4 = new int[nArray.length];
        }
        if (nArray != null && nArray.length > 0 && nArray2 != null && nArray2.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (posPosition != null) {
                    nArray3[i2] = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), nArray2[i2], nArray[i2]);
                    int n = Util.computeAbsoluteDirection(posPosition, nArray2[i2], nArray[i2]);
                    int n2 = this.vehicle.getHeading(posPosition);
                    nArray4[i2] = Util.convertRotatingDirection(n, n2);
                } else {
                    nArray3[i2] = 0;
                    nArray4[i2] = 0;
                    posPosition = new PosPosition();
                }
                this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: distance %1, direction %2", (long)nArray3[i2], (long)nArray4[i2]);
                this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: vehiclepos lat %1, vehiclepos lon %2", (long)posPosition.getLatitude(), (long)posPosition.getLongitude());
            }
        } else {
            this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: requested Lat and lon empty");
        }
        if (naviOnlineService != null) {
            this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#updateDirectionAndAirDistance: updating %1/%2 entries of distances and directions", (long)nArray3.length, (long)nArray4.length);
            naviOnlineService.updateDirectionAndAirDistance(nArray3, nArray4);
        }
    }

    @Override
    public int getRRDListCalculationLimit() {
        this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#getRRDListCalculationLimit()");
        return 10;
    }

    @Override
    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.poiLogChannel.log(1078071040, "RemoteHMIResultRRDListProvider#updateRRDDistances: Called with distances %1", (Object)rrdCalculationInfoArray);
        NaviOnlineService naviOnlineService = this.navigation.getInterAppService().getNaviOnlineService();
        if (naviOnlineService != null) {
            this.poiLogChannel.log(1078071040, "RemoteHMIResultRRDListProvider#updateRRDDistances: updating %1 entries", (long)rrdCalculationInfoArray.length);
            naviOnlineService.updateRRDDistances(rrdCalculationInfoArray);
        } else {
            this.poiLogChannel.log(1078071040, "RemoteHMIResultRRDListProvider#updateRRDDistances: naviService null, not updating RRD distance");
        }
    }

    @Override
    public void unitsChanged() {
        this.poiLogChannel.log(-2137614336, "RemoteHMIResultRRDListProvider#unitsChanged()");
    }
}

