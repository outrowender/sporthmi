/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ETC_Status_Status
implements StatusProperty {
    public int cardStatus;
    private static final int CARD_STATUS_BITSIZE = 8;
    public static final int CARD_STATUS_INIT_UNKNOWN = 0;
    public static final int CARD_STATUS_ETC_CARD_INSERTED = 1;
    public static final int CARD_STATUS_ETC_CARD_NOT_INSERTED = 2;
    public static final int CARD_STATUS_ETC_CARD_READER_IS_NOT_CONNECTED = 3;
    public static final int EXTENSION1_MAX = 0;
    public static final int EXTENSION1_MIN = 0;
    public int extension1;
    private static final int EXTENSION1_BITSIZE = 8;

    public ETC_Status_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ETC_Status_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.cardStatus = 0;
        this.extension1 = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ETC_Status_Status eTC_Status_Status = (ETC_Status_Status)bAPEntity;
        return this.cardStatus == eTC_Status_Status.cardStatus && this.extension1 == eTC_Status_Status.extension1;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ETC_Status_Status:");
        stringBuffer.append("\n - CardStatus: ");
        switch (this.cardStatus) {
            case 0: {
                stringBuffer.append("0x00 (init / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (ETC card inserted)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ETC card not inserted)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ETC card reader is not connected)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Extension1 - ");
        stringBuffer.append(this.extension1);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.cardStatus);
        bitStream.pushByte((byte)this.extension1);
    }

    public void deserialize(BitStream bitStream) {
        this.cardStatus = bitStream.popFrontByte();
        this.extension1 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 56;
    }

    public int getFunctionId() {
        return ETC_Status_Status.functionId();
    }
}

