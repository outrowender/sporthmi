/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.AbstractMap$MapState;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.IsViewSizeDepended;
import de.audi.tghu.navi.app.map.context.CtxPositionMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestZoomEngine;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public abstract class CtxShown
extends Context
implements IVisibleContext {
    private static final long[][] DEMO_MODE_SPEED_MAPPING = new long[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
    private static final int DEMO_MODE_SPEED_MAPPING_INDEX_ZOOMLEVEL;
    private static final int DEMO_MODE_SPEED_MAPPING_INDEX_FACTOR;

    CtxShown(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public synchronized void cleanup() {
        super.cleanup();
    }

    @Override
    public void enterPrologue() {
        this.freezeMap();
        int n = this.getCID();
        int n2 = this.getMap().getLastVisibleCID();
        if (MapUtils.isPreviewMapContext(n) != MapUtils.isPreviewMapContext(n2)) {
            this.getLogChannel().log(1078071040, "CtxShown#enterPrologue() - last visible CID = %1, active CID = %2, restore is required.", (long)n2, (long)n);
            this.restore();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enterEpilogue() {
        this.showMap(true);
        this.unfreezeMap();
        if (this.naviMap.isMapMain()) {
            MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
            synchronized (mVRequestControl) {
                if (MapUtils.isRectEqual(this.naviMap.getGuiInterface().getMapSize(), this.naviMap.getMVResponseControl().getViewScreenViewPort())) {
                    this.setGridMaskVisible(false);
                }
            }
        }
    }

    @Override
    public void enter() {
        if (Util.isRangeMapDisplayPresent(this.env.getFramework())) {
            this.switchMobilityHorizonAccordingToSetup();
        }
        this.setVisibleArea();
        this.reinitOrientationThresholds();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.setRotation(this.getMapRotation());
        gUIInterface.enableScrollInfo(this.getRGActive());
        if (!this.getRGActive()) {
            gUIInterface.clearDestDistance();
        }
        if (this.getMap().getSetup().isCrossingViewEnabled() && !this.getMap().getRouteInfoContextHandler().isManeuverViewAvailable() && this.getMap().getRouteInfoContextHandler().isManeuverViewVisible()) {
            this.getLogChannel().log(-2137614336, "CtxShown#enter() - correct visible display context!");
            this.getMap().getActiveCtx().setVisibleDisplayContextID(this.getMap().getMapDataContainer().sRequestedDisplayContextID);
        }
        int n = this.naviMap.getOldActiveContextIndex();
        if (this.getMap().getLastVisibleCID() == 30) {
            this.getMap().getMapManager().getPreviewMapHandler().resetEventVisibilities(true, true);
        }
        if (n == 3 || n == 33 || n == 5 || n == 20 || n == 2 || n == 27 || n == 26 || n == 30 || n == 18 || n == 13 || n == 28 || n == 37 || n == 36 || n == 34 || n == 39) {
            int n2;
            IMapRequest iMapRequest = this.naviMap.getMVRequest();
            iMapRequest.showTMCMessages(this.getSetupTMCSymbols());
            iMapRequest.setCityModelMode(this.determineSetup3DCityModelMode());
            iMapRequest.setLandmarksVisible(this.getSetup3DLandmarks());
            iMapRequest.setBrandIconStyle(new int[]{-1}, this.getSetupBrandedPOIs());
            iMapRequest.setPictureNavigationIconVisibility(this.getSetupPicNavIcons(), -1);
            iMapRequest.setWeatherVisualization(this.isSetupWeatherIconVisible());
            if (Util.isHURegionAsia()) {
                iMapRequest.setSpeedAndFlowRoadClass(this.getSetup().getProperty(5));
            }
            if ((n2 = this.naviMap.getActiveContextIndex()) != 26 && n2 != 27) {
                this.getMap().getMVRequest().setGeneralPoiVisibility(this.getSetup().getGeneralPoiVisibility());
            }
            this.switchDayNight();
            this.switchMapRepresentation();
            this.getMap().getSatellitemapsManager().setSatelliteMapIconsAccordingToSetup();
            this.naviMap.getNaviInterface().addressbookMapActive(true);
            this.getLogChannel().log(-2137614336, "CtxShown#enter()");
        }
        if (this.getData().sHomeAddress == null && MapEnv.isDebugMapFlagEnabled()) {
            this.getLogChannel().log(-2137614336, "CtxPositionMap#enter() - add faked pin als home address");
            this.getData().sHomeAddress = Util.getLocationFromGeoPos(-186966264, -1124619230);
        }
        this.refreshPins();
        this.hideToolTip();
        this.initFocusedProperty();
    }

    protected void initFocusedProperty() {
        this.getGUI().setFocusedProperty(-1);
    }

    @Override
    public void exit() {
        super.exit();
        this.naviMap.getMVRequest().setEnableSoftJump(false);
        this.naviMap.getMVRequest().setEnableSoftRotation(false);
        this.exitHandlingSetEnableSoftZoomAndSoftTilt();
    }

    public void exitHandlingSetEnableSoftZoomAndSoftTilt() {
        boolean bl;
        int n = this.naviMap.getActiveContextIndex();
        int n2 = this.naviMap.getOldActiveContextIndex();
        boolean bl2 = n == 12 && this.naviMap.getCtx(n2) instanceof CtxPositionMap;
        boolean bl3 = bl = this.naviMap.getCtx(n) instanceof CtxPositionMap && n2 == 12;
        if (bl2 || bl) {
            this.naviMap.getMVRequest().setEnableSoftZoom(true);
            this.naviMap.getMVRequest().setEnableSoftTilt(this.naviMap.isMapEnablingSoftTiltDesired());
            this.naviMap.getMVRequest().setEnableSoftZoomConditional(true);
        } else if (n2 != 10 || n != 6) {
            this.naviMap.getMVRequest().setEnableSoftZoom(false);
            this.naviMap.getMVRequest().setEnableSoftTilt(false);
            this.naviMap.getMVRequest().setEnableSoftZoomConditional(false);
        }
    }

    @Override
    public void enterMapScreen(int n) {
        this.getLogChannel().log(1078071040, "CtxShown#enterMapScreen() - keepContext: %1", (long)n);
        super.enterMapScreen(n);
        if (n == 1) {
            this.storeKeptContextIndex(this.naviMap.getActiveContextIndex());
        } else {
            this.naviMap.switchToAShownContext();
        }
    }

    @Override
    public void exitMapScreen() {
        super.exitMapScreen();
        this.naviMap.switchToContext(3);
        this.shutdownAdditionalInfos();
    }

    @Override
    public void exitNavSetup() {
        this.naviMap.switchToContext(3);
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
        if (!bl) {
            if (this.container.sInitalization) {
                this.container.sInitalization = false;
                int n = this.env.getFramework().isFrontMU() ? 0 : 5;
                boolean bl2 = this.env.getFramework().getLastmodeHandler().getLastmode(n) == 5;
                Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] CtxShown#updateViewFreeze() - isMapMain: ").append(this.naviMap.isMapMain()).append(", isLastmodeNav: ").append(bl2).append(", isLVDSmapVisible: ").append(this.naviMap.getNaviInterface().getClusterService().isLvdsMapVisible()));
                if (!this.naviMap.isMapKombi() && !bl2) {
                    this.naviMap.switchToContext(3);
                }
                if (this.naviMap.isMapMain()) {
                    this.naviMap.getNaviInterface().setOperationTaskCompleted(7);
                }
                if (this.naviMap.isMapKombi() && !this.naviMap.getNaviInterface().getClusterService().isLvdsMapVisible()) {
                    this.naviMap.switchToContext(3);
                }
                this.naviMap.mapInitialized();
            }
            this.naviMap.getMVRequest().setEnableSoftZoom(true);
            this.naviMap.getMVRequest().setEnableSoftTilt(this.naviMap.isMapEnablingSoftTiltDesired());
            this.naviMap.getMVRequest().setEnableSoftJump(true);
            this.naviMap.getMVRequest().setEnableSoftRotation(true);
            if (this.getMap().isDeepSwitchingEnabled()) {
                this.getMap().setEnableDeepSwitching(false);
            }
            if (!this.container.sSwitchDisplayContextImmediately) {
                this.switchDisplayContext(this.container.sRequestedDisplayContextID);
            }
        }
    }

    @Override
    protected void setVisibleArea() {
        Rect rect = this.getVisibleArea();
        this.getLogChannel().log(-2137614336, "CtxShown[%2]#setVisibleArea() - %1", (Object)rect, (long)this.getCID());
        this.getZoomHandler().setZoomArea(rect);
    }

    @Override
    public Rect getVisibleArea() {
        if (Util.isClusterMMI(this.env.getFramework()) || this.naviMap.isMapKombiFPK()) {
            return this.getGUI().getLayout().getVisibleArea(this.getCID(), false, true, this.getData().viewSize == 1);
        }
        if (Util.isPorscheGen2(this.env.getFramework())) {
            return this.getGUI().getLayout().getVisibleArea(this.getCID(), false, false, this.getData().viewSize == 1);
        }
        return this.getGUI().getLayout().getVisibleArea(this.getCID(), this.getMixedListOffset() > 0, true);
    }

    protected void centerCarPosition() {
        this.getLogChannel().log(-2137614336, "CtxShown#centerCarPosition()");
        Rect rect = this.getVisibleArea();
        this.setCarPosition(rect.kordX + (rect.diffX >> 1), rect.kordY + (rect.diffY >> 1));
    }

    protected void setHotPoint(int n, int n2) {
        this.getLogChannel().log(-2137614336, "CtxShown#setHotPoint( x = %1, y = %2 )", (long)n, (long)n2);
        this.naviMap.getMVRequest().setHotPoint(new Point(n, n2));
    }

    protected void setCarPosition(int n, int n2) {
        int n3 = n + this.getGUI().getOffsetOfCarPosition();
        this.getLogChannel().log(1078071040, "CtxShown#setCarPosition( x = %1 (adjusted to %3), y = %2 )", (long)n, (long)n2, (long)n3);
        this.naviMap.getMVRequest().setCarPosition(new Point(n3, n2));
    }

    protected int getCrosshairHotPointX() {
        return this.naviMap.getMVRequest().getHotPointPosition().getXPos();
    }

    protected int getCrosshairHotPointY() {
        return this.naviMap.getMVRequest().getHotPointPosition().getYPos();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestPreferredViewType() {
        CtxShown ctxShown = this;
        synchronized (ctxShown) {
            int n = 0;
            if (this.getSetupMapType() == 2 && !MapUtils.isRSERouteCalcMode(this.env.getFramework())) {
                n = 3;
            }
            this.naviMap.getMVRequest().setViewType(n);
        }
    }

    @Override
    public void sdsSetZoomLevel(int n) {
        super.sdsSetZoomLevel(n);
        this.getZoomHandler().setZoom(n);
    }

    @Override
    public void updateMapRotation(short s) {
        super.updateMapRotation(s);
        this.naviMap.getGuiInterface().setRotation(s);
    }

    private void reinitOrientationThresholds() {
        this.container.sAutoOrientationThreshold = this.retrieveZoomListIndex(8436549);
        this.container.sOrientationThresholdPM = 5292871;
    }

    @Override
    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
        if (fArray != null && fArray.length > 0) {
            this.reinitOrientationThresholds();
        }
        super.updateZoomList(fArray, n, fArray2);
    }

    @Override
    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
        this.getLogChannel().log(-2137614336, "CtxShown#updateZoomListIndex(%1)", (long)n);
        if (this.getZoomHandler().getZoom() >= 64068 && this.isMapFlagAutoHideEnabled()) {
            this.getMap().getMapFlagHandler().cleanAllPins();
        } else {
            this.getMap().getMapFlagHandler().refresh(false);
        }
    }

    protected boolean isMapFlagAutoHideEnabled() {
        return false;
    }

    @Override
    public void showLandmark(float f2) {
        if (this.container.sToolTipMode == 3) {
            if (-2137614336 <= this.getLogChannel().getCurrentLogThreshold()) {
                this.getLogChannel().log(1078071040, "CtxShown#showLandmark(): aspectRatio = %1", (Object)Float.toString(f2));
            }
            if ((double)f2 < 1.0) {
                this.container.sToolTipMode = 4;
            }
            this.naviMap.getGuiInterface().showToolTip(this.container.s3DLandmarkString, this.container.sToolTipMode, this.container.s3DLandmarkX, this.container.s3DLandmarkY, this.container.s3DLandmarkPositionInfo != null ? this.container.s3DLandmarkPositionInfo.getDisplayPosition() : null, null, false, false, null, 0);
            this.switchDisplayContext(5);
        }
    }

    @Override
    public void updateManoeuvreViewsAvailable(short[] sArray) {
        this.getLogChannel().log(1078071040, "CtxShown#updateManoeuvreViewsAvailable() - sShowManeuverViews: %1", this.container.sShowManeuverViews);
        super.updateManoeuvreViewsAvailable(sArray);
        this.naviMap.getRouteInfoContextHandler().handleCurrentRouteInfoContext();
    }

    @Override
    public void updateManoeuvreViewActive(int n) {
        super.updateManoeuvreViewActive(n);
        this.getLogChannel().log(-2137614336, "CtxShown#updateManoeuvreViewActive( %1 )", (long)n);
        this.naviMap.getRouteInfoContextHandler().signalManeuverViewActive();
    }

    @Override
    public void initAdditionalInfos() {
        super.initAdditionalInfos();
        this.container.sShowManeuverViews = this.getSetup().isCrossingViewEnabled();
        this.container.sShowMapInMap = this.getSetup().isMapInMapEnabled();
        this.getLogChannel().log(-2137614336, "CtxShown#initAdditionalInfos() - sShowManeuverViews: %1, sShowMapInMap: %2", this.container.sShowManeuverViews, this.container.sShowMapInMap);
        this.naviMap.getRouteInfoContextHandler().handleCurrentRouteInfoContext();
    }

    protected void shutdownAdditionalInfos() {
        this.container.sShowManeuverViews = false;
        this.container.sShowMapInMap = false;
        boolean bl = this.naviMap.getRouteInfoContextHandler().isManeuverViewVisible();
        this.getLogChannel().log(-2137614336, "CtxShown#shutdownAdditionalInfos() - maneuverViewVisible: %1", bl);
        this.naviMap.getRouteInfoContextHandler().handleCurrentRouteInfoContext();
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.enableScrollInfo(bl);
        gUIInterface.clearDestDistance();
        if (!bl) {
            this.hideBetterRoutePopup();
        }
        this.naviMap.getRouteInfoContextHandler().handleCurrentRouteInfoContext();
    }

    protected void hideBetterRoutePopup() {
        this.getGUI().hidePopupBetterRouteAvailable();
        this.getMap().switchToAShownContext();
    }

    @Override
    public void setNightDesign(int n) {
        super.setNightDesign(n);
        this.switchMapAccordingToNightDesign();
    }

    @Override
    public void incrementGesture(int n) {
        super.incrementGesture(n);
        this.getZoomHandler().incrementGesture(n);
    }

    @Override
    public void touchScreenDoubleClick(int n, int n2, int n3) {
        this.getZoomHandler().doubleClick();
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3) {
        this.getZoomHandler().pinchZoom(f2);
    }

    @Override
    public void touchScreenRotate(int n, short s) {
        this.naviMap.getMVRequest().setRotation(s);
    }

    @Override
    public void increment(int n, int n2) {
        super.increment(n, n2);
        switch (n) {
            case 400476: {
                this.naviMap.getMVRequest().setEnableSoftZoomConditional(false);
                this.getZoomHandler().incrementWithDelay(n2);
                break;
            }
        }
    }

    protected int getNextZoomIndex(int n, boolean bl) {
        int[] nArray = new int[]{0, 3, 7, 11, 18, 21, 28, 36};
        if (n < nArray[0]) {
            return nArray[0];
        }
        if (n > nArray[nArray.length - 1]) {
            return nArray[nArray.length - 1];
        }
        int n2 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 = i2 == nArray.length - 1 ? nArray[i2] : nArray[i2 + 1];
            if (bl) {
                if (n < nArray[i2] || n >= n2) continue;
                return nArray[i2 + 1];
            }
            if (n <= nArray[i2] || n > n2) continue;
            return nArray[i2];
        }
        return n;
    }

    @Override
    public void keyPressed(int n, int n2) {
        super.keyPressed(n, n2);
        block0 : switch (n) {
            case 400492: {
                this.naviMap.switchToContext(17);
                break;
            }
            case 400482: {
                this.getSetup().setOrientation(this.getMapOrientation() == 0 ? 0 : 1, true);
                this.activateOrientationAccordingToSetup();
                break;
            }
            case 400450: 
            case 400791: {
                this.naviMap.getGuiInterface().fireModelEvent(n);
                break;
            }
            case 400476: {
                int n3 = 0;
                int n4 = 0;
                switch (n2) {
                    case 0: {
                        boolean bl = this.naviMap.getGuiInterface().isZoomBarOpen();
                        this.naviMap.getGuiInterface().openOrCloseZoomBar(!bl);
                        break;
                    }
                    case 31: {
                        this.naviMap.getMVRequest().setEnableSoftZoomConditional(false);
                        n3 = this.naviMap.getMVResponseControl().getZoomListIndex();
                        n4 = this.getNextZoomIndex(n3, true);
                        this.getLogChannel().log(-2137614336, "CtxShown#keyPressed#NAV_MAP_MAGNIFICATION_RANGE-KEY_LEFT: newIndex = %1", (long)n4);
                        if (n4 == n3) break block0;
                        this.increment(n, n4 - n3);
                        break;
                    }
                    case 32: {
                        this.naviMap.getMVRequest().setEnableSoftZoomConditional(false);
                        n3 = this.naviMap.getMVResponseControl().getZoomListIndex();
                        n4 = this.getNextZoomIndex(n3, false);
                        this.getLogChannel().log(-2137614336, "CtxShown#keyPressed#NAV_MAP_MAGNIFICATION_RANGE-KEY_RIGHT: newIndex = %1", (long)n4);
                        if (n4 == n3) break block0;
                        this.increment(n, n4 - n3);
                        break;
                    }
                    default: {
                        this.getLogChannel().log(-1601830656, "CtxShown#keyPressed#NAV_MAP_MAGNIFICATION_RANGE - unknown keyID = %1", (long)n2);
                        break;
                    }
                }
                break;
            }
            case 400898: {
                this.naviMap.getZoomHandler().startPinchZoom();
                break;
            }
            case 401004: {
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
            case 401781: {
                this.getGUI().fireModelEvent(1965098496);
                this.onHKSelectionClicked();
                break;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2) {
        super.keyReleased(n, n2);
        switch (n) {
            case 400898: {
                this.naviMap.getZoomHandler().stopPinchZoom();
                if (!MapEnv.isDebuggingCrossHair()) break;
                this.naviMap.switchToContext(12);
                break;
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        super.itemSelected(n, n2, n3, n4);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        switch (n) {
            case 400447: {
                gUIInterface.openOrCloseSidebar(n2);
                if (n2 != 1) break;
                this.naviMap.switchToContext(12);
                break;
            }
        }
    }

    @Override
    public void joystick(int n, int n2) {
        super.joystick(n, n2);
        if (n != 404817408) {
            AbstractMap abstractMap = this.naviMap;
            int n3 = abstractMap.getActiveContextIndex();
            if (n2 >= 0 && !MapUtils.isUserInteractiveMap(n3)) {
                abstractMap.switchToContext(12);
                abstractMap.getActiveContext().joystick(n, n2);
            }
        }
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
        this.getLogChannel().log(-2137614336, "CtxShown[%1]#touchPadPositionMoved( %2 )", (long)this.getMap().getActiveContextIndex(), (long)n);
        AbstractMap abstractMap = this.naviMap;
        int n6 = abstractMap.getActiveContextIndex();
        if (!MapUtils.isUserInteractiveMap(n6)) {
            abstractMap.switchToContext(12);
            abstractMap.getActiveContext().touchPadPositionMoved(n, n2, n3, n4, n5);
        }
    }

    protected void hideToolTip() {
        this.getLogChannel().log(-2137614336, "CtxShown#hideToolTip()");
        this.getGUI().hideToolTip();
    }

    @Override
    public void onChangedMapType(int n, int n2) {
        super.onChangedMapType(n, n2);
        AbstractMap abstractMap = this.naviMap;
        int n3 = abstractMap.getActiveContextIndex();
        if (!MapUtils.isUserInteractiveMap(n3)) {
            abstractMap.getActiveContext().freezeMapLevel1();
            abstractMap.forceSwitchToAShownContext();
            abstractMap.getActiveCtx().requestPreferredViewType();
            abstractMap.getActiveCtx().sdsChangedMapType();
            abstractMap.getActiveContext().unfreezeMapLevel1();
        }
    }

    @Override
    public void onChangedMapRepresentation(int n, int n2) {
        super.onChangedMapRepresentation(n, n2);
        if (n == 3 || n2 == 3) {
            this.naviMap.forceShownContextRefresh();
        }
    }

    @Override
    public void onChangedDayNightView(int n) {
        this.getLogChannel().log(-2137614336, "CtxShown#onChangedDayNightView() - dayNightView = %1", (long)n);
        super.onChangedDayNightView(n);
        AbstractMap abstractMap = this.naviMap;
        abstractMap.getActiveContext().freezeMapLevel1();
        abstractMap.getActiveCtx().switchDayNight();
        abstractMap.getActiveContext().unfreezeMapLevel1();
    }

    public void calculateAndSetDemoModeSpeed() {
        long l = this.calculateDemoModeSpeed(this.getZoomHandler().getZoom() * 51266);
        if (l != -1L) {
            this.getLogChannel().log(-2137614336, "CtxShown#calculateAndSetDemoModeSpeed() - speed = %1", l);
            this.naviMap.getNaviInterface().setDemoModeSpeed(l);
        } else {
            this.getLogChannel().log(-1601830656, "CtxShown#calculateAndSetDemoModeSpeed() - could not calculate demo mode speed");
        }
    }

    private long calculateDemoModeSpeed(float f2) {
        long l;
        String string = String.valueOf(f2);
        this.getLogChannel().log(-2137614336, "CtxShown#calculateDemoModeSpeed() - zoomLevel: %1", (Object)string);
        long l2 = (long)(f2 + 63);
        int n = DEMO_MODE_SPEED_MAPPING.length;
        if (n > 0 && l2 > (l = DEMO_MODE_SPEED_MAPPING[n - 1][0])) {
            long l3 = DEMO_MODE_SPEED_MAPPING[n - 1][1];
            this.getLogChannel().log(-2137614336, "CtxShown#calculateDemoModeSpeed() - use maximum demo mode speed: %1", l3);
            return l3;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            l = DEMO_MODE_SPEED_MAPPING[i2][0];
            if (l2 > l) continue;
            long l4 = DEMO_MODE_SPEED_MAPPING[i2][1];
            this.getLogChannel().log(-2137614336, "CtxShown#calculateDemoModeSpeed() - calculated demo mode speed: %1", l4);
            return l4;
        }
        this.getLogChannel().log(-2137614336, "CtxShown#calculateDemoModeSpeed() - could not calculate demo mode speed; return default: 1000L");
        return 0;
    }

    @Override
    public boolean isUserZoomEnabled() {
        return true;
    }

    protected void updateCrosshairsColor() {
        this.getLogChannel().log(-2137614336, "CtxShown[%1]#updateCrosshairsColor()", (long)this.getCID());
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.setCrossHairsColor(gUIInterface.getCrosshairColorMode() == 1);
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(-2137614336, "CtxShown[%1]#onDDSClicked()", (long)this.getCID());
    }

    protected void onHKBackClicked() {
        this.getLogChannel().log(-2137614336, "CtxShown[%1]#onHKBackClicked()", (long)this.getCID());
        this.getGUI().fireHKBackEvent();
    }

    protected void onHKSelectionClicked() {
        this.getLogChannel().log(14808325, "CtxShown[%1]#onHKSelectionClicked()", (long)this.getCID());
    }

    protected void restore() {
        this.getLogChannel().log(-2137614336, "CtxShown[%1]#restore()", (long)this.getCID());
        AbstractMap$MapState abstractMap$MapState = this.getMap().getLastMapState();
        IMapRequest iMapRequest = this.getMap().getMVRequest();
        if (abstractMap$MapState != null) {
            this.getZoomHandler().setZoomLevel(abstractMap$MapState.zoomlevel);
            iMapRequest.setOrientation(abstractMap$MapState.mapOrientation);
            if (!(this.naviMap.getActiveCtx() instanceof CtxPositionMap) && abstractMap$MapState.position != null && abstractMap$MapState.position.latitude != 0 && abstractMap$MapState.position.longitude != 0) {
                iMapRequest.setMapPosition(abstractMap$MapState.position);
            }
        }
        iMapRequest.showTMCMessages(true);
        iMapRequest.setGeneralPoiVisibility(this.getSetup().getGeneralPoiVisibility());
        int n = this.naviMap.getOldActiveContextIndex();
        if (this.naviMap.getActiveContextIndex() != 12 || !(this.naviMap.getCtx(n) instanceof CtxPositionMap)) {
            iMapRequest.setEnableSoftZoom(false);
            iMapRequest.setEnableSoftRotation(false);
            iMapRequest.setEnableSoftTilt(false);
            iMapRequest.setEnableSoftJump(false);
        }
    }

    @Override
    public void viewSizeChanged(int n) {
        super.viewSizeChanged(n);
        if (this instanceof IsViewSizeDepended) {
            this.getLogChannel().log(14808325, "CtxShown[%1]#viewSizeChanged( %2 )", (long)this.getCID(), (long)n);
            this.setVisibleArea();
        }
    }

    @Override
    public void setSDSDialogActive(boolean bl) {
        this.getLogChannel().log(-2137614336, "CtxShown[%2]#setSDSDialogActive( %1 )", bl, (long)this.getCID());
        super.setSDSDialogActive(bl);
        this.setBackgroundRenderingMode(bl);
        this.joystick(1075578368, -1);
    }

    protected void refreshPins() {
        this.getMapFlagHandler().refresh(true);
    }

    @Override
    public void setBackgroundRenderingMode(boolean bl) {
        this.getLogChannel().log(-2137614336, "CtxShown#setBackgroundMode( %1 )", bl);
        if (!bl && (this.getSDSDialogActive() || this.isDrawerOpen())) {
            this.getLogChannel().log(-2137614336, "CtxShown#setBackgroundMode() - keeping background mode active (SDS dialog active = %1, drawer open = %2)", this.getSDSDialogActive(), this.isDrawerOpen());
            return;
        }
        this.naviMap.getMVRequest().setFrameRateMode(bl ? 2 : 1);
    }

    @Override
    public void showTMC(boolean bl) {
        super.showTMC(bl);
        this.freezeMap();
        this.naviMap.getMVRequest().showTMCMessages(bl);
        this.unfreezeMap();
    }

    @Override
    public void showSpeedAndFlowFreeflow(boolean bl) {
        super.showSpeedAndFlowFreeflow(bl);
        this.showSpeedAndFlowFreeflow(bl, true);
    }

    @Override
    public void showSpeedAndFlowFreeflow(boolean bl, boolean bl2) {
        super.showSpeedAndFlowFreeflow(bl);
        if (bl2) {
            this.freezeMap();
            this.naviMap.getMVRequest().showSpeedAndFlowFreeflow(bl);
            this.unfreezeMap();
        } else {
            this.naviMap.getMVRequest().showSpeedAndFlowFreeflow(bl);
        }
    }

    @Override
    public void showSpeedAndFlowCongestions(boolean bl) {
        super.showSpeedAndFlowCongestions(bl);
        this.showSpeedAndFlowCongestions(bl, true);
    }

    @Override
    public void showSpeedAndFlowCongestions(boolean bl, boolean bl2) {
        super.showSpeedAndFlowCongestions(bl);
        if (bl2) {
            this.freezeMap();
            this.naviMap.getMVRequest().showSpeedAndFlowCongestions(bl);
            this.unfreezeMap();
        } else {
            this.naviMap.getMVRequest().showSpeedAndFlowCongestions(bl);
        }
    }

    @Override
    public void setSpeedAndFlowRoadClass(int n) {
        super.setSpeedAndFlowRoadClass(n);
        this.freezeMap();
        this.naviMap.getMVRequest().setSpeedAndFlowRoadClass(n);
        this.unfreezeMap();
    }

    @Override
    public void setLandmarksVisible(boolean bl) {
        super.setLandmarksVisible(bl);
        this.freezeMap();
        this.naviMap.getMVRequest().setLandmarksVisible(bl);
        this.unfreezeMap();
    }

    @Override
    public void setCityModelMode(int n) {
        super.setCityModelMode(n);
        this.freezeMap();
        this.naviMap.getMVRequest().setCityModelMode(n);
        this.unfreezeMap();
    }

    @Override
    public void showBrandIcons(int n) {
        super.showBrandIcons(n);
        this.freezeMap();
        this.naviMap.getMVRequest().setBrandIconStyle(new int[]{-1}, n);
        this.unfreezeMap();
    }

    @Override
    public void showPictureNavigationIcons(boolean bl) {
        super.showPictureNavigationIcons(bl);
        this.freezeMap();
        this.naviMap.getMVRequest().setPictureNavigationIconVisibility(bl, -1);
        this.unfreezeMap();
    }

    @Override
    public void showWeatherIcons(boolean bl) {
        super.showWeatherIcons(bl);
        this.freezeMap();
        this.naviMap.getMVRequest().setWeatherVisualization(bl);
        this.unfreezeMap();
    }

    @Override
    public void updateMobilityHorizonStatus(int n) {
        super.updateMobilityHorizonStatus(n);
        this.switchMobilityHorizonAccordingToSetup();
    }

    protected void refreshCarPositionForZoomEngine() {
        this.getLogChannel().log(-2137614336, "CtxShown#refreshCarPositionForZoomEngine()");
        Rect rect = this.getVisibleArea();
        if (Util.isClusterMMI(this.env.getFramework())) {
            rect.kordY = rect.kordY - 15 - 5;
        }
        int n = rect.kordY + (int)(-512080833 * (float)rect.diffY) + 1;
        MVRequestZoomEngine mVRequestZoomEngine = this.getMap().getMVRequest().getMVRequestZoomEngine();
        if (mVRequestZoomEngine != null) {
            mVRequestZoomEngine.setCarPosition(new Point(rect.kordX + (rect.diffX >> 1), n));
            mVRequestZoomEngine.setViewType(0);
            mVRequestZoomEngine.setMapOrientation(0);
        }
    }

    @Override
    public void recalculateVisibleArea() {
        this.setVisibleArea();
    }

    @Override
    public void updateLockingState(boolean bl) {
        if (Util.isLockFeatureNavMapAdvancedMapEnabled(this.env)) {
            this.naviMap.getMVRequest().setCityModelMode(this.determineSetup3DCityModelMode());
            this.naviMap.getMVRequest().setLandmarksVisible(this.getSetup3DLandmarks());
        }
        super.updateLockingState(bl);
    }

    @Override
    protected int determineSetup3DCityModelMode() {
        if (Util.isLockFeatureNavMapAdvancedMapEnabled(this.env) && this.naviMap.getNaviInterface().isFeatureToBeLocked()) {
            return 0;
        }
        return super.determineSetup3DCityModelMode();
    }

    @Override
    protected boolean getSetup3DLandmarks() {
        if (Util.isLockFeatureNavMapAdvancedMapEnabled(this.env) && this.naviMap.getNaviInterface().isFeatureToBeLocked()) {
            return false;
        }
        return super.getSetup3DLandmarks();
    }
}

