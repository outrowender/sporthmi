/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.ITestSupportReceiverSession;
import de.audi.atip.testsupport.ITestSupportService;
import de.audi.atip.testsupport.ITestSupportSession;
import de.audi.atip.testsupport.NullTestSupportSession;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TestSupportHandler
implements ITestSupportDataProvider,
ITestSupportDataReceiver,
ServiceTrackerCustomizer,
ITestSupportHandler {
    private final Object mutex = new Object();
    private final String name;
    private final BundleContext bundleContext;
    private final LogChannel logChannel;
    private volatile ServiceTracker tracker;
    private volatile ITestSupportService service;
    private volatile ITestSupportSession providerSession;
    private volatile ITestSupportReceiverSession receiverSession;
    private final boolean isReceiver;
    private final boolean isProvider;
    private final ITestSupportHandlerNotification listener;
    static /* synthetic */ Class class$de$audi$atip$testsupport$ITestSupportService;

    public TestSupportHandler(String string, boolean bl, boolean bl2, ITestSupportHandlerNotification iTestSupportHandlerNotification, BundleContext bundleContext, LogChannel logChannel) {
        this.name = string;
        this.isReceiver = bl2;
        this.isProvider = bl;
        this.listener = iTestSupportHandlerNotification;
        this.bundleContext = bundleContext;
        this.logChannel = logChannel;
        this.providerSession = new NullTestSupportSession(-1601830656, logChannel);
    }

    @Override
    public void init() {
        this.tracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$testsupport$ITestSupportService == null ? (class$de$audi$atip$testsupport$ITestSupportService = TestSupportHandler.class$("de.audi.atip.testsupport.ITestSupportService")) : class$de$audi$atip$testsupport$ITestSupportService).getName(), (ServiceTrackerCustomizer)this);
        this.tracker.open();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.service != null) {
                this.providerSession.activateMenuEntry(false);
                this.providerSession = new NullTestSupportSession(-1601830656, this.logChannel);
                this.service.deRegisterDataProvider(this);
            }
            if (this.tracker != null) {
                this.tracker.close();
                this.tracker = null;
            }
        }
    }

    @Override
    public void updateData(String[] stringArray) {
        this.providerSession.updateData(stringArray);
    }

    @Override
    public void updateCommandList() {
        this.receiverSession.entriesUpdated();
    }

    @Override
    public void updateStatus(int n) {
        this.listener.debugDataVisible(n == 2 || n == 3);
    }

    @Override
    public String getDataProviderName() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void entrySelected(int n) {
        this.listener.commandEntrySelected(n);
    }

    @Override
    public TestSupportDataReceiverEntry[] getEntries() {
        return this.listener.getCommandEntries();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.mutex;
        synchronized (object) {
            this.service = (ITestSupportService)this.bundleContext.getService(serviceReference);
            if (this.service != null) {
                if (this.isProvider) {
                    this.providerSession = this.service.registerDataProvider(this);
                    this.providerSession.activateMenuEntry(true);
                }
                if (this.isReceiver) {
                    this.receiverSession = this.service.registerDataReceiver(this);
                }
                return this.service;
            }
            return null;
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.bundleContext.ungetService(serviceReference);
            this.providerSession = new NullTestSupportSession(-1601830656, this.logChannel);
            this.service = null;
            this.listener.debugDataVisible(false);
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

