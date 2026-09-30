/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

public interface DSIMessaging
extends DSIBase {
    public static final String VERSION = "2.11.19";
    public static final int RT_CHANGEFOLDERREQUEST = 1000;
    public static final int RT_LISTENTRIESREQUEST = 1001;
    public static final int RT_DELETEMESSAGEREQUEST = 1002;
    public static final int RT_SENDMESSAGEREQUEST = 1003;
    public static final int RT_GETMESSAGECONTENTSREQUEST = 1004;
    public static final int RT_SETMESSAGEREADSTATUSREQUEST = 1005;
    public static final int RT_SAVEASDRAFTREQUEST = 1007;
    public static final int RT_EXTRACTINFORMATIONREQUEST = 1008;
    public static final int RT_DELETETEMPLATEREQUEST = 1009;
    public static final int RT_GETTEMPLATESREQUEST = 1010;
    public static final int RT_GETTEMPLATEREQUEST = 1011;
    public static final int RT_CHANGETEMPLATEREQUEST = 1012;
    public static final int RT_GETPOSITIONOFMESSAGEREQUEST = 1013;
    public static final int RT_GETPOSITIONOFFOLDERREQUEST = 1014;
    public static final int RT_DELETESIMCARDMESSAGESREQUEST = 1015;
    public static final int RT_DECODEATTACHMENTREQUEST = 1016;
    public static final int ATTR_SYNCHINPROGRESS = 4;
    public static final int ATTR_MESSAGINGACCOUNTS = 5;
    public static final int IN_INDICATENEWMESSAGE = 3001;
    public static final int IN_INDICATELISTCHANGED = 3003;
    public static final int IN_INDICATEMESSAGESTATUS = 3004;
    public static final int IN_INDICATEPUSHMESSAGEFAILED = 3005;
    public static final int IN_INDICATESENDMESSAGE = 3006;
    public static final int IN_INDICATEFOLDERINFORMATION = 3007;
    public static final int RP_LISTENTRIESRESPONSE = 2000;
    public static final int RP_CHANGEFOLDERRESPONSE = 2001;
    public static final int RP_DELETEMESSAGERESPONSE = 2002;
    public static final int RP_SENDMESSAGERESPONSE = 2003;
    public static final int RP_GETMESSAGECONTENTSRESPONSE = 2004;
    public static final int RP_SETMESSAGEREADSTATUSRESPONSE = 2005;
    public static final int RP_PARSEVCARDRESPONSE = 2006;
    public static final int RP_SAVEASDRAFTRESPONSE = 2007;
    public static final int RP_EXTRACTINFORMATIONRESPONSE = 2008;
    public static final int RP_DELETETEMPLATERESPONSE = 2009;
    public static final int RP_GETTEMPLATESRESPONSE = 2010;
    public static final int RP_GETTEMPLATERESPONSE = 2011;
    public static final int RP_CHANGETEMPLATERESPONSE = 2012;
    public static final int RP_GETPOSITIONOFMESSAGERESPONSE = 2013;
    public static final int RP_GETPOSITIONOFFOLDERRESPONSE = 2014;
    public static final int RP_DELETESIMCARDMESSAGESRESPONSE = 2015;
    public static final int RP_DECODEATTACHMENTRESPONSE = 2016;

    public void changeFolderRequest(int var1, int var2, int var3, int var4, int var5);

    public void listEntriesRequest(int var1, int var2, int var3);

    public void getPositionOfMessageRequest(String var1);

    public void getPositionOfFolderRequest(int var1);

    public void deleteMessageRequest(String[] var1, boolean var2);

    public void sendMessageRequest(int var1, int var2, RecipientList var3, String var4, String var5, AttachmentInformation[] var6, int var7);

    public void getMessageContentsRequest(int var1, String var2, int var3);

    public void setMessageReadStatusRequest(String var1, boolean var2);

    public void saveAsDraftRequest(String var1, int var2, RecipientList var3, String var4, String var5, int var6, AttachmentInformation[] var7);

    public void extractInformationRequest(String var1);

    public void changeTemplateRequest(int var1, String var2);

    public void getTemplateRequest(int var1);

    public void getTemplatesRequest();

    public void deleteTemplateRequest(int[] var1);

    public void deleteSimCardMessagesRequest(int var1, int var2);

    public void decodeAttachmentRequest(AttachmentInformation var1);
}

