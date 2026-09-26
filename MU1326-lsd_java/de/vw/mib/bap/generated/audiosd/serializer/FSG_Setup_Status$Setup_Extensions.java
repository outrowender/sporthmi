/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$Setup_Extensions
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean commonListIsAutomaticallyUpdated;
    public boolean dabServiceSortedList;
    private static final int SETUP_EXTENSIONS_BITSIZE;

    public FSG_Setup_Status$Setup_Extensions() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$Setup_Extensions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.commonListIsAutomaticallyUpdated = false;
        this.dabServiceSortedList = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$Setup_Extensions fSG_Setup_Status$Setup_Extensions = (FSG_Setup_Status$Setup_Extensions)bAPEntity;
        return this.commonListIsAutomaticallyUpdated == fSG_Setup_Status$Setup_Extensions.commonListIsAutomaticallyUpdated && this.dabServiceSortedList == fSG_Setup_Status$Setup_Extensions.dabServiceSortedList;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Setup_Extensions:");
        stringBuffer.append("\n - Bit 1: ");
        if (this.commonListIsAutomaticallyUpdated) {
            stringBuffer.append("true  (CommonList is automatically updated (DF4.1)");
        } else {
            stringBuffer.append("false  (CommonList is NOT automatically updated (DF4.1)");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.dabServiceSortedList) {
            stringBuffer.append("true  (DAB service sorted list");
        } else {
            stringBuffer.append("false  (DAB ensemble sorted list");
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
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.commonListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.dabServiceSortedList);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.commonListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.dabServiceSortedList = bitStream.popFrontBoolean();
    }
}

