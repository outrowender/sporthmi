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
    public static final int SBRS_MAX_COLUMNS = 13;
    public static final int SBRS_MODE_NORMAL = 0;
    public static final int SBRS_MODE_ECO = 1;
    public static final int SBRS_MODE_BYPASS = 2;
    public static final int SIDEBAR_CLOSED = 0;
    public static final int SIDEBAR_ROUTE_SELECTION_NORMAL = 1;
    public static final int SIDEBAR_ROUTE_SELECTION_ECO = 2;
    public static final int SIDEBAR_ROUTE_SELECTION_BYPASS = 3;
    public static final int SIDEBAR_DESTINATION_INDEX_STOPOVER = 1;
    public static final int SIDEBAR_DESTINATION_INDEX_FINALDEST = 0;

    public void fireModelEvent(int var1);

    public void controlMixedListNoUpdate(int var1);

    public void controlMixedList(int var1, int var2);

    public int getSidebarState();

    public void closeSidebarWithoutAnimation();

    public void openOrCloseSidebar(int var1);

    public void setPressed(int var1, boolean var2);

    public void setCursorForPOIMap(int var1);

    public void switchToRouteSelectionSidebar(int var1);

    public void switchToNormalSidebar();

    public void showToolTip(String var1, int var2, int var3, int var4, Rect var5, String var6, boolean var7, boolean var8, ResourceLocator var9, int var10);

    public MapItemSelectionAction checkToShowToolTipForTMC(MapItemSelectionInfo var1);

    public MapItemSelectionAction checkToShowToolTipForTmc(TmcMessage var1);

    public MapItemSelectionAction checkToShowToolTipForNavi(NavLocation var1, GuiTooltipInformationContainer var2);

    public MapItemSelectionAction checkToShowToolTipForOffroadTour(GuiTooltipInformationContainer var1);

    public MapItemSelectionAction checkToShowToolTipForPoiOnline(NavLocation var1, boolean var2, boolean var3, boolean var4, String var5);

    public MapItemSelectionAction hideToolTip();

    public void hideOnlyToolTip();

    public void refreshMapRepresentation();

    public void drawAlternativeRoutesSelectionUI(CalculatedRouteListElement[] var1);

    public void updateChoiceValue(int var1, int var2);

    public void enableScrollInfo(boolean var1);

    public void setMagnificationLimits(int var1, int var2, int var3);

    public boolean setPinchZoomLimits(int var1, int var2);

    public void setMagnification(int var1);

    public int getMagnificationValue(int var1);

    public int getMagnificationMaximum(int var1);

    public int getMagnificationMinimum(int var1);

    public void setPinchZoomValue(int var1);

    public void openOrCloseZoomBar(boolean var1);

    public boolean isZoomBarOpen();

    public void setRotation(int var1);

    public void enableOrientation(boolean var1);

    public void setDestinationIndex(int var1);

    public void setDestDistanceNoUpdate(boolean var1, long var2);

    public void clearDestDistance();

    public boolean setETA(long var1, int var3, boolean var4);

    public boolean setRTT(long var1, boolean var3);

    public void updateModelGroup();

    public void setHeight(int var1);

    public void refreshMapType(int var1);

    public void setSideBarRotaryIcon(int var1);

    public int getSideBarRotaryIconState();

    public void leaveBlockInRouteScreen(boolean var1);

    public void setSidebarBlockChoice(int var1);

    public void setTopBarVisible(boolean var1);

    public void setScrollAlongRouteDirection(int var1);

    public void setScrollAlongRouteDistance(String var1);

    public void setScrollAlongRouteDirectionAndDistanceVisible(boolean var1);

    public int getScreenWidth();

    public int getScreenHeight();

    public int getMapWidth();

    public int getMapHeight();

    public int getScreenWidthMapInMap();

    public int getScreenHeightMapInMap();

    public int getScreenWidthPreviewMap();

    public int getScreenHeightPreviewMap();

    public Rect getScreenSize();

    public Rect getMapSize();

    public int getVisibleOffsetXPreviewMap();

    public int getVisibleOffsetYPreviewMap();

    public int getVisibleWidthPreviewMap();

    public int getVisibleHeightPreviewMap();

    public int getOffsetCrosshairHeight();

    public int getStatusBarHeight();

    public int getSideBarWidthOpen();

    public int getSideBarWidth();

    public int getSideBarWidthAR();

    public int getMixedListOffset();

    public void setCenterCarButtonVisibility(int var1);

    public void setOnlineLogoVisible(boolean var1);

    public void setOptMenuType(int var1);

    public void setScrollOnRoutePressed(boolean var1);

    public void setMapScrollSidebarPressed(int var1, boolean var2);

    public boolean getScrollOnRoutePressed();

    public boolean getMapScrollSidebarPressed(int var1);

    public boolean isDemoMode();

    public int getCrosshairColorMode();

    public void setMapFollowUpPicNavImage(ResourceLocator var1);

    public void setGEGreyOutOption(boolean var1);

    public void fireHKBackEvent();

    public void showPreviewMap(boolean var1);

    public void switchMapScreen(int var1);

    public int getOffsetOfCarPosition();

    public void hidePopupBetterRouteAvailable();

    public void updateSetupModels(int var1, int var2, int var3, int var4, int var5, int var6);

    public void setGoogleSettingVisible(boolean var1);

    public int getTopLineHeight();

    public void startRouteCalculation();

    public int getScreenSmallLeftOffset();

    public int getScreenSmallRightOffset();

    public void setRouteCriteriaIcons(int var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10);

    public boolean updateTollInfoJP(CalculatedRouteListElement var1);

    public int getRouteCriteriaBoxLeftOffset();

    public void setFocusedProperty(int var1);

    public int getScreenLayoutAt(int var1);

    public MapItemSelectionAction checkToShowToolTipForAddressStreet(MapItemSelectionInfo var1, Point var2);

    public MapItemSelectionAction checkToShowToolTipForPoi(MapItemSelectionInfo var1, Point var2, boolean var3);

    public MapItemSelectionAction checkToShowToolTipForTmc(MapItemSelectionInfo var1, Point var2);

    public MapItemSelectionAction checkToShowToolTipForNaviWithoutPin(NavLocation var1, String var2, GuiTooltipInformationContainer var3, boolean var4);

    public void resetMapModels();

    public AbstractLayoutProvider getLayout();

    public void setGridMaskVisible(boolean var1);

    public IMapPartialPopupHandler getPartialPopupHandler();

    public void hideCrosshairs();

    public void showCrosshairs(int var1, int var2);

    public void updateCarPosition();

    public void setTrafficNoticeMapActive(boolean var1);

    public int getSBRSListModel();

    public ListModelApp getRouteInfoBox();

    public void updateStateIndicator(PropertyEnum var1, int var2);

    public IMapPartialPopupHandler getMapPartialPopupHandler();

    public void newPoiPreviewMapSelectionMade(boolean var1);

    public void cleanup();

    public boolean isUpdateMagnificationModelGroupNeccessary(float var1);
}

