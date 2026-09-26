/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.Markup;
import de.audi.app.messaging.core.readout.Markup$Attribute;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.core.util.Times;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;

public final class EppMarkup {
    private static final String TAG_NAME_TYPE;
    private static final String TYPE_SMS;
    private static final String TYPE_EMAIL;
    private static final String TYPE_EMAIL_BODY_ONLY;
    private static final String TAG_NAME_FROM;
    private static final String TAG_NAME_TO;
    private static final String TAG_NAME_CC;
    private static final String TAG_NAME_BCC;
    private static final String TAG_NAME_DATE;
    private static final String TAG_NAME_TIME;
    private static final String TAG_NAME_SUBJECT;
    private static final String TAG_NAME_BODY;
    private static final String TAG_NAME_CONTACT;
    private static final String TAG_NAME_ADDRESS;
    private static final String TAG_NAME_NAME;
    private static final String ATTR_NAME_ENTRY_ID;
    private static final boolean FORCE_TOP_LEVEL_TAGS;

    public static String getText(MessageDetails messageDetails, boolean bl) {
        Buffer buffer = new Buffer(256);
        EppMarkup.appendTypeNode(buffer, messageDetails, bl);
        EppMarkup.appendFromNode(buffer, messageDetails);
        EppMarkup.appendToNode(buffer, messageDetails);
        EppMarkup.appendCcNode(buffer, messageDetails);
        EppMarkup.appendBccNode(buffer, messageDetails);
        EppMarkup.appendDateNode(buffer, messageDetails);
        EppMarkup.appendTimeNode(buffer, messageDetails);
        EppMarkup.appendSubjectNode(buffer, messageDetails);
        EppMarkup.appendBodyNode(buffer, messageDetails);
        String string = buffer.toString();
        return Markup.ensureDsiMaxByteLength(string, "body");
    }

    private static void appendTypeNode(Buffer buffer, MessageDetails messageDetails, boolean bl) {
        Markup.openTag(buffer, "type", null);
        String string = Messages.isSms(messageDetails) ? "1" : (bl ? "3" : "2");
        Markup.appendText(buffer, string);
        Markup.closeTag(buffer, "type");
    }

    private static void appendFromNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress matchedAddress = messageDetails != null ? messageDetails.getSender() : null;
        String string = null;
        String string2 = null;
        if (matchedAddress != null) {
            string = matchedAddress.getName();
            string2 = matchedAddress.getAddress();
        }
        boolean bl2 = bl = !Strings.isNullOrEmpty(string) || !Strings.isNullOrEmpty(string2);
        if (!bl) {
            // empty if block
        }
        Markup.openTag(buffer, "from", null);
        EppMarkup.appendContactNodes(buffer, new MatchedAddress[]{matchedAddress});
        Markup.closeTag(buffer, "from");
    }

    private static void appendToNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress[] matchedAddressArray = messageDetails != null ? messageDetails.getRecipientsTo() : new MatchedAddress[]{};
        boolean bl2 = bl = Messages.isEmail(messageDetails) && matchedAddressArray.length > 0;
        if (bl) {
            Markup.openTag(buffer, "to", null);
            EppMarkup.appendContactNodes(buffer, matchedAddressArray);
            Markup.closeTag(buffer, "to");
        } else {
            Markup.openTag(buffer, "to", null);
            Markup.closeTag(buffer, "to");
        }
    }

    private static void appendCcNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress[] matchedAddressArray = messageDetails != null ? messageDetails.getRecipientsCc() : new MatchedAddress[]{};
        boolean bl2 = bl = Messages.isEmail(messageDetails) && matchedAddressArray.length > 0;
        if (bl) {
            Markup.openTag(buffer, "cc", null);
            EppMarkup.appendContactNodes(buffer, matchedAddressArray);
            Markup.closeTag(buffer, "cc");
        } else {
            Markup.openTag(buffer, "cc", null);
            Markup.closeTag(buffer, "cc");
        }
    }

    private static void appendBccNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress[] matchedAddressArray = messageDetails != null ? messageDetails.getRecipientsBcc() : new MatchedAddress[]{};
        boolean bl2 = bl = Messages.isEmail(messageDetails) && matchedAddressArray.length > 0;
        if (bl) {
            Markup.openTag(buffer, "bcc", null);
            EppMarkup.appendContactNodes(buffer, matchedAddressArray);
            Markup.closeTag(buffer, "bcc");
        } else {
            Markup.openTag(buffer, "bcc", null);
            Markup.closeTag(buffer, "bcc");
        }
    }

    private static void appendDateNode(Buffer buffer, MessageDetails messageDetails) {
        Markup.openTag(buffer, "date", null);
        if (messageDetails != null) {
            Markup.appendText(buffer, Times.formatDate(messageDetails.getDateTime()));
        }
        Markup.closeTag(buffer, "date");
    }

    private static void appendTimeNode(Buffer buffer, MessageDetails messageDetails) {
        Markup.openTag(buffer, "time", null);
        if (messageDetails != null) {
            Markup.appendText(buffer, Times.formatTime(messageDetails.getDateTime()));
        }
        Markup.closeTag(buffer, "time");
    }

    private static void appendSubjectNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        String string = messageDetails != null ? messageDetails.getSubject() : null;
        boolean bl2 = bl = Messages.isEmail(messageDetails) && !Strings.isNullOrEmpty(string);
        if (bl) {
            Markup.openTag(buffer, "subject", null);
            Markup.appendText(buffer, messageDetails.getSubject());
            Markup.closeTag(buffer, "subject");
        } else {
            Markup.openTag(buffer, "subject", null);
            Markup.closeTag(buffer, "subject");
        }
    }

    private static void appendBodyNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        String string = messageDetails != null ? messageDetails.getBody() : null;
        boolean bl2 = bl = !Strings.isNullOrEmpty(string);
        if (bl) {
            Markup.openTag(buffer, "body", null);
            Markup.appendText(buffer, string);
            Markup.closeTag(buffer, "body");
        } else {
            Markup.openTag(buffer, "body", null);
            Markup.closeTag(buffer, "body");
        }
    }

    private static void appendContactNodes(Buffer buffer, MatchedAddress[] matchedAddressArray) {
        if (matchedAddressArray != null) {
            for (int i2 = 0; i2 < matchedAddressArray.length; ++i2) {
                MatchedAddress matchedAddress = matchedAddressArray[i2];
                Markup.openTag(buffer, "contact", null);
                if (matchedAddress != null && !Strings.isNullOrEmpty(matchedAddress.getName())) {
                    EppMarkup.appendNameNode(buffer, matchedAddress);
                } else {
                    EppMarkup.appendAddressNode(buffer, matchedAddress);
                }
                Markup.closeTag(buffer, "contact");
            }
        }
    }

    private static void appendAddressNode(Buffer buffer, MatchedAddress matchedAddress) {
        Markup.openTag(buffer, "address", null);
        if (matchedAddress != null) {
            Markup.appendText(buffer, matchedAddress.getAddress());
        }
        Markup.closeTag(buffer, "address");
    }

    private static void appendNameNode(Buffer buffer, MatchedAddress matchedAddress) {
        Markup$Attribute markup$Attribute = new Markup$Attribute("entryID", String.valueOf(matchedAddress.getAdbEntryID()));
        Markup$Attribute[] markup$AttributeArray = new Markup$Attribute[]{markup$Attribute};
        Markup.openTag(buffer, "name", markup$AttributeArray);
        Markup.appendText(buffer, matchedAddress.getName());
        Markup.closeTag(buffer, "name");
    }
}

