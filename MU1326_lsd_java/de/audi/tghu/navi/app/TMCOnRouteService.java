/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.map.MapInterface;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.DSITmcOnRouteListener;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public class TMCOnRouteService
implements DSITmcOnRouteListener {
    protected LogChannel logChannel;
    protected LogChannel dsiLogChannel;
    private DSITmcOnRoute tmcOnRoute;
    private final MapInterface mapInterface;
    private final ClusterService clusterService;
    private final NaviServiceListenerController naviServiceListenerController;

    public TMCOnRouteService(NavigationEnv navigationEnv, MapInterface mapInterface, ClusterService clusterService, NaviServiceListenerController naviServiceListenerController) {
        this.logChannel = navigationEnv.getLogChannel();
        this.dsiLogChannel = navigationEnv.getDSILogChannel();
        this.mapInterface = mapInterface;
        this.clusterService = clusterService;
        this.naviServiceListenerController = naviServiceListenerController;
        this.logChannel.log(-2137614336, "TMCOnRouteService#TMCOnRouteService() ");
    }

    public void setDSI(DSITmcOnRoute dSITmcOnRoute) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(-2137614336, "TMCOnRouteService#setDSI( %1 ) ", (Object)this.tmcOnRoute);
        }
        this.tmcOnRoute = dSITmcOnRoute;
        if (this.tmcOnRoute != null) {
            this.dsiLogChannel.log(-2137614336, "TMCOnRouteService#setDSI() - Notification(ATTR_TMCMESSAGESAHEAD, ATTR_URGENTMESSAGES) ");
            try {
                this.tmcOnRoute.setNotification(new int[]{1, 2}, (DSIListener)this);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "TMCOnRouteService#setDSI(): ERROR = %1", (Throwable)exception);
            }
        }
    }

    public void getTmcMessage(int n) {
        this.logChannel.log(-2137614336, "TMCOnRouteService#getTmcMessage() ");
        try {
            this.tmcOnRoute.getTmcMessage(n);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "TMCOnRouteService#getTmcMessage(): ERROR = %1", (Throwable)exception);
        }
    }

    @Override
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        this.dsiLogChannel.log(-2137614336, "TMCOnRouteService#updateTmcMessagesAhead() length: %1, validFlag: %2 ", tmcMessageArray == null ? 0L : (long)tmcMessageArray.length, (long)n);
        if (n == 1) {
            try {
                this.mapInterface.updateTmcMessagesAhead(tmcMessageArray);
                this.clusterService.updateMessagesOnRoute(tmcMessageArray);
                this.naviServiceListenerController.updateTmcMessagesAhead(tmcMessageArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "TMCOnRouteService#updateTmcMessagesAhead(): ERROR = %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
        this.dsiLogChannel.log(-2137614336, "TMCOnRouteService#updateUrgentMessages() ");
        if (n == 1) {
            try {
                this.clusterService.updateXUrgentMessages(tmcMessageArray);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "TMCOnRouteService#updateUrgentMessages(): ERROR = %1", (Throwable)exception);
            }
        }
    }

    @Override
    public void tmcMessage(TmcMessage tmcMessage) {
        this.dsiLogChannel.log(-2137614336, "TMCOnRouteService#tmcMessage() ");
        try {
            this.mapInterface.updateTmcMessage(tmcMessage);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "TMCOnRouteService#tmcMessage(): ERROR = %1", (Throwable)exception);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.dsiLogChannel.log(10000, "TMCOnRouteService#asyncException(%1, %2) ", (Object)string, (long)n2);
    }

    @Override
    public void updateTmcMessagesAheadCalculationHorizon(long l, int n) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#updateTmcMessagesAheadCalculationHorizon( %1 ) - unexpected call!", l);
    }

    @Override
    public void setTmcWarningModeResult(int n) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#setTmcWarningModeResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void updateCurrentlyBlockedTMCMessages(long[] lArray, int n) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#updateCurrentlyBlockedTMCMessages( %1 ) - unexpected call!", (Object)lArray);
    }

    @Override
    public void blockTMCMessagesResult(long[] lArray, long[] lArray2) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#blockTMCMessagesResult( %1, %2 ) - unexpected call!", (Object)lArray, (Object)lArray2);
    }

    @Override
    public void unblockTMCMessagesResult(long[] lArray, long[] lArray2) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#unblockTMCMessagesResult( %1, %2 ) - unexpected call!", (Object)lArray, (Object)lArray2);
    }

    @Override
    public void unblockAllTMCMessagesResult(int n) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#unblockAllTMCMessagesResult( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void updateNaviCoreAvailableToChangeTMCBlockings(int n, int n2) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#updateNaviCoreAvailableToChangeTMCBlockings( %1 ) - unexpected call!", (long)n);
    }

    @Override
    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.dsiLogChannel.log(-2137614336, "TMCOnRouteService#indicateTrafficEventNoticeMap( =%1 ) and soundID is( =%2 )", (Object)(tmcMessage == null ? "message is null" : "message is not null"), (long)n);
        try {
            this.mapInterface.indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "TMCOnRouteService#indicateTrafficEventNoticeMap(): ERROR = %1", (Throwable)exception);
        }
    }

    @Override
    public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] speedAndFlowSegmentArray, int n) {
        this.dsiLogChannel.log(-1601830656, "TMCOnRouteService#updateSpeedAndFlowAhead( %1 )", (Object)speedAndFlowSegmentArray);
    }
}

