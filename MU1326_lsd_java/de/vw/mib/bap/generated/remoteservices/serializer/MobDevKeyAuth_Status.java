/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeyAuth_Status
implements StatusProperty {
    public final BAPString data = new BAPString(46);
    private static final int MAX_DATA_LENGTH;
    public int status;
    public static final int STATUS_NOT_SUCCESSFUL_VEHICLE_KEY_IN_USE;
    public static final int STATUS_NOT_SUCCESSFUL_NO_IMMOBILIZER_CHALLENGE;
    public static final int STATUS_NOT_SUCCESSFUL_COMMAND_INVALID;
    public static final int STATUS_NOT_SUCCESSFUL_EXECUTION_OF_COMMAND_TIMED_OUT;
    public static final int STATUS_NOT_SUCCESSFUL_WAITING_FOR_COMMAND_TIMED_OUT;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED_VEHICLE_UNLOCKED;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED_VEHICLE_IN_MOTION;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED_CLAMP_15_ACTIVE;
    public static final int STATUS_NOT_SUCCESSFUL_FUNCTIONAL_PRECONDITIONS_VIOLATED;
    public static final int STATUS_SUCCESSFUL_EXECUTION_OF_COMMAND_COMPLETED_RESULT_DATA_AVAILABLE;
    public static final int STATUS_SUCCESSFUL_AUTHENTICATION_DATA_AVAILABLE;
    public static final int STATUS_ABORT_NOT_SUCCESSFUL;
    public static final int STATUS_ABORT_SUCCESSFUL;
    public static final int STATUS_NOT_SUCCESSFUL;
    public static final int STATUS_SUCCESSFUL;
    public static final int STATUS_INIT_UNKNOWN;

    public MobDevKeyAuth_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeyAuth_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.status = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeyAuth_Status mobDevKeyAuth_Status = (MobDevKeyAuth_Status)bAPEntity;
        return this.data.equalTo(mobDevKeyAuth_Status.data) && this.status == mobDevKeyAuth_Status.status;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeyAuth_Status");
        stringBuffer.append("\n - data:").append(this.data.toString());
        stringBuffer.append("\n - status:").append(this.status);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.data.serialize(bitStream);
        bitStream.pushByte((byte)this.status);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.data.deserialize(bitStream);
        this.status = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return MobDevKeyAuth_Status.functionId();
    }
}

