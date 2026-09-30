/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIBase;

public interface DSIMessagingServiceConfiguration
extends DSIBase {
    public static final String VERSION = "2.11.19";
    public static final int RT_SETSMSCNUMBERREQUEST = 1001;
    public static final int RT_ACTIVATESMSDELIVERYREPORTREQUEST = 1002;
    public static final int RT_ACTIVATESTORESMSONSENTREQUEST = 1003;
    public static final int RT_SETSHORTMESSAGEVALIDITYPERIODREQUEST = 1004;
    public static final int RT_SETPHONESYSTEMRINGINGVOLUMEREQUEST = 1005;
    public static final int RT_SETPHONESYSTEMRINGINGTYPEREQUEST = 1006;
    public static final int RT_ACTIVATEEMAILINCLUDEOLDMAILINREPLYREQUEST = 1007;
    public static final int RT_ACTIVATEEMAILEMPTYSUBJECTNOTIFICATIONREQUEST = 1008;
    public static final int RT_CHANGEFOLDERVIEWMODEREQUEST = 1009;
    public static final int RT_RESTOREFACTORYSETTINGSREQUEST = 1010;
    public static final int RT_SETACCOUNTPREFERENCES = 1011;
    public static final int RT_REQUESTSETSMSINDICATIONS = 1012;
    public static final int RT_REQUESTSETEMAILINDICATIONS = 1013;
    public static final int RT_REQUESTSETPUSHSMS = 1014;
    public static final int ATTR_SMSCNUMBER = 1;
    public static final int ATTR_SMSDELIVERYREPORT = 2;
    public static final int ATTR_STORESMSONSENT = 3;
    public static final int ATTR_SHORTMESSAGEVALIDITYPERIOD = 4;
    public static final int ATTR_PHONESYSTEMRINGINGVOLUME = 5;
    public static final int ATTR_PHONESYSTEMRINGINGTYPE = 6;
    public static final int ATTR_EMAILINCLUDEOLDMAILINREPLY = 7;
    public static final int ATTR_EMAILEMPTYSUBJECTNOTIFICATION = 8;
    public static final int ATTR_FOLDERVIEWMODE = 9;
    public static final int ATTR_ACCOUNTPREFERENCES = 10;
    public static final int ATTR_SMSINDICATIONS = 11;
    public static final int ATTR_EMAILINDICATIONS = 12;
    public static final int ATTR_PUSHSMS = 13;
    public static final int RP_SETSMSCNUMBERRESPONSE = 2001;
    public static final int RP_ACTIVATESMSDELIVERYREPORTRESPONSE = 2002;
    public static final int RP_ACTIVATESTORESMSONSENTRESPONSE = 2003;
    public static final int RP_SETSHORTMESSAGEVALIDITYPERIODRESPONSE = 2004;
    public static final int RP_SETPHONESYSTEMRINGINGVOLUMERESPONSE = 2005;
    public static final int RP_SETPHONESYSTEMRINGINGTYPERESPONSE = 2006;
    public static final int RP_ACTIVATEEMAILINCLUDEOLDMAILINREPLYRESPONSE = 2007;
    public static final int RP_ACTIVATEEMAILEMPTYSUBJECTNOTIFICATIONRESPONSE = 2008;
    public static final int RP_CHANGEFOLDERVIEWMODERESPONSE = 2009;
    public static final int RP_RESTOREFACTORYSETTINGSRESPONSE = 2010;
    public static final int RP_RESPONSESETSMSINDICATIONS = 2011;
    public static final int RP_RESPONSESETEMAILINDICATIONS = 2012;
    public static final int RP_RESPONSESETPUSHSMS = 2013;

    public void setPhoneSystemRingingVolumeRequest(int var1);

    public void setPhoneSystemRingingTypeRequest(int var1);

    public void setSMSCNumberRequest(String var1);

    public void activateSmsDeliveryReportRequest(boolean var1);

    public void activateStoreSmsOnSentRequest(boolean var1);

    public void setShortMessageValidityPeriodRequest(int var1);

    public void activateEmailIncludeOldMailInReplyRequest(boolean var1);

    public void activateEmailEmptySubjectNotificationRequest(boolean var1);

    public void changeFolderViewModeRequest(int var1);

    public void restoreFactorySettingsRequest();

    public void setAccountPreferences(int var1, String var2);

    public void requestSetSmsIndications(boolean var1);

    public void requestSetEmailIndications(boolean var1);

    public void requestSetPushSms(boolean var1);
}

