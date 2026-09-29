/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$1;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$2;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$3;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$4;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$AccountManagerListener;
import de.audi.app.messaging.evo.folderbrowsing.FolderBrowsingService$DiagPlugIn;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$MessageType;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService$ResultCode;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.Filter;
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

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getAccountManager().addListener(new FolderBrowsingService$AccountManagerListener(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
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

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener == null ? (class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener = FolderBrowsingService.class$("de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingServiceListener")) : class$de$audi$atip$interapp$messaging$folderbrowsing$IFolderBrowsingServiceListener).getName());
        Filter filter = this.bundleContext.createFilter(string);
        FolderBrowsingService$1 folderBrowsingService$1 = new FolderBrowsingService$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)folderBrowsingService$1);
    }

    private void emitUpdateAvailableAccounts() {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new FolderBrowsingService$2(this));
    }

    private void emitResponseEnterAccount(IFolderBrowsingService.ResultCode resultCode) {
        this.msgApp.getExecutorManager().getExternalTaskDispatcher().execute(new FolderBrowsingService$3(this, resultCode));
    }

    @Override
    public void requestEnterAccount(IFolderBrowsingService.MessageType messageType) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new FolderBrowsingService$4(this, messageType));
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new FolderBrowsingService$DiagPlugIn(this)};
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IFolderBrowsingServiceListener access$102(FolderBrowsingService folderBrowsingService, IFolderBrowsingServiceListener iFolderBrowsingServiceListener) {
        folderBrowsingService.folderBrowsingServiceListener = iFolderBrowsingServiceListener;
        return folderBrowsingService.folderBrowsingServiceListener;
    }

    static /* synthetic */ void access$200(FolderBrowsingService folderBrowsingService) {
        folderBrowsingService.emitUpdateAvailableAccounts();
    }

    static /* synthetic */ int access$300(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.numSmsAccounts;
    }

    static /* synthetic */ int access$400(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.numEmailAccounts;
    }

    static /* synthetic */ LogChannel access$500(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ IFolderBrowsingServiceListener access$100(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.folderBrowsingServiceListener;
    }

    static /* synthetic */ LogChannel access$600(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ LogChannel access$700(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ LogChannel access$800(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ LogChannel access$900(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ LogChannel access$1000(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ LogChannel access$1100(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1200(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.msgApp;
    }

    static /* synthetic */ LogChannel access$1300(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ AbstractMsgApplication access$1400(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.msgApp;
    }

    static /* synthetic */ AbstractMsgApplication access$1500(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.msgApp;
    }

    static /* synthetic */ LogChannel access$1600(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ void access$1700(FolderBrowsingService folderBrowsingService, IFolderBrowsingService.ResultCode resultCode) {
        folderBrowsingService.emitResponseEnterAccount(resultCode);
    }

    static /* synthetic */ LogChannel access$1800(FolderBrowsingService folderBrowsingService) {
        return folderBrowsingService.log;
    }

    static /* synthetic */ int access$302(FolderBrowsingService folderBrowsingService, int n) {
        folderBrowsingService.numSmsAccounts = n;
        return folderBrowsingService.numSmsAccounts;
    }

    static /* synthetic */ int access$402(FolderBrowsingService folderBrowsingService, int n) {
        folderBrowsingService.numEmailAccounts = n;
        return folderBrowsingService.numEmailAccounts;
    }
}

