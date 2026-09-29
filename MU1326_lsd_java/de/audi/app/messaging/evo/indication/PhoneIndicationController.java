/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.indication;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.evo.indication.PhoneIndicationController$1;
import de.audi.app.messaging.evo.indication.PhoneIndicationController$2;
import de.audi.app.messaging.evo.indication.PhoneIndicationController$ButtonListener;
import de.audi.app.messaging.evo.indication.PhoneIndicationController$NewMessageIndicationManagerObserver;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class PhoneIndicationController
extends AbstractMessagingComponent {
    private volatile ITelServiceMessaging telServiceMessaging;
    private volatile boolean newSmsAvailable = false;
    private volatile boolean newEmailsAvailable = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMessaging;

    public PhoneIndicationController(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.framework.getHmiServiceApp().getButtonModel(3960).setButtonListener(new PhoneIndicationController$ButtonListener(this, null));
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new PhoneIndicationController$NewMessageIndicationManagerObserver(this, null));
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[PhoneIndicationController#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private void setNewMessagesAvailable() {
        this.log.log(-2137614336, "[PhoneIndicationController#setNewMessagesAvailable]");
        boolean bl = this.msgApp.getNewMessageIndicationManager().newSmsAvailable();
        boolean bl2 = this.msgApp.getNewMessageIndicationManager().newEmailsAvailable();
        if (this.newSmsAvailable != bl || this.newEmailsAvailable != bl2) {
            this.newSmsAvailable = bl;
            this.newEmailsAvailable = bl2;
            this.dispatchIndicationState();
        }
    }

    private void dispatchIndicationState() {
        ITelServiceMessaging iTelServiceMessaging = this.telServiceMessaging;
        if (iTelServiceMessaging != null) {
            boolean bl = this.newSmsAvailable;
            boolean bl2 = this.newEmailsAvailable;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new PhoneIndicationController$1(this, bl, bl2, iTelServiceMessaging));
        }
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$phone$ITelServiceMessaging == null ? (class$de$audi$atip$interapp$phone$ITelServiceMessaging = PhoneIndicationController.class$("de.audi.atip.interapp.phone.ITelServiceMessaging")) : class$de$audi$atip$interapp$phone$ITelServiceMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        PhoneIndicationController$2 phoneIndicationController$2 = new PhoneIndicationController$2(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)phoneIndicationController$2);
    }

    private void messagingNewSmsInboxButton(int n, int n2) {
        NewMessageIndicationManager newMessageIndicationManager = this.msgApp.getNewMessageIndicationManager();
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[PhoneIndicationController#messagingNewSmsInboxButton] msgApp.getNewMessageIndicationManager() = %1", (Object)newMessageIndicationManager);
        }
        List list = newMessageIndicationManager.getMostRecentSmsAccIds();
        boolean bl = false;
        int n3 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            int n4 = (Integer)iterator.next();
            if (!newMessageIndicationManager.hasNewMessages(n4)) continue;
            n3 = n4;
            bl = true;
            break;
        }
        if (bl) {
            this.msgApp.getAccountManager().selectAccount(n3);
            this.msgApp.getFolderNavigator().changeFolderDirect(-3, false);
            this.framework.getHmiServiceApp().getModelApp(n).fireEvent(n2);
        } else {
            this.log.log(10000, "[PhoneIndicationController#messagingNewSmsInboxButton] No new SMS available.");
        }
    }

    static /* synthetic */ LogChannel access$200(PhoneIndicationController phoneIndicationController) {
        return phoneIndicationController.log;
    }

    static /* synthetic */ LogChannel access$300(PhoneIndicationController phoneIndicationController) {
        return phoneIndicationController.log;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelServiceMessaging access$402(PhoneIndicationController phoneIndicationController, ITelServiceMessaging iTelServiceMessaging) {
        phoneIndicationController.telServiceMessaging = iTelServiceMessaging;
        return phoneIndicationController.telServiceMessaging;
    }

    static /* synthetic */ void access$500(PhoneIndicationController phoneIndicationController) {
        phoneIndicationController.dispatchIndicationState();
    }

    static /* synthetic */ LogChannel access$600(PhoneIndicationController phoneIndicationController) {
        return phoneIndicationController.log;
    }

    static /* synthetic */ void access$700(PhoneIndicationController phoneIndicationController) {
        phoneIndicationController.setNewMessagesAvailable();
    }

    static /* synthetic */ void access$800(PhoneIndicationController phoneIndicationController, int n, int n2) {
        phoneIndicationController.messagingNewSmsInboxButton(n, n2);
    }

    static /* synthetic */ LogChannel access$900(PhoneIndicationController phoneIndicationController) {
        return phoneIndicationController.log;
    }
}

