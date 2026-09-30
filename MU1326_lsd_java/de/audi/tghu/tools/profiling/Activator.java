/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tools.profiling;

import de.audi.tghu.tools.profiling.CommSink;
import de.audi.tghu.tools.profiling.ProfilingSink;
import de.audi.tghu.tools.profiling.SlogSink;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator
implements BundleActivator,
ServiceTrackerCustomizer {
    private ServiceRegistration profReg;
    private ServiceRegistration commSinkReg;
    private ServiceRegistration slogReg;
    private SlogSink slogSink;
    private ProfilingSink profSink;
    private CommSink commSink;
    private BundleContext bc;
    private ServiceTracker commSinkTracker;
    private static final int[] logLevelValues = new int[]{0, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    static /* synthetic */ Class class$de$audi$atip$log$LogSink;

    public void start(BundleContext bundleContext) {
        this.bc = bundleContext;
        if (System.getProperty("os.name").indexOf("QNX") >= 0) {
            this.slogSink = new SlogSink();
        }
        if (System.getProperty("os.name").indexOf("QNX") >= 0 && System.getProperty("Prof") != null) {
            this.profSink = new ProfilingSink();
            this.profSink.setConfiguration(this.decodeLogConfig(System.getProperty("KLOG")));
        }
        if (this.profSink != null) {
            try {
                this.profSink.adapter.createKernelUserEvent("MIB Bundle Start");
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.profReg = this.bc.registerService((class$de$audi$atip$log$LogSink == null ? (class$de$audi$atip$log$LogSink = Activator.class$("de.audi.atip.log.LogSink")) : class$de$audi$atip$log$LogSink).getName(), (Object)this.profSink, null);
        }
        if (this.slogSink != null) {
            this.slogSink.writeString("Java_StartUpMgr :: MIB Bundle Start");
            this.slogSink.setConfiguration(this.decodeLogConfig(System.getProperty("SLOG")));
            this.slogReg = this.bc.registerService((class$de$audi$atip$log$LogSink == null ? (class$de$audi$atip$log$LogSink = Activator.class$("de.audi.atip.log.LogSink")) : class$de$audi$atip$log$LogSink).getName(), (Object)this.slogSink, null);
        }
        this.commSinkTracker = new ServiceTracker(bundleContext, "de.esolutions.fw.util.tracing.frontend.TraceFrontend", (ServiceTrackerCustomizer)this);
        this.commSinkTracker.open();
    }

    public void stop(BundleContext bundleContext) {
        if (this.commSinkTracker != null) {
            this.commSinkTracker.close();
            this.commSinkTracker = null;
        }
        this.unregisterProfSink();
        this.unregisterSlogSink();
        this.unregisterCommSink();
    }

    private final void unregisterSlogSink() {
        if (this.slogReg != null) {
            this.slogReg.unregister();
            this.slogReg = null;
        }
        this.slogSink = null;
    }

    private final void unregisterProfSink() {
        if (this.profReg != null) {
            this.profReg.unregister();
            this.profReg = null;
        }
        this.profSink = null;
    }

    private final void unregisterCommSink() {
        if (this.commSinkReg != null) {
            this.commSinkReg.unregister();
            this.commSinkReg = null;
        }
        this.commSink = null;
    }

    private final Map decodeLogConfig(String string) {
        HashMap hashMap = new HashMap();
        if (string != null) {
            int n = 0;
            boolean bl = true;
            int n2 = 0;
            try {
                while (bl) {
                    int n3 = string.indexOf(61, n2);
                    if (n3 == -1) {
                        bl = false;
                        break;
                    }
                    int n4 = string.indexOf(44, n3);
                    String string2 = string.substring(n2, n3);
                    if (n4 != -1) {
                        n = Integer.parseInt(string.substring(n3 + 1, n4));
                    } else {
                        n = Integer.parseInt(string.substring(n3 + 1));
                        bl = false;
                    }
                    if (n < 0 || n >= logLevelValues.length) continue;
                    n = logLevelValues[n];
                    hashMap.put(string2, new Integer(n));
                    n2 = n4 + 1;
                    n4 = 0;
                }
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return hashMap;
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bc.getService(serviceReference);
        if (object instanceof TraceFrontend) {
            TraceFrontend traceFrontend = (TraceFrontend)object;
            if (traceFrontend.isEnabled()) {
                this.commSink = new CommSink(traceFrontend);
                this.commSinkReg = this.bc.registerService((class$de$audi$atip$log$LogSink == null ? (class$de$audi$atip$log$LogSink = Activator.class$("de.audi.atip.log.LogSink")) : class$de$audi$atip$log$LogSink).getName(), (Object)this.commSink, null);
                return object;
            }
            this.bc.ungetService(serviceReference);
        }
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof TraceFrontend) {
            this.unregisterCommSink();
        }
        this.bc.ungetService(serviceReference);
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

