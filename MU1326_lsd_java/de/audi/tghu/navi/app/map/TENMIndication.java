/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.ITENMIndication;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcMessage;

public class TENMIndication
implements ITENMIndication {
    private final NavigationEnv env;
    private final MapMain mapMain;
    private final LogChannel mLogChannel;
    private final Timer trafficEventNoticePopupRemovalTimer;
    private static final int TIME_DELAY = 10000;

    public TENMIndication(NavigationEnv navigationEnv, MapMain mapMain) {
        this.env = navigationEnv;
        this.mapMain = mapMain;
        this.mLogChannel = navigationEnv.getMapMainLogChannel();
        this.trafficEventNoticePopupRemovalTimer = new Timer("TENMIndication.contextSwitchDelayTimer", 10000L, true, new DefaultTimerListener(){

            public synchronized void fireTimer(Timer timer) {
                TENMIndication.this.hideTrafficEventNoticePopup();
            }
        });
    }

    public void cleanup() {
        this.trafficEventNoticePopupRemovalTimer.cancel();
    }

    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.mLogChannel.log(10000000, "TENMIndication#indicateTrafficEventNoticeMap( =%1 ) and soundID is( =%2 )", (Object)(tmcMessage == null ? "message is null" : "message is not null"), (long)n);
        boolean bl = this.checkSetupEnablement();
        boolean bl2 = this.mapMain.getMapManager().getCruiseModeHandler().isInCruiseMode();
        int n2 = this.env.getFramework().getHmiServiceApp().getCurrentPopup();
        boolean bl3 = this.mapMain.getMapDataContainer().vicsEmergencyPopupShown;
        if (this.isTENMInterruptionAllowed(bl, bl2, n2, bl3)) {
            if (Util.isGoogleMapRestricted(this.env.getFramework()) && this.mapMain.getSatellitemapsManager().isSatelliteMapActive()) {
                if (tmcMessage == null) {
                    this.mLogChannel.log(10000, "TENMIndication#indicateTrafficEventNoticeMap() - data not valid - return! message: %1", (Object)tmcMessage);
                    return;
                }
                this.mLogChannel.log(10000000, "TENMIndication#indicateTrafficEventNoticeMap() - Indicate TENM for reduced mode");
                this.notifyTENMInReducedMode(tmcMessage, navRectangle, n);
            } else {
                if (tmcMessage == null || navRectangle == null) {
                    this.mLogChannel.log(10000, "TENMIndication#indicateTrafficEventNoticeMap() - data not valid - return! message: %1 rectangle:%2", (Object)tmcMessage, (Object)navRectangle);
                    return;
                }
                this.mLogChannel.log(10000000, "TENMIndication#indicateTrafficEventNoticeMap() - Indicate TENM for normal mode");
                this.notifyTENMInNormalMode(tmcMessage, navRectangle, n);
            }
        }
    }

    private boolean checkSetupEnablement() {
        if (Util.isPorsche(this.env.getFramework())) {
            return this.env.getChoiceModel(401832).getValue() == 1;
        }
        if (Util.isHURegionJP()) {
            return this.env.getChoiceModel(900026).getValue() == 1;
        }
        return this.env.getChoiceModel(401832).getValue() == 1;
    }

    private void notifyTENMInNormalMode(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.mapMain.getActiveContext().indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
        this.mapMain.switchToContext(36);
    }

    private void notifyTENMInReducedMode(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.mapMain.getActiveContext().indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
        TrafficEventMsgExtractor trafficEventMsgExtractor = new TrafficEventMsgExtractor(this.env);
        this.env.getFramework().getHmiServiceApp().getLabelModel(401943).setText(trafficEventMsgExtractor.extractTrafficEventMsg(this.mapMain.getMapDataContainer().trafficNoticeMessage));
        if (this.mapMain.getMapDataContainer().isInMap) {
            this.showTrafficEventNoticePopup();
        }
        this.mapMain.getNaviInterface().triggerEventAudioMessage(this.mapMain.getMapDataContainer().trafficNoticeSoundID);
        this.trafficEventNoticePopupRemovalTimer.start();
    }

    private void showTrafficEventNoticePopup() {
        this.mLogChannel.log(10000000, "TENMIndicationHandler#showTrafficEventNoticePopup()");
        this.mapMain.getMapManager().getPartialPopupHandler().showPopupTrafficeNoticeMap(true);
    }

    private boolean isTENMInterruptionAllowed(boolean bl, boolean bl2, int n, boolean bl3) {
        this.mLogChannel.log(10000000, "TENMIndicationHandler#isTENMInterruptionAllowed() - isTrafficNoticeMapOn: %1, isInCruiseMode: %2, popupVisible: %3 ", (Object)bl, (Object)bl2, (long)n);
        this.mLogChannel.log(10000000, "TENMIndicationHandler#isTENMInterruptionAllowed() - isVicsEmergencyPopupShown: %1 ", bl3);
        return bl && bl2 && n == -1 && !bl3;
    }

    private void hideTrafficEventNoticePopup() {
        this.mLogChannel.log(10000000, "TENMIndicationHandler#hideTrafficEventNoticePopup()");
        this.mapMain.getMapManager().getPartialPopupHandler().showPopupTrafficeNoticeMap(false);
    }

    protected MapMain getMapMain() {
        return this.mapMain;
    }

    protected LogChannel getLogChannel() {
        return this.mLogChannel;
    }
}

