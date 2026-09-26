/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.organizer.AdbEntry;

public interface ADBHMIAppServiceListener {
    default public void responseParseVCards(int n, AdbEntry[] adbEntryArray) {
    }

    default public void responseInsertEntry(int n) {
    }
}

