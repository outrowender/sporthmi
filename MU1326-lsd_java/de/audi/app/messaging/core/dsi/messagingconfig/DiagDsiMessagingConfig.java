/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.DiagDsi;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$1;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$2;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$3;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$4;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$5;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$6;
import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig$7;
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
        this.upcall(this.currentMethodName(), 0L, new DiagDsiMessagingConfig$1(this));
    }

    @Override
    public void setPhoneSystemRingingVolumeRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void setPhoneSystemRingingTypeRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void setSMSCNumberRequest(String string) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void activateSmsDeliveryReportRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void activateStoreSmsOnSentRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void setShortMessageValidityPeriodRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void activateEmailIncludeOldMailInReplyRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void activateEmailEmptySubjectNotificationRequest(boolean bl) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void changeFolderViewModeRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void restoreFactorySettingsRequest() {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void setAccountPreferences(int n, String string) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void requestSetSmsIndications(boolean bl) {
        this.respond(this.currentMethodName(), 0, new DiagDsiMessagingConfig$2(this, bl));
        this.respond(this.currentMethodName(), 0, new DiagDsiMessagingConfig$3(this));
    }

    @Override
    public void requestSetEmailIndications(boolean bl) {
        this.respond(this.currentMethodName(), 0, new DiagDsiMessagingConfig$4(this, bl));
        this.respond(this.currentMethodName(), 0, new DiagDsiMessagingConfig$5(this));
    }

    @Override
    public void requestSetPushSms(boolean bl) {
        this.respond(this.currentMethodName(), 0, new DiagDsiMessagingConfig$6(this, bl));
        this.respond(this.currentMethodName(), 0, new DiagDsiMessagingConfig$7(this));
    }

    static /* synthetic */ DSIMessagingServiceConfigurationListener access$000(DiagDsiMessagingConfig diagDsiMessagingConfig) {
        return diagDsiMessagingConfig.dsiMessagingConfigListener;
    }
}

