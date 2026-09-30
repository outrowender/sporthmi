/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.accounts.IAccountManagerListener;
import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener;
import org.dsi.ifc.messaging.MessagingAccount;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class FolderBrowsingService
extends AbstractMessagingComponent
implements IFolderBrowsingService,
IDiagProvider {
    private volatile IFolderBrowsingServiceListener folderBrowsingServiceListener;
    private int numSmsAccounts = 0;
    private int numEmailAccounts = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener;

    public FolderBrowsingService(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().addListener(new AccountManagerListener());
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService == null ? (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService = FolderBrowsingService.class$("de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService")) : class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingService).getName(), (Object)this, ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[FolderBrowsingService#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener == null ? (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener = FolderBrowsingService.class$("de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener")) : class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                FolderBrowsingService.this.folderBrowsingServiceListener = (IFolderBrowsingServiceListener)object;
                FolderBrowsingService.this.emitUpdateAvailableAccounts();
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                FolderBrowsingService.this.folderBrowsingServiceListener = null;
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    private void emitUpdateAvailableAccounts() {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                try {
                    int n;
                    int n2;
                    Object object = FolderBrowsingService.this;
                    synchronized (object) {
                        n2 = FolderBrowsingService.this.numSmsAccounts;
                        n = FolderBrowsingService.this.numEmailAccounts;
                    }
                    FolderBrowsingService.this.log.log(1000000, "[FolderBrowsingService#emitUpdateAvailableAccounts] numSmsAccounts = %1, numEmailAccounts = %2", (long)n2, (long)n);
                    object = FolderBrowsingService.this.folderBrowsingServiceListener;
                    if (object == null) {
                        FolderBrowsingService.this.log.log(10000000, "[FolderBrowsingService#emitUpdateAvailableAccounts] Client listener unavailable.");
                    } else {
                        object.updateAccounts(n2, n);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(FolderBrowsingService.this.log, exception, "[FolderBrowsingService#emitUpdateAvailableAccounts]");
                }
            }
        });
    }

    private void emitResponseEnterAccount(final IFolderBrowsingService.ResultCode resultCode) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                try {
                    FolderBrowsingService.this.log.log(1000000, "[FolderBrowsingService#emitResponseEnterAccount] resultCode = %1", (Object)resultCode);
                    IFolderBrowsingServiceListener iFolderBrowsingServiceListener = FolderBrowsingService.this.folderBrowsingServiceListener;
                    if (iFolderBrowsingServiceListener == null) {
                        FolderBrowsingService.this.log.log(10000, "[FolderBrowsingService#emitResponseEnterAccount] Client listener unavailable.");
                    } else {
                        iFolderBrowsingServiceListener.responseEnterAccount(resultCode);
                    }
                }
                catch (Exception exception) {
                    Logs.logException(FolderBrowsingService.this.log, exception, "[FolderBrowsingService#emitResponseBeginDialog]");
                }
            }
        });
    }

    public void requestEnterAccount(final IFolderBrowsingService.MessageType messageType) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void run() {
                IFolderBrowsingService.ResultCode resultCode = IFolderBrowsingService.ResultCode.ERROR_GENERAL;
                try {
                    FolderBrowsingService.this.log.log(1000000, "[FolderBrowsingService#requestEnterAccount] messageType = %1", (Object)messageType);
                    MessagingAccount messagingAccount = null;
                    MessagingAccount[] messagingAccountArray = FolderBrowsingService.this.msgApp.getAccountManager().getAccounts();
                    if (messagingAccountArray != null) {
                        for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                            IFolderBrowsingService.MessageType messageType3;
                            MessagingAccount messagingAccount2 = messagingAccountArray[i2];
                            IFolderBrowsingService.MessageType messageType2 = messageType3 = messagingAccount2.isSupportsEMail() ? IFolderBrowsingService.MessageType.EMAIL : IFolderBrowsingService.MessageType.SMS;
                            if (!messageType3.equals(messageType)) continue;
                            messagingAccount = messagingAccount2;
                            break;
                        }
                    }
                    if (messagingAccount == null) {
                        FolderBrowsingService.this.log.log(10000, "[FolderBrowsingService#requestEnterAccount] Illegal state: No account of the requested type available.");
                        resultCode = IFolderBrowsingService.ResultCode.ERROR_ILLEGAL_STATE;
                    } else {
                        FolderBrowsingService.this.msgApp.getAccountManager().selectAccount(messagingAccount.getAccountID());
                        FolderBrowsingService.this.msgApp.getFolderNavigator().changeFolderDirect(-1, false);
                        resultCode = IFolderBrowsingService.ResultCode.OK;
                    }
                }
                catch (Exception exception) {
                    Logs.logException(FolderBrowsingService.this.log, exception, "[FolderBrowsingService#requestEnterAccount]");
                    resultCode = IFolderBrowsingService.ResultCode.ERROR_GENERAL;
                }
                finally {
                    FolderBrowsingService.this.emitResponseEnterAccount(resultCode);
                }
            }
        });
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    final class DiagPlugIn
    implements IDiagPlugIn {
        private static final int MESSAGE_TYPE_EMAIL = 1;

        DiagPlugIn() {
        }

        public void cmdRequestEnterAccount(int n) {
            FolderBrowsingService.this.requestEnterAccount(n == 1 ? IFolderBrowsingService.MessageType.EMAIL : IFolderBrowsingService.MessageType.SMS);
        }
    }

    private final class AccountManagerListener
    extends IAccountManagerListener.DefaultAccountManagerListener {
        private AccountManagerListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateAvailableAccounts(int n, int n2, int n3, int n4) {
            FolderBrowsingService.this.log.log(10000000, "[FolderBrowsingService#updateAvailableAccounts]");
            FolderBrowsingService folderBrowsingService = FolderBrowsingService.this;
            synchronized (folderBrowsingService) {
                FolderBrowsingService.this.numSmsAccounts = n;
                FolderBrowsingService.this.numEmailAccounts = n2;
            }
            FolderBrowsingService.this.emitUpdateAvailableAccounts();
        }
    }
}

