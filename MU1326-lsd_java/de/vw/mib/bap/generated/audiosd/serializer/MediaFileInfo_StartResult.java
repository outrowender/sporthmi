/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaFileInfo_StartResult
implements StartResultMethod {
    public int ref_MediaBrowser;
    private static final int REF_MEDIA_BROWSER_BITSIZE;

    public MediaFileInfo_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaFileInfo_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ref_MediaBrowser = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaFileInfo_StartResult mediaFileInfo_StartResult = (MediaFileInfo_StartResult)bAPEntity;
        return this.ref_MediaBrowser == mediaFileInfo_StartResult.ref_MediaBrowser;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaFileInfo_StartResult:");
        stringBuffer.append("\n - Ref_MediaBrowser - ");
        stringBuffer.append(this.ref_MediaBrowser);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.ref_MediaBrowser);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.ref_MediaBrowser = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 39;
    }

    @Override
    public int getFunctionId() {
        return MediaFileInfo_StartResult.functionId();
    }
}

