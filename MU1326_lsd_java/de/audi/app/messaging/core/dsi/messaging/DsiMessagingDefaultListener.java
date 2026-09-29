/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.util.Logs;
import java.util.Collection;
import java.util.LinkedList;
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

final class DsiMessagingDefaultListener
extends AbstractMessagingComponent
implements DSIMessagingListener {
    private final Collection subscribers = new LinkedList();

    DsiMessagingDefaultListener(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
    }

    public synchronized void addSubscriber(DSIMessagingListener dSIMessagingListener) {
        this.subscribers.add(dSIMessagingListener);
    }

    private synchronized DSIMessagingListener[] getCurrentSubscribers() {
        Object[] objectArray = new DSIMessagingListener[this.subscribers.size()];
        this.subscribers.toArray(objectArray);
        return objectArray;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#asyncException] Not implemented.");
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].indicateMessageStatus(statusInformation);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#indicateMessageStatus]");
            }
        }
    }

    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
        if (listChangedInformation == null) {
            Logs.logNullParameter(this.log, "[DsiMessagingDefaultListener#indicateListChanged]");
        } else {
            DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
            for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
                try {
                    dSIMessagingListenerArray[i2].indicateListChanged(listChangedInformation);
                    continue;
                }
                catch (Exception exception) {
                    Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#indicateListChanged]");
                }
            }
        }
    }

    @Override
    public void updateSynchInProgress(boolean bl, int n) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].updateSynchInProgress(bl, n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#updateSynchInProgress]");
            }
        }
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        if (messagingAccountArray == null) {
            Logs.logNullParameter(this.log, "[DsiMessagingDefaultListener#updateMessagingAccounts]");
        } else {
            DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
            for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
                try {
                    dSIMessagingListenerArray[i2].updateMessagingAccounts(messagingAccountArray, n);
                    continue;
                }
                catch (Exception exception) {
                    Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#updateMessagingAccounts]");
                }
            }
        }
    }

    @Override
    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].indicateNewMessage(bl, string, n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#indicateNewMessage]");
            }
        }
    }

    public void indicateNewMessageOverflow(boolean bl, int n) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#indicateNewMessageOverflow] Not implemented.");
    }

    @Override
    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#listEntriesResponse] Not implemented.");
    }

    @Override
    public void getPositionOfMessageResponse(int n, int n2) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#getPositionOfMessageResponse] Not implemented.");
    }

    @Override
    public void changeFolderResponse(FolderEntry folderEntry, int n) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#changeFolderResponse] Not implemented.");
    }

    @Override
    public void deleteMessageResponse(int n, int n2, int n3) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#deleteMessageResponse] Not implemented.");
    }

    @Override
    public void sendMessageResponse(int n, int n2) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#sendMessageResponse] Not implemented.");
    }

    @Override
    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#getMessageContentsResponse] Not implemented.");
    }

    @Override
    public void setMessageReadStatusResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#setMessageReadStatusResponse] Not implemented.");
    }

    @Override
    public void parseVCardResponse(int n, String string) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#parseVCardResponse] Not implemented.");
    }

    @Override
    public void saveAsDraftResponse(int n, String string) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#saveAsDraftResponse] Not implemented.");
    }

    @Override
    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#extractInformationResponse] Not implemented.");
    }

    @Override
    public void changeTemplateResponse(int n, int n2) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#changeTemplateResponse] Not implemented.");
    }

    @Override
    public void getTemplateResponse(int n, Template template) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#getTemplateResponse] Not implemented.");
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].getTemplatesResponse(n, templateArray);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#getTemplatesResponse]");
            }
        }
    }

    @Override
    public void deleteTemplateResponse(int n) {
        this.log.log(-1601830656, "[DsiMessagingDefaultListener#deleteTemplateResponse] Not implemented.");
    }

    @Override
    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].indicatePushMessageFailed(n, n2, n3, string);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#indicatePushMessageFailed]");
            }
        }
    }

    @Override
    public void indicateFolderInformation(FolderEntry folderEntry) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].indicateFolderInformation(folderEntry);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#indicateFolderInformation]");
            }
        }
    }

    @Override
    public void getPositionOfFolderResponse(int n, int n2) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].getPositionOfFolderResponse(n, n2);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#getPositionOfFolderResponse]");
            }
        }
    }

    @Override
    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].indicateSendMessage(nArray, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#indicateSendMessage]");
            }
        }
    }

    @Override
    public void deleteSimCardMessagesResponse(int n) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].deleteSimCardMessagesResponse(n);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#deleteSimCardMessagesResponse]");
            }
        }
    }

    @Override
    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
        DSIMessagingListener[] dSIMessagingListenerArray = this.getCurrentSubscribers();
        for (int i2 = 0; i2 < dSIMessagingListenerArray.length; ++i2) {
            try {
                dSIMessagingListenerArray[i2].decodeAttachmentResponse(n, resourceLocator);
                continue;
            }
            catch (Exception exception) {
                Logs.logException(this.log, exception, "[DsiMessagingDefaultListener#decodeAttachmentResponse]");
            }
        }
    }
}

