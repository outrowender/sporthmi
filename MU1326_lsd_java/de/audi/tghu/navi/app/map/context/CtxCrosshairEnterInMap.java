/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CTags;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.PinList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Rect;

public class CtxCrosshairEnterInMap
extends CtxFreeMap
implements CTags.HasDefaultZoom,
CTags.HasZoomArea {
    private static final float DEFAULT_ZOOM_LEVEL = 400.0f;
    private static final float DEFAULT_ASIA_ZOOM_LEVEL = 100.0f;
    private NavLocationWgs84 backupMapPosition = null;
    private float backupZoomLevel = -1.0f;
    protected int hotPointX;
    protected int hotPointY;

    public CtxCrosshairEnterInMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#updateMapPosition(%1)", (Object)navLocationWgs84);
        super.updateMapPosition(navLocationWgs84);
        this.backupMapPosition = navLocationWgs84;
    }

    public void enter() {
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        this.setVisibleAreaInTheMiddleOfTheScreen();
        this.setHotPointAndCrosshairInTheMiddleOfTheScreen();
        this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap.enter   w = %1, h = %2", (long)this.hotPointX, (long)this.hotPointY);
        if (Util.isHURegionAsia()) {
            if (Util.isHMIScrollHairsEnabled(this.env.getFramework()) || Util.isLockFeatureNavMapviewScrollEnabled(this.env)) {
                iMapRequest.setMode(2);
            } else {
                iMapRequest.setMode(3);
            }
            this.updateCrossHairsBoundingBox();
        }
        this.setLocationForContext();
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
        super.enter();
        if (!this.container.sEnterInMapHidePois) {
            iMapRequest.ensurePoiVisibility(new NavLocation[]{this.getEnterInMapLocation()});
        } else {
            this.backupPOIVisibilityAndHideAllPOIs();
        }
        this.shutdownAdditionalInfos();
        this.getViews().getMainMapView().setOptionIconVisible(false);
    }

    protected void calculateHotPointInTheMiddleOfTheScreen() {
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getScreenWidth();
        int n2 = gUIInterface.getScreenHeight();
        this.hotPointX = n >> 1;
        this.hotPointY = n2 >> 1;
    }

    protected void setHotPointAndCrosshairInTheMiddleOfTheScreen() {
        this.calculateHotPointInTheMiddleOfTheScreen();
        this.getLogChannel().log(10000000, "CtxCrosshairMapPCore#setHotPointAndCrosshairInTheMiddleOfTheScreen() - hotPoint-x=%1 hotPoint-y=%2", (long)this.hotPointX, (long)this.hotPointY);
        this.setHotPoint(this.hotPointX, this.hotPointY);
    }

    protected void setVisibleAreaInTheMiddleOfTheScreen() {
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getMapWidth();
        int n2 = gUIInterface.getMapHeight();
        this.getZoomHandler().setZoomArea(new Rect(0, 0, n, n2));
    }

    protected void setLocationForContext() {
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        NavLocation navLocation = this.getEnterInMapLocation();
        if (navLocation != null && this.isForceUseEnterInMapLocation()) {
            this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#enter() - setLocationByLocation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
            if (this.isForceUseEnterInMapRestoreZoom() && this.backupZoomLevel != -1.0f) {
                this.initZoomLevel(this.backupZoomLevel);
            } else {
                this.getZoomHandler().setZoomLevel(this.getDefaultZoomLevel());
            }
            iMapRequest.setLocationByLocation(navLocation);
            this.backupMapPosition = Util.navLocationToWgs84(navLocation);
            this.setForceUseEnterInMapLocation(false, false);
        } else if (this.backupMapPosition != null) {
            this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#enter() - backup map position( %1 ), backup zoom index( %2 )", (Object)this.backupMapPosition, (Object)Float.toString(this.backupZoomLevel));
            this.initZoomLevel(this.backupZoomLevel);
            iMapRequest.setMapPosition(this.backupMapPosition);
        } else {
            this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#enter() - neither location nor backup map position set!");
        }
    }

    public void exit() {
        super.exit();
        this.naviMap.getMVRequest().ensurePoiVisibility(null);
        this.backupZoomLevel = this.getZoomHandler().getZoom();
        if (this.backupZoomLevel > 0.0f) {
            this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#exit() - backupZoomLevel fetched.");
        } else {
            this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#exit() - backupZoomLevel not available!");
        }
        this.naviMap.getGuiInterface().setTopBarVisible(false);
        this.getViews().getMainMapView().setOptionIconVisible(true);
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
    }

    private void initZoomLevel(float f2) {
        this.getLogChannel().log(10000000, "CtxCrosshairEnterInMap#initZoomLevel( %1 )", (Object)Float.toString(f2));
        this.getZoomHandler().setZoomLevel(f2);
    }

    public float getDefaultZoomLevel() {
        return Util.isHURegionAsia() ? 100.0f : 400.0f;
    }

    protected void onDDSClicked() {
        boolean bl = !Util.isLockFeatureNavMapviewScrollEnabled(this.env) || !this.getMap().getNaviInterface().isFeatureToBeLocked() || Util.isHMIScrollHairsEnabled(this.env.getFramework());
        this.getLogChannel().log(1000000, "CtxCrosshairEnterInMap#onDDSClicked() - ddsClickAllowed: %1", bl);
        if (bl) {
            this.bUserHasSelectedOnMap = true;
            this.joystick(401099, -1);
        }
    }

    protected void onHKBackClicked() {
        this.getLogChannel().log(1000000, "CtxCrosshairEnterInMap#onHKBackClicked()");
        this.getGUI().fireHKBackEvent();
    }

    protected void refreshPins() {
        MapPin mapPin;
        this.getLogChannel().log(100000000, "CtxCrosshairEnterInMap#refreshPins()");
        super.refreshPins();
        PinList pinList = new PinList();
        if (this.backupMapPosition != null && this.container.sEnterInMapShowPin) {
            mapPin = new MapPin(this.backupMapPosition.getLongitude(), this.backupMapPosition.getLatitude(), 28, 10);
            pinList.add(mapPin);
        }
        if (this.container.sEnterInMapFavorite != null && !this.getMap().getSetup().isFavoriteVisible(0)) {
            mapPin = new MapPin(this.container.sEnterInMapFavorite.getLongitude(), this.container.sEnterInMapFavorite.getLatitude(), MapUtils.getStyleIndexForFavorite(), (int)this.container.sEnterInMapFavorite.getUniqueID(), 0);
            pinList.add(mapPin);
        }
        if (!pinList.isEmpty()) {
            this.getMapFlagHandler().setTemporaryPins(pinList.toArray());
        }
    }

    public void viewSizeChanged(int n) {
        super.viewSizeChanged(n);
        if (n == 1) {
            this.getLogChannel().log(1000000, "CtxCrosshairMap#viewSizeChanged( ) - switch to normal map context.");
        }
        this.onHKBackClicked();
    }
}

