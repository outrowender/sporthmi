/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CtxFreeMap$1;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.context.HasPosInfo;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.gui.ToolTipTimer;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler$IMapSelectionListener;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class CtxFreeMap
extends CtxShown
implements HasPosInfo,
MapSelectionHandler$IMapSelectionListener {
    protected static final float CROSSHAIRS_3D_HEIGHT_FACTOR;
    private int mOptMenuModelIDPending = -1;
    private boolean mTouchPadTapped = false;
    protected boolean bUserHasSelectedOnMap = false;
    protected int selectionModelId;

    protected CtxFreeMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public synchronized void cleanup() {
        super.cleanup();
        this.cancelTooltipTimer();
    }

    protected void cancelTooltipTimer() {
        ToolTipTimer toolTipTimer = this.getToolTipTimer();
        if (toolTipTimer != null) {
            toolTipTimer.cancelAndHideToolTip();
        }
    }

    private ToolTipTimer getToolTipTimer() {
        return this.getMap().getGuiInterface().getTooltipTimer();
    }

    @Override
    public void enter() {
        super.enter();
        this.naviMap.cancelOverviewMapTimer();
        this.setToolTipDelay(0);
        this.joystick(0, -1);
        this.naviMap.getGuiInterface().setSideBarRotaryIcon(2);
        this.getMapSelectionHandler().clear();
        int n = this.naviMap.getOldActiveContextIndex();
        this.getLogChannel().log(-2137614336, "CtxFreeMap#enter: oldContext = %1", (long)n);
        if (n != 12 && n != 17 && this.naviMap.getmLastForcedContext() != 17) {
            this.container.sNeedToSetScrollOnRoutePosition = true;
        }
    }

    @Override
    public void exit() {
        super.exit();
        ToolTipTimer toolTipTimer = this.getToolTipTimer();
        if (null != toolTipTimer) {
            toolTipTimer.cancelAndHideToolTip();
        }
        this.joystick(0, -1);
        this.validateMapPosition(true);
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
        if (!bl) {
            this.requestInfoForPosition(true);
        }
    }

    protected void requestInfoForPosition(boolean bl) {
        this.getMapSelectionHandler().requestInfoForPosition(bl, this.bUserHasSelectedOnMap);
    }

    public void requestInfoForScreenPosition(int n, Point point) {
        this.getMapSelectionHandler().requestInfoForScreenPosition(n, point);
    }

    @Override
    public void updateInfoForPosition(PosInfo[] posInfoArray) {
        this.getMapSelectionHandler().updateInfoForPosition(posInfoArray, this.container.sJoystickIdle);
    }

    @Override
    public void updateTmcMessage(TmcMessage tmcMessage) {
        this.getMapSelectionHandler().updateTmcMessage(tmcMessage);
    }

    @Override
    public void updateOnlineResultFlagDetails(int n) {
        this.getMapSelectionHandler().updateOnlineResultFlagDetails(n);
    }

    protected void showToolTipAfterTimeout(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
        ToolTipTimer toolTipTimer = this.getToolTipTimer();
        if (toolTipTimer != null) {
            toolTipTimer.restart(string, n, n2, posInfo, string2, bl, bl2, resourceLocator);
        }
    }

    @Override
    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
        this.getSetup().setSavedZoomListIndex(n, true);
        if (this.container.sJoystickIdle && !this.getViewFreeze()) {
            this.requestInfoForPosition(true);
        }
    }

    @Override
    public void updateMapOrientation(int n) {
        super.updateMapOrientation(n);
        if (this.container.sJoystickIdle && !this.getViewFreeze()) {
            this.requestInfoForPosition(true);
        }
    }

    @Override
    public void joystick(int n, int n2) {
        super.joystick(n, n2);
        if (n != 404817408) {
            this.selectionModelId = n;
            this.getLogChannel().log(-2137614336, "CtxFreeMap#joystick( modelID = %1, dir = %2 )", (long)n, (long)n2);
            if (n2 >= 0 && !this.getSDSDialogActive()) {
                this.scrollMapStart(n2);
            } else {
                this.scrollMapStop(n != 0);
            }
        }
    }

    protected void scrollMapStart(int n) {
        this.getLogChannel().log(-1601830656, "CtxFreeMap#scrollMapStart( %1 )", (long)n);
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        if (n < 0 || n > 359) {
            this.getLogChannel().log(-1601830656, "CtxFreeMap#scrollMapStart() - Invalid direction: %1", (long)n);
            return;
        }
        this.naviMap.getGuiInterface().setSideBarRotaryIcon(2);
        iMapRequest.startScrollToDirection(n);
        this.container.sScrollToDirectionActive = true;
        this.cancelTooltipTimer();
        this.getMapSelectionHandler().clear();
        this.getGUI().setFocusedProperty(-1);
        this.container.sJoystickIdle = false;
        this.container.sMapScrollDir = n;
        this.bUserHasSelectedOnMap = false;
        this.validateMapPosition(false);
    }

    protected void scrollMapStop(boolean bl) {
        this.getLogChannel().log(-2137614336, "CtxFreeMap#scrollMapStop( %1 )", bl);
        if (!this.container.sJoystickIdle) {
            IMapRequest iMapRequest = this.naviMap.getMVRequest();
            iMapRequest.stopScrollToDirection();
            this.container.sScrollToDirectionActive = false;
        }
        this.container.sJoystickIdle = true;
        this.container.sMapScrollDir = -1;
        if (bl) {
            this.requestInfoForPosition(true);
        }
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
        boolean bl;
        boolean bl2 = bl = n2 == 1;
        if (this.container.sScrollByCrossHairsEnabled != bl) {
            this.container.sScrollByCrossHairsEnabled = bl;
            this.naviMap.getMVRequest().setScrollByCrossHairs(bl);
        }
        if (this.container.sJoystickIdle) {
            this.startScrolling();
        }
        if (!this.container.sScrollToDirectionActive) {
            if (n2 == 1) {
                this.naviMap.getMVRequest().dragMap((short)n4, (short)n5);
            } else {
                this.naviMap.getMVRequest().dragMap((short)(-n4), (short)(-n5));
            }
        }
    }

    private void startScrolling() {
        this.getLogChannel().log(1078071040, "CtxFreeMap#startScrolling()");
        this.naviMap.getGuiInterface().setSideBarRotaryIcon(2);
        this.getMapSelectionHandler().cancelSelection();
        this.getGUI().setFocusedProperty(-1);
        this.hideToolTip();
        this.cancelTooltipTimer();
        this.getMapSelectionHandler().clear();
        this.container.sJoystickIdle = false;
        this.validateMapPosition(false);
    }

    @Override
    public void screenHidden() {
        super.screenHidden();
        this.joystick(0, -1);
    }

    @Override
    public void screenVisible() {
        super.screenVisible();
        if (this.determineSetup3DCityModelMode() != 0) {
            this.getLogChannel().log(1078071040, "CtxFreeMap#screenVisible(): restoring city model (3D buildings) = %1 ", (long)this.determineSetup3DCityModelMode());
            this.naviMap.getMVRequest().setCityModelMode(this.determineSetup3DCityModelMode());
        }
        if (this.getSetup3DLandmarks()) {
            this.getLogChannel().log(1078071040, "CtxFreeMap#screenVisible(): restoring landmarks = true");
            this.naviMap.getMVRequest().setLandmarksVisible(true);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        super.itemSelected(n, n2, n3, n4);
        this.getLogChannel().log(1078071040, "CtxFreeMap#itemSelected() - modelID: %1, itemID: %2", (long)n, (long)n2);
        if (n == 1058801152 && n2 == 3) {
            this.naviMap.getMVRequest().setCityModelMode(this.determineSetup3DCityModelMode());
            this.naviMap.getMVRequest().setLandmarksVisible(this.getSetup3DLandmarks());
            this.naviMap.switchToAShownContext();
        } else if (n == 991692288 || n == 890963456) {
            if (n2 == -1) {
                this.scrollMapStop(true);
            } else {
                this.scrollMapStart(n2);
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2) {
        switch (n) {
            case 400181: 
            case 400443: {
                if (this.naviMap.getGuiInterface().getMapScrollSidebarPressed(n)) {
                    this.naviMap.getGuiInterface().setMapScrollSidebarPressed(n, false);
                    break;
                }
                this.naviMap.getGuiInterface().setMapScrollSidebarPressed(n, true);
                break;
            }
        }
    }

    @Override
    public void keyReleased(int n, int n2) {
        super.keyReleased(n, n2);
        switch (n) {
            case 400181: 
            case 400443: {
                this.naviMap.getGuiInterface().setMapScrollSidebarPressed(n, false);
                break;
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2) {
        super.keyPressed(n, n2);
        switch (n) {
            case 400482: {
                this.cancelTooltipTimer();
                this.getMapSelectionHandler().clear();
                this.getGUI().setFocusedProperty(-1);
                break;
            }
            case 400479: {
                this.naviMap.getNaviInterface().resetEditInputMode();
                this.mTouchPadTapped = n2 == 10906 || n2 == 10907;
                this.getLogChannel().log(-2137614336, "CtxFreeMap#keyPressed() - mTouchPadTapped: %1 - keyID: %2", this.mTouchPadTapped, (long)n2);
                if (this.getMapSelectionHandler().getActiveInfoListIndex() >= 0) {
                    this.switchToFollowUpScreen(n);
                    break;
                }
                this.mOptMenuModelIDPending = n;
                break;
            }
            case 400181: 
            case 400443: {
                if (this.naviMap.getGuiInterface().getMapScrollSidebarPressed(n)) {
                    this.naviMap.getGuiInterface().setMapScrollSidebarPressed(n, false);
                    break;
                }
                this.naviMap.getGuiInterface().setMapScrollSidebarPressed(n, true);
                break;
            }
        }
    }

    protected void switchToFollowUpScreen(int n) {
        Object object;
        Object object2;
        MapItemSelectionInfo mapItemSelectionInfo = this.getMapSelectionHandler().getSelectedValue();
        if (mapItemSelectionInfo == null) {
            this.getLogChannel().log(-1601830656, "CtxFreeMap#switchToFollowUpScreen() - no selected value");
            return;
        }
        PosInfo posInfo = mapItemSelectionInfo.posInfo;
        NavLocation navLocation = posInfo.getTLocation();
        int n2 = posInfo.getEInfoType();
        String string = null;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        this.getLogChannel().log(1078071040, "CtxFreeMap#switchToFollowUpScreen() - infoType = %1", (long)n2);
        block2 : switch (n2) {
            case 1: 
            case 2: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_POI");
                break;
            }
            case 3: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_POI_CONTAINER");
                bl = true;
                break;
            }
            case 5: {
                MapFlag[] mapFlagArray = this.naviMap.getMapFlagHandler().getPins();
                int n3 = MapUtils.searchUserFlag(posInfo, mapFlagArray, this.env);
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_PERSONAL_DEST: index = %1", (long)n3);
                if (mapFlagArray == null || n3 < 0) break;
                if (((MapPin)mapFlagArray[n3]).type == 3 || ((MapPin)mapFlagArray[n3]).type == 2) {
                    object2 = this.getOnlinePOIResultList();
                    switch (this.getCID()) {
                        case 15: {
                            if (object2 != null) {
                                navLocation = ((OnlinePOIResultList)object2).getTransformedLocationAt(((MapPin)mapFlagArray[n3]).index);
                                string = mapItemSelectionInfo.Url;
                                break block2;
                            }
                            this.getLogChannel().log(-1601830656, "CtxFreeMap#switchToFollowUpScreen() - oprl is null");
                            break block2;
                        }
                        case 28: {
                            navLocation = null;
                            object = this.getMap().getNaviInterface().getNaviOnlineService().getListener();
                            if (object != null) {
                                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - setting index %1 at naviOnlineServiceListener ", (long)((MapPin)mapFlagArray[n3]).index);
                                try {
                                    object.indicateSelectedMapFlag(((MapPin)mapFlagArray[n3]).index);
                                }
                                catch (Exception exception) {
                                    this.getLogChannel().log(10000, "CtxFreeMap#switchToFollowUpScreen() - ERROR = %1 ", (Throwable)exception);
                                }
                                return;
                            }
                            this.getLogChannel().log(-1601830656, "CtxFreeMap#switchToFollowUpScreen() - naviOnlineServiceListener is null");
                            break block2;
                        }
                    }
                    this.getLogChannel().log(10000, "CtxFreeMap#switchToFollowUpScreen() - inconsistent");
                    break;
                }
                if (((MapPin)mapFlagArray[n3]).styleIndex == MapUtils.getStyleIndexForFavorite()) {
                    navLocation = mapItemSelectionInfo.navLocationAdditionalInfo;
                    break;
                }
                object2 = null;
                object = null;
                switch (((MapPin)mapFlagArray[n3]).styleIndex) {
                    case 0: 
                    case 1: {
                        try {
                            object2 = this.getData().sTopDestinations[((MapPin)mapFlagArray[n3]).index];
                            object = MapUtils.extractAddressDataOfEntryType(((AdbEntry)object2).getAddressData(), ((MapPin)mapFlagArray[n3]).styleIndex == 0 ? 2 : 1);
                            if (object == null || ((AddressData)object).getNavLocation() == null) break block2;
                            navLocation = this.naviMap.getNaviInterface().streamToLocation(((AddressData)object).getNavLocation());
                            Util.setDescriptionOnLocation(navLocation, ((AdbEntry)object2).getCombinedName());
                        }
                        catch (Exception exception) {
                            this.getLogChannel().log(10000, "CtxFreeMap#switchToFollowUpScreen() - Tops : %1", (Throwable)exception);
                        }
                        break;
                    }
                    case 23: {
                        navLocation = this.naviMap.getMapDataContainer().sHomeAddress;
                        break;
                    }
                }
                break;
            }
            case 9: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_PICTURE_DESTINATION");
                navLocation = mapItemSelectionInfo.navLocationPicNavTransformed;
                this.naviMap.getGuiInterface().setMapFollowUpPicNavImage(PicNavNaviInterfaceImpl.getPictureFromPicNavLocationStatic(navLocation));
                bl2 = true;
                break;
            }
            case 8: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_XT_REPRESENTATION");
                navLocation = mapItemSelectionInfo.navLocationXtResolved;
                string = mapItemSelectionInfo.Url;
                bl2 = false;
                break;
            }
            case 4: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_TMC_MESSAGE");
                bl3 = true;
                break;
            }
            case 11: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_XT_REPRESENTATION");
                navLocation = mapItemSelectionInfo.navLocationPoiOnboardGoogle;
                bl2 = false;
                break;
            }
            default: {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - POSITIONINFOTYPE_UNKNOWN");
            }
        }
        this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - loc = %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation != null) {
            int n4;
            Util.setGeoPosFlagOnLocation(navLocation, true);
            if (bl) {
                n4 = 1;
                this.env.getChoiceModel(-668989952).setValue(0);
            } else if (n2 == 8 && !Util.isEmpty(mapItemSelectionInfo.Url)) {
                n4 = 0;
                this.env.getChoiceModel(-668989952).setValue(1);
            } else if (n2 == 4) {
                n4 = 2;
                this.env.getChoiceModel(-668989952).setValue(0);
            } else if (n2 == 5 && !Util.isEmpty(string)) {
                n4 = 0;
                this.env.getChoiceModel(-668989952).setValue(1);
            } else {
                n4 = 0;
                this.env.getChoiceModel(-668989952).setValue(0);
            }
            this.naviMap.getGuiInterface().setOptMenuType(n4);
            if (bl) {
                this.getMap().getNaviInterface().startPoiStackSequence(navLocation);
            } else if (bl2) {
                NavLocation navLocation2 = navLocation;
                object2 = string;
                object = this.getMap().getNaviInterface().createCommandList();
                ((CommandList)object).add(new CtxFreeMap$1(this, "NaviInterface#resolveMapLocation", navLocation2, (String)object2));
                ((CommandList)object).execute("CtxFreeMap#switchToFollowUpScreen()");
            } else if (!bl3) {
                this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - startDestinationDetails");
                this.getMap().getNaviInterface().startDestinationDetails(navLocation);
            }
            if (Util.isPreviewMapPresent(this.env.getFramework())) {
                this.getMap().getMapManager().getPreviewMapHandler().setPreviewMapCallbackHandler(this.getMap().getNaviInterface().getDetailsScreen());
            }
            this.naviMap.getGuiInterface().fireModelEvent(n);
        } else {
            this.getLogChannel().log(-1601830656, "CtxFreeMap#switchToFollowUpScreen() - failed to switch to followup - loc is null!");
            if (bl3) {
                this.naviMap.getGuiInterface().setOptMenuType(2);
                this.env.getChoiceModel(-668989952).setValue(0);
                this.naviMap.getGuiInterface().fireModelEvent(n);
            }
        }
    }

    @Override
    public void increment(int n, int n2) {
        this.getLogChannel().log(-2137614336, "CtxFreeMap#increment() - modelID: %1, steps: %2", (long)n, (long)n2);
        super.increment(n, n2);
        this.cancelTooltipTimer();
        this.getMapSelectionHandler().clear();
        this.getGUI().setFocusedProperty(-1);
    }

    protected void setToolTipDelay(long l) {
        ToolTipTimer toolTipTimer = this.getToolTipTimer();
        if (toolTipTimer != null) {
            toolTipTimer.setDelay(l);
        }
    }

    @Override
    public void updateViewPort(ViewPort viewPort) {
        super.updateViewPort(viewPort);
    }

    protected boolean isForceUseEnterInMapLocation() {
        return this.container.sForceUseEnterInMapLocation;
    }

    protected boolean isForceUseEnterInMapRestoreZoom() {
        return this.container.sForceUseEnterInMapRestoreZoom;
    }

    protected void setForceUseEnterInMapLocation(boolean bl, boolean bl2) {
        this.container.sForceUseEnterInMapLocation = bl;
        this.container.sForceUseEnterInMapRestoreZoom = bl2;
    }

    public int getPOIIndexFromUserFlags() {
        if (this.getMapSelectionHandler().getSelectedValue() == null || this.getMapSelectionHandler().getSelectedValue().posInfo == null) {
            return -1;
        }
        PosInfo posInfo = this.getMapSelectionHandler().getSelectedValue().posInfo;
        MapFlag[] mapFlagArray = this.naviMap.getMapFlagHandler().getPins();
        return MapUtils.searchUserFlag(posInfo, mapFlagArray, this.env);
    }

    @Override
    public PosInfo[] getInfoList() {
        return this.getMap().getMVResponseControl().getInfoList();
    }

    protected void switchToFollowUpScreen() {
        NavLocation navLocation;
        if (this.getMapSelectionHandler().getSelectedValue() != null && (navLocation = this.getMapSelectionHandler().getSelectedValue().getLocationTransformed()) != null && navLocation.longitude != 0 && navLocation.latitude != 0) {
            this.container.sFocusedPosition = navLocation;
        }
        this.getLogChannel().log(-2137614336, "CtxFreeMap#switchToFollowUpScreen() - bUserHasSelectedOnMap = %1, selected = %2", this.bUserHasSelectedOnMap, (Object)this.getMapSelectionHandler().getSelectedValue());
        if (this.bUserHasSelectedOnMap && this.getMapSelectionHandler().getSelectedValue() != null) {
            this.switchToFollowUpScreen(this.selectionModelId);
            this.bUserHasSelectedOnMap = false;
        }
    }

    @Override
    protected void onDDSClicked() {
        this.getLogChannel().log(-2137614336, "CtxFreeMap#onDDSClicked()");
    }

    @Override
    protected void onHKBackClicked() {
        this.getLogChannel().log(-2137614336, "CtxFreeMap#onHKBackClicked()");
    }

    @Override
    public void onSelectionChanged(MapItemSelectionInfo mapItemSelectionInfo) {
        NavLocation navLocation;
        this.getLogChannel().log(-2137614336, "CtxFreeMap#onSelectionChanged() - %1", (Object)mapItemSelectionInfo);
        this.validateMapPosition(true);
        if (mapItemSelectionInfo != null && (navLocation = mapItemSelectionInfo.getLocationTransformed()) != null && navLocation.longitude != 0 && navLocation.latitude != 0) {
            this.container.sFocusedPosition = navLocation;
            this.container.sFocusedZoom = this.getZoomHandler().getZoom();
            this.container.sFocusedRotation = this.getMapRotation();
        }
        if (this.bUserHasSelectedOnMap) {
            this.getLogChannel().log(-2137614336, "CtxFreeMap#onSelectionChanged() - selection detected, switch to follow screen");
            this.switchToFollowUpScreen();
        } else {
            this.getLogChannel().log(-2137614336, "CtxFreeMap#onSelectionChanged() - show tooltip");
            this.getMap().getMapTooltip().show(mapItemSelectionInfo);
            this.getGUI().setFocusedProperty(mapItemSelectionInfo.posInfo.eInfoType);
        }
    }

    protected void validateMapPosition(boolean bl) {
        this.getLogChannel().log(-2137614336, "CtxFreeMap#validateMapPosition( %1 )", bl);
        this.env.getChoiceModel(1562510848).setValue(bl ? 0 : 1);
    }

    @Override
    protected void hideBetterRoutePopup() {
        this.getGUI().hidePopupBetterRouteAvailable();
    }

    protected void updateCrossHairsBoundingBox() {
        Rect rect;
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        if (MapEnv.useTopLeftToCalculateBoundingBox) {
            int n = gUIInterface.getScreenWidth() >> 1;
            int n2 = gUIInterface.getScreenHeight() >> 1;
            rect = new Rect();
            if (Util.isClusterMMI(this.env.getFramework())) {
                rect.kordX = n - 275;
                rect.kordY = n2 - 170 + 15;
                rect.diffX = 550;
                rect.diffY = 340;
            } else {
                rect.kordX = n - 285 - 75 + (this.env.getFramework().getLanguageMgr().isLeftToRightOrientation() ? 0 : gUIInterface.getSideBarWidth());
                rect.kordY = n2 - 170 - 10;
                rect.diffX = 570;
                rect.diffY = 340;
            }
        } else {
            rect = Util.isClusterMMI(this.env.getFramework()) ? new Rect(0, 15, 550, 340) : (this.env.getFramework().getLanguageMgr().isLeftToRightOrientation() ? new Rect(-75, -10, 570, 340) : new Rect(-75 + gUIInterface.getSideBarWidth(), -10, 340, 340));
        }
        this.naviMap.getMVRequest().setScrollByCrossHairsBoundingBox(rect);
    }
}

