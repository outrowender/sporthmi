/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxTMCMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class CtxPicNavMap
extends CtxTMCMap {
    private static final float DEFAULT_ZOOM_LEVEL;

    public CtxPicNavMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        this.getLogChannel().log(1078071040, "CtxPicNavMap#enter()");
        super.enter();
        this.showPicNavDestination(false);
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.showTMCMessages(false);
        iMapRequest.setCityModelMode(0);
        iMapRequest.setLandmarksVisible(false);
        iMapRequest.setBrandIconStyle(new int[]{-1}, 1);
        this.setPictureNavigationIconVisibility();
        this.backupPOIVisibilityAndHideAllPOIs();
    }

    @Override
    public void enterEpilogue() {
        this.showMap(true);
        this.unfreezeMap();
    }

    @Override
    public void exit() {
        this.getLogChannel().log(1078071040, "CtxPicNavMap#exit()");
        super.exit();
    }

    @Override
    public NavLocation getEnterInMapLocation() {
        return this.container.sPicNavMapLocation;
    }

    protected void setPicNavMapTooltipString(String string) {
        this.container.sPicNavMapTooltipString = string;
    }

    protected String getPicNavMapTooltipString() {
        return this.container.sPicNavMapTooltipString;
    }

    protected boolean isPicNavMapShowPicNavIcons() {
        return this.container.sPicNavMapShowPicNavIcons;
    }

    protected int getPicNavMapFilterId() {
        return this.container.sPicNavMapFilterId;
    }

    protected ResourceLocator getPicNavMapTooltipLocator() {
        return this.container.sPicNavMapTooltipLocator;
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
        if (!bl) {
            ResourceLocator resourceLocator = this.getPicNavMapTooltipLocator();
            String string = this.getPicNavMapTooltipString();
            float f2 = this.getZoomHandler().getZoom();
            if (resourceLocator != null && !Util.isEmpty(string) && f2 <= 5292871) {
                this.getLogChannel().log(-2137614336, "CtxPicNavMap#updateViewFreeze(): requesting delayed ToolTip %1", (Object)string);
                this.showToolTipAfterTimeout(string, this.getCrosshairHotPointX(), this.getCrosshairHotPointY(), null, null, false, true, resourceLocator);
            } else {
                this.getLogChannel().log(-2137614336, "CtxPicNavMap#updateViewFreeze(): hiding ToolTip, zoomIndex: %1", (Object)Float.toString(f2));
                this.hideToolTip();
            }
        }
    }

    void tmcToolTipHandling(int n) {
        boolean bl = this.naviMap.getMVResponseControl().getViewFreeze();
        ResourceLocator resourceLocator = this.getPicNavMapTooltipLocator();
        String string = this.getPicNavMapTooltipString();
        if (resourceLocator != null && !Util.isEmpty(string) && !bl && n <= this.retrieveZoomListIndex(5292871)) {
            this.getLogChannel().log(-2137614336, "CtxPicNavMap#tmcToolTipHandling(): requesting ToolTip %1", (Object)string);
            this.naviMap.getMapTooltip().showToolTip(string, this.getCrosshairHotPointX(), this.getCrosshairHotPointY(), null, null, false, true, resourceLocator);
        } else {
            this.getLogChannel().log(-2137614336, "CtxPicNavMap#tmcToolTipHandling(): hiding ToolTip, mapFrozen: %1, zoomIndex: %2", bl, (long)n);
            this.hideToolTip();
        }
    }

    private void resolvePicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
        this.getLogChannel().log(1078071040, "CtxPicNavMap#resolvePicNavLocation() - picNavLocation: %1, picNavLocator: %2", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)resourceLocator);
        this.setPicNavMapTooltipString(null);
        if (navLocation != null && resourceLocator != null) {
            if (navLocation.isPositionValid()) {
                this.naviMap.getMapTooltip().resolvePicNavLocation(navLocation.getLongitude(), navLocation.getLatitude(), resourceLocator);
                return;
            }
            this.getLogChannel().log(10000, "CtxPicNavMap#resolvePicNavLocation() - did not find valid location for address resolution!");
            return;
        }
        this.getLogChannel().log(-1601830656, "CtxPicNavMap#resolvePicNavLocation() - picNavLocation or picNavLocator is null!");
    }

    @Override
    public void updatePicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
        this.getLogChannel().log(1078071040, "CtxPicNavMap#updatePicNavLocation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        String string = this.naviMap.getTooltipFormatter().formatPicNavLocation(navLocation);
        if (Util.isEmpty(string)) {
            this.getLogChannel().log(-1601830656, "CtxPicNavMap#updatePicNavLocation() - failed to retrieve tooltip string, showing only the picture!");
            string = "";
        }
        this.setPicNavMapTooltipLocator(resourceLocator);
        this.setPicNavMapTooltipString(string);
        this.showToolTipAfterTimeout(string, this.getCrosshairHotPointX(), this.getCrosshairHotPointY(), null, null, false, true, resourceLocator);
    }

    private void showPicNavDestination(boolean bl) {
        this.getLogChannel().log(1078071040, "CtxPicNavMap#showPicNavDestination()");
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        NavLocation navLocation = this.getEnterInMapLocation();
        if (navLocation != null) {
            this.hideToolTip();
            this.resolvePicNavLocation(navLocation, this.getPicNavMapTooltipLocator());
            this.getZoomHandler().setZoomLevel(51267);
            this.getLogChannel().log(-2137614336, "CtxPicNavMap#showPicNavDestination() - setLocationByLocation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
            iMapRequest.setLocationByLocation(navLocation);
        } else {
            this.getLogChannel().log(-1601830656, "CtxPicNavMap#showPicNavDestination() - location not set!");
        }
        if (bl) {
            this.setPictureNavigationIconVisibility();
        }
    }

    private void setPictureNavigationIconVisibility() {
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        if (this.isPicNavMapShowPicNavIcons()) {
            iMapRequest.setPictureNavigationIconVisibility(true, this.getPicNavMapFilterId());
        } else {
            iMapRequest.setPictureNavigationIconVisibility(false, -1);
        }
    }

    @Override
    public void setPicNavMapLocation(NavLocation navLocation, boolean bl, int n, ResourceLocator resourceLocator) {
        super.setPicNavMapLocation(navLocation, bl, n, resourceLocator);
        this.getLogChannel().log(1078071040, "CtxPicNavMap#setPicNavMapLocation()");
        this.freezeMap();
        this.showPicNavDestination(true);
        this.getMapFlagHandler().refresh(true);
        this.unfreezeMap();
    }

    public void showMapInMapPictureDest(boolean bl, int n, int n2) {
    }

    public void showMapInMapPictureDest(int n, int n2) {
        this.getLogChannel().log(1078071040, "Context#showPictureDestForMapInMap() - longitude: %1, latitude: %2", (long)n, (long)n2);
        this.notifyMapInMapPictureDestOn(n, n2);
    }

    public void hideMapInMapPictureDest() {
        this.getLogChannel().log(-2137614336, "Context#hideMapInMapPictureDest()");
        this.notifyMapInMapPictureDestOff();
    }

    void notifyMapInMapPictureDestOn(int n, int n2) {
    }

    void notifyMapInMapPictureDestOff() {
    }

    @Override
    public MapPin[] getDynamicPins() {
        NavLocation navLocation = this.getEnterInMapLocation();
        if (navLocation != null) {
            MapPin mapPin = new MapPin(navLocation.getLongitude(), navLocation.getLatitude(), 35, 8);
            return new MapPin[]{mapPin};
        }
        return new MapPin[0];
    }
}

