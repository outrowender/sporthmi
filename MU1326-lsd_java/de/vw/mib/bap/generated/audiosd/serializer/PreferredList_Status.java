/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredList_Status
implements StatusProperty {
    public int list;
    private static final int LIST_BITSIZE;
    public static final int LIST_NO_LIST_PREFERRED;
    public static final int LIST_RECEPTION_LIST_MEDIA_BROWSER_PREFERRED;
    public static final int LIST_PRESET_LIST_PREFERRED;
    public static final int LIST_COMMON_LIST_PREFERRED_DF4_1;

    public PreferredList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.list = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PreferredList_Status preferredList_Status = (PreferredList_Status)bAPEntity;
        return this.list == preferredList_Status.list;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PreferredList_Status:");
        stringBuffer.append("\n - List: ");
        switch (this.list) {
            case 0: {
                stringBuffer.append("0x00 (no list preferred)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (reception list / media browser preferred)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (preset list preferred)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (common list preferred (DF4.1))");
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
        bitStream.pushByte((byte)this.list);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.list = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 40;
    }

    @Override
    public int getFunctionId() {
        return PreferredList_Status.functionId();
    }
}

