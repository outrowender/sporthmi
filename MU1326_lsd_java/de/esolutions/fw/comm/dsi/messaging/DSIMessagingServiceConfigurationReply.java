/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMessagingServiceConfigurationReply {
    public static final String IPL_COMM_UUID = "00bb8613-1c87-5188-8f8d-740a594364ca";
    public static final String IPL_COMM_INTERFACE_KEY = "1274017b-42f4-5d28-8978-47f8efc8962f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.19";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.19";

    public void setSMSCNumberResponse(int var1) throws MethodException;

    public void activateStoreSmsOnSentResponse(int var1) throws MethodException;

    public void setShortMessageValidityPeriodResponse(int var1) throws MethodException;

    public void activateSMSDeliveryReportResponse(int var1) throws MethodException;

    public void updateSMSCNumber(String var1, int var2) throws MethodException;

    public void setPhoneSystemRingingVolumeResponse(int var1) throws MethodException;

    public void setPhoneSystemRingingTypeResponse(int var1) throws MethodException;

    public void activateEmailIncludeOldMailInReplyResponse(int var1) throws MethodException;

    public void activateEmailEmptySubjectNotificationResponse(int var1) throws MethodException;

    public void changeFolderViewModeResponse(int var1) throws MethodException;

    public void restoreFactorySettingsResponse(int var1) throws MethodException;

    public void responseSetSmsIndications(int var1) throws MethodException;

    public void responseSetEmailIndications(int var1) throws MethodException;

    public void responseSetPushSms(int var1) throws MethodException;

    public void updateSmsDeliveryReport(boolean var1, int var2) throws MethodException;

    public void updateStoreSmsOnSent(boolean var1, int var2) throws MethodException;

    public void updateShortMessageValidityPeriod(int var1, int var2) throws MethodException;

    public void updatePhoneSystemRingingVolume(int var1, int var2) throws MethodException;

    public void updatePhoneSystemRingingType(int var1, int var2) throws MethodException;

    public void updateEmailIncludeOldMailInReply(boolean var1, int var2) throws MethodException;

    public void updateEmailEmptySubjectNotification(boolean var1, int var2) throws MethodException;

    public void updateFolderViewMode(int var1, int var2) throws MethodException;

    public void updateAccountPreferences(int var1, String var2, int var3) throws MethodException;

    public void updateSmsIndications(boolean var1, int var2) throws MethodException;

    public void updateEmailIndications(boolean var1, int var2) throws MethodException;

    public void updatePushSms(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

