/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.grammar;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.interapp.SDSListEntry;

public class DynamicSlotContent {
    static final String DESCR_UNK;
    public static final byte SLOT_CONTENT_NEW;
    public static final byte SLOT_CONTENT_NEW_AND_TO_BE_LOADED;
    static final byte SLOT_CONTENT_OLD;
    private static final long DUMMY_ID;
    private final String description;
    private final SDSListEntry[] slotEntries;
    private byte status = 0;

    public DynamicSlotContent(String string, SDSListEntry[] sDSListEntryArray, byte by) {
        this.description = string != null ? string : "UNK";
        this.slotEntries = sDSListEntryArray == null ? new SDSListEntry[]{} : sDSListEntryArray;
        this.status = by;
    }

    public DynamicSlotContent(String string, String[] stringArray, byte by) {
        this.description = string != null ? string : "UNK";
        this.status = by;
        if (SDSUtils.isEmpty(stringArray)) {
            this.slotEntries = new SDSListEntry[0];
            return;
        }
        int n = stringArray.length;
        this.slotEntries = new SDSListEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            this.slotEntries[i2] = new SDSListEntry(stringArray[i2], 0L);
        }
    }

    public SDSListEntry[] getEntries() {
        return this.slotEntries;
    }

    String getDescription() {
        return this.description;
    }

    void setStatus(byte by) {
        this.status = by;
    }

    byte getStatus() {
        return this.status;
    }

    public String toString() {
        return SDSUtils.toString((Object[])this.slotEntries, false);
    }
}

