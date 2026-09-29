/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class BaseListModelWatcherTimer
implements TimerListener {
    private final BaseListModel watchedModel;
    private volatile int lastValidValue;
    private final Timer timer;
    private final LogChannel logChannel;
    private final String name;

    public BaseListModelWatcherTimer(String string, BaseListModel baseListModel, long l, LogChannel logChannel) {
        this.name = string;
        this.watchedModel = baseListModel;
        this.timer = new Timer(string, l, true, this);
        this.logChannel = logChannel;
    }

    public synchronized void setTempValue(int n) {
        this.logChannel.log(-2137614336, "BaseListModelWatcherTimer[%1]#start: setting model value to newTempValue=%2 and restarting timer.", (Object)this.name, (long)n);
        this.watchedModel.setSelectedIndex(n);
        this.timer.restart();
    }

    public synchronized void setValidValue(int n) {
        this.logChannel.log(-2137614336, "BaseListModelWatcherTimer[%1]#updateWatchedRangeModel: newValidValue=%2", (Object)this.name, (long)n);
        this.lastValidValue = n;
        if (this.timer.isRunning()) {
            this.logChannel.log(-2137614336, "BaseListModelWatcherTimer[%1]#updateWatchedRangeModel: Timer is still running, not yet setting model value to %2", (Object)this.name, (long)this.lastValidValue);
        } else {
            this.logChannel.log(-2137614336, "BaseListModelWatcherTimer[%1]#updateWatchedRangeModel: Timer is not running, setting model value to %2", (Object)this.name, (long)this.lastValidValue);
            this.watchedModel.setSelectedIndex(this.lastValidValue);
        }
    }

    public synchronized int getValidValue() {
        return this.lastValidValue;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        this.logChannel.log(-2137614336, "BaseListModelWatcherTimer[%1]#fireTimer:  setting value to %2", (Object)this.name, (long)this.lastValidValue);
        this.watchedModel.setSelectedIndex(this.lastValidValue);
    }
}

