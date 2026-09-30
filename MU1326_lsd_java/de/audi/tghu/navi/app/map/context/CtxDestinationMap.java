/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.context.CTags;
import de.audi.tghu.navi.app.map.context.CtxShown;
import org.dsi.ifc.map.Rect;

public class CtxDestinationMap
extends CtxShown
implements CTags.HasDefaultZoom {
    public CtxDestinationMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

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

    public void stopoverHasBeenPassed() {
        super.stopoverHasBeenPassed();
        this.setMapPosition();
    }

    public void initAdditionalInfos() {
        super.initAdditionalInfos();
        this.setMapPosition();
    }

    public void updateManoeuvreViewActive(int n) {
        super.updateManoeuvreViewActive(n);
        this.getLogChannel().log(10000000, "CtxDestinationMap#updateManoeuvreViewActive( %1 )", (long)n);
        this.setMapPosition();
    }

    public void updateZoomEngineState(int n) {
        super.updateZoomEngineState(n);
        int n2 = this.getSetupAutoZoom();
        this.getLogChannel().log(10000000, "CtxDestinationMap#updateZoomEngineState - setupAutoZoom = %1", (long)n2);
        if (n2 == 1 || n2 == 0) {
            this.getLogChannel().log(100000000, "CtxDestinationMap#updateZoomEngineState - zoomEngineState = %1", (long)n);
            if (n == 3) {
                this.container.sManoeuvreZoomDisabledWithReturn = false;
            }
        }
    }

    public void updateRecommendedZoom(float f2) {
        super.updateRecommendedZoom(f2);
        int n = this.getSetupAutoZoom();
        this.getLogChannel().log(10000000, "CtxDestinationMap#updateRecommendedZoom - setupAutoZoom = %1", (long)n);
        if (n == 1 || n == 0) {
            int n2 = this.getZoomEngineState();
            this.getLogChannel().log(100000000, "CtxDestinationMap#updateRecommendedZoom - zoomEngineState = %1", (long)n2);
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
        this.getLogChannel().log(10000000, "CtxDestinationMap#setMapPosition(): currentDestIndex=%1, routeLength=%2", (long)n2, (long)n3);
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
        this.getLogChannel().log(1000000, "CtxDestinationMap#setMapPosition(): locationType=%1, stopoverNumber=%2", (long)n, (long)n2);
        this.setVisibleArea();
        this.naviMap.getMVRequest().setLocation(n, n2);
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.setMapPosition();
    }

    public boolean supportsAdditionalInfo() {
        return true;
    }

    public float getDefaultZoomLevel() {
        return 400.0f;
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(10000000, "CtxDestinationMap#onDDSClicked()");
        this.getMap().setSwitchBackToContext(11);
        this.getMap().switchToContext(12);
    }
}

