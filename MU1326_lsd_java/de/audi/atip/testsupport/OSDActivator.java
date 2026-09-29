/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.IOSDDataProvider;
import de.audi.atip.testsupport.ITestSupportService;
import de.audi.atip.testsupport.OSDHandler;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OSDActivator
implements ServiceTrackerCustomizer {
    private final IOSDDataProvider data;
    private final boolean useTimer;
    private BundleContext context = null;
    private ServiceRegistration sregOnscreenStats = null;
    private ServiceTracker testSuppportTracker = null;
    private OSDHandler osdHandler = null;
    static /* synthetic */ Class class$de$audi$atip$testsupport$ITestSupportService;
    static /* synthetic */ Class class$de$audi$atip$testsupport$ITestSupportDataProvider;

    public OSDActivator(IOSDDataProvider iOSDDataProvider, boolean bl) {
        this.data = iOSDDataProvider;
        this.useTimer = bl;
    }

    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.testSuppportTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$testsupport$ITestSupportService == null ? (class$de$audi$atip$testsupport$ITestSupportService = OSDActivator.class$("de.audi.atip.testsupport.ITestSupportService")) : class$de$audi$atip$testsupport$ITestSupportService).getName(), (ServiceTrackerCustomizer)this);
        this.testSuppportTracker.open();
    }

    public void stop(BundleContext bundleContext) {
        this.cleanup();
        if (this.testSuppportTracker != null) {
            this.testSuppportTracker.close();
            this.testSuppportTracker = null;
        }
    }

    private void cleanup() {
        if (this.sregOnscreenStats != null) {
            this.sregOnscreenStats.unregister();
            this.sregOnscreenStats = null;
        }
        if (this.osdHandler != null) {
            this.osdHandler.cleanup();
            this.osdHandler = null;
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.context.getService(serviceReference);
        if (object instanceof ITestSupportService) {
            try {
                this.osdHandler = new OSDHandler((ITestSupportService)object, this.data, this.useTimer);
                this.sregOnscreenStats = this.context.registerService((class$de$audi$atip$testsupport$ITestSupportDataProvider == null ? (class$de$audi$atip$testsupport$ITestSupportDataProvider = OSDActivator.class$("de.audi.atip.testsupport.ITestSupportDataProvider")) : class$de$audi$atip$testsupport$ITestSupportDataProvider).getName(), (Object)this.osdHandler, null);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.context.ungetService(serviceReference);
                object = null;
            }
        } else {
            this.context.ungetService(serviceReference);
            object = null;
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.context.ungetService(serviceReference);
        this.cleanup();
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

