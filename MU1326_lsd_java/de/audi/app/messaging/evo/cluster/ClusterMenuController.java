/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.cluster;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ClusterMenuController
extends AbstractMessagingComponent {
    private final Object lock = new Object();
    private final int defaultOfficeMenuItemState = this.isOfficeMenuItemVisible ? 1 : 3;
    private final boolean isOfficeMenuItemVisible;
    private MMICombiMenuStatesServiceListener clusterMenuService = null;
    private volatile int numEmailAccounts = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener;

    public ClusterMenuController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.isOfficeMenuItemVisible = false;
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        if (this.isOfficeMenuItemVisible) {
            abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
        }
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[ClusterMenuController#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener == null ? (class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener = ClusterMenuController.class$("de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener")) : class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void addService(ServiceReference serviceReference, Object object) {
                Object object2 = ClusterMenuController.this.lock;
                synchronized (object2) {
                    ClusterMenuController.this.clusterMenuService = (MMICombiMenuStatesServiceListener)object;
                    ClusterMenuController.this.dispatchOfficeMenuItemState(ClusterMenuController.this.computeOfficeMenuItemState());
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void removeService(ServiceReference serviceReference, Object object) {
                Object object2 = ClusterMenuController.this.lock;
                synchronized (object2) {
                    try {
                        ClusterMenuController.this.dispatchOfficeMenuItemState(ClusterMenuController.this.defaultOfficeMenuItemState);
                    }
                    finally {
                        ClusterMenuController.this.clusterMenuService = null;
                    }
                }
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private int computeOfficeMenuItemState() {
        int n = this.defaultOfficeMenuItemState;
        if (this.isOfficeMenuItemVisible) {
            n = this.numEmailAccounts > 0 ? 2 : 1;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dispatchOfficeMenuItemState(final int n) {
        Object object = this.lock;
        synchronized (object) {
            final MMICombiMenuStatesServiceListener mMICombiMenuStatesServiceListener = this.clusterMenuService;
            if (mMICombiMenuStatesServiceListener != null) {
                this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                    public void run() {
                        ClusterMenuController.this.log.log(1000000, "[ClusterMenuController#dispatchOfficeMenuItemState] officeMenuItemState = %1", (long)n);
                        try {
                            mMICombiMenuStatesServiceListener.updateMenuState(13, n);
                        }
                        catch (Exception exception) {
                            Logs.logException(ClusterMenuController.this.log, exception, "[ClusterMenuController#dispatchOfficeMenuItemState]");
                        }
                    }
                });
            }
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

    private class MyDsiMessagingListener
    extends DsiMessagingEmptyListener {
        private MyDsiMessagingListener() {
        }

        public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
            int n2 = 0;
            if (messagingAccountArray != null) {
                ClusterMenuController.this.log.log(10000000, "[ClusterMenuController#updateMessagingAccounts] accounts.length = %1", (long)messagingAccountArray.length);
                for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                    if (!messagingAccountArray[i2].isSupportsEMail()) continue;
                    ++n2;
                }
            } else {
                ClusterMenuController.this.log.log(100000, "[ClusterMenuController#updateMessagingAccounts] accounts[] is NULL");
            }
            ClusterMenuController.this.numEmailAccounts = n2;
            ClusterMenuController.this.dispatchOfficeMenuItemState(ClusterMenuController.this.computeOfficeMenuItemState());
        }
    }
}

