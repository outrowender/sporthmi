/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import org.dsi.ifc.messaging.ListEntry;

public final class ListEntries {
    public static boolean isFolder(ListEntry listEntry) {
        return listEntry.getType() == 1;
    }

    public static boolean isMessage(ListEntry listEntry) {
        return !ListEntries.isFolder(listEntry);
    }
}

