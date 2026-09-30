/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_ModificationState;
import de.vw.mib.bap.generated.eni.serializer.PrivacySetup_Setup;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_Status
implements StatusProperty {
    public PrivacySetup_Setup setup = new PrivacySetup_Setup();
    public int modificationReason;
    public static final int MODIFICATION_REASON_NO_CONTRACT = 6;
    public static final int MODIFICATION_REASON_SYSTEM_OFF = 5;
    public static final int MODIFICATION_REASON_DEFECTIVE = 4;
    public static final int MODIFICATION_REASON_CLAMP_15_NOT_ACTIVE = 2;
    public static final int MODIFICATION_REASON_NO_REASON = 0;
    private static final int MODIFICATION_REASON_BITSIZE = 4;
    public PrivacySetup_ModificationState modificationState = new PrivacySetup_ModificationState();

    public PrivacySetup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PrivacySetup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.modificationReason = 0;
    }

    public void reset() {
        this.internalReset();
        this.setup.reset();
        this.modificationState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_Status privacySetup_Status = (PrivacySetup_Status)bAPEntity;
        return this.setup.equalTo(privacySetup_Status.setup) && this.modificationReason == privacySetup_Status.modificationReason && this.modificationState.equalTo(privacySetup_Status.modificationState);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrivacySetup_Status");
        stringBuffer.append("\n - setup:" + this.setup.toString());
        stringBuffer.append("\n - modificationReason:" + this.modificationReason);
        stringBuffer.append("\n - modificationState:" + this.modificationState.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.setup.serialize(bitStream);
        bitStream.pushBits(4, this.modificationReason);
        this.modificationState.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.setup.deserialize(bitStream);
        this.modificationReason = bitStream.popFrontBits(4);
        this.modificationState.deserialize(bitStream);
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return PrivacySetup_Status.functionId();
    }
}

