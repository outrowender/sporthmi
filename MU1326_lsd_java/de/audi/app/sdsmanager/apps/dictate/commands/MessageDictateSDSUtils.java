/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.atip.log.LogChannel;
import java.util.LinkedList;

class MessageDictateSDSUtils {
    static final int MSG_TYPE_NONE = 0;
    static final int MSG_TYPE_SMS = 1;
    static final int MSG_TYPE_MAIL = 2;
    static final int MSG_TYPE_SMS_REPLY = 3;
    static final int MSG_TYPE_SMS_FORWARD = 4;
    static final int MSG_TYPE_ANY = 5;
    static final int MSG_TYPE_SMS_EDIT = 6;
    static final int MSG_TYPE_SMS_REPLY_ALL = 7;
    static final int MSG_TYPE_MAIL_EDIT = 8;
    static final int MSG_TYPE_MAIL_REPLY = 9;
    static final int MSG_TYPE_MAIL_FORWARD = 10;
    static final int MSG_TYPE_MAIL_REPLY_ALL = 11;
    static final int[][] MESSAGE_PARAMETER_2_TYPE_AND_COMPOSITION_MODE = new int[][]{{2, 2, 0}, {1, 1, 0}, {5, 0, 0}, {3, 1, 3}, {7, 1, 4}, {4, 1, 5}, {6, 1, 1}, {8, 2, 1}, {9, 2, 3}, {11, 2, 4}, {10, 2, 5}};

    MessageDictateSDSUtils() {
    }

    private static boolean isSentenceDelimiter(String string) {
        return ".".equals(string) || ":".equals(string) || ";".equals(string) || "!".equals(string) || "?".equals(string);
    }

    public static String getSelectedWord(int n, int n2, LinkedList linkedList, LogChannel logChannel) {
        if (linkedList == null || linkedList.size() <= n) {
            logChannel.log(100000, "SDSUtils#getSelectedWord: Text too short, returning null!");
            return null;
        }
        String[] stringArray = (String[])linkedList.get(n);
        if (stringArray == null || stringArray.length <= n2) {
            logChannel.log(100000, "SDSUtils#getSelectedWord: Words too short, returning null!");
            return null;
        }
        return stringArray[n2];
    }

    static String getSelectedSentence(int n, LinkedList linkedList, LogChannel logChannel) {
        String[] stringArray;
        int n2;
        StringBuffer stringBuffer = new StringBuffer();
        for (n2 = n; n2 >= 0; --n2) {
            String[] stringArray2 = (String[])linkedList.get(n2);
            if (stringArray2 == null || stringArray2.length == 0) {
                logChannel.log(100000, "SMSSDSUtils#getSelectedSentence: Skipping empty word at pos. #%1!", (long)n2);
                continue;
            }
            stringArray = stringArray2[0];
            if (MessageDictateSDSUtils.isSentenceDelimiter((String)stringArray)) {
                logChannel.log(10000000, "SMSSDSUtils#getSelectedSentence: Found starting delimiter '%1' at pos. #%2!", (Object)stringArray, (long)n2);
                break;
            }
            stringBuffer.insert(0, (String)stringArray);
        }
        n2 = linkedList.size();
        for (int i2 = n + 1; i2 < n2; ++i2) {
            stringArray = (String[])linkedList.get(i2);
            if (stringArray == null || stringArray.length == 0) {
                logChannel.log(100000, "SMSSDSUtils#getSelectedSentence: Skipping empty word at pos. #%1!", (long)i2);
                continue;
            }
            String string = stringArray[0];
            if (MessageDictateSDSUtils.isSentenceDelimiter(string)) {
                logChannel.log(10000000, "SMSSDSUtils#getSelectedSentence: Found ending delimiter '%1' at pos. #%2!", (Object)string, (long)i2);
                stringBuffer.append(string);
                break;
            }
            stringBuffer.append(string);
        }
        return stringBuffer.toString().trim();
    }
}

