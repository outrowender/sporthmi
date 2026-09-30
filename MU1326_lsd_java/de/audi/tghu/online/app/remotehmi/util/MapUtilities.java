/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.util;

import java.util.Iterator;
import java.util.Map;

public final class MapUtilities {
    private MapUtilities() {
    }

    public static String getDescriptionOfFirstValue(Map map, int n) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer n2 = (Integer)entry.getValue();
            if (n2 != n) continue;
            String string = (String)entry.getKey();
            return string == null ? "NULL" : string;
        }
        return "VALUE_NOT_FOUND";
    }
}

