/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.KOMOService;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.routeinfo.MixedList;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemPOI;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemTMC;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItemTurn;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelperAsia;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelperNAR;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.audi.tghu.navi.app.map.utils.NavRouteListDataWrapper;
import de.audi.tghu.navi.app.map.utils.TurnListElementWrapper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.komoview.RouteInfoElement;
import org.dsi.ifc.komoview.TrafficInfo;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public class RouteInfoHandler
implements MapConsts,
MixedListConstants,
IRouteInfo {
    public static final int REASON_UPDATED_POI = 0;
    public static final int REASON_UPDATED_TMC = 1;
    public static final int REASON_UPDATED_TURN = 2;
    public static final int REASON_UPDATED_DEST_INFO = 3;
    public static final int REASON_UPDATED_DIST_RTT = 4;
    public static final int REASON_UPDATED_DIST_RTT_TO_FINAL = 5;
    public static final int REASON_UPDATED_POI_ENABLE = 6;
    public static final int REASON_CHANGE_LANG = 7;
    public static final int REASON_NEW_RG = 8;
    public static final int REASON_CHANGE_UNIT = 9;
    protected final NavigationEnv env;
    protected final IconHandler iconHandler;
    private final RouteInfoHelper helper;
    private final MixedData mMixedList;
    private MixedListRow mCalculatingListRow;
    private MixedListRow mInvisibleListRow;
    private DateMetric mRTTMetric;
    private boolean mRGActive;
    private volatile boolean mRouteInfoComplete;
    private boolean mShowMixedList;
    private boolean mixedListVisible;
    private boolean mDelay = false;
    private RouteInfoElement[] mCurrentRouteInfoElement = null;
    protected IRouteInfo.IRouteInfoHandlerEnv riEnv;
    protected INaviInterface naviInterface;
    protected GUIInterface guiInterface;
    protected LogChannel logger;
    private final MixedListRow.IRouteInfoEnv routeInfoEnv;
    private TravelData mTravelData = new TravelData();
    private final IRouteInfoRenderer[] mRIRenderers;
    private boolean previousETAModeActive = true;
    private NavPoiInfo[] pendingPOIs;

    public RouteInfoHandler(final NavigationEnv navigationEnv, final IconHandler iconHandler, IRouteInfo.IRouteInfoHandlerEnv iRouteInfoHandlerEnv) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.riEnv = iRouteInfoHandlerEnv;
        this.naviInterface = iRouteInfoHandlerEnv.getNaviInterface();
        this.guiInterface = iRouteInfoHandlerEnv.getGuiInterface();
        this.logger = navigationEnv.getLogChannel("App.Map.Guidance");
        this.mMixedList = new MixedData();
        this.routeInfoEnv = new MixedListRow.IRouteInfoEnv(){

            public RoadClassSpeedInfo[] getSpeedInfo() {
                return RouteInfoHandler.this.getNaviInterface().getTrafficRegulationService().getCountrySpeedInfo();
            }

            public int getSpeedUnitForCountry(String string) {
                return RouteInfoHandler.this.helper.findSpeedUnitForCountry(string, this.getSpeedInfo());
            }

            public IconHandler getIconHandler() {
                return iconHandler;
            }

            public int getRouteLength() {
                return RouteUtil.getRouteLength(RouteInfoHandler.this.getNaviInterface().getRoute());
            }

            public NavLocation getCurrentDestination() {
                return RouteUtil.getCurrentDestination(RouteInfoHandler.this.getNaviInterface().getRoute());
            }

            public String getTranslatedText(int n) {
                String string = MapUtils.getDefaultTraslatedText(n);
                return navigationEnv.getTranslatedText(n, string);
            }

            public String formatDistStr(long l) {
                long l2 = ((RouteInfoHandler)RouteInfoHandler.this).mTravelData.mDistCarToFinalDest - RouteInfoHandler.this.helper.computeDistToFinalDest(l, ((RouteInfoHandler)RouteInfoHandler.this).mTravelData.indexOfCurrentDestination, RouteInfoHandler.this.mTravelData);
                return RouteInfoHandler.this.helper.formatDistString(l2);
            }

            public String getDestName(int n) {
                return RouteInfoHandler.this.getDestName(n);
            }

            public DateMetric getRTTMetric() {
                return RouteInfoHandler.this.mRTTMetric;
            }

            public NavigationEnv getNavigationEnv() {
                return navigationEnv;
            }

            public RouteInfoHelper getHelper() {
                return RouteInfoHandler.this.helper;
            }

            public NavLocation getLocationOfDestination(int n) {
                Route route = RouteInfoHandler.this.getNaviInterface().getRoute();
                if (route != null && route.getRoutelist() != null && n < route.getRoutelist().length && route.getRoutelist()[n] != null) {
                    return route.getRoutelist()[n].getRouteLocation();
                }
                RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler#getLocationOfDestination() is null!");
                return null;
            }
        };
        this.helper = Util.isHURegionAsia() ? new RouteInfoHelperAsia(navigationEnv, this.logger, this.routeInfoEnv) : (Util.isHURegionNAR() ? new RouteInfoHelperNAR(navigationEnv, this.logger, this.routeInfoEnv) : new RouteInfoHelper(navigationEnv, this.logger, this.routeInfoEnv));
        this.mCalculatingListRow = this.createCalculatingListRow();
        this.mInvisibleListRow = this.createMixedListRow(this.routeInfoEnv, this.logger);
        this.mInvisibleListRow.content = -1;
        this.mInvisibleListRow.setCellFormat(-1);
        this.mInvisibleListRow.setCellUnifierID(-1);
        this.clearList();
        this.mShowMixedList = false;
        this.mixedListVisible = false;
        this.mRGActive = false;
        this.mRouteInfoComplete = true;
        this.mRTTMetric = new DateMetric(new Date(0L), 5);
        IRouteInfoRenderer iRouteInfoRenderer = this.initializeRouteInfoBoxRenderer(navigationEnv.getListModel(400477), this.getGui().getRouteInfoBox(), this, this.helper, this.logger);
        this.mRIRenderers = Util.isKOMOFollowMode(navigationEnv.getFramework()) ? new IRouteInfoRenderer[]{iRouteInfoRenderer, new KOMOFollowInfoRenderer(), new FirstTmcRenderer()} : new IRouteInfoRenderer[]{iRouteInfoRenderer, new KOMORenderer(), new FirstTmcRenderer()};
    }

    protected MixedListRow.IRouteInfoEnv getRouteInfoEnv() {
        return this.routeInfoEnv;
    }

    protected IRouteInfoRenderer initializeRouteInfoBoxRenderer(ListModelApp listModelApp, ListModelApp listModelApp2, RouteInfoHandler routeInfoHandler, RouteInfoHelper routeInfoHelper, LogChannel logChannel) {
        return new ThreePlusOneBoxRenderer(this);
    }

    protected INaviInterface getNaviInterface() {
        return this.naviInterface;
    }

    protected GUIInterface getGui() {
        return this.guiInterface;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearList() {
        this.getLogger().log(10000000, "RouteInfoHandler#clearList()");
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            this.mMixedList.clear();
        }
    }

    protected LogChannel getLogger() {
        return this.logger;
    }

    public final MixedListRow createCalculatingListRow() {
        return this.createMixedListRow(this.routeInfoEnv, this.getLogger());
    }

    public MixedListRow getInvisibleListRow() {
        return this.mInvisibleListRow;
    }

    public NavigationEnv getEnv() {
        return this.env;
    }

    private long getCurrentDistCarToFinalDest() {
        return this.mTravelData.mDistCarToFinalDest;
    }

    private long getCurrentRttCarToFinalDest() {
        return this.mTravelData.mRttCarToFinalDest;
    }

    public void show() {
        this.getLogger().log(1000000, "RouteInfoHandler#show()");
        this.showMixedList(true);
    }

    public void forceRouteInfo(boolean bl) {
        this.getLogger().log(1000000, "RouteInfoHandler#forceRouteInfo() - show: %1", bl);
        if (bl) {
            this.mShowMixedList = true;
            this.getGui().controlMixedList(1, 1);
        } else {
            this.mShowMixedList = false;
            this.getGui().controlMixedList(2, 0);
        }
    }

    public void hide() {
        this.getLogger().log(1000000, "RouteInfoHandler#hide()");
        this.showMixedList(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void showMixedList(boolean bl) {
        RouteInfoHandler routeInfoHandler = this;
        synchronized (routeInfoHandler) {
            this.orientateMapBefore();
            boolean bl2 = this.riEnv.isRouteInfoEnabled();
            boolean bl3 = this.riEnv.supportsAdditionalInfo();
            boolean bl4 = this.riEnv.isRouteInfoAllowedToFadeIn();
            this.getLogger().log(10000000, "RouteInfoHandler#showMixedList(): %1", (Object)new Buffer().append("routeInfoEnabled = ").append(bl2).append(", supportsAdditionalInfo = ").append(bl3).append(", isRouteInfoAllowedToFadeIn = ").append(bl4).append(", mRGActive = ").append(this.mRGActive).append(", mDelay = ").append(this.mDelay).toString());
            if (bl && bl2 && bl3 && !this.mDelay && this.mRGActive && bl4) {
                if (!this.mShowMixedList) {
                    this.getLogger().log(1000000, "RouteInfoHandler#showMixedList(): SHOW");
                    this.mShowMixedList = true;
                    this.getGui().controlMixedList(1, 1);
                    this.setMixedListVisible(true);
                }
            } else if (this.mShowMixedList) {
                this.getLogger().log(1000000, "RouteInfoHandler#showMixedList(): HIDE");
                this.mShowMixedList = false;
                this.getGui().controlMixedList(2, 0);
                this.setMixedListVisible(false);
            }
            this.orientateMapAfter();
        }
    }

    protected void orientateMapAfter() {
    }

    protected void orientateMapBefore() {
        this.riEnv.automaticOrientateMap();
    }

    public boolean isMixedListVisible() {
        return this.mixedListVisible;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setMixedListVisible(boolean bl) {
        this.getLogger().log(10000000, "RouteInfoHandler#setMixedListVisible( %1 )", bl);
        RouteInfoHandler routeInfoHandler = this;
        synchronized (routeInfoHandler) {
            this.mixedListVisible = bl;
        }
    }

    public void updateRgActive(boolean bl) {
        this.getLogger().log(10000000, "RouteInfoHandler#updateRgActive( %1 )", bl);
        if (!bl) {
            this.mMixedList.clear();
            this.delayRouteInfo();
        }
        this.mRGActive = bl;
        this.show();
    }

    private void delayRouteInfo() {
        this.mDelay = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            this.mTravelData = new TravelData();
            this.mTravelData.rgDestinationInfo = navRouteListDataArray;
            if (navRouteListDataArray != null && navRouteListDataArray.length > 0) {
                for (int i2 = 0; i2 < navRouteListDataArray.length; ++i2) {
                    this.getLogger().log(1000000, "RouteInfoHandler#updateRgDestinationInfo() - [%2] %1", (Object)NavRouteListDataWrapper.toShortString(navRouteListDataArray[i2]), (long)i2);
                }
            }
            this.helper.setTravelData(this.mTravelData);
            this.mergeList(8);
            if (this.mDelay && this.mMixedList.hasTurnListElement()) {
                this.mDelay = false;
                this.show();
            }
            this.logMixedList();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        if ((turnListElementArray = this.filterEtcElementsForG24(turnListElementArray)) == null) {
            this.getLogger().log(100000, "RouteInfoHandler#updateRgTurnList() - turnList: null");
            return;
        }
        this.getLogger().log(1000000, "RouteInfoHandler#updateRgTurnList() - turnList: %1", (long)turnListElementArray.length);
        if (this.getLogger().isDebug()) {
            for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
                this.getLogger().log(10000000, "RouteInfoHandler#updateRgTurnList() - [%2] %1", (Object)TurnListElementWrapper.toShortString(turnListElementArray[i2]), (long)i2);
            }
        }
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            TurnListElement[] turnListElementArray2 = this.removeSoftDestination(turnListElementArray);
            this.mMixedList.updateTurn(turnListElementArray2);
            if (!this.mTravelData.isTravelDataValid() && turnListElementArray2 != null && turnListElementArray2.length > 0) {
                this.getLogger().log(100000, "RouteInfoHandler#updateRgTurnList() - invalid Travel data - wait for updateRgDestinationInfo.");
                return;
            }
        }
        this.mergeList(2);
        if (this.mDelay && turnListElementArray.length > 0) {
            this.mDelay = false;
            this.show();
        }
        this.logMixedList();
    }

    private TurnListElement[] filterEtcElementsForG24(TurnListElement[] turnListElementArray) {
        if (Util.isClusterMMI(this.env.getFramework()) && Util.isHURegionAsia()) {
            int n;
            int n2 = turnListElementArray != null ? turnListElementArray.length : 0;
            turnListElementArray = MapUtils.filterRgTurnListForAsia(turnListElementArray);
            int n3 = n = turnListElementArray != null ? turnListElementArray.length : 0;
            if (n2 != 0 && n == 0) {
                this.getLogger().log(10000, "RouteInfoHandler#updateRgTurnList() - filtered turnList length became 0 (was %1)! ", (long)n2);
            } else if (n2 != n) {
                this.getLogger().log(100000, "RouteInfoHandler#updateRgTurnList() - turnList was filtered from length %1 to %2 ", (long)n2, (long)n);
            }
        }
        return turnListElementArray;
    }

    private TurnListElement[] removeSoftDestination(TurnListElement[] turnListElementArray) {
        Route route = this.getNaviInterface().getRoute();
        int n = 0;
        for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
            if (turnListElementArray[i2] == null || this.helper.getDefaultFormat(turnListElementArray[i2], this.env) != 16) continue;
            try {
                RouteDestination routeDestination = route.routelist[turnListElementArray[i2].destinationIndex];
                if (routeDestination.destinationType != 2) continue;
                turnListElementArray[i2] = null;
                ++n;
                continue;
            }
            catch (Exception exception) {
                this.getLogger().log(100000, "RouteInfoHandler#removeSoftDestination() - %1", (Throwable)exception);
            }
        }
        TurnListElement[] turnListElementArray2 = new TurnListElement[turnListElementArray.length - n];
        int n2 = 0;
        for (int i3 = 0; i3 < turnListElementArray.length; ++i3) {
            if (turnListElementArray[i3] == null) continue;
            turnListElementArray2[n2++] = turnListElementArray[i3];
        }
        return turnListElementArray2;
    }

    private RouteInfoElement[] createRouteInfoElement(MixedListItem[] mixedListItemArray) {
        RouteInfoElement[] routeInfoElementArray = new RouteInfoElement[mixedListItemArray.length];
        for (int i2 = 0; i2 < mixedListItemArray.length; ++i2) {
            String[] stringArray;
            ManeuverElement[] maneuverElementArray;
            Object object;
            Object object2;
            MixedListItem mixedListItem = mixedListItemArray[i2];
            if (mixedListItem == null) {
                routeInfoElementArray[i2] = null;
                continue;
            }
            Object object3 = mixedListItem.getEvent();
            String string = this.helper.formatDistString(mixedListItem.getDistanceToCar());
            if (object3 instanceof TurnListElement) {
                int n;
                int n2;
                object2 = (TurnListElement)object3;
                object = ((TurnListElement)object2).getManeuver();
                maneuverElementArray = new ManeuverElement[((org.dsi.ifc.navigation.ManeuverElement[])object).length];
                for (n2 = 0; n2 < ((org.dsi.ifc.navigation.ManeuverElement[])object).length; ++n2) {
                    maneuverElementArray[n2] = this.helper.clone(object[n2]);
                }
                n2 = ((TurnListElement)object2).destinationIndex;
                stringArray = mixedListItem.getMixedListRow();
                if (stringArray != null && (n = stringArray.getInteger(20)) >= 69 && n <= 78) {
                    n2 = n == 69 ? -1 : n - 70;
                }
                routeInfoElementArray[i2] = new RouteInfoElement(string, null, 3, null, null, ((TurnListElement)object2).getStreetIconText(), ((TurnListElement)object2).getStreetIconId(), this.helper.determineExitNumber((TurnListElement)object2), mixedListItem.getName(), null, maneuverElementArray, null, n2, null, null, null, ((TurnListElement)object2).getStreetCardinalDirection(), -1);
                continue;
            }
            if (object3 instanceof NavPoiInfo) {
                object2 = (NavPoiInfo)object3;
                object = Util.isHURegionNAR() ? ((NavPoiInfo)object2).getExitNumber() : null;
                maneuverElementArray = this.helper.formatMillisecond(mixedListItem.getRttToCCP() * 1000L);
                int[] nArray = mixedListItem.getIconIDs();
                stringArray = new String[]{mixedListItem.getName()};
                routeInfoElementArray[i2] = new RouteInfoElement(string, (String)maneuverElementArray, 1, nArray, null, null, 0, (String)object, null, stringArray, null, null, ((NavPoiInfo)object2).destinationIndex, null, null, null, null, -1);
                continue;
            }
            if (!(object3 instanceof TmcMessage)) continue;
            object2 = (TmcMessage)object3;
            object = mixedListItem.getIconIDs();
            maneuverElementArray = (ManeuverElement[])new int[]{(int)object[0]};
            TrafficInfo trafficInfo = new TrafficInfo();
            if (mixedListItem.getFormat() == 21) {
                stringArray = new Date(((TmcMessage)object2).getEventDelayOnRoute() * 1000L);
                String[] stringArray2 = new DateMetric((Date)stringArray, 23).getStringValueAndUnit();
                trafficInfo.trafficOffset = new Buffer(stringArray2[0]).append(stringArray2[1].trim()).toString();
            }
            routeInfoElementArray[i2] = new RouteInfoElement(string, null, 2, (int[])maneuverElementArray, mixedListItem.getName(), ((TmcMessage)object2).getRoadNumber(), (int)((TmcMessage)object2).getStreetSignId(), null, null, null, null, trafficInfo, ((TmcMessage)object2).destinationIndex, null, null, null, ((TmcMessage)object2).getStreetCardinalDirection(), -1);
        }
        return routeInfoElementArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enableRouteInfoComplete(boolean bl) {
        boolean bl2;
        LogChannel logChannel = this.getLogger();
        logChannel.log(1000000, "RouteInfoHandler#enableRouteInfoComplete( %1 )", bl);
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            bl2 = this.mRouteInfoComplete != bl;
            this.mRouteInfoComplete = bl;
        }
        if (bl2) {
            this.mMixedList.rebuild();
            this.mergeList(6);
        }
    }

    private String formatNavPoiInfoShort(NavPoiInfo navPoiInfo) {
        Buffer buffer = new Buffer();
        buffer.append("NavPoiInfo");
        buffer.append('(');
        buffer.append("distance");
        buffer.append('=');
        buffer.append(navPoiInfo.distance);
        buffer.append(',');
        buffer.append("remainingTime");
        buffer.append('=');
        buffer.append(navPoiInfo.remainingTime);
        buffer.append(',');
        buffer.append("poiLocations");
        buffer.append('=');
        buffer.append('{');
        if (navPoiInfo.poiLocations != null) {
            for (int i2 = 0; i2 < navPoiInfo.poiLocations.length; ++i2) {
                buffer.append(LocationFormatter.formatPOIName(navPoiInfo.poiLocations[i2]));
                if (i2 >= navPoiInfo.poiLocations.length - 1) continue;
                buffer.append(',');
            }
        }
        buffer.append('}');
        buffer.append(',');
        buffer.append("exitNumber");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(navPoiInfo.exitNumber);
        buffer.append('\"');
        buffer.append(',');
        buffer.append("signpostInfo");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(navPoiInfo.signpostInfo);
        buffer.append('\"');
        buffer.append(',');
        buffer.append("exitIconId");
        buffer.append('=');
        buffer.append(navPoiInfo.exitIconId);
        buffer.append(',');
        buffer.append("sideOfStreet");
        buffer.append('=');
        buffer.append(navPoiInfo.sideOfStreet);
        buffer.append(',');
        buffer.append("destinationIndex");
        buffer.append('=');
        buffer.append(navPoiInfo.destinationIndex);
        buffer.append(',');
        buffer.append("type");
        buffer.append('=');
        buffer.append(navPoiInfo.type);
        buffer.append(',');
        buffer.append("exitPoiLocation");
        buffer.append('=');
        buffer.append(LocationFormatter.formatPOIName(navPoiInfo.exitPoiLocation));
        buffer.append(',');
        buffer.append("poiIcons");
        buffer.append('[');
        if (navPoiInfo.poiIcons != null) {
            buffer.append(navPoiInfo.poiIcons.length);
        }
        buffer.append(']');
        buffer.append(')');
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        int n;
        int n2 = n = navPoiInfoArray == null ? 0 : navPoiInfoArray.length;
        if (navPoiInfoArray == null) {
            this.getLogger().log(10000, "RouteInfoHandler#updateRgPoiInfo() - rgPoiInfo: null");
            return;
        }
        this.getLogger().log(1000000, "RouteInfoHandler#updateRgPoiInfo() - rgPoiInfo: %1", (long)n);
        if (this.getLogger().isDebug()) {
            for (int i2 = 0; i2 < n; ++i2) {
                this.getLogger().log(10000000, "RouteInfoHandler#updateRgPoiInfo() - [%2] %1", (Object)this.formatNavPoiInfoShort(navPoiInfoArray[i2]), (long)i2);
            }
        }
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            this.mMixedList.updatePOI(navPoiInfoArray);
            if (!this.mTravelData.isTravelDataValid()) {
                this.getLogger().log(100000, "RouteInfoHandler#updateRgPoiInfo() - invalid Travel data - wait for updateRgDestinationInfo.");
                return;
            }
        }
        this.mergeList(0);
        this.logMixedList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        int n;
        int n2 = n = tmcMessageArray == null ? 0 : tmcMessageArray.length;
        if (tmcMessageArray == null) {
            this.getLogger().log(1000000, "RouteInfoHandler#updateTmcMessagesAhead(): tmcMessagesAhead = null");
            return;
        }
        this.getLogger().log(1000000, "RouteInfoHandler#updateTmcMessagesAhead(): tmcMessagesAhead.length = %1", (long)n);
        if (this.getLogger().isDebug()) {
            for (int i2 = 0; i2 < n; ++i2) {
                this.getLogger().log(10000000, "RouteInfoHandler#updateTmcMessagesAhead() - [%2] %1", (Object)tmcMessageArray[i2], (long)i2);
            }
        }
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            this.mMixedList.updateTMC(tmcMessageArray);
            if (!this.mTravelData.isTravelDataValid()) {
                this.getLogger().log(100000, "RouteInfoHandler#updateTmcMessagesAhead() - invalid Travel data - wait for updateRgDestinationInfo.");
                return;
            }
        }
        this.mergeList(1);
        this.logMixedList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void mergeList(int n) {
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            this.getLogger().log(100000000, "RouteInfoHandler#mergeList() - DTLD = %1, RTT = %2s, Reason = %3", this.getCurrentDistCarToFinalDest(), this.getCurrentRttCarToFinalDest(), (long)n);
            this.getLogger().log(100000000, "RouteInfoHandler#mergeList() - mixedList: %1", (Object)this.mMixedList);
            this.renderRouteInfo();
        }
    }

    private void logMixedList() {
        this.getLogger().log(10000000, "RouteInfoHandler#logMixedList() - mixedList: %1", (Object)this.mMixedList);
    }

    private void renderRouteInfo() {
        for (int i2 = 0; i2 < this.mRIRenderers.length; ++i2) {
            try {
                this.mRIRenderers[i2].render(this.mMixedList);
                continue;
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "RouteInfoHandler#renderRouteInfo() - i=%1, %2", (long)i2, (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTravelParameters(boolean bl, boolean bl2, long l, long l2, int n, int n2, long l3, long l4, int n3, int n4, int n5) {
        int n6 = (int)(l / 3600L);
        int n7 = (int)(l3 / 3600L);
        int n8 = n6 / 24;
        int n9 = n7 / 24;
        Buffer buffer = new Buffer();
        if (this.getLogger().isDebug2()) {
            buffer.append("etaModeActive:").append(bl);
            buffer.append(", etaValid:").append(bl2);
            buffer.append(", timeToNextDestination:").append(l);
            buffer.append(", eta:").append(l2);
            buffer.append(", distance:").append(n);
            buffer.append(", distanceDelta:").append(n2);
            buffer.append(", timeToFinalDestination:").append(l3);
            buffer.append(", etaToFinalDestination:").append(l4);
            buffer.append(", distanceToFinalDestination:").append(n3);
            buffer.append(", distanceToFinalDestDelta:").append(n4);
            buffer.append(", indexOfCurrentDestination:").append(n5);
        }
        this.getLogger().log(100000000, "RouteInfoHandler#setTravelParameters() %1", (Object)buffer.toString());
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            boolean bl3;
            boolean bl4 = false;
            if (this.previousETAModeActive != bl) {
                this.previousETAModeActive = bl;
                bl4 = true;
            }
            GUIInterface gUIInterface = this.getGui();
            if (n != n2) {
                this.getLogger().log(100000000, "RouteInfoHandler#setTravelParameters() - delta distance: %1 ", (long)n2);
            }
            if (n3 != n4) {
                this.getLogger().log(100000000, "RouteInfoHandler#setTravelParameters() - delta distance to final destination: %1 ", (long)n4);
            }
            boolean bl5 = n > 0 && l > 0L;
            boolean bl6 = bl3 = this.env.getChoiceModel(400573).getValue() == 1;
            if (this.riEnv.showETAandDistanceToNextStopover()) {
                gUIInterface.setDestDistanceNoUpdate(bl5, n);
                if (bl && !bl3) {
                    gUIInterface.setETA(l2, n8, bl4);
                } else {
                    gUIInterface.setRTT(l * 1000L, bl4);
                }
            } else {
                gUIInterface.setDestDistanceNoUpdate(bl5, n3);
                if (bl && !bl3) {
                    gUIInterface.setETA(l4, n9, bl4);
                } else {
                    gUIInterface.setRTT(l3 * 1000L, bl4);
                }
            }
            this.setDistAndRttToFinalDestination(n3, l3, n5);
            gUIInterface.setDestinationIndex(this.getDestIndex());
            gUIInterface.updateModelGroup();
            this.riEnv.updateDestDistance(n);
        }
    }

    private boolean setDistAndRttToFinalDestinationWithoutMergeList(long l, long l2, int n) {
        boolean bl;
        if (this.mTravelData.indexOfCurrentDestination != n) {
            this.getLogger().log(10000000, "RouteInfoHandler#setDistAndRttToFinalDestinationWithoutMergeList() - Destination changed");
            this.mTravelData.indexOfCurrentDestination = n;
        }
        boolean bl2 = bl = l != this.mTravelData.mDistCarToFinalDest || l2 != this.mTravelData.mRttCarToFinalDest;
        if (!bl) {
            return false;
        }
        this.mTravelData.mDistCarToFinalDest = l;
        this.mTravelData.mRttCarToFinalDest = l2;
        this.getLogger().log(100000000, "RouteInfoHandler#setDistAndRttToFinalDestinationWithoutMergeList() - distCarToFinalDest:%1, rttCarToFinalDest:%2", this.mTravelData.mDistCarToFinalDest, this.mTravelData.mRttCarToFinalDest);
        bl = false;
        for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
            boolean bl3 = false;
            MixedListItem mixedListItem = this.mMixedList.getItem(i2);
            bl3 = mixedListItem.updateDistanceToCar(this.mTravelData.mDistCarToFinalDest);
            bl3 |= mixedListItem.updateRttToCar(this.mTravelData.mRttCarToFinalDest);
            this.getLogger().log(100000000, "RouteInfoHandler#setDistAndRttToFinalDestinationWithoutMergeList() Distance is updated to: %1", mixedListItem.getDistanceToCar());
            if (i2 >= 4) continue;
            bl |= bl3;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setDistAndRttToFinalDestination(long l, long l2, int n) {
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            boolean bl = this.setDistAndRttToFinalDestinationWithoutMergeList(l, l2, n);
            if (this.pendingPOIs != null) {
                this.mMixedList.updatePOI(this.pendingPOIs);
            }
            if (bl) {
                this.mergeList(5);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setLanguage(String string) {
        this.getLogger().log(1000000, "RouteInfoHandler#setLanguage(%1)", (Object)string);
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            this.mCalculatingListRow = this.createCalculatingListRow();
            for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
                int n;
                MixedListItem mixedListItem = this.mMixedList.getItem(i2);
                MixedListRow mixedListRow = mixedListItem.getMixedListRow();
                String string2 = this.env.getTranslatedText(4, "Calculating...");
                this.getLogger().log(1000000, "RouteInfoHandler#setLanguage(): Calculating translated to: %1", (Object)string2);
                mixedListRow.setCellCalculating(string2);
                mixedListRow.updateDistanceToCCP();
                if (this.helper.isTurnElement(mixedListItem.getFormat()) && (n = mixedListRow.getInteger(20)) >= 69 && n <= 78) {
                    this.getLogger().log(100000000, "RouteInfoHandler#setLanguage(): image = %1", (long)n);
                    mixedListRow.setCellTurnRoadNameOr2ndLine(this.getDestName(mixedListItem.getDestinationIndex()));
                }
                if (!mixedListRow.isBorderCrossingElement()) continue;
                int n2 = n = this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex() == 26 ? 1 : 0;
                if (Util.isClusterMMI(this.env.getFramework())) {
                    mixedListRow.setCellBorderCrossingTextAllowedVelocity1(this.env.getTranslatedText(53, "Tempolimits"));
                    mixedListRow.setCellBorderCrossingTextAllowedVelocity2(this.env.getTranslatedText(3, "velocities"));
                } else if (n != 0) {
                    mixedListRow.setCellBorderCrossingTextAllowedVelocity1(this.env.getTranslatedText(3, "velocities"));
                    mixedListRow.setCellBorderCrossingTextAllowedVelocity2(this.env.getTranslatedText(0, "Allowed"));
                } else {
                    mixedListRow.setCellBorderCrossingTextAllowedVelocity1(this.env.getTranslatedText(0, "Allowed"));
                    mixedListRow.setCellBorderCrossingTextAllowedVelocity2(this.env.getTranslatedText(3, "velocities"));
                }
                mixedListRow.setCellBorderCrossingTextPassing(this.env.getTranslatedText(6, "Border crossing"));
                mixedListRow.setCellBorderCrossingTextSpeedUnit(this.env.getTranslatedText(1, "in km/h"));
            }
        }
        this.mergeList(7);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeKOMO(RouteInfoElement[] routeInfoElementArray) {
        KOMOService kOMOService = this.getNaviInterface().getKOMOService();
        if (kOMOService != null && !Util.isKOMOFollowMode(this.env.getFramework())) {
            KOMOService kOMOService2 = kOMOService;
            synchronized (kOMOService2) {
                kOMOService.setRouteInfo(routeInfoElementArray);
            }
        }
    }

    private String getDestName(int n) {
        String string;
        int n2 = this.getNaviInterface().getRouteListLength();
        int n3 = n;
        this.getLogger().log(1000000, "RouteInfoHandler#getDestName(): stopover#%1, destinations %2", (long)n3, (long)n2);
        if (n3 + 1 < n2) {
            string = this.env.getTranslatedText(21, "Stopover");
            this.getLogger().log(1000000, "RouteInfoHandler#getDestName(): stopover");
        } else {
            string = this.env.getTranslatedText(14, "Destination");
            this.getLogger().log(1000000, "RouteInfoHandler#getDestName(): destination");
        }
        return string;
    }

    public void refreshDestinationFlag() {
        LogChannel logChannel = this.getLogger();
        logChannel.log(100000000, "RouteInfoHandler#refreshDestinationFlag(): enter");
        TurnListElement[] turnListElementArray = this.getNaviInterface().getNavigationMode() == 0 ? this.env.getContainer().getRgTurnList() : this.env.getRemoteContainer().getRgTurnList();
        this.updateRgTurnList(turnListElementArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void refreshDistAndRtt() {
        this.getLogger().log(1000000, "RouteInfoHandler#refreshDistAndRtt() - distCarToFinalDest: %1m, rttCarToFinalDest: %2s", this.getCurrentDistCarToFinalDest(), this.getCurrentRttCarToFinalDest());
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
                MixedListItem mixedListItem = this.mMixedList.getItem(i2);
                mixedListItem.updateDistanceToCar(this.getCurrentDistCarToFinalDest());
                mixedListItem.updateRttToCar(this.getCurrentRttCarToFinalDest());
            }
        }
        this.mergeList(9);
    }

    protected int getCountryFlagResourceID(String string, CountryInfo[] countryInfoArray) {
        LogChannel logChannel = this.getLogger();
        logChannel.log(100000000, "RouteInfoHandler#getCountryFlagResourceID() - countryAbbreviation: '%1', countryInfo.length: %2", (Object)string, countryInfoArray == null ? 0L : (long)countryInfoArray.length);
        int n = -1;
        if (!Util.isEmpty(string) && countryInfoArray != null) {
            for (int i2 = 0; i2 < countryInfoArray.length; ++i2) {
                CountryInfo countryInfo = countryInfoArray[i2];
                if (countryInfo != null) {
                    logChannel.log(100000000, "RouteInfoHandler#getCountryFlagResourceID() - processing index %3: country: %1, abbreviation: %2", (Object)countryInfo.getName(), (Object)countryInfo.getCountryAbbreviation(), (long)i2);
                    if (!string.equals(countryInfo.getCountryAbbreviation())) continue;
                    int n2 = countryInfo.getIconIndex();
                    logChannel.log(100000000, "RouteInfoHandler#getCountryFlagResourceID() - found matching abbreviation at index %1, flagIndex: %2", (long)i2, (long)n2);
                    n = this.iconHandler.resolveCountryIconResourceID(n2);
                    if (n == -1) continue;
                    break;
                }
                logChannel.log(100000, "RouteInfoHandler#getCountryFlagResourceID() - CountryInfo at index %1 is null!", (long)i2);
            }
        }
        logChannel.log(100000000, "RouteInfoHandler#getCountryFlagResourceID() - result: %1", (long)n);
        return n;
    }

    private int getDestIndex() {
        int n = this.getNaviInterface().getRouteListLength();
        int n2 = this.getNaviInterface().getIndexOfCurrentDestination();
        if (n2 + 1 < n) {
            return 1;
        }
        return 0;
    }

    protected static MixedListItem getNextManeuver(MixedData mixedData) {
        for (int i2 = 0; i2 < mixedData.mTurnList.size(); ++i2) {
            MixedListItem mixedListItem = mixedData.mTurnList.getItem(i2);
            if (!mixedListItem.isRealTurnElement()) continue;
            return mixedListItem;
        }
        return null;
    }

    protected static MixedListItem getNextElementToShow(MixedData mixedData, LogChannel logChannel) {
        for (int i2 = 0; i2 < mixedData.size(); ++i2) {
            MixedListItem mixedListItem = mixedData.getItem(i2);
            int n = mixedListItem.getFormat();
            if (!mixedListItem.isRealTurnElement() && n != 1 && n != 2 && n != 18 && n != 21 && n != 22) continue;
            return mixedListItem;
        }
        return null;
    }

    protected MixedListRow createMixedListRow(MixedListRow.IRouteInfoEnv iRouteInfoEnv, LogChannel logChannel) {
        return new MixedListRow(iRouteInfoEnv, logChannel);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getItemByUID(long l) {
        Object object = null;
        MixedData mixedData = this.mMixedList;
        synchronized (mixedData) {
            for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
                if (this.mMixedList.getItem(i2).getUID() != l) continue;
                object = this.mMixedList.getItem(i2).getEvent();
                break;
            }
        }
        return object;
    }

    static /* synthetic */ RouteInfoElement[] access$1002(RouteInfoHandler routeInfoHandler, RouteInfoElement[] routeInfoElementArray) {
        routeInfoHandler.mCurrentRouteInfoElement = routeInfoElementArray;
        return routeInfoElementArray;
    }

    static /* synthetic */ NavPoiInfo[] access$1502(RouteInfoHandler routeInfoHandler, NavPoiInfo[] navPoiInfoArray) {
        routeInfoHandler.pendingPOIs = navPoiInfoArray;
        return navPoiInfoArray;
    }

    public class MixedData {
        MixedList mTurnList = new MixedList();
        MixedList mPOIList = new MixedList();
        MixedList mTMCList = new MixedList();
        private MixedList data = new MixedList();

        public MixedData() {
            this.rebuild();
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append(RouteInfoHandler.this.mTravelData).append("\n");
            for (int i2 = 0; i2 < this.data.size(); ++i2) {
                buffer.append(this.data.getItem(i2)).append("\n");
            }
            return buffer.toString();
        }

        public MixedListItem getItem(int n) {
            return this.data.getItem(n);
        }

        public void removeItem(int n) {
            MixedListItem mixedListItem = this.data.getItem(n);
            if (this.mTMCList.containsItem(mixedListItem)) {
                this.mTMCList.removeItem(mixedListItem);
            } else if (this.mPOIList.containsItem(mixedListItem)) {
                this.mPOIList.removeItem(mixedListItem);
            } else if (this.mTurnList.containsItem(mixedListItem)) {
                this.mTurnList.removeItem(mixedListItem);
            }
            this.data.removeItem(mixedListItem);
        }

        public int size() {
            return this.data.size();
        }

        public void updateTurn(TurnListElement[] turnListElementArray) {
            this.mTurnList.clear();
            long l = RouteInfoHandler.this.getCurrentDistCarToFinalDest();
            long l2 = RouteInfoHandler.this.getCurrentRttCarToFinalDest();
            for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
                try {
                    MixedListItemTurn mixedListItemTurn = new MixedListItemTurn(turnListElementArray[i2], RouteInfoHandler.this.mTravelData, RouteInfoHandler.this.createMixedListRow(RouteInfoHandler.this.routeInfoEnv, RouteInfoHandler.this.getLogger()), l, l2, RouteInfoHandler.this.helper);
                    this.mTurnList.add(mixedListItemTurn);
                    if (mixedListItemTurn.mMixedListRow.name == null || mixedListItemTurn.mMixedListRow.name.equals(RouteInfoHandler.this.helper.getDisplayName(turnListElementArray[i2]))) continue;
                    RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler#MixedData#updateTurn() - name = %1", (Object)RouteInfoHandler.this.helper.getDisplayName(turnListElementArray[i2]));
                    continue;
                }
                catch (Exception exception) {
                    RouteInfoHandler.this.getLogger().log(10000, "RouteInfoHandler#MixedData#updateTurn() - %1", (Throwable)exception);
                }
            }
            this.rebuild();
        }

        public void updatePOI(NavPoiInfo[] navPoiInfoArray) {
            this.mPOIList.clear();
            long l = RouteInfoHandler.this.getCurrentDistCarToFinalDest();
            long l2 = RouteInfoHandler.this.getCurrentRttCarToFinalDest();
            if (l < 0L) {
                RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler#MixedData#updatePOI() negative distCarToFinalDest: %1", l);
                RouteInfoHandler.access$1502(RouteInfoHandler.this, navPoiInfoArray);
                return;
            }
            RouteInfoHandler.access$1502(RouteInfoHandler.this, null);
            for (int i2 = 0; i2 < navPoiInfoArray.length; ++i2) {
                try {
                    MixedListItemPOI mixedListItemPOI = new MixedListItemPOI(navPoiInfoArray[i2], RouteInfoHandler.this.mTravelData, RouteInfoHandler.this.createMixedListRow(RouteInfoHandler.this.routeInfoEnv, RouteInfoHandler.this.getLogger()), l, l2, RouteInfoHandler.this.helper);
                    this.mPOIList.add(mixedListItemPOI);
                    if (mixedListItemPOI.mMixedListRow.name == null || mixedListItemPOI.mMixedListRow.name.equals(RouteInfoHandler.this.helper.getDisplayName(navPoiInfoArray[i2]))) continue;
                    RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler#MixedData#updatePOI() - name = %1", (Object)RouteInfoHandler.this.helper.getDisplayName(navPoiInfoArray[i2]));
                    continue;
                }
                catch (Exception exception) {
                    RouteInfoHandler.this.getLogger().log(10000, "RouteInfoHandler#MixedData#updatePOI() - %1", (Throwable)exception);
                }
            }
            this.rebuild();
        }

        public void updateTMC(TmcMessage[] tmcMessageArray) {
            this.mTMCList.clear();
            long l = RouteInfoHandler.this.getCurrentDistCarToFinalDest();
            long l2 = RouteInfoHandler.this.getCurrentRttCarToFinalDest();
            for (int i2 = 0; i2 < tmcMessageArray.length; ++i2) {
                try {
                    MixedListItemTMC mixedListItemTMC = new MixedListItemTMC(tmcMessageArray[i2], RouteInfoHandler.this.mTravelData, RouteInfoHandler.this.createMixedListRow(RouteInfoHandler.this.routeInfoEnv, RouteInfoHandler.this.getLogger()), l, l2, RouteInfoHandler.this.helper);
                    this.mTMCList.add(mixedListItemTMC);
                    String string = RouteInfoHandler.this.helper.getDisplayName(tmcMessageArray[i2]);
                    if (mixedListItemTMC.mMixedListRow.name == null || mixedListItemTMC.mMixedListRow.name.equals(string)) continue;
                    RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler#MixedData#updateTMC() - name = %1", (Object)string);
                    continue;
                }
                catch (Exception exception) {
                    RouteInfoHandler.this.getLogger().log(10000, "RouteInfoHandler#MixedData#updateTMC() - %1", (Throwable)exception);
                }
            }
            this.rebuild();
        }

        protected final void rebuild() {
            this.data.clear();
            this.data.add(this.mPOIList).add(this.mTMCList);
            this.data.add(this.mTurnList).sort();
        }

        public void clear() {
            this.mTurnList.clear();
            this.mPOIList.clear();
            this.mTMCList.clear();
            this.data.clear();
            RouteInfoHandler.access$1502(RouteInfoHandler.this, null);
        }

        public void clearOldItems() {
        }

        public boolean hasTurnListElement() {
            return this.mTurnList.size() > 0;
        }
    }

    public static class TravelData {
        long mDistCarToFinalDest = -1L;
        long mRttCarToFinalDest = -1L;
        int indexOfCurrentDestination = 0;
        NavRouteListData[] rgDestinationInfo = new NavRouteListData[0];

        public long getDistCarToDest() {
            return this.mDistCarToFinalDest;
        }

        public boolean isTravelDataValid() {
            return this.rgDestinationInfo != null && this.rgDestinationInfo.length > 0;
        }

        public long getRttCarToDest() {
            return this.mRttCarToFinalDest;
        }

        public long getDistCarToEvent(long l, int n) {
            return 0L;
        }

        public long getRttCarToEvent(long l, int n) {
            return 0L;
        }

        public String toString() {
            Buffer buffer = new Buffer("TravelData(");
            buffer.append("distCarToFinalDest: ").append(this.mDistCarToFinalDest);
            buffer.append("m, rttCarToFinalDest: ").append(this.mRttCarToFinalDest);
            buffer.append("s, currentDestIndex: ").append(this.indexOfCurrentDestination);
            buffer.append(')');
            return buffer.toString();
        }
    }

    private class KOMORenderer
    implements IRouteInfoRenderer {
        private KOMORenderer() {
        }

        public void render(MixedData mixedData) {
            RouteInfoHandler.this.getLogger().log(100000000, "RouteInfoHandler<KOMORenderer>#render() - data length : %1", mixedData != null ? (long)mixedData.size() : -1L);
            if (mixedData == null) {
                RouteInfoHandler.this.getLogger().log(10000, "RouteInfoHandler<KOMORenderer>#render() - data null");
                return;
            }
            MixedListItem[] mixedListItemArray = new MixedListItem[]{RouteInfoHandler.getNextElementToShow(mixedData, RouteInfoHandler.this.getLogger()), RouteInfoHandler.getNextManeuver(mixedData)};
            RouteInfoHandler.access$1002(RouteInfoHandler.this, RouteInfoHandler.this.createRouteInfoElement(mixedListItemArray));
            RouteInfoHandler.this.writeKOMO(RouteInfoHandler.this.mCurrentRouteInfoElement);
        }
    }

    private class FirstTmcRenderer
    implements IRouteInfoRenderer {
        private FirstTmcRenderer() {
        }

        public void render(MixedData mixedData) {
            MixedListItem mixedListItem = this.getFirstTMC(mixedData);
            if (mixedListItem != null) {
                RouteInfoHandler.this.getNaviInterface().updateInfoForNextTmcEvent(mixedListItem.getDistanceToCar() >= 0L ? mixedListItem.getDistanceToCar() : 0L, (TmcMessage)mixedListItem.getEvent());
            }
        }

        private MixedListItem getFirstTMC(MixedData mixedData) {
            for (int i2 = 0; i2 < mixedData.size(); ++i2) {
                MixedListItem mixedListItem = mixedData.getItem(i2);
                if (mixedListItem.getFormat() != 2 && mixedListItem.getFormat() != 18 && mixedListItem.getFormat() != 21 && mixedListItem.getFormat() != 22) continue;
                return mixedListItem;
            }
            return null;
        }
    }

    public static interface IRouteInfoRenderer {
        public static final int UID_INVISIBLE = -1;
        public static final int UID_CALCULATING = 0;

        public void render(MixedData var1);
    }

    private class KOMOFollowInfoRenderer
    implements IRouteInfoRenderer {
        private KOMOFollowInfoRenderer() {
        }

        public void render(MixedData mixedData) {
            RouteInfoHandler.this.getLogger().log(100000000, "RouteInfoHandler<G24KOMORenderer>#render() - data length : %1", mixedData != null ? (long)mixedData.size() : -1L);
            RouteInfoElement routeInfoElement = RouteInfoHandler.this.createRouteInfoElement(new MixedListItem[]{RouteInfoHandler.getNextManeuver(mixedData)})[0];
            RouteInfoHandler.this.getNaviInterface().getClusterService().updateNextManeuver(routeInfoElement);
        }
    }

    private class ThreePlusOneBoxRenderer
    implements IRouteInfoRenderer {
        public static final int MAX_ROW_NUM = 3;
        protected ListModelApp listModel;

        public ThreePlusOneBoxRenderer(RouteInfoHandler routeInfoHandler2) {
            this.listModel = RouteInfoHandler.this.env.getListModel(400477);
            this.listModel.setMaxRows(3);
            this.listModel.setMaxColumns(69);
            this.listModel.clear();
            for (int i2 = 0; i2 < 3; ++i2) {
                this.listModel.addRow(routeInfoHandler2.mCalculatingListRow);
            }
        }

        public void render(MixedData mixedData) {
            int n;
            if (mixedData == null) {
                RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - not initialized");
                return;
            }
            RouteInfoHandler.this.getLogger().log(100000000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - list size : %1", (long)mixedData.size());
            Util.beginTransaction(this.listModel);
            if (!mixedData.hasTurnListElement()) {
                int n2;
                int n3 = this.countVisibleRows();
                this.listModel.clear();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.listModel.insertRow(0, RouteInfoHandler.this.mCalculatingListRow);
                }
                for (n2 = 0; n2 < 3 - n3; ++n2) {
                    this.listModel.insertRow(0, RouteInfoHandler.this.getInvisibleListRow());
                }
                Util.endTransaction(this.listModel);
                return;
            }
            this.listModel.clear();
            this.checkDataValidity(mixedData);
            int n4 = 0;
            MixedListItem mixedListItem = null;
            for (n = 0; n4 < 3 && n < mixedData.size(); ++n) {
                mixedListItem = mixedData.getItem(n);
                if (!RouteInfoHandler.this.mRouteInfoComplete && mixedListItem instanceof MixedListItemPOI) continue;
                if (n4 < 2 && mixedListItem.getFormat() == 8) {
                    if (mixedListItem.isBorderCrossingSpeedInfoAvailable() && mixedListItem.isWithinHorizon() && !Util.isHURegionNAR()) {
                        BaseListRow baseListRow = mixedListItem.toBaseListRow();
                        baseListRow.setCell(0, IntegerListCell.create(7));
                        this.listModel.insertRow(0, baseListRow);
                        baseListRow = mixedListItem.toBaseListRow();
                        baseListRow.setCell(0, IntegerListCell.create(6));
                        this.listModel.insertRow(0, baseListRow);
                        n4 += 2;
                        continue;
                    }
                    this.listModel.insertRow(0, mixedListItem.toBaseListRow());
                    ++n4;
                    continue;
                }
                this.listModel.insertRow(0, mixedListItem.toBaseListRow());
                ++n4;
            }
            RouteInfoHandler.this.getLogger().log(10000000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - model size: %1", (long)n4);
            for (n = 0; n < 3 - n4; ++n) {
                this.listModel.insertRow(0, RouteInfoHandler.this.getInvisibleListRow());
            }
            Util.endTransaction(this.listModel);
        }

        private int countVisibleRows() {
            int n = 0;
            int n2 = this.listModel.getLength();
            for (int i2 = 0; i2 < n2; ++i2) {
                BaseListRow baseListRow = this.listModel.getRow(i2);
                int n3 = ((IntegerListCell)baseListRow.getCell(0)).getValue();
                RouteInfoHandler.this.getLogger().log(100000000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() %1", (long)n3);
                if (n3 == -1) continue;
                ++n;
            }
            RouteInfoHandler.this.getLogger().log(10000000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#render() - visible size: %1", (long)n);
            return n;
        }

        private void checkDataValidity(MixedData mixedData) {
            if (mixedData == null || mixedData.size() == 0) {
                RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#checkDataValidity() - listModel = null");
            } else {
                int n = 50;
                for (int i2 = mixedData.size() - 1; i2 > 0; --i2) {
                    int n2 = mixedData.getItem(i2).getMixedListRow().getInteger(48);
                    if (n2 == 0 || n2 == -1 || n2 != mixedData.getItem(i2 - 1).getMixedListRow().getInteger(48)) continue;
                    RouteInfoHandler.this.getLogger().log(100000, "RouteInfoHandler<ThreePlusOneBoxRenderer>#checkDataValidity() - same UID : %1, change to %2", (long)mixedData.getItem(i2 - 1).getMixedListRow().getInteger(48), (long)(n2 -= ++n));
                    mixedData.getItem(i2).getMixedListRow().setInteger(48, n2);
                }
            }
        }
    }
}

