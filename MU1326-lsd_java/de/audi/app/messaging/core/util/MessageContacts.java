/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.RecipientList;

public final class MessageContacts {
    public static String toString(MatchedAddress matchedAddress) {
        String string = "null";
        if (matchedAddress != null) {
            String string2 = matchedAddress.getName().trim();
            String string3 = matchedAddress.getAddress();
            boolean bl = !Strings.isNullOrEmpty(string2);
            Buffer buffer = new Buffer(string2.length() + string3.length() + 3);
            if (bl) {
                buffer.append(string2);
                buffer.append(' ');
                buffer.append('(');
            }
            buffer.append(string3);
            if (bl) {
                buffer.append(')');
            }
            string = buffer.toString();
        }
        return string;
    }

    public static MatchedAddress toMatchedAddress(String string) {
        String string2 = "";
        String string3 = "";
        int n = string.indexOf(40);
        int n2 = -1;
        if (n != -1) {
            n2 = string.indexOf(41, n + 1);
        }
        if (n >= n2) {
            string2 = string.trim();
        } else {
            string3 = string.substring(0, n).trim();
            string2 = string.substring(n + 1, n2).trim();
        }
        return new MatchedAddress(string2, string3, 0L, null);
    }

    public static MatchedAddress getFirstRecipient(MessageDetails messageDetails) {
        MatchedAddress[] matchedAddressArray;
        MatchedAddress matchedAddress = null;
        if (messageDetails != null && (matchedAddressArray = messageDetails.getRecipientsTo()) != null && matchedAddressArray.length > 0) {
            matchedAddress = matchedAddressArray[0];
        }
        return matchedAddress;
    }

    public static boolean hasPrimaryContact(MessageDetails messageDetails) {
        return MessageContacts.getPrimaryContact(messageDetails) != null;
    }

    public static MatchedAddress getPrimaryContact(MessageDetails messageDetails) {
        MatchedAddress matchedAddress = null;
        if (messageDetails != null) {
            matchedAddress = Messages.isOutbound(messageDetails) ? MessageContacts.getFirstRecipient(messageDetails) : messageDetails.getSender();
        }
        return matchedAddress;
    }

    public static String getPrimaryContactText(MessageListEntry messageListEntry) {
        String string = "";
        if (messageListEntry == null) {
            return string;
        }
        MatchedAddress matchedAddress = messageListEntry.getMatchedAddress();
        String string2 = matchedAddress.getName();
        string = !Strings.isNullOrEmpty(string2) ? string2 : matchedAddress.getAddress();
        return string;
    }

    public static String getPrimaryContactInfo(MessageListEntry messageListEntry, ITextLookup iTextLookup) {
        String string = MessageContacts.getPrimaryContactText(messageListEntry);
        if (Strings.isNullOrEmpty(string)) {
            string = Messages.isOutbound(messageListEntry) ? iTextLookup.getRecipientNone() : iTextLookup.getSenderNone();
        }
        return string;
    }

    public static String[] getRawAddresses(List list) {
        String[] stringArray = new String[list.size()];
        Iterator iterator = list.iterator();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            stringArray[i2] = ((MatchedAddress)iterator.next()).getAddress();
        }
        return stringArray;
    }

    public static String[] getRawAddresses(MatchedAddress[] matchedAddressArray) {
        return MessageContacts.getRawAddresses(Arrays.asList(matchedAddressArray));
    }

    public static MatchedAddress[] toArray(Collection collection) {
        Object[] objectArray = null;
        if (collection != null) {
            objectArray = new MatchedAddress[collection.size()];
            objectArray = (MatchedAddress[])collection.toArray(objectArray);
        }
        return objectArray;
    }

    public static int getRecipientCount(RecipientList recipientList) {
        int n = 0;
        if (recipientList != null) {
            if (recipientList.getTo() != null) {
                n += recipientList.getTo().length;
            }
            if (recipientList.getCc() != null) {
                n += recipientList.getCc().length;
            }
            if (recipientList.getBcc() != null) {
                n += recipientList.getBcc().length;
            }
        }
        return n;
    }
}

