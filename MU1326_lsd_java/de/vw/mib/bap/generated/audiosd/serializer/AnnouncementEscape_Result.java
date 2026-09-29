/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class AnnouncementEscape_Result
implements ResultMethod {
    public int announcementEscapeResult;
    private static final int ANNOUNCEMENT_ESCAPE_RESULT_BITSIZE;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_NOT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_ABORT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_ANNOUNCEMENT_NOT_ACTIVE;

    @Override
    public int getResultCode() {
        return this.announcementEscapeResult;
    }

    public AnnouncementEscape_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public AnnouncementEscape_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.announcementEscapeResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AnnouncementEscape_Result announcementEscape_Result = (AnnouncementEscape_Result)bAPEntity;
        return this.announcementEscapeResult == announcementEscape_Result.announcementEscapeResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AnnouncementEscape_Result:");
        stringBuffer.append("\n - AnnouncementEscapeResult: ");
        switch (this.announcementEscapeResult) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful)");
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
            case 4: {
                stringBuffer.append("0x04 (announcement not active)");
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
        bitStream.pushByte((byte)this.announcementEscapeResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.announcementEscapeResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 29;
    }

    @Override
    public int getFunctionId() {
        return AnnouncementEscape_Result.functionId();
    }
}

