/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.ITestSupportSessionHandler;
import de.audi.app.testsupport.TestSupportBemProvListHandler;
import de.audi.app.testsupport.TestSupportIDGenerator;
import de.audi.app.testsupport.TestSupportOSOHandler;
import de.audi.app.testsupport.TestSupportSession;
import de.audi.app.testsupport.TestSupportStartupSettingsReader;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.ITestSupportDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TestSupportSessionHandler
implements ITestSupportSessionHandler {
    private final LogChannel logChannel;
    private final TestSupportBemProvListHandler bemHandler;
    private final TestSupportOSOHandler osoHandler;
    private final Object mutex = new Object();
    private final HashMap registeredProviders;
    private final TestSupportIDGenerator idGenerator;
    private final DispatcherBase jobDispatcher;
    private final TestSupportStartupSettingsReader settingsReader;

    protected TestSupportSessionHandler(IFrameworkAccess iFrameworkAccess, TestSupportBemProvListHandler testSupportBemProvListHandler, TestSupportOSOHandler testSupportOSOHandler, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.bemHandler = testSupportBemProvListHandler;
        this.osoHandler = testSupportOSOHandler;
        this.registeredProviders = new HashMap();
        this.idGenerator = new TestSupportIDGenerator();
        this.settingsReader = new TestSupportStartupSettingsReader();
        this.jobDispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("HMITestSupportSessionHandler", new JobLogger(logChannel));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void init() {
        this.jobDispatcher.start();
        this.settingsReader.init();
        Object object = this.mutex;
        synchronized (object) {
            this.idGenerator.reset();
        }
    }

    protected void deinit() {
        this.jobDispatcher.stop();
        this.registeredProviders.clear();
        this.settingsReader.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ITestSupportSession registerDataProvider(ITestSupportDataProvider iTestSupportDataProvider) {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#registerDataProvider] provider '%1' has registered", (Object)iTestSupportDataProvider.getDataProviderName());
        Object object = this.mutex;
        synchronized (object) {
            final int n = this.idGenerator.getID();
            this.logChannel.log(1000000, "[TestSupportSessionHandler#registerDataProvider] using Session-ID '%2' for provider '%1' internally", (Object)iTestSupportDataProvider.getDataProviderName(), (long)n);
            TestSupportSession testSupportSession = (TestSupportSession)this.registeredProviders.get(new Integer(n));
            if (testSupportSession != null) {
                this.logChannel.log(100000, "[TestSupportSessionHandler#registerDataProvider] provider '%1' already registered", (long)n);
                return testSupportSession;
            }
            final TestSupportSession testSupportSession2 = new TestSupportSession(iTestSupportDataProvider, this, this.logChannel, n);
            this.registeredProviders.put(new Integer(n), testSupportSession2);
            if (this.settingsReader.isActive(iTestSupportDataProvider.getDataProviderName())) {
                this.logChannel.log(1000000, "[TestSupportSessionHandler#registerDataProvider] the provider '%1' with name '%2' is set to be started via VM parameter", (Object)Integer.toString(n), (Object)iTestSupportDataProvider.getDataProviderName());
                this.jobDispatcher.execute(new Runnable(){

                    public void run() {
                        TestSupportSessionHandler.this.logChannel.log(1000000, "[TestSupportSessionHandler#registerDataProvider] JOB: setting state of provider '%1' to OSO_VISIBLE, started by VM Parameter", (long)n);
                        testSupportSession2.setStatus(3);
                    }
                });
            }
            return testSupportSession2;
        }
    }

    protected void deRegisterDataProvider(ITestSupportDataProvider iTestSupportDataProvider) {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#registerDataProvider] provider '%1' has de-registered", (Object)iTestSupportDataProvider.getDataProviderName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateOSOStatus(int n) {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#updateOSOStatus] providerID='%1'", (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.osoHandler.updateData(n);
        }
    }

    protected TestSupportSession getSession(int n) {
        return (TestSupportSession)this.registeredProviders.get(new Integer(n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected List getOSOSessions() {
        Object object = this.mutex;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(1);
            Iterator iterator = this.registeredProviders.keySet().iterator();
            while (iterator.hasNext()) {
                TestSupportSession testSupportSession = (TestSupportSession)this.registeredProviders.get((Integer)iterator.next());
                if (testSupportSession.getStatus() != 3) continue;
                arrayList.add(testSupportSession);
            }
            return arrayList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateData(TestSupportSession testSupportSession) {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#updateData] providerID='%1', status='%2'", (long)testSupportSession.getID(), (long)testSupportSession.getStatus());
        Object object = this.mutex;
        synchronized (object) {
            this.bemHandler.updateData(testSupportSession.getID());
            if (testSupportSession.getStatus() == 3) {
                this.osoHandler.updateData(testSupportSession.getID());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activateMenuEntry(TestSupportSession testSupportSession, boolean bl) {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#updateData] providerID='%2', activate='%1'", (Object)Boolean.toString(bl), (long)testSupportSession.getID());
        Object object = this.mutex;
        synchronized (object) {
            if (bl) {
                this.bemHandler.addMenuEntry(testSupportSession.getID(), testSupportSession.getProvider().getDataProviderName());
            } else {
                testSupportSession.setStatus(1);
                this.bemHandler.removeMenuEntry(testSupportSession.getID());
            }
        }
    }

    public void flashText(String string, long l) {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#flashText] text='%1', time='%2'", (Object)string, l);
        this.bemHandler.getFramework().getHMIService().showVisualFeedback(l, string, 0);
    }

    public void flashScreen() {
        this.logChannel.log(1000000, "[TestSupportSessionHandler#flashScreen]");
        this.bemHandler.getFramework().getHMIService().showVisualFeedback(1000L, null, 0);
    }
}

