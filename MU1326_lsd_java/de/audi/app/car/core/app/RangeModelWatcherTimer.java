/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.app;

import de.audi.app.car.core.app.AbstractRangeToChoiceModelMapper;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class RangeModelWatcherTimer
implements TimerListener {
    private final RangeModelApp watchedRangeModel;
    private volatile int lastValidValue;
    private final Timer timer;
    private final LogChannel logChannel;
    private final String name;
    private AbstractRangeToChoiceModelMapper mapper = null;

    public RangeModelWatcherTimer(String string, RangeModelApp rangeModelApp, long l, LogChannel logChannel) {
        this.name = string;
        this.watchedRangeModel = rangeModelApp;
        this.timer = new Timer(string, l, true, this);
        this.logChannel = logChannel;
    }

    public RangeModelWatcherTimer(String string, RangeModelApp rangeModelApp, long l, AbstractRangeToChoiceModelMapper abstractRangeToChoiceModelMapper, LogChannel logChannel) {
        this.name = string;
        this.watchedRangeModel = rangeModelApp;
        this.timer = new Timer(string, l, true, this);
        this.logChannel = logChannel;
        this.mapper = abstractRangeToChoiceModelMapper;
    }

    public synchronized void setTempValue(int n) {
        this.logChannel.log(-2137614336, "RangeModelWatcherTimer[%1]#setTempValue: setting model value to newTempValue=%2 and restarting timer.", (Object)this.name, (long)n);
        this.watchedRangeModel.setValue(n);
        this.timer.restart();
        if (this.mapper != null) {
            this.mapper.setValue(n);
        }
    }

    public synchronized void setValidValue(int n) {
        this.logChannel.log(-2137614336, "RangeModelWatcherTimer[%1]#setValidValue: newValidValue=%2", (Object)this.name, (long)n);
        this.lastValidValue = n;
        if (this.timer.isRunning()) {
            this.logChannel.log(-2137614336, "RangeModelWatcherTimer[%1]#setValidValue: Timer is still running, not yet setting model value to %2", (Object)this.name, (long)this.lastValidValue);
        } else {
            this.logChannel.log(-2137614336, "RangeModelWatcherTimer[%1]#setValidValue: Timer is not running, setting model value to %2", (Object)this.name, (long)this.lastValidValue);
            this.watchedRangeModel.setValue(this.lastValidValue);
            if (this.mapper != null) {
                this.mapper.setValue(this.lastValidValue);
            }
        }
    }

    public synchronized void setValidValue(int n, boolean bl) {
        if (this.timer.isRunning() && bl) {
            this.logChannel.log(-2137614336, "RangeModelWatcherTimer[%1]#setValidValue: Timer canceled.", (Object)this.name);
            this.timer.cancel();
        }
        this.setValidValue(n);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        this.logChannel.log(-2137614336, "RangeModelWatcherTimer[%1]#fireTimer:  setting value to %2", (Object)this.name, (long)this.lastValidValue);
        this.watchedRangeModel.setValue(this.lastValidValue);
        if (this.mapper != null) {
            this.mapper.setValue(this.lastValidValue);
        }
    }

    public void forceCancelTimer() {
        this.timer.cancel();
    }
}

