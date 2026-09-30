/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.DiagDsi;
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
import org.dsi.ifc.messaging.Template;

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
        this.upcall(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.updateMessagingAccounts(DiagDsiMessagingData.MSG_ACCOUNTS, 1);
            }
        });
    }

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
        this.respond(this.currentMethodName(), 0L, new Runnable((FolderEntry)object, n6, listChangedInformation){
            private final /* synthetic */ FolderEntry val$activeFolderEntry;
            private final /* synthetic */ int val$resultCode;
            private final /* synthetic */ ListChangedInformation val$information;
            {
                this.val$activeFolderEntry = folderEntry;
                this.val$resultCode = n;
                this.val$information = listChangedInformation;
            }

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.changeFolderResponse(this.val$activeFolderEntry, this.val$resultCode);
                if (this.val$resultCode == 0) {
                    DiagDsiMessaging.this.dsiMessagingListener.indicateListChanged(this.val$information);
                }
            }
        });
    }

    public void listEntriesRequest(final int n, final int n2, int n3) {
        final ListEntry[] listEntryArray = new ListEntry[n3];
        try {
            System.arraycopy((Object)DiagDsiMessagingData.LIST_ENTRIES, n2, (Object)listEntryArray, 0, n3);
        }
        catch (Exception exception) {
            this.log.log(100000, "DiagDsiMessaging#listEntriesRequest(): list copy failed");
        }
        final int n4 = this.selectedMessagingAccount.getAccountID();
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.listEntriesResponse(n, 0, listEntryArray, n4, DiagDsiMessagingData.ROOT_FOLDER.getFolderID(), n2);
            }
        });
    }

    public void getPositionOfMessageRequest(String string) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void deleteMessageRequest(String[] stringArray, boolean bl) {
        final int n = stringArray.length;
        int n2 = DiagDsiMessagingData.LIST_ENTRIES.length;
        final int n3 = Math.min(n, n2);
        int n4 = n2 - n3;
        n4 = Math.max(n4, 0);
        final ListChangedInformation listChangedInformation = new ListChangedInformation(4, n4);
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.deleteMessageResponse(0, n3, n);
            }
        });
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.indicateListChanged(listChangedInformation);
            }
        });
    }

    public void sendMessageRequest(final int n, final int n2, final RecipientList recipientList, final String string, final String string2, final AttachmentInformation[] attachmentInformationArray, final int n3) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.sendMessageResponse(0, n);
            }
        });
        this.respond(this.currentMethodName(), 2000L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.indicateSendMessage(new int[]{0}, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
            }
        });
    }

    public void getMessageContentsRequest(int n, String string, int n2) {
        MessageDetails messageDetails = DiagDsiMessagingData.CONCAT_SMS[0].getMessageID().equals(string) ? DiagDsiMessagingData.CONCAT_SMS[this.segmentCounter++ % DiagDsiMessagingData.CONCAT_SMS.length] : (this.selectedMessagingAccount.isSupportsEMail() ? DiagDsiMessagingData.MESSAGE_DETAILS_EMAIL : DiagDsiMessagingData.MESSAGE_DETAILS_SMS);
        final MessageDetails messageDetails2 = new MessageDetails(this.selectedMessagingAccount.getAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), messageDetails.getDateTime(), messageDetails.getMessageStatus(), messageDetails.getReplyTo(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.getMessageContentsResponse(0, messageDetails2);
            }
        });
    }

    public void setMessageReadStatusRequest(String string, boolean bl) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.setMessageReadStatusResponse(0);
            }
        });
    }

    public void parseVCardRequest(String string, int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        final String string4 = new StringBuffer().append(string).append("D").toString();
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.saveAsDraftResponse(0, string4);
            }
        });
    }

    public void extractInformationRequest(String string) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.extractInformationResponse(0, DiagDsiMessagingData.EXTRACTED_ITEMS);
            }
        });
    }

    public void changeTemplateRequest(final int n, String string) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.changeTemplateResponse(0, n);
            }
        });
    }

    public void getTemplateRequest(final int n) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                int n2 = 2;
                Template template = null;
                for (int i2 = 0; i2 < DiagDsiMessagingData.templates.length; ++i2) {
                    if (DiagDsiMessagingData.templates[i2].getId() != n) continue;
                    n2 = 0;
                    template = DiagDsiMessagingData.templates[i2];
                }
                DiagDsiMessaging.this.dsiMessagingListener.getTemplateResponse(n2, template);
            }
        });
    }

    public void getTemplatesRequest() {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.getTemplatesResponse(0, DiagDsiMessagingData.templates);
            }
        });
    }

    public void deleteTemplateRequest(final int[] nArray) {
        this.respond(this.currentMethodName(), 1000L, new Runnable(){

            public void run() {
                Template[] templateArray = new Template[DiagDsiMessagingData.templates.length - nArray.length];
                int n = 0;
                for (int i2 = 0; i2 < DiagDsiMessagingData.templates.length; ++i2) {
                    boolean bl = false;
                    for (int i3 = 0; i3 < nArray.length; ++i3) {
                        if (DiagDsiMessagingData.templates[i2].id != nArray[i3]) continue;
                        bl = true;
                    }
                    if (bl) continue;
                    templateArray[n++] = DiagDsiMessagingData.templates[i2];
                }
                DiagDsiMessagingData.templates = templateArray;
                DiagDsiMessaging.this.dsiMessagingListener.deleteTemplateResponse(0);
            }
        });
    }

    public void getPositionOfFolderRequest(int n) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void deleteSimCardMessagesRequest(int n, int n2) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.deleteSimCardMessagesResponse(0);
            }
        });
    }

    public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
        this.respond(this.currentMethodName(), 0L, new Runnable(){

            public void run() {
                DiagDsiMessaging.this.dsiMessagingListener.decodeAttachmentResponse(0, DiagDsiMessagingData.VCARD_ATTACHMENT.getAttachmentPath());
            }
        });
    }
}

