/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.InfoHMIApplication;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRowBuilder;
import de.audi.tghu.info.app.tmc.readout.ReadOutSync;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutAllQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutOnRoadQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutOnRouteQueue;
import de.audi.tghu.info.app.tmc.readout.UrgentPopupHandler;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.DSITmcOnRoute;
import org.dsi.ifc.tmc.DSITmcOnRouteListener;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public class AppTMCReadOut
implements DSITmcOnRouteListener {
    protected LogChannel logChMain;
    private LogChannel logChDsi;
    private DSITmcOnRoute dsiTmcOnRoute;
    private TMCReadOutAllQueue tmcMsgQueue;
    private ReadOutSync sync;
    protected UrgentPopupHandler urgentPopupHandler;

    public ReadOutSync getSync() {
        return this.sync;
    }

    public AppTMCReadOut(LogChannel logChannel, LogChannel logChannel2, InfoEnv infoEnv) {
        this.logChMain = logChannel;
        this.logChDsi = logChannel2;
        ThreadPool threadPool = infoEnv.getFramework().getHMIThreadPool();
        this.tmcMsgQueue = new TMCReadOutAllQueue(this.logChMain, new TMCReadOutOnRouteQueue(this.logChMain, infoEnv), new TMCReadOutOnRoadQueue(this.logChMain, infoEnv), new TMCReadOutOnRoadQueue(this.logChMain, infoEnv));
        this.sync = new ReadOutSync(logChannel, this.tmcMsgQueue, infoEnv);
        this.tmcMsgQueue.setQueueListener(this.sync);
        threadPool.execute(this.sync);
    }

    public void setTTSService(TTSSingleSpeakService tTSSingleSpeakService) {
        this.sync.setTTSService(tTSSingleSpeakService);
    }

    public void setTTSServiceNoTel(TTSSingleSpeakService tTSSingleSpeakService) {
        this.sync.setTTSServiceNoTel(tTSSingleSpeakService);
    }

    public void setHmiApplication(InfoHMIApplication infoHMIApplication) {
        this.urgentPopupHandler.setHmiApplication(infoHMIApplication);
    }

    public void setListRowBuilder(TMCAbstractListRowBuilder tMCAbstractListRowBuilder) {
        this.urgentPopupHandler.setListRowBuilder(tMCAbstractListRowBuilder);
    }

    public UrgentPopupHandler getUrgentPopupHandler() {
        return this.urgentPopupHandler;
    }

    public TMCReadOutAllQueue getGeneralReadOutQueue() {
        return this.tmcMsgQueue;
    }

    public TTSSingleSpeakService getTTSService() {
        return this.sync.getTTSService();
    }

    public void setTmcOnRoute(DSITmcOnRoute dSITmcOnRoute) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#setTmcOnRoute] DSITmcOnRoute was found and is set on AppTMCReadOut application. ");
        this.dsiTmcOnRoute = dSITmcOnRoute;
        try {
            this.dsiTmcOnRoute.setNotification(new int[]{1, 2}, (DSIListener)this);
        }
        catch (Exception exception) {
            this.logChMain.log(10000, "[AppTMCReadOut#setTmcOnRoute] ERROR = %1", (Throwable)exception);
        }
        this.logChMain.log(-2137614336, "[AppTMCReadOut#setTmcOnRoute] Notifications set.");
    }

    public void releaseTmcOnRoute() {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#releaseTmcOnRoute] DSITmcOnRoute is removed from AppTMCReadOut application.");
        this.dsiTmcOnRoute.clearNotification(this);
        this.dsiTmcOnRoute = null;
    }

    public void setReadOutMode(int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#setReadOutMode] Called, mode: %1 ", (long)n);
        this.tmcMsgQueue.setReadOutMode(n);
    }

    public boolean isCurrentlySpeaking() {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#isCurrentlySpeaking] Called. ");
        return this.sync.isCurrentlySpeaking();
    }

    TMCReadOutMessage getCurrentMessage() {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#getCurrentMessage] Called. ");
        return this.sync.getCurrentMessage();
    }

    long getCurrentMessageId() {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#getCurrentMessageId] Called. ");
        return this.sync.getCurrentMessageId();
    }

    public void stop() {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#stop] Called. ");
        this.sync.stop();
    }

    public void updateDistanceToDestination(long l) {
        if (this.logChMain.isDebug2()) {
            this.logChMain.log(14808325, "[AppTMCReadOut#updateDistanceToDestination] Called, distance: %1 ", l);
        }
        this.sync.distanceToDestinationUpdated(l);
    }

    public int repeatOrAbortTmcMessageReadOutSince(long l) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#repeatOrAbortTmcMessageReadOutSince] Called, timestamp: %1 ", l);
        return this.sync.repeatOrAbortTmcMessageReadOutSince(l);
    }

    public void setTimeForAnnouncement(long l) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#setTimeForAnnouncement] Called, time: %1 ", l);
        this.sync.setTimeForAnnouncement(l);
    }

    public void urgentPopupRemoved() {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#urgentPopupRemoved] Called. ");
        this.urgentPopupHandler.urgentPopupRemoved();
    }

    @Override
    public void updateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
        if (n == 1) {
            TmcMessage[] tmcMessageArray2;
            String string = tmcMessageArray == null ? "null" : String.valueOf(tmcMessageArray.length);
            this.logChDsi.log(-2137614336, "[AppTMCReadOut#updateUrgentMessagesExt] Called, number: %1 ", (Object)string);
            TmcMessage[] tmcMessageArray3 = tmcMessageArray2 = tmcMessageArray == null ? new TmcMessage[]{} : tmcMessageArray;
            if (this.sync.checkSetupNavAnnouncementsEnabled()) {
                this.sync.updateTmcUrgentMessages(tmcMessageArray2);
            }
            this.urgentPopupHandler.updateTmcUrgentMessages(tmcMessageArray2);
        } else {
            this.logChDsi.log(-2137614336, "[AppTMCReadOut#updateUrgentMessagesExt] Invalid value! ");
        }
    }

    @Override
    public void tmcMessage(TmcMessage tmcMessage) {
        this.logChDsi.log(-2137614336, "[AppTMCReadOut#tmcMessage] Called. ");
    }

    @Override
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        if (n == 1) {
            String string = tmcMessageArray == null ? "null" : String.valueOf(tmcMessageArray.length);
            this.logChDsi.log(-2137614336, "[AppTMCReadOut#updateTmcMessagesAhead] Called, number: %1 ", (Object)string);
            this.logChDsi.log(1078071040, "[AppTMCReadOut#updateTmcMessagesAhead] TMC on-route/on-road messages are not handled by TMC HMI.");
        } else {
            this.logChDsi.log(-2137614336, "[AppTMCReadOut#updateTmcMessagesAhead] Invalid value! ");
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChDsi.log(-2137614336, "[AppTMCReadOut#asyncException] Error code: %1, error msg: %2, request type: %3 ", (Object)new Integer(n), (Object)string, (Object)new Integer(n2));
    }

    @Override
    public void updateTmcMessagesAheadCalculationHorizon(long l, int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#updateTmcMessagesAheadCalculationHorizon] Called, arg0:%1, arg1: %2", l, (long)n);
    }

    @Override
    public void setTmcWarningModeResult(int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#setTmcWarningModeResult] Called, resultCode:%1", (long)n);
    }

    public void updateRgActive(boolean bl) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#updateRgActive] Called, active: %1", bl);
        this.sync.setRgActive(bl);
    }

    @Override
    public void updateCurrentlyBlockedTMCMessages(long[] lArray, int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#updateCurrentlyBlockedTMCMessages] Called, arg0:%1", (Object)lArray);
    }

    @Override
    public void blockTMCMessagesResult(long[] lArray, long[] lArray2) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#blockTMCMessagesResult] Called, arg0:%1, arg1:%2", (Object)lArray, (Object)lArray2);
    }

    @Override
    public void unblockTMCMessagesResult(long[] lArray, long[] lArray2) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#unblockTMCMessagesResult] Called, arg0:%1, arg1:%2", (Object)lArray, (Object)lArray2);
    }

    @Override
    public void unblockAllTMCMessagesResult(int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#unblockAllTMCMessagesResult] Called, arg0:%1", (long)n);
    }

    @Override
    public void updateNaviCoreAvailableToChangeTMCBlockings(int n, int n2) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#updateNaviCoreAvailableToChangeTMCBlockings] Called, arg0:%1", (long)n);
    }

    @Override
    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#indicateTrafficEventNoticeMap] Called, arg0:%1, arg1:%2, arg2:%3", (Object)tmcMessage, (Object)navRectangle, (long)n);
    }

    public void setTmcApp(AppTMC appTMC) {
        this.urgentPopupHandler.setTmcApp(appTMC);
    }

    @Override
    public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] speedAndFlowSegmentArray, int n) {
        this.logChMain.log(-2137614336, "[AppTMCReadOut#updateSpeedAndFlowAhead] Called, segments=%1", (Object)speedAndFlowSegmentArray);
    }
}

