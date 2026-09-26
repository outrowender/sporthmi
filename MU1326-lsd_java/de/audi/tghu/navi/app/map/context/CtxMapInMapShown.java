/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CTags$HasZoomArea;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVResponseControl;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Rect;

public class CtxMapInMapShown
extends CtxShown
implements CTags$HasZoomArea {
    private static final int MAP_IN_MAP_VIEWSIZE_WIDTH;
    private static final int MAP_IN_MAP_VIEWSIZE_HEIGHT;
    private static final MapFlag[] EMPTY_FLAGS;
    private int mapMode = 0;

    public CtxMapInMapShown(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enterPrologue() {
    }

    @Override
    public void enterEpilogue() {
    }

    @Override
    public void enter() {
        this.getLogChannel().log(-2137614336, "CtxMapInMapShown#enter() - enter");
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.viewFreeze(true);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getScreenWidthMapInMap();
        int n2 = gUIInterface.getScreenHeightMapInMap();
        iMapRequest.viewSetScreenViewport(new Rect(0, 0, n, n2));
        iMapRequest.setViewPortBorder(2);
        iMapRequest.configureFlags(1, EMPTY_FLAGS);
        iMapRequest.showTMCMessages(true);
        boolean bl = this.env.getFramework().getSysConst(488) == 1;
        iMapRequest.setTrafficMapStyle(bl);
        iMapRequest.showSpeedAndFlowCongestions(bl);
        iMapRequest.showSpeedAndFlowFreeflow(bl);
        boolean bl2 = this.calculateMapColorAccordingToSetup();
        if (bl2) {
            iMapRequest.setDayView();
        } else {
            iMapRequest.setNightView();
        }
        iMapRequest.setMode(this.mapMode);
        iMapRequest.setViewType(0);
        iMapRequest.viewSetScreenViewport(new Rect(0, 0, 293, 323));
        this.getZoomHandler().setZoomArea(new Rect(0, 0, 293, 323));
        iMapRequest.setOrientation(2);
        iMapRequest.setEnableSoftZoom(true);
        iMapRequest.setFrameRateMode(this.getSDSDialogActive() ? 2 : 1);
        iMapRequest.viewSetVisible(true);
        iMapRequest.viewFreeze(false);
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        this.check();
    }

    @Override
    public void updateViewVisible(boolean bl) {
        this.check();
    }

    private void check() {
        this.getLogChannel().log(-2137614336, "CtxMapInMapShown#check()");
        MVResponseControl mVResponseControl = this.getMap().getMVResponseControl();
        if (mVResponseControl.getViewVisible() && !mVResponseControl.getViewFreeze()) {
            this.getMap().getRouteInfoContextHandler().updateMapInMapViewVisibleAndUnfrozen(true, true);
        }
    }

    public void setMapMode(int n) {
        this.mapMode = n;
    }

    public void itemSelected(int n, int n2) {
        this.getLogChannel().log(-2137614336, "CtxMapInMapShown#itemSelected(%1, %2)", (long)n, (long)n2);
        switch (n) {
            case 400786: {
                this.naviMap.getMapManager().setMapColor(n2);
                break;
            }
            default: {
                this.getLogChannel().log(-1601830656, "CtxMapInMapShown#itemSelected() - modelID = %1 is not supported.", (long)n);
            }
        }
    }

    static {
        EMPTY_FLAGS = new MapFlag[0];
    }
}

