/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.Mute_MuteState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Mute_Status
implements StatusProperty {
    public final Mute_MuteState muteState = new Mute_MuteState();

    public Mute_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Mute_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.muteState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Mute_Status mute_Status = (Mute_Status)bAPEntity;
        return this.muteState.equalTo(mute_Status.muteState);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Mute_Status:");
        stringBuffer.append("\n - MuteState - ");
        stringBuffer.append(this.muteState.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.muteState.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.muteState.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.muteState.deserialize(bitStream);
    }

    public static int functionId() {
        return 19;
    }

    public int getFunctionId() {
        return Mute_Status.functionId();
    }
}

