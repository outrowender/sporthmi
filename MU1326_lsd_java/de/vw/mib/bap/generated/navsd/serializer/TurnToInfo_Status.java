/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TurnToInfo_Status
implements StatusProperty {
    public final BAPString turnToInfo = new BAPString(76);
    private static final int MAX_TURN_TO_INFO_LENGTH = 76;
    public final BAPString signPost = new BAPString(31);
    private static final int MAX_SIGN_POST_LENGTH = 31;

    public TurnToInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TurnToInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.turnToInfo.reset();
        this.signPost.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TurnToInfo_Status turnToInfo_Status = (TurnToInfo_Status)bAPEntity;
        return this.turnToInfo.equalTo(turnToInfo_Status.turnToInfo) && this.signPost.equalTo(turnToInfo_Status.signPost);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TurnToInfo_Status:");
        stringBuffer.append("\n - TurnToInfo - ");
        stringBuffer.append(this.turnToInfo.toString());
        stringBuffer.append("\n - SignPost - ");
        stringBuffer.append(this.signPost.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.turnToInfo.bitSize();
        return n += this.signPost.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.turnToInfo.serialize(bitStream);
        this.signPost.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.turnToInfo.deserialize(bitStream);
        this.signPost.deserialize(bitStream);
    }

    public static int functionId() {
        return 20;
    }

    public int getFunctionId() {
        return TurnToInfo_Status.functionId();
    }
}

