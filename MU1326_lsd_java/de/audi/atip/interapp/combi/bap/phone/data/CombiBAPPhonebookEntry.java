/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPPhonebookEntry
implements CombiBAPArrayElement {
    private long entryId;
    private int entryPosition;
    private String pbName;
    private int storage;
    private int telNumberQuantity;
    private String pictureURL;
    private int pictureID;
    private CombiBAPPhonebookEntryDetails[] details;

    public CombiBAPPhonebookEntry(long l, int n, String string, int n2, int n3) {
        this.entryId = l;
        this.entryPosition = n;
        this.pbName = string;
        this.storage = n2;
        this.telNumberQuantity = n3;
    }

    public CombiBAPPhonebookEntry(long l, int n, String string, int n2, int n3, String string2, int n4) {
        this.entryId = l;
        this.entryPosition = n;
        this.pbName = string;
        this.storage = n2;
        this.telNumberQuantity = n3;
        this.pictureURL = string2;
        this.pictureID = n4;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public int getPosID() {
        return this.entryPosition + 1;
    }

    public int getEntryPosition() {
        return this.entryPosition;
    }

    public String getPbName() {
        return this.pbName;
    }

    public int getStorage() {
        return this.storage;
    }

    public int getTelNumberQuantity() {
        return this.telNumberQuantity;
    }

    public String getPictureURL() {
        return this.pictureURL;
    }

    public int getPictureID() {
        return this.pictureID;
    }

    public void setDetails(CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray) {
        this.details = combiBAPPhonebookEntryDetailsArray;
    }

    public CombiBAPPhonebookEntryDetails[] getDetails() {
        return this.details;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPPhonebookEntry {entryID=");
        buffer.append(this.entryId);
        buffer.append(", posID=");
        buffer.append(this.getPosID());
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.getPosID()));
        buffer.append("), entryPosition=");
        buffer.append(this.entryPosition);
        buffer.append(", pbName=");
        buffer.append(this.pbName);
        buffer.append(", storage=");
        buffer.append(this.storage);
        buffer.append(", telNumberQuantity=");
        buffer.append(this.telNumberQuantity);
        buffer.append(", pictureURL=");
        buffer.append(this.pictureURL);
        buffer.append(", pictureID=");
        buffer.append(this.pictureID);
        buffer.append(", details=");
        if (this.details == null) {
            buffer.append("null");
        } else {
            for (int i2 = 0; i2 < this.details.length; ++i2) {
                buffer.append("\n");
                buffer.append(this.details[i2]);
            }
        }
        buffer.append("}");
        return buffer.toString();
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPPhonebookEntry) {
            CombiBAPPhonebookEntry combiBAPPhonebookEntry = (CombiBAPPhonebookEntry)combiBAPArrayElement;
            return this.entryId == combiBAPPhonebookEntry.entryId && this.entryPosition == combiBAPPhonebookEntry.entryPosition && this.pbName.equals(combiBAPPhonebookEntry.pbName) && this.storage == combiBAPPhonebookEntry.storage && this.telNumberQuantity == combiBAPPhonebookEntry.telNumberQuantity && (this.pictureURL == null && combiBAPPhonebookEntry.pictureURL == null || this.pictureURL != null && this.pictureURL.equals(combiBAPPhonebookEntry.pictureURL)) && this.pictureID == combiBAPPhonebookEntry.pictureID && this.detailsHasSameContent(combiBAPPhonebookEntry.details);
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPPhonebookEntry) {
            CombiBAPPhonebookEntry combiBAPPhonebookEntry = (CombiBAPPhonebookEntry)combiBAPArrayElement;
            n = CombiBAPPhonebookEntry.getRecordAddress(this.getPosID() != combiBAPPhonebookEntry.getPosID(), !this.pbName.equals(combiBAPPhonebookEntry.pbName), this.storage != combiBAPPhonebookEntry.storage, false, this.telNumberQuantity != combiBAPPhonebookEntry.telNumberQuantity, this.detailsHasSameContent(combiBAPPhonebookEntry.getDetails()));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        int n = 0;
        if (bl) {
            ++n;
        }
        if (bl2) {
            ++n;
        }
        if (bl3) {
            ++n;
        }
        if (bl4) {
            ++n;
        }
        if (bl5) {
            ++n;
        }
        if (bl6) {
            ++n;
        }
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n == 1 && bl6 ? 2 : (!bl && !bl2 && !bl3 ? 4 : (!bl && !bl6 ? 1 : 0))));
        return n2;
    }

    private boolean detailsHasSameContent(CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray) {
        if (this.details == null && combiBAPPhonebookEntryDetailsArray == null) {
            return true;
        }
        if (this.details == null || combiBAPPhonebookEntryDetailsArray == null) {
            return false;
        }
        if (this.details.length != combiBAPPhonebookEntryDetailsArray.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.details.length; ++i2) {
            if (this.details[i2].hasSameContent(combiBAPPhonebookEntryDetailsArray[i2])) continue;
            return false;
        }
        return true;
    }
}

