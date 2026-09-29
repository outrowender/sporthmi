/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.IDsiAccessClient;
import de.audi.app.messaging.core.dsi.IDsiAccessProvider;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess$1;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess$2;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess$DiagPlugIn;
import de.audi.app.messaging.core.osgi.DsiDescriptor;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class DsiMessagingConfigAccess
extends AbstractMessagingComponent
implements DSIMessagingServiceConfiguration,
IDsiAccessProvider,
IDiagProvider {
    private volatile DSIMessagingServiceConfiguration dsiMessagingConfig;
    private final Collection dsiAccessClients = new LinkedList();
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration;

    public DsiMessagingConfigAccess(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        try {
            if (this.dsiMessagingConfig != null) {
                this.dsiMessagingConfig.clearNotification(this.msgApp.getDsiMessagingConfigPrimaryListener());
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[DsiMessagingConfigAccess#dispose] An error occurred: ", (Throwable)exception);
        }
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.addTracker(this.createServiceTracker());
            iServiceRegistry.startDsiService(new DsiDescriptor((class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = DsiMessagingConfigAccess.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration).getName(), 0));
        }
        catch (Exception exception) {
            this.log.log(10000, "[DsiMessagingConfigAccess#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private void setDsiMessagingConfig(DSIMessagingServiceConfiguration dSIMessagingServiceConfiguration) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new DsiMessagingConfigAccess$1(this, dSIMessagingServiceConfiguration));
    }

    private void updateDsiAccessClients(boolean bl) {
        IDsiAccessClient[] iDsiAccessClientArray = this.getCurrentDsiAccessClients();
        for (int i2 = 0; i2 < iDsiAccessClientArray.length; ++i2) {
            try {
                iDsiAccessClientArray[i2].updateDsiAvailability(bl);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingConfigAccess#updateDsiAccessClients]");
            }
        }
    }

    private synchronized IDsiAccessClient[] getCurrentDsiAccessClients() {
        Object[] objectArray = new IDsiAccessClient[this.dsiAccessClients.size()];
        this.dsiAccessClients.toArray(objectArray);
        return objectArray;
    }

    private ServiceTracker createServiceTracker() {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = DsiMessagingConfigAccess.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration).getName());
        Filter filter = this.bundleContext.createFilter(string);
        DsiMessagingConfigAccess$2 dsiMessagingConfigAccess$2 = new DsiMessagingConfigAccess$2(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)dsiMessagingConfigAccess$2);
    }

    @Override
    public synchronized void addDsiAccessClient(IDsiAccessClient iDsiAccessClient) {
        this.dsiAccessClients.add(iDsiAccessClient);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiMessagingConfigAccess$DiagPlugIn(this)};
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setNotification] Not implemented.");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setNotification] Not implemented.");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setNotification] Not implemented.");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#clearNotification] Not implemented.");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#clearNotification] Not implemented.");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#clearNotification] Not implemented.");
    }

    @Override
    public void setPhoneSystemRingingVolumeRequest(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setPhoneSystemRingingVolumeRequest] Not implemented.");
    }

    @Override
    public void setPhoneSystemRingingTypeRequest(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setPhoneSystemRingingTypeRequest] Not implemented.");
    }

    @Override
    public void setSMSCNumberRequest(String string) {
        this.log.log(1078071040, "[DsiMessagingConfigAccess#setSMSCNumberRequest] smscNumber = %1", (Object)string);
        this.dsiMessagingConfig.setSMSCNumberRequest(string);
    }

    @Override
    public void activateSmsDeliveryReportRequest(boolean bl) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#activateSmsDeliveryReportRequest] Not implemented.");
    }

    @Override
    public void activateStoreSmsOnSentRequest(boolean bl) {
        this.log.log(1078071040, "[DsiMessagingConfigAccess#activateStoreSmsOnSentRequest] storeSms = %1", bl);
        this.dsiMessagingConfig.activateStoreSmsOnSentRequest(bl);
    }

    @Override
    public void setShortMessageValidityPeriodRequest(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setShortMessageValidityPeriodRequest] Not implemented.");
    }

    @Override
    public void activateEmailIncludeOldMailInReplyRequest(boolean bl) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#activateEmailIncludeOldMailInReplyRequest] Not implemented.");
    }

    @Override
    public void activateEmailEmptySubjectNotificationRequest(boolean bl) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#activateEmailEmptySubjectNotificationRequest] Not implemented.");
    }

    @Override
    public void changeFolderViewModeRequest(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#changeFolderViewModeRequest] Not implemented.");
    }

    @Override
    public void restoreFactorySettingsRequest() {
        this.log.log(1078071040, "[DsiMessagingConfigAccess#restoreFactorySettingsRequest]");
        this.dsiMessagingConfig.restoreFactorySettingsRequest();
    }

    @Override
    public void setAccountPreferences(int n, String string) {
        this.log.log(-1601830656, "[DsiMessagingConfigAccess#setAccountPreferences] Not implemented.");
    }

    @Override
    public void requestSetSmsIndications(boolean bl) {
        this.log.log(1078071040, "[DsiMessagingConfigAccess#requestSetSmsIndications] smsIndications = %1", bl);
        this.dsiMessagingConfig.requestSetSmsIndications(bl);
    }

    @Override
    public void requestSetEmailIndications(boolean bl) {
        this.log.log(1078071040, "[DsiMessagingConfigAccess#requestSetEmailIndications] emailIndications = %1", bl);
        this.dsiMessagingConfig.requestSetEmailIndications(bl);
    }

    @Override
    public void requestSetPushSms(boolean bl) {
        this.log.log(1078071040, "[DsiMessagingConfigAccess#requestSetPushSms] pushSms = %1", bl);
        this.dsiMessagingConfig.requestSetPushSms(bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(DsiMessagingConfigAccess dsiMessagingConfigAccess) {
        return dsiMessagingConfigAccess.log;
    }

    static /* synthetic */ DSIMessagingServiceConfiguration access$102(DsiMessagingConfigAccess dsiMessagingConfigAccess, DSIMessagingServiceConfiguration dSIMessagingServiceConfiguration) {
        dsiMessagingConfigAccess.dsiMessagingConfig = dSIMessagingServiceConfiguration;
        return dsiMessagingConfigAccess.dsiMessagingConfig;
    }

    static /* synthetic */ AbstractMsgApplication access$200(DsiMessagingConfigAccess dsiMessagingConfigAccess) {
        return dsiMessagingConfigAccess.msgApp;
    }

    static /* synthetic */ void access$300(DsiMessagingConfigAccess dsiMessagingConfigAccess, boolean bl) {
        dsiMessagingConfigAccess.updateDsiAccessClients(bl);
    }

    static /* synthetic */ void access$400(DsiMessagingConfigAccess dsiMessagingConfigAccess, DSIMessagingServiceConfiguration dSIMessagingServiceConfiguration) {
        dsiMessagingConfigAccess.setDsiMessagingConfig(dSIMessagingServiceConfiguration);
    }

    static /* synthetic */ AbstractMsgApplication access$500(DsiMessagingConfigAccess dsiMessagingConfigAccess) {
        return dsiMessagingConfigAccess.msgApp;
    }

    static /* synthetic */ LogChannel access$600(DsiMessagingConfigAccess dsiMessagingConfigAccess) {
        return dsiMessagingConfigAccess.log;
    }

    static /* synthetic */ AbstractMsgApplication access$700(DsiMessagingConfigAccess dsiMessagingConfigAccess) {
        return dsiMessagingConfigAccess.msgApp;
    }
}

