/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingDefaultListener;
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

public abstract class AbstractDsiMessagingCommand
extends AbstractMessagingCommand
implements DSIMessagingListener {
    protected final DsiMessagingAccess dsiMessagingAccess;
    private final DsiMessagingDefaultListener dsiMessagingDefaultListener;

    protected AbstractDsiMessagingCommand(AbstractMsgApplication abstractMsgApplication) {
        super(abstractMsgApplication);
        this.dsiMessagingAccess = abstractMsgApplication.getDsiMessagingAccess();
        this.dsiMessagingDefaultListener = abstractMsgApplication.getDsiMessagingPrimaryListener().getDsiMessagingDefaultListener();
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        this.dsiMessagingDefaultListener.indicateMessageStatus(statusInformation);
    }

    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
        this.dsiMessagingDefaultListener.indicateListChanged(listChangedInformation);
    }

    @Override
    public void updateSynchInProgress(boolean bl, int n) {
        this.dsiMessagingDefaultListener.updateSynchInProgress(bl, n);
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        this.dsiMessagingDefaultListener.updateMessagingAccounts(messagingAccountArray, n);
    }

    @Override
    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
        this.dsiMessagingDefaultListener.indicateNewMessage(bl, string, n, n2);
    }

    public void indicateNewMessageOverflow(boolean bl, int n) {
        this.dsiMessagingDefaultListener.indicateNewMessageOverflow(bl, n);
    }

    @Override
    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        this.dsiMessagingDefaultListener.listEntriesResponse(n, n2, listEntryArray, n3, n4, n5);
    }

    @Override
    public void getPositionOfMessageResponse(int n, int n2) {
        this.dsiMessagingDefaultListener.getPositionOfMessageResponse(n, n2);
    }

    @Override
    public void changeFolderResponse(FolderEntry folderEntry, int n) {
        this.dsiMessagingDefaultListener.changeFolderResponse(folderEntry, n);
    }

    @Override
    public void deleteMessageResponse(int n, int n2, int n3) {
        this.dsiMessagingDefaultListener.deleteMessageResponse(n, n2, n3);
    }

    @Override
    public void sendMessageResponse(int n, int n2) {
        this.dsiMessagingDefaultListener.sendMessageResponse(n, n2);
    }

    @Override
    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
        this.dsiMessagingDefaultListener.getMessageContentsResponse(n, messageDetails);
    }

    @Override
    public void setMessageReadStatusResponse(int n) {
        this.dsiMessagingDefaultListener.setMessageReadStatusResponse(n);
    }

    @Override
    public void parseVCardResponse(int n, String string) {
        this.dsiMessagingDefaultListener.parseVCardResponse(n, string);
    }

    @Override
    public void saveAsDraftResponse(int n, String string) {
        this.dsiMessagingDefaultListener.saveAsDraftResponse(n, string);
    }

    @Override
    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        this.dsiMessagingDefaultListener.extractInformationResponse(n, extractedItemArray);
    }

    @Override
    public void changeTemplateResponse(int n, int n2) {
        this.dsiMessagingDefaultListener.changeTemplateResponse(n, n2);
    }

    @Override
    public void getTemplateResponse(int n, Template template) {
        this.dsiMessagingDefaultListener.getTemplateResponse(n, template);
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
        this.dsiMessagingDefaultListener.getTemplatesResponse(n, templateArray);
    }

    @Override
    public void deleteTemplateResponse(int n) {
        this.dsiMessagingDefaultListener.deleteTemplateResponse(n);
    }

    @Override
    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
        this.dsiMessagingDefaultListener.indicatePushMessageFailed(n, n2, n3, string);
    }

    @Override
    public void indicateFolderInformation(FolderEntry folderEntry) {
        this.dsiMessagingDefaultListener.indicateFolderInformation(folderEntry);
    }

    @Override
    public void getPositionOfFolderResponse(int n, int n2) {
        this.dsiMessagingDefaultListener.getPositionOfFolderResponse(n, n2);
    }

    @Override
    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        this.dsiMessagingDefaultListener.indicateSendMessage(nArray, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
    }

    @Override
    public void deleteSimCardMessagesResponse(int n) {
        this.dsiMessagingDefaultListener.deleteSimCardMessagesResponse(n);
    }

    @Override
    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
        this.dsiMessagingDefaultListener.decodeAttachmentResponse(n, resourceLocator);
    }
}

