/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredList_SetGet
implements SetGetProperty {
    public int list;
    private static final int LIST_BITSIZE = 8;
    public static final int LIST_NO_LIST_PREFERRED = 0;
    public static final int LIST_RECEPTION_LIST_MEDIA_BROWSER_PREFERRED = 1;
    public static final int LIST_PRESET_LIST_PREFERRED = 2;
    public static final int LIST_COMMON_LIST_PREFERRED_DF4_1 = 3;

    public PreferredList_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredList_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.list = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PreferredList_SetGet preferredList_SetGet = (PreferredList_SetGet)bAPEntity;
        return this.list == preferredList_SetGet.list;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PreferredList_SetGet:");
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

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.list);
    }

    public void deserialize(BitStream bitStream) {
        this.list = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 40;
    }

    public int getFunctionId() {
        return PreferredList_SetGet.functionId();
    }
}

