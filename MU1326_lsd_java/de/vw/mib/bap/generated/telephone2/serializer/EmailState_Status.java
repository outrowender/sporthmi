/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class EmailState_Status
implements StatusProperty {
    public int storageState;
    private static final int STORAGE_STATE_BITSIZE;
    public static final int STORAGE_STATE_EMAIL_STORAGE_AVAILABLE;
    public static final int STORAGE_STATE_EMAIL_STORAGE_FULL;
    public static final int STORAGE_STATE_EMAIL_STORAGE_FULL_EMAIL_PENDING_1;
    public static final int STORAGE_STATE_EMAIL_STORAGE_FULL_EMAIL_PENDING_2;
    public int numberOfNewEmail;
    private static final int NUMBER_OF_NEW_EMAIL_BITSIZE;

    public EmailState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public EmailState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.storageState = 0;
        this.numberOfNewEmail = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        EmailState_Status emailState_Status = (EmailState_Status)bAPEntity;
        return this.storageState == emailState_Status.storageState && this.numberOfNewEmail == emailState_Status.numberOfNewEmail;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EmailState_Status:");
        stringBuffer.append("\n - StorageState: ");
        switch (this.storageState) {
            case 0: {
                stringBuffer.append("0x00 (Email storage available)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Email storage full)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Email storage full, Email pending_1)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Email storage full, Email pending_2)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - NumberOfNewEmail - ");
        stringBuffer.append(this.numberOfNewEmail);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.storageState);
        bitStream.pushShort((short)this.numberOfNewEmail);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.storageState = bitStream.popFrontByte();
        this.numberOfNewEmail = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return EmailState_Status.functionId();
    }
}

