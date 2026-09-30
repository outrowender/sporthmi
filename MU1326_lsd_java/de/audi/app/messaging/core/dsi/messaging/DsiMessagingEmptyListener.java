/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public class DsiMessagingEmptyListener
implements DSIMessagingListener {
    public void asyncException(int n, String string, int n2) {
    }

    public void indicateMessageStatus(StatusInformation statusInformation) {
    }

    public void indicateListChanged(ListChangedInformation listChangedInformation) {
    }

    public void updateSynchInProgress(boolean bl, int n) {
    }

    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
    }

    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
    }

    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
    }

    public void getPositionOfMessageResponse(int n, int n2) {
    }

    public void changeFolderResponse(FolderEntry folderEntry, int n) {
    }

    public void deleteMessageResponse(int n, int n2, int n3) {
    }

    public void sendMessageResponse(int n, int n2) {
    }

    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
    }

    public void setMessageReadStatusResponse(int n) {
    }

    public void parseVCardResponse(int n, String string) {
    }

    public void saveAsDraftResponse(int n, String string) {
    }

    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
    }

    public void changeTemplateResponse(int n, int n2) {
    }

    public void getTemplateResponse(int n, Template template) {
    }

    public void getTemplatesResponse(int n, Template[] templateArray) {
    }

    public void deleteTemplateResponse(int n) {
    }

    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
    }

    public void indicateFolderInformation(FolderEntry folderEntry) {
    }

    public void getPositionOfFolderResponse(int n, int n2) {
    }

    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
    }

    public void deleteSimCardMessagesResponse(int n) {
    }

    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
    }
}

