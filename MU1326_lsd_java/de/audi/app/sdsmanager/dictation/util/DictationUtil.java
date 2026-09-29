/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.util;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Collection;
import java.util.Iterator;

public final class DictationUtil {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static String arrayToString(Object[] objectArray, boolean bl) {
        if (objectArray == null) {
            return "null";
        }
        Buffer buffer = new Buffer();
        buffer.append('[');
        if (objectArray.length > 0) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (bl) {
                    buffer.append('\n');
                    buffer.append('\t');
                    buffer.append('[');
                    buffer.append(i2);
                    buffer.append("] = ");
                }
                buffer.append(objectArray[i2]);
                if (i2 < objectArray.length - 1) {
                    buffer.append(", ");
                    continue;
                }
                if (!bl) continue;
                buffer.append('\n');
            }
        }
        buffer.append(']');
        return buffer.toString();
    }

    public static String collectionToString(Collection collection) {
        String string = "null";
        if (collection != null) {
            Buffer buffer = new Buffer();
            buffer.append('(');
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                buffer.append(iterator.next());
                if (!iterator.hasNext()) continue;
                buffer.append(", ");
            }
            buffer.append(')');
            string = buffer.toString();
        }
        return string;
    }

    public static String getShortClassName(Class clazz) {
        String string;
        int n = 0;
        Package package_ = clazz.getPackage();
        if (package_ != null && !DictationUtil.isNullOrEmpty(string = package_.getName())) {
            n = string.length() + 1;
        }
        string = clazz.getName();
        String string2 = null;
        string2 = n == 0 ? string : string.substring(n, string.length());
        return string2;
    }

    public static void logException(LogChannel logChannel, Throwable throwable, String string) {
        logChannel.log(10000, "%1 An exception occurred: ", (Object)string, throwable);
    }

    public static void logNullParameter(LogChannel logChannel, String string) {
        logChannel.log(10000, "%1 An illegal null parameter has been passed.", (Object)string);
    }
}

