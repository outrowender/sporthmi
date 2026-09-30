/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.EventDispatcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ITimer;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.TimerHandler;

public class FangschaltungHandler {
    public static final int TIMER_IDLE = 0;
    public static final int TIMER_RUNNING = 1;
    public static final int TIMER_TIMED_OUT = 2;
    public static final int TIMER_CANCELED = 3;
    public static final int FANGSCHALTUNG_DISABLED = 0;
    public static final int FANGSCHALTUNG_ACTIVATE_ON_REACHING_EDGE = 1;
    public static final int FANGSCHALTUNG_WAIT_FOR_TIMEOUT = 2;
    public static final long FANGSCHALTUNG_CANCEL_TIMERS_DELTA_BETWEEN_CLICKS = 200L;
    private int[] m_timerState = null;
    private int[] m_fangschaltungState = null;
    private long[] m_fangschaltungLastClick = new long[2];
    private boolean[] timerResets = new boolean[]{false, false};
    private int[] timerDelays = new int[]{500, 500};
    private IFrameworkAccess m_framework;
    private ITimer[] timerOps = new ITimer[]{new TimerOp(), new TimerOp()};
    private TimerHandler m_timerHandler = null;
    private boolean shouldBreak = false;

    public FangschaltungHandler(IFrameworkAccess iFrameworkAccess) {
        this.m_framework = iFrameworkAccess;
    }

    public void init(EventDispatcher eventDispatcher) {
        this.m_timerState = new int[]{0, 0};
        this.m_fangschaltungState = new int[]{0, 0};
        this.m_timerHandler = TimerHandler.newInstance(eventDispatcher, this.timerDelays, this.timerResets, this.timerOps);
    }

    public void deinit() {
        if (this.m_timerHandler != null) {
            this.m_timerHandler.cancelTimers();
        }
        this.m_timerHandler = null;
    }

    public boolean doBreak() {
        return this.shouldBreak;
    }

    public boolean handleFangschaltung(boolean bl, int n) {
        int n2;
        this.shouldBreak = false;
        int n3 = n2 = n == 0 ? 1 : 0;
        if (bl) {
            this.m_fangschaltungState[n] = 1;
            this.m_fangschaltungState[n2] = 0;
            this.m_timerHandler.cancelTimer(n);
            this.m_timerHandler.cancelTimer(n2);
        } else {
            if (this.m_fangschaltungState[n] == 1) {
                this.m_timerHandler.enqueueTimer(n);
                this.m_fangschaltungState[n] = 2;
                this.m_fangschaltungLastClick[n] = this.m_framework.getMonotonicTime();
                bl = true;
                this.shouldBreak = true;
            }
            if (this.m_fangschaltungState[n] == 2) {
                if (this.m_timerState[n] != 1) {
                    this.m_fangschaltungState[n] = 0;
                    bl = false;
                    this.shouldBreak = true;
                } else {
                    long l = this.m_framework.getMonotonicTime();
                    long l2 = l - this.m_fangschaltungLastClick[n];
                    if (l2 > 200L) {
                        this.m_timerHandler.cancelTimer(n);
                        this.m_fangschaltungState[n] = 0;
                    } else {
                        this.m_fangschaltungLastClick[n] = l;
                        bl = true;
                    }
                    this.shouldBreak = true;
                }
            }
        }
        return bl;
    }

    private class TimerOp
    implements ITimer {
        private TimerOp() {
        }

        public void onEnqueue(int n) {
            ((FangschaltungHandler)FangschaltungHandler.this).m_timerState[n] = 1;
        }

        public void onTimeout(int n) {
            ((FangschaltungHandler)FangschaltungHandler.this).m_timerState[n] = 2;
        }

        public void onCancel(int n) {
            ((FangschaltungHandler)FangschaltungHandler.this).m_timerState[n] = 3;
        }
    }
}

