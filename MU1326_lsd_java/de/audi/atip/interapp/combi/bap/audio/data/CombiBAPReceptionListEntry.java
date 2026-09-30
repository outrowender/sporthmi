/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.audio.data.AbstractCombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPReceptionListEntry
extends AbstractCombiBAPReceptionListEntry {
    private int type;
    private int fmRegionCode;
    private int dabEnsembleID = 0;
    private int dabEnsembleAbsPos = 0;
    private int absPos;

    public CombiBAPReceptionListEntry(int n, int n2, String string, String string2, int n3, int n4, int n5, int n6, String string3) {
        super(n, string, string2, n3, n4, n6, string3);
        this.type = n2;
        this.fmRegionCode = n5;
    }

    public CombiBAPReceptionListEntry(int n, int n2, String string, String string2, int n3, int n4, int n5, int n6) {
        this(n, n2, string, string2, n3, n4, n5, n6, null);
    }

    public CombiBAPReceptionListEntry(int n, int n2, String string, String string2) {
        this(n, n2, string, string2, 0, 0, 0, 0, null);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public int getFmRegionCode() {
        return this.fmRegionCode;
    }

    public void setFmRegionCode(int n) {
        this.fmRegionCode = n;
    }

    public void setDABEnsembleID(int n) {
        this.dabEnsembleID = n;
    }

    public int getDABEnsembleID() {
        return this.dabEnsembleID;
    }

    public int getDABEnsembleAbsPos() {
        return this.dabEnsembleAbsPos;
    }

    public void setDABEnsembleAbsPos(int n) {
        this.dabEnsembleAbsPos = n;
    }

    public int getAbsPos() {
        return this.absPos;
    }

    public void setAbsPos(int n) {
        this.absPos = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPReceptionListEntry {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), name=");
        buffer.append(this.name);
        buffer.append(", frequency=");
        buffer.append(this.frequency);
        buffer.append(", type=");
        buffer.append(CombiBAPReceptionListEntry.getTypeName(this.type));
        buffer.append(", presetID=");
        buffer.append(this.presetID);
        buffer.append(", fmRegionCode=");
        buffer.append(this.fmRegionCode);
        buffer.append(", category=");
        buffer.append(this.category);
        buffer.append(", dabEnsembleID=");
        buffer.append(this.dabEnsembleID);
        buffer.append(", dabEnsembleAbsPos=");
        buffer.append(this.dabEnsembleAbsPos);
        buffer.append(", absPos=");
        buffer.append(this.absPos);
        buffer.append(", pictureURL=");
        buffer.append(this.pictureURL);
        buffer.append(", attributes=");
        buffer.append(this.attributes);
        buffer.append("}");
        return buffer.toString();
    }

    protected static String getTypeName(int n) {
        switch (n) {
            case 1: {
                return "STATION";
            }
            case 2: {
                return "DAB_ENSEMBLE";
            }
            case 3: {
                return "DAB_PRIMARY_SERVICE";
            }
            case 4: {
                return "DAB_SECONDARY_SERVICE";
            }
            case 5: {
                return "IBOC_PRIMARY_SERVICE";
            }
            case 6: {
                return "IBOC_SECONDARY_SERVICE";
            }
            case 7: {
                return "DVB_SERVICE";
            }
            case 8: {
                return "SDARS_STATION";
            }
        }
        return String.valueOf(n);
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPReceptionListEntry) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)combiBAPArrayElement;
            return this.posID == combiBAPReceptionListEntry.posID && this.type == combiBAPReceptionListEntry.type && this.attributes == combiBAPReceptionListEntry.attributes && this.presetID == combiBAPReceptionListEntry.presetID && this.fmRegionCode == combiBAPReceptionListEntry.fmRegionCode && this.category == combiBAPReceptionListEntry.category && this.name.equals(combiBAPReceptionListEntry.name) && this.frequency.equals(combiBAPReceptionListEntry.frequency) && this.pictureURL.equals(combiBAPReceptionListEntry.pictureURL);
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPReceptionListEntry) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry = (CombiBAPReceptionListEntry)combiBAPArrayElement;
            n = CombiBAPReceptionListEntry.getRecordAddress(this.posID != combiBAPReceptionListEntry.posID, this.type != combiBAPReceptionListEntry.type, this.attributes != combiBAPReceptionListEntry.attributes, this.presetID != combiBAPReceptionListEntry.presetID, this.fmRegionCode != combiBAPReceptionListEntry.fmRegionCode, this.category != combiBAPReceptionListEntry.category, !this.name.equals(combiBAPReceptionListEntry.name), !this.frequency.equals(combiBAPReceptionListEntry.frequency));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
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
        if (bl7) {
            ++n;
        }
        if (bl8) {
            ++n;
        }
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n == 1 && bl7 ? 4 : (n == 1 && bl8 ? 5 : (n <= 2 && !bl && !bl4 && !bl5 && !bl6 && !bl7 && !bl8 ? 2 : (n <= 4 && !bl && !bl2 && !bl3 && !bl8 ? 3 : (n <= 4 && !bl && !bl4 && !bl5 && !bl8 ? 6 : (n <= 6 && !bl && !bl8 ? 1 : 0)))))));
        return n2;
    }
}

