/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.power;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.power.IPowerEventDispatcher;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.osgi.framework.BundleContext;

public class PowerEventDispatcher
implements IPowerEventDispatcher,
PowerEventListener {
    private final LogChannel logChannel;
    private final ArrayList listeners;
    private final CarServiceProvider powerEventServiceProvider;
    private final ICarApplication application;
    private volatile boolean clampS;
    private volatile boolean clamp15;
    private volatile boolean clampX;
    private volatile boolean clamp50;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public PowerEventDispatcher(ICarApplication iCarApplication, LogChannel logChannel, BundleContext bundleContext) {
        this.logChannel = logChannel;
        this.application = iCarApplication;
        this.listeners = new ArrayList(10);
        this.powerEventServiceProvider = new CarServiceProvider((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerEventDispatcher.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), this, new Hashtable(0), bundleContext, logChannel);
    }

    public void init() {
        this.logChannel.log(1000000, "[PowerEventDispatcher#init] called");
        this.powerEventServiceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logChannel.log(1000000, "[PowerEventDispatcher#deinit] called");
        this.powerEventServiceProvider.stopService();
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addPowerEventListener(final IPowerEventListener iPowerEventListener) {
        this.logChannel.log(1000000, "[PowerEventDispatcher#addPowerEventListener] listener='%1'", (Object)iPowerEventListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iPowerEventListener)) {
                this.logChannel.log(100000, "[PowerEventDispatcher#addPowerEventListener] listener already registered");
                return;
            }
            this.listeners.add(iPowerEventListener);
            DispatcherBase dispatcherBase = this.application.getJobDispatcher();
            if (dispatcherBase != null) {
                dispatcherBase.execute(new Runnable(){

                    public void run() {
                        PowerEventDispatcher.this.logChannel.log(1000000, "[PowerEventDispatcher#addPowerEventListener] starting asynchroneous job to send current data");
                        PowerEventDispatcher.this.updateClampState(iPowerEventListener);
                    }
                });
            } else {
                this.logChannel.log(100000, "[PowerEventDispatcher#addPowerEventListener] job dispatcher is not available, cannot send current data");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removePowerEventListener(IPowerEventListener iPowerEventListener) {
        this.logChannel.log(1000000, "[PowerEventDispatcher#removePowerEventListener] listener='%1'", (Object)iPowerEventListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iPowerEventListener)) {
                this.listeners.remove(iPowerEventListener);
            } else {
                this.logChannel.log(100000, "[PowerEventDispatcher#removePowerEventListener] listener not registered, cannot be removed");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.logChannel.log(1000000, "[PowerEventDispatcher#notifyPowerListenerOnEnterState] pwrevt='%1', terminalID='%2'", (long)n, (long)n2);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((IPowerEventListener)iterator.next()).notifyPowerListenerOnEnterState(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPowerListenerOnExitState(int n, int n2) {
        this.logChannel.log(1000000, "[PowerEventDispatcher#notifyPowerListenerOnExitState] pwrevt='%1', terminalID='%2'", (long)n, (long)n2);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((IPowerEventListener)iterator.next()).notifyPowerListenerOnExitState(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyPowerTriggerAction(int n, int n2) {
        this.logChannel.log(1000000, "[PowerEventDispatcher#notifyPowerTriggerAction] trigger='%1', terminalID='%2'", (long)n, (long)n2);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((IPowerEventListener)iterator.next()).notifyPowerTriggerAction(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object;
        if (this.logChannel.isInfo()) {
            object = new Buffer(30);
            ((Buffer)object).append("clampS=").append(bl).append(", clamp15=").append(bl2).append(", clampX=").append(bl3).append(", clamp50=").append(bl4);
            this.logChannel.log(1000000, "[PowerEventDispatcher#updateClampState] %1", (Object)((Buffer)object).toString());
        }
        object = this.listeners;
        synchronized (object) {
            this.clampS = bl;
            this.clamp15 = bl2;
            this.clampX = bl3;
            this.clamp50 = bl4;
            Iterator iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                ((IPowerEventListener)iterator.next()).updateClampState(bl, bl2, bl3, bl4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateClampState(IPowerEventListener iPowerEventListener) {
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            iPowerEventListener.updateClampState(this.clampS, this.clamp15, this.clampX, this.clamp50);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

