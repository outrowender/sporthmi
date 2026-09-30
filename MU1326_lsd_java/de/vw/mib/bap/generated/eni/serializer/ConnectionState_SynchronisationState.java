/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ConnectionState_SynchronisationState
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE = 6;
    public boolean serviceListWasSynchronised;
    public boolean userListWasSynchronised;

    public ConnectionState_SynchronisationState() {
        this.internalReset();
        this.customInitialization();
    }

    public ConnectionState_SynchronisationState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceListWasSynchronised = false;
        this.userListWasSynchronised = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ConnectionState_SynchronisationState connectionState_SynchronisationState = (ConnectionState_SynchronisationState)bAPEntity;
        return this.serviceListWasSynchronised == connectionState_SynchronisationState.serviceListWasSynchronised && this.userListWasSynchronised == connectionState_SynchronisationState.userListWasSynchronised;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ConnectionState_SynchronisationState");
        stringBuffer.append("\n - serviceListWasSynchronised:" + this.serviceListWasSynchronised);
        stringBuffer.append("\n - userListWasSynchronised:" + this.userListWasSynchronised);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.serviceListWasSynchronised);
        bitStream.pushBoolean(this.userListWasSynchronised);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.serviceListWasSynchronised = bitStream.popFrontBoolean();
        this.userListWasSynchronised = bitStream.popFrontBoolean();
    }
}

