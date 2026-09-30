/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMessagingServiceConfigurationC {
    public void setPhoneSystemRingingVolumeRequest(int var1) throws MethodException;

    public void setPhoneSystemRingingTypeRequest(int var1) throws MethodException;

    public void setSMSCNumberRequest(String var1) throws MethodException;

    public void activateSmsDeliveryReportRequest(boolean var1) throws MethodException;

    public void activateStoreSmsOnSentRequest(boolean var1) throws MethodException;

    public void setShortMessageValidityPeriodRequest(int var1) throws MethodException;

    public void activateEmailIncludeOldMailInReplyRequest(boolean var1) throws MethodException;

    public void activateEmailEmptySubjectNotificationRequest(boolean var1) throws MethodException;

    public void changeFolderViewModeRequest(int var1) throws MethodException;

    public void restoreFactorySettingsRequest() throws MethodException;

    public void setAccountPreferences(int var1, String var2) throws MethodException;

    public void requestSetSmsIndications(boolean var1) throws MethodException;

    public void requestSetEmailIndications(boolean var1) throws MethodException;

    public void requestSetPushSms(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

