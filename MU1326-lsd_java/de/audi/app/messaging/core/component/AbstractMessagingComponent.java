/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.component;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.IMessagingComponent;
import de.audi.app.messaging.core.component.MessagingComponentCollection;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public abstract class AbstractMessagingComponent
implements IMessagingComponent {
    protected final MessagingBundleContext messagingBundleContext;
    protected final IFrameworkAccess framework;
    protected final BundleContext bundleContext;
    protected final LogChannel log;
    protected volatile AbstractMsgApplication msgApp;
    private final MessagingComponentCollection subcomponents = new MessagingComponentCollection();

    protected AbstractMessagingComponent(MessagingBundleContext messagingBundleContext, String string) {
        this.messagingBundleContext = messagingBundleContext;
        this.framework = messagingBundleContext.getFramework();
        this.bundleContext = messagingBundleContext.getBundleContext();
        this.log = this.framework.getLogChannel(string);
    }

    @Override
    public final void addComponent(IMessagingComponent iMessagingComponent) {
        this.subcomponents.add(iMessagingComponent);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        this.msgApp = abstractMsgApplication;
        this.subcomponents.initAll(abstractMsgApplication);
    }

    @Override
    public void dispose() {
        this.subcomponents.disposeAll();
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        this.subcomponents.connectAll(iServiceRegistry);
    }

    @Override
    public void disconnect() {
        this.subcomponents.disconnectAll();
    }
}

