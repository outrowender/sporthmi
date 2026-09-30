/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class ChallengeData_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_CHALLENGE_TYPE_CHALLENGE = 1;
    public static final int RECORD_ADDRESS_POS = 15;
    public static final int POS_MIN = 0;
    public int pos;
    public static final int CHALLENGE_TYPE_SESSION_CHALLENGE = 0;
    public static final int CHALLENGE_TYPE_USER_CHALLENGE = 1;
    public int challengeType;
    private static final int MAX_CHALLENGE_LENGTH = 129;
    public final BAPString challenge;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public ChallengeData_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.challenge = new BAPString(129);
        this.internalReset();
        this.customInitialization();
    }

    public ChallengeData_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.challengeType = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.challenge.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ChallengeData_Data challengeData_Data = (ChallengeData_Data)bAPEntity;
        return this.arrayHeader.equalTo(challengeData_Data.arrayHeader) && this.pos == challengeData_Data.pos && this.challengeType == challengeData_Data.challengeType && this.challenge.equalTo(challengeData_Data.challenge);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChallengeData_Data");
        stringBuffer.append("\n - pos:" + this.pos);
        stringBuffer.append("\n - challengeType:" + this.challengeType);
        stringBuffer.append("\n - challenge:" + this.challenge.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.challengeType);
                this.challenge.serialize(bitStream);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.challengeType = bitStream.popFrontByte();
                this.challenge.deserialize(bitStream);
                break;
            }
        }
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }
}

