/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
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
import de.audi.tghu.navi.app.map.handler.IRouteInfo$IRouteInfoHandlerEnv;
import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$1;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$FirstTmcRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$IRouteInfoRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$KOMOFollowInfoRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$KOMORenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$MixedData;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$ThreePlusOneBoxRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$TravelData;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelperAsia;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelperNAR;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.MixedListRow;
import de.audi.tghu.navi.app.map.utils.MixedListRow$IRouteInfoEnv;
import de.audi.tghu.navi.app.map.utils.NavRouteListDataWrapper;
import de.audi.tghu.navi.app.map.utils.TurnListElementWrapper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
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

public class RouteInfoHandler
implements MapConsts,
MixedListConstants,
IRouteInfo {
    public static final int REASON_UPDATED_POI;
    public static final int REASON_UPDATED_TMC;
    public static final int REASON_UPDATED_TURN;
    public static final int REASON_UPDATED_DEST_INFO;
    public static final int REASON_UPDATED_DIST_RTT;
    public static final int REASON_UPDATED_DIST_RTT_TO_FINAL;
    public static final int REASON_UPDATED_POI_ENABLE;
    public static final int REASON_CHANGE_LANG;
    public static final int REASON_NEW_RG;
    public static final int REASON_CHANGE_UNIT;
    protected final NavigationEnv env;
    protected final IconHandler iconHandler;
    private final RouteInfoHelper helper;
    private final RouteInfoHandler$MixedData mMixedList;
    private MixedListRow mCalculatingListRow;
    private MixedListRow mInvisibleListRow;
    private DateMetric mRTTMetric;
    private boolean mRGActive;
    private volatile boolean mRouteInfoComplete;
    private boolean mShowMixedList;
    private boolean mixedListVisible;
    private boolean mDelay = false;
    private RouteInfoElement[] mCurrentRouteInfoElement = null;
    protected IRouteInfo$IRouteInfoHandlerEnv riEnv;
    protected INaviInterface naviInterface;
    protected GUIInterface guiInterface;
    protected LogChannel logger;
    private final MixedListRow$IRouteInfoEnv routeInfoEnv;
    private RouteInfoHandler$TravelData mTravelData = new RouteInfoHandler$TravelData();
    private final RouteInfoHandler$IRouteInfoRenderer[] mRIRenderers;
    private boolean previousETAModeActive = true;
    private NavPoiInfo[] pendingPOIs;

    public RouteInfoHandler(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteInfo$IRouteInfoHandlerEnv iRouteInfo$IRouteInfoHandlerEnv) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.riEnv = iRouteInfo$IRouteInfoHandlerEnv;
        this.naviInterface = iRouteInfo$IRouteInfoHandlerEnv.getNaviInterface();
        this.guiInterface = iRouteInfo$IRouteInfoHandlerEnv.getGuiInterface();
        this.logger = navigationEnv.getLogChannel("App.Map.Guidance");
        this.mMixedList = new RouteInfoHandler$MixedData(this);
        this.routeInfoEnv = new RouteInfoHandler$1(this, iconHandler, navigationEnv);
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
        RouteInfoHandler$IRouteInfoRenderer routeInfoHandler$IRouteInfoRenderer = this.initializeRouteInfoBoxRenderer(navigationEnv.getListModel(1562117632), this.getGui().getRouteInfoBox(), this, this.helper, this.logger);
        this.mRIRenderers = Util.isKOMOFollowMode(navigationEnv.getFramework()) ? new RouteInfoHandler$IRouteInfoRenderer[]{routeInfoHandler$IRouteInfoRenderer, new RouteInfoHandler$KOMOFollowInfoRenderer(this, null), new RouteInfoHandler$FirstTmcRenderer(this, null)} : new RouteInfoHandler$IRouteInfoRenderer[]{routeInfoHandler$IRouteInfoRenderer, new RouteInfoHandler$KOMORenderer(this, null), new RouteInfoHandler$FirstTmcRenderer(this, null)};
    }

    protected MixedListRow$IRouteInfoEnv getRouteInfoEnv() {
        return this.routeInfoEnv;
    }

    protected RouteInfoHandler$IRouteInfoRenderer initializeRouteInfoBoxRenderer(ListModelApp listModelApp, ListModelApp listModelApp2, RouteInfoHandler routeInfoHandler, RouteInfoHelper routeInfoHelper, LogChannel logChannel) {
        return new RouteInfoHandler$ThreePlusOneBoxRenderer(this, this);
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
        this.getLogger().log(-2137614336, "RouteInfoHandler#clearList()");
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
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

    @Override
    public void show() {
        this.getLogger().log(1078071040, "RouteInfoHandler#show()");
        this.showMixedList(true);
    }

    @Override
    public void forceRouteInfo(boolean bl) {
        this.getLogger().log(1078071040, "RouteInfoHandler#forceRouteInfo() - show: %1", bl);
        if (bl) {
            this.mShowMixedList = true;
            this.getGui().controlMixedList(1, 1);
        } else {
            this.mShowMixedList = false;
            this.getGui().controlMixedList(2, 0);
        }
    }

    @Override
    public void hide() {
        this.getLogger().log(1078071040, "RouteInfoHandler#hide()");
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
            this.getLogger().log(-2137614336, "RouteInfoHandler#showMixedList(): %1", (Object)new Buffer().append("routeInfoEnabled = ").append(bl2).append(", supportsAdditionalInfo = ").append(bl3).append(", isRouteInfoAllowedToFadeIn = ").append(bl4).append(", mRGActive = ").append(this.mRGActive).append(", mDelay = ").append(this.mDelay).toString());
            if (bl && bl2 && bl3 && !this.mDelay && this.mRGActive && bl4) {
                if (!this.mShowMixedList) {
                    this.getLogger().log(1078071040, "RouteInfoHandler#showMixedList(): SHOW");
                    this.mShowMixedList = true;
                    this.getGui().controlMixedList(1, 1);
                    this.setMixedListVisible(true);
                }
            } else if (this.mShowMixedList) {
                this.getLogger().log(1078071040, "RouteInfoHandler#showMixedList(): HIDE");
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

    @Override
    public boolean isMixedListVisible() {
        return this.mixedListVisible;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setMixedListVisible(boolean bl) {
        this.getLogger().log(-2137614336, "RouteInfoHandler#setMixedListVisible( %1 )", bl);
        RouteInfoHandler routeInfoHandler = this;
        synchronized (routeInfoHandler) {
            this.mixedListVisible = bl;
        }
    }

    @Override
    public void updateRgActive(boolean bl) {
        this.getLogger().log(-2137614336, "RouteInfoHandler#updateRgActive( %1 )", bl);
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
    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            this.mTravelData = new RouteInfoHandler$TravelData();
            this.mTravelData.rgDestinationInfo = navRouteListDataArray;
            if (navRouteListDataArray != null && navRouteListDataArray.length > 0) {
                for (int i2 = 0; i2 < navRouteListDataArray.length; ++i2) {
                    this.getLogger().log(1078071040, "RouteInfoHandler#updateRgDestinationInfo() - [%2] %1", (Object)NavRouteListDataWrapper.toShortString(navRouteListDataArray[i2]), (long)i2);
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
    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        if ((turnListElementArray = this.filterEtcElementsForG24(turnListElementArray)) == null) {
            this.getLogger().log(-1601830656, "RouteInfoHandler#updateRgTurnList() - turnList: null");
            return;
        }
        this.getLogger().log(1078071040, "RouteInfoHandler#updateRgTurnList() - turnList: %1", (long)turnListElementArray.length);
        if (this.getLogger().isDebug()) {
            for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
                this.getLogger().log(-2137614336, "RouteInfoHandler#updateRgTurnList() - [%2] %1", (Object)TurnListElementWrapper.toShortString(turnListElementArray[i2]), (long)i2);
            }
        }
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            TurnListElement[] turnListElementArray2 = this.removeSoftDestination(turnListElementArray);
            this.mMixedList.updateTurn(turnListElementArray2);
            if (!this.mTravelData.isTravelDataValid() && turnListElementArray2 != null && turnListElementArray2.length > 0) {
                this.getLogger().log(-1601830656, "RouteInfoHandler#updateRgTurnList() - invalid Travel data - wait for updateRgDestinationInfo.");
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
                this.getLogger().log(-1601830656, "RouteInfoHandler#updateRgTurnList() - turnList was filtered from length %1 to %2 ", (long)n2, (long)n);
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
                this.getLogger().log(-1601830656, "RouteInfoHandler#removeSoftDestination() - %1", (Throwable)exception);
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
                maneuverElementArray = this.helper.formatMillisecond(mixedListItem.getRttToCCP() * 0);
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
                stringArray = new Date(((TmcMessage)object2).getEventDelayOnRoute() * 0);
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
    @Override
    public void enableRouteInfoComplete(boolean bl) {
        boolean bl2;
        LogChannel logChannel = this.getLogger();
        logChannel.log(1078071040, "RouteInfoHandler#enableRouteInfoComplete( %1 )", bl);
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
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
    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        int n;
        int n2 = n = navPoiInfoArray == null ? 0 : navPoiInfoArray.length;
        if (navPoiInfoArray == null) {
            this.getLogger().log(10000, "RouteInfoHandler#updateRgPoiInfo() - rgPoiInfo: null");
            return;
        }
        this.getLogger().log(1078071040, "RouteInfoHandler#updateRgPoiInfo() - rgPoiInfo: %1", (long)n);
        if (this.getLogger().isDebug()) {
            for (int i2 = 0; i2 < n; ++i2) {
                this.getLogger().log(-2137614336, "RouteInfoHandler#updateRgPoiInfo() - [%2] %1", (Object)this.formatNavPoiInfoShort(navPoiInfoArray[i2]), (long)i2);
            }
        }
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            this.mMixedList.updatePOI(navPoiInfoArray);
            if (!this.mTravelData.isTravelDataValid()) {
                this.getLogger().log(-1601830656, "RouteInfoHandler#updateRgPoiInfo() - invalid Travel data - wait for updateRgDestinationInfo.");
                return;
            }
        }
        this.mergeList(0);
        this.logMixedList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        int n;
        int n2 = n = tmcMessageArray == null ? 0 : tmcMessageArray.length;
        if (tmcMessageArray == null) {
            this.getLogger().log(1078071040, "RouteInfoHandler#updateTmcMessagesAhead(): tmcMessagesAhead = null");
            return;
        }
        this.getLogger().log(1078071040, "RouteInfoHandler#updateTmcMessagesAhead(): tmcMessagesAhead.length = %1", (long)n);
        if (this.getLogger().isDebug()) {
            for (int i2 = 0; i2 < n; ++i2) {
                this.getLogger().log(-2137614336, "RouteInfoHandler#updateTmcMessagesAhead() - [%2] %1", (Object)tmcMessageArray[i2], (long)i2);
            }
        }
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            this.mMixedList.updateTMC(tmcMessageArray);
            if (!this.mTravelData.isTravelDataValid()) {
                this.getLogger().log(-1601830656, "RouteInfoHandler#updateTmcMessagesAhead() - invalid Travel data - wait for updateRgDestinationInfo.");
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
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            this.getLogger().log(14808325, "RouteInfoHandler#mergeList() - DTLD = %1, RTT = %2s, Reason = %3", this.getCurrentDistCarToFinalDest(), this.getCurrentRttCarToFinalDest(), (long)n);
            this.getLogger().log(14808325, "RouteInfoHandler#mergeList() - mixedList: %1", (Object)this.mMixedList);
            this.renderRouteInfo();
        }
    }

    private void logMixedList() {
        this.getLogger().log(-2137614336, "RouteInfoHandler#logMixedList() - mixedList: %1", (Object)this.mMixedList);
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
    @Override
    public void setTravelParameters(boolean bl, boolean bl2, long l, long l2, int n, int n2, long l3, long l4, int n3, int n4, int n5) {
        int n6 = (int)(l / 0);
        int n7 = (int)(l3 / 0);
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
        this.getLogger().log(14808325, "RouteInfoHandler#setTravelParameters() %1", (Object)buffer.toString());
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            boolean bl3;
            boolean bl4 = false;
            if (this.previousETAModeActive != bl) {
                this.previousETAModeActive = bl;
                bl4 = true;
            }
            GUIInterface gUIInterface = this.getGui();
            if (n != n2) {
                this.getLogger().log(14808325, "RouteInfoHandler#setTravelParameters() - delta distance: %1 ", (long)n2);
            }
            if (n3 != n4) {
                this.getLogger().log(14808325, "RouteInfoHandler#setTravelParameters() - delta distance to final destination: %1 ", (long)n4);
            }
            boolean bl5 = n > 0 && l > 0L;
            boolean bl6 = bl3 = this.env.getChoiceModel(-1122236928).getValue() == 1;
            if (this.riEnv.showETAandDistanceToNextStopover()) {
                gUIInterface.setDestDistanceNoUpdate(bl5, n);
                if (bl && !bl3) {
                    gUIInterface.setETA(l2, n8, bl4);
                } else {
                    gUIInterface.setRTT(l * 0, bl4);
                }
            } else {
                gUIInterface.setDestDistanceNoUpdate(bl5, n3);
                if (bl && !bl3) {
                    gUIInterface.setETA(l4, n9, bl4);
                } else {
                    gUIInterface.setRTT(l3 * 0, bl4);
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
            this.getLogger().log(-2137614336, "RouteInfoHandler#setDistAndRttToFinalDestinationWithoutMergeList() - Destination changed");
            this.mTravelData.indexOfCurrentDestination = n;
        }
        boolean bl2 = bl = l != this.mTravelData.mDistCarToFinalDest || l2 != this.mTravelData.mRttCarToFinalDest;
        if (!bl) {
            return false;
        }
        this.mTravelData.mDistCarToFinalDest = l;
        this.mTravelData.mRttCarToFinalDest = l2;
        this.getLogger().log(14808325, "RouteInfoHandler#setDistAndRttToFinalDestinationWithoutMergeList() - distCarToFinalDest:%1, rttCarToFinalDest:%2", this.mTravelData.mDistCarToFinalDest, this.mTravelData.mRttCarToFinalDest);
        bl = false;
        for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
            boolean bl3 = false;
            MixedListItem mixedListItem = this.mMixedList.getItem(i2);
            bl3 = mixedListItem.updateDistanceToCar(this.mTravelData.mDistCarToFinalDest);
            bl3 |= mixedListItem.updateRttToCar(this.mTravelData.mRttCarToFinalDest);
            this.getLogger().log(14808325, "RouteInfoHandler#setDistAndRttToFinalDestinationWithoutMergeList() Distance is updated to: %1", mixedListItem.getDistanceToCar());
            if (i2 >= 4) continue;
            bl |= bl3;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setDistAndRttToFinalDestination(long l, long l2, int n) {
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
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
    @Override
    public void setLanguage(String string) {
        this.getLogger().log(1078071040, "RouteInfoHandler#setLanguage(%1)", (Object)string);
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            this.mCalculatingListRow = this.createCalculatingListRow();
            for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
                int n;
                MixedListItem mixedListItem = this.mMixedList.getItem(i2);
                MixedListRow mixedListRow = mixedListItem.getMixedListRow();
                String string2 = this.env.getTranslatedText(4, "Calculating...");
                this.getLogger().log(1078071040, "RouteInfoHandler#setLanguage(): Calculating translated to: %1", (Object)string2);
                mixedListRow.setCellCalculating(string2);
                mixedListRow.updateDistanceToCCP();
                if (this.helper.isTurnElement(mixedListItem.getFormat()) && (n = mixedListRow.getInteger(20)) >= 69 && n <= 78) {
                    this.getLogger().log(14808325, "RouteInfoHandler#setLanguage(): image = %1", (long)n);
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
        this.getLogger().log(1078071040, "RouteInfoHandler#getDestName(): stopover#%1, destinations %2", (long)n3, (long)n2);
        if (n3 + 1 < n2) {
            string = this.env.getTranslatedText(21, "Stopover");
            this.getLogger().log(1078071040, "RouteInfoHandler#getDestName(): stopover");
        } else {
            string = this.env.getTranslatedText(14, "Destination");
            this.getLogger().log(1078071040, "RouteInfoHandler#getDestName(): destination");
        }
        return string;
    }

    @Override
    public void refreshDestinationFlag() {
        LogChannel logChannel = this.getLogger();
        logChannel.log(14808325, "RouteInfoHandler#refreshDestinationFlag(): enter");
        TurnListElement[] turnListElementArray = this.getNaviInterface().getNavigationMode() == 0 ? this.env.getContainer().getRgTurnList() : this.env.getRemoteContainer().getRgTurnList();
        this.updateRgTurnList(turnListElementArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void refreshDistAndRtt() {
        this.getLogger().log(1078071040, "RouteInfoHandler#refreshDistAndRtt() - distCarToFinalDest: %1m, rttCarToFinalDest: %2s", this.getCurrentDistCarToFinalDest(), this.getCurrentRttCarToFinalDest());
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
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
        logChannel.log(14808325, "RouteInfoHandler#getCountryFlagResourceID() - countryAbbreviation: '%1', countryInfo.length: %2", (Object)string, countryInfoArray == null ? 0L : (long)countryInfoArray.length);
        int n = -1;
        if (!Util.isEmpty(string) && countryInfoArray != null) {
            for (int i2 = 0; i2 < countryInfoArray.length; ++i2) {
                CountryInfo countryInfo = countryInfoArray[i2];
                if (countryInfo != null) {
                    logChannel.log(14808325, "RouteInfoHandler#getCountryFlagResourceID() - processing index %3: country: %1, abbreviation: %2", (Object)countryInfo.getName(), (Object)countryInfo.getCountryAbbreviation(), (long)i2);
                    if (!string.equals(countryInfo.getCountryAbbreviation())) continue;
                    int n2 = countryInfo.getIconIndex();
                    logChannel.log(14808325, "RouteInfoHandler#getCountryFlagResourceID() - found matching abbreviation at index %1, flagIndex: %2", (long)i2, (long)n2);
                    n = this.iconHandler.resolveCountryIconResourceID(n2);
                    if (n == -1) continue;
                    break;
                }
                logChannel.log(-1601830656, "RouteInfoHandler#getCountryFlagResourceID() - CountryInfo at index %1 is null!", (long)i2);
            }
        }
        logChannel.log(14808325, "RouteInfoHandler#getCountryFlagResourceID() - result: %1", (long)n);
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

    protected static MixedListItem getNextManeuver(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        for (int i2 = 0; i2 < routeInfoHandler$MixedData.mTurnList.size(); ++i2) {
            MixedListItem mixedListItem = routeInfoHandler$MixedData.mTurnList.getItem(i2);
            if (!mixedListItem.isRealTurnElement()) continue;
            return mixedListItem;
        }
        return null;
    }

    protected static MixedListItem getNextElementToShow(RouteInfoHandler$MixedData routeInfoHandler$MixedData, LogChannel logChannel) {
        for (int i2 = 0; i2 < routeInfoHandler$MixedData.size(); ++i2) {
            MixedListItem mixedListItem = routeInfoHandler$MixedData.getItem(i2);
            int n = mixedListItem.getFormat();
            if (!mixedListItem.isRealTurnElement() && n != 1 && n != 2 && n != 18 && n != 21 && n != 22) continue;
            return mixedListItem;
        }
        return null;
    }

    protected MixedListRow createMixedListRow(MixedListRow$IRouteInfoEnv mixedListRow$IRouteInfoEnv, LogChannel logChannel) {
        return new MixedListRow(mixedListRow$IRouteInfoEnv, logChannel);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object getItemByUID(long l) {
        Object object = null;
        RouteInfoHandler$MixedData routeInfoHandler$MixedData = this.mMixedList;
        synchronized (routeInfoHandler$MixedData) {
            for (int i2 = 0; i2 < this.mMixedList.size(); ++i2) {
                if (this.mMixedList.getItem(i2).getUID() != l) continue;
                object = this.mMixedList.getItem(i2).getEvent();
                break;
            }
        }
        return object;
    }

    static /* synthetic */ RouteInfoHelper access$000(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.helper;
    }

    static /* synthetic */ RouteInfoHandler$TravelData access$100(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.mTravelData;
    }

    static /* synthetic */ String access$200(RouteInfoHandler routeInfoHandler, int n) {
        return routeInfoHandler.getDestName(n);
    }

    static /* synthetic */ DateMetric access$300(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.mRTTMetric;
    }

    static /* synthetic */ MixedListRow access$700(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.mCalculatingListRow;
    }

    static /* synthetic */ boolean access$800(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.mRouteInfoComplete;
    }

    static /* synthetic */ RouteInfoElement[] access$900(RouteInfoHandler routeInfoHandler, MixedListItem[] mixedListItemArray) {
        return routeInfoHandler.createRouteInfoElement(mixedListItemArray);
    }

    static /* synthetic */ RouteInfoElement[] access$1002(RouteInfoHandler routeInfoHandler, RouteInfoElement[] routeInfoElementArray) {
        routeInfoHandler.mCurrentRouteInfoElement = routeInfoElementArray;
        return routeInfoElementArray;
    }

    static /* synthetic */ RouteInfoElement[] access$1000(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.mCurrentRouteInfoElement;
    }

    static /* synthetic */ void access$1100(RouteInfoHandler routeInfoHandler, RouteInfoElement[] routeInfoElementArray) {
        routeInfoHandler.writeKOMO(routeInfoElementArray);
    }

    static /* synthetic */ long access$1200(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.getCurrentDistCarToFinalDest();
    }

    static /* synthetic */ long access$1300(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.getCurrentRttCarToFinalDest();
    }

    static /* synthetic */ MixedListRow$IRouteInfoEnv access$1400(RouteInfoHandler routeInfoHandler) {
        return routeInfoHandler.routeInfoEnv;
    }

    static /* synthetic */ NavPoiInfo[] access$1502(RouteInfoHandler routeInfoHandler, NavPoiInfo[] navPoiInfoArray) {
        routeInfoHandler.pendingPOIs = navPoiInfoArray;
        return navPoiInfoArray;
    }
}

