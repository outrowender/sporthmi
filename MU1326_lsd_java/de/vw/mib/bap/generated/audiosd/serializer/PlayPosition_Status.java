/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.PlayPosition_Status$Attributes;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PlayPosition_Status
implements StatusProperty {
    public int timePosition;
    private static final int TIME_POSITION_BITSIZE;
    public int totalPlayTime;
    private static final int TOTAL_PLAY_TIME_BITSIZE;
    public final PlayPosition_Status$Attributes attributes = new PlayPosition_Status$Attributes();
    public static final int EXTENSION_MIN;
    public int extension;
    private static final int EXTENSION_BITSIZE;

    public PlayPosition_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PlayPosition_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timePosition = 0;
        this.totalPlayTime = 0;
        this.extension = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.attributes.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PlayPosition_Status playPosition_Status = (PlayPosition_Status)bAPEntity;
        return this.timePosition == playPosition_Status.timePosition && this.totalPlayTime == playPosition_Status.totalPlayTime && this.attributes.equalTo(playPosition_Status.attributes) && this.extension == playPosition_Status.extension;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PlayPosition_Status:");
        stringBuffer.append("\n - TimePosition - ");
        stringBuffer.append(this.timePosition);
        stringBuffer.append("\n - TotalPlayTime - ");
        stringBuffer.append(this.totalPlayTime);
        stringBuffer.append("\n - Attributes - ");
        stringBuffer.append(this.attributes.toString());
        stringBuffer.append("\n - Extension - ");
        stringBuffer.append(this.extension);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 16;
        n += 16;
        n += this.attributes.bitSize();
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.timePosition);
        bitStream.pushShort((short)this.totalPlayTime);
        this.attributes.serialize(bitStream);
        bitStream.pushByte((byte)this.extension);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.timePosition = bitStream.popFrontShort();
        this.totalPlayTime = bitStream.popFrontShort();
        this.attributes.deserialize(bitStream);
        this.extension = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 52;
    }

    @Override
    public int getFunctionId() {
        return PlayPosition_Status.functionId();
    }
}

