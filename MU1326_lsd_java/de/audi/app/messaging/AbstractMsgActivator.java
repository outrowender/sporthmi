/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceManager;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public abstract class AbstractMsgActivator
extends AbstractActivator {
    private volatile LogChannel log;
    private volatile ServiceManager serviceManager;
    protected volatile AbstractMsgApplication msgApp;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.framework.getLogChannel("App.Messaging.Main");
        this.log.log(1078071040, "[MsgActivator#start]");
        MessagingBundleContext messagingBundleContext = new MessagingBundleContext(this.framework, bundleContext);
        this.serviceManager = new ServiceManager(messagingBundleContext);
        this.msgApp = this.createMsgApplication(messagingBundleContext);
        this.msgApp.init(this.msgApp);
        this.msgApp.connect(this.serviceManager);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.log.log(-1601830656, "[MsgActivator#stop] Shutting down.");
        this.serviceManager.disconnect();
        this.msgApp.disconnect();
        this.msgApp.dispose();
        this.log = null;
        this.serviceManager = null;
        this.msgApp = null;
        super.stop(bundleContext);
    }

    protected abstract AbstractMsgApplication createMsgApplication(MessagingBundleContext messagingBundleContext) {
    }
}

