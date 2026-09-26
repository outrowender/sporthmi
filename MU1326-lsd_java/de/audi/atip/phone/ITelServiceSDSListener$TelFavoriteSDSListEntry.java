/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.interapp.SDSListEntry;

public class ITelServiceSDSListener$TelFavoriteSDSListEntry
extends SDSListEntry {
    private final String number;

    public ITelServiceSDSListener$TelFavoriteSDSListEntry(String string, long l, String string2) {
        super(string, l);
        this.number = string2;
    }

    public String getNumber() {
        return this.number;
    }
}

