/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.organizer.AdbEntry;

public interface ADBHMIAppServiceListener {
    public void responseParseVCards(int var1, AdbEntry[] var2);

    public void responseInsertEntry(int var1);
}

