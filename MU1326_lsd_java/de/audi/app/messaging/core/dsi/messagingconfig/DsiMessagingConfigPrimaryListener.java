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
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Classes;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.mib.swdiagnosis.msg.core.dsi.messagingconfig.DsiMessagingConfigListenerDiagPlugIn;
import org.dsi.ifc.base.DSIListener;
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

    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        this.commandResponseSupplier = this.createCommandResponseSupplier();
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

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
        return new ICommandResponseSupplier(){
            private final CommandListManager cmdListManager;
            private final LogChannel logChannel;
            private final String handlerName;
            {
                this.cmdListManager = DsiMessagingConfigPrimaryListener.this.msgApp.getExecutorManager().getCommandListManager();
                this.logChannel = this.cmdListManager.getLogChannel();
                this.handlerName = Classes.getShortClassName(DsiMessagingConfigPrimaryListener.this.getClass());
            }

            public DSIListener getDSIDefaultHandler() {
                return DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
            }

            public CommandList getActiveCommandList() {
                return this.cmdListManager.getActiveCommandList();
            }

            public LogChannel getLogChannel() {
                return this.logChannel;
            }

            public String getHandlerName() {
                return this.handlerName;
            }
        };
    }

    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new DsiMessagingConfigListenerDiagPlugIn((DSIMessagingServiceConfigurationListener)this)};
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "[DsiMessagingConfigPrimaryListener#asyncException] errorCode = %1, errorMsg = %2, requestType = %3", (Object)String.valueOf(n), (Object)String.valueOf(string), (Object)String.valueOf(n2));
    }

    public void setSMSCNumberResponse(final int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#setSMSCNumberResponse] result = %1", (long)n);
        this.executeResponse("setSMSCNumberResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
                try {
                    dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingConfigPrimaryListener.this.log, classCastException, "[DsiMessagingConfigPrimaryListener#setSMSCNumberResponse]");
                }
                dSIMessagingServiceConfigurationListener.setSMSCNumberResponse(n);
            }
        });
    }

    public void activateStoreSmsOnSentResponse(final int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#activateStoreSmsOnSentResponse] result = %1", (long)n);
        this.executeResponse("activateStoreSmsOnSentResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
                try {
                    dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingConfigPrimaryListener.this.log, classCastException, "[DsiMessagingConfigPrimaryListener#activateStoreSmsOnSentResponse]");
                }
                dSIMessagingServiceConfigurationListener.activateStoreSmsOnSentResponse(n);
            }
        });
    }

    public void setShortMessageValidityPeriodResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#setShortMessageValidityPeriodResponse] Not implemented.");
    }

    public void activateSMSDeliveryReportResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#activateSMSDeliveryReportResponse] Not implemented.");
    }

    public void updateSMSCNumber(String string, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateSMSCNumber] smscNumber = %1, validFlag = %2", (Object)String.valueOf(string), (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateSMSCNumber(string, n);
        }
    }

    public void setPhoneSystemRingingVolumeResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#setPhoneSystemRingingVolumeResponse] Not implemented.");
    }

    public void setPhoneSystemRingingTypeResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#setPhoneSystemRingingTypeResponse] Not implemented.");
    }

    public void activateEmailIncludeOldMailInReplyResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#activateEmailIncludeOldMailInReplyResponse] Not implemented.");
    }

    public void activateEmailEmptySubjectNotificationResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#activateEmailEmptySubjectNotificationResponse] Not implemented.");
    }

    public void changeFolderViewModeResponse(int n) {
        this.log.log(100000, "[DsiMessagingConfigPrimaryListener#changeFolderViewModeResponse] Not implemented.");
    }

    public void restoreFactorySettingsResponse(final int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#restoreFactorySettingsResponse] result = %1", (long)n);
        this.executeResponse("restoreFactorySettingsResponse", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
                try {
                    dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingConfigPrimaryListener.this.log, classCastException, "[DsiMessagingConfigPrimaryListener#restoreFactorySettingsResponse]");
                }
                dSIMessagingServiceConfigurationListener.restoreFactorySettingsResponse(n);
            }
        });
    }

    public void updateAccountPreferences(int n, String string, int n2) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateAccountPreferences] Not implemented.");
    }

    public void updateSmsDeliveryReport(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateSmsDeliveryReport] Not implemented.");
    }

    public void updateStoreSmsOnSent(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateStoreSmsOnSent] store = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateStoreSmsOnSent(bl, n);
        }
    }

    public void updateShortMessageValidityPeriod(int n, int n2) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateShortMessageValidityPeriod] Not implemented.");
    }

    public void updatePhoneSystemRingingVolume(int n, int n2) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updatePhoneSystemRingingVolume] Not implemented.");
    }

    public void updatePhoneSystemRingingType(int n, int n2) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updatePhoneSystemRingingType] Not implemented.");
    }

    public void updateEmailIncludeOldMailInReply(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateEmailIncludeOldMailInReply] Not implemented.");
    }

    public void updateEmailEmptySubjectNotification(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateEmailEmptySubjectNotification] Not implemented.");
    }

    public void updateFolderViewMode(int n, int n2) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateFolderViewMode] Not implemented.");
    }

    public void responseSetSmsIndications(final int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#responseSetSmsIndications] result = %1", (long)n);
        this.executeResponse("responseSetSmsIndications", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
                try {
                    dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingConfigPrimaryListener.this.log, classCastException, "[DsiMessagingConfigPrimaryListener#responseSetSmsIndications]");
                }
                dSIMessagingServiceConfigurationListener.responseSetSmsIndications(n);
            }
        });
    }

    public void responseSetEmailIndications(final int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#responseSetEmailIndications] result = %1", (long)n);
        this.executeResponse("responseSetEmailIndications", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
                try {
                    dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingConfigPrimaryListener.this.log, classCastException, "[DsiMessagingConfigPrimaryListener#responseSetEmailIndications]");
                }
                dSIMessagingServiceConfigurationListener.responseSetEmailIndications(n);
            }
        });
    }

    public void responseSetPushSms(final int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#responseSetPushSms] result = %1", (long)n);
        this.executeResponse("responseSetPushSms", new CommandResponse(){

            public void call(DSIListener dSIListener) {
                DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.this.dsiMessagingConfigDefaultListener;
                try {
                    dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
                }
                catch (ClassCastException classCastException) {
                    Logs.logException(DsiMessagingConfigPrimaryListener.this.log, classCastException, "[DsiMessagingConfigPrimaryListener#responseSetPushSms]");
                }
                dSIMessagingServiceConfigurationListener.responseSetPushSms(n);
            }
        });
    }

    public void updateSmsIndications(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateSmsIndications] smsIndications = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateSmsIndications(bl, n);
        }
    }

    public void updateEmailIndications(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updateEmailIndications] emailIndications = %1, validFlag = %2", bl, (long)n);
        if (n == 1) {
            this.dsiMessagingConfigDefaultListener.updateEmailIndications(bl, n);
        }
    }

    public void updatePushSms(boolean bl, int n) {
        this.log.log(1000000, "[DsiMessagingConfigPrimaryListener#updatePushSms] pushSms = %1, validFlag = %2", bl, (long)n);
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
}

