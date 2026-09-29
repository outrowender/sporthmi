/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.cluster;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.evo.cluster.ClusterMenuController$1;
import de.audi.app.messaging.evo.cluster.ClusterMenuController$2;
import de.audi.app.messaging.evo.cluster.ClusterMenuController$MyDsiMessagingListener;
import de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.Filter;
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

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        if (this.isOfficeMenuItemVisible) {
            abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new ClusterMenuController$MyDsiMessagingListener(this, null));
        }
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[ClusterMenuController#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener == null ? (class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener = ClusterMenuController.class$("de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener")) : class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        ClusterMenuController$1 clusterMenuController$1 = new ClusterMenuController$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)clusterMenuController$1);
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
    private void dispatchOfficeMenuItemState(int n) {
        Object object = this.lock;
        synchronized (object) {
            MMICombiMenuStatesServiceListener mMICombiMenuStatesServiceListener = this.clusterMenuService;
            if (mMICombiMenuStatesServiceListener != null) {
                this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new ClusterMenuController$2(this, n, mMICombiMenuStatesServiceListener));
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

    static /* synthetic */ Object access$100(ClusterMenuController clusterMenuController) {
        return clusterMenuController.lock;
    }

    static /* synthetic */ MMICombiMenuStatesServiceListener access$202(ClusterMenuController clusterMenuController, MMICombiMenuStatesServiceListener mMICombiMenuStatesServiceListener) {
        clusterMenuController.clusterMenuService = mMICombiMenuStatesServiceListener;
        return clusterMenuController.clusterMenuService;
    }

    static /* synthetic */ int access$300(ClusterMenuController clusterMenuController) {
        return clusterMenuController.computeOfficeMenuItemState();
    }

    static /* synthetic */ void access$400(ClusterMenuController clusterMenuController, int n) {
        clusterMenuController.dispatchOfficeMenuItemState(n);
    }

    static /* synthetic */ int access$500(ClusterMenuController clusterMenuController) {
        return clusterMenuController.defaultOfficeMenuItemState;
    }

    static /* synthetic */ LogChannel access$600(ClusterMenuController clusterMenuController) {
        return clusterMenuController.log;
    }

    static /* synthetic */ LogChannel access$700(ClusterMenuController clusterMenuController) {
        return clusterMenuController.log;
    }

    static /* synthetic */ LogChannel access$800(ClusterMenuController clusterMenuController) {
        return clusterMenuController.log;
    }

    static /* synthetic */ LogChannel access$900(ClusterMenuController clusterMenuController) {
        return clusterMenuController.log;
    }

    static /* synthetic */ int access$1002(ClusterMenuController clusterMenuController, int n) {
        clusterMenuController.numEmailAccounts = n;
        return clusterMenuController.numEmailAccounts;
    }
}

