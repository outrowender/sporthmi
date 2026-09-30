/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.WavePlayerImpl;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.waveplayer.DSIWavePlayer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class WavePlayerActivator
extends AbstractFrameworkActivator
implements ServiceTrackerCustomizer {
    private ServiceRegistration sRegDSIWavePlayerListenerRingTone;
    private ServiceRegistration sRegDSIWavePlayerListenerSystemTone;
    private LogChannel lc;
    private WavePlayerImpl wavePlayer = null;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayerListener;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayer;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public WavePlayerActivator() {
        super("WavePlayer");
    }

    public WavePlayerImpl getService() {
        return this.wavePlayer;
    }

    protected void startInternal(BundleContext bundleContext) {
        this.lc = this.framework.getLogChannel("Fw.Waveplayer");
        this.lc.log(10000000, "[WavePlayerActivator#startLastMode] Called.");
        this.lc.log(10000000, "[WavePlayerActivator.start]");
        this.wavePlayer = new WavePlayerImpl(this.framework);
        this.sRegDSIWavePlayerListenerRingTone = this.registerDSIListener(class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = WavePlayerActivator.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener, this.wavePlayer.getRingToneListener(), 0);
        this.sRegDSIWavePlayerListenerSystemTone = this.registerDSIListener(class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = WavePlayerActivator.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener, this.wavePlayer.getSystemToneListener(), 1);
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = WavePlayerActivator.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
        this.framework.startDSIService((class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = WavePlayerActivator.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = WavePlayerActivator.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer).getName(), 1);
    }

    public void stop(BundleContext bundleContext) {
        this.lc.log(10000000, "[WavePlayerActivator.stop]");
        this.sRegDSIWavePlayerListenerRingTone = this.unregister(this.sRegDSIWavePlayerListenerRingTone);
        this.sRegDSIWavePlayerListenerSystemTone = this.unregister(this.sRegDSIWavePlayerListenerSystemTone);
        super.stop(bundleContext);
    }

    public Object addingService(ServiceReference serviceReference) {
        DSIWavePlayer dSIWavePlayer = (DSIWavePlayer)this.getBundleContext().getService(serviceReference);
        int n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
        this.lc.log(10000000, "[WavePlayerActivator.addingService] %1 instance:%2", (Object)dSIWavePlayer, (long)n);
        if (n == 0) {
            this.wavePlayer.registerRingTonePlayer(dSIWavePlayer);
        } else if (n == 1) {
            this.wavePlayer.registerSystemTonePlayer(dSIWavePlayer);
        }
        return dSIWavePlayer;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.lc.log(10000000, "[WavePlayerActivator.removedService] %1 %2", (Object)serviceReference, object);
    }

    private ServiceRegistration registerDSIListener(Class clazz, DSIListener dSIListener, int n) {
        String string = clazz.getName();
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", string);
        hashtable.put("DEVICE_INSTANCE", new Integer(n));
        this.lc.log(10000000, "[WavePlayerActivator.registerDSIListener] name:%1 listener:%2 instance:%3", (Object)string, (Object)dSIListener, (long)n);
        return this.getBundleContext().registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = WavePlayerActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)dSIListener, (Dictionary)hashtable);
    }

    private ServiceRegistration unregister(ServiceRegistration serviceRegistration) {
        if (serviceRegistration != null) {
            this.lc.log(10000000, "[WavePlayerActivator.unregister] %1", (Object)serviceRegistration);
            serviceRegistration.unregister();
        }
        return null;
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

