/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionListType_Status
implements StatusProperty {
    public int type;
    private static final int TYPE_BITSIZE;
    public static final int TYPE_UNKNOWN_TYPE_UNSPECIFIC;
    public static final int TYPE_FM_RECEPTION_LIST;
    public static final int TYPE_AM_RECEPTION_LIST;
    public static final int TYPE_DAB_RECEPTION_LIST;
    public static final int TYPE_SDARS_RECEPTION_LIST;
    public static final int TYPE_DVB_RECEPTION_LIST;
    public static final int TYPE_TV_RECEPTION_LIST;
    public static final int TYPE_AM_SW_RECEPTION_LIST;
    public static final int TYPE_AM_LW_RECEPTION_LIST;
    public static final int TYPE_ONLINE_RADIO_RECEPTION_LIST_DF4_1;
    public static final int TYPE_COMMON_LIST_DF4_2;
    public static final int TYPE_NO_RECEPTION_LIST_AVAILABLE_RECEPTION_LIST_NOT_SUPPORTED;

    public ReceptionListType_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionListType_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionListType_Status receptionListType_Status = (ReceptionListType_Status)bAPEntity;
        return this.type == receptionListType_Status.type;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReceptionListType_Status:");
        stringBuffer.append("\n - Type: ");
        switch (this.type) {
            case 0: {
                stringBuffer.append("0x00 (unknown type / unspecific)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (FM reception list)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (AM reception list)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (DAB reception list)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (SDARS reception list)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (DVB reception list)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (TV reception list)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (AM-SW reception list)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (AM-LW reception list)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (online radio reception list (DF4.1))");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (CommonList (DF4.2))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (no reception list available / reception list not supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.type);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.type = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return ReceptionListType_Status.functionId();
    }
}

