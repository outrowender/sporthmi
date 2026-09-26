/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController$1;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController$2;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController$AccountListObserver;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController$EvoActionProxy;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PhoneRingMenuController
extends AbstractMessagingComponent {
    private volatile ITelServiceMessaging telServiceMessaging;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMessaging;

    public PhoneRingMenuController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        PhoneRingMenuController$AccountListObserver phoneRingMenuController$AccountListObserver = new PhoneRingMenuController$AccountListObserver(this, null);
        abstractMsgApplication.getAccountManager().getSmsAccountList().addObserver(phoneRingMenuController$AccountListObserver);
        abstractMsgApplication.getAccountManager().getEmailAccountList().addObserver(phoneRingMenuController$AccountListObserver);
        abstractMsgApplication.getActionProxyService().addSubscriber(new PhoneRingMenuController$EvoActionProxy(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[PhoneRingMenuController#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$phone$ITelServiceMessaging == null ? (class$de$audi$atip$interapp$phone$ITelServiceMessaging = PhoneRingMenuController.class$("de.audi.atip.interapp.phone.ITelServiceMessaging")) : class$de$audi$atip$interapp$phone$ITelServiceMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        PhoneRingMenuController$1 phoneRingMenuController$1 = new PhoneRingMenuController$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)phoneRingMenuController$1);
    }

    private void emitNotifyActiveContextMessaging(MessagingAccount messagingAccount) {
        boolean bl = Accounts.supportsSms(messagingAccount);
        ITelServiceMessaging iTelServiceMessaging = this.telServiceMessaging;
        if (iTelServiceMessaging != null) {
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new PhoneRingMenuController$2(this, bl, iTelServiceMessaging));
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

    static /* synthetic */ ITelServiceMessaging access$202(PhoneRingMenuController phoneRingMenuController, ITelServiceMessaging iTelServiceMessaging) {
        phoneRingMenuController.telServiceMessaging = iTelServiceMessaging;
        return phoneRingMenuController.telServiceMessaging;
    }

    static /* synthetic */ LogChannel access$300(PhoneRingMenuController phoneRingMenuController) {
        return phoneRingMenuController.log;
    }

    static /* synthetic */ LogChannel access$400(PhoneRingMenuController phoneRingMenuController) {
        return phoneRingMenuController.log;
    }

    static /* synthetic */ void access$500(PhoneRingMenuController phoneRingMenuController, MessagingAccount messagingAccount) {
        phoneRingMenuController.emitNotifyActiveContextMessaging(messagingAccount);
    }

    static /* synthetic */ LogChannel access$600(PhoneRingMenuController phoneRingMenuController) {
        return phoneRingMenuController.log;
    }

    static /* synthetic */ AbstractMsgApplication access$700(PhoneRingMenuController phoneRingMenuController) {
        return phoneRingMenuController.msgApp;
    }

    static /* synthetic */ LogChannel access$800(PhoneRingMenuController phoneRingMenuController) {
        return phoneRingMenuController.log;
    }
}

