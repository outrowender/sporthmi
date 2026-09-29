/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CTags$HasPosition;
import de.audi.tghu.navi.app.map.context.CTags$HasZoomArea;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Rect;

public class CtxCrosshairMap
extends CtxFreeMap
implements CTags$HasZoomArea,
CTags$HasPosition {
    protected static final float fOrientationThresholdCHM;

    public CtxCrosshairMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        boolean bl;
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        boolean bl2 = this.naviMap.getSatellitemapsManager().isSatelliteMapActive();
        boolean bl3 = this.getSetupMapType() == 2;
        Rect rect = this.getVisibleArea();
        this.getLogChannel().log(-2137614336, "CtxCrosshairMap#enter() - visible area : %1", (Object)rect);
        int n = rect.kordX + (rect.diffX >> 1);
        int n2 = rect.kordY + (rect.diffY >> 1);
        int n3 = this.naviMap.getOldActiveContextIndex();
        if (n3 == 10) {
            iMapRequest.setMode(2);
        }
        this.setHotPoint(n, n2);
        if (Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            gUIInterface.showCrosshairs(n, n2);
        }
        this.updateCrosshairsColor();
        boolean bl4 = bl = !Util.isLockFeatureNavMapviewScrollEnabled(this.env) || !this.getMap().getNaviInterface().isFeatureToBeLocked();
        if (!Util.isHMIScrollHairsEnabled(this.env.getFramework()) && bl) {
            iMapRequest.setMode(3);
        } else if (n3 != 10) {
            iMapRequest.setMode(2);
        }
        if (Util.isHURegionAsia()) {
            iMapRequest.stopScrollToDirection();
        }
        iMapRequest.setViewType(0);
        this.initCtxFreeMap();
        this.activateOrientationAccordingToSetup();
        if (this.getMap().getLastVisibleCID() == 30 && this.getData().sFocusedPosition != null) {
            iMapRequest.setRotation(this.getData().sFocusedRotation);
            this.getMap().getZoomHandler().setZoomLevel(this.getData().sFocusedZoom);
            iMapRequest.setLocationByLocation(this.getData().sFocusedPosition);
            this.getData().sFocusedPosition = null;
        }
        if (this.getMap().getLastVisibleCID() == 12 || this.getMap().getLastVisibleCID() == 28 || this.getMap().getLastVisibleCID() == 37) {
            if (this.container.sOldLocationAfterCrosshairMap != null) {
                this.getLogChannel().log(-2137614336, "CtxCrosshairMap#enter()recover previous crosshair settings");
                iMapRequest.setRotation(this.container.sSavedRotationAfterCrosshairMap);
                NavLocation navLocation = Util.getLocationFromGeoPos(this.container.sOldLocationAfterCrosshairMap.getLongitude(), this.container.sOldLocationAfterCrosshairMap.getLatitude());
                this.getMap().getMVRequest().setLocationByLocation(navLocation);
                this.container.sOldLocationAfterCrosshairMap = null;
            }
            if (this.getMap().getLastVisibleCID() != 12 && this.container.sSavedZoomIndexAfterCrosshairMap != -1) {
                this.getZoomHandler().setZoom(this.container.sSavedZoomIndexAfterCrosshairMap);
                this.container.sSavedZoomIndexAfterCrosshairMap = -1;
            }
        }
        this.naviMap.getGuiInterface().switchToNormalSidebar();
        this.shutdownAdditionalInfos();
        if (this.getMap().getLastCtxShownID() == 12) {
            this.initZoomLevel();
        }
        if (bl || Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            this.naviMap.getGuiInterface().setTopBarVisible(true);
        } else {
            this.env.getChoiceModel(958727680).setValue(1);
        }
        this.updateCrossHairsBoundingBox();
        if (this.naviMap.getNaviInterface().getViewSizeChangeHandler().isSmallStageActive() || this.container.requestedViewSize == 1) {
            this.container.requestedViewSize = 2;
            this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
        }
    }

    protected void initCtxFreeMap() {
        super.enter();
    }

    @Override
    public void exit() {
        NavLocationWgs84 navLocationWgs84;
        this.container.lastZoomLevelInCrossHairMode = this.getZoomHandler().getZoom();
        super.exit();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.setTopBarVisible(false);
        if (Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            gUIInterface.hideCrosshairs();
        }
        this.env.getChoiceModel(958727680).setValue(0);
        this.joystick(0, -1);
        this.container.sOldLocationAfterTMCMap = this.getMapPosition();
        this.container.sSavedZoomIndexAfterTMCMap = this.getSavedZoomListIndex();
        this.container.sSavedRotationAfterTMCMap = this.getMapRotation();
        this.getLogChannel().log(-2137614336, "CtxCrosshairMap#exit(): saved position = %1, zoom = %2, rotation = %3", (Object)this.container.sOldLocationAfterTMCMap, (long)this.container.sSavedZoomIndexAfterTMCMap, (long)this.container.sSavedRotationAfterTMCMap);
        this.container.sOldLocationAfterCrosshairMap = this.getMapPosition();
        this.container.sSavedZoomIndexAfterCrosshairMap = this.getSavedZoomListIndex();
        this.container.sSavedRotationAfterCrosshairMap = this.getMapRotation();
        if (this.container.requestedViewSize == 2) {
            this.container.requestedViewSize = 1;
            this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
        }
        if ((navLocationWgs84 = this.naviMap.getMapPosition()) != null && this.getMapSelectionHandler().getActiveInfoListIndex() < 0) {
            this.getData().sFocusedPosition = Util.wgs84ToNavLocation(navLocationWgs84);
        }
    }

    @Override
    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
    }

    @Override
    public void automaticOrientateMap() {
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.getLogChannel().log(-2137614336, "CtxCrosshairMap#keyPressed( modelID = %1, keyID = %2)", (long)n, (long)n2);
        switch (n) {
            case 400450: {
                this.getLogChannel().log(1078071040, "CtxCrosshairMap#keyPressed - NAV_MAP_FULLSCREEN_RETURN_BUTTON");
                this.naviMap.getGuiInterface().openOrCloseSidebar(3);
                this.naviMap.switchToAShownContext();
                break;
            }
            case 401004: {
                this.getLogChannel().log(-2137614336, "CtxCrosshairMap#keyPressed() - Crosshairs event");
                if (n2 == 17) {
                    this.onDDSClicked();
                    break;
                }
                if (n2 == 15) {
                    this.onHKBackClicked();
                    break;
                }
                this.getLogChannel().log(-1601830656, "CtxCrosshairMap#keyPressed() - unknown keyID = %1", (long)n2);
                break;
            }
            default: {
                super.keyPressed(n, n2);
            }
        }
    }

    @Override
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

    @Override
    protected void onDDSClicked() {
        boolean bl = !Util.isLockFeatureNavMapviewScrollEnabled(this.env) || !this.getMap().getNaviInterface().isFeatureToBeLocked() || Util.isHMIScrollHairsEnabled(this.env.getFramework());
        this.getLogChannel().log(1078071040, "CtxCrosshairMap#onDDSClicked() - selection event received (ddsClickAllowed: %1)", bl);
        if (bl) {
            this.bUserHasSelectedOnMap = true;
            this.getMap().getNaviInterface().getInputModeManager().setInputMode(0, this.env);
            this.joystick(-887224832, -1);
        }
    }

    @Override
    protected void onHKBackClicked() {
        this.getLogChannel().log(1078071040, "CtxCrosshairMap#onHKBackClicked() - HK back event received");
        this.getMap().forceContext(-1);
        this.getMap().switchToAShownContext();
    }

    @Override
    public void exitMapScreen() {
        this.getLogChannel().log(-2137614336, "CtxCrosshairMap#exitMapScreen()");
        int n = this.getCID();
        super.exitMapScreen();
        if (n == 12) {
            this.getLogChannel().log(-2137614336, "CtxCrosshairMap#exitMapScreen(): forceContext to (%1)", (long)n);
            this.naviMap.forceContext(n);
        }
    }

    @Override
    public void viewSizeChanged(int n) {
        super.viewSizeChanged(n);
        if (n == 1) {
            this.getLogChannel().log(1078071040, "CtxCrosshairMap#viewSizeChanged( ) - switch to normal map context.");
            this.onHKBackClicked();
        }
    }

    private void initZoomLevel() {
        if (this.getSetupMapType() == 3 && !this.container.sForceRestoreUserZoomLevel) {
            return;
        }
        if (this.container.fUserZoomLevel < 0.0f) {
            try {
                this.container.fUserZoomLevel = this.getZoomHandler().getZoomList()[this.getSetup().getSavedZoomListIndex()] / 51266;
                this.getLogChannel().log(-1601830656, "CtxCrosshairMap#initZoomLevel() - Invalid user zoom level -> use saved zoom level: %1m", (double)this.container.fUserZoomLevel);
            }
            catch (Exception exception) {
                this.container.fUserZoomLevel = 61505;
                this.getLogChannel().log(10000, "CtxCrosshairMap#initZoomLevel() - Invalid user zoom level -> use default zoom level: %1m", (double)this.container.fUserZoomLevel);
            }
        }
        this.getLogChannel().log(-2137614336, "CtxCrosshairMap#initZoomLevel() - fUserZoomLevel: %1m", (double)this.container.fUserZoomLevel);
        if (this.container.lastZoomLevelInCrossHairMode > 0.0f) {
            this.getZoomHandler().setZoomLevel(this.container.lastZoomLevelInCrossHairMode);
        } else if (this.container.fUserZoomLevel > 0.0f) {
            this.getZoomHandler().setZoomLevel(this.container.fUserZoomLevel);
        } else {
            this.getZoomHandler().setZoom(this.getSetup().getSavedZoomListIndex());
        }
    }

    @Override
    public void incrementGesture(int n) {
        super.incrementGesture(n);
        this.container.fUserZoomLevel = n / 100;
        this.container.lastZoomLevelInCrossHairMode = n / 100;
    }

    @Override
    protected int getMixedListOffset() {
        return 0;
    }

    @Override
    protected void initFocusedProperty() {
    }

    @Override
    public void updateLockingState(boolean bl) {
        if (bl) {
            if (Util.isLockFeatureNavMapviewScrollEnabled(this.env) && !Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
                this.getMap().getMVRequest().setMode(2);
                this.getMap().getGuiInterface().setTopBarVisible(false);
                this.env.getChoiceModel(958727680).setValue(1);
            }
        } else if (Util.isLockFeatureNavMapviewScrollEnabled(this.env) && !Util.isHMIScrollHairsEnabled(this.env.getFramework())) {
            this.getMap().getMVRequest().setMode(3);
            this.getMap().getGuiInterface().setTopBarVisible(true);
            this.env.getChoiceModel(958727680).setValue(0);
        }
        super.updateLockingState(bl);
    }
}

