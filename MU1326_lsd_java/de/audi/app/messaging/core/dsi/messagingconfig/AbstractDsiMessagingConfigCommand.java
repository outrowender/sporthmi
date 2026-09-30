/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigDefaultListener;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;

public abstract class AbstractDsiMessagingConfigCommand
extends AbstractMessagingCommand
implements DSIMessagingServiceConfigurationListener {
    protected final DsiMessagingConfigAccess dsiMessagingConfigAccess;
    private final DsiMessagingConfigDefaultListener dsiMessagingConfigDefaultListener;

    protected AbstractDsiMessagingConfigCommand(AbstractMsgApplication abstractMsgApplication) {
        super(abstractMsgApplication);
        this.dsiMessagingConfigAccess = abstractMsgApplication.getDsiMessagingConfigAccess();
        this.dsiMessagingConfigDefaultListener = abstractMsgApplication.getDsiMessagingConfigPrimaryListener().getDsiMessagingConfigDefaultListener();
    }

    public void setSMSCNumberResponse(int n) {
        this.dsiMessagingConfigDefaultListener.setSMSCNumberResponse(n);
    }

    public void activateStoreSmsOnSentResponse(int n) {
        this.dsiMessagingConfigDefaultListener.activateStoreSmsOnSentResponse(n);
    }

    public void setShortMessageValidityPeriodResponse(int n) {
        this.dsiMessagingConfigDefaultListener.setShortMessageValidityPeriodResponse(n);
    }

    public void activateSMSDeliveryReportResponse(int n) {
        this.dsiMessagingConfigDefaultListener.activateSMSDeliveryReportResponse(n);
    }

    public void updateSMSCNumber(String string, int n) {
        this.dsiMessagingConfigDefaultListener.updateSMSCNumber(string, n);
    }

    public void setPhoneSystemRingingVolumeResponse(int n) {
        this.dsiMessagingConfigDefaultListener.setPhoneSystemRingingVolumeResponse(n);
    }

    public void setPhoneSystemRingingTypeResponse(int n) {
        this.dsiMessagingConfigDefaultListener.setPhoneSystemRingingTypeResponse(n);
    }

    public void activateEmailIncludeOldMailInReplyResponse(int n) {
        this.dsiMessagingConfigDefaultListener.activateEmailIncludeOldMailInReplyResponse(n);
    }

    public void activateEmailEmptySubjectNotificationResponse(int n) {
        this.dsiMessagingConfigDefaultListener.activateEmailEmptySubjectNotificationResponse(n);
    }

    public void changeFolderViewModeResponse(int n) {
        this.dsiMessagingConfigDefaultListener.changeFolderViewModeResponse(n);
    }

    public void restoreFactorySettingsResponse(int n) {
        this.dsiMessagingConfigDefaultListener.restoreFactorySettingsResponse(n);
    }

    public void updateAccountPreferences(int n, String string, int n2) {
        this.dsiMessagingConfigDefaultListener.updateAccountPreferences(n, string, n2);
    }

    public void updateSmsDeliveryReport(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updateSmsDeliveryReport(bl, n);
    }

    public void updateStoreSmsOnSent(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updateStoreSmsOnSent(bl, n);
    }

    public void updateShortMessageValidityPeriod(int n, int n2) {
        this.dsiMessagingConfigDefaultListener.updateShortMessageValidityPeriod(n, n2);
    }

    public void updatePhoneSystemRingingVolume(int n, int n2) {
        this.dsiMessagingConfigDefaultListener.updatePhoneSystemRingingVolume(n, n2);
    }

    public void updatePhoneSystemRingingType(int n, int n2) {
        this.dsiMessagingConfigDefaultListener.updatePhoneSystemRingingType(n, n2);
    }

    public void updateEmailIncludeOldMailInReply(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updateEmailIncludeOldMailInReply(bl, n);
    }

    public void updateEmailEmptySubjectNotification(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updateEmailEmptySubjectNotification(bl, n);
    }

    public void updateFolderViewMode(int n, int n2) {
        this.dsiMessagingConfigDefaultListener.updateFolderViewMode(n, n2);
    }

    public void responseSetSmsIndications(int n) {
        this.dsiMessagingConfigDefaultListener.responseSetSmsIndications(n);
    }

    public void responseSetEmailIndications(int n) {
        this.dsiMessagingConfigDefaultListener.responseSetEmailIndications(n);
    }

    public void responseSetPushSms(int n) {
        this.dsiMessagingConfigDefaultListener.responseSetPushSms(n);
    }

    public void updateSmsIndications(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updateSmsIndications(bl, n);
    }

    public void updateEmailIndications(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updateEmailIndications(bl, n);
    }

    public void updatePushSms(boolean bl, int n) {
        this.dsiMessagingConfigDefaultListener.updatePushSms(bl, n);
    }
}

