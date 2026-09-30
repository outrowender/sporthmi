/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.DiagDsi;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;

public class DiagDsiMessagingConfig
extends DiagDsi
implements DSIMessagingServiceConfiguration {
    private final DSIMessagingServiceConfigurationListener dsiMessagingConfigListener;

    public DiagDsiMessagingConfig(DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener, LogChannel logChannel, DispatcherBase dispatcherBase) {
        super(logChannel, dispatcherBase);
        this.dsiMessagingConfigListener = dSIMessagingServiceConfigurationListener;
    }

    public void initServiceCenterNumber() {
        this.upcall(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.updateSMSCNumber("0123555666", 1);
            }
        });
    }

    public void setPhoneSystemRingingVolumeRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void setPhoneSystemRingingTypeRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void setSMSCNumberRequest(String string) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void activateSmsDeliveryReportRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void activateStoreSmsOnSentRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void setShortMessageValidityPeriodRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void activateEmailIncludeOldMailInReplyRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void activateEmailEmptySubjectNotificationRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void changeFolderViewModeRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void restoreFactorySettingsRequest() {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void setAccountPreferences(int n, String string) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void requestSetSmsIndications(final boolean bl) {
        this.respond(this.currentMethodName(), 500L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.updateSmsIndications(bl, 1);
            }
        });
        this.respond(this.currentMethodName(), 1000L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.responseSetSmsIndications(0);
            }
        });
    }

    public void requestSetEmailIndications(final boolean bl) {
        this.respond(this.currentMethodName(), 500L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.updateEmailIndications(bl, 1);
            }
        });
        this.respond(this.currentMethodName(), 1000L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.responseSetEmailIndications(0);
            }
        });
    }

    public void requestSetPushSms(final boolean bl) {
        this.respond(this.currentMethodName(), 500L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.updatePushSms(bl, 1);
            }
        });
        this.respond(this.currentMethodName(), 1000L, new Runnable(){

            public void run() {
                DiagDsiMessagingConfig.this.dsiMessagingConfigListener.responseSetPushSms(0);
            }
        });
    }
}

