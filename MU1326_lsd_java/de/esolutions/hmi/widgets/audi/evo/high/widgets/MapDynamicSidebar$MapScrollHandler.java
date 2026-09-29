/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapDynamicSidebar;

public final class MapDynamicSidebar$MapScrollHandler
implements ATIPEventListener {
    private static final int EVENT_CYCLE;
    private static final int V_START;
    private static final float V_SCALE;
    private static final int DEGREE_PER_TICK_NAVI;
    private static final float DEGREE_PER_TICK_WIDGET;
    private static final float DEGREE_DIRECTION_N;
    private static final float DEGREE_DIRECTION_NNE;
    private static final float DEGREE_DIRECTION_NE;
    private static final float DEGREE_DIRECTION_ENE;
    private static final float DEGREE_DIRECTION_E;
    private static final float DEGREE_DIRECTION_ESE;
    private static final float DEGREE_DIRECTION_SE;
    private static final float DEGREE_DIRECTION_SSE;
    private static final float DEGREE_DIRECTION_S;
    private static final float DEGREE_DIRECTION_SSW;
    private static final float DEGREE_DIRECTION_SW;
    private static final float DEGREE_DIRECTION_WSW;
    private static final float DEGREE_DIRECTION_W;
    private static final float DEGREE_DIRECTION_WNW;
    private static final float DEGREE_DIRECTION_NW;
    private static final float DEGREE_DIRECTION_NNW;
    private static final float DEGREE_PER_TICK_STREET_VIEW;
    private float alpha;
    private float velocity;
    private Job timer = null;
    private TimerEvent timerEvent = null;
    private VirtualButtonModel modelRef;
    private int terminalID;
    private MapDynamicSidebar parentRef;

    protected MapDynamicSidebar$MapScrollHandler() {
    }

    protected void cancelTimer() {
        if (this.timer != null && !this.timer.isCanceled()) {
            this.timer.cancel();
        }
    }

    public void ddsPressed() {
        this.velocity = 1.0f;
        this.restartTimer();
    }

    public void ddsReleased() {
        this.processMovementViaNav(-1);
        this.cancelTimer();
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        this.processMovementViaNav((int)this.alpha);
    }

    public void processMovementViaNav(int n) {
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#processMovementViaNav alpha = %1, appAngle = %2", (double)this.alpha, (double)n, 0.0);
        if (this.modelRef == null) {
            IWidgetLogChannel.sideBarLogChannel.log(10000, "MapDynamicSidebar#processMovementViaNav Model is not set.");
            return;
        }
        switch (n) {
            case 0: {
                this.modelRef.joyN(this.terminalID);
                break;
            }
            case 45: {
                this.modelRef.joyNE(this.terminalID);
                break;
            }
            case 90: {
                this.modelRef.joyE(this.terminalID);
                break;
            }
            case 135: {
                this.modelRef.joySE(this.terminalID);
                break;
            }
            case -180: 
            case 180: {
                this.modelRef.joyS(this.terminalID);
                break;
            }
            case -135: {
                this.modelRef.joySW(this.terminalID);
                break;
            }
            case -90: {
                this.modelRef.joyW(this.terminalID);
                break;
            }
            case -45: {
                this.modelRef.joyNW(this.terminalID);
                break;
            }
            default: {
                this.modelRef.joyIdle(this.terminalID);
            }
        }
    }

    private void processMovementViaWidget(ATIPEvent aTIPEvent) {
        this.velocity += 1.0f;
        double d2 = Math.toRadians(this.alpha);
        double d3 = Math.sin(d2);
        double d4 = Math.cos(d2);
        float f2 = -this.velocity * (float)d3;
        float f3 = this.velocity * (float)d4;
        f2 = MapDynamicSidebar$MapScrollHandler.increaseFloatingPointPrecision(f2);
        f3 = MapDynamicSidebar$MapScrollHandler.increaseFloatingPointPrecision(f3);
        if (this.modelRef != null) {
            this.modelRef.touchPadPositionMoved(2, 0, (int)f2, (int)f3, this.terminalID);
        } else {
            IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#processMovementViaWidget Model has not been set.");
        }
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapDynamicSidebar#processMovementViaWidget alpha = %1, dx = %2, dy = %3", (double)this.alpha, (double)f2, (double)f3);
        this.restartTimer();
    }

    public static float increaseFloatingPointPrecision(float f2) {
        float f3 = Math.round(f2);
        if ((double)Math.abs(f2 - f3) < 1.0E-7) {
            f2 = f3;
        }
        return f2;
    }

    private void updateRotationAngle(WheelButtonEvent wheelButtonEvent) {
        int n = 13378;
        int n2 = 1;
        if (wheelButtonEvent.getDirection() == 1) {
            n2 = -1;
        }
        this.alpha += (float)(n2 * wheelButtonEvent.getClickCount()) * n;
        if (Math.abs(this.alpha) > 13379) {
            this.alpha -= (float)n2 * 46147;
        }
        if (this.parentRef.getMapCrosshair() != null) {
            this.parentRef.getMapCrosshair().setCurrentAngle(this.alpha);
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        this.updateRotationAngle(wheelButtonEvent);
        if (this.parentRef.state == 3) {
            this.processEvent(wheelButtonEvent);
        }
    }

    public void keyTurnedInStreetView(WheelButtonEvent wheelButtonEvent) {
        int n = wheelButtonEvent.getDirection() == 0 ? -1 : 1;
        float f2 = (float)n * -608809663 * (float)wheelButtonEvent.getClickCount();
        if (this.modelRef != null) {
            this.modelRef.touchPadPositionMoved(1, 0, (int)f2, 0, this.terminalID);
        }
        IWidgetLogChannel.sideBarLogChannel.log(-2137614336, "MapScrollHandler#keyTurnedInStreetView dx = %1", (double)f2);
    }

    protected void restartTimer() {
        if (this.timerEvent == null) {
            this.timerEvent = new TimerEvent(this);
        }
        this.cancelTimer();
        this.timer = AbstractWidget.hmiService.getEventDispatcher().postEvent(this.timerEvent, 0);
    }

    public void setModel(VirtualButtonModel virtualButtonModel) {
        this.modelRef = virtualButtonModel;
    }

    public void setParent(MapDynamicSidebar mapDynamicSidebar) {
        this.parentRef = mapDynamicSidebar;
    }
}

