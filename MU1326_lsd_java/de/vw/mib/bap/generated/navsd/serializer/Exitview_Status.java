/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Exitview_Status
implements StatusProperty {
    public int variant;
    private static final int VARIANT_BITSIZE = 8;
    public static final int VARIANT_EU = 0;
    public static final int VARIANT_NAR = 1;
    public static final int VARIANT_ROW = 2;
    public static final int VARIANT_ASIA = 3;
    public static final int VARIANT_UNKNOWN = 255;
    public int exitview_Id;
    private static final int EXITVIEW_ID_BITSIZE = 16;

    public Exitview_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Exitview_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.variant = 0;
        this.exitview_Id = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Exitview_Status exitview_Status = (Exitview_Status)bAPEntity;
        return this.variant == exitview_Status.variant && this.exitview_Id == exitview_Status.exitview_Id;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Exitview_Status:");
        stringBuffer.append("\n - Variant: ");
        switch (this.variant) {
            case 0: {
                stringBuffer.append("0x00 (EU)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (NAR)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ROW)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (ASIA)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Exitview_ID - ");
        stringBuffer.append(this.exitview_Id);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.variant);
        bitStream.pushShort((short)this.exitview_Id);
    }

    public void deserialize(BitStream bitStream) {
        this.variant = bitStream.popFrontByte();
        this.exitview_Id = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 49;
    }

    public int getFunctionId() {
        return Exitview_Status.functionId();
    }
}

