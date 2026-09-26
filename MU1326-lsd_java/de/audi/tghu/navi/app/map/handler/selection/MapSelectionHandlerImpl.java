/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.IPosInfoParser;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler$IMapSelectionListener;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl$1;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl$2;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl$3;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl$4;
import de.audi.tghu.navi.app.map.impl.PosInfoParser;
import de.audi.tghu.navi.app.map.impl.PosInfoParser$PosInfoParserEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.tmc.TmcMessage;

public class MapSelectionHandlerImpl
implements MapSelectionHandler {
    private LogChannel logger;
    protected AbstractMap naviMap;
    private final List selectionListeners = new ArrayList();
    protected final PosInfoParser$PosInfoParserEnv env;
    protected final IPosInfoParser posInfoParser;
    private MapItemSelectionInfo selectedValue = null;
    private Object selectionMutex = new Object();
    protected final Timer requestDelayer;
    protected volatile boolean canceled = true;

    public MapSelectionHandlerImpl(AbstractMap abstractMap, PosInfoParser$PosInfoParserEnv posInfoParser$PosInfoParserEnv) {
        this.naviMap = abstractMap;
        this.logger = abstractMap.getMapLogChannel();
        this.env = posInfoParser$PosInfoParserEnv;
        this.posInfoParser = new PosInfoParser(this.logger, posInfoParser$PosInfoParserEnv);
        this.requestDelayer = new Timer("RequestDelayer", 0, true, new MapSelectionHandlerImpl$1(this));
    }

    protected LogChannel getLogger() {
        return this.logger;
    }

    @Override
    public void clear() {
        this.posInfoParser.setActiveInfoListIndex(-1);
    }

    @Override
    public void addListener(MapSelectionHandler$IMapSelectionListener mapSelectionHandler$IMapSelectionListener) {
        if (!this.selectionListeners.isEmpty()) {
            this.selectionListeners.clear();
        }
        this.selectionListeners.add(mapSelectionHandler$IMapSelectionListener);
    }

    public PosInfo getSelectedPosInfo() {
        return this.posInfoParser.getPosInfo();
    }

    @Override
    public MapPin getSelectedPin() {
        return this.posInfoParser.getMapPin();
    }

    @Override
    public MapItemSelectionInfo getSelectedValue() {
        return this.selectedValue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cancelSelection() {
        Object object = this.selectionMutex;
        synchronized (object) {
            this.canceled = true;
            this.requestDelayer.cancel();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setSelectedValue(MapItemSelectionInfo mapItemSelectionInfo) {
        Object object = this.selectionMutex;
        synchronized (object) {
            if (this.selectedValue != null) {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#setSelectedValue() - remove not handled selection event");
            } else {
                this.getLogger().log(14808325, "MapSelectionHandlerImpl#setSelectedValue()");
            }
            this.selectedValue = mapItemSelectionInfo;
        }
    }

    @Override
    public void requestInfoForPosition(boolean bl, boolean bl2) {
        this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#requestInfoForPosition( %1 ) - is selection : %2", bl, bl2);
        if (bl2) {
            this.requestDelayer.cancel();
            this.setSelectedValue(null);
            this.canceled = false;
            this.naviMap.getMVRequest().getInfoForPosition();
        } else {
            this.requestDelayer.restart();
        }
    }

    @Override
    public void requestInfoForScreenPosition(int n, Point point) {
        this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#requestInfoForScreenPosition() - should be overridden!");
    }

    @Override
    public int getActiveInfoListIndex() {
        return this.posInfoParser.getActiveInfoListIndex();
    }

    @Override
    public void updateInfoForPosition(PosInfo[] posInfoArray, boolean bl) {
        if (this.canceled) {
            this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - selection was canceled");
            return;
        }
        this.resolve(posInfoArray, bl);
    }

    protected void resolve(PosInfo[] posInfoArray, boolean bl) {
        int n;
        int n2 = posInfoArray != null ? posInfoArray.length : 0;
        this.getLogger().log(1078071040, "MapSelectionHandlerImpl#updateInfoForPosition(): PosInfo.length = %2, isJoystickIdle = %1", bl, (long)n2);
        for (n = 0; n < n2; ++n) {
            this.getLogger().log(14808325, "MapSelectionHandlerImpl#updateInfoForPosition(): PosInfo[%2]: %1", (Object)posInfoArray[n], (long)n);
        }
        n = this.posInfoParser.parseInfoList(posInfoArray);
        PosInfo posInfo = this.posInfoParser.getPosInfo();
        if (posInfo == null) {
            this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateInfoForPosition(): no selected PosInfo");
            return;
        }
        MapItemSelectionInfo mapItemSelectionInfo = MapItemSelectionInfo.create(posInfo, this.getLogger());
        this.setSelectedValue(mapItemSelectionInfo);
        switch (n) {
            case 1: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - resolve online POI.");
                if (this.posInfoParser.getMapPin() != null) {
                    this.naviMap.getNaviInterface().requestOnlineResultFlagDetails(this.posInfoParser.getMapPin().index, this.env.getContextDependedOnlineResult(), this.naviMap);
                    break;
                }
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - getUserFlag() = null");
                break;
            }
            case 3: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - resolve pic nav.");
                this.fireAfterResolvePicNavLocation(mapItemSelectionInfo);
                break;
            }
            case 2: {
                int n3 = (int)posInfo.getObjectId();
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - request TMC message %1", (long)n3);
                this.naviMap.getNaviInterface().requestTmcMessage(n3);
                break;
            }
            case 4: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - resolve XT.");
                this.fireAfterResolveXTRepresentation(mapItemSelectionInfo);
                break;
            }
            case 5: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - resolve Google onboard POI.");
                this.fireAfterResolveGoogleOnboardPOI(mapItemSelectionInfo);
                break;
            }
            case 6: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - resolve favorite.");
                mapItemSelectionInfo.navLocationAdditionalInfo = this.getNavLocationForFavorite(posInfo);
                if (mapItemSelectionInfo.navLocationAdditionalInfo == null) {
                    this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateInfoForPosition() - can not get NavLocation for this favorite");
                } else if (this.naviMap.getSatellitemapsManager().isSatelliteMapActive()) {
                    this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateInfoForPosition() - remove url when on GE");
                    Util.removeUrlFromMmiInternalData(mapItemSelectionInfo.navLocationAdditionalInfo);
                }
                mapItemSelectionInfo.textDescriptionSingleLine = this.posInfoParser.getDescription();
                mapItemSelectionInfo.Url = this.posInfoParser.getUrl();
                if (StringUtilities.isNullOrEmpty(mapItemSelectionInfo.textDescriptionSingleLine)) {
                    mapItemSelectionInfo.textDescriptionSingleLine = this.env.getTooltipFormatter().formatFallback(mapItemSelectionInfo.posInfo.tLocation);
                }
                this.fireShowToolTip(mapItemSelectionInfo);
                break;
            }
            case 0: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition(): done");
                mapItemSelectionInfo.textDescriptionSingleLine = this.posInfoParser.getDescription();
                mapItemSelectionInfo.Url = this.posInfoParser.getUrl();
                if (StringUtilities.isNullOrEmpty(mapItemSelectionInfo.textDescriptionSingleLine)) {
                    mapItemSelectionInfo.textDescriptionSingleLine = this.env.getTooltipFormatter().formatFallback(mapItemSelectionInfo.posInfo.tLocation);
                }
                this.fireShowToolTip(mapItemSelectionInfo);
                break;
            }
            case 7: {
                this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateInfoForPosition() - resolve");
                this.fireAfterResolve(mapItemSelectionInfo);
                break;
            }
            case -1: {
                this.setSelectedValue(null);
                this.getLogger().log(10000, "MapSelectionHandlerImpl#updateInfoForPosition(): infolist unknown.");
                break;
            }
            default: {
                this.setSelectedValue(null);
                this.getLogger().log(10000, "MapSelectionHandlerImpl#updateInfoForPosition(): infolist not parseable.");
            }
        }
    }

    @Override
    public void updateOnlineResultFlagDetails(int n) {
        OnlinePOIResultList onlinePOIResultList = this.env.getContextDependedOnlineResult();
        if (onlinePOIResultList == null) {
            this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateOnlineResultFlagDetails() - oprl is null");
            return;
        }
        this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateOnlineResultFlagDetails()");
        NavLocation navLocation = onlinePOIResultList.getTransformedLocationAt(n);
        String string = LocationFormatter.getURLAddress(navLocation);
        String string2 = this.env.getTooltipFormatter().formatOnlinePOI(onlinePOIResultList.getPOIElementAt(n), navLocation);
        MapItemSelectionInfo mapItemSelectionInfo = MapItemSelectionInfo.create(this.posInfoParser.getPosInfo(), this.getLogger());
        mapItemSelectionInfo.textDescriptionSingleLine = string2;
        mapItemSelectionInfo.Url = string;
        this.fireShowToolTip(mapItemSelectionInfo);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTmcMessage(TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateTmcMessage() - tmcMessage is null!", (Object)tmcMessage);
            return;
        }
        this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateTmcMessage()");
        this.naviMap.getNaviInterface().getTMCGateWay().fillDetailScreen(tmcMessage, this.naviMap.getMapManager().determinePreviewMapClientId());
        this.naviMap.getMapDataContainer().mapToolTipTMCMessage = tmcMessage;
        this.getLogger().log(-2137614336, "MapSelectionHandlerImpl#updateTmcMessage() - startDestinationDetailsTMC");
        this.naviMap.getNaviInterface().startDestinationDetailsTMC(tmcMessage);
        Object object = this.selectionMutex;
        synchronized (object) {
            MapItemSelectionInfo mapItemSelectionInfo = this.getSelectedValue();
            if (mapItemSelectionInfo == null) {
                this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateTmcMessage() - no selected value");
            } else if (mapItemSelectionInfo.posInfo.eInfoType != 4) {
                this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#updateTmcMessage() - selected value is not TMC");
            } else {
                String string = this.env.getTooltipFormatter().formatTMC(tmcMessage);
                ExtRenderingInfo extRenderingInfo = null;
                if (tmcMessage.getRoadNumber() != null) {
                    extRenderingInfo = this.naviMap.getIconHandler().resolveStreetIconResourceID(tmcMessage.getStreetSignId(), tmcMessage.getRoadNumber().length());
                }
                int[] nArray = tmcMessage.getIconListId();
                int n = -1;
                if (nArray != null && nArray.length > 0) {
                    int n2 = this.getSubIndexForEventIcon(tmcMessage, this.naviMap.getMapDataContainer().sRGActive);
                    n = this.naviMap.getIconHandler().resolveTMCIconResourceID(nArray[0], n2);
                }
                this.getLogger().log(1078071040, "MapSelectionHandlerImpl#updateTmcMessage() - tooltip text: %1", (Object)string);
                mapItemSelectionInfo.textDescriptionSingleLine = string;
                mapItemSelectionInfo.tmc_roadSignInfo = extRenderingInfo;
                mapItemSelectionInfo.tmc_roadNr = tmcMessage.getRoadNumber();
                mapItemSelectionInfo.tmc_eventIconID = n;
                mapItemSelectionInfo.tmcMessage = tmcMessage;
                this.fireShowToolTip(mapItemSelectionInfo);
            }
        }
    }

    protected int getSubIndexForEventIcon(TmcMessage tmcMessage, boolean bl) {
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void fireShowToolTip(MapItemSelectionInfo mapItemSelectionInfo) {
        Object object = this.selectionMutex;
        synchronized (object) {
            if (this.getSelectedValue() != null && this.getSelectedValue().ID > mapItemSelectionInfo.ID) {
                this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#fireShowToolTip() - this event was replaced by a new one");
                return;
            }
            this.setSelectedValue(mapItemSelectionInfo);
        }
        if (this.selectionListeners != null && mapItemSelectionInfo != null && mapItemSelectionInfo.posInfo != null) {
            for (int i2 = 0; i2 < this.selectionListeners.size(); ++i2) {
                try {
                    if (this.canceled) continue;
                    ((MapSelectionHandler$IMapSelectionListener)this.selectionListeners.get(i2)).onSelectionChanged(mapItemSelectionInfo);
                    continue;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    protected void fireAfterResolveXTRepresentation(MapItemSelectionInfo mapItemSelectionInfo) {
        MapSelectionHandlerImpl$2 mapSelectionHandlerImpl$2 = new MapSelectionHandlerImpl$2(this, "ResolveXTRepresentationCall", mapItemSelectionInfo.posInfo.tLocation, mapItemSelectionInfo);
        this.naviMap.getNaviInterface().executeCallDiscardOld(mapSelectionHandlerImpl$2, "MapSelectionHandlerImpl#resolveXTRepresentation");
    }

    protected void fireAfterResolveGoogleOnboardPOI(MapItemSelectionInfo mapItemSelectionInfo) {
        MapSelectionHandlerImpl$3 mapSelectionHandlerImpl$3 = new MapSelectionHandlerImpl$3(this, this.naviMap.getNavigationEnv().getCommandLogChannel(), "ResolveGoogleOnboardPOICall", mapItemSelectionInfo);
        this.naviMap.getNaviInterface().executeCallDiscardOld(mapSelectionHandlerImpl$3, "MapSelectionHandlerImpl#resolveGoogleOnboardPOI");
    }

    private void fireAfterResolvePicNavLocation(MapItemSelectionInfo mapItemSelectionInfo) {
        MapSelectionHandlerImpl$4 mapSelectionHandlerImpl$4 = new MapSelectionHandlerImpl$4(this, "ResolvePicNavLocationCall", mapItemSelectionInfo.posInfo.tLocation, mapItemSelectionInfo);
        this.naviMap.getNaviInterface().executeCallDiscardOld(mapSelectionHandlerImpl$4, "MapTooltip#resolvePicNavLocation");
    }

    private void fireAfterResolve(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    protected NavLocation getNavLocationForFavorite(PosInfo posInfo) {
        if (posInfo == null) {
            this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#buildNavLocationForFavorite( null )");
            return null;
        }
        MapPin mapPin = this.env.getMapPin(posInfo.getObjectId());
        if (mapPin == null) {
            this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#buildNavLocationForFavorite() - MapPin not found");
            return null;
        }
        IFavorite iFavorite = this.env.getFavorite(mapPin.index);
        if (iFavorite == null) {
            this.getLogger().log(-1601830656, "MapSelectionHandlerImpl#buildNavLocationForFavorite() - favorite not found");
            return null;
        }
        NavLocation navLocation = this.naviMap.getNaviInterface().streamToLocation(iFavorite.getFavoriteLocation());
        return navLocation;
    }

    @Override
    public void requestPreviewMapItemInformation(NavLocationWgs84 navLocationWgs84, boolean bl) {
    }

    @Override
    public MapItemSelectionInfo getStoredSelectedValue(int n) {
        return this.getSelectedValue();
    }
}

