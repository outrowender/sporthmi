/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.tts;

import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;

public class AddressBookTTSUtils {
    public static String getSSMLMessage(String string, LogChannel logChannel) {
        Buffer buffer = new Buffer();
        if (!ADBUtils.isEmpty(string)) {
            AddressBookTTSUtils.openTag(buffer, "say-as", "interpret-as", "name");
            AddressBookTTSUtils.appendText(buffer, string);
            AddressBookTTSUtils.closeTag(buffer, "say-as");
        }
        logChannel.log(-2137614336, "AddressBookTTSUtils#getSSMLMessage(): returning ssmlMessage: %1", (Object)buffer);
        return buffer.toString();
    }

    private static void openTag(Buffer buffer, String string, String string2, String string3) {
        buffer.append('<');
        buffer.append(string);
        if (string2 != null && !"".equals(string2)) {
            buffer.append(' ');
            buffer.append(string2);
            buffer.append("=\"");
            if (string3 != null) {
                buffer.append(string3);
            }
            buffer.append('\"');
        }
        buffer.append('>');
    }

    private static void appendText(Buffer buffer, String string) {
        buffer.append(TTSStringUtil.escapeXml(string));
    }

    private static void closeTag(Buffer buffer, String string) {
        buffer.append("</");
        buffer.append(string);
        buffer.append('>');
    }
}

