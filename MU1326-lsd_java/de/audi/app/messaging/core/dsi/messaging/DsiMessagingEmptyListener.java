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
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
    }

    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
    }

    @Override
    public void updateSynchInProgress(boolean bl, int n) {
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
    }

    @Override
    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
    }

    @Override
    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
    }

    @Override
    public void getPositionOfMessageResponse(int n, int n2) {
    }

    @Override
    public void changeFolderResponse(FolderEntry folderEntry, int n) {
    }

    @Override
    public void deleteMessageResponse(int n, int n2, int n3) {
    }

    @Override
    public void sendMessageResponse(int n, int n2) {
    }

    @Override
    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
    }

    @Override
    public void setMessageReadStatusResponse(int n) {
    }

    @Override
    public void parseVCardResponse(int n, String string) {
    }

    @Override
    public void saveAsDraftResponse(int n, String string) {
    }

    @Override
    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
    }

    @Override
    public void changeTemplateResponse(int n, int n2) {
    }

    @Override
    public void getTemplateResponse(int n, Template template) {
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
    }

    @Override
    public void deleteTemplateResponse(int n) {
    }

    @Override
    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
    }

    @Override
    public void indicateFolderInformation(FolderEntry folderEntry) {
    }

    @Override
    public void getPositionOfFolderResponse(int n, int n2) {
    }

    @Override
    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
    }

    @Override
    public void deleteSimCardMessagesResponse(int n) {
    }

    @Override
    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
    }
}

