/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.phone.ITelServiceListener;

public interface ITelServiceSDSListener
extends ITelServiceListener {
    public void unlockSIMResponse(int var1);

    public void setMailboxResponse(int var1);

    public static class TelFavoriteSDSListEntry
    extends SDSListEntry {
        private final String number;

        public TelFavoriteSDSListEntry(String string, long l, String string2) {
            super(string, l);
            this.number = string2;
        }

        public String getNumber() {
            return this.number;
        }
    }
}

