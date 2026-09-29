/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.Strings;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;

public class Messages {
    public static boolean isSms(MessageListEntry messageListEntry) {
        return messageListEntry != null && Messages.isSmsMessageType(messageListEntry.getType());
    }

    public static boolean isSms(MessageDetails messageDetails) {
        return messageDetails != null && Messages.isSmsMessageType(messageDetails.getType());
    }

    public static boolean isEmail(MessageListEntry messageListEntry) {
        return messageListEntry != null && Messages.isEmailMessageType(messageListEntry.getType());
    }

    public static boolean isEmail(MessageDetails messageDetails) {
        return messageDetails != null && Messages.isEmailMessageType(messageDetails.getType());
    }

    private static boolean isSmsMessageType(int n) {
        return n == 3 || n == 1;
    }

    private static boolean isEmailMessageType(int n) {
        return n == 2;
    }

    public static boolean isOutbound(MessageListEntry messageListEntry) {
        return messageListEntry != null && Messages.isOutboundStatus(messageListEntry.getMessageStatus());
    }

    public static boolean isOutbound(MessageDetails messageDetails) {
        return messageDetails != null && Messages.isOutboundStatus(messageDetails.getMessageStatus());
    }

    private static boolean isOutboundStatus(int n) {
        return n == 7 || n == 2 || n == 8 || n == 6 || n == 5;
    }

    public static boolean isBlank(MessageDetails messageDetails) {
        if (messageDetails == null) {
            return true;
        }
        MatchedAddress[] matchedAddressArray = messageDetails.getRecipientsTo();
        MatchedAddress[] matchedAddressArray2 = messageDetails.getRecipientsCc();
        MatchedAddress[] matchedAddressArray3 = messageDetails.getRecipientsBcc();
        String string = messageDetails.getSubject();
        String string2 = messageDetails.getBody();
        AttachmentInformation[] attachmentInformationArray = messageDetails.getAttachments();
        matchedAddressArray = matchedAddressArray != null ? matchedAddressArray : new MatchedAddress[]{};
        matchedAddressArray2 = matchedAddressArray2 != null ? matchedAddressArray2 : new MatchedAddress[]{};
        matchedAddressArray3 = matchedAddressArray3 != null ? matchedAddressArray3 : new MatchedAddress[]{};
        attachmentInformationArray = attachmentInformationArray != null ? attachmentInformationArray : new AttachmentInformation[]{};
        return matchedAddressArray.length == 0 && matchedAddressArray2.length == 0 && matchedAddressArray3.length == 0 && Strings.isNullOrEmpty(string) && Strings.isNullOrEmpty(string2) && attachmentInformationArray.length == 0;
    }

    public static MessageDetails truncateBody(MessageDetails messageDetails, int n) {
        String string;
        int n2;
        MessageDetails messageDetails2 = messageDetails;
        int n3 = n2 = n < 0 ? 0 : n;
        if (messageDetails != null && !Strings.isNullOrEmpty(string = messageDetails.getBody()) && string.length() > n2) {
            String string2 = string.substring(0, n2);
            messageDetails2 = new MessageDetails(messageDetails.getMessagingAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), messageDetails.getDateTime(), messageDetails.getMessageStatus(), messageDetails.getReplyTo(), string2, messageDetails.getAttachments(), messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
        }
        return messageDetails2;
    }

    public static MessageDetails copy(MessageDetails messageDetails) {
        MessageDetails messageDetails2 = messageDetails;
        if (messageDetails != null) {
            messageDetails2 = new MessageDetails(messageDetails.getMessagingAccountID(), messageDetails.getMessageID(), messageDetails.getType(), messageDetails.getSender(), messageDetails.getRecipientsTo(), messageDetails.getRecipientsCc(), messageDetails.getRecipientsBcc(), messageDetails.getSubject(), messageDetails.getDateTime(), messageDetails.getMessageStatus(), messageDetails.getReplyTo(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getPriority(), messageDetails.getSegmentLengths(), messageDetails.getStorageLocation());
        }
        return messageDetails2;
    }
}

