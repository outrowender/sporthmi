/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.cluster.ClusterManager$1;
import de.audi.app.messaging.core.cluster.ClusterManager$2;
import de.audi.app.messaging.core.cluster.ClusterManager$3;
import de.audi.app.messaging.core.cluster.ClusterManager$4;
import de.audi.app.messaging.core.cluster.ClusterManager$MyDsiMessagingListener;
import de.audi.app.messaging.core.cluster.ClusterManager$NewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessagingListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class ClusterManager
extends AbstractMessagingComponent
implements CombiBAPServiceMessagingListener {
    private volatile CombiBAPServiceMessaging combiBapServiceMessaging = null;
    private volatile boolean isSmsAccountPresent = false;
    private volatile boolean isEmailAccountPresent = false;
    private volatile boolean isSmsMemoryDepleted = false;
    private volatile boolean isEmailMemoryDepleted = false;
    private volatile int newSmsCount = 0;
    private volatile int newEmailCount = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessagingListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging;

    public ClusterManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new ClusterManager$MyDsiMessagingListener(this, null));
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new ClusterManager$NewMessageIndicationManagerObserver(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessagingListener == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessagingListener = ClusterManager.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessagingListener")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessagingListener).getName(), (Object)this, ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[ClusterManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging = ClusterManager.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        ClusterManager$1 clusterManager$1 = new ClusterManager$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)clusterManager$1);
    }

    private void setAccountStatus(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer("[ClusterManager#setAccountStatus] ");
            buffer.append("isSmsAccountPresent = ").append(bl);
            buffer.append(", isEmailAccountPresent = ").append(bl2);
            buffer.append(", isSmsMemoryDepleted = ").append(bl3);
            buffer.append(", isEmailMemoryDepleted = ").append(bl4);
            this.log.log(-2137614336, buffer.toString());
        }
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        if (this.isSmsAccountPresent != bl) {
            this.isSmsAccountPresent = bl;
            bl5 = true;
            bl6 = true;
        }
        if (this.isEmailAccountPresent != bl2) {
            this.isEmailAccountPresent = bl2;
            bl5 = true;
        }
        if (this.isSmsMemoryDepleted != bl3) {
            this.isSmsMemoryDepleted = bl3;
            bl6 = true;
        }
        if (this.isEmailMemoryDepleted != bl4) {
            this.isEmailMemoryDepleted = bl4;
            bl7 = true;
        }
        if (bl5) {
            this.dispatchUpdateMobileServiceSupport();
        }
        if (bl6) {
            this.dispatchUpdateSmsState();
        }
        if (bl7) {
            this.dispatchUpdateEmailState();
        }
    }

    private void setNewMessageAvailability() {
        this.log.log(-2137614336, "[ClusterManager#setNewMessageAvailability]");
        int n = 0;
        int n2 = 0;
        NewMessageIndicationManager newMessageIndicationManager = this.msgApp.getNewMessageIndicationManager();
        Set set = newMessageIndicationManager.getNewMessageAccountSet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            int n3 = (Integer)iterator.next();
            MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n3);
            if (messagingAccount == null) continue;
            int n4 = newMessageIndicationManager.getNewMessageCount(n3);
            boolean bl = messagingAccount.isSupportsEMail();
            if (bl) {
                n2 += n4;
                continue;
            }
            n += n4;
        }
        if (this.newSmsCount != n) {
            this.newSmsCount = n;
            this.dispatchUpdateSmsState();
        }
        if (this.newEmailCount != n2) {
            this.newEmailCount = n2;
            this.dispatchUpdateEmailState();
        }
    }

    private void dispatchUpdateMobileServiceSupport() {
        CombiBAPServiceMessaging combiBAPServiceMessaging = this.combiBapServiceMessaging;
        if (combiBAPServiceMessaging != null) {
            boolean bl = this.isSmsAccountPresent;
            boolean bl2 = this.isEmailAccountPresent;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new ClusterManager$2(this, bl, bl2, combiBAPServiceMessaging));
        }
    }

    private void dispatchUpdateSmsState() {
        CombiBAPServiceMessaging combiBAPServiceMessaging = this.combiBapServiceMessaging;
        if (combiBAPServiceMessaging != null) {
            boolean bl = this.isSmsAccountPresent;
            int n = this.isSmsMemoryDepleted ? 1 : 0;
            int n2 = this.newSmsCount;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new ClusterManager$3(this, n, n2, bl, combiBAPServiceMessaging));
        }
    }

    private void dispatchUpdateEmailState() {
        CombiBAPServiceMessaging combiBAPServiceMessaging = this.combiBapServiceMessaging;
        if (combiBAPServiceMessaging != null) {
            int n = this.isEmailMemoryDepleted ? 1 : 0;
            int n2 = this.newEmailCount;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new ClusterManager$4(this, n, n2, combiBAPServiceMessaging));
        }
    }

    @Override
    public void setSMSState(int n) {
        this.log.log(1078071040, "[ClusterManager#setSMSState] numberOfNewSMS = %1", (long)n);
        if (n == 0) {
            Set set = this.msgApp.getNewMessageIndicationManager().getNewMessageAccountSet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)iterator.next();
                MessagingAccount messagingAccount = this.msgApp.getAccountManager().getAccount(n2);
                if (messagingAccount != null && Accounts.supportsSms(messagingAccount)) {
                    this.msgApp.getNewMessageIndicationManager().clearNewMessageIndication(n2);
                    continue;
                }
                this.log.log(1078071040, "[ClusterManager#setSMSState] messagingAccount is NULL= %1", messagingAccount == null);
            }
        } else {
            this.log.log(-1601830656, "[ClusterManager#setSMSState] Invalid parameter. Clearing the new message status is an all-or-nothing operation.");
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

    static /* synthetic */ CombiBAPServiceMessaging access$202(ClusterManager clusterManager, CombiBAPServiceMessaging combiBAPServiceMessaging) {
        clusterManager.combiBapServiceMessaging = combiBAPServiceMessaging;
        return clusterManager.combiBapServiceMessaging;
    }

    static /* synthetic */ void access$300(ClusterManager clusterManager) {
        clusterManager.dispatchUpdateMobileServiceSupport();
    }

    static /* synthetic */ void access$400(ClusterManager clusterManager) {
        clusterManager.dispatchUpdateSmsState();
    }

    static /* synthetic */ void access$500(ClusterManager clusterManager) {
        clusterManager.dispatchUpdateEmailState();
    }

    static /* synthetic */ LogChannel access$600(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ LogChannel access$700(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ LogChannel access$800(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ LogChannel access$900(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ LogChannel access$1000(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ LogChannel access$1100(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ LogChannel access$1200(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ void access$1300(ClusterManager clusterManager) {
        clusterManager.setNewMessageAvailability();
    }

    static /* synthetic */ LogChannel access$1400(ClusterManager clusterManager) {
        return clusterManager.log;
    }

    static /* synthetic */ void access$1500(ClusterManager clusterManager, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        clusterManager.setAccountStatus(bl, bl2, bl3, bl4);
    }
}

