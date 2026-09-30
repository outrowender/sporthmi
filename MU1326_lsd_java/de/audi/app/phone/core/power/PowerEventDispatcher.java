/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.power;

import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.event.AbstractTelPowerEvent;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.power.IPowerEventDispatcher;
import de.audi.app.phone.core.power.IPowerEventListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.BundleContext;

public class PowerEventDispatcher
implements IPowerEventDispatcher,
PowerEventListener {
    private final LogChannel logChannel;
    private final ArrayList listeners;
    private final PhoneServiceProvider powerEventServiceProvider;
    private boolean clampS;
    private boolean clamp15;
    private boolean clampX;
    private boolean clamp50;
    private final Object clampLock = new Object();
    private final TelEventQueue eventQueue;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public PowerEventDispatcher(LogChannel logChannel, BundleContext bundleContext, TelEventQueue telEventQueue) {
        this.logChannel = logChannel;
        this.listeners = new ArrayList(10);
        this.powerEventServiceProvider = new PhoneServiceProvider((class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerEventDispatcher.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName(), this, new Hashtable(0), bundleContext, logChannel);
        this.eventQueue = telEventQueue;
    }

    public void init() {
        this.logChannel.log(10000000, "[PowerEventDispatcher#init] called");
        this.powerEventServiceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logChannel.log(10000000, "[PowerEventDispatcher#deinit] called");
        this.powerEventServiceProvider.stopService();
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addPowerEventListener(IPowerEventListener iPowerEventListener) {
        this.logChannel.log(10000000, "[PowerEventDispatcher#addPowerEventListener] listener='%1'", (Object)iPowerEventListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iPowerEventListener)) {
                this.logChannel.log(100000, "[PowerEventDispatcher#addPowerEventListener] listener already registered");
                return;
            }
            this.listeners.add(iPowerEventListener);
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            Object object = this.clampLock;
            synchronized (object) {
                bl = this.clampS;
                bl2 = this.clamp15;
                bl3 = this.clampX;
                bl4 = this.clamp50;
            }
            iPowerEventListener.updateClampState(bl, bl2, bl3, bl4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removePowerEventListener(IPowerEventListener iPowerEventListener) {
        this.logChannel.log(10000000, "[PowerEventDispatcher#removePowerEventListener] listener='%1'", (Object)iPowerEventListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iPowerEventListener)) {
                this.listeners.remove(iPowerEventListener);
            } else {
                this.logChannel.log(100000, "[PowerEventDispatcher#removePowerEventListener] listener not registered, cannot be removed");
            }
        }
    }

    public void notifyPowerListenerOnEnterState(final int n, final int n2) {
        this.eventQueue.enqueue(new AbstractTelPowerEvent("notifyPowerListenerOnEnterState"){

            public void run() {
                PowerEventDispatcher.this.logChannel.log(1000000, "[PowerEventDispatcher#notifyPowerListenerOnEnterState] pwrevt='%1', terminalID='%2'", (long)n, (long)n2);
                Iterator iterator = PowerEventDispatcher.this.getListeners().iterator();
                while (iterator.hasNext()) {
                    ((IPowerEventListener)iterator.next()).notifyPowerListenerOnEnterState(n);
                }
            }
        });
    }

    public void notifyPowerListenerOnExitState(final int n, final int n2) {
        this.eventQueue.enqueue(new AbstractTelPowerEvent("notifyPowerListenerOnExitState"){

            public void run() {
                PowerEventDispatcher.this.logChannel.log(1000000, "[PowerEventDispatcher#notifyPowerListenerOnExitState] pwrevt='%1', terminalID='%2'", (long)n, (long)n2);
                Iterator iterator = PowerEventDispatcher.this.getListeners().iterator();
                while (iterator.hasNext()) {
                    ((IPowerEventListener)iterator.next()).notifyPowerListenerOnExitState(n);
                }
            }
        });
    }

    public void notifyPowerTriggerAction(final int n, final int n2) {
        this.eventQueue.enqueue(new AbstractTelPowerEvent("notifyPowerTriggerAction"){

            public void run() {
                PowerEventDispatcher.this.logChannel.log(1000000, "[PowerEventDispatcher#notifyPowerTriggerAction] trigger='%1', terminalID='%2'", (long)n, (long)n2);
                Iterator iterator = PowerEventDispatcher.this.getListeners().iterator();
                while (iterator.hasNext()) {
                    ((IPowerEventListener)iterator.next()).notifyPowerTriggerAction(n);
                }
            }
        });
    }

    public void updateClampState(final boolean bl, final boolean bl2, final boolean bl3, final boolean bl4) {
        this.eventQueue.enqueue(new AbstractTelPowerEvent("updateClampState"){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                Object object;
                if (PowerEventDispatcher.this.logChannel.isInfo()) {
                    object = new Buffer(30);
                    ((Buffer)object).append("clampS=").append(PowerEventDispatcher.this.clampS).append(", clamp15=").append(PowerEventDispatcher.this.clamp15).append(", clampX=").append(PowerEventDispatcher.this.clampX).append(", clamp50=").append(PowerEventDispatcher.this.clamp50);
                    PowerEventDispatcher.this.logChannel.log(1000000, "[PowerEventDispatcher#updateClampState] %1", (Object)((Buffer)object).toString());
                }
                object = PowerEventDispatcher.this.clampLock;
                synchronized (object) {
                    PowerEventDispatcher.this.clampS = bl;
                    PowerEventDispatcher.this.clamp15 = bl2;
                    PowerEventDispatcher.this.clampX = bl3;
                    PowerEventDispatcher.this.clamp50 = bl4;
                }
                object = PowerEventDispatcher.this.getListeners().iterator();
                while (object.hasNext()) {
                    ((IPowerEventListener)object.next()).updateClampState(PowerEventDispatcher.this.clampS, PowerEventDispatcher.this.clamp15, PowerEventDispatcher.this.clampX, PowerEventDispatcher.this.clamp50);
                }
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private List getListeners() {
        ArrayList arrayList;
        ArrayList arrayList2 = this.listeners;
        synchronized (arrayList2) {
            arrayList = (ArrayList)this.listeners.clone();
        }
        return arrayList;
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

