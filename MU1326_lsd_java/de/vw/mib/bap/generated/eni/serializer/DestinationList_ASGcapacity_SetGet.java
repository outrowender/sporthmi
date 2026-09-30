/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationList_ASGcapacity_SetGet
implements SetGetProperty {
    public int asgcapacity;
    public static final int ASGCAPACITY_MIN = 0;

    public DestinationList_ASGcapacity_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public DestinationList_ASGcapacity_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asgcapacity = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationList_ASGcapacity_SetGet destinationList_ASGcapacity_SetGet = (DestinationList_ASGcapacity_SetGet)bAPEntity;
        return this.asgcapacity == destinationList_ASGcapacity_SetGet.asgcapacity;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DestinationList_ASGcapacity_SetGet");
        stringBuffer.append("\n - asgcapacity:" + this.asgcapacity);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.asgcapacity);
    }

    public void deserialize(BitStream bitStream) {
        this.asgcapacity = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 17;
    }

    public int getFunctionId() {
        return DestinationList_ASGcapacity_SetGet.functionId();
    }
}

