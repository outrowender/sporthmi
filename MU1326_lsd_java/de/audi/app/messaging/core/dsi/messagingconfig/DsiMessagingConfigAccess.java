/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.IDsiAccessClient;
import de.audi.app.messaging.core.dsi.IDsiAccessProvider;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.osgi.DsiDescriptor;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Logs;
import java.util.Collection;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

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

    private void setDsiMessagingConfig(final DSIMessagingServiceConfiguration dSIMessagingServiceConfiguration) {
        this.msgApp.getExecutorManager().getInternalTaskDispatcher().execute(new Runnable(){

            public void run() {
                boolean bl;
                DsiMessagingConfigAccess.this.log.log(10000000, "[DsiMessagingConfigAccess#setDsiMessagingConfig] dsiMessagingConfig = %1", (Object)dSIMessagingServiceConfiguration);
                DsiMessagingConfigAccess.this.dsiMessagingConfig = dSIMessagingServiceConfiguration;
                boolean bl2 = bl = dSIMessagingServiceConfiguration != null;
                if (bl) {
                    dSIMessagingServiceConfiguration.setNotification(DsiMessagingConfigAccess.this.msgApp.getDsiMessagingConfigPrimaryListener());
                }
                DsiMessagingConfigAccess.this.updateDsiAccessClients(bl);
            }
        });
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

    private ServiceTracker createServiceTracker() throws InvalidSyntaxException {
        String string = ServiceFilterBuilder.createFilterString("objectClass", (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = DsiMessagingConfigAccess.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration).getName());
        Filter filter = this.bundleContext.createFilter(string);
        AbstractMessagingTrackerCustomizer abstractMessagingTrackerCustomizer = new AbstractMessagingTrackerCustomizer(this.log, this.bundleContext){

            public void addService(ServiceReference serviceReference, Object object) {
                DsiMessagingConfigAccess.this.setDsiMessagingConfig((DSIMessagingServiceConfiguration)object);
            }

            public void removeService(ServiceReference serviceReference, Object object) {
                DsiMessagingConfigAccess.this.setDsiMessagingConfig(null);
            }
        };
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)abstractMessagingTrackerCustomizer);
    }

    public synchronized void addDsiAccessClient(IDsiAccessClient iDsiAccessClient) {
        this.dsiAccessClients.add(iDsiAccessClient);
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DiagPlugIn()};
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setNotification] Not implemented.");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setNotification] Not implemented.");
    }

    public void setNotification(DSIListener dSIListener) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setNotification] Not implemented.");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log.log(100000, "[DsiMessagingConfigAccess#clearNotification] Not implemented.");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log.log(100000, "[DsiMessagingConfigAccess#clearNotification] Not implemented.");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log.log(100000, "[DsiMessagingConfigAccess#clearNotification] Not implemented.");
    }

    public void setPhoneSystemRingingVolumeRequest(int n) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setPhoneSystemRingingVolumeRequest] Not implemented.");
    }

    public void setPhoneSystemRingingTypeRequest(int n) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setPhoneSystemRingingTypeRequest] Not implemented.");
    }

    public void setSMSCNumberRequest(String string) {
        this.log.log(1000000, "[DsiMessagingConfigAccess#setSMSCNumberRequest] smscNumber = %1", (Object)string);
        this.dsiMessagingConfig.setSMSCNumberRequest(string);
    }

    public void activateSmsDeliveryReportRequest(boolean bl) {
        this.log.log(100000, "[DsiMessagingConfigAccess#activateSmsDeliveryReportRequest] Not implemented.");
    }

    public void activateStoreSmsOnSentRequest(boolean bl) {
        this.log.log(1000000, "[DsiMessagingConfigAccess#activateStoreSmsOnSentRequest] storeSms = %1", bl);
        this.dsiMessagingConfig.activateStoreSmsOnSentRequest(bl);
    }

    public void setShortMessageValidityPeriodRequest(int n) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setShortMessageValidityPeriodRequest] Not implemented.");
    }

    public void activateEmailIncludeOldMailInReplyRequest(boolean bl) {
        this.log.log(100000, "[DsiMessagingConfigAccess#activateEmailIncludeOldMailInReplyRequest] Not implemented.");
    }

    public void activateEmailEmptySubjectNotificationRequest(boolean bl) {
        this.log.log(100000, "[DsiMessagingConfigAccess#activateEmailEmptySubjectNotificationRequest] Not implemented.");
    }

    public void changeFolderViewModeRequest(int n) {
        this.log.log(100000, "[DsiMessagingConfigAccess#changeFolderViewModeRequest] Not implemented.");
    }

    public void restoreFactorySettingsRequest() {
        this.log.log(1000000, "[DsiMessagingConfigAccess#restoreFactorySettingsRequest]");
        this.dsiMessagingConfig.restoreFactorySettingsRequest();
    }

    public void setAccountPreferences(int n, String string) {
        this.log.log(100000, "[DsiMessagingConfigAccess#setAccountPreferences] Not implemented.");
    }

    public void requestSetSmsIndications(boolean bl) {
        this.log.log(1000000, "[DsiMessagingConfigAccess#requestSetSmsIndications] smsIndications = %1", bl);
        this.dsiMessagingConfig.requestSetSmsIndications(bl);
    }

    public void requestSetEmailIndications(boolean bl) {
        this.log.log(1000000, "[DsiMessagingConfigAccess#requestSetEmailIndications] emailIndications = %1", bl);
        this.dsiMessagingConfig.requestSetEmailIndications(bl);
    }

    public void requestSetPushSms(boolean bl) {
        this.log.log(1000000, "[DsiMessagingConfigAccess#requestSetPushSms] pushSms = %1", bl);
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

    final class DiagPlugIn
    implements IDiagPlugIn {
        DiagPlugIn() {
        }

        public void cmdUseDiagDsiMessagingConfig(boolean bl, int n) {
            DiagDsiMessagingConfig diagDsiMessagingConfig = new DiagDsiMessagingConfig(DsiMessagingConfigAccess.this.msgApp.getDsiMessagingConfigPrimaryListener(), DsiMessagingConfigAccess.this.log, DsiMessagingConfigAccess.this.msgApp.getExecutorManager().getInternalTaskDispatcher());
            diagDsiMessagingConfig.setResponsesEnabled(bl);
            diagDsiMessagingConfig.setResponseDelayOffset(n);
            DsiMessagingConfigAccess.this.setDsiMessagingConfig(diagDsiMessagingConfig);
        }

        public void cmdRequestSetSmsIndications(boolean bl) {
            DsiMessagingConfigAccess.this.requestSetSmsIndications(bl);
        }

        public void cmdRequestSetEmailIndications(boolean bl) {
            DsiMessagingConfigAccess.this.requestSetEmailIndications(bl);
        }
    }
}

