/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;

public class CtxScrollOnRoute
extends CtxFreeMap {
    private static final String TIMER_INFO = "infoTimer";
    private static final String TIMER_CCP_CHANGED = "ccpChangeTimer";
    private static final String TIMER_DDS_CHANGED = "ddsChangeTimer";
    private static final long DELAY_INFO_TIMER = 250L;
    private static final long DELAY_CCP_CHANGED_TIMER = 10000L;
    private static final long DELAY_DDS_CHANGED_TIMER = 2000L;
    private int distanceToDest = 0;
    private NavLocationWgs84 mapPosition = null;
    private int distanceToCCP = 0;

    public CtxScrollOnRoute(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        if (this.container.sInfoTimer == null) {
            this.container.sInfoTimer = new InfoTimer(TIMER_INFO, 250L);
        }
        if (this.container.sCcpChangeTimer == null) {
            this.container.sCcpChangeTimer = new InfoTimer(TIMER_CCP_CHANGED, 10000L);
        }
        if (this.container.sDdsChangeTimer == null) {
            this.container.sDdsChangeTimer = new InfoTimer(TIMER_DDS_CHANGED, 2000L);
        }
    }

    private void cancelAllTimer() {
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#cancelAllTimer()");
        this.getInfoTimer().cancel();
        this.getCcpChangeTimer().cancel();
        this.getDdsChangeTimer().cancel();
    }

    public synchronized void cleanup() {
        super.cleanup();
        this.cancelAllTimer();
    }

    private InfoTimer getInfoTimer() {
        return (InfoTimer)this.container.sInfoTimer;
    }

    private InfoTimer getCcpChangeTimer() {
        return (InfoTimer)this.container.sCcpChangeTimer;
    }

    private InfoTimer getDdsChangeTimer() {
        return (InfoTimer)this.container.sDdsChangeTimer;
    }

    public void enter() {
        super.enter();
        this.shutdownAdditionalInfos();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        this.requestPreferredViewType();
        if (this.container.sNeedToSetScrollOnRoutePosition) {
            this.container.sNeedToSetScrollOnRoutePosition = false;
            int n = 1;
            if (this.getSetupMapType() == 0 && this.getRGActive()) {
                n = 0;
            }
            iMapRequest.rbSetPosition(n);
            if (n == 0) {
                this.requestIdOfSelectedSegment();
            }
        } else {
            this.requestIdOfSelectedSegment();
        }
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = gUIInterface.getScreenHeight();
        if (this.getSetupMapType() == 2) {
            n = (int)((float)n * 1.28125f);
        }
        int n2 = gUIInterface.getScreenWidth() >> 1;
        int n3 = n >> 1;
        this.setHotPoint(n2, n3);
        this.updateCrosshairsColor();
        iMapRequest.setMode(5);
        this.distanceToDest = 0;
    }

    public void exit() {
        super.exit();
        this.cancelAllTimer();
    }

    public void exitMapScreen() {
        super.exitMapScreen();
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#exitMapScreen(): forceContext to cScrollOnRoute (%1)", 17L);
        this.naviMap.forceContext(17);
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#updateMapPosition()");
        super.updateMapPosition(navLocationWgs84);
        this.mapPosition = navLocationWgs84;
        this.getInfoTimer().restart();
        this.updateRRDPopup();
    }

    private void updateRRDPopup() {
        if (this.mapPosition != null && this.distanceToCCP > 0) {
            PosPosition posPosition = this.getMap().getNaviInterface().getVehicle().getPosition();
            short s = this.getMapRotation();
            int n = Util.computeAbsoluteDirection(posPosition, this.mapPosition.getLongitude(), this.mapPosition.getLatitude());
            int n2 = Util.convertRotatingDirection((n + 180) % 360, (360 - s) % 360) + 1;
            this.naviMap.getGuiInterface().setScrollAlongRouteDirection(n2);
            this.naviMap.getGuiInterface().setScrollAlongRouteDistance(Util.formatDistance(this.distanceToCCP, 1));
        } else {
            this.naviMap.getGuiInterface().setScrollAlongRouteDirectionAndDistanceVisible(false);
        }
    }

    public void updateDestDistance(int n) {
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#updateDestDistance() - distance: %1, distanceToDest: %2", (long)n, (long)this.distanceToDest);
        if (!this.getDdsChangeTimer().isRunning() && !this.getCcpChangeTimer().isRunning() && this.distanceToDest != n) {
            this.getCcpChangeTimer().restart();
        }
        this.distanceToDest = n;
    }

    public void joystick(int n, int n2) {
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2) {
        switch (n) {
            case 400492: {
                if (this.naviMap.getGuiInterface().getScrollOnRoutePressed()) {
                    this.naviMap.getGuiInterface().setScrollOnRoutePressed(false);
                    this.naviMap.switchToContext(12);
                    break;
                }
                this.naviMap.getGuiInterface().setScrollOnRoutePressed(true);
                break;
            }
        }
    }

    public void keyPressed(int n, int n2) {
        switch (n) {
            case 400492: {
                if (this.naviMap.getGuiInterface().getScrollOnRoutePressed()) {
                    this.naviMap.getGuiInterface().setScrollOnRoutePressed(false);
                    this.naviMap.switchToContext(12);
                    break;
                }
                this.naviMap.getGuiInterface().setScrollOnRoutePressed(true);
                break;
            }
            default: {
                super.keyPressed(n, n2);
            }
        }
    }

    public void keyReleased(int n, int n2) {
        super.keyReleased(n, n2);
        if (n == 400492) {
            this.naviMap.getGuiInterface().setScrollOnRoutePressed(false);
            this.naviMap.switchToContext(12);
        }
    }

    public void increment(int n, int n2) {
        if (n == 400492) {
            int n3;
            this.getLogChannel().log(10000000, "CtxScrollOnRoute#increment() - steps: %1", (long)n2);
            boolean bl = n2 > 0;
            int n4 = n3 = bl ? n2 : -n2;
            if (bl) {
                for (int i2 = 0; i2 < n3; ++i2) {
                    this.naviMap.getMVRequest().rbSelectNextSegment();
                }
            } else {
                for (int i3 = 0; i3 < n3; ++i3) {
                    this.naviMap.getMVRequest().rbSelectPreviousSegment();
                }
            }
            this.getCcpChangeTimer().cancel();
            this.getDdsChangeTimer().restart();
            this.naviMap.getGuiInterface().setScrollAlongRouteDirectionAndDistanceVisible(false);
        }
        super.increment(n, n2);
    }

    public void rbGetIDOfSelectedSegmentResult(long l) {
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#rbGetIDOfSelectedSegmentResult() - segmentUid: %1", l);
        super.rbGetIDOfSelectedSegmentResult(l);
        this.naviMap.getMVRequest().rbGetRRDToSelectedSegment(l);
    }

    public void rbGetRRDToSelectedSegmentResult(long l, int n) {
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#rbGetRRDToSelectedSegmentResult() - segmentUid: %1, rrdToSegment: %2", l, (long)n);
        super.rbGetRRDToSelectedSegmentResult(l, n);
        this.distanceToCCP = n;
        if (n <= 0) {
            this.naviMap.getGuiInterface().setScrollAlongRouteDirectionAndDistanceVisible(false);
        } else {
            this.updateRRDPopup();
            this.naviMap.getGuiInterface().setScrollAlongRouteDirectionAndDistanceVisible(true);
        }
    }

    protected void requestIdOfSelectedSegment() {
        this.getLogChannel().log(10000000, "CtxScrollOnRoute#requestIdOfSelectedSegment()");
        this.naviMap.getMVRequest().rbGetIDOfSelectedSegment();
    }

    private final class InfoTimer
    implements TimerListener {
        private final Timer mTimer;

        InfoTimer(String string, long l) {
            this.mTimer = new Timer(string, l, true, this);
        }

        private void restart() {
            CtxScrollOnRoute.this.getLogChannel().log(10000000, "CtxScrollOnRoute#InfoTimer#restart() - restart %1", (Object)this.mTimer.getName());
            this.mTimer.restart();
        }

        private void cancel() {
            CtxScrollOnRoute.this.getLogChannel().log(10000000, "CtxScrollOnRoute#InfoTimer#cancel() - cancel %1", (Object)this.mTimer.getName());
            this.mTimer.cancel();
        }

        public void fireTimer(Timer timer) {
            CtxScrollOnRoute.this.getLogChannel().log(10000000, "CtxScrollOnRoute#InfoTimer#fireTimer() - %1 fired", (Object)timer.getName());
            if (timer.getName().equals(CtxScrollOnRoute.TIMER_INFO)) {
                CtxScrollOnRoute.this.requestInfoForPosition(true);
            } else if (timer.getName().equals(CtxScrollOnRoute.TIMER_CCP_CHANGED) || timer.getName().equals(CtxScrollOnRoute.TIMER_DDS_CHANGED)) {
                CtxScrollOnRoute.this.requestIdOfSelectedSegment();
            } else {
                CtxScrollOnRoute.this.getLogChannel().log(100000, "CtxScrollOnRoute#InfoTimer#fireTimer() - unknown timer: %1", (Object)timer.getName());
            }
        }

        public void cancelTimer(Timer timer) {
        }

        public boolean isRunning() {
            return this.mTimer.isRunning();
        }
    }
}

