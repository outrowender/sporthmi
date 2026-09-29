/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredDest_List_Status
implements StatusProperty {
    public int listType;
    private static final int LIST_TYPE_BITSIZE;
    public static final int LIST_TYPE_NO_LIST_PREFERRED_UNDEFINED;
    public static final int LIST_TYPE_LAST_DESTINATIONS_LIST_FCT_0X1D;
    public static final int LIST_TYPE_FAVORITE_DESTINATIONS_LIST_FCT_0X1E;
    public static final int LIST_TYPE_NAV_BOOK_FCT_0X20;

    public PreferredDest_List_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredDest_List_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.listType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PreferredDest_List_Status preferredDest_List_Status = (PreferredDest_List_Status)bAPEntity;
        return this.listType == preferredDest_List_Status.listType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PreferredDest_List_Status:");
        stringBuffer.append("\n - ListType: ");
        switch (this.listType) {
            case 0: {
                stringBuffer.append("0x00 (no list preferred / undefined)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (LastDestinations_List (fct 0x1D))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (FavoriteDestinations_List (fct. 0x1E))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (NavBook (fct. 0x20))");
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
        bitStream.pushByte((byte)this.listType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return PreferredDest_List_Status.functionId();
    }
}

