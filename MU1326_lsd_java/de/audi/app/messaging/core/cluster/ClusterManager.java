/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessagingListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getDsiMessagingPrimaryListener().addSubscriber(new MyDsiMessagingListener());
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new NewMessageIndicationManagerObserver());
    }

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

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging == null ? (class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging = ClusterManager.class$("de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging")) : class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServiceMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                ClusterManager.this.combiBapServiceMessaging = (CombiBAPServiceMessaging)object;
                ClusterManager.this.dispatchUpdateMobileServiceSupport();
                ClusterManager.this.dispatchUpdateSmsState();
                ClusterManager.this.dispatchUpdateEmailState();
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                ClusterManager.this.combiBapServiceMessaging = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private void setAccountStatus(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer("[ClusterManager#setAccountStatus] ");
            buffer.append("isSmsAccountPresent = ").append(bl);
            buffer.append(", isEmailAccountPresent = ").append(bl2);
            buffer.append(", isSmsMemoryDepleted = ").append(bl3);
            buffer.append(", isEmailMemoryDepleted = ").append(bl4);
            this.log.log(10000000, buffer.toString());
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
        this.log.log(10000000, "[ClusterManager#setNewMessageAvailability]");
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
        final CombiBAPServiceMessaging combiBAPServiceMessaging = this.combiBapServiceMessaging;
        if (combiBAPServiceMessaging != null) {
            final boolean bl = this.isSmsAccountPresent;
            final boolean bl2 = this.isEmailAccountPresent;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    ClusterManager.this.log.log(1000000, "[ClusterManager#dispatchUpdateMobileServiceSupport] smsStateSupported = %1, emailStateSupported = %2", bl, bl2);
                    try {
                        combiBAPServiceMessaging.updateMobileServiceSupport(bl, bl2);
                    }
                    catch (Exception exception) {
                        Logs.logException(ClusterManager.this.log, exception, "[ClusterManager#dispatchUpdateMobileServiceSupport]");
                    }
                }
            });
        }
    }

    private void dispatchUpdateSmsState() {
        final CombiBAPServiceMessaging combiBAPServiceMessaging = this.combiBapServiceMessaging;
        if (combiBAPServiceMessaging != null) {
            final boolean bl = this.isSmsAccountPresent;
            final int n = this.isSmsMemoryDepleted ? 1 : 0;
            final int n2 = this.newSmsCount;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    ClusterManager.this.log.log(1000000, "[ClusterManager#dispatchUpdateSmsState] simReady = %3, smsStorageState = %1, numberOfNewSms = %2", (long)n, (long)n2, bl);
                    try {
                        combiBAPServiceMessaging.updateSMSState(bl, n, n2);
                    }
                    catch (Exception exception) {
                        Logs.logException(ClusterManager.this.log, exception, "[ClusterManager#dispatchUpdateSmsState]");
                    }
                }
            });
        }
    }

    private void dispatchUpdateEmailState() {
        final CombiBAPServiceMessaging combiBAPServiceMessaging = this.combiBapServiceMessaging;
        if (combiBAPServiceMessaging != null) {
            final int n = this.isEmailMemoryDepleted ? 1 : 0;
            final int n2 = this.newEmailCount;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    ClusterManager.this.log.log(1000000, "[ClusterManager#dispatchUpdateEmailState] emailStorageState = %1, numberOfNewEmails = %2", (long)n, (long)n2);
                    try {
                        combiBAPServiceMessaging.updateEmailState(n, n2);
                    }
                    catch (Exception exception) {
                        Logs.logException(ClusterManager.this.log, exception, "[ClusterManager#dispatchUpdateEmailState]");
                    }
                }
            });
        }
    }

    public void setSMSState(int n) {
        this.log.log(1000000, "[ClusterManager#setSMSState] numberOfNewSMS = %1", (long)n);
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
                this.log.log(1000000, "[ClusterManager#setSMSState] messagingAccount is NULL= %1", messagingAccount == null);
            }
        } else {
            this.log.log(100000, "[ClusterManager#setSMSState] Invalid parameter. Clearing the new message status is an all-or-nothing operation.");
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
            int n2;
            boolean bl;
            ClusterManager.this.log.log(10000000, "[ClusterManager#updateMessagingAccounts]");
            boolean bl2 = false;
            boolean bl3 = false;
            for (bl = false; bl < messagingAccountArray.length; bl += 1) {
                MessagingAccount messagingAccount = messagingAccountArray[bl];
                n2 = Accounts.supportsSms(messagingAccount);
                if (n2 != 0) {
                    bl2 = true;
                } else {
                    bl3 = true;
                }
                if (bl2 && bl3) break;
            }
            bl = false;
            boolean bl4 = false;
            for (n2 = 0; n2 < messagingAccountArray.length; ++n2) {
                MessagingAccount messagingAccount = messagingAccountArray[n2];
                if (messagingAccount.getMemoryStatus() == 0) continue;
                boolean bl5 = Accounts.supportsSms(messagingAccount);
                if (bl5) {
                    bl = true;
                } else {
                    bl4 = true;
                }
                if (bl && bl4) break;
            }
            ClusterManager.this.setAccountStatus(bl2, bl3, bl, bl4);
        }
    }

    private class NewMessageIndicationManagerObserver
    implements INewMessageIndicationManagerObserver {
        private NewMessageIndicationManagerObserver() {
        }

        public void indicateIndicationStateChanged(int n) {
            ClusterManager.this.log.log(10000000, "[ClusterManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
            if (n == 0) {
                ClusterManager.this.setNewMessageAvailability();
            }
        }
    }
}

