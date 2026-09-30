/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navigation.previewmap;

import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.atip.interapp.navigation.previewmap.PreviewMapClientIdsConsts;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.tmc.TmcMessage;

public interface IPreviewMap
extends PreviewMapClientIdsConsts {
    public void setPreviewMapCallbackHandler(PreviewMapCallback var1);

    public void hidePreviewMap();

    public void previewMapScreenEntering(int var1, int var2, int var3, int var4);

    public void previewMapScreenEntering(int var1, int var2, int var3, int var4, boolean var5);

    public void previewMapScreenEntering(int var1, int var2);

    public void previewMapScreenLayoutRegister(int var1, int var2, int var3, int var4, int var5);

    public void previewMapScreenApplyItemBeforeShown(int var1, int var2);

    public void previewMapFullScreenShowItemSelectedWithToolTip(int var1);

    public void previewMapFullScreenShowItemSelectedWithToolTipLast();

    public void previewMapFullScreenShowItemInMapWithToolTip();

    public void previewMapFullScreenShowItemInMapWithToolTipWithoutCenteringMapPosition();

    public void previewMapFullScreenHidden();

    public void previewMapScreenExited();

    public void previewMapScreenErrorUpdateByClientWithDelay();

    public void setPreviewAreaAroundCCP(int var1);

    public void setPreviewLocation(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationSds(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationDistant(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationAroundReferencePoint(NavLocation var1, NavLocationWgs84 var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewLocationAroundCCP(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationAroundDestination(NavLocation var1, NavLocationWgs84 var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewDestination(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewAddressBookEntry(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewFavoriteHome(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewState(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationCity(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocations(NavLocation[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewTour(NavLocation[] var1, String var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewLocationsForOperatorCall(NavLocationWgs84[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPOIsOnboard(NavLocation[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPOIsOnboardDistant(NavLocation[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPOIsOnboardAroundCCP(NavLocation[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPOIsOnboardAroundReferencePoint(NavLocation[] var1, NavLocationWgs84 var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewPOIsOnboardAroundDestination(NavLocation[] var1, NavLocationWgs84 var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewRoadSegment(int var1, int var2, int var3, int var4, long var5, long var7, int var9, GuiModelAccessForPreviewMapDetailScreen var10, GuiTooltipInformationContainer var11);

    public void setPreviewTrafficInfoTmcEvent(TmcMessage var1, int var2, boolean var3);

    public void setPreviewTrafficInfoTmcEvents(long[] var1, NavRectangle var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewRoute(boolean var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewRoute(boolean var1, boolean var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewRouteEvent(NavLocation var1, int var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewSDSPicklistEvents(NavLocation[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewTrafficInfoTmcEvent(long var1, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewTrafficInfoTmcEventsForRouteList(NavRectangle var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPredictiveNavigationRoute(NavSegmentID var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPredictiveNavigationRoutes(NavSegmentID[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewRouteOffroad(NavSegmentID var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPoiOnlineAroundCCP(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewPoiOnlineAroundDestination(NavLocation var1, NavLocationWgs84 var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewPoiOnlineAroundReferencePoint(NavLocation var1, NavLocationWgs84 var2, int var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public void setPreviewFavorite(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationConcierge(NavLocationWgs84 var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocationTpeg(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewLocation(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4, boolean var5, String var6);

    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void setPreviewMapNone(int var1);

    public void setPreviewLocationFromTourList(NavLocation var1, int var2, GuiModelAccessForPreviewMapDetailScreen var3, GuiTooltipInformationContainer var4);

    public void callbackByMapContextOnEnteringMapPreview();

    public void callbackByMapContextOnEnteringMapFullscreen();

    public void onScreenFadedOut(int var1);

    public void setStoreFocusForEnterOnce(boolean var1);

    public void refreshLastRequestedState(int var1);

    public void resetEventVisibilities(boolean var1, boolean var2);

    public Rect getGuiPreviewMapLayoutVisibleAreaCurrent();

    public void setPreviewMapPositionRefreshAllowed(boolean var1);

    public int getPreviewMapClientIdLast();

    public void setPreviewMapWaitSyncChoiceModelId(int var1);

    public int getMapContextCorrected(int var1);

    public int getPreviewMapModelHkBackBehavior();

    public void setPreviewMapModelHkBackBehavior(int var1);

    public void cleanUp();

    public boolean isFullscreenPreviewMapVisible();

    public boolean isPreviewMapItemArea();
}

