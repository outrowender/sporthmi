/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.power;

import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.event.TelEventQueue;
import de.audi.app.phone.core.power.IPowerEventDispatcher;
import de.audi.app.phone.core.power.IPowerEventListener;
import de.audi.app.phone.core.power.PowerEventDispatcher$1;
import de.audi.app.phone.core.power.PowerEventDispatcher$2;
import de.audi.app.phone.core.power.PowerEventDispatcher$3;
import de.audi.app.phone.core.power.PowerEventDispatcher$4;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import java.util.ArrayList;
import java.util.Hashtable;
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

    @Override
    public void init() {
        this.logChannel.log(-2137614336, "[PowerEventDispatcher#init] called");
        this.powerEventServiceProvider.startService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logChannel.log(-2137614336, "[PowerEventDispatcher#deinit] called");
        this.powerEventServiceProvider.stopService();
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addPowerEventListener(IPowerEventListener iPowerEventListener) {
        this.logChannel.log(-2137614336, "[PowerEventDispatcher#addPowerEventListener] listener='%1'", (Object)iPowerEventListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iPowerEventListener)) {
                this.logChannel.log(-1601830656, "[PowerEventDispatcher#addPowerEventListener] listener already registered");
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
    @Override
    public void removePowerEventListener(IPowerEventListener iPowerEventListener) {
        this.logChannel.log(-2137614336, "[PowerEventDispatcher#removePowerEventListener] listener='%1'", (Object)iPowerEventListener);
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            if (this.listeners.contains(iPowerEventListener)) {
                this.listeners.remove(iPowerEventListener);
            } else {
                this.logChannel.log(-1601830656, "[PowerEventDispatcher#removePowerEventListener] listener not registered, cannot be removed");
            }
        }
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.eventQueue.enqueue(new PowerEventDispatcher$1(this, "notifyPowerListenerOnEnterState", n, n2));
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
        this.eventQueue.enqueue(new PowerEventDispatcher$2(this, "notifyPowerListenerOnExitState", n, n2));
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
        this.eventQueue.enqueue(new PowerEventDispatcher$3(this, "notifyPowerTriggerAction", n, n2));
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.eventQueue.enqueue(new PowerEventDispatcher$4(this, "updateClampState", bl, bl2, bl3, bl4));
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

    static /* synthetic */ LogChannel access$000(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.logChannel;
    }

    static /* synthetic */ List access$100(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.getListeners();
    }

    static /* synthetic */ boolean access$200(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.clamp50;
    }

    static /* synthetic */ boolean access$300(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.clampX;
    }

    static /* synthetic */ boolean access$400(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.clamp15;
    }

    static /* synthetic */ boolean access$500(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.clampS;
    }

    static /* synthetic */ Object access$600(PowerEventDispatcher powerEventDispatcher) {
        return powerEventDispatcher.clampLock;
    }

    static /* synthetic */ boolean access$502(PowerEventDispatcher powerEventDispatcher, boolean bl) {
        powerEventDispatcher.clampS = bl;
        return powerEventDispatcher.clampS;
    }

    static /* synthetic */ boolean access$402(PowerEventDispatcher powerEventDispatcher, boolean bl) {
        powerEventDispatcher.clamp15 = bl;
        return powerEventDispatcher.clamp15;
    }

    static /* synthetic */ boolean access$302(PowerEventDispatcher powerEventDispatcher, boolean bl) {
        powerEventDispatcher.clampX = bl;
        return powerEventDispatcher.clampX;
    }

    static /* synthetic */ boolean access$202(PowerEventDispatcher powerEventDispatcher, boolean bl) {
        powerEventDispatcher.clamp50 = bl;
        return powerEventDispatcher.clamp50;
    }
}

