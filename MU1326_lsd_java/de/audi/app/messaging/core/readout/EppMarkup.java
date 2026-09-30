/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.Markup;
import de.audi.app.messaging.core.util.Messages;
import de.audi.app.messaging.core.util.Strings;
import de.audi.app.messaging.core.util.Times;
import de.esolutions.fw.util.commons.Buffer;
import java.io.UnsupportedEncodingException;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;

public final class EppMarkup {
    private static final String TAG_NAME_TYPE = "type";
    private static final String TYPE_SMS = "1";
    private static final String TYPE_EMAIL = "2";
    private static final String TYPE_EMAIL_BODY_ONLY = "3";
    private static final String TAG_NAME_FROM = "from";
    private static final String TAG_NAME_TO = "to";
    private static final String TAG_NAME_CC = "cc";
    private static final String TAG_NAME_BCC = "bcc";
    private static final String TAG_NAME_DATE = "date";
    private static final String TAG_NAME_TIME = "time";
    private static final String TAG_NAME_SUBJECT = "subject";
    private static final String TAG_NAME_BODY = "body";
    private static final String TAG_NAME_CONTACT = "contact";
    private static final String TAG_NAME_ADDRESS = "address";
    private static final String TAG_NAME_NAME = "name";
    private static final String ATTR_NAME_ENTRY_ID = "entryID";
    private static final boolean FORCE_TOP_LEVEL_TAGS = true;

    public static String getText(MessageDetails messageDetails, boolean bl) throws IllegalArgumentException, UnsupportedEncodingException {
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
        return Markup.ensureDsiMaxByteLength(string, TAG_NAME_BODY);
    }

    private static void appendTypeNode(Buffer buffer, MessageDetails messageDetails, boolean bl) {
        Markup.openTag(buffer, TAG_NAME_TYPE, null);
        String string = Messages.isSms(messageDetails) ? TYPE_SMS : (bl ? TYPE_EMAIL_BODY_ONLY : TYPE_EMAIL);
        Markup.appendText(buffer, string);
        Markup.closeTag(buffer, TAG_NAME_TYPE);
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
        Markup.openTag(buffer, TAG_NAME_FROM, null);
        EppMarkup.appendContactNodes(buffer, new MatchedAddress[]{matchedAddress});
        Markup.closeTag(buffer, TAG_NAME_FROM);
    }

    private static void appendToNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress[] matchedAddressArray = messageDetails != null ? messageDetails.getRecipientsTo() : new MatchedAddress[]{};
        boolean bl2 = bl = Messages.isEmail(messageDetails) && matchedAddressArray.length > 0;
        if (bl) {
            Markup.openTag(buffer, TAG_NAME_TO, null);
            EppMarkup.appendContactNodes(buffer, matchedAddressArray);
            Markup.closeTag(buffer, TAG_NAME_TO);
        } else {
            Markup.openTag(buffer, TAG_NAME_TO, null);
            Markup.closeTag(buffer, TAG_NAME_TO);
        }
    }

    private static void appendCcNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress[] matchedAddressArray = messageDetails != null ? messageDetails.getRecipientsCc() : new MatchedAddress[]{};
        boolean bl2 = bl = Messages.isEmail(messageDetails) && matchedAddressArray.length > 0;
        if (bl) {
            Markup.openTag(buffer, TAG_NAME_CC, null);
            EppMarkup.appendContactNodes(buffer, matchedAddressArray);
            Markup.closeTag(buffer, TAG_NAME_CC);
        } else {
            Markup.openTag(buffer, TAG_NAME_CC, null);
            Markup.closeTag(buffer, TAG_NAME_CC);
        }
    }

    private static void appendBccNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        MatchedAddress[] matchedAddressArray = messageDetails != null ? messageDetails.getRecipientsBcc() : new MatchedAddress[]{};
        boolean bl2 = bl = Messages.isEmail(messageDetails) && matchedAddressArray.length > 0;
        if (bl) {
            Markup.openTag(buffer, TAG_NAME_BCC, null);
            EppMarkup.appendContactNodes(buffer, matchedAddressArray);
            Markup.closeTag(buffer, TAG_NAME_BCC);
        } else {
            Markup.openTag(buffer, TAG_NAME_BCC, null);
            Markup.closeTag(buffer, TAG_NAME_BCC);
        }
    }

    private static void appendDateNode(Buffer buffer, MessageDetails messageDetails) {
        Markup.openTag(buffer, TAG_NAME_DATE, null);
        if (messageDetails != null) {
            Markup.appendText(buffer, Times.formatDate(messageDetails.getDateTime()));
        }
        Markup.closeTag(buffer, TAG_NAME_DATE);
    }

    private static void appendTimeNode(Buffer buffer, MessageDetails messageDetails) {
        Markup.openTag(buffer, TAG_NAME_TIME, null);
        if (messageDetails != null) {
            Markup.appendText(buffer, Times.formatTime(messageDetails.getDateTime()));
        }
        Markup.closeTag(buffer, TAG_NAME_TIME);
    }

    private static void appendSubjectNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        String string = messageDetails != null ? messageDetails.getSubject() : null;
        boolean bl2 = bl = Messages.isEmail(messageDetails) && !Strings.isNullOrEmpty(string);
        if (bl) {
            Markup.openTag(buffer, TAG_NAME_SUBJECT, null);
            Markup.appendText(buffer, messageDetails.getSubject());
            Markup.closeTag(buffer, TAG_NAME_SUBJECT);
        } else {
            Markup.openTag(buffer, TAG_NAME_SUBJECT, null);
            Markup.closeTag(buffer, TAG_NAME_SUBJECT);
        }
    }

    private static void appendBodyNode(Buffer buffer, MessageDetails messageDetails) {
        boolean bl;
        String string = messageDetails != null ? messageDetails.getBody() : null;
        boolean bl2 = bl = !Strings.isNullOrEmpty(string);
        if (bl) {
            Markup.openTag(buffer, TAG_NAME_BODY, null);
            Markup.appendText(buffer, string);
            Markup.closeTag(buffer, TAG_NAME_BODY);
        } else {
            Markup.openTag(buffer, TAG_NAME_BODY, null);
            Markup.closeTag(buffer, TAG_NAME_BODY);
        }
    }

    private static void appendContactNodes(Buffer buffer, MatchedAddress[] matchedAddressArray) {
        if (matchedAddressArray != null) {
            for (int i2 = 0; i2 < matchedAddressArray.length; ++i2) {
                MatchedAddress matchedAddress = matchedAddressArray[i2];
                Markup.openTag(buffer, TAG_NAME_CONTACT, null);
                if (matchedAddress != null && !Strings.isNullOrEmpty(matchedAddress.getName())) {
                    EppMarkup.appendNameNode(buffer, matchedAddress);
                } else {
                    EppMarkup.appendAddressNode(buffer, matchedAddress);
                }
                Markup.closeTag(buffer, TAG_NAME_CONTACT);
            }
        }
    }

    private static void appendAddressNode(Buffer buffer, MatchedAddress matchedAddress) {
        Markup.openTag(buffer, TAG_NAME_ADDRESS, null);
        if (matchedAddress != null) {
            Markup.appendText(buffer, matchedAddress.getAddress());
        }
        Markup.closeTag(buffer, TAG_NAME_ADDRESS);
    }

    private static void appendNameNode(Buffer buffer, MatchedAddress matchedAddress) {
        Markup.Attribute attribute = new Markup.Attribute(ATTR_NAME_ENTRY_ID, String.valueOf(matchedAddress.getAdbEntryID()));
        Markup.Attribute[] attributeArray = new Markup.Attribute[]{attribute};
        Markup.openTag(buffer, TAG_NAME_NAME, attributeArray);
        Markup.appendText(buffer, matchedAddress.getName());
        Markup.closeTag(buffer, TAG_NAME_NAME);
    }
}

