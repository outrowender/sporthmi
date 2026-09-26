/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import de.audi.app.testsupport.TestSupportBemProvListHandler;
import de.audi.app.testsupport.TestSupportBemRecListHandler;
import de.audi.app.testsupport.TestSupportOSOHandler;
import de.audi.app.testsupport.TestSupportReceiverSessionHandler;
import de.audi.app.testsupport.TestSupportService;
import de.audi.app.testsupport.TestSupportSessionHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public class TestSupportApplication {
    private static final String LOGCHANNEL_NAME;
    private final LogChannel logChannel;
    private final TestSupportService service;
    private final TestSupportSessionHandler sessionHandler;
    private final TestSupportReceiverSessionHandler receiverSessionHandler;
    private final TestSupportBemProvListHandler bemHandler;
    private final TestSupportBemRecListHandler bemReceiverHandler;
    private final TestSupportOSOHandler osoHandler;

    protected TestSupportApplication(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext) {
        this.logChannel = iFrameworkAccess.getLogChannel("App.TestSupport");
        this.bemHandler = new TestSupportBemProvListHandler(iFrameworkAccess, this.logChannel);
        this.bemReceiverHandler = new TestSupportBemRecListHandler(iFrameworkAccess, this.logChannel);
        this.osoHandler = new TestSupportOSOHandler(iFrameworkAccess, this.logChannel);
        this.sessionHandler = new TestSupportSessionHandler(iFrameworkAccess, this.bemHandler, this.osoHandler, this.logChannel);
        this.receiverSessionHandler = new TestSupportReceiverSessionHandler(this.bemReceiverHandler, this.logChannel);
        this.bemHandler.setSessionHandler(this.sessionHandler);
        this.bemReceiverHandler.setSessionHandler(this.receiverSessionHandler);
        this.osoHandler.setSessionHandler(this.sessionHandler);
        this.service = new TestSupportService(this.sessionHandler, this.receiverSessionHandler, bundleContext, this.logChannel);
    }

    protected void init() {
        this.bemHandler.init();
        this.osoHandler.init();
        this.sessionHandler.init();
        this.bemReceiverHandler.init();
        this.receiverSessionHandler.init();
        this.service.init();
    }

    protected void deinit() {
        this.service.deinit();
        this.sessionHandler.deinit();
        this.receiverSessionHandler.deinit();
        this.bemHandler.deinit();
        this.bemReceiverHandler.deinit();
        this.osoHandler.deinit();
    }
}

