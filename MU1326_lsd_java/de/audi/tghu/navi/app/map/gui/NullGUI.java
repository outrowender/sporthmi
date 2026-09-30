/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.constants.PropertyEnum;
import de.audi.tghu.navi.app.map.gui.AbstractGUI;
import de.audi.tghu.navi.app.map.gui.EmptyMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.gui.ToolTipTimer;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionActionDoNothing;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class NullGUI
extends AbstractGUI {
    private int iMagnificantMin = 0;
    private int iMagnificantMax = 0;
    private int iMagnificantVal = 0;

    public NullGUI(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(abstractMap, navigationEnv, abstractMap.getMapGUILogChannel());
    }

    protected void warn(String string) {
        this.getLogger().log(100000, "%1#%2( ) - unexpected call.", (Object)this.getName(), (Object)string);
    }

    protected void fixme(String string) {
        this.getLogger().log(10000000, "%1#%2( ) - FIXME.", (Object)this.getName(), (Object)string);
    }

    public void fireModelEvent(int n) {
        this.warn("fireModelEvent");
    }

    public void controlMixedListNoUpdate(int n) {
        this.warn("controlMixedListNoUpdate");
    }

    public void controlMixedList(int n, int n2) {
        this.warn("controlMixedList");
    }

    public int getSidebarState() {
        this.warn("getSidebarState");
        return 0;
    }

    public void closeSidebarWithoutAnimation() {
        this.warn("closeSidebarWithoutAnimation");
    }

    public void openOrCloseSidebar(int n) {
        this.warn("openOrCloseSidebar");
    }

    public void setPressed(int n, boolean bl) {
        this.warn("setPressed");
    }

    public void setCursorForPOIMap(int n) {
        this.warn("setCursorForPOIMap");
    }

    public void switchToRouteSelectionSidebar(int n) {
        this.warn("switchToRouteSelectionSidebar");
    }

    public void switchToNormalSidebar() {
        this.warn("switchToNormalSidebar");
    }

    public void showToolTip(String string, int n, int n2, int n3, Rect rect, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator, int n4) {
        this.warn("showToolTip");
    }

    public MapItemSelectionAction hideToolTip() {
        this.warn("hideToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    public void refreshMapRepresentation() {
        this.warn("refreshMapRepresentation");
    }

    public void drawAlternativeRoutesSelectionUI(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.warn("setAltRouteParameters");
    }

    public void updateChoiceValue(int n, int n2) {
        this.warn("updateChoiceValue");
    }

    public void enablePOIInfo(boolean bl) {
        this.warn("enablePOIInfo");
    }

    public void enableScrollInfo(boolean bl) {
        this.warn("enableScrollInfo");
    }

    public void setMagnificationLimits(int n, int n2, int n3) {
        this.fixme("setMagnificationLimits");
        this.iMagnificantMin = n;
        this.iMagnificantMax = n2;
        this.iMagnificantVal = n3;
    }

    public void setMagnification(int n) {
        this.fixme("setMagnification");
        this.iMagnificantVal = n;
    }

    public int getMagnificationValue(int n) {
        this.fixme("getMagnificationValue");
        return this.iMagnificantVal;
    }

    public int getMagnificationMaximum(int n) {
        this.fixme("getMagnificationMaximum");
        return this.iMagnificantMax;
    }

    public int getMagnificationMinimum(int n) {
        this.fixme("getMagnificationMinimum");
        return this.iMagnificantMin;
    }

    public void openOrCloseZoomBar(boolean bl) {
        this.warn("openOrCloseZoomBar");
    }

    public boolean isZoomBarOpen() {
        this.warn("isZoomBarOpen");
        return false;
    }

    public void setRotation(int n) {
        this.warn("setRotation");
    }

    public void enableOrientation(boolean bl) {
        this.warn("enableOrientation");
    }

    public void setDestDistanceNoUpdate(boolean bl, long l) {
        this.warn("setDestDistanceNoUpdate");
    }

    public void clearDestDistance() {
        this.warn("clearDestDistance");
    }

    public boolean setETA(long l, int n, boolean bl) {
        this.warn("setETA");
        return false;
    }

    public boolean setRTT(long l, boolean bl) {
        this.warn("setRTT");
        return false;
    }

    public void updateModelGroup() {
        this.warn("updateModelGroup");
    }

    public void setHeight(int n) {
        this.warn("setHeight");
    }

    public void refreshMapType(int n) {
        this.warn("setMapType");
    }

    public void setSideBarRotaryIcon(int n) {
        this.warn("setSideBarRotaryIcon");
    }

    public int getSideBarRotaryIconState() {
        this.warn("getSideBarRotaryIconState");
        return 0;
    }

    public void leaveBlockInRouteScreen(boolean bl) {
        this.warn("leaveBlockInRouteScreen");
    }

    public void setSidebarBlockChoice(int n) {
        this.warn("setSidebarBlockChoice");
    }

    public void setTopBarVisible(boolean bl) {
        this.warn("setTopBarVisible");
    }

    public void setScrollAlongRouteDirection(int n) {
        this.warn("setScrollAlongRouteDirection");
    }

    public void setScrollAlongRouteDistance(String string) {
        this.warn("setScrollAlongRouteDistance");
    }

    public void setScrollAlongRouteDirectionAndDistanceVisible(boolean bl) {
        this.warn("setScrollAlongRouteDirectionAndDistanceVisible");
    }

    public int getScreenWidth() {
        this.warn("getScreenWidth");
        return 0;
    }

    public int getScreenHeight() {
        this.warn("getScreenHeight");
        return 0;
    }

    public int getMapWidth() {
        this.warn("getMapWidth");
        return 0;
    }

    public int getMapHeight() {
        this.warn("getMapHeight");
        return 0;
    }

    public int getStatusBarHeight() {
        this.warn("getStatusBarHeight");
        return 0;
    }

    public int getSideBarWidthOpen() {
        this.warn("getSideBarWidthOpen");
        return 0;
    }

    public int getSideBarWidth() {
        this.warn("getSideBarWidth");
        return 0;
    }

    public int getSideBarWidthAR() {
        this.warn("getSideBarWidthAR");
        return 0;
    }

    public int getMixedListOffset() {
        this.warn("setRotation");
        return 0;
    }

    public void setCenterCarButtonVisibility(int n) {
        this.warn("setCenterCarButtonVisibility");
    }

    public void setOnlineLogoVisible(boolean bl) {
        this.warn("setOnlineLogoVisible");
    }

    public void setOptMenuType(int n) {
        this.warn("setOptMenuType");
    }

    public void setScrollOnRoutePressed(boolean bl) {
        this.warn("setScrollOnRoutePressed");
    }

    public void setMapScrollSidebarPressed(int n, boolean bl) {
        this.warn("setMapScrollSidebarPressed");
    }

    public boolean getScrollOnRoutePressed() {
        this.warn("getScrollOnRoutePressed");
        return false;
    }

    public boolean getMapScrollSidebarPressed(int n) {
        this.warn("getMapScrollSidebarPressed");
        return false;
    }

    public boolean isDemoMode() {
        this.warn("isDemoMode");
        return false;
    }

    public int getCrosshairColorMode() {
        this.warn("getCrosshairColorMode");
        return 0;
    }

    public void setMapFollowUpPicNavImage(ResourceLocator resourceLocator) {
        this.warn("setMapFollowUpPicNavImage");
    }

    public void setGEGreyOutOption(boolean bl) {
        this.warn("setGEGreyOutOption");
    }

    public boolean setPinchZoomLimits(int n, int n2) {
        this.warn("setPinchZoomLimits");
        return false;
    }

    public void setPinchZoomValue(int n) {
    }

    protected String getName() {
        return "NullGUI";
    }

    public void fireHKBackEvent() {
        this.warn("fireHKBackEvent");
    }

    public void switchMapScreen(int n) {
    }

    public void hidePopupBetterRouteAvailable() {
        this.warn("hidePopupBetterRouteAvailable");
    }

    public MapItemSelectionAction checkToShowToolTipForTMC(MapItemSelectionInfo mapItemSelectionInfo) {
        this.warn("showToolTipTMC");
        return new MapItemSelectionActionDoNothing();
    }

    public void updateSetupModels(int n, int n2, int n3, int n4, int n5, int n6) {
        this.warn("updateSetupModels");
    }

    public void setGoogleSettingVisible(boolean bl) {
        this.warn("setGoogleSettingVisible");
    }

    public int getTopLineHeight() {
        this.warn("getTopLineHeight");
        return 0;
    }

    public void startRouteCalculation() {
    }

    public int getScreenSmallLeftOffset() {
        return 0;
    }

    public int getScreenSmallRightOffset() {
        return 0;
    }

    public void setRouteCriteriaIcons(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.warn("setRouteCriteriaIcons");
    }

    public boolean updateTollInfoJP(CalculatedRouteListElement calculatedRouteListElement) {
        this.warn("updateTollInfoJP");
        return false;
    }

    public int getRouteCriteriaBoxLeftOffset() {
        return 0;
    }

    public void setFocusedProperty(int n) {
    }

    public int getScreenLayoutAt(int n) {
        return 0;
    }

    public MapItemSelectionAction checkToShowToolTipForAddressStreet(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        this.warn("showStreetToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForPoi(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
        this.warn("showPOIToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForTmc(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        this.warn("showTMCToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    public void setDestinationIndex(int n) {
    }

    public void resetMapModels() {
        this.warn("resetMapModels");
    }

    public AbstractLayoutProvider getLayout() {
        this.warn("getLayout");
        return null;
    }

    public IMapPartialPopupHandler getPartialPopupHandler() {
        return new EmptyMapPartialPopupHandler(this.getLogger());
    }

    public void setMapSetupAutozoomGreyOut(boolean bl) {
    }

    public void setMapSetup3dMapGreyOut(boolean bl) {
    }

    public void resolvePicNavLocation(int n, int n2, ResourceLocator resourceLocator) {
    }

    public void show(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    public MapItemSelectionAction checkToShow(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl, boolean bl2) {
        return new MapItemSelectionActionDoNothing();
    }

    public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
    }

    public ToolTipTimer getTooltipTimer() {
        return null;
    }

    public void hideCrosshairs() {
        this.warn("hideCrosshairs");
    }

    public void showCrosshairs(int n, int n2) {
        this.warn("showCrosshairs");
    }

    public void setTrafficNoticeMapActive(boolean bl) {
        this.warn("setTrafficNoticeMapActive");
    }

    public void show(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    public void showPreviewMapEntry(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
    }

    public ListModelApp getRouteInfoBox() {
        return null;
    }

    public void updateStateIndicator(PropertyEnum propertyEnum, int n) {
    }

    public MapItemSelectionAction checkToShowToolTipForTmc(TmcMessage tmcMessage) {
        return new MapItemSelectionActionDoNothing();
    }

    public void hideOnlyToolTip() {
    }

    public void newPoiPreviewMapSelectionMade(boolean bl) {
        this.warn("newPoiPreviewMapSelectionMade");
    }

    public MapItemSelectionAction checkToShowToolTipForNavi(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return new MapItemSelectionActionDoNothing();
    }

    public MapItemSelectionAction checkToShowToolTipForNaviWithoutPin(NavLocation navLocation, String string, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl) {
        return new MapItemSelectionActionDoNothing();
    }

    public boolean isUpdateMagnificationModelGroupNeccessary(float f2) {
        return false;
    }

    public MapItemSelectionAction checkToShowToolTipForOffroadTour(GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return null;
    }

    public MapItemSelectionAction checkToShowToolTipForPoiOnline(NavLocation navLocation, boolean bl, boolean bl2, boolean bl3, String string) {
        return null;
    }
}

