/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public interface DSIMessagingReply {
    public static final String IPL_COMM_UUID = "de638f1a-b4f1-53c5-ae36-09e21251513b";
    public static final String IPL_COMM_INTERFACE_KEY = "7feed9a5-c7e8-572a-b6fd-2d260b6f2aa6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.19";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.19";

    public void indicateMessageStatus(StatusInformation var1) throws MethodException;

    public void indicateFolderInformation(FolderEntry var1) throws MethodException;

    public void indicateListChanged(ListChangedInformation var1) throws MethodException;

    public void updateSynchInProgress(boolean var1, int var2) throws MethodException;

    public void updateMessagingAccounts(MessagingAccount[] var1, int var2) throws MethodException;

    public void indicateNewMessage(boolean var1, String var2, int var3, int var4) throws MethodException;

    public void listEntriesResponse(int var1, int var2, ListEntry[] var3, int var4, int var5, int var6) throws MethodException;

    public void getPositionOfMessageResponse(int var1, int var2) throws MethodException;

    public void getPositionOfFolderResponse(int var1, int var2) throws MethodException;

    public void changeFolderResponse(FolderEntry var1, int var2) throws MethodException;

    public void deleteMessageResponse(int var1, int var2, int var3) throws MethodException;

    public void sendMessageResponse(int var1, int var2) throws MethodException;

    public void getMessageContentsResponse(int var1, MessageDetails var2) throws MethodException;

    public void setMessageReadStatusResponse(int var1) throws MethodException;

    public void parseVCardResponse(int var1, String var2) throws MethodException;

    public void saveAsDraftResponse(int var1, String var2) throws MethodException;

    public void extractInformationResponse(int var1, ExtractedItem[] var2) throws MethodException;

    public void changeTemplateResponse(int var1, int var2) throws MethodException;

    public void getTemplateResponse(int var1, Template var2) throws MethodException;

    public void getTemplatesResponse(int var1, Template[] var2) throws MethodException;

    public void deleteTemplateResponse(int var1) throws MethodException;

    public void indicatePushMessageFailed(int var1, int var2, int var3, String var4) throws MethodException;

    public void indicateSendMessage(int[] var1, int var2, int var3, RecipientList var4, String var5, String var6, AttachmentInformation[] var7, int var8) throws MethodException;

    public void deleteSimCardMessagesResponse(int var1) throws MethodException;

    public void decodeAttachmentResponse(int var1, ResourceLocator var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

