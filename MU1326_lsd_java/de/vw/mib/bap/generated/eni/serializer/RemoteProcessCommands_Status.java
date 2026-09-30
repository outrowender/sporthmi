/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessCommands_SupportedCommands0;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessCommands_SupportedCommands1;
import de.vw.mib.bap.generated.eni.serializer.RemoteProcessCommands_SupportedCommands2;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessCommands_Status
implements StatusProperty {
    public RemoteProcessCommands_SupportedCommands0 supportedCommands0 = new RemoteProcessCommands_SupportedCommands0();
    public RemoteProcessCommands_SupportedCommands1 supportedCommands1 = new RemoteProcessCommands_SupportedCommands1();
    public RemoteProcessCommands_SupportedCommands2 supportedCommands2 = new RemoteProcessCommands_SupportedCommands2();
    public int supportedCommands3;
    public static final int SUPPORTED_COMMANDS3_MIN = 0;
    public int supportedCommands4;
    public static final int SUPPORTED_COMMANDS4_MIN = 0;
    public int supportedCommands5;
    public static final int SUPPORTED_COMMANDS5_MIN = 0;

    public RemoteProcessCommands_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessCommands_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.supportedCommands3 = 0;
        this.supportedCommands4 = 0;
        this.supportedCommands5 = 0;
    }

    public void reset() {
        this.internalReset();
        this.supportedCommands0.reset();
        this.supportedCommands1.reset();
        this.supportedCommands2.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessCommands_Status remoteProcessCommands_Status = (RemoteProcessCommands_Status)bAPEntity;
        return this.supportedCommands0.equalTo(remoteProcessCommands_Status.supportedCommands0) && this.supportedCommands1.equalTo(remoteProcessCommands_Status.supportedCommands1) && this.supportedCommands2.equalTo(remoteProcessCommands_Status.supportedCommands2) && this.supportedCommands3 == remoteProcessCommands_Status.supportedCommands3 && this.supportedCommands4 == remoteProcessCommands_Status.supportedCommands4 && this.supportedCommands5 == remoteProcessCommands_Status.supportedCommands5;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RemoteProcessCommands_Status");
        stringBuffer.append("\n - supportedCommands0:" + this.supportedCommands0.toString());
        stringBuffer.append("\n - supportedCommands1:" + this.supportedCommands1.toString());
        stringBuffer.append("\n - supportedCommands2:" + this.supportedCommands2.toString());
        stringBuffer.append("\n - supportedCommands3:" + this.supportedCommands3);
        stringBuffer.append("\n - supportedCommands4:" + this.supportedCommands4);
        stringBuffer.append("\n - supportedCommands5:" + this.supportedCommands5);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.supportedCommands0.serialize(bitStream);
        this.supportedCommands1.serialize(bitStream);
        this.supportedCommands2.serialize(bitStream);
        bitStream.pushByte((byte)this.supportedCommands3);
        bitStream.pushByte((byte)this.supportedCommands4);
        bitStream.pushByte((byte)this.supportedCommands5);
    }

    public void deserialize(BitStream bitStream) {
        this.supportedCommands0.deserialize(bitStream);
        this.supportedCommands1.deserialize(bitStream);
        this.supportedCommands2.deserialize(bitStream);
        this.supportedCommands3 = bitStream.popFrontByte();
        this.supportedCommands4 = bitStream.popFrontByte();
        this.supportedCommands5 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 19;
    }

    public int getFunctionId() {
        return RemoteProcessCommands_Status.functionId();
    }
}

