/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaRouteUtil;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.rp.TripSettingsListener;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class TripHandler
implements TimerListener {
    private LogChannel guidanceLogChannel;
    private Timer updateETATimer;
    private TripHandler$TripData tripData;
    private TripHandler$TripData tripDataVia;
    private TripSettingsListener tripSettingsListener;
    private boolean rgActive;
    private final NavigationEnv env;
    private final IRouteManager routeManager;
    private int currentTimeMode;
    protected final MapInterface mapInterface;
    private final ClusterService clusterService;

    public TripHandler(NavigationEnv navigationEnv, IRouteManager iRouteManager, MapInterface mapInterface, ClusterService clusterService) {
        this.env = navigationEnv;
        this.routeManager = iRouteManager;
        this.mapInterface = mapInterface;
        this.clusterService = clusterService;
        this.guidanceLogChannel = navigationEnv.getGuidanceLogChannel();
        this.tripData = new TripHandler$TripData();
        this.tripDataVia = new TripHandler$TripData();
        this.updateETATimer = new Timer("Update ETA", 0, false, this);
        this.tripSettingsListener = new TripSettingsListener(navigationEnv, this, this.guidanceLogChannel);
    }

    public synchronized void cleanup() {
        this.updateETATimer.cancel();
    }

    public void updateRgActive(boolean bl) {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(14808325, "TripHandler#updateRgActive( %1 )", bl);
            this.rgActive = bl;
        }
        if (bl && this.tripData.etaModeActive) {
            this.startETAUpdate();
        } else {
            this.stopETAUpdate();
        }
        if (!bl) {
            this.tripData.clear();
            this.tripDataVia.clear();
            this.env.getContainer().setRgInfoForNextDestination(null);
        }
        this.tripDataRefreshed();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TripHandler$TripData getTripDataNormal() {
        TripHandler$TripData tripHandler$TripData = this.tripData;
        synchronized (tripHandler$TripData) {
            return this.tripData;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TripHandler$TripData getTripDataVia() {
        TripHandler$TripData tripHandler$TripData = this.tripDataVia;
        synchronized (tripHandler$TripData) {
            return this.tripDataVia;
        }
    }

    public TripHandler$TripData getTripDataAuto() {
        return this.isCurrentViaRoute() ? this.getTripDataVia() : this.getTripDataNormal();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshTripData() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(14808325, "TripHandler#refreshTripData()");
        }
        long l = this.env.getFramework().getKombiTime();
        TripHandler$TripData tripHandler$TripData = this.tripData;
        synchronized (tripHandler$TripData) {
            this.resetETAUpdate();
            RgInfoForNextDestination rgInfoForNextDestination = this.env.getContainer().getRgInfoForNextDestination();
            if (rgInfoForNextDestination != null) {
                this.tripData.distanceToNextDestination = (int)rgInfoForNextDestination.getDistanceToNextDest();
                this.tripData.timeToNextDestination = rgInfoForNextDestination.getTimeToNextDest();
                this.tripData.isTimeZoneOffset = false;
                this.tripData.timeZoneOffset = 0;
                if (this.tripData.timeToNextDestination == 0L && this.tripData.distanceToNextDestination > 0) {
                    this.tripData.timeToNextDestination = 1L;
                }
                this.tripData.etaValid = this.isTripdataValid(rgInfoForNextDestination);
                this.tripData.etaToNextDestination = l + 0 * this.tripData.timeToNextDestination + (long)this.tripData.timeZoneOffset;
            }
            this.tripData.indexOfCurrentDestination = RouteUtil.getIndexOfCurrentDestination(this.routeManager.getFilteredRoute());
        }
        int n = this.getDistanceToFinalDestination(this.routeManager.getRoute());
        long l2 = this.getTimeToFinalDestination(this.routeManager.getRoute());
        int n2 = 0;
        this.tripData.distanceToFinalDestination = n;
        this.tripData.timeToFinalDestination = l2;
        this.tripData.timeZoneOffsetToFinalDest = n2;
        this.tripData.etaToFinalDestination = l + 0 * l2 + (long)n2;
        this.tripDataVia.clone(this.tripData);
        if (this.isCurrentViaRoute()) {
            this.tripDataVia.timeZoneOffset = n2;
            this.tripDataVia.isTimeZoneOffset = n2 != 0;
            this.tripDataVia.distanceToNextDestination = n;
            this.tripDataVia.timeToNextDestination = l2;
            this.tripDataVia.etaToNextDestination = l + 0 * l2 + (long)this.tripDataVia.timeZoneOffset;
        }
        this.tripDataRefreshed();
    }

    protected boolean isTripdataValid(RgInfoForNextDestination rgInfoForNextDestination) {
        return rgInfoForNextDestination.timeToNextDestStatus == 1;
    }

    private void tripDataRefreshed() {
        TripHandler$TripData tripHandler$TripData = this.getTripDataAuto();
        TripHandler$TripData tripHandler$TripData2 = this.getTripDataNormal();
        this.mapInterface.setTravelParameters(tripHandler$TripData.etaModeActive, tripHandler$TripData.etaValid, tripHandler$TripData2.timeToNextDestination, tripHandler$TripData.etaToNextDestination, tripHandler$TripData.distanceToNextDestination, tripHandler$TripData2.distanceToNextDestination, tripHandler$TripData2.timeToFinalDestination, tripHandler$TripData.etaToFinalDestination, tripHandler$TripData.distanceToFinalDestination, tripHandler$TripData2.distanceToFinalDestination, tripHandler$TripData.indexOfCurrentDestination);
        this.clusterService.refreshTravelParameters(this.getTripDataAuto());
        this.routeManager.tripDataRefreshed();
    }

    private boolean isCurrentViaRoute() {
        return ViaRouteUtil.isViaRoute(this.routeManager.getRoute());
    }

    public void setTimeMode(int n) {
        if (n == 0) {
            this.currentTimeMode = 0;
            this.tripData.etaModeActive = true;
            if (this.rgActive) {
                this.startETAUpdate();
            }
        } else {
            this.currentTimeMode = 1;
            this.tripData.etaModeActive = false;
            this.stopETAUpdate();
        }
        this.tripDataRefreshed();
    }

    public void toggleTimeMode(int n) {
        if (n == 1 && this.currentTimeMode == 1) {
            this.setTimeMode(0);
        } else if (n == 0 && this.currentTimeMode == 0) {
            this.setTimeMode(1);
        }
    }

    public int getDistanceToFinalDestination(Route route) {
        TripHandler$TripData tripHandler$TripData = this.getTripDataNormal();
        int n = RouteUtil.getRouteLength(route);
        int n2 = 0;
        if (n > 0) {
            int n3 = RouteUtil.getIndexOfCurrentDestination(route);
            n2 = tripHandler$TripData.distanceToNextDestination;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            for (int i2 = n3 + 1; i2 < n; ++i2) {
                if (navRouteListDataArray != null && i2 < navRouteListDataArray.length) {
                    int n4 = navRouteListDataArray[i2].getEndDistance();
                    int n5 = navRouteListDataArray[i2].getStartDistance();
                    n2 += n5 - n4;
                    continue;
                }
                this.guidanceLogChannel.log(-1601830656, "TripHandler#getDistanceToFinalDestination() - rgDestinationInfo array too small!");
            }
        }
        return n2;
    }

    public long getTimeToFinalDestination(Route route) {
        TripHandler$TripData tripHandler$TripData = this.getTripDataNormal();
        int n = RouteUtil.getRouteLength(route);
        long l = 0L;
        if (n > 0) {
            int n2 = RouteUtil.getIndexOfCurrentDestination(route);
            l = tripHandler$TripData.timeToNextDestination;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            int n3 = n2 + 1;
            if (navRouteListDataArray != null && n3 < navRouteListDataArray.length) {
                l += (long)(navRouteListDataArray[n3].getRemainingTravelTime() / 1000);
            }
        }
        return l;
    }

    public int getTimeZoneOffsetToFinalDestination(Route route) {
        TripHandler$TripData tripHandler$TripData = this.getTripDataNormal();
        int n = RouteUtil.getRouteLength(route);
        int n2 = 0;
        if (n > 0) {
            int n3 = RouteUtil.getIndexOfCurrentDestination(route);
            n2 = tripHandler$TripData.timeZoneOffset;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            int n4 = n3 + 1;
            if (navRouteListDataArray != null && n4 < navRouteListDataArray.length) {
                n2 += navRouteListDataArray[n4].getTimeLagToNextDest();
            }
        }
        return n2;
    }

    private void startETAUpdate() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(14808325, "TripHandler#startETAUpdate()");
        }
        if (!this.updateETATimer.isRunning()) {
            this.updateETATimer.start();
        }
    }

    private void resetETAUpdate() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(14808325, "TripHandler#resetETAUpdate()");
        }
        if (this.updateETATimer.isRunning()) {
            this.updateETATimer.restart();
        }
    }

    private void stopETAUpdate() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(14808325, "TripHandler#stopETAUpdate()");
        }
        if (this.updateETATimer.isRunning()) {
            this.updateETATimer.cancel();
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer == this.updateETATimer) {
            this.guidanceLogChannel.log(14808325, "TripHandler#fireTimer() - updateETATimer fired!");
            if (this.routeManager.isDestIndexMatching()) {
                this.refreshTripData();
            }
        }
    }

    public int getTimeMode() {
        return this.env.getChoiceModel(-1608710656).getValue();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    public void resetSettings() {
        this.tripSettingsListener.resetSettings();
    }
}

