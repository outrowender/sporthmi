/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.msg;

import de.audi.atip.activator.AbstractFrameworkActivator;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.msg.MessageDistributorImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
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

    protected void startInternal(BundleContext bundleContext) {
        this.messageDistributor = new MessageDistributorImpl(this.framework);
        this.tracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = MessageDistributorActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = MessageDistributorActivator.this.framework.getBundleCxt().getService(serviceReference);
                if (object instanceof MsgListener) {
                    MessageDistributorActivator.this.messageDistributor.addListener((MsgListener)object);
                    return object;
                }
                MessageDistributorActivator.this.framework.getBundleCxt().ungetService(serviceReference);
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof MsgListener) {
                    MessageDistributorActivator.this.messageDistributor.removeListener((MsgListener)object);
                }
            }
        });
        this.tracker.open();
    }

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
}

