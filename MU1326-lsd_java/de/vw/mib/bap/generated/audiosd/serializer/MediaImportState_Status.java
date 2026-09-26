/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MediaImportState_Status
implements StatusProperty {
    public int sourceType;
    private static final int SOURCE_TYPE_BITSIZE;
    public static final int SOURCE_TYPE_NO_SOURCE_ACTIVE;
    public static final int SOURCE_TYPE_CD;
    public static final int SOURCE_TYPE_CD_CHANGER;
    public static final int SOURCE_TYPE_DVD;
    public static final int SOURCE_TYPE_HDD;
    public static final int SOURCE_TYPE_SD;
    public static final int SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI;
    public static final int SOURCE_TYPE_GENERIC_PLAYER;
    public static final int SOURCE_TYPE_DVD_CHANGER;
    public static final int SOURCE_TYPE_USB;
    public static final int SOURCE_TYPE_JUKEBOX;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER;
    public static final int SOURCE_TYPE_BLUE_RAY;
    public static final int SOURCE_TYPE_BLUE_RAY_CHANGER;
    public static final int SOURCE_TYPE_FLASH_FLASH_MEMORY;
    public static final int SOURCE_TYPE_HDMI_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_RADIO_DF4_1;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE;
    public int instance_Id;
    private static final int INSTANCE_ID_BITSIZE;
    public int state;
    private static final int STATE_BITSIZE;
    public static final int STATE_IMPORT_NOT_ACTIVE;
    public static final int STATE_IMPORT_ACTIVE_ONGOING;
    public int progress;
    private static final int PROGRESS_BITSIZE;

    public MediaImportState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaImportState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sourceType = 0;
        this.instance_Id = 0;
        this.state = 0;
        this.progress = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaImportState_Status mediaImportState_Status = (MediaImportState_Status)bAPEntity;
        return this.sourceType == mediaImportState_Status.sourceType && this.instance_Id == mediaImportState_Status.instance_Id && this.state == mediaImportState_Status.state && this.progress == mediaImportState_Status.progress;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaImportState_Status:");
        stringBuffer.append("\n - SourceType: ");
        switch (this.sourceType) {
            case 0: {
                stringBuffer.append("0x00 (no source active)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (CD)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (CD changer)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (DVD)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (HDD)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (SD)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (portable device (MDI, AMI))");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (generic player)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (DVD changer)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (USB)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (Jukebox)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (Bluetooth connection - BT stream)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (Bluetooth connection - remote control protocol)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (WLAN connection - mass storage)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (WLAN connection - RCP (Remote Control Player))");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (BlueRay)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (BlueRay changer)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (Flash (flash memory))");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (HDMI (DF4.1))");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (online mass storage (DF4.1))");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (online radio (DF4.1))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown source)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Instance_ID - ");
        stringBuffer.append(this.instance_Id);
        stringBuffer.append("\n - State: ");
        switch (this.state) {
            case 0: {
                stringBuffer.append("0x00 (import not active)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (import active/ongoing)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Progress - ");
        stringBuffer.append(this.progress);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.sourceType);
        bitStream.pushByte((byte)this.instance_Id);
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.progress);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.sourceType = bitStream.popFrontByte();
        this.instance_Id = bitStream.popFrontByte();
        this.state = bitStream.popFrontByte();
        this.progress = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 46;
    }

    @Override
    public int getFunctionId() {
        return MediaImportState_Status.functionId();
    }
}

