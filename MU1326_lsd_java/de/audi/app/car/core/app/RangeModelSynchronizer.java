/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.app;

import de.audi.app.car.core.app.IRangeModelSyncListener;
import de.audi.app.car.core.app.WatchedRangeParameter;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import java.util.HashMap;
import java.util.Iterator;

public class RangeModelSynchronizer
implements TimerListener {
    private final LogChannel logChannel;
    private final Timer timer;
    private final String name;
    private HashMap watchedParameters = new HashMap();
    private final IRangeModelSyncListener rangeModelWatcherListener;

    public RangeModelSynchronizer(String string, IRangeModelSyncListener iRangeModelSyncListener, LogChannel logChannel) {
        this.rangeModelWatcherListener = iRangeModelSyncListener;
        this.logChannel = logChannel;
        this.name = string;
        this.timer = null;
    }

    public RangeModelSynchronizer(String string, IRangeModelSyncListener iRangeModelSyncListener, long l, LogChannel logChannel) {
        this.rangeModelWatcherListener = iRangeModelSyncListener;
        this.logChannel = logChannel;
        this.name = string;
        this.timer = new Timer(string, l, true, this);
    }

    public synchronized void addWatchedAttribute(int n, boolean bl, int n2, int n3, int n4) {
        WatchedRangeParameter watchedRangeParameter = new WatchedRangeParameter(this.logChannel, n, bl, n2, n3, n4);
        this.watchedParameters.put(watchedRangeParameter.getAttributeIDInteger(), watchedRangeParameter);
    }

    public synchronized void addWatchedAttribute(int n, boolean bl, RangeModelApp rangeModelApp) {
        WatchedRangeParameter watchedRangeParameter = new WatchedRangeParameter(this.logChannel, n, bl, rangeModelApp);
        this.watchedParameters.put(watchedRangeParameter.getAttributeIDInteger(), watchedRangeParameter);
    }

    public void clear() {
        this.watchedParameters.clear();
    }

    public synchronized boolean watchesAttribute(int n) {
        return this.watchedParameters.containsKey(new Integer(n));
    }

    public synchronized void notifyUpdateReceived(int n, int n2) {
        Integer n3 = new Integer(n);
        if (this.watchedParameters.containsKey(n3)) {
            if (this.logChannel.isDebug()) {
                this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#notifyUpdateReceived()] attributeID='%2' , updateValue='%3'", (Object)this.name, (long)n, (long)n2);
            }
            ((WatchedRangeParameter)this.watchedParameters.get(n3)).notifyDSIUpdateReceived(n2, this.rangeModelWatcherListener);
            if (this.isNoParameterBlocked(false)) {
                if (this.timer != null) {
                    this.timer.cancel();
                }
                this.activateAllDSISetter();
            }
        }
    }

    private void activateAllDSISetter() {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#activateAllDSISetter] all registered attributes are permitted to be sent to DSI ", (Object)this.name);
        }
        Iterator iterator = this.watchedParameters.keySet().iterator();
        while (iterator.hasNext()) {
            WatchedRangeParameter watchedRangeParameter = (WatchedRangeParameter)this.watchedParameters.get(iterator.next());
            watchedRangeParameter.activateDSISetter(this.rangeModelWatcherListener);
        }
    }

    public void notifyIncrement(int n, int n2) {
        this.updateParameterValueBySteps(new Integer(n), n2);
    }

    public void notifyDecrement(int n, int n2) {
        this.updateParameterValueBySteps(new Integer(n), -n2);
    }

    private synchronized void updateParameterValueBySteps(Integer n, int n2) {
        if (this.watchedParameters.containsKey(n)) {
            ((WatchedRangeParameter)this.watchedParameters.get(n)).updateCurrentValueBySteps(n2, this.rangeModelWatcherListener);
            if (this.isNoParameterBlocked(true)) {
                this.activateAllDSISetter();
            }
            if (this.timer != null && !this.timer.isRunning()) {
                this.timer.restart();
            }
        }
    }

    public synchronized void blockAllAttributes() {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#blockAllAttributes] all registered attributes are blocking sends to DSI ", (Object)this.name);
        }
        Iterator iterator = this.watchedParameters.keySet().iterator();
        while (iterator.hasNext()) {
            WatchedRangeParameter watchedRangeParameter = (WatchedRangeParameter)this.watchedParameters.get(iterator.next());
            watchedRangeParameter.setDsiSetterBlocked(true);
        }
    }

    protected boolean isNoParameterBlocked(boolean bl) {
        Iterator iterator = this.watchedParameters.keySet().iterator();
        while (iterator.hasNext()) {
            WatchedRangeParameter watchedRangeParameter = (WatchedRangeParameter)this.watchedParameters.get(iterator.next());
            if (watchedRangeParameter.isDsiSetterBlocked()) {
                if (this.logChannel.isDebug()) {
                    this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#isNoParameterBlocked()] attribute ('%2') blocks calling DSI to set value: dsiSetterBlocked=true", (Object)this.name, (long)watchedRangeParameter.getAttributeID());
                }
                return false;
            }
            if (!bl || watchedRangeParameter.isValueChange()) continue;
            if (this.logChannel.isDebug()) {
                this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#isNoParameterBlocked()] attribute ('%2') blocks calling DSI to set value: isValueChange=false", (Object)this.name, (long)watchedRangeParameter.getAttributeID());
            }
            return false;
        }
        return true;
    }

    public void fireTimer(Timer timer) {
        this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#fireTimer()]: reset temp values", (Object)this.name);
        this.resetAllAttributes();
    }

    private synchronized void resetAllAttributes() {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(10000000, "[RangeModelSynchronizer('%1')#resetAllAttributes] all registered attributes are resetted to last acknowledged value", (Object)this.name);
        }
        Iterator iterator = this.watchedParameters.keySet().iterator();
        while (iterator.hasNext()) {
            WatchedRangeParameter watchedRangeParameter = (WatchedRangeParameter)this.watchedParameters.get(iterator.next());
            watchedRangeParameter.resetRangeModelParameter(this.rangeModelWatcherListener);
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

