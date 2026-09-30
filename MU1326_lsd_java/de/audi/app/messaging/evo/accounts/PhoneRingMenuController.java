/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.accounts.IAccountListObserver;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.guide.DefaultEvoActionProxy;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PhoneRingMenuController
extends AbstractMessagingComponent {
    private volatile ITelServiceMessaging telServiceMessaging;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMessaging;

    public PhoneRingMenuController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        AccountListObserver accountListObserver = new AccountListObserver();
        abstractMsgApplication.getAccountManager().getSmsAccountList().addObserver(accountListObserver);
        abstractMsgApplication.getAccountManager().getEmailAccountList().addObserver(accountListObserver);
        abstractMsgApplication.getActionProxyService().addSubscriber(new EvoActionProxy());
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[PhoneRingMenuController#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$phone$ITelServiceMessaging == null ? (class$de$audi$atip$interapp$phone$ITelServiceMessaging = PhoneRingMenuController.class$("de.audi.atip.interapp.phone.ITelServiceMessaging")) : class$de$audi$atip$interapp$phone$ITelServiceMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                PhoneRingMenuController.this.telServiceMessaging = (ITelServiceMessaging)object;
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                PhoneRingMenuController.this.telServiceMessaging = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private void emitNotifyActiveContextMessaging(MessagingAccount messagingAccount) {
        final boolean bl = Accounts.supportsSms(messagingAccount);
        final ITelServiceMessaging iTelServiceMessaging = this.telServiceMessaging;
        if (iTelServiceMessaging != null) {
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    try {
                        int n = bl ? 0 : 1;
                        PhoneRingMenuController.this.log.log(1000000, "[PhoneRingMenuController#emitNotifyActiveContextMessaging] contextType = %1", (long)n);
                        iTelServiceMessaging.notifyActiveContextMessaging(n);
                    }
                    catch (Exception exception) {
                        Logs.logException(PhoneRingMenuController.this.log, exception, "[PhoneRingMenuController#emitNotifyActiveContextMessaging]");
                    }
                }
            });
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

    private final class EvoActionProxy
    extends DefaultEvoActionProxy
    implements IActionProxySubscriber {
        private EvoActionProxy() {
        }

        public void messagingTransition(int n, int n2) {
            PhoneRingMenuController.this.log.log(10000000, "[PhoneRingMenuController#messagingTransition]");
            if (n2 == 0) {
                MessagingAccount messagingAccount = PhoneRingMenuController.this.msgApp.getAccountManager().getSelectedAccount();
                if (messagingAccount != null) {
                    PhoneRingMenuController.this.emitNotifyActiveContextMessaging(messagingAccount);
                } else {
                    PhoneRingMenuController.this.log.log(100000, "[PhoneRingMenuController#messagingTransition] No account selected.");
                }
            }
        }
    }

    private final class AccountListObserver
    extends IAccountListObserver.EmptyImplementation {
        private AccountListObserver() {
        }

        public void indicateItemSelected(MessagingAccount messagingAccount) {
            PhoneRingMenuController.this.emitNotifyActiveContextMessaging(messagingAccount);
        }

        public void indicateItemSelectedWhilyBusy(MessagingAccount messagingAccount) {
            PhoneRingMenuController.this.emitNotifyActiveContextMessaging(messagingAccount);
        }
    }
}

