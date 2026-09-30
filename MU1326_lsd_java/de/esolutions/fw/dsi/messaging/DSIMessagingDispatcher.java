/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.messaging;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingReply;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
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

public class DSIMessagingDispatcher
extends AbstractDispatcher
implements DSIMessagingReply {
    private DSIMessagingReplyService service = new DSIMessagingReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMessagingDispatcher(int n) {
        super(n, (class$org$dsi$ifc$messaging$DSIMessagingListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingListener = DSIMessagingDispatcher.class$("org.dsi.ifc.messaging.DSIMessagingListener")) : class$org$dsi$ifc$messaging$DSIMessagingListener).getName());
    }

    public IReplyService getService() {
        return this.service;
    }

    public void indicateMessageStatus(StatusInformation statusInformation) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.indicateMessageStatus(statusInformation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateFolderInformation(FolderEntry folderEntry) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.indicateFolderInformation(folderEntry);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateListChanged(ListChangedInformation listChangedInformation) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.indicateListChanged(listChangedInformation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateSynchInProgress(boolean bl, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMessagingListener);
                    dSIMessagingListener.updateSynchInProgress(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)iterator.next();
                    dSIMessagingListener.updateSynchInProgress(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) throws MethodException {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMessagingListener);
                    dSIMessagingListener.updateMessagingAccounts(messagingAccountArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)iterator.next();
                    dSIMessagingListener.updateMessagingAccounts(messagingAccountArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateNewMessage(boolean bl, String string, int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.indicateNewMessage(bl, string, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.listEntriesResponse(n, n2, listEntryArray, n3, n4, n5);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getPositionOfMessageResponse(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.getPositionOfMessageResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getPositionOfFolderResponse(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.getPositionOfFolderResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void changeFolderResponse(FolderEntry folderEntry, int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.changeFolderResponse(folderEntry, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteMessageResponse(int n, int n2, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.deleteMessageResponse(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void sendMessageResponse(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.sendMessageResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getMessageContentsResponse(int n, MessageDetails messageDetails) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.getMessageContentsResponse(n, messageDetails);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void setMessageReadStatusResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.setMessageReadStatusResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void parseVCardResponse(int n, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.parseVCardResponse(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void saveAsDraftResponse(int n, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.saveAsDraftResponse(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.extractInformationResponse(n, extractedItemArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void changeTemplateResponse(int n, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.changeTemplateResponse(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getTemplateResponse(int n, Template template) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.getTemplateResponse(n, template);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void getTemplatesResponse(int n, Template[] templateArray) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.getTemplatesResponse(n, templateArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteTemplateResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.deleteTemplateResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicatePushMessageFailed(int n, int n2, int n3, String string) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.indicatePushMessageFailed(n, n2, n3, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.indicateSendMessage(nArray, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void deleteSimCardMessagesResponse(int n) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.deleteSimCardMessagesResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.decodeAttachmentResponse(n, resourceLocator);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void asyncException(int n, String string, int n2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    dSIMessagingListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    public void yyIndication(String string, String string2) throws MethodException {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMessagingListener dSIMessagingListener = (DSIMessagingListener)objectArray[i2];
                    Method method = dSIMessagingListener.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMessagingDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMessagingDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMessagingListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

