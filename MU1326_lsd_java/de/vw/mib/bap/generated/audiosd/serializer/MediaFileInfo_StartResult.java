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
    private static final int REF_MEDIA_BROWSER_BITSIZE = 16;

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

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MediaFileInfo_StartResult mediaFileInfo_StartResult = (MediaFileInfo_StartResult)bAPEntity;
        return this.ref_MediaBrowser == mediaFileInfo_StartResult.ref_MediaBrowser;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaFileInfo_StartResult:");
        stringBuffer.append("\n - Ref_MediaBrowser - ");
        stringBuffer.append(this.ref_MediaBrowser);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.ref_MediaBrowser);
    }

    public void deserialize(BitStream bitStream) {
        this.ref_MediaBrowser = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 39;
    }

    public int getFunctionId() {
        return MediaFileInfo_StartResult.functionId();
    }
}

