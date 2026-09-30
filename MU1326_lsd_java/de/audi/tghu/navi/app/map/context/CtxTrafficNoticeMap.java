/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.tmc.TmcMessage;

public class CtxTrafficNoticeMap
extends CtxShown {
    private static final int ID_EVENT_MSG_LABEL = 401943;
    private static final int MINIMAL_ZOOM_SCALE = 3;
    private static final int TIME_DELAY = 10000;
    private final Timer contextSwitchDelayTimer;

    public CtxTrafficNoticeMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#constructor, CtxTrafficNoticeMap is initialized!");
        this.contextSwitchDelayTimer = new Timer("contextSwitchDelayTimer", 10000L, true, new DefaultTimerListener(){

            public synchronized void fireTimer(Timer timer) {
                CtxTrafficNoticeMap.this.getLogChannel().log(10000000, "CtxTrafficNoticeMap.Timer#fireTimer()");
                CtxTrafficNoticeMap.this.switchBackToShownContext();
            }
        });
    }

    public void enter() {
        super.enter();
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#enter()");
        TrafficEventMsgExtractor trafficEventMsgExtractor = new TrafficEventMsgExtractor(this.env);
        if (this.getMap().getMapDataContainer().isInMap) {
            this.env.getFramework().getHmiServiceApp().getLabelModel(401943).setText(trafficEventMsgExtractor.extractTrafficEventMsg(this.getData().trafficNoticeMessage));
            this.showPopup();
        }
        this.doEnterTENMMapState();
    }

    protected void doEnterTENMMapState() {
        IMapRequest iMapRequest = this.getMap().getMVRequest();
        this.getGUI().setTrafficNoticeMapActive(true);
        iMapRequest.setMode(2);
        iMapRequest.setViewType(0);
        iMapRequest.setOrientation(2);
        if (Util.isGoogleMapRestrictedPoiOnly(this.env.getFramework()) && this.naviMap.getMapInterface().isGoogleActive()) {
            iMapRequest.showTMCMessages(true);
        }
        iMapRequest.ensureTMCVisibility(this.getData().trafficNoticeMessage.messageID);
        Rect rect = this.getVisibleArea();
        int n = rect.kordX + (rect.diffX >> 1);
        int n2 = rect.kordY + (rect.diffY >> 1);
        this.setHotPoint(n, n2);
        iMapRequest.setMapViewPortByWGS84Rectangle(this.getData().trafficNoticeRectangle, 3);
        this.getMap().getNaviInterface().triggerEventAudioMessage(this.getData().trafficNoticeSoundID);
        this.hidePOIs(iMapRequest);
        this.restartTimer();
    }

    private void hidePOIs(IMapRequest iMapRequest) {
        iMapRequest.setGeneralPoiVisibility(false);
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#onDDSClicked()");
        this.switchBackToShownContext();
    }

    protected void onHKBackClicked() {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#onHKBackClicked()");
        this.switchBackToShownContext();
    }

    public void hkBackPressed() {
        this.hideTENM();
    }

    public void screenHidden() {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#screenHidden()");
        super.screenHidden();
        this.switchBackToShownContext();
    }

    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        super.indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#indicateTrafficEventNoticeMap() - message is(%1), NavRectangle is(%2), soundID is(%3)", (Object)tmcMessage, (Object)navRectangle, (long)n);
    }

    private void restartTimer() {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#restartTimer()");
        this.contextSwitchDelayTimer.start();
    }

    public void exit() {
        super.exit();
        this.contextSwitchDelayTimer.cancel();
        this.hidePopup();
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#exit()");
        this.getGUI().setTrafficNoticeMapActive(false);
        this.getMap().getMVRequest().ensureTMCVisibility(0L);
        this.showPOIs();
    }

    private void showPOIs() {
        this.getMap().getMVRequest().setGeneralPoiVisibility(true);
    }

    private void hidePopup() {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#hidePopup()");
        this.getMap().getMapManager().getPartialPopupHandler().showPopupTrafficeNoticeMap(false);
    }

    private void showPopup() {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#showPopup()");
        this.getMap().getMapManager().getPartialPopupHandler().showPopupTrafficeNoticeMap(true);
    }

    protected void switchBackToShownContext() {
        this.getLogChannel().log(100000000, "CtxTrafficNoticeMap#switchBackToShownContext()");
        this.hidePopup();
        this.getMap().switchToAShownContext();
    }

    public boolean supportsAdditionalInfo() {
        return true;
    }

    public synchronized void cleanup() {
        super.cleanup();
        this.contextSwitchDelayTimer.cancel();
    }

    public void informTENMPopupPosition(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#informTENMPopupPosition(), TENM popup rectangle: [%1] ", (Object)new Rect(n, n2, n3, n4));
        this.freezeMap();
        Rect rect = this.calculateZoomArea(new Rect(n, n2, n3, n4));
        this.getMap().getZoomHandler().setZoomArea(rect);
        this.getMapMain().getMVRequest().setMapViewPortByWGS84Rectangle(this.getData().trafficNoticeRectangle, 3);
        this.unfreezeMap();
    }

    private Rect calculateZoomArea(Rect rect) {
        Rect rect2 = this.getVisibleArea();
        int n = rect.getKordY() - rect2.getKordY();
        Rect rect3 = new Rect(rect2.getKordX(), rect2.getKordY(), rect2.getDiffX(), n);
        this.getLogChannel().log(10000000, "CtxTrafficNoticeMap#calculateZoomArea(), visibleArea:[%1], zooom area: [%2] ", (Object)rect2, (Object)rect3);
        return rect3;
    }
}

