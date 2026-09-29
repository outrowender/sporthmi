/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;
import de.esolutions.fw.util.commons.Buffer;

public class TunerService$TunerListEntry {
    public final SDSListEntry[] entryVariants;

    public TunerService$TunerListEntry(SDSListEntry[] sDSListEntryArray) {
        this.entryVariants = sDSListEntryArray;
    }

    public String toString() {
        if (this.entryVariants == null) {
            return "entryVariants=[ ]";
        }
        int n = this.entryVariants.length;
        Buffer buffer = new Buffer("entryVariants=[ ");
        for (int i2 = 0; i2 < n - 1; ++i2) {
            buffer.append(this.entryVariants[i2]).append(", ");
        }
        buffer.append(this.entryVariants[n - 1]).append(" ]");
        return buffer.toString();
    }

    public long[] getEntryVariantIds() {
        int n = this.entryVariants.length;
        long[] lArray = new long[n];
        for (int i2 = 0; i2 < n; ++i2) {
            lArray[i2] = this.entryVariants[i2].getId();
        }
        return lArray;
    }

    public String getNameOfEntryVariant(int n) {
        int n2 = this.entryVariants.length;
        if (n >= n2) {
            return "";
        }
        return this.entryVariants[n].getName();
    }

    public String getName() {
        return this.entryVariants[0].getName();
    }
}

