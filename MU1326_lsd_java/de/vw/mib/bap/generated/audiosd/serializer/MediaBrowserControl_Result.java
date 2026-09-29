/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowserControl_Result
implements ResultMethod {
    public int browserControlResult;
    private static final int BROWSER_CONTROL_RESULT_BITSIZE;
    public static final int BROWSER_CONTROL_RESULT_SUCCESSFUL;
    public static final int BROWSER_CONTROL_RESULT_NOT_SUCCESFUL_NOT_SUPPORTED;
    public static final int BROWSER_CONTROL_RESULT_ABORT_SUCCESSFUL;
    public static final int BROWSER_CONTROL_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.browserControlResult;
    }

    public MediaBrowserControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowserControl_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.browserControlResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)bAPEntity;
        return this.browserControlResult == mediaBrowserControl_Result.browserControlResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaBrowserControl_Result:");
        stringBuffer.append("\n - BrowserControlResult: ");
        switch (this.browserControlResult) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not succesful / not supported)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
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
        bitStream.pushByte((byte)this.browserControlResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.browserControlResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 38;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowserControl_Result.functionId();
    }
}

