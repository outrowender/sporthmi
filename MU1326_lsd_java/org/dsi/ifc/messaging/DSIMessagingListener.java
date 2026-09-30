/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIListener;
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

public interface DSIMessagingListener
extends DSIListener {
    public void indicateMessageStatus(StatusInformation var1);

    public void indicateFolderInformation(FolderEntry var1);

    public void indicateListChanged(ListChangedInformation var1);

    public void updateSynchInProgress(boolean var1, int var2);

    public void updateMessagingAccounts(MessagingAccount[] var1, int var2);

    public void indicateNewMessage(boolean var1, String var2, int var3, int var4);

    public void listEntriesResponse(int var1, int var2, ListEntry[] var3, int var4, int var5, int var6);

    public void getPositionOfMessageResponse(int var1, int var2);

    public void getPositionOfFolderResponse(int var1, int var2);

    public void changeFolderResponse(FolderEntry var1, int var2);

    public void deleteMessageResponse(int var1, int var2, int var3);

    public void sendMessageResponse(int var1, int var2);

    public void getMessageContentsResponse(int var1, MessageDetails var2);

    public void setMessageReadStatusResponse(int var1);

    public void parseVCardResponse(int var1, String var2);

    public void saveAsDraftResponse(int var1, String var2);

    public void extractInformationResponse(int var1, ExtractedItem[] var2);

    public void changeTemplateResponse(int var1, int var2);

    public void getTemplateResponse(int var1, Template var2);

    public void getTemplatesResponse(int var1, Template[] var2);

    public void deleteTemplateResponse(int var1);

    public void indicatePushMessageFailed(int var1, int var2, int var3, String var4);

    public void indicateSendMessage(int[] var1, int var2, int var3, RecipientList var4, String var5, String var6, AttachmentInformation[] var7, int var8);

    public void deleteSimCardMessagesResponse(int var1);

    public void decodeAttachmentResponse(int var1, ResourceLocator var2);
}

