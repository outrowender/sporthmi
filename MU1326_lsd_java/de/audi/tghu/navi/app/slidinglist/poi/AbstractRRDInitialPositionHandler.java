/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.slidinglist.poi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.slidinglist.poi.RRDInitialPositionHandler;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public abstract class AbstractRRDInitialPositionHandler
implements RRDInitialPositionHandler {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    private final LogChannel logChannel;
    protected final IRouteManager routeManager;
    protected final NavigationEnv env;
    protected final IVehicle vehicle;

    public AbstractRRDInitialPositionHandler(IRouteManager iRouteManager, NavigationEnv navigationEnv, IVehicle iVehicle) {
        this.routeManager = iRouteManager;
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    @Override
    public PosPosition getInitialPosition() {
        if ((this.isStopOverVicinity() || this.isDestinationVicinity()) && this.routeManager != null && this.routeManager.getRoute() != null) {
            NavLocation navLocation;
            if (this.isDestinationVicinity()) {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "%1#getInitialPosition - calculating for destination vicinity", (Object)this.CLASS_NAME);
                }
                navLocation = RouteUtil.getFinalDestination(this.routeManager.getRoute());
            } else {
                if (this.logChannel.isDebug2()) {
                    this.logChannel.log(14808325, "%1#getInitialPosition - calculating for stop over vicinity", (Object)this.CLASS_NAME);
                }
                navLocation = RouteUtil.getFirstDestination(this.routeManager.getRoute());
            }
            PosPosition posPosition = new PosPosition();
            posPosition.latitude = navLocation.getLatitude();
            posPosition.longitude = navLocation.getLongitude();
            return posPosition;
        }
        if (this.isInNewCity()) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "%1#getInitialPosition - calculation for new city", (Object)this.CLASS_NAME);
            }
            PosPosition posPosition = this.env.getPoiSearchArea().getLocationAsPosPosition();
            if (this.env.getPoiSearchArea().getSearchContext() == 5) {
                return this.vehicle.getPosition();
            }
            if (posPosition != null) {
                return posPosition;
            }
            return this.vehicle.getPosition();
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#getInitialPosition getting vehicle position", (Object)this.CLASS_NAME);
        }
        if (this.vehicle == null) {
            this.logChannel.log(-1601830656, "%1#getInitialPosition vehicle is null, no position available, returning null", (Object)this.CLASS_NAME);
            return null;
        }
        return this.vehicle.getPosition();
    }

    protected abstract boolean isStopOverVicinity() {
    }

    protected abstract boolean isDestinationVicinity() {
    }

    protected abstract boolean isInNewCity() {
    }
}

