/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolumeExtended_Status
implements StatusProperty {
    public int changingVolumeType;
    private static final int CHANGING_VOLUME_TYPE_BITSIZE = 8;
    public static final int CHANGING_VOLUME_TYPE_NO_VOLUME_IS_CHANGED = 0;
    public static final int CHANGING_VOLUME_TYPE_ENTERTAINMENT_VOLUME_IS_BEING_CHANGED = 1;
    public static final int CHANGING_VOLUME_TYPE_NAVIGATION_VOLUME_IS_BEING_CHANGED = 2;
    public static final int CHANGING_VOLUME_TYPE_PHONE_RINGING_VOLUME_IS_BEING_CHANGED = 3;
    public static final int CHANGING_VOLUME_TYPE_TA_TP_VOLUME_IS_BEING_CHANGED = 4;
    public static final int CHANGING_VOLUME_TYPE_CAR_PARKING_FADER_IS_BEING_CHANGED = 5;
    public static final int CHANGING_VOLUME_TYPE_READ_MESSAGE_VOLUME_IS_BEING_CHANGED = 6;
    public static final int CHANGING_VOLUME_TYPE_TMC_TRAFFIC_MESSAGE_VOLUME_IS_BEING_CHANGED = 7;
    public static final int CHANGING_VOLUME_TYPE_PHONE_CALL_VOLUME_IS_BEING_CHANGED = 8;
    public static final int CHANGING_VOLUME_TYPE_READ_CONTACT_VOLUME_IS_BEING_CHANGED = 9;
    public static final int CHANGING_VOLUME_TYPE_MMI_TOUCH_VOLUME_IS_BEING_CHANGED = 10;
    public static final int CHANGING_VOLUME_TYPE_ANNOUNCEMENT_VOLUME_IS_BEING_CHANGED = 11;
    public static final int CHANGING_VOLUME_TYPE_ONLINE_VOLUME_TYPE_IS_BEING_CHANGED = 12;
    public static final int CHANGING_VOLUME_TYPE_SDS_VOLUME_IS_BEING_CHANGED = 16;
    public static final int CHANGING_VOLUME_TYPE_EXTERNAL_SDS_VOLUME_IS_BEING_CHANGED_DF4_4 = 17;
    public final VolumeState volumeState = new VolumeState();
    public int maxVolume;
    private static final int MAX_VOLUME_BITSIZE = 8;
    public int genericVolume;
    private static final int GENERIC_VOLUME_BITSIZE = 8;

    public CurrentVolumeExtended_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolumeExtended_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.changingVolumeType = 0;
        this.maxVolume = 0;
        this.genericVolume = 0;
    }

    public void reset() {
        this.internalReset();
        this.volumeState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolumeExtended_Status currentVolumeExtended_Status = (CurrentVolumeExtended_Status)bAPEntity;
        return this.changingVolumeType == currentVolumeExtended_Status.changingVolumeType && this.volumeState.equalTo(currentVolumeExtended_Status.volumeState) && this.maxVolume == currentVolumeExtended_Status.maxVolume && this.genericVolume == currentVolumeExtended_Status.genericVolume;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentVolumeExtended_Status:");
        stringBuffer.append("\n - ChangingVolumeType: ");
        switch (this.changingVolumeType) {
            case 0: {
                stringBuffer.append("0x00 (no volume is changed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (entertainment volume is being changed)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (navigation volume is being changed)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (phone ringing volume is being changed)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (TA/TP volume is being changed)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (car parking fader is being changed)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (read message volume is being changed)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (TMC traffic message volume is being changed)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (phone  call volume is being changed)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (read contact volume is being changed)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (MMI touch volume is being changed)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (announcement volume is being changed)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (online volume type is being changed)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (SDS volume is being changed)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (external SDS volume is being changed (DF4.4))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - VolumeState - ");
        stringBuffer.append(this.volumeState.toString());
        stringBuffer.append("\n - maxVolume - ");
        stringBuffer.append(this.maxVolume);
        stringBuffer.append("\n - GenericVolume - ");
        stringBuffer.append(this.genericVolume);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += this.volumeState.bitSize();
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.changingVolumeType);
        this.volumeState.serialize(bitStream);
        bitStream.pushByte((byte)this.maxVolume);
        bitStream.pushByte((byte)this.genericVolume);
    }

    public void deserialize(BitStream bitStream) {
        this.changingVolumeType = bitStream.popFrontByte();
        this.volumeState.deserialize(bitStream);
        this.maxVolume = bitStream.popFrontByte();
        this.genericVolume = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 47;
    }

    public int getFunctionId() {
        return CurrentVolumeExtended_Status.functionId();
    }

    public static final class VolumeState
    implements BAPEntity {
        private static final int RESERVED_BIT_1__7_BITSIZE = 7;
        public boolean volumeIsNotLocked;
        private static final int VOLUME_STATE_BITSIZE = 8;

        public VolumeState() {
            this.internalReset();
            this.customInitialization();
        }

        public VolumeState(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.volumeIsNotLocked = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            VolumeState volumeState = (VolumeState)bAPEntity;
            return this.volumeIsNotLocked == volumeState.volumeIsNotLocked;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("VolumeState:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.volumeIsNotLocked) {
                stringBuffer.append("true  (Volume is not locked");
            } else {
                stringBuffer.append("false  (Volume is locked");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(7);
            bitStream.pushBoolean(this.volumeIsNotLocked);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(7);
            this.volumeIsNotLocked = bitStream.popFrontBoolean();
        }
    }
}

