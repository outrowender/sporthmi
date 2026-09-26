/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.context.CTags$HasDefaultZoom;
import de.audi.tghu.navi.app.map.context.CtxShown;
import org.dsi.ifc.map.Rect;

public class CtxDestinationMap
extends CtxShown
implements CTags$HasDefaultZoom {
    public CtxDestinationMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        super.enter();
        Rect rect = this.getVisibleArea();
        int n = rect.kordX + (rect.diffX >> 1);
        int n2 = rect.kordY + (rect.diffY >> 1);
        this.setHotPoint(n, n2);
        this.naviMap.getMVRequest().setViewType(0);
        this.naviMap.getMVRequest().setRotation((short)0);
        this.naviMap.getMVRequest().setOrientation(2);
        this.refreshCarPositionForZoomEngine();
    }

    @Override
    public void stopoverHasBeenPassed() {
        super.stopoverHasBeenPassed();
        this.setMapPosition();
    }

    @Override
    public void initAdditionalInfos() {
        super.initAdditionalInfos();
        this.setMapPosition();
    }

    @Override
    public void updateManoeuvreViewActive(int n) {
        super.updateManoeuvreViewActive(n);
        this.getLogChannel().log(-2137614336, "CtxDestinationMap#updateManoeuvreViewActive( %1 )", (long)n);
        this.setMapPosition();
    }

    @Override
    public void updateZoomEngineState(int n) {
        super.updateZoomEngineState(n);
        int n2 = this.getSetupAutoZoom();
        this.getLogChannel().log(-2137614336, "CtxDestinationMap#updateZoomEngineState - setupAutoZoom = %1", (long)n2);
        if (n2 == 1 || n2 == 0) {
            this.getLogChannel().log(14808325, "CtxDestinationMap#updateZoomEngineState - zoomEngineState = %1", (long)n);
            if (n == 3) {
                this.container.sManoeuvreZoomDisabledWithReturn = false;
            }
        }
    }

    @Override
    public void updateRecommendedZoom(float f2) {
        super.updateRecommendedZoom(f2);
        int n = this.getSetupAutoZoom();
        this.getLogChannel().log(-2137614336, "CtxDestinationMap#updateRecommendedZoom - setupAutoZoom = %1", (long)n);
        if (n == 1 || n == 0) {
            int n2 = this.getZoomEngineState();
            this.getLogChannel().log(14808325, "CtxDestinationMap#updateRecommendedZoom - zoomEngineState = %1", (long)n2);
            if (!this.container.sManoeuvreZoomDisabledWithReturn && n2 == 3) {
                AbstractMap abstractMap = this.naviMap;
                abstractMap.switchToContext(8);
                abstractMap.setSwitchBackToContext(11);
            }
        }
    }

    protected void setMapPosition() {
        int n;
        INaviInterface iNaviInterface = this.naviMap.getNaviInterface();
        int n2 = iNaviInterface.getIndexOfCurrentDestination();
        int n3 = iNaviInterface.getRouteListLength();
        this.getLogChannel().log(-2137614336, "CtxDestinationMap#setMapPosition(): currentDestIndex=%1, routeLength=%2", (long)n2, (long)n3);
        if (this.getRGActive()) {
            if (n3 == 1 || n2 == n3 - 1) {
                n = 1;
            } else if (n3 > 1) {
                n = 2;
            } else {
                n = 0;
                n2 = -1;
            }
        } else {
            n = 0;
            n2 = -1;
        }
        this.getLogChannel().log(1078071040, "CtxDestinationMap#setMapPosition(): locationType=%1, stopoverNumber=%2", (long)n, (long)n2);
        this.setVisibleArea();
        this.naviMap.getMVRequest().setLocation(n, n2);
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.setMapPosition();
    }

    @Override
    public boolean supportsAdditionalInfo() {
        return true;
    }

    @Override
    public float getDefaultZoomLevel() {
        return 51267;
    }

    @Override
    protected void onDDSClicked() {
        this.getLogChannel().log(-2137614336, "CtxDestinationMap#onDDSClicked()");
        this.getMap().setSwitchBackToContext(11);
        this.getMap().switchToContext(12);
    }
}

