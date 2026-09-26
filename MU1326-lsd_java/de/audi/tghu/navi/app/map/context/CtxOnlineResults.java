/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CTags$HasZoomArea;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.handler.MapFlagUtils;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;

public class CtxOnlineResults
extends CtxFreeMap
implements CTags$HasZoomArea {
    public CtxOnlineResults(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#enter()");
        this.doEnter();
    }

    private void doEnter() {
        this.getGUI().switchMapScreen(4);
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.setViewType(0);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        Rect rect = this.getVisibleArea();
        this.getZoomHandler().setZoomArea(rect);
        int n = gUIInterface.getScreenWidth() >> 1;
        int n2 = gUIInterface.getScreenHeight() >> 1;
        this.setHotPoint(n, n2);
        if (Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            gUIInterface.showCrosshairs(n, n2);
        }
        this.updateCrosshairsColor();
        if (Util.isHMIScrollHairsEnabled(this.env.getFramework()) || Util.isLockFeatureNavMapviewScrollEnabled(this.env)) {
            iMapRequest.setMode(2);
        } else {
            iMapRequest.setMode(3);
        }
        NavLocation navLocation = this.getEnterInMapLocation();
        if (navLocation != null && this.isForceUseEnterInMapLocation()) {
            this.getLogChannel().log(-2137614336, "CtxOnlineResults#enter() - setLocationByLocation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
            iMapRequest.setLocationByLocation(navLocation);
            this.setForceUseEnterInMapLocation(false, false);
        } else {
            this.processResultFlags(iMapRequest);
        }
        this.callCtxFreeMapEnter();
        iMapRequest.setOrientation(2);
        this.backupPOIVisibilityAndHideAllPOIs();
        this.enableDisableOrientation();
        gUIInterface.switchToNormalSidebar();
        this.shutdownAdditionalInfos();
        if (!Util.isLockFeatureNavMapviewScrollEnabled(this.env) || Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            gUIInterface.setTopBarVisible(true);
        }
        this.showLogo(true);
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
    }

    @Override
    public Rect getVisibleArea() {
        if (Util.isClusterMMI(this.env.getFramework())) {
            return this.getGUI().getLayout().getVisibleArea(this.getCID(), false, false, this.getData().viewSize == 1);
        }
        return this.getGUI().getLayout().getVisibleArea(this.getCID(), false, false);
    }

    protected void callCtxFreeMapEnter() {
        super.enter();
    }

    protected void processResultFlags(IMapRequest iMapRequest) {
        OnlinePOIResultList onlinePOIResultList = this.getOnlinePOIResultList();
        if (onlinePOIResultList == null || onlinePOIResultList.length() == 0) {
            this.getLogChannel().log(-1601830656, "CtxOnlineResults#processResultFlags() - OnlinePOIResultList is empty");
            return;
        }
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#processResultFlags()");
        this.calculateLocationRectangle(onlinePOIResultList);
        iMapRequest.setMapViewPortByWGS84Rectangle(this.container.focusRectangle, this.retrieveZoomListIndex(51266));
        NavLocationWgs84 navLocationWgs84 = onlinePOIResultList.getForcedLocation();
        if (navLocationWgs84 != null) {
            iMapRequest.setMapPosition(navLocationWgs84);
        }
    }

    @Override
    public void exit() {
        super.exit();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.setTopBarVisible(false);
        gUIInterface.hideCrosshairs();
        this.showLogo(false);
        this.container.sOldLocationAfterTMCMap = this.getMapPosition();
        this.container.sSavedZoomIndexAfterTMCMap = this.getSavedZoomListIndex();
        this.container.sSavedRotationAfterTMCMap = this.getMapRotation();
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#exit(): saved position = %1, zoom = %2, rotation = %3", (Object)this.container.sOldLocationAfterTMCMap, (long)this.container.sSavedZoomIndexAfterTMCMap, (long)this.container.sSavedRotationAfterTMCMap);
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
    }

    protected void calculateLocationRectangle(OnlinePOIResultList onlinePOIResultList) {
        int n;
        int n2 = -129;
        int n3 = -129;
        int n4 = 128;
        int n5 = 128;
        if (onlinePOIResultList != null) {
            NavLocation navLocation = onlinePOIResultList.getSearchContext();
            this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle() - handle searchContext: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
            n = onlinePOIResultList.length();
            this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): looking in %1 OnlineResults flags", (long)n);
            for (int i2 = 0; i2 < n; ++i2) {
                if (onlinePOIResultList.getPOIElementAt((int)i2).longitude < n2) {
                    n2 = onlinePOIResultList.getPOIElementAt((int)i2).longitude;
                }
                if (onlinePOIResultList.getPOIElementAt((int)i2).latitude < n3) {
                    n3 = onlinePOIResultList.getPOIElementAt((int)i2).latitude;
                }
                if (onlinePOIResultList.getPOIElementAt((int)i2).longitude > n4) {
                    n4 = onlinePOIResultList.getPOIElementAt((int)i2).longitude;
                }
                if (onlinePOIResultList.getPOIElementAt((int)i2).latitude <= n5) continue;
                n5 = onlinePOIResultList.getPOIElementAt((int)i2).latitude;
            }
            if (n == 0 && navLocation != null) {
                n2 = navLocation.getLongitude();
                n4 = navLocation.getLongitude();
                n3 = navLocation.getLatitude();
                n5 = navLocation.getLatitude();
            }
        }
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): smallest location: %1/%2", (long)n2, (long)n3);
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): largest location: %1/%2", (long)n4, (long)n5);
        if (n4 - n2 > -221185761) {
            n = n2 + (n4 - n2 >> 1);
            n2 = n - 2045312015;
            n4 = n + 2045312015;
            this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): shrinking span (longitues): %1/%2", (long)n2, (long)n4);
        }
        if (n5 - n3 > -221185761) {
            n = n3 + (n5 - n3 >> 1);
            n3 = n - 2045312015;
            n5 = n + 2045312015;
            this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): shrinking span (latitudes): %1/%2", (long)n3, (long)n5);
        }
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): setting min locations %1/%2", (long)n3, (long)n2);
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): setting max locations %1/%2", (long)n5, (long)n4);
        this.container.focusRectangle = new NavRectangle(n2, n4, n3, n5, false);
        NavLocationWgs84 navLocationWgs84 = onlinePOIResultList.getForcedLocation();
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle() - center: %1", (Object)navLocationWgs84);
        if (navLocationWgs84 != null) {
            this.container.focusRectangle = Util.extendNavRectangleToCenterOnPoint(this.container.focusRectangle, navLocationWgs84);
        }
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#calculateLocationRectangle(): rectangle: %1", (Object)this.container.focusRectangle);
    }

    protected void showLogo(boolean bl) {
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#showLogo( %1 )", bl);
        this.naviMap.getGuiInterface().setOnlineLogoVisible(bl);
    }

    @Override
    public MapPin[] getDynamicPins() {
        MapPin[] mapPinArray = MapFlagUtils.convertResultListToMapPins(this.getOnlinePOIResultList());
        if (mapPinArray != null) {
            for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                this.getLogChannel().log(-2137614336, "CtxOnlineResults#getDynamicPins()[%2]: %1", (Object)mapPinArray[i2], (long)i2);
            }
            return mapPinArray;
        }
        return new MapPin[0];
    }

    @Override
    public OnlinePOIResultList getOnlinePOIResultList() {
        return this.container.sOnlinePOIResultList;
    }

    @Override
    protected void onDDSClicked() {
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#onDDSClicked()");
        this.bUserHasSelectedOnMap = true;
        this.joystick(-887224832, -1);
    }

    @Override
    protected void onHKBackClicked() {
        this.getLogChannel().log(-2137614336, "CtxOnlineResults#onHKBackClicked()");
        this.getGUI().fireHKBackEvent();
    }

    @Override
    public void viewSizeChanged(int n) {
        super.viewSizeChanged(n);
        if (n == 1) {
            this.naviMap.getGuiInterface().hideToolTip();
        }
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
        if (this.naviMap.getNaviInterface().getViewSizeChangeHandler().isSmallStageActive()) {
            this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
        }
        super.touchPadPositionMoved(n, n2, n3, n4, n5);
    }
}

