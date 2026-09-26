/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.util.Strings;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public final class TemplateProcessor {
    public static String replaceVariables(String string, Map map) {
        String string2 = string;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string3 = (String)map$Entry.getKey();
            String string4 = (String)map$Entry.getValue();
            string2 = TemplateProcessor.replaceFirst(string2, string3, string4);
        }
        return string2;
    }

    private static String replaceFirst(String string, String string2, String string3) {
        int n;
        String string4 = string;
        if (!Strings.isNullOrEmpty(string) && !Strings.isNullOrEmpty(string2) && (n = string.indexOf(string2)) != -1) {
            String string5 = string3 == null ? "" : string3;
            int n2 = string.length() - string2.length() + string5.length();
            Buffer buffer = new Buffer(n2);
            buffer.append(string);
            buffer.delete(n, n + string2.length());
            buffer.insert(n, string5);
            string4 = buffer.toString();
        }
        return string4;
    }
}

