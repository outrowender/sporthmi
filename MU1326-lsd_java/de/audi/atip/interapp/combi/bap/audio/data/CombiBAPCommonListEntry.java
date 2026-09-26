/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.audio.data.AbstractCombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPCommonListEntry
extends AbstractCombiBAPReceptionListEntry {
    private int sourceType;

    public CombiBAPCommonListEntry(int n, int n2, String string, String string2, int n3, int n4, int n5, String string3) {
        super(n, string, string2, n3, n4, n5, string3);
        this.sourceType = n2;
    }

    public CombiBAPCommonListEntry(int n, int n2, String string, String string2, int n3, int n4, int n5) {
        this(n, n2, string, string2, n3, n4, n5, null);
    }

    public CombiBAPCommonListEntry(int n, int n2, String string, String string2) {
        this(n, n2, string, string2, 0, 0, 0, null);
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int n) {
        this.sourceType = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPCommonListEntry {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), name=");
        buffer.append(this.name);
        buffer.append(", frequency=");
        buffer.append(this.frequency);
        buffer.append(", sourceType=");
        buffer.append(CombiBAPCommonListEntry.getSourceTypeName(this.sourceType));
        buffer.append(", presetID=");
        buffer.append(this.presetID);
        buffer.append(", category=");
        buffer.append(this.category);
        buffer.append(", pictureURL=");
        buffer.append(this.pictureURL);
        buffer.append(", attributes=");
        buffer.append(this.attributes);
        buffer.append("}");
        return buffer.toString();
    }

    private static String getSourceTypeName(int n) {
        switch (n) {
            case 1: {
                return "FM";
            }
            case 2: {
                return "AM_MW_MITTELWELLE";
            }
            case 3: {
                return "DAB";
            }
            case 4: {
                return "SDARS_XM";
            }
            case 5: {
                return "SDARS_SIRIUS";
            }
            case 9: {
                return "TV";
            }
            case 17: {
                return "AM_TI_JAPAN";
            }
            case 25: {
                return "AM_SW_KURZWELLE_SHORT_WAVE";
            }
            case 26: {
                return "AM_LW_LANGWELLE_LONG_WAVE";
            }
            case 35: {
                return "ONLINE_RADIO";
            }
            case 255: {
                return "UNKNOWN_SOURCE";
            }
        }
        return String.valueOf(n);
    }

    @Override
    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPCommonListEntry) {
            CombiBAPCommonListEntry combiBAPCommonListEntry = (CombiBAPCommonListEntry)combiBAPArrayElement;
            return this.posID == combiBAPCommonListEntry.posID && this.sourceType == combiBAPCommonListEntry.sourceType && this.attributes == combiBAPCommonListEntry.attributes && this.presetID == combiBAPCommonListEntry.presetID && this.category == combiBAPCommonListEntry.category && this.name.equals(combiBAPCommonListEntry.name) && this.frequency.equals(combiBAPCommonListEntry.frequency) && this.pictureURL.equals(combiBAPCommonListEntry.pictureURL);
        }
        return false;
    }

    @Override
    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPCommonListEntry) {
            CombiBAPCommonListEntry combiBAPCommonListEntry = (CombiBAPCommonListEntry)combiBAPArrayElement;
            n = CombiBAPCommonListEntry.getRecordAddress(this.posID != combiBAPCommonListEntry.posID, this.sourceType != combiBAPCommonListEntry.sourceType, this.attributes != combiBAPCommonListEntry.attributes, this.presetID != combiBAPCommonListEntry.presetID, this.category != combiBAPCommonListEntry.category, !this.name.equals(combiBAPCommonListEntry.name), !this.frequency.equals(combiBAPCommonListEntry.frequency));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
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
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n == 1 && bl6 ? 2 : (n <= 2 && !bl && !bl2 && !bl4 && !bl5 && !bl6 ? 3 : (n <= 6 && !bl && !bl7 ? 1 : 0))));
        return n2;
    }
}

