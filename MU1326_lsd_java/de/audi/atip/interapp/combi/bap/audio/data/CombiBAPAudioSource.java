/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSourceAttributes;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPAudioSource
implements CombiBAPArrayElement {
    private int mediaType;
    private String name;
    private int sourceType;
    private int slotNumber;
    private int partitionNumber;
    private final CombiBAPAudioSourceAttributes attributes = new CombiBAPAudioSourceAttributes();
    private int posID;

    public CombiBAPAudioSource() {
        this(0, 0, 0, 0, "", 0);
    }

    public CombiBAPAudioSource(int n, int n2, int n3, String string) {
        this.sourceType = n;
        this.slotNumber = CombiBAPAudioSource.slotFromSourceId(n2);
        this.partitionNumber = CombiBAPAudioSource.partitionFromSourceId(n2);
        this.mediaType = n3;
        this.name = string;
        this.attributes.set(0);
    }

    public CombiBAPAudioSource(int n, int n2, int n3, int n4, String string) {
        this(n, n2, n3, n4, string, 0);
    }

    public CombiBAPAudioSource(int n, int n2, int n3, int n4, String string, CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        this.sourceType = n;
        this.setSlotNumber(n2);
        this.setPartitionNumber(n3);
        this.mediaType = n4;
        this.name = string;
        this.attributes.set(combiBAPAudioSourceAttributes);
    }

    public CombiBAPAudioSource(int n, int n2, int n3, int n4, String string, int n5) {
        this.sourceType = n;
        this.setSlotNumber(n2);
        this.setPartitionNumber(n3);
        this.mediaType = n4;
        this.name = string;
        this.attributes.set(n5);
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int n) {
        this.sourceType = n;
    }

    public int getSlotNumber() {
        return CombiBAPAudioSource.mediaSlotNumberFromCombiSlotNumber(this.sourceType, this.slotNumber, this.attributes);
    }

    public void setSlotNumber(int n) {
        this.slotNumber = CombiBAPAudioSource.combiSlotNumberFromMediaSlotNumber(this.sourceType, n, this.attributes);
    }

    public int getPartitionNumber() {
        return this.partitionNumber;
    }

    public void setPartitionNumber(int n) {
        this.partitionNumber = n;
    }

    public CombiBAPAudioSourceAttributes getAttributes() {
        return new CombiBAPAudioSourceAttributes(this.attributes);
    }

    public void setAttributes(CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        this.attributes.set(combiBAPAudioSourceAttributes);
    }

    @Override
    public int getPosID() {
        return this.posID;
    }

    public void setPosID(int n) {
        this.posID = n;
    }

    public int getNumber() {
        return this.slotNumber;
    }

    public int getInstanceId() {
        return this.slotNumber;
    }

    public int getTypeOfNumber() {
        int n;
        switch (this.sourceType) {
            case 7: 
            case 18: 
            case 30: {
                n = 5;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public int getSourceId() {
        return CombiBAPAudioSource.sourceIdFromSlotAndPartition(this.slotNumber, this.partitionNumber);
    }

    public void set(CombiBAPAudioSource combiBAPAudioSource) {
        this.mediaType = combiBAPAudioSource.mediaType;
        this.sourceType = combiBAPAudioSource.sourceType;
        this.partitionNumber = combiBAPAudioSource.partitionNumber;
        this.slotNumber = combiBAPAudioSource.slotNumber;
        this.name = combiBAPAudioSource.name;
        this.posID = combiBAPAudioSource.posID;
        this.attributes.set(this.attributes);
    }

    private static int slotFromSourceId(int n) {
        return n & 0xF;
    }

    private static int partitionFromSourceId(int n) {
        return (n & 0xF0) >> 4;
    }

    private static int sourceIdFromSlotAndPartition(int n, int n2) {
        return n2 << 4 | n;
    }

    private static int combiSlotNumberFromMediaSlotNumber(int n, int n2, CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        if (CombiBAPAudioSource.slotNumberNeedsConversion(n, combiBAPAudioSourceAttributes)) {
            return CombiBAPAudioSource.convertSlotNumberFromMediaToCombi(n2);
        }
        return n2;
    }

    private static int mediaSlotNumberFromCombiSlotNumber(int n, int n2, CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        if (CombiBAPAudioSource.slotNumberNeedsConversion(n, combiBAPAudioSourceAttributes)) {
            return CombiBAPAudioSource.convertSlotNumberFromCombiToMedia(n2);
        }
        return n2;
    }

    private static boolean slotNumberNeedsConversion(int n, CombiBAPAudioSourceAttributes combiBAPAudioSourceAttributes) {
        return n == 11 || n == 19 || n == 7 || n == 18 || n == 30 || n == 16 || n == 15 && !combiBAPAudioSourceAttributes.isBuiltInButNotReady();
    }

    private static int convertSlotNumberFromMediaToCombi(int n) {
        return n + 1;
    }

    private static int convertSlotNumberFromCombiToMedia(int n) {
        return n - 1;
    }

    @Override
    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPAudioSource) {
            CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)combiBAPArrayElement;
            return this.posID == combiBAPAudioSource.posID && this.sourceType == combiBAPAudioSource.sourceType && this.getSourceId() == combiBAPAudioSource.getSourceId() && this.mediaType == combiBAPAudioSource.mediaType && this.name.equals(combiBAPAudioSource.name) && this.attributes.equals(combiBAPAudioSource.attributes);
        }
        return false;
    }

    @Override
    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (this.hasSameContent(combiBAPArrayElement)) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPAudioSource) {
            CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)combiBAPArrayElement;
            n = CombiBAPAudioSource.getRecordAddress(this.posID != combiBAPAudioSource.posID, this.sourceType != combiBAPAudioSource.sourceType, this.getSourceId() != combiBAPAudioSource.getSourceId(), this.mediaType != combiBAPAudioSource.mediaType, !this.name.equals(combiBAPAudioSource.name), !this.attributes.equals(combiBAPAudioSource.attributes));
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
        int n2 = n == 0 ? -1 : (n == 1 ? (bl ? 15 : (bl4 ? 4 : (bl6 ? 3 : (bl5 ? 2 : 1)))) : (!bl5 ? 1 : 0));
        return n2;
    }

    private static String getSourceTypeName(int n) {
        switch (n) {
            case 0: {
                return "NO SOURCE ACTIVE";
            }
            case 1: {
                return "FM";
            }
            case 2: {
                return "AM";
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
            case 6: {
                return "CD";
            }
            case 7: {
                return "CD_CHANGER";
            }
            case 8: {
                return "DVD";
            }
            case 9: {
                return "TV";
            }
            case 10: {
                return "HDD";
            }
            case 11: {
                return "SD";
            }
            case 12: {
                return "TP_MEMO_TIM";
            }
            case 13: {
                return "AUX_IN_AUDIO";
            }
            case 14: {
                return "AUX_IN_VIDEO";
            }
            case 15: {
                return "PORTABLE_DEVICE_MDI_AMI";
            }
            case 16: {
                return "GENERIC_PLAYER";
            }
            case 17: {
                return "AM_TI_JAPAN";
            }
            case 18: {
                return "DVD_CHANGER";
            }
            case 19: {
                return "USB";
            }
            case 20: {
                return "JUKEBOX";
            }
            case 21: {
                return "BLUETOOTH_CONNECTION_BT_STREAM";
            }
            case 22: {
                return "BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL";
            }
            case 23: {
                return "DVB_VIDEO_SERVICE";
            }
            case 24: {
                return "DVB_AUDIO_SERVICE";
            }
            case 25: {
                return "AM_SW_KURZWELLE_SHORT_WAVE";
            }
            case 26: {
                return "AM_LW_LANGWELLE_LONG_WAVE";
            }
            case 27: {
                return "WLAN_CONNECTION_MASS_STORAGE";
            }
            case 28: {
                return "WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER";
            }
            case 29: {
                return "BLUE_RAY";
            }
            case 30: {
                return "BLUE_RAY_CHANGER";
            }
            case 31: {
                return "FLASH_FLASH_MEMORY";
            }
            case 32: {
                return "AUX_IN_VIDEO_TV";
            }
            case 33: {
                return "HDMI";
            }
            case 34: {
                return "ONLINE_MASS_STORAGE";
            }
            case 35: {
                return "ONLINE_RADIO";
            }
            case 36: {
                return "COMMON LIST (DABFM)";
            }
            case 37: {
                return "MOBILE_DEVICE_APPLE_LINK";
            }
            case 38: {
                return "MOBILE_DEVICE_MIRROR_LINK";
            }
            case 39: {
                return "MOBILE_DEVICE_GOOGLE_LINK";
            }
            case 40: {
                return "MOBILE_DEVICE_BAIDU_LINK";
            }
            case 255: {
                return "UNKNOWN SOURCE";
            }
        }
        return "INVALID SOURCE TYPE";
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.attributes == null ? 0 : this.attributes.hashCode());
        n = 31 * n + this.mediaType;
        n = 31 * n + (this.name == null ? 0 : this.name.hashCode());
        n = 31 * n + this.partitionNumber;
        n = 31 * n + this.posID;
        n = 31 * n + this.slotNumber;
        n = 31 * n + this.sourceType;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CombiBAPAudioSource combiBAPAudioSource = (CombiBAPAudioSource)object;
        if (this.attributes == null ? combiBAPAudioSource.attributes != null : !this.attributes.equals(combiBAPAudioSource.attributes)) {
            return false;
        }
        if (this.mediaType != combiBAPAudioSource.mediaType) {
            return false;
        }
        if (this.name == null ? combiBAPAudioSource.name != null : !this.name.equals(combiBAPAudioSource.name)) {
            return false;
        }
        if (this.partitionNumber != combiBAPAudioSource.partitionNumber) {
            return false;
        }
        if (this.posID != combiBAPAudioSource.posID) {
            return false;
        }
        if (this.slotNumber != combiBAPAudioSource.slotNumber) {
            return false;
        }
        return this.sourceType == combiBAPAudioSource.sourceType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPAudioSource {posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), name=");
        buffer.append(this.name);
        buffer.append(", sourceType=");
        buffer.append(this.sourceType);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.sourceType));
        buffer.append(") (");
        buffer.append(CombiBAPAudioSource.getSourceTypeName(this.sourceType));
        buffer.append(")");
        buffer.append(", slot=");
        buffer.append(this.getSlotNumber());
        buffer.append(", partition=");
        buffer.append(this.getPartitionNumber());
        buffer.append(", sourceID=");
        buffer.append(this.getSourceId());
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.getSourceId()));
        buffer.append("), mediaType=");
        buffer.append(this.mediaType);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.mediaType));
        buffer.append("), attributes=");
        buffer.append(this.attributes);
        buffer.append("}");
        return buffer.toString();
    }
}

