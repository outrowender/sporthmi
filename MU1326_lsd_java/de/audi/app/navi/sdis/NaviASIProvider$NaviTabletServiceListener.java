/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviASIProvider;
import de.audi.app.navi.sdis.NaviASIProvider$1;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.sdis.INaviTabletServiceListener;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

class NaviASIProvider$NaviTabletServiceListener
implements INaviTabletServiceListener {
    private final /* synthetic */ NaviASIProvider this$0;

    private NaviASIProvider$NaviTabletServiceListener(NaviASIProvider naviASIProvider) {
        this.this$0 = naviASIProvider;
    }

    @Override
    public void updateCarPosition(PosPosition posPosition) {
        if (NaviASIProvider.access$300(this.this$0).isDebug2()) {
            NaviASIProvider.access$300(this.this$0).log(14808325, "NaviTabletServiceListener#updateCarPosition %1", (Object)posPosition);
        }
        CarPosition carPosition = new CarPosition();
        carPosition.angle = posPosition.directionAngle;
        carPosition.height = posPosition.height;
        carPosition.latitude = NavigationUtilities.wgs84ToDegree(posPosition.latitude);
        carPosition.longitude = NavigationUtilities.wgs84ToDegree(posPosition.longitude);
        carPosition.speed = this.convertFromcmsToms(posPosition.speed);
        try {
            this.this$0.updateCarPosition(carPosition);
        }
        catch (MethodException methodException) {
            NaviASIProvider.access$300(this.this$0).log(10000, "NaviTabletServiceListener#updateCarPosition ", (Throwable)methodException);
        }
    }

    private int convertFromcmsToms(int n) {
        return n / 100;
    }

    @Override
    public void updateRouteGuidanceActive(boolean bl) {
        try {
            this.this$0.updateRouteGuidanceActive(bl);
        }
        catch (MethodException methodException) {
            NaviASIProvider.access$300(this.this$0).log(10000, "NaviTabletServiceListener#updateRouteGuidanceActive ", (Throwable)methodException);
        }
    }

    @Override
    public void updateDestinationInfo(NavRouteListData[] navRouteListDataArray, NavLocation[] navLocationArray, NavigationEnv navigationEnv) {
        DestinationInfo[] destinationInfoArray = new DestinationInfo[navLocationArray.length];
        for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
            DestinationInfo destinationInfo;
            NavLocation navLocation = navLocationArray[i2];
            NavRouteListData navRouteListData = navRouteListDataArray[i2];
            IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
            String[] stringArray = new String[]{AddressFormatter.formatOneLine(navLocation, navigationEnv).getFirstLineAsText()};
            destinationInfoArray[i2] = destinationInfo = new DestinationInfo(NavigationUtilities.wgs84ToDegree(iMyLocationAccessor.getLongitude()), NavigationUtilities.wgs84ToDegree(iMyLocationAccessor.getLatitude()), iMyLocationAccessor.getCountry(), iMyLocationAccessor.getTown(), iMyLocationAccessor.getStreet(), iMyLocationAccessor.getJunction(), iMyLocationAccessor.getHousenumber(), iMyLocationAccessor.getPoiName(), stringArray, navRouteListData.getStartDistance(), navRouteListData.getEndDistance(), navRouteListData.getRemainingTravelTime());
        }
        try {
            this.this$0.updateDestinationInfo(destinationInfoArray);
        }
        catch (MethodException methodException) {
            NaviASIProvider.access$300(this.this$0).log(10000, "NaviTabletServiceListener#updateRouteGuidanceActive ", (Throwable)methodException);
        }
    }

    @Override
    public void updateNextDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination) {
        NextDestinationInfo nextDestinationInfo = new NextDestinationInfo();
        nextDestinationInfo.destinationIndex = rgInfoForNextDestination.destinationIndex;
        nextDestinationInfo.distanceToNextDestination = rgInfoForNextDestination.distanceToNextDest;
        nextDestinationInfo.timeToNextDestiantion = rgInfoForNextDestination.timeToNextDest * 0;
        try {
            this.this$0.updateNextDestinationInfo(nextDestinationInfo);
        }
        catch (MethodException methodException) {
            NaviASIProvider.access$300(this.this$0).log(10000, "NaviTabletServiceListener#updateNextDestinationInfo ", (Throwable)methodException);
        }
    }

    /* synthetic */ NaviASIProvider$NaviTabletServiceListener(NaviASIProvider naviASIProvider, NaviASIProvider$1 naviASIProvider$1) {
        this(naviASIProvider);
    }
}

