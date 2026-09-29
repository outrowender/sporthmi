/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.TMCinfo_Status$TMCinfo;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_Status
implements StatusProperty {
    public int messageId;
    private static final int MESSAGE_ID_BITSIZE;
    public int messageStatus;
    private static final int MESSAGE_STATUS_BITSIZE;
    public static final int MESSAGE_STATUS_NO_MESSAGE;
    public static final int MESSAGE_STATUS_PRESENTATION_REQUEST_FOR_NEW_MESSAGE;
    public static final int MESSAGE_STATUS_MESSAGE_PRESENTATION_CONFIRMED_TO_BE_SET_BY_ASG;
    public int messageWaitingIndication;
    private static final int MESSAGE_WAITING_INDICATION_BITSIZE;
    public static final int MESSAGE_WAITING_INDICATION_NO_MESSAGES_WAITING;
    public static final int MESSAGE_WAITING_INDICATION_1_MESSAGE_WAITING;
    public static final int MESSAGE_WAITING_INDICATION_SEVERAL_MESSAGES_ARE_WAITING;
    public final TMCinfo_Status$TMCinfo tmcinfo = new TMCinfo_Status$TMCinfo();

    public TMCinfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.messageId = 0;
        this.messageStatus = 0;
        this.messageWaitingIndication = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.tmcinfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_Status tMCinfo_Status = (TMCinfo_Status)bAPEntity;
        return this.messageId == tMCinfo_Status.messageId && this.messageStatus == tMCinfo_Status.messageStatus && this.messageWaitingIndication == tMCinfo_Status.messageWaitingIndication && this.tmcinfo.equalTo(tMCinfo_Status.tmcinfo);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TMCinfo_Status:");
        stringBuffer.append("\n - MessageID - ");
        stringBuffer.append(this.messageId);
        stringBuffer.append("\n - MessageStatus: ");
        switch (this.messageStatus) {
            case 0: {
                stringBuffer.append("0x0 (no message)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (presentation request for new message)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (message presentation confirmed (to be set by ASG))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MessageWaitingIndication: ");
        switch (this.messageWaitingIndication) {
            case 0: {
                stringBuffer.append("0x00 (no messages waiting)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (1 message waiting)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (several messages are waiting)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TMCinfo - ");
        stringBuffer.append(this.tmcinfo.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        return n += this.tmcinfo.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.messageId);
        bitStream.pushBits(4, this.messageStatus);
        bitStream.pushByte((byte)this.messageWaitingIndication);
        this.tmcinfo.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.messageId = bitStream.popFrontBits(4);
        this.messageStatus = bitStream.popFrontBits(4);
        this.messageWaitingIndication = bitStream.popFrontByte();
        this.tmcinfo.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return TMCinfo_Status.functionId();
    }
}

