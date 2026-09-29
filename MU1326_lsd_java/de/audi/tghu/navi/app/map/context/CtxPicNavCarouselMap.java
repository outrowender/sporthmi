/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CTags$HasDefaultZoom;
import de.audi.tghu.navi.app.map.context.CTags$HasZoomArea;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;

public class CtxPicNavCarouselMap
extends CtxFreeMap
implements CTags$HasDefaultZoom,
CTags$HasZoomArea {
    public static int CAROUSEL_MAP_WIDTH = 401;
    public static int CAROUSEL_MAP_HEIGHT = 255;

    public CtxPicNavCarouselMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        super.enter();
        this.backupPOIVisibilityAndHideAllPOIs();
        this.naviMap.getMVRequest().setPictureNavigationIconVisibility(false, -1);
        this.shutdownAdditionalInfos();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.setViewType(0);
        iMapRequest.setMode(2);
        iMapRequest.setRotation((short)0);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = CAROUSEL_MAP_WIDTH >> 1;
        int n2 = CAROUSEL_MAP_HEIGHT >> 1;
        this.setHotPoint(n, n2);
        this.getZoomHandler().setZoomArea(new Rect(0, 0, CAROUSEL_MAP_WIDTH, CAROUSEL_MAP_HEIGHT));
        this.getZoomHandler().setZoomLevel(this.getDefaultZoomLevel());
        NavLocationWgs84 navLocationWgs84 = this.naviMap.getMapDataContainer().sPicNavCarouselMapPosition;
        if (navLocationWgs84 != null) {
            iMapRequest.setMapPosition(navLocationWgs84);
        } else {
            this.getLogChannel().log(10000, "CtxPicNavCarouselMap#enter(): mapPosition is null!");
        }
    }

    @Override
    public void exit() {
        super.exit();
        this.naviMap.getMVRequest().setPictureNavigationIconVisibility(false, -1);
        this.freezeMap();
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n != 1058801152) {
            super.itemSelected(n, n2, n3, n4);
        }
    }

    @Override
    public void updateZoomListIndex(int n) {
    }

    @Override
    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
        super.updateZoomList(fArray, n, fArray2);
        this.getZoomHandler().setZoomLevel(this.getDefaultZoomLevel());
    }

    @Override
    public void updateMapOrientation(int n) {
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    @Override
    public void updateInfoForPosition(PosInfo[] posInfoArray) {
    }

    @Override
    public float getDefaultZoomLevel() {
        return 51267;
    }

    @Override
    public MapPin[] getDynamicPins() {
        NavLocationWgs84 navLocationWgs84 = this.getData().sPicNavCarouselMapPosition;
        if (navLocationWgs84 != null) {
            MapPin mapPin = new MapPin(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude(), 35, 8);
            return new MapPin[]{mapPin};
        }
        return new MapPin[0];
    }
}

