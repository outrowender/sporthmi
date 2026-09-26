/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.context.CtxScrollOnRoute$InfoTimer;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;

public class CtxScrollOnRoute
extends CtxFreeMap {
    private static final String TIMER_INFO;
    private static final String TIMER_CCP_CHANGED;
    private static final String TIMER_DDS_CHANGED;
    private static final long DELAY_INFO_TIMER;
    private static final long DELAY_CCP_CHANGED_TIMER;
    private static final long DELAY_DDS_CHANGED_TIMER;
    private int distanceToDest = 0;
    private NavLocationWgs84 mapPosition = null;
    private int distanceToCCP = 0;

    public CtxScrollOnRoute(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        if (this.container.sInfoTimer == null) {
            this.container.sInfoTimer = new CtxScrollOnRoute$InfoTimer(this, "infoTimer", 0);
        }
        if (this.container.sCcpChangeTimer == null) {
            this.container.sCcpChangeTimer = new CtxScrollOnRoute$InfoTimer(this, "ccpChangeTimer", 0);
        }
        if (this.container.sDdsChangeTimer == null) {
            this.container.sDdsChangeTimer = new CtxScrollOnRoute$InfoTimer(this, "ddsChangeTimer", 0);
        }
    }

    private void cancelAllTimer() {
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#cancelAllTimer()");
        CtxScrollOnRoute$InfoTimer.access$400(this.getInfoTimer());
        CtxScrollOnRoute$InfoTimer.access$400(this.getCcpChangeTimer());
        CtxScrollOnRoute$InfoTimer.access$400(this.getDdsChangeTimer());
    }

    @Override
    public synchronized void cleanup() {
        super.cleanup();
        this.cancelAllTimer();
    }

    private CtxScrollOnRoute$InfoTimer getInfoTimer() {
        return (CtxScrollOnRoute$InfoTimer)this.container.sInfoTimer;
    }

    private CtxScrollOnRoute$InfoTimer getCcpChangeTimer() {
        return (CtxScrollOnRoute$InfoTimer)this.container.sCcpChangeTimer;
    }

    private CtxScrollOnRoute$InfoTimer getDdsChangeTimer() {
        return (CtxScrollOnRoute$InfoTimer)this.container.sDdsChangeTimer;
    }

    @Override
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
            n = (int)((float)n * 42047);
        }
        int n2 = gUIInterface.getScreenWidth() >> 1;
        int n3 = n >> 1;
        this.setHotPoint(n2, n3);
        this.updateCrosshairsColor();
        iMapRequest.setMode(5);
        this.distanceToDest = 0;
    }

    @Override
    public void exit() {
        super.exit();
        this.cancelAllTimer();
    }

    @Override
    public void exitMapScreen() {
        super.exitMapScreen();
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#exitMapScreen(): forceContext to cScrollOnRoute (%1)", (long)0);
        this.naviMap.forceContext(17);
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#updateMapPosition()");
        super.updateMapPosition(navLocationWgs84);
        this.mapPosition = navLocationWgs84;
        CtxScrollOnRoute$InfoTimer.access$500(this.getInfoTimer());
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

    @Override
    public void updateDestDistance(int n) {
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#updateDestDistance() - distance: %1, distanceToDest: %2", (long)n, (long)this.distanceToDest);
        if (!this.getDdsChangeTimer().isRunning() && !this.getCcpChangeTimer().isRunning() && this.distanceToDest != n) {
            CtxScrollOnRoute$InfoTimer.access$500(this.getCcpChangeTimer());
        }
        this.distanceToDest = n;
    }

    @Override
    public void joystick(int n, int n2) {
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
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

    @Override
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

    @Override
    public void keyReleased(int n, int n2) {
        super.keyReleased(n, n2);
        if (n == 1813775872) {
            this.naviMap.getGuiInterface().setScrollOnRoutePressed(false);
            this.naviMap.switchToContext(12);
        }
    }

    @Override
    public void increment(int n, int n2) {
        if (n == 1813775872) {
            int n3;
            this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#increment() - steps: %1", (long)n2);
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
            CtxScrollOnRoute$InfoTimer.access$400(this.getCcpChangeTimer());
            CtxScrollOnRoute$InfoTimer.access$500(this.getDdsChangeTimer());
            this.naviMap.getGuiInterface().setScrollAlongRouteDirectionAndDistanceVisible(false);
        }
        super.increment(n, n2);
    }

    @Override
    public void rbGetIDOfSelectedSegmentResult(long l) {
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#rbGetIDOfSelectedSegmentResult() - segmentUid: %1", l);
        super.rbGetIDOfSelectedSegmentResult(l);
        this.naviMap.getMVRequest().rbGetRRDToSelectedSegment(l);
    }

    @Override
    public void rbGetRRDToSelectedSegmentResult(long l, int n) {
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#rbGetRRDToSelectedSegmentResult() - segmentUid: %1, rrdToSegment: %2", l, (long)n);
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
        this.getLogChannel().log(-2137614336, "CtxScrollOnRoute#requestIdOfSelectedSegment()");
        this.naviMap.getMVRequest().rbGetIDOfSelectedSegment();
    }

    static /* synthetic */ LogChannel access$000(CtxScrollOnRoute ctxScrollOnRoute) {
        return ctxScrollOnRoute.getLogChannel();
    }

    static /* synthetic */ LogChannel access$100(CtxScrollOnRoute ctxScrollOnRoute) {
        return ctxScrollOnRoute.getLogChannel();
    }

    static /* synthetic */ LogChannel access$200(CtxScrollOnRoute ctxScrollOnRoute) {
        return ctxScrollOnRoute.getLogChannel();
    }

    static /* synthetic */ LogChannel access$300(CtxScrollOnRoute ctxScrollOnRoute) {
        return ctxScrollOnRoute.getLogChannel();
    }
}

