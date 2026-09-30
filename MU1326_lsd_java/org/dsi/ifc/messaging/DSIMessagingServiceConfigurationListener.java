/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIListener;

public interface DSIMessagingServiceConfigurationListener
extends DSIListener {
    public void setSMSCNumberResponse(int var1);

    public void activateStoreSmsOnSentResponse(int var1);

    public void setShortMessageValidityPeriodResponse(int var1);

    public void activateSMSDeliveryReportResponse(int var1);

    public void updateSMSCNumber(String var1, int var2);

    public void setPhoneSystemRingingVolumeResponse(int var1);

    public void setPhoneSystemRingingTypeResponse(int var1);

    public void activateEmailIncludeOldMailInReplyResponse(int var1);

    public void activateEmailEmptySubjectNotificationResponse(int var1);

    public void changeFolderViewModeResponse(int var1);

    public void restoreFactorySettingsResponse(int var1);

    public void responseSetSmsIndications(int var1);

    public void responseSetEmailIndications(int var1);

    public void responseSetPushSms(int var1);

    public void updateSmsDeliveryReport(boolean var1, int var2);

    public void updateStoreSmsOnSent(boolean var1, int var2);

    public void updateShortMessageValidityPeriod(int var1, int var2);

    public void updatePhoneSystemRingingVolume(int var1, int var2);

    public void updatePhoneSystemRingingType(int var1, int var2);

    public void updateEmailIncludeOldMailInReply(boolean var1, int var2);

    public void updateEmailEmptySubjectNotification(boolean var1, int var2);

    public void updateFolderViewMode(int var1, int var2);

    public void updateAccountPreferences(int var1, String var2, int var3);

    public void updateSmsIndications(boolean var1, int var2);

    public void updateEmailIndications(boolean var1, int var2);

    public void updatePushSms(boolean var1, int var2);
}

