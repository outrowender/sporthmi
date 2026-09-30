/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPPresetListEntry
implements CombiBAPArrayElement {
    public static final int ATTRIBUTE_IBOC_SERVICE = 1;
    public static final int ATTRIBUTE_DAB_SECONDARY_SERVICE = 2;
    public static final int ATTRIBUTE_DAB_PRIMARY_SERVICE_CONTAINS_SECONDARY_SERVICES = 4;
    public static final int ATTRIBUTE_TP_AVAILABLE = 32;
    public static final int ATTRIBUTE_TMC_AVAILABLE = 64;
    public static final int ATTRIBUTE_SDARS_STATION_SUBSCRIBED_OR_NOT_AN_SDARS_STATION = 128;
    private int posID;
    private int presetIndex = 0;
    private int waveband;
    private int attributes;
    private String name;

    public CombiBAPPresetListEntry(int n, int n2, int n3, String string) {
        this.posID = n;
        this.presetIndex = n2;
        this.waveband = n3;
        this.name = string;
    }

    public CombiBAPPresetListEntry(int n, int n2, int n3, String string, int n4) {
        this.posID = n;
        this.presetIndex = n2;
        this.waveband = n3;
        this.name = string;
        this.attributes = n4;
    }

    public int getPosID() {
        return this.posID;
    }

    public int getPresetIndex() {
        return this.presetIndex;
    }

    public int getWaveband() {
        return this.waveband;
    }

    public boolean hasAttribute(int n) {
        return (this.attributes & n) == n;
    }

    public void setAttributes(int n) {
        this.attributes = n;
    }

    public void addAttribute(int n) {
        this.attributes |= n;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPPresetListEntry {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), presetIndex=");
        buffer.append(this.presetIndex);
        buffer.append(", name=");
        buffer.append(this.name);
        buffer.append(", waveband=");
        buffer.append(this.waveband);
        buffer.append(", attributes=");
        buffer.append(this.attributes);
        buffer.append("}");
        return buffer.toString();
    }

    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPPresetListEntry) {
            CombiBAPPresetListEntry combiBAPPresetListEntry = (CombiBAPPresetListEntry)combiBAPArrayElement;
            return this.posID == combiBAPPresetListEntry.posID && this.presetIndex == combiBAPPresetListEntry.presetIndex && this.waveband == combiBAPPresetListEntry.waveband && this.attributes == combiBAPPresetListEntry.attributes && this.name.equals(combiBAPPresetListEntry.name);
        }
        return false;
    }

    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (combiBAPArrayElement == this) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPPresetListEntry) {
            CombiBAPPresetListEntry combiBAPPresetListEntry = (CombiBAPPresetListEntry)combiBAPArrayElement;
            n = CombiBAPPresetListEntry.getRecordAddress(this.posID != combiBAPPresetListEntry.posID, this.presetIndex != combiBAPPresetListEntry.presetIndex, this.waveband != combiBAPPresetListEntry.waveband, this.attributes != combiBAPPresetListEntry.attributes, !this.name.equals(combiBAPPresetListEntry.name));
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
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
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n <= 2 && !bl3 && !bl4 ? 2 : (n <= 3 && !bl4 ? 1 : 0)));
        return n2;
    }
}

