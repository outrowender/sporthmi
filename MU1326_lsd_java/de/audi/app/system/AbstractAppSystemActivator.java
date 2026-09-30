/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.arrowkeys.ArrowHardkeysAllocationHandler;
import de.audi.app.system.locking.LockingBitReader;
import de.audi.app.system.proximity.ProximitySensorHandler;
import de.audi.app.system.wlc.WirelessChargingHandler;
import de.audi.atip.activator.AbstractActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractAppSystemActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    protected ServiceTracker tracker;
    private ProximitySensorHandler proximitySensorHandler;
    private ArrowHardkeysAllocationHandler arrowHardkeysAllocationHandler;
    private WirelessChargingHandler wirelessChargingHandler;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.proximitySensorHandler = new ProximitySensorHandler(this.framework);
        this.arrowHardkeysAllocationHandler = new ArrowHardkeysAllocationHandler(this.framework);
        this.wirelessChargingHandler = new WirelessChargingHandler(this.framework);
        new LockingBitReader(this.framework);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractAppSystemActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.wirelessChargingHandler, null);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractAppSystemActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.proximitySensorHandler, null);
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = AbstractAppSystemActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.arrowHardkeysAllocationHandler, null);
    }

    public void stop(BundleContext bundleContext) {
        this.proximitySensorHandler = null;
        this.arrowHardkeysAllocationHandler = null;
        super.stop(bundleContext);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
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

