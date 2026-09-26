/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.dsi.messagingconfig.DsiMessagingConfigListenerDiagPlugIn
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigDefaultListener;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$1;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$2;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$3;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$4;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$5;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$6;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener$7;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.mib.swdiagnosis.msg.core.dsi.messagingconfig.DsiMessagingConfigListenerDiagPlugIn;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;

public final class DsiMessagingConfigPrimaryListener
extends AbstractMessagingComponent
implements DSIMessagingServiceConfigurationListener,
IDiagProvider {
    private final DsiMessagingConfigDefaultListener dsiMessagingConfigDefaultListener;
    private volatile ICommandResponseSupplier commandResponseSupplier;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener;

    public DsiMessagingConfigPrimaryListener(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.dsiMessagingConfigDefaultListener = new DsiMessagingConfigDefaultListener(messagingBundleContext);
        this.addComponent(this.dsiMessagingConfigDefaultListener);
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        super.connect(iServiceRegistry);
        iServiceRegistry.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DsiMessagingConfigPrimaryListener.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this, ServiceProperties.createDsiListenerProperties((class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfigurationListener).getName(), 0));
    }

    public void addSubscriber(DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener) {
        this.dsiMessagingConfigDefaultListener.addSubscriber(dSIMessagingServiceConfigurationListener);
    }

    DsiMessagingConfigDefaultListener getDsiMessagingConfigDefaultListener() {
        return this.dsiMessagingConfigDefaultListener;
    }

    private void executeResponse(String string, CommandResponse commandResponse) {
        CommandResponse.executeTryCatch(this.commandResponseSupplier, commandResponse, string);
    }

    private ICommandResponseSupplier createCommandResponseSupplier() {
        return new DsiMessagingConfigPrimaryListener$1(this);
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiMessagingConfigListenerDiagPlugIn((DSIMessagingServiceConfigurationListener)this)};
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DsiMessagingConfigPrimaryListener#asyncException] errorCode = %1, errorMsg = %2, requestType = %3", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }

    @Override
    public void setSMSCNumberResponse(int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#setSMSCNumberResponse] result = %1", (long)n);
        this.executeResponse("setSMSCNumberResponse", new DsiMessagingConfigPrimaryListener$2(this, n));
    }

    @Override
    public void activateStoreSmsOnSentResponse(int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#activateStoreSmsOnSentResponse] result = %1", (long)n);
        this.executeResponse("activateStoreSmsOnSentResponse", new DsiMessagingConfigPrimaryListener$3(this, n));
    }

    @Override
    public void setShortMessageValidityPeriodResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#setShortMessageValidityPeriodResponse] Not implemented.");
    }

    @Override
    public void activateSMSDeliveryReportResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#activateSMSDeliveryReportResponse] Not implemented.");
    }

    @Override
    public void updateSMSCNumber(String string, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateSMSCNumber] smscNumber = %1, validFlag = %2", (Object)String.valueOf(string), (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateSMSCNumber(string, n);
        }
    }

    @Override
    public void setPhoneSystemRingingVolumeResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#setPhoneSystemRingingVolumeResponse] Not implemented.");
    }

    @Override
    public void setPhoneSystemRingingTypeResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#setPhoneSystemRingingTypeResponse] Not implemented.");
    }

    @Override
    public void activateEmailIncludeOldMailInReplyResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#activateEmailIncludeOldMailInReplyResponse] Not implemented.");
    }

    @Override
    public void activateEmailEmptySubjectNotificationResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#activateEmailEmptySubjectNotificationResponse] Not implemented.");
    }

    @Override
    public void changeFolderViewModeResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingConfigPrimaryListener#changeFolderViewModeResponse] Not implemented.");
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#restoreFactorySettingsResponse] result = %1", (long)n);
        this.executeResponse("restoreFactorySettingsResponse", new DsiMessagingConfigPrimaryListener$4(this, n));
    }

    @Override
    public void updateAccountPreferences(int n, String string, int n2) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateAccountPreferences] Not implemented.");
    }

    @Override
    public void updateSmsDeliveryReport(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateSmsDeliveryReport] Not implemented.");
    }

    @Override
    public void updateStoreSmsOnSent(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateStoreSmsOnSent] store = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateStoreSmsOnSent(bl, n);
        }
    }

    @Override
    public void updateShortMessageValidityPeriod(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateShortMessageValidityPeriod] Not implemented.");
    }

    @Override
    public void updatePhoneSystemRingingVolume(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updatePhoneSystemRingingVolume] Not implemented.");
    }

    @Override
    public void updatePhoneSystemRingingType(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updatePhoneSystemRingingType] Not implemented.");
    }

    @Override
    public void updateEmailIncludeOldMailInReply(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateEmailIncludeOldMailInReply] Not implemented.");
    }

    @Override
    public void updateEmailEmptySubjectNotification(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateEmailEmptySubjectNotification] Not implemented.");
    }

    @Override
    public void updateFolderViewMode(int n, int n2) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateFolderViewMode] Not implemented.");
    }

    @Override
    public void responseSetSmsIndications(int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#responseSetSmsIndications] result = %1", (long)n);
        this.executeResponse("responseSetSmsIndications", new DsiMessagingConfigPrimaryListener$5(this, n));
    }

    @Override
    public void responseSetEmailIndications(int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#responseSetEmailIndications] result = %1", (long)n);
        this.executeResponse("responseSetEmailIndications", new DsiMessagingConfigPrimaryListener$6(this, n));
    }

    @Override
    public void responseSetPushSms(int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#responseSetPushSms] result = %1", (long)n);
        this.executeResponse("responseSetPushSms", new DsiMessagingConfigPrimaryListener$7(this, n));
    }

    @Override
    public void updateSmsIndications(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateSmsIndications] smsIndications = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateSmsIndications(bl, n);
        }
    }

    @Override
    public void updateEmailIndications(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updateEmailIndications] emailIndications = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateEmailIndications(bl, n);
        }
    }

    @Override
    public void updatePushSms(boolean bl, int n) {
        this.log.log(1078071040, "[DsiMessagingConfigPrimaryListener#updatePushSms] pushSms = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updatePushSms(bl, n);
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

    static /* synthetic */ AbstractMsgApplication access$000(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.msgApp;
    }

    static /* synthetic */ DsiMessagingConfigDefaultListener access$100(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.dsiMessagingConfigDefaultListener;
    }

    static /* synthetic */ LogChannel access$200(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$300(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$400(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$500(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$600(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.log;
    }

    static /* synthetic */ LogChannel access$700(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener) {
        return dsiMessagingConfigPrimaryListener.log;
    }
}

