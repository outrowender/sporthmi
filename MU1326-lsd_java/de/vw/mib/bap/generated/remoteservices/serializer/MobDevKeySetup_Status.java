/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_ModificationState_Reset;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_ModificationState_Setup;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_ModificationState_Smartcard;
import de.vw.mib.bap.generated.remoteservices.serializer.MobDevKeySetup_Setup;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeySetup_Status
implements StatusProperty {
    public MobDevKeySetup_Setup setup = new MobDevKeySetup_Setup();
    public int modificationReason_Setup;
    public static final int MODIFICATION_REASON_SETUP_DEFECTIVE;
    public static final int MODIFICATION_REASON_SETUP_AUTHENTICATION_WITH_PHYSICAL_OR_MOBILE_DEVICE_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_SETUP_AUTHENTICATION_WITH_SMARTCARD_REQUIRED;
    public static final int MODIFICATION_REASON_SETUP_AUTHENTICATION_WITH_MOBILE_DEVICE_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_SETUP_AUTHENTICATION_WITH_PHYSICAL_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_SETUP_CLAMP_15_ESTABLISHED_WITH_SMARTCARD;
    public static final int MODIFICATION_REASON_SETUP_CLAMP_15_ESTABLISHED_WITH_MOBILE_DEVICE_KEY;
    public static final int MODIFICATION_REASON_SETUP_CLAMP_15_ESTABLISHED_WITH_PHYSICAL_KEY;
    public static final int MODIFICATION_REASON_SETUP_CLAMP_15_NOT_ACTIVE;
    public static final int MODIFICATION_REASON_SETUP_NO_REASON;
    private static final int MODIFICATION_REASON_SETUP_BITSIZE;
    public MobDevKeySetup_ModificationState_Setup modificationState_Setup = new MobDevKeySetup_ModificationState_Setup();
    public int modificationReason_Smartcard;
    public static final int MODIFICATION_REASON_SMARTCARD_DEFECTIVE;
    public static final int MODIFICATION_REASON_SMARTCARD_AUTHENTICATION_WITH_PHYSICAL_OR_MOBILE_DEVICE_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_SMARTCARD_AUTHENTICATION_WITH_SMARTCARD_REQUIRED;
    public static final int MODIFICATION_REASON_SMARTCARD_AUTHENTICATION_WITH_MOBILE_DEVICE_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_SMARTCARD_AUTHENTICATION_WITH_PHYSICAL_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_SMARTCARD_CLAMP_15_ESTABLISHED_WITH_SMARTCARD;
    public static final int MODIFICATION_REASON_SMARTCARD_CLAMP_15_ESTABLISHED_WITH_MOBILE_DEVICE_KEY;
    public static final int MODIFICATION_REASON_SMARTCARD_CLAMP_15_ESTABLISHED_WITH_PHYSICAL_KEY;
    public static final int MODIFICATION_REASON_SMARTCARD_CLAMP_15_NOT_ACTIVE;
    public static final int MODIFICATION_REASON_SMARTCARD_NO_REASON;
    private static final int MODIFICATION_REASON_SMARTCARD_BITSIZE;
    public MobDevKeySetup_ModificationState_Smartcard modificationState_Smartcard = new MobDevKeySetup_ModificationState_Smartcard();
    public int modificationReason_Reset;
    public static final int MODIFICATION_REASON_RESET_DEFECTIVE;
    public static final int MODIFICATION_REASON_RESET_AUTHENTICATION_WITH_PHYSICAL_OR_MOBILE_DEVICE_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_RESET_AUTHENTICATION_WITH_SMARTCARD_REQUIRED;
    public static final int MODIFICATION_REASON_RESET_AUTHENTICATION_WITH_MOBILE_DEVICE_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_RESET_AUTHENTICATION_WITH_PHYSICAL_KEY_REQUIRED;
    public static final int MODIFICATION_REASON_RESET_CLAMP_15_ESTABLISHED_WITH_SMARTCARD;
    public static final int MODIFICATION_REASON_RESET_CLAMP_15_ESTABLISHED_WITH_MOBILE_DEVICE_KEY;
    public static final int MODIFICATION_REASON_RESET_CLAMP_15_ESTABLISHED_WITH_PHYSICAL_KEY;
    public static final int MODIFICATION_REASON_RESET_CLAMP_15_NOT_ACTIVE;
    public static final int MODIFICATION_REASON_RESET_NO_REASON;
    private static final int MODIFICATION_REASON_RESET_BITSIZE;
    public MobDevKeySetup_ModificationState_Reset modificationState_Reset = new MobDevKeySetup_ModificationState_Reset();
    public int extension1;
    public static final int EXTENSION1_MIN;
    public int extension2;
    public static final int EXTENSION2_MIN;

    public MobDevKeySetup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeySetup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.modificationReason_Setup = 0;
        this.modificationReason_Smartcard = 0;
        this.modificationReason_Reset = 0;
        this.extension1 = 0;
        this.extension2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.setup.reset();
        this.modificationState_Setup.reset();
        this.modificationState_Smartcard.reset();
        this.modificationState_Reset.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeySetup_Status mobDevKeySetup_Status = (MobDevKeySetup_Status)bAPEntity;
        return this.setup.equalTo(mobDevKeySetup_Status.setup) && this.modificationReason_Setup == mobDevKeySetup_Status.modificationReason_Setup && this.modificationState_Setup.equalTo(mobDevKeySetup_Status.modificationState_Setup) && this.modificationReason_Smartcard == mobDevKeySetup_Status.modificationReason_Smartcard && this.modificationState_Smartcard.equalTo(mobDevKeySetup_Status.modificationState_Smartcard) && this.modificationReason_Reset == mobDevKeySetup_Status.modificationReason_Reset && this.modificationState_Reset.equalTo(mobDevKeySetup_Status.modificationState_Reset) && this.extension1 == mobDevKeySetup_Status.extension1 && this.extension2 == mobDevKeySetup_Status.extension2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeySetup_Status");
        stringBuffer.append("\n - setup:").append(this.setup.toString());
        stringBuffer.append("\n - modificationReason_Setup:").append(this.modificationReason_Setup);
        stringBuffer.append("\n - modificationState_Setup:").append(this.modificationState_Setup.toString());
        stringBuffer.append("\n - modificationReason_Smartcard:").append(this.modificationReason_Smartcard);
        stringBuffer.append("\n - modificationState_Smartcard:").append(this.modificationState_Smartcard.toString());
        stringBuffer.append("\n - modificationReason_Reset:").append(this.modificationReason_Reset);
        stringBuffer.append("\n - modificationState_Reset:").append(this.modificationState_Reset.toString());
        stringBuffer.append("\n - extension1:").append(this.extension1);
        stringBuffer.append("\n - extension2:").append(this.extension2);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.setup.serialize(bitStream);
        bitStream.pushBits(4, this.modificationReason_Setup);
        this.modificationState_Setup.serialize(bitStream);
        bitStream.pushBits(4, this.modificationReason_Smartcard);
        this.modificationState_Smartcard.serialize(bitStream);
        bitStream.pushBits(4, this.modificationReason_Reset);
        this.modificationState_Reset.serialize(bitStream);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.setup.deserialize(bitStream);
        this.modificationReason_Setup = bitStream.popFrontBits(4);
        this.modificationState_Setup.deserialize(bitStream);
        this.modificationReason_Smartcard = bitStream.popFrontBits(4);
        this.modificationState_Smartcard.deserialize(bitStream);
        this.modificationReason_Reset = bitStream.popFrontBits(4);
        this.modificationState_Reset.deserialize(bitStream);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return MobDevKeySetup_Status.functionId();
    }
}

