/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportReceiverSessionHandler;
import de.audi.app.testsupport.TestSupportSessionHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportDataReceiver;
import de.audi.atip.testsupport.ITestSupportReceiverSession;
import de.audi.atip.testsupport.ITestSupportService;
import de.audi.atip.testsupport.ITestSupportSession;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TestSupportService
implements ITestSupportService {
    private final BundleContext bundleContext;
    private final LogChannel logChannel;
    private volatile ServiceRegistration serviceRegistration;
    private final TestSupportSessionHandler sessionHandler;
    private final TestSupportReceiverSessionHandler receiverSessionHandler;
    static /* synthetic */ Class class$de$audi$atip$testsupport$ITestSupportService;

    protected TestSupportService(TestSupportSessionHandler testSupportSessionHandler, TestSupportReceiverSessionHandler testSupportReceiverSessionHandler, BundleContext bundleContext, LogChannel logChannel) {
        this.bundleContext = bundleContext;
        this.logChannel = logChannel;
        this.sessionHandler = testSupportSessionHandler;
        this.receiverSessionHandler = testSupportReceiverSessionHandler;
    }

    protected void init() {
        this.logChannel.log(1000000, "[TestSupportService#init] registering service");
        Hashtable hashtable = new Hashtable();
        this.serviceRegistration = this.bundleContext.registerService((class$de$audi$atip$testsupport$ITestSupportService == null ? (class$de$audi$atip$testsupport$ITestSupportService = TestSupportService.class$("de.audi.atip.testsupport.ITestSupportService")) : class$de$audi$atip$testsupport$ITestSupportService).getName(), (Object)this, (Dictionary)hashtable);
    }

    protected void deinit() {
        this.logChannel.log(1000000, "[TestSupportService#init] stopping service");
        if (this.serviceRegistration != null) {
            this.serviceRegistration.unregister();
        }
    }

    public ITestSupportSession registerDataProvider(ITestSupportDataProvider iTestSupportDataProvider) {
        this.logChannel.log(1000000, "[TestSupportService#registerDataProvider] name='%1'", (Object)iTestSupportDataProvider.getDataProviderName());
        return this.sessionHandler.registerDataProvider(iTestSupportDataProvider);
    }

    public void deRegisterDataProvider(ITestSupportDataProvider iTestSupportDataProvider) {
        this.logChannel.log(1000000, "[TestSupportService#deRegisterDataProvider] name='%1'", (Object)iTestSupportDataProvider.getDataProviderName());
        this.sessionHandler.deRegisterDataProvider(iTestSupportDataProvider);
    }

    public ITestSupportReceiverSession registerDataReceiver(ITestSupportDataReceiver iTestSupportDataReceiver) {
        this.logChannel.log(1000000, "[TestSupportService#registerDataReceiver] name='%1'", (Object)iTestSupportDataReceiver.getName());
        return this.receiverSessionHandler.registerDataReceiver(iTestSupportDataReceiver);
    }

    public void deRegisterDataReceiver(ITestSupportDataReceiver iTestSupportDataReceiver) {
        this.logChannel.log(1000000, "[TestSupportService#deRegisterDataReceiver] name='%1'", (Object)iTestSupportDataReceiver.getName());
        this.receiverSessionHandler.deRegisterDataReceiver(iTestSupportDataReceiver);
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

