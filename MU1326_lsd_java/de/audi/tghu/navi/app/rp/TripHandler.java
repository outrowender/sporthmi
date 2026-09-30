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
import de.audi.tghu.navi.app.rp.TripSettingsListener;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class TripHandler
implements TimerListener {
    private LogChannel guidanceLogChannel;
    private Timer updateETATimer;
    private TripData tripData;
    private TripData tripDataVia;
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
        this.tripData = new TripData();
        this.tripDataVia = new TripData();
        this.updateETATimer = new Timer("Update ETA", 1000L, false, this);
        this.tripSettingsListener = new TripSettingsListener(navigationEnv, this, this.guidanceLogChannel);
    }

    public synchronized void cleanup() {
        this.updateETATimer.cancel();
    }

    public void updateRgActive(boolean bl) {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "TripHandler#updateRgActive( %1 )", bl);
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
    public TripData getTripDataNormal() {
        TripData tripData = this.tripData;
        synchronized (tripData) {
            return this.tripData;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TripData getTripDataVia() {
        TripData tripData = this.tripDataVia;
        synchronized (tripData) {
            return this.tripDataVia;
        }
    }

    public TripData getTripDataAuto() {
        return this.isCurrentViaRoute() ? this.getTripDataVia() : this.getTripDataNormal();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshTripData() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "TripHandler#refreshTripData()");
        }
        long l = this.env.getFramework().getKombiTime();
        TripData tripData = this.tripData;
        synchronized (tripData) {
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
                this.tripData.etaToNextDestination = l + 1000L * this.tripData.timeToNextDestination + (long)this.tripData.timeZoneOffset;
            }
            this.tripData.indexOfCurrentDestination = RouteUtil.getIndexOfCurrentDestination(this.routeManager.getFilteredRoute());
        }
        int n = this.getDistanceToFinalDestination(this.routeManager.getRoute());
        long l2 = this.getTimeToFinalDestination(this.routeManager.getRoute());
        int n2 = 0;
        this.tripData.distanceToFinalDestination = n;
        this.tripData.timeToFinalDestination = l2;
        this.tripData.timeZoneOffsetToFinalDest = n2;
        this.tripData.etaToFinalDestination = l + 1000L * l2 + (long)n2;
        this.tripDataVia.clone(this.tripData);
        if (this.isCurrentViaRoute()) {
            this.tripDataVia.timeZoneOffset = n2;
            this.tripDataVia.isTimeZoneOffset = n2 != 0;
            this.tripDataVia.distanceToNextDestination = n;
            this.tripDataVia.timeToNextDestination = l2;
            this.tripDataVia.etaToNextDestination = l + 1000L * l2 + (long)this.tripDataVia.timeZoneOffset;
        }
        this.tripDataRefreshed();
    }

    protected boolean isTripdataValid(RgInfoForNextDestination rgInfoForNextDestination) {
        return rgInfoForNextDestination.timeToNextDestStatus == 1;
    }

    private void tripDataRefreshed() {
        TripData tripData = this.getTripDataAuto();
        TripData tripData2 = this.getTripDataNormal();
        this.mapInterface.setTravelParameters(tripData.etaModeActive, tripData.etaValid, tripData2.timeToNextDestination, tripData.etaToNextDestination, tripData.distanceToNextDestination, tripData2.distanceToNextDestination, tripData2.timeToFinalDestination, tripData.etaToFinalDestination, tripData.distanceToFinalDestination, tripData2.distanceToFinalDestination, tripData.indexOfCurrentDestination);
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
        TripData tripData = this.getTripDataNormal();
        int n = RouteUtil.getRouteLength(route);
        int n2 = 0;
        if (n > 0) {
            int n3 = RouteUtil.getIndexOfCurrentDestination(route);
            n2 = tripData.distanceToNextDestination;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            for (int i2 = n3 + 1; i2 < n; ++i2) {
                if (navRouteListDataArray != null && i2 < navRouteListDataArray.length) {
                    int n4 = navRouteListDataArray[i2].getEndDistance();
                    int n5 = navRouteListDataArray[i2].getStartDistance();
                    n2 += n5 - n4;
                    continue;
                }
                this.guidanceLogChannel.log(100000, "TripHandler#getDistanceToFinalDestination() - rgDestinationInfo array too small!");
            }
        }
        return n2;
    }

    public long getTimeToFinalDestination(Route route) {
        TripData tripData = this.getTripDataNormal();
        int n = RouteUtil.getRouteLength(route);
        long l = 0L;
        if (n > 0) {
            int n2 = RouteUtil.getIndexOfCurrentDestination(route);
            l = tripData.timeToNextDestination;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            int n3 = n2 + 1;
            if (navRouteListDataArray != null && n3 < navRouteListDataArray.length) {
                l += (long)(navRouteListDataArray[n3].getRemainingTravelTime() / 1000);
            }
        }
        return l;
    }

    public int getTimeZoneOffsetToFinalDestination(Route route) {
        TripData tripData = this.getTripDataNormal();
        int n = RouteUtil.getRouteLength(route);
        int n2 = 0;
        if (n > 0) {
            int n3 = RouteUtil.getIndexOfCurrentDestination(route);
            n2 = tripData.timeZoneOffset;
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
            this.guidanceLogChannel.log(100000000, "TripHandler#startETAUpdate()");
        }
        if (!this.updateETATimer.isRunning()) {
            this.updateETATimer.start();
        }
    }

    private void resetETAUpdate() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "TripHandler#resetETAUpdate()");
        }
        if (this.updateETATimer.isRunning()) {
            this.updateETATimer.restart();
        }
    }

    private void stopETAUpdate() {
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "TripHandler#stopETAUpdate()");
        }
        if (this.updateETATimer.isRunning()) {
            this.updateETATimer.cancel();
        }
    }

    public void fireTimer(Timer timer) {
        if (timer == this.updateETATimer) {
            this.guidanceLogChannel.log(100000000, "TripHandler#fireTimer() - updateETATimer fired!");
            if (this.routeManager.isDestIndexMatching()) {
                this.refreshTripData();
            }
        }
    }

    public int getTimeMode() {
        return this.env.getChoiceModel(400800).getValue();
    }

    public void cancelTimer(Timer timer) {
    }

    public void resetSettings() {
        this.tripSettingsListener.resetSettings();
    }

    public static class TripData {
        public boolean etaModeActive = true;
        public long etaToNextDestination = 0L;
        public boolean etaValid = false;
        public long timeToNextDestination = 0L;
        public int distanceToNextDestination = 0;
        public long timeToFinalDestination = 0L;
        public long etaToFinalDestination = 0L;
        public int timeZoneOffset = 0;
        public boolean isTimeZoneOffset = false;
        public int timeZoneOffsetToFinalDest = 0;
        public boolean isTimeZoneOffsetToFinalDest = false;
        public int distanceToFinalDestination = 0;
        public int indexOfCurrentDestination = 0;

        public void clone(TripData tripData) {
            this.etaModeActive = tripData.etaModeActive;
            this.etaToNextDestination = tripData.etaToNextDestination;
            this.etaValid = tripData.etaValid;
            this.timeToNextDestination = tripData.timeToNextDestination;
            this.distanceToNextDestination = tripData.distanceToNextDestination;
            this.timeToFinalDestination = tripData.timeToFinalDestination;
            this.etaToFinalDestination = tripData.etaToFinalDestination;
            this.distanceToFinalDestination = tripData.distanceToFinalDestination;
            this.indexOfCurrentDestination = tripData.indexOfCurrentDestination;
            this.timeZoneOffset = tripData.timeZoneOffset;
            this.isTimeZoneOffset = tripData.isTimeZoneOffset;
            this.timeZoneOffsetToFinalDest = tripData.timeZoneOffsetToFinalDest;
            this.isTimeZoneOffsetToFinalDest = tripData.isTimeZoneOffsetToFinalDest;
        }

        public void clear() {
            this.etaToNextDestination = 0L;
            this.etaValid = false;
            this.timeToNextDestination = 0L;
            this.distanceToNextDestination = 0;
            this.timeToFinalDestination = 0L;
            this.etaToFinalDestination = 0L;
            this.distanceToFinalDestination = 0;
            this.indexOfCurrentDestination = 0;
            this.timeZoneOffset = 0;
            this.isTimeZoneOffset = false;
            this.timeZoneOffsetToFinalDest = 0;
            this.isTimeZoneOffsetToFinalDest = false;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("etaModeActive=").append(this.etaModeActive).append(", ");
            buffer.append("etaToNextDestination=").append(this.etaToNextDestination).append(", ");
            buffer.append("etaValid=").append(this.etaValid).append(", ");
            buffer.append("timeToNextDestination=").append(this.timeToNextDestination).append(", ");
            buffer.append("distanceToNextDestination=").append(this.distanceToNextDestination).append(", ");
            buffer.append("timeToFinalDestination=").append(this.timeToFinalDestination).append(", ");
            buffer.append("etaToFinalDestination=").append(this.etaToFinalDestination).append(", ");
            buffer.append("distanceToFinalDestination=").append(this.distanceToFinalDestination).append(", ");
            buffer.append("indexOfCurrentDestination=").append(this.indexOfCurrentDestination).append(", ");
            buffer.append("isTimeZoneOffset=").append(this.isTimeZoneOffset).append(", ");
            buffer.append("timeZoneOffset=").append(this.timeZoneOffset).append(", ");
            buffer.append("isTimeZoneOffsetToFinalDest=").append(this.isTimeZoneOffsetToFinalDest).append(", ");
            buffer.append("timeZoneOffsetToFinalDest=").append(this.timeZoneOffsetToFinalDest);
            return buffer.toString();
        }
    }
}

