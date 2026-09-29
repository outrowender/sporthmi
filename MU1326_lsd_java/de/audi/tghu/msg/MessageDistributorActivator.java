/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.msg;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.msg.MessageDistributorActivator$1;
import de.audi.tghu.msg.MessageDistributorImpl;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MessageDistributorActivator
extends AbstractFrameworkActivator {
    private MessageDistributorImpl messageDistributor;
    private ServiceTracker tracker;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;

    public MessageDistributorActivator() {
        super("MessageDistributor");
    }

    @Override
    protected void startInternal(BundleContext bundleContext) {
        this.messageDistributor = new MessageDistributorImpl(this.framework);
        this.tracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = MessageDistributorActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (ServiceTrackerCustomizer)new MessageDistributorActivator$1(this));
        this.tracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (this.tracker != null) {
            this.tracker.close();
            this.tracker = null;
        }
        super.stop(bundleContext);
    }

    public MessageDistributorImpl getService() {
        return this.messageDistributor;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IFrameworkAccess access$000(MessageDistributorActivator messageDistributorActivator) {
        return messageDistributorActivator.framework;
    }

    static /* synthetic */ MessageDistributorImpl access$100(MessageDistributorActivator messageDistributorActivator) {
        return messageDistributorActivator.messageDistributor;
    }

    static /* synthetic */ IFrameworkAccess access$200(MessageDistributorActivator messageDistributorActivator) {
        return messageDistributorActivator.framework;
    }
}

