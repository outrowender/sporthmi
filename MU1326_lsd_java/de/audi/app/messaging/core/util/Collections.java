/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.IFormatter;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Collection;
import java.util.Iterator;

public final class Collections {
    public static String toString(Collection collection) {
        return Collections.toString(collection, IFormatter.SIMPLE_FORMATTER);
    }

    public static String toString(Collection collection, IFormatter iFormatter) {
        return Collections.toString(collection, "", ", ", "", iFormatter);
    }

    public static String toMultiLineString(Collection collection) {
        return Collections.toMultiLineString(collection, IFormatter.SIMPLE_FORMATTER);
    }

    public static String toMultiLineString(Collection collection, IFormatter iFormatter) {
        return Collections.toString(collection, "\n\t", ",", "\n", iFormatter);
    }

    private static String toString(Collection collection, String string, String string2, String string3, IFormatter iFormatter) {
        String string4 = String.valueOf((Object)null);
        if (collection != null) {
            Buffer buffer = new Buffer();
            buffer.append('(');
            if (!collection.isEmpty()) {
                Iterator iterator = collection.iterator();
                while (iterator.hasNext()) {
                    buffer.append(string);
                    buffer.append(iFormatter.format(iterator.next()));
                    if (iterator.hasNext()) {
                        buffer.append(string2);
                        continue;
                    }
                    buffer.append(string3);
                }
            }
            buffer.append(')');
            string4 = buffer.toString();
        }
        return string4;
    }

    public static int[] toPrimitiveArray(Collection collection) {
        int[] nArray = null;
        if (collection != null) {
            nArray = new int[collection.size()];
            int n = 0;
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                nArray[n++] = (Integer)iterator.next();
            }
        }
        return nArray;
    }
}

