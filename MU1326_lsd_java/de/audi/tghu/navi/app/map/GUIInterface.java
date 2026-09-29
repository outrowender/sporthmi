/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.intercommunication.MapLayoutModelColumnConstants;
import de.audi.atip.hmi.intercommunication.RouteSelectionConstants;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.constants.PropertyEnum;
import de.audi.tghu.navi.app.map.gui.GUIEventListener;
import de.audi.tghu.navi.app.map.gui.IMapTooltip;
import de.audi.tghu.navi.app.map.gui.layout.AbstractLayoutProvider;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface GUIInterface
extends GUIEventListener,
RouteSelectionConstants,
MapLayoutModelColumnConstants,
IMapTooltip {
    public static final int SBRS_MAX_COLUMNS;
    public static final int SBRS_MODE_NORMAL;
    public static final int SBRS_MODE_ECO;
    public static final int SBRS_MODE_BYPASS;
    public static final int SIDEBAR_CLOSED;
    public static final int SIDEBAR_ROUTE_SELECTION_NORMAL;
    public static final int SIDEBAR_ROUTE_SELECTION_ECO;
    public static final int SIDEBAR_ROUTE_SELECTION_BYPASS;
    public static final int SIDEBAR_DESTINATION_INDEX_STOPOVER;
    public static final int SIDEBAR_DESTINATION_INDEX_FINALDEST;

    default public void fireModelEvent(int n) {
    }

    default public void controlMixedListNoUpdate(int n) {
    }

    default public void controlMixedList(int n, int n2) {
    }

    default public int getSidebarState() {
    }

    default public void closeSidebarWithoutAnimation() {
    }

    default public void openOrCloseSidebar(int n) {
    }

    default public void setPressed(int n, boolean bl) {
    }

    default public void setCursorForPOIMap(int n) {
    }

    default public void switchToRouteSelectionSidebar(int n) {
    }

    default public void switchToNormalSidebar() {
    }

    default public void showToolTip(String string, int n, int n2, int n3, Rect rect, String string2, boolean bl, boolean bl2, ResourceLocator resourceLocator, int n4) {
    }

    default public MapItemSelectionAction checkToShowToolTipForTMC(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    default public MapItemSelectionAction checkToShowToolTipForTmc(TmcMessage tmcMessage) {
    }

    default public MapItemSelectionAction checkToShowToolTipForNavi(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    default public MapItemSelectionAction checkToShowToolTipForOffroadTour(GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    default public MapItemSelectionAction checkToShowToolTipForPoiOnline(NavLocation navLocation, boolean bl, boolean bl2, boolean bl3, String string) {
    }

    default public MapItemSelectionAction hideToolTip() {
    }

    default public void hideOnlyToolTip() {
    }

    default public void refreshMapRepresentation() {
    }

    default public void drawAlternativeRoutesSelectionUI(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    default public void updateChoiceValue(int n, int n2) {
    }

    default public void enableScrollInfo(boolean bl) {
    }

    default public void setMagnificationLimits(int n, int n2, int n3) {
    }

    default public boolean setPinchZoomLimits(int n, int n2) {
    }

    default public void setMagnification(int n) {
    }

    default public int getMagnificationValue(int n) {
    }

    default public int getMagnificationMaximum(int n) {
    }

    default public int getMagnificationMinimum(int n) {
    }

    default public void setPinchZoomValue(int n) {
    }

    default public void openOrCloseZoomBar(boolean bl) {
    }

    default public boolean isZoomBarOpen() {
    }

    default public void setRotation(int n) {
    }

    default public void enableOrientation(boolean bl) {
    }

    default public void setDestinationIndex(int n) {
    }

    default public void setDestDistanceNoUpdate(boolean bl, long l) {
    }

    default public void clearDestDistance() {
    }

    default public boolean setETA(long l, int n, boolean bl) {
    }

    default public boolean setRTT(long l, boolean bl) {
    }

    default public void updateModelGroup() {
    }

    default public void setHeight(int n) {
    }

    default public void refreshMapType(int n) {
    }

    default public void setSideBarRotaryIcon(int n) {
    }

    default public int getSideBarRotaryIconState() {
    }

    default public void leaveBlockInRouteScreen(boolean bl) {
    }

    default public void setSidebarBlockChoice(int n) {
    }

    default public void setTopBarVisible(boolean bl) {
    }

    default public void setScrollAlongRouteDirection(int n) {
    }

    default public void setScrollAlongRouteDistance(String string) {
    }

    default public void setScrollAlongRouteDirectionAndDistanceVisible(boolean bl) {
    }

    default public int getScreenWidth() {
    }

    default public int getScreenHeight() {
    }

    default public int getMapWidth() {
    }

    default public int getMapHeight() {
    }

    default public int getScreenWidthMapInMap() {
    }

    default public int getScreenHeightMapInMap() {
    }

    default public int getScreenWidthPreviewMap() {
    }

    default public int getScreenHeightPreviewMap() {
    }

    default public Rect getScreenSize() {
    }

    default public Rect getMapSize() {
    }

    default public int getVisibleOffsetXPreviewMap() {
    }

    default public int getVisibleOffsetYPreviewMap() {
    }

    default public int getVisibleWidthPreviewMap() {
    }

    default public int getVisibleHeightPreviewMap() {
    }

    default public int getOffsetCrosshairHeight() {
    }

    default public int getStatusBarHeight() {
    }

    default public int getSideBarWidthOpen() {
    }

    default public int getSideBarWidth() {
    }

    default public int getSideBarWidthAR() {
    }

    default public int getMixedListOffset() {
    }

    default public void setCenterCarButtonVisibility(int n) {
    }

    default public void setOnlineLogoVisible(boolean bl) {
    }

    default public void setOptMenuType(int n) {
    }

    default public void setScrollOnRoutePressed(boolean bl) {
    }

    default public void setMapScrollSidebarPressed(int n, boolean bl) {
    }

    default public boolean getScrollOnRoutePressed() {
    }

    default public boolean getMapScrollSidebarPressed(int n) {
    }

    default public boolean isDemoMode() {
    }

    default public int getCrosshairColorMode() {
    }

    default public void setMapFollowUpPicNavImage(ResourceLocator resourceLocator) {
    }

    default public void setGEGreyOutOption(boolean bl) {
    }

    default public void fireHKBackEvent() {
    }

    default public void showPreviewMap(boolean bl) {
    }

    default public void switchMapScreen(int n) {
    }

    default public int getOffsetOfCarPosition() {
    }

    default public void hidePopupBetterRouteAvailable() {
    }

    default public void updateSetupModels(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void setGoogleSettingVisible(boolean bl) {
    }

    default public int getTopLineHeight() {
    }

    default public void startRouteCalculation() {
    }

    default public int getScreenSmallLeftOffset() {
    }

    default public int getScreenSmallRightOffset() {
    }

    default public void setRouteCriteriaIcons(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9) {
    }

    default public boolean updateTollInfoJP(CalculatedRouteListElement calculatedRouteListElement) {
    }

    default public int getRouteCriteriaBoxLeftOffset() {
    }

    default public void setFocusedProperty(int n) {
    }

    default public int getScreenLayoutAt(int n) {
    }

    default public MapItemSelectionAction checkToShowToolTipForAddressStreet(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    default public MapItemSelectionAction checkToShowToolTipForPoi(MapItemSelectionInfo mapItemSelectionInfo, Point point, boolean bl) {
    }

    default public MapItemSelectionAction checkToShowToolTipForTmc(MapItemSelectionInfo mapItemSelectionInfo, Point point) {
    }

    default public MapItemSelectionAction checkToShowToolTipForNaviWithoutPin(NavLocation navLocation, String string, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl) {
    }

    default public void resetMapModels() {
    }

    default public AbstractLayoutProvider getLayout() {
    }

    default public void setGridMaskVisible(boolean bl) {
    }

    default public IMapPartialPopupHandler getPartialPopupHandler() {
    }

    default public void hideCrosshairs() {
    }

    default public void showCrosshairs(int n, int n2) {
    }

    default public void updateCarPosition() {
    }

    default public void setTrafficNoticeMapActive(boolean bl) {
    }

    default public int getSBRSListModel() {
    }

    default public ListModelApp getRouteInfoBox() {
    }

    default public void updateStateIndicator(PropertyEnum propertyEnum, int n) {
    }

    default public IMapPartialPopupHandler getMapPartialPopupHandler() {
    }

    default public void newPoiPreviewMapSelectionMade(boolean bl) {
    }

    default public void cleanup() {
    }

    default public boolean isUpdateMagnificationModelGroupNeccessary(float f2) {
    }
}

