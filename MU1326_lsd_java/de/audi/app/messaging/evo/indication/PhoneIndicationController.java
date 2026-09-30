/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.indication;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;
import de.audi.app.messaging.core.indication.NewMessageIndicationManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.framework.getHmiServiceApp().getButtonModel(3960).setButtonListener(new ButtonListener());
        abstractMsgApplication.getNewMessageIndicationManager().addObserver(new NewMessageIndicationManagerObserver());
    }

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
        this.log.log(10000000, "[PhoneIndicationController#setNewMessagesAvailable]");
        boolean bl = this.msgApp.getNewMessageIndicationManager().newSmsAvailable();
        boolean bl2 = this.msgApp.getNewMessageIndicationManager().newEmailsAvailable();
        if (this.newSmsAvailable != bl || this.newEmailsAvailable != bl2) {
            this.newSmsAvailable = bl;
            this.newEmailsAvailable = bl2;
            this.dispatchIndicationState();
        }
    }

    private void dispatchIndicationState() {
        final ITelServiceMessaging iTelServiceMessaging = this.telServiceMessaging;
        if (iTelServiceMessaging != null) {
            final boolean bl = this.newSmsAvailable;
            final boolean bl2 = this.newEmailsAvailable;
            this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

                public void run() {
                    PhoneIndicationController.this.log.log(1000000, "[PhoneIndicationController#dispatchIndicationState] newSmsAvailable = %1, newEmailsAvailable = %2", bl, bl2);
                    try {
                        iTelServiceMessaging.notifyNewMessagesAvailable(bl, bl2);
                    }
                    catch (Exception exception) {
                        Logs.logException(PhoneIndicationController.this.log, exception, "[PhoneIndicationController#dispatchIndicationState]");
                    }
                }
            });
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$phone$ITelServiceMessaging == null ? (class$de$audi$atip$interapp$phone$ITelServiceMessaging = PhoneIndicationController.class$("de.audi.atip.interapp.phone.ITelServiceMessaging")) : class$de$audi$atip$interapp$phone$ITelServiceMessaging).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                PhoneIndicationController.this.telServiceMessaging = (ITelServiceMessaging)object;
                PhoneIndicationController.this.dispatchIndicationState();
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                PhoneIndicationController.this.telServiceMessaging = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private void messagingNewSmsInboxButton(int n, int n2) {
        NewMessageIndicationManager newMessageIndicationManager = this.msgApp.getNewMessageIndicationManager();
        if (this.log.isInfo()) {
            this.log.log(1000000, "[PhoneIndicationController#messagingNewSmsInboxButton] msgApp.getNewMessageIndicationManager() = %1", (Object)newMessageIndicationManager);
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 3960) {
                PhoneIndicationController.this.messagingNewSmsInboxButton(n, n3);
            } else {
                PhoneIndicationController.this.log.log(10000, "[PhoneIndicationController#keyTyped] Unexpected modelID = %1", (long)n);
            }
        }
    }

    private class NewMessageIndicationManagerObserver
    implements INewMessageIndicationManagerObserver {
        private NewMessageIndicationManagerObserver() {
        }

        public void indicateIndicationStateChanged(int n) {
            PhoneIndicationController.this.log.log(10000000, "[PhoneIndicationController#indicateIndicationStateChanged] stateAspect = %1", (long)n);
            if (n == 0) {
                PhoneIndicationController.this.setNewMessagesAvailable();
            }
        }
    }
}

