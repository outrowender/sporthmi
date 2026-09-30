/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxOnlineResults;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import org.dsi.ifc.map.MapOverlay;

public class CtxRemoteHMIResults
extends CtxOnlineResults {
    public CtxRemoteHMIResults(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        super.enter();
        this.updateCrossHairsBoundingBox();
    }

    protected void processResultFlags(IMapRequest iMapRequest) {
        if (this.isOnlineResultListAvailable()) {
            super.processResultFlags(iMapRequest);
        } else if (this.isWeatherDataAvailable()) {
            this.processWeatherOverlays(iMapRequest);
        } else {
            this.getLogChannel().log(10000, "CtxRemoteHMIResults#processResultFlags() - OnlinePOIResultList is empty and no weather data available");
            return;
        }
    }

    private void processWeatherOverlays(IMapRequest iMapRequest) {
        this.getLogChannel().log(10000000, "CtxRemoteHMIResults#processWeatherOverlays()");
        this.naviMap.getGuiInterface().hideToolTip();
        try {
            this.getLogChannel().log(10000000, "CtxRemoteHMIResults#processWeatherOverlays(): weather data != null, length is %1", (long)this.container.weatherData.length);
            MapOverlay[] mapOverlayArray = new MapOverlay[this.container.weatherData.length];
            for (int i2 = 0; i2 < this.container.weatherData.length; ++i2) {
                mapOverlayArray[i2] = new MapOverlay();
                mapOverlayArray[i2].description = this.container.weatherData[i2].description;
                mapOverlayArray[i2].path = this.container.weatherData[i2].path;
                mapOverlayArray[i2].rectangle = this.container.weatherData[i2].rectangle;
                mapOverlayArray[i2].textFieldBoundingBox = this.getGUI().getLayout().getWeatherOverlayTimestampBoundingBox();
                this.getLogChannel().log(100000000, "CtxRemoteHMIResults#processWeatherOverlays() - weatherData[%2].description: '%1'", (Object)mapOverlayArray[i2].description, (long)i2);
            }
            this.getLogChannel().log(100000000, "CtxRemoteHMIResults#processWeatherOverlays() -- Setup Mapview");
            iMapRequest.setMapOverlays(this.container.weatherSetId, mapOverlayArray, this.container.weatherDelayInMillisBetweenImages, 1);
            iMapRequest.setViewType(0);
            iMapRequest.setMode(15);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000000, "CtxRemoteHMIResults#processWeatherOverlays() -- Exception %1", (Throwable)exception);
        }
    }

    protected void showLogo(boolean bl) {
        this.getLogChannel().log(10000000, "CtxRemoteHMIResults#showLogo( %1 )", bl);
    }

    public OnlinePOIResultList getOnlinePOIResultList() {
        return this.container.sRemoteHMIResultList;
    }

    protected void switchToFollowUpScreen() {
        this.getLogChannel().log(10000000, "CtxRemoteHMIResults#switchToFollowUpScreen() - bUserHasSelectedOnMap = %1", this.bUserHasSelectedOnMap);
        MapPin mapPin = this.getMapSelectionHandler().getSelectedPin();
        if (mapPin != null) {
            long l = mapPin.index;
            this.getLogChannel().log(10000000, "CtxRemoteHMIResults#switchToFollowUpScreen( ) - selected index = %1", l);
            try {
                if (this.bUserHasSelectedOnMap) {
                    this.getLogChannel().log(10000000, "CtxRemoteHMIResults#switchToFollowUpScreen() - call indicateSelectedMapFlag");
                    this.getMap().getNaviInterface().getNaviOnlineService().getListener().indicateSelectedMapFlag((int)l);
                }
            }
            catch (Exception exception) {
                this.getLogChannel().log(100000, "CtxRemoteHMIResults#switchToFollowUpScreen( ) - %1", (Throwable)exception);
            }
        } else {
            this.getLogChannel().log(1000000, "CtxRemoteHMIResults#switchToFollowUpScreen( ) - selected index = null");
            super.switchToFollowUpScreen();
        }
        this.bUserHasSelectedOnMap = false;
    }

    protected void requestInfoForPosition(boolean bl) {
        if (!this.isWeatherDataAvailable()) {
            super.requestInfoForPosition(bl);
        }
    }

    public void incrementGesture(int n) {
        if (!this.isWeatherDataAvailable()) {
            super.incrementGesture(n);
        }
    }

    protected boolean isSetupWeatherIconVisible() {
        if (this.isWeatherDataAvailable()) {
            return false;
        }
        return super.isSetupWeatherIconVisible();
    }

    private boolean isOnlineResultListAvailable() {
        OnlinePOIResultList onlinePOIResultList = this.getOnlinePOIResultList();
        return onlinePOIResultList != null && onlinePOIResultList.length() != 0;
    }

    private boolean isWeatherDataAvailable() {
        return this.container.weatherData != null && this.container.weatherData.length != 0;
    }
}

