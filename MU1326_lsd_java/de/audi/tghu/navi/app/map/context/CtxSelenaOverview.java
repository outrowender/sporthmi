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
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.Rect;

public class CtxSelenaOverview
extends CtxFreeMap
implements CTags.HasZoomArea,
CTags.HasPosition {
    protected static final float fOrientationThresholdCHM = 100000.0f;
    protected NavSegmentID[] preparedVisibleRoutes;

    public CtxSelenaOverview(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        boolean bl = this.naviMap.getSatellitemapsManager().isSatelliteMapActive();
        boolean bl2 = this.getSetupMapType() == 2;
        Rect rect = this.getVisibleArea();
        this.getLogChannel().log(10000000, "CtxSelenaOverview#enter() - visible area : %1", (Object)rect);
        int n = rect.kordX + (rect.diffX >> 1);
        int n2 = rect.kordY + (rect.diffY >> 1);
        if (bl && bl2) {
            n2 += gUIInterface.getOffsetCrosshairHeight();
        }
        iMapRequest.setViewType(0);
        this.setVisibleArea();
        iMapRequest.setEnableSoftZoom(false);
        if (this.preparedVisibleRoutes != null) {
            this.getLogChannel().log(10000000, "CtxSelenaOverview#enter() - preparedVisibleRoute %1", (Object)this.preparedVisibleRoutes);
            iMapRequest.setMode(16);
            this.setVisibleRoutes(this.preparedVisibleRoutes);
        } else {
            this.getLogChannel().log(10000, "CtxSelenaOverview#enter() - preparedVisibleRoute is null");
            iMapRequest.setMode(2);
            iMapRequest.setLocationByLocation(this.getMapMain().getNaviInterface().getVehicle().getVehicleLocation());
        }
    }

    protected void initCtxFreeMap() {
        super.enter();
    }

    public void exit() {
        super.exit();
        this.preparedVisibleRoutes = null;
        this.getMapMain().getCtxTimeline().clearIntention();
    }

    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
    }

    public void automaticOrientateMap() {
    }

    public void keyPressed(int n, int n2) {
        this.getLogChannel().log(10000000, "CtxCrosshairMap#keyPressed( modelID = %1, keyID = %2)", (long)n, (long)n2);
        switch (n) {
            case 400450: {
                this.getLogChannel().log(1000000, "CtxCrosshairMap#keyPressed - NAV_MAP_FULLSCREEN_RETURN_BUTTON");
                this.naviMap.getGuiInterface().openOrCloseSidebar(3);
                this.naviMap.switchToAShownContext();
                break;
            }
            case 401004: {
                this.getLogChannel().log(10000000, "CtxCrosshairMap#keyPressed() - Crosshairs event");
                if (n2 == 17) {
                    this.onDDSClicked();
                    break;
                }
                if (n2 == 15) {
                    this.onHKBackClicked();
                    break;
                }
                this.getLogChannel().log(100000, "CtxCrosshairMap#keyPressed() - unknown keyID = %1", (long)n2);
                break;
            }
            default: {
                super.keyPressed(n, n2);
            }
        }
    }

    public void keyReleased(int n, int n2) {
        switch (n) {
            case 401567: 
            case 401568: 
            case 402293: {
                this.bUserHasSelectedOnMap = true;
                this.selectionModelId = n;
                this.requestInfoForPosition(true);
                break;
            }
            default: {
                super.keyReleased(n, n2);
            }
        }
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(1000000, "CtxCrosshairMap#onDDSClicked() - selection event received");
        this.bUserHasSelectedOnMap = true;
        this.getMap().getNaviInterface().getInputModeManager().setInputMode(0, this.env);
        this.joystick(401099, -1);
    }

    protected void onHKBackClicked() {
        this.getLogChannel().log(1000000, "CtxCrosshairMap#onHKBackClicked() - HK back event received");
        this.getMap().forceContext(-1);
        this.getMap().switchToAShownContext();
    }

    public void hkBackPressed() {
        this.getLogChannel().log(1000000, "CtxCrosshairMap#hkBackPressed() - HK back event received");
        this.getMap().forceContext(-1);
    }

    public void exitMapScreen() {
        this.getLogChannel().log(10000000, "CtxCrosshairMap#exitMapScreen()");
        int n = this.getCID();
        super.exitMapScreen();
        if (n == 12) {
            this.getLogChannel().log(10000000, "CtxCrosshairMap#exitMapScreen(): forceContext to (%1)", (long)n);
            this.naviMap.forceContext(n);
        }
    }

    public void viewSizeChanged(int n) {
        super.viewSizeChanged(n);
        if (n == 1) {
            this.getLogChannel().log(1000000, "CtxCrosshairMap#viewSizeChanged( ) - switch to normal map context.");
        }
        this.setVisibleArea();
    }

    public void incrementGesture(int n) {
        super.incrementGesture(n);
        this.container.fUserZoomLevel = n / 100;
        this.container.lastZoomLevelInCrossHairMode = n / 100;
    }

    protected int getMixedListOffset() {
        return 0;
    }

    protected void initFocusedProperty() {
    }

    public void setVisibleRoutes(NavSegmentID[] navSegmentIDArray) {
        this.naviMap.getMVRequest().setVisibleRoutes(navSegmentIDArray);
    }

    public Rect getVisibleArea() {
        return this.getGUI().getLayout().getVisibleArea(this.getMap().getActiveContextIndex(), false, false, this.getData().viewSize == 1);
    }

    public void prepareVisibleSelenaRoutes(NavSegmentID[] navSegmentIDArray) {
        this.preparedVisibleRoutes = navSegmentIDArray;
    }
}

