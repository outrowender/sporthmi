/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.IFormatter;
import de.audi.app.messaging.core.util.Maps$ElementFormatter;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public final class Maps {
    private static final IFormatter DEFAULT_ELEMENT_FORMATTER = new Maps$ElementFormatter(IFormatter.SIMPLE_FORMATTER, IFormatter.SIMPLE_FORMATTER);

    public static String toString(Map map) {
        return Maps.toString(map, DEFAULT_ELEMENT_FORMATTER);
    }

    public static String toString(Map map, IFormatter iFormatter) {
        return Maps.toString(map, "", ", ", "", iFormatter);
    }

    public static String toMultiLineString(Map map) {
        return Maps.toMultiLineString(map, DEFAULT_ELEMENT_FORMATTER);
    }

    public static String toMultiLineString(Map map, IFormatter iFormatter) {
        return Maps.toString(map, "\n\t", ",", "\n", iFormatter);
    }

    private static String toString(Map map, String string, String string2, String string3, IFormatter iFormatter) {
        String string4 = String.valueOf((Object)null);
        if (map != null) {
            Buffer buffer = new Buffer();
            buffer.append('(');
            if (!map.isEmpty()) {
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map$Entry map$Entry = (Map$Entry)iterator.next();
                    buffer.append(string);
                    buffer.append(iFormatter.format(map$Entry));
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

    public static int getInitialHashMapCapacity(int n, int n2) {
        return n * 100 / n2 + 1;
    }
}

