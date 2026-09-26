/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.extracteditems;

import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.messaging.ExtractedItem;

public final class ExtractedItems {
    public static boolean addIfUniqueValue(ExtractedItem extractedItem, List list, boolean bl) {
        String string = ExtractedItems.normalizeItemValue(extractedItem.getValue(), bl);
        boolean bl2 = false;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ExtractedItem extractedItem2 = (ExtractedItem)iterator.next();
            String string2 = ExtractedItems.normalizeItemValue(extractedItem2.getValue(), bl);
            if ((string != null || string2 != null) && (string == null || !string.equals(string2))) continue;
            bl2 = true;
            break;
        }
        if (!bl2) {
            list.add(extractedItem);
        }
        return !bl2;
    }

    private static String normalizeItemValue(String string, boolean bl) {
        String string2 = string;
        if (string != null && bl) {
            string2 = string.toLowerCase();
        }
        return string2;
    }
}

