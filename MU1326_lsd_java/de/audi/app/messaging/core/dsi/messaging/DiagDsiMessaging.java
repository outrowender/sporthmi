/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.DiagDsi;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$1;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$10;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$11;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$12;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$13;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$14;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$15;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$16;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$17;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$2;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$3;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$4;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$5;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$6;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$7;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$8;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging$9;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessagingData;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;

public final class DiagDsiMessaging
extends DiagDsi
implements DSIMessaging {
    private final DSIMessagingListener dsiMessagingListener;
    private volatile MessagingAccount selectedMessagingAccount;
    private volatile int segmentCounter = 0;

    public DiagDsiMessaging(DSIMessagingListener dSIMessagingListener, LogChannel logChannel, DispatcherBase dispatcherBase) {
        super(logChannel, dispatcherBase);
        this.dsiMessagingListener = dSIMessagingListener;
    }

    public void initAccounts() {
        this.upcall(this.currentMethodName(), 0L, new DiagDsiMessaging$1(this));
    }

    @Override
    public void changeFolderRequest(int n, int n2, int n3, int n4, int n5) {
        Object object;
        int n6;
        MessagingAccount messagingAccount = null;
        for (n6 = 0; n6 < DiagDsiMessagingData.MSG_ACCOUNTS.length; ++n6) {
            object = DiagDsiMessagingData.MSG_ACCOUNTS[n6];
            if (((MessagingAccount)object).getAccountID() != n3) continue;
            messagingAccount = object;
        }
        if (messagingAccount != null) {
            this.selectedMessagingAccount = messagingAccount;
        }
        n6 = messagingAccount != null ? 0 : 2;
        object = n6 == 0 ? DiagDsiMessagingData.ROOT_FOLDER : null;
        ListChangedInformation listChangedInformation = new ListChangedInformation(6, DiagDsiMessagingData.LIST_ENTRIES.length);
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$2(this, (FolderEntry)object, n6, listChangedInformation));
    }

    @Override
    public void listEntriesRequest(int n, int n2, int n3) {
        ListEntry[] listEntryArray = new ListEntry[n3];
        try {
            System.arraycopy((Object)DiagDsiMessagingData.LIST_ENTRIES, n2, (Object)listEntryArray, 0, n3);
        }
        catch (Exception exception) {
            this.log.log(-1601830656, "DiagDsiMessaging#listEntriesRequest(): list copy failed");
        }
        int n4 = this.selectedMessagingAccount.getAccountID();
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$3(this, n, listEntryArray, n4, n2));
    }

    @Override
    public void getPositionOfMessageRequest(String string) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void deleteMessageRequest(String[] stringArray, boolean bl) {
        int n = stringArray.length;
        int n2 = DiagDsiMessagingData.LIST_ENTRIES.length;
        int n3 = Math.min(n, n2);
        int n4 = n2 - n3;
        n4 = Math.max(n4, 0);
        ListChangedInformation listChangedInformation = new ListChangedInformation(4, n4);
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$4(this, n3, n));
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$5(this, listChangedInformation));
    }

    @Override
    public void sendMessageRequest(int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$6(this, n));
        this.respond(this.currentMethodName(), 0, new DiagDsiMessaging$7(this, n, n2, recipientList, string, string2, attachmentInformationArray, n3));
    }

    @Override
    public void getMessageContentsRequest(int n, String string, int n2) {
        MessageDetails messageDetails = DiagDsiMessagingData.CONCAT_SMS[0].getMessageID().equals(string) ? DiagDsiMessagingData.CONCAT_SMS[this.segmentCounter++ % DiagDsiMessagingData.CONCAT_SMS.length] : (this.selectedMessagingAccount.isSupportsEMail() ? DiagDsiMessagingData.MESSAGE_DETAILS_EMAIL : DiagDsiMessagingData.MESSAGE_DETAILS_SMS);
        MessageDetails messageDetails2 = new MessageDetails(this.selectedMessagingAccount.getAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), messageDetails.getDateTime(), messageDetails.getMessageStatus(), messageDetails.getReplyTo(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$8(this, messageDetails2));
    }

    @Override
    public void setMessageReadStatusRequest(String string, boolean bl) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$9(this));
    }

    public void parseVCardRequest(String string, int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        String string4 = new StringBuffer().append(string).append("D").toString();
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$10(this, string4));
    }

    @Override
    public void extractInformationRequest(String string) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$11(this));
    }

    @Override
    public void changeTemplateRequest(int n, String string) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$12(this, n));
    }

    @Override
    public void getTemplateRequest(int n) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$13(this, n));
    }

    @Override
    public void getTemplatesRequest() {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$14(this));
    }

    @Override
    public void deleteTemplateRequest(int[] nArray) {
        this.respond(this.currentMethodName(), 0, new DiagDsiMessaging$15(this, nArray));
    }

    @Override
    public void getPositionOfFolderRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    @Override
    public void deleteSimCardMessagesRequest(int n, int n2) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$16(this));
    }

    @Override
    public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
        this.respond(this.currentMethodName(), 0L, new DiagDsiMessaging$17(this));
    }

    static /* synthetic */ DSIMessagingListener access$000(DiagDsiMessaging diagDsiMessaging) {
        return diagDsiMessaging.dsiMessagingListener;
    }
}

