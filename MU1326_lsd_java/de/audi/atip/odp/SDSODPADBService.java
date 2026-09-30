/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

public interface SDSODPADBService {
    public void openEntryDetails(long var1);

    public void getEntry(long var1);

    public static class ADBEntry {
        public long entryID;
        public String[] telNumbers;
        public String combinedName;

        public ADBEntry(long l, String string, String[] stringArray) {
            this.entryID = l;
            this.combinedName = string;
            this.telNumbers = stringArray;
        }

        public long getEntryID() {
            return this.entryID;
        }

        public String[] getTelNumbers() {
            return this.telNumbers;
        }

        public String getCombinedName() {
            return this.combinedName;
        }
    }
}

