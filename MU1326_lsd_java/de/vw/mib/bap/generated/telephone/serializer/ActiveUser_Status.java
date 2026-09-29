/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveUser_Status
implements StatusProperty {
    public final BAPString userName = new BAPString(50);
    private static final int MAX_USER_NAME_LENGTH;

    public ActiveUser_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveUser_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.userName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveUser_Status activeUser_Status = (ActiveUser_Status)bAPEntity;
        return this.userName.equalTo(activeUser_Status.userName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveUser_Status:");
        stringBuffer.append("\n - UserName - ");
        stringBuffer.append(this.userName.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += this.userName.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.userName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.userName.deserialize(bitStream);
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return ActiveUser_Status.functionId();
    }
}

