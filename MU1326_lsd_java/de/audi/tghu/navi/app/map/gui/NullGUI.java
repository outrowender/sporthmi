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
        this.getLogger().log(-1601830656, "%1#%2( ) - unexpected call.", (Object)this.getName(), (Object)string);
    }

    protected void fixme(String string) {
        this.getLogger().log(-2137614336, "%1#%2( ) - FIXME.", (Object)this.getName(), (Object)string);
    }

    @Override
    public void fireModelEvent(int n) {
        this.warn("fireModelEvent");
    }

    @Override
    public void controlMixedListNoUpdate(int n) {
        this.warn("controlMixedListNoUpdate");
    }

    @Override
    public void controlMixedList(int n, int n2) {
        this.warn("controlMixedList");
    }

    @Override
    public int getSidebarState() {
        this.warn("getSidebarState");
        return 0;
    }

    @Override
    public void closeSidebarWithoutAnimation() {
        this.warn("closeSidebarWithoutAnimation");
    }

    @Override
    public void openOrCloseSidebar(int n) {
        this.warn("openOrCloseSidebar");
    }

    @Override
    public void setPressed(int n, boolean bl) {
        this.warn("setPressed");
    }

    @Override
    public void setCursorForPOIMap(int n) {
        this.warn("setCursorForPOIMap");
    }

    @Override
    public void switchToRouteSelectionSidebar(int n) {
        this.warn("switchToRouteSelectionSidebar");
    }

    @Override
    public void switchToNormalSidebar() {
        this.warn("switchToNormalSidebar");
    }

    @Override
    public void showToolTip(String string, int n, int n2, int n3, Rect rect, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator, int n4) {
        this.warn("showToolTip");
    }

    @Override
    public MapItemSelectionAction hideToolTip() {
        this.warn("hideToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void refreshMapRepresentation() {
        this.warn("refreshMapRepresentation");
    }

    @Override
    public void drawAlternativeRoutesSelectionUI(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.warn("setAltRouteParameters");
    }

    @Override
    public void updateChoiceValue(int n, int n2) {
        this.warn("updateChoiceValue");
    }

    public void enablePOIInfo(boolean bl) {
        this.warn("enablePOIInfo");
    }

    @Override
    public void enableScrollInfo(boolean bl) {
        this.warn("enableScrollInfo");
    }

    @Override
    public void setMagnificationLimits(int n, int n2, int n3) {
        this.fixme("setMagnificationLimits");
        this.iMagnificantMin = n;
        this.iMagnificantMax = n2;
        this.iMagnificantVal = n3;
    }

    @Override
    public void setMagnification(int n) {
        this.fixme("setMagnification");
        this.iMagnificantVal = n;
    }

    @Override
    public int getMagnificationValue(int n) {
        this.fixme("getMagnificationValue");
        return this.iMagnificantVal;
    }

    @Override
    public int getMagnificationMaximum(int n) {
        this.fixme("getMagnificationMaximum");
        return this.iMagnificantMax;
    }

    @Override
    public int getMagnificationMinimum(int n) {
        this.fixme("getMagnificationMinimum");
        return this.iMagnificantMin;
    }

    @Override
    public void openOrCloseZoomBar(boolean bl) {
        this.warn("openOrCloseZoomBar");
    }

    @Override
    public boolean isZoomBarOpen() {
        this.warn("isZoomBarOpen");
        return false;
    }

    @Override
    public void setRotation(int n) {
        this.warn("setRotation");
    }

    @Override
    public void enableOrientation(boolean bl) {
        this.warn("enableOrientation");
    }

    @Override
    public void setDestDistanceNoUpdate(boolean bl, long l) {
        this.warn("setDestDistanceNoUpdate");
    }

    @Override
    public void clearDestDistance() {
        this.warn("clearDestDistance");
    }

    @Override
    public boolean setETA(long l, int n, boolean bl) {
        this.warn("setETA");
        return false;
    }

    @Override
    public boolean setRTT(long l, boolean bl) {
        this.warn("setRTT");
        return false;
    }

    @Override
    public void updateModelGroup() {
        this.warn("updateModelGroup");
    }

    @Override
    public void setHeight(int n) {
        this.warn("setHeight");
    }

    @Override
    public void refreshMapType(int n) {
        this.warn("setMapType");
    }

    @Override
    public void setSideBarRotaryIcon(int n) {
        this.warn("setSideBarRotaryIcon");
    }

    @Override
    public int getSideBarRotaryIconState() {
        this.warn("getSideBarRotaryIconState");
        return 0;
    }

    @Override
    public void leaveBlockInRouteScreen(boolean bl) {
        this.warn("leaveBlockInRouteScreen");
    }

    @Override
    public void setSidebarBlockChoice(int n) {
        this.warn("setSidebarBlockChoice");
    }

    @Override
    public void setTopBarVisible(boolean bl) {
        this.warn("setTopBarVisible");
    }

    @Override
    public void setScrollAlongRouteDirection(int n) {
        this.warn("setScrollAlongRouteDirection");
    }

    @Override
    public void setScrollAlongRouteDistance(String string) {
        this.warn("setScrollAlongRouteDistance");
    }

    @Override
    public void setScrollAlongRouteDirectionAndDistanceVisible(boolean bl) {
        this.warn("setScrollAlongRouteDirectionAndDistanceVisible");
    }

    @Override
    public int getScreenWidth() {
        this.warn("getScreenWidth");
        return 0;
    }

    @Override
    public int getScreenHeight() {
        this.warn("getScreenHeight");
        return 0;
    }

    @Override
    public int getMapWidth() {
        this.warn("getMapWidth");
        return 0;
    }

    @Override
    public int getMapHeight() {
        this.warn("getMapHeight");
        return 0;
    }

    @Override
    public int getStatusBarHeight() {
        this.warn("getStatusBarHeight");
        return 0;
    }

    @Override
    public int getSideBarWidthOpen() {
        this.warn("getSideBarWidthOpen");
        return 0;
    }

    @Override
    public int getSideBarWidth() {
        this.warn("getSideBarWidth");
        return 0;
    }

    @Override
    public int getSideBarWidthAR() {
        this.warn("getSideBarWidthAR");
        return 0;
    }

    @Override
    public int getMixedListOffset() {
        this.warn("setRotation");
        return 0;
    }

    @Override
    public void setCenterCarButtonVisibility(int n) {
        this.warn("setCenterCarButtonVisibility");
    }

    @Override
    public void setOnlineLogoVisible(boolean bl) {
        this.warn("setOnlineLogoVisible");
    }

    @Override
    public void setOptMenuType(int n) {
        this.warn("setOptMenuType");
    }

    @Override
    public void setScrollOnRoutePressed(boolean bl) {
        this.warn("setScrollOnRoutePressed");
    }

    @Override
    public void setMapScrollSidebarPressed(int n, boolean bl) {
        this.warn("setMapScrollSidebarPressed");
    }

    @Override
    public boolean getScrollOnRoutePressed() {
        this.warn("getScrollOnRoutePressed");
        return false;
    }

    @Override
    public boolean getMapScrollSidebarPressed(int n) {
        this.warn("getMapScrollSidebarPressed");
        return false;
    }

    @Override
    public boolean isDemoMode() {
        this.warn("isDemoMode");
        return false;
    }

    @Override
    public int getCrosshairColorMode() {
        this.warn("getCrosshairColorMode");
        return 0;
    }

    @Override
    public void setMapFollowUpPicNavImage(ResourceLocator resourceLocator) {
        this.warn("setMapFollowUpPicNavImage");
    }

    @Override
    public void setGEGreyOutOption(boolean bl) {
        this.warn("setGEGreyOutOption");
    }

    @Override
    public boolean setPinchZoomLimits(int n, int n2) {
        this.warn("setPinchZoomLimits");
        return false;
    }

    @Override
    public void setPinchZoomValue(int n) {
    }

    @Override
    protected String getName() {
        return "NullGUI";
    }

    @Override
    public void fireHKBackEvent() {
        this.warn("fireHKBackEvent");
    }

    @Override
    public void switchMapScreen(int n) {
    }

    @Override
    public void hidePopupBetterRouteAvailable() {
        this.warn("hidePopupBetterRouteAvailable");
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForTMC(MapItemSelectionInfo mapItemSelectionInfo) {
        this.warn("showToolTipTMC");
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void updateSetupModels(int n, int n2, int n3, int n4, int n5, int n6) {
        this.warn("updateSetupModels");
    }

    @Override
    public void setGoogleSettingVisible(boolean bl) {
        this.warn("setGoogleSettingVisible");
    }

    @Override
    public int getTopLineHeight() {
        this.warn("getTopLineHeight");
        return 0;
    }

    @Override
    public void startRouteCalculation() {
    }

    @Override
    public int getScreenSmallLeftOffset() {
        return 0;
    }

    @Override
    public int getScreenSmallRightOffset() {
        return 0;
    }

    @Override
    public void setRouteCriteriaIcons(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
        this.warn("setRouteCriteriaIcons");
    }

    @Override
    public boolean updateTollInfoJP(CalculatedRouteListElement calculatedRouteListElement) {
        this.warn("updateTollInfoJP");
        return false;
    }

    @Override
    public int getRouteCriteriaBoxLeftOffset() {
        return 0;
    }

    @Override
    public void setFocusedProperty(int n) {
    }

    @Override
    public int getScreenLayoutAt(int n) {
        return 0;
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForAddressStreet(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        this.warn("showStreetToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForPoi(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
        this.warn("showPOIToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForTmc(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
        this.warn("showTMCToolTip");
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void setDestinationIndex(int n) {
    }

    @Override
    public void resetMapModels() {
        this.warn("resetMapModels");
    }

    @Override
    public AbstractLayoutProvider getLayout() {
        this.warn("getLayout");
        return null;
    }

    @Override
    public IMapPartialPopupHandler getPartialPopupHandler() {
        return new EmptyMapPartialPopupHandler(this.getLogger());
    }

    public void setMapSetupAutozoomGreyOut(boolean bl) {
    }

    public void setMapSetup3dMapGreyOut(boolean bl) {
    }

    @Override
    public void resolvePicNavLocation(int n, int n2, ResourceLocator resourceLocator) {
    }

    @Override
    public void show(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    @Override
    public MapItemSelectionAction checkToShow(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl, boolean bl2) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void showToolTip(String string, int n, int n2, PosInfo posInfo, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator) {
    }

    @Override
    public ToolTipTimer getTooltipTimer() {
        return null;
    }

    @Override
    public void hideCrosshairs() {
        this.warn("hideCrosshairs");
    }

    @Override
    public void showCrosshairs(int n, int n2) {
        this.warn("showCrosshairs");
    }

    @Override
    public void setTrafficNoticeMapActive(boolean bl) {
        this.warn("setTrafficNoticeMapActive");
    }

    @Override
    public void show(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    public void showPreviewMapEntry(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
    }

    @Override
    public ListModelApp getRouteInfoBox() {
        return null;
    }

    @Override
    public void updateStateIndicator(PropertyEnum propertyEnum, int n) {
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForTmc(TmcMessage tmcMessage) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public void hideOnlyToolTip() {
    }

    @Override
    public void newPoiPreviewMapSelectionMade(boolean bl) {
        this.warn("newPoiPreviewMapSelectionMade");
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForNavi(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForNaviWithoutPin(NavLocation navLocation, String string, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl) {
        return new MapItemSelectionActionDoNothing();
    }

    @Override
    public boolean isUpdateMagnificationModelGroupNeccessary(float f2) {
        return false;
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForOffroadTour(GuiTooltipInformationContainer guiTooltipInformationContainer) {
        return null;
    }

    @Override
    public MapItemSelectionAction checkToShowToolTipForPoiOnline(NavLocation navLocation, boolean bl, boolean bl2, boolean bl3, String string) {
        return null;
    }
}

