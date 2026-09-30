/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPFavoriteNumberEntry
implements CombiBAPArrayElement {
    private int posID;
    private String name;
    private String telNumber;
    private int numberType;

    public CombiBAPFavoriteNumberEntry(int n, String string, String string2) {
        this(n, string, string2, 0);
    }

    public CombiBAPFavoriteNumberEntry(int n, String string, String string2, int n2) {
        this.posID = n;
        this.name = string;
        this.telNumber = string2;
        this.numberType = n2;
    }

    public int getPosID() {
        return this.posID;
    }

    public String getName() {
        return this.name;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPFavoriteNumberEntry {");
        buffer.append("posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), name=");
        buffer.append(this.name);
        buffer.append(", ");
        buffer.append("telNumber=");
        buffer.append(this.telNumber);
        buffer.append(", ");
        buffer.append("numberType=");
        buffer.append(this.numberType);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPFavoriteNumberEntry) {
            CombiBAPFavoriteNumberEntry combiBAPFavoriteNumberEntry = (CombiBAPFavoriteNumberEntry)combiBAPArrayElement;
            return this.posID == combiBAPFavoriteNumberEntry.posID && this.name.equals(combiBAPFavoriteNumberEntry.name) && this.telNumber.equals(combiBAPFavoriteNumberEntry.telNumber) && this.numberType == combiBAPFavoriteNumberEntry.numberType;
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPFavoriteNumberEntry) {
            CombiBAPFavoriteNumberEntry combiBAPFavoriteNumberEntry = (CombiBAPFavoriteNumberEntry)combiBAPArrayElement;
            n = CombiBAPFavoriteNumberEntry.getRecordAddress(this.posID != combiBAPFavoriteNumberEntry.posID, !this.name.equals(combiBAPFavoriteNumberEntry.name), !this.telNumber.equals(combiBAPFavoriteNumberEntry.telNumber), this.numberType != combiBAPFavoriteNumberEntry.numberType);
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
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
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n <= 2 ? (!bl && !bl4 ? 2 : (!bl && !bl3 ? 1 : 0)) : 0));
        return n2;
    }
}

