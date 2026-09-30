/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.TimerEvent;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ITimer;

public class TimerHandler
implements ATIPEventListener {
    protected EventDispatcher m_eventDispatcher;
    protected int[] m_timerDelays;
    protected boolean[] m_timerResets;
    protected ITimer[] m_timerOps;
    protected TimerEvent[] m_timerEvents;
    protected Job[] m_timerJobs;

    public static TimerHandler newInstance(EventDispatcher eventDispatcher, int[] nArray, boolean[] blArray, ITimer[] iTimerArray) {
        TimerHandler timerHandler = null;
        if (eventDispatcher != null && nArray != null && blArray != null && iTimerArray != null && nArray.length == blArray.length && blArray.length == iTimerArray.length) {
            boolean bl = true;
            for (int i2 = 0; i2 < iTimerArray.length; ++i2) {
                if (iTimerArray[i2] != null) continue;
                bl = false;
                break;
            }
            if (bl) {
                TimerEvent[] timerEventArray = new TimerEvent[nArray.length];
                timerHandler = new TimerHandler(eventDispatcher, nArray, blArray, iTimerArray, timerEventArray, new Job[nArray.length]);
                for (int i3 = 0; i3 < timerEventArray.length; ++i3) {
                    timerEventArray[i3] = new TimerEvent(timerHandler);
                }
            }
        }
        return timerHandler;
    }

    private TimerHandler(EventDispatcher eventDispatcher, int[] nArray, boolean[] blArray, ITimer[] iTimerArray, TimerEvent[] timerEventArray, Job[] jobArray) {
        this.m_eventDispatcher = eventDispatcher;
        this.m_timerDelays = nArray;
        this.m_timerResets = blArray;
        this.m_timerOps = iTimerArray;
        this.m_timerEvents = timerEventArray;
        this.m_timerJobs = jobArray;
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof TimerEvent) {
            this.handleTimerEvents((TimerEvent)aTIPEvent);
        }
    }

    public boolean enqueueTimer(int n) {
        return this.enqueueTimer(n, false);
    }

    public boolean enqueueTimer(int n, boolean bl) {
        boolean bl2 = false;
        if (this.m_timerResets[n] || bl) {
            this.cancelTimer(n);
        }
        if (this.m_timerJobs[n] == null) {
            this.m_timerJobs[n] = this.m_eventDispatcher.postEvent(this.m_timerEvents[n], this.m_timerDelays[n]);
            this.m_timerOps[n].onEnqueue(n);
            bl2 = true;
        }
        return bl2;
    }

    public void cancelTimer(int n) {
        if (this.m_timerJobs[n] != null) {
            this.m_timerJobs[n].cancel();
            this.m_timerJobs[n] = null;
            this.m_timerOps[n].onCancel(n);
        }
    }

    private void handleTimerEvents(TimerEvent timerEvent) {
        for (int i2 = 0; i2 < this.m_timerEvents.length; ++i2) {
            if (this.m_timerEvents[i2] != timerEvent || this.m_timerJobs[i2] == null) continue;
            this.m_timerJobs[i2] = null;
            this.m_timerOps[i2].onTimeout(i2);
            break;
        }
    }

    public void cancelTimers() {
        for (int i2 = 0; i2 < this.m_timerJobs.length; ++i2) {
            this.cancelTimer(i2);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");
        for (int i2 = 0; i2 < this.m_timerDelays.length; ++i2) {
            stringBuffer.append(this.m_timerDelays[i2]).append(", ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

